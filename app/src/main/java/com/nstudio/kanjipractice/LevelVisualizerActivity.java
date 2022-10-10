package com.nstudio.kanjipractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;

public class LevelVisualizerActivity extends AppCompatActivity {

    private Level level;
    private ArrayList<Kanji> kanjis;
    private CtrlKanji ctrlKanji;
    private GridView gv_kanjisGrid;
    private GridAdapter gridAdapter;
    private Context self = this;
    private boolean[] selected_kanjis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_visualizer);

        Intent intent = getIntent();

        this.level = (Level) intent.getSerializableExtra("level");
        this.ctrlKanji = new CtrlKanji();

        switch (this.level){
            case N5:
                this.kanjis = ctrlKanji.getN5Kanjis();
                this.setTitle("N5 Kanji");
                break;
            case N4:
                this.kanjis = ctrlKanji.getN4Kanjis();
                this.setTitle("N4 Kanji");
            default:
                break;
        }
        this.gv_kanjisGrid = (GridView) findViewById(R.id.gv_kanjisGrid);
        this.selected_kanjis = new boolean[kanjis.size()];



        for(int i = 0; i < selected_kanjis.length; i++){
            selected_kanjis[i] = false;
        }

        gridAdapter = new GridAdapter(LevelVisualizerActivity.this, kanjis, selected_kanjis);
        gv_kanjisGrid.setAdapter(gridAdapter);

        gv_kanjisGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(selected_kanjis[position])
                    selected_kanjis[position] = false;
                else
                    selected_kanjis[position] = true;

                ((GridAdapter) gv_kanjisGrid.getAdapter()).notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.level_visualizer_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.action_play:
                boolean atLeastOneKanjiSelected = false;
                for(int i = 0; i < selected_kanjis.length; i++){
                    if(selected_kanjis[i])
                        atLeastOneKanjiSelected = true;
                }
                if(atLeastOneKanjiSelected){
                    Intent intent = new Intent(this, PlayActivity.class);
                    Bundle extras = new Bundle();
                    extras.putSerializable("level", this.level);
                    extras.putBooleanArray("selected_kanjis", selected_kanjis);
                    intent.putExtras(extras);
                    startActivity(intent);
                }else{
                    Toast.makeText(self, "Please select at least one kanji to study", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.action_selectAll:
                for(int i = 0; i < selected_kanjis.length; i++)
                    selected_kanjis[i] = true;
                ((GridAdapter) gv_kanjisGrid.getAdapter()).notifyDataSetChanged();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}