package com.nstudio.kanjipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton bt_play;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bt_play = (ImageButton) findViewById(R.id.bt_play);
    }

    public void launchLevelActivity(View v){
        Intent i = new Intent(this, LevelActivity.class);
        startActivity(i);
    }
}