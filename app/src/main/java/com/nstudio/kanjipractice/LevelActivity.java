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

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        this.bt_levelN5 = (Button) findViewById(R.id.bt_levelN5);
        this.bt_levelN4 = (Button) findViewById(R.id.bt_levelN4);
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
            default:
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
                break;
        }
        Intent i = new Intent(this, LevelVisualizerActivity.class);
        i.putExtra("level", level);
        startActivity(i);
    }

}