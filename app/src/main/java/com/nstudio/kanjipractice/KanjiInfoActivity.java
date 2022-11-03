package com.nstudio.kanjipractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.nstudio.kanjipractice.database.Kanji;

public class KanjiInfoActivity extends AppCompatActivity {

    Kanji kanji;
    private Level level;
    private CtrlKanji ctrlKanji;
    private TextView tv_meaning;
    private TextView tv_onyomi;
    private TextView tv_onyomiKatakana;
    private TextView tv_kunyomi;
    private TextView tv_kunyomiHiragana;
    private TextView tv_kanjiJapanese;
    private TextView tv_status;
    private Button bt_markAsLearned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanji_info);

        Intent intent = getIntent();
        kanji = (Kanji) intent.getSerializableExtra("kanji");
        switch (kanji.getLevel()){
            case 5:
                this.level = Level.N5;
                break;
            case 4:
                this.level = Level.N4;
                break;
            case 3:
                this.level = Level.N3;
                break;
            default:
                this.level = null;
        }
        this.ctrlKanji = new CtrlKanji(this, this.level);
        this.tv_meaning = (TextView) findViewById(R.id.tv_meaning);
        this.tv_onyomi = (TextView) findViewById(R.id.tv_onyomi);
        this.tv_onyomiKatakana = (TextView) findViewById(R.id.tv_onyomiKatakana);
        this.tv_kunyomi = (TextView) findViewById(R.id.tv_kunyomi);
        this.tv_kunyomiHiragana = (TextView) findViewById(R.id.tv_kunyomiHiragana);
        this.tv_kanjiJapanese = (TextView) findViewById(R.id.tv_kanjiJapanese);
        this.tv_status = (TextView) findViewById(R.id.tv_status);
        this.bt_markAsLearned = (Button) findViewById(R.id.bt_markAsLearned);

        this.setTitle(level + " Kanji (" + kanji.getId() + ")");
        this.tv_meaning.setText(kanji.getMeaning());
        this.tv_onyomi.setText(kanji.getOnyomi());
        this.tv_onyomiKatakana.setText(kanji.getOnyomi_katakana());
        this.tv_kunyomi.setText(kanji.getKunyomi());
        this.tv_kunyomiHiragana.setText(kanji.getKunyomi_hiragana());
        this.tv_kanjiJapanese.setText(kanji.getKanji());
        this.updateView();
    }

    public void markAsLearned(View v){
        if(kanji.getLearned() == 0){
            this.ctrlKanji.setLearned(1, kanji.getId());
            kanji.setLearned(1);
        }
        else{
            this.ctrlKanji.setLearned(0, kanji.getId());
            kanji.setLearned(0);
        }
        this.updateView();
    }

    public void updateView(){
        if(kanji.getLearned() == 1){
            this.tv_status.setTextColor(ContextCompat.getColor(this, R.color.green));
            this.tv_status.setText("Learned");
            this.bt_markAsLearned.setText("Mark as not learned");
        }
        else{
            this.tv_status.setTextColor(ContextCompat.getColor(this, R.color.red));
            this.tv_status.setText("Not Learned");
            this.bt_markAsLearned.setText("Mark as learned");
        }
    }
}