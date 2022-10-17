package com.nstudio.kanjipractice;

import androidx.appcompat.app.AppCompatActivity;

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
    private TextView tv_meaning;
    private TextView tv_onyomi;
    private TextView tv_onyomiKatakana;
    private TextView tv_kunyomi;
    private TextView tv_kunyomiHiragana;
    private TextView tv_kanjiJapanese;
    private Button bt_markAsLearned;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanji_info);

        Intent intent = getIntent();
        kanji = (Kanji) intent.getSerializableExtra("kanji");
        this.tv_meaning = (TextView) findViewById(R.id.tv_meaning);
        this.tv_onyomi = (TextView) findViewById(R.id.tv_onyomi);
        this.tv_onyomiKatakana = (TextView) findViewById(R.id.tv_onyomiKatakana);
        this.tv_kunyomi = (TextView) findViewById(R.id.tv_kunyomi);
        this.tv_kunyomiHiragana = (TextView) findViewById(R.id.tv_kunyomiHiragana);
        this.tv_kanjiJapanese = (TextView) findViewById(R.id.tv_kanjiJapanese);
        this.bt_markAsLearned = (Button) findViewById(R.id.bt_markAsLearned);

        this.tv_meaning.setText(kanji.getMeaning());
        this.tv_onyomi.setText(kanji.getOnyomi());
        this.tv_onyomiKatakana.setText(kanji.getOnyomi_katakana());
        this.tv_kunyomi.setText(kanji.getKunyomi());
        this.tv_kunyomiHiragana.setText(kanji.getKunyomi_hiragana());
        this.tv_kanjiJapanese.setText(kanji.getKanji());
    }

    public void markAsLearned(View v){
        this.kanji.setLearned(1);
    }
}