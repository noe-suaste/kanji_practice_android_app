package com.nstudio.kanjipractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

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


import com.nstudio.kanjipractice.database.Kanji;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LevelVisualizerActivity extends AppCompatActivity {

    private Level level;
    private List<Kanji> kanjis;
    private CtrlKanji ctrlKanji;
    private GridView gv_kanjisGrid;
    private GridAdapter gridAdapter;
    private Context self = this;
    private List<Integer> selected_kanjis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_visualizer);


        Intent intent = getIntent();
        this.level = (Level) intent.getSerializableExtra("level");
        this.setTitle(level + " Kanji");
        this.ctrlKanji = new CtrlKanji(this, level);
        this.kanjis = this.ctrlKanji.getKanjis();
        this.selected_kanjis = new ArrayList<Integer>();
        this.gv_kanjisGrid = (GridView) findViewById(R.id.gv_kanjisGrid);
        gridAdapter = new GridAdapter(LevelVisualizerActivity.this, kanjis, selected_kanjis, level);
        gv_kanjisGrid.setAdapter(gridAdapter);

        gv_kanjisGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // If it is in selection mode (there is at least one kanji selected)
                if(!selected_kanjis.isEmpty()){
                    if(selected_kanjis.contains(position + 1))
                        selected_kanjis.remove(Integer.valueOf(position + 1));
                    else
                        selected_kanjis.add(position + 1);
                    ((GridAdapter) gv_kanjisGrid.getAdapter()).notifyDataSetChanged();
                }else{
                    Intent intent = new Intent(self, KanjiInfoActivity.class);
                    intent.putExtra("kanji", kanjis.get(position));
                    startActivity(intent);
                }

            }
        });

        gv_kanjisGrid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(selected_kanjis.isEmpty()){
                    selected_kanjis.add(position + 1);
                    ((GridAdapter) gv_kanjisGrid.getAdapter()).notifyDataSetChanged();
                }
                /*Intent intent = new Intent(self, KanjiInfoActivity.class);
                intent.putExtra("kanji", kanjis.get(position));
                startActivity(intent);*/
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.level_visualizer_menu, menu);
        if(this.level == Level.LEARNED){
            MenuItem item = menu.findItem(R.id.action_setAsLearned);
            item.setVisible(false);
            item = menu.findItem(R.id.action_selectLearned);
            item.setVisible(false);
            item = menu.findItem(R.id.action_selectNotLearned);
            item.setVisible(false);

        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.action_play:
                if(!selected_kanjis.isEmpty()){
                    Intent intent = new Intent(this, PlayActivity.class);
                    Bundle extras = new Bundle();
                    extras.putSerializable("level", this.level);
                    extras.putIntegerArrayList("selected_kanjis", (ArrayList<Integer>) selected_kanjis);
                    intent.putExtras(extras);
                    startActivity(intent);
                }else{
                    Toast.makeText(self, "Please select at least one kanji to study", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.action_setAsLearned:
                if(!selected_kanjis.isEmpty()){
                    for(Integer i : selected_kanjis){
                        this.ctrlKanji.setLearned(1, i);
                    }
                    this.kanjis = this.ctrlKanji.getKanjis();
                }else{
                    Toast.makeText(self, "Please select at least one kanji to mark as learned", Toast.LENGTH_SHORT).show();
                }
                ((GridAdapter) gv_kanjisGrid.getAdapter()).refresh(this.kanjis);
                break;
            case R.id.action_selectAll:
                selected_kanjis.clear();
                for(int i = 1; i <= kanjis.size(); i++)
                    selected_kanjis.add(i);
                ((GridAdapter) gv_kanjisGrid.getAdapter()).notifyDataSetChanged();
                break;
            case R.id.action_unselectAll:
                selected_kanjis.clear();
                ((GridAdapter) gv_kanjisGrid.getAdapter()).notifyDataSetChanged();
                break;
            case R.id.action_selectLearned:
                selected_kanjis.clear();
                for(Kanji k : this.kanjis){
                    if(k.getLearned() == 1)
                        selected_kanjis.add(k.getId());
                }
                ((GridAdapter) gv_kanjisGrid.getAdapter()).notifyDataSetChanged();
                break;
            case R.id.action_selectNotLearned:
                selected_kanjis.clear();
                for(Kanji k : this.kanjis){
                    if(k.getLearned() == 0)
                        selected_kanjis.add(k.getId());
                }
                ((GridAdapter) gv_kanjisGrid.getAdapter()).notifyDataSetChanged();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRestart(){
        super.onRestart();
        this.kanjis = this.ctrlKanji.getKanjis();
        ((GridAdapter) gv_kanjisGrid.getAdapter()).refresh(this.kanjis);
    }
}