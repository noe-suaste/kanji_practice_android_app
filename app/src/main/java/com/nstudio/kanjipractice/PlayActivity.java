package com.nstudio.kanjipractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nstudio.kanjipractice.database.Kanji;

import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends AppCompatActivity {

    private Level level;
    private boolean[] selected_kanjis;
    private List<Kanji> kanjis;
    private CtrlKanji ctrlKanji;
    private TextView tv_meaning;
    private TextView tv_onyomi;
    private TextView tv_onyomiKatakana;
    private TextView tv_kunyomi;
    private TextView tv_kunyomiHiragana;
    private TextView tv_check;
    private EditText et_answer;
    private Button bt_start;
    private ImageButton bt_kanjiInfo;
    private Kanji current_kanji;

    public PlayActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        this.level = (Level) extras.getSerializable("level");
        this.selected_kanjis = extras.getBooleanArray("selected_kanjis");
        this.ctrlKanji = new CtrlKanji(this);
        switch (level){
            case N5:
                this.kanjis = ctrlKanji.getSelectedN5Kanjis(this.selected_kanjis);
                break;
            case N4:
                this.kanjis = ctrlKanji.getSelectedN4Kanjis(this.selected_kanjis);
                break;
            default:
                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();
                break;
        }

        this.tv_meaning = (TextView) findViewById(R.id.tv_meaning);
        this.tv_onyomi = (TextView) findViewById(R.id.tv_onyomi);
        this.tv_onyomiKatakana = (TextView) findViewById(R.id.tv_onyomiKatakana);
        this.tv_kunyomi = (TextView) findViewById(R.id.tv_kunyomi);
        this.tv_kunyomiHiragana = (TextView) findViewById(R.id.tv_kunyomiHiragana);
        this.tv_check = (TextView) findViewById(R.id.tv_check);
        this.et_answer = (EditText) findViewById(R.id.et_answer);
        this.bt_start = (Button) findViewById(R.id.bt_start);
        this.bt_kanjiInfo = (ImageButton) findViewById(R.id.bt_kanjiInfo);

        this.et_answer.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    check(et_answer);
                }
                return false;
            }
        });

        et_answer.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(!et_answer.getText().toString().equals("")){
                    check(et_answer);
                }
            }
        });
    }

    // OnClick method for button bt_start
    public void start(View v){
        this.bt_start.setEnabled(false);
        this.bt_start.setVisibility(View.GONE);
        this.et_answer.setEnabled(true);
        this.bt_kanjiInfo.setVisibility(View.VISIBLE);
        showNewKanji();
    }

    public void check(View v){
        if(this.et_answer.getText().toString().equals(current_kanji.getKanji())){
            //Toast.makeText(this, "✔", Toast.LENGTH_SHORT).show();
            tv_check.setTextColor(ContextCompat.getColor(this, R.color.green));
            tv_check.setText("✔");
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after .5s = 500ms
                    showNewKanji();
                }
            }, 500);
        }else{
            //Toast.makeText(this, "✗", Toast.LENGTH_SHORT).show();
            tv_check.setTextColor(ContextCompat.getColor(this, R.color.red));
            tv_check.setText("✗");
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after .5s = 500ms
                    et_answer.setText("");
                    tv_check.setText("");
                }
            }, 500);
            this.et_answer.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(et_answer, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    public void showNewKanji(){
        int index = (int)(Math.random() * kanjis.size());
        current_kanji = kanjis.get(index);
        this.tv_meaning.setText(current_kanji.getMeaning());
        this.tv_onyomi.setText(current_kanji.getOnyomi());
        this.tv_onyomiKatakana.setText(current_kanji.getOnyomi_katakana());
        this.tv_kunyomi.setText(current_kanji.getKunyomi());
        this.tv_kunyomiHiragana.setText(current_kanji.getKunyomi_hiragana());
        this.tv_check.setText("");
        this.et_answer.setText("");
        this.et_answer.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(et_answer, InputMethodManager.SHOW_IMPLICIT);
    }

    public void launchKanjiInfoActivity(View v){
        Intent intent = new Intent(this, KanjiInfoActivity.class);
        intent.putExtra("kanji", current_kanji);
        startActivity(intent);
    }
}