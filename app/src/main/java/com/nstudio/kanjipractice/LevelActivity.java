package com.nstudio.kanjipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LevelActivity extends AppCompatActivity {

    private Button bt_levelN5;
    private Button bt_levelN4;
    private Button bt_levelN3;
    private Button bt_levelLearned;
    private CtrlKanji ctrlKanji;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        this.bt_levelN5 = (Button) findViewById(R.id.bt_levelN5);
        this.bt_levelN4 = (Button) findViewById(R.id.bt_levelN4);
        this.bt_levelN3 = (Button) findViewById(R.id.bt_levelN3);
        this.bt_levelLearned = (Button) findViewById(R.id.bt_levelLearned);
        this.ctrlKanji = new CtrlKanji(this);

        this.bt_levelN5.setText("N5 Kanji  (" + ctrlKanji.countLearnedByLevel(5).toString() + "/80)");
        this.bt_levelN4.setText("N4 Kanji  (" + ctrlKanji.countLearnedByLevel(4).toString() + "/167)");
        this.bt_levelN3.setText("N3 Kanji  (" + ctrlKanji.countLearnedByLevel(3).toString() + "/370)");
        this.bt_levelLearned.setText("Learned Kanji  (" + ctrlKanji.countLearned().toString() + ")");
    }

    public void launchLevelVisualizerActivity(View v){
        Level level = null;
        switch(v.getId()){
            case R.id.bt_levelN5:
                level = Level.N5;
                break;
            case R.id.bt_levelN4:
                level = Level.N4;
                break;
            case R.id.bt_levelN3:
                level = Level.N3;
                break;
            case R.id.bt_levelLearned:
                level = Level.LEARNED;
                break;
            default:
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
                break;
        }
        Intent i = new Intent(this, LevelVisualizerActivity.class);
        i.putExtra("level", level);
        startActivity(i);
    }

    @Override
    public void onRestart(){
        super.onRestart();
        this.bt_levelN5.setText("N5 Kanji  (" + ctrlKanji.countLearnedByLevel(5).toString() + "/80)");
        this.bt_levelN4.setText("N4 Kanji  (" + ctrlKanji.countLearnedByLevel(4).toString() + "/167)");
        this.bt_levelN3.setText("N3 Kanji  (" + ctrlKanji.countLearnedByLevel(3).toString() + "/370)");
        this.bt_levelLearned.setText("Learned Kanji  (" + ctrlKanji.countLearned().toString() + ")");
    }
}