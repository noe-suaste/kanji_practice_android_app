package com.nstudio.kanjipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class LevelVisualizerActivity extends AppCompatActivity {

    private Level level;
    private ArrayList<Kanji> kanjis;
    private CtrlKanji ctrlKanji;
    private GridView gv_kanjisGrid;
    private GridAdapter gridAdapter;
    private Context self = this;
    private ArrayList<Boolean> selected_kanjis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_visualizer);

        Intent i = getIntent();

        this.level = (Level) i.getSerializableExtra("level");
        this.ctrlKanji = new CtrlKanji();

        switch (this.level){
            case N5:
                this.kanjis = ctrlKanji.getN5Kanjis();
                break;
            default:
                break;
        }
        this.gv_kanjisGrid = (GridView) findViewById(R.id.gv_kanjisGrid);
        this.selected_kanjis = new ArrayList<Boolean>();



        for(Kanji k : kanjis){
            selected_kanjis.add(false);
        }

        gridAdapter = new GridAdapter(LevelVisualizerActivity.this, kanjis, selected_kanjis);
        gv_kanjisGrid.setAdapter(gridAdapter);

        gv_kanjisGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(selected_kanjis.get(position))
                    selected_kanjis.set(position, false);
                else
                    selected_kanjis.set(position, true);

                ((GridAdapter) gv_kanjisGrid.getAdapter()).notifyDataSetChanged();
            }
        });

        gv_kanjisGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(selected_kanjis.get(position))
                    selected_kanjis.set(position, false);
                else
                    selected_kanjis.set(position, true);

                ((GridAdapter) gv_kanjisGrid.getAdapter()).notifyDataSetChanged();
            }
        });
    }
}