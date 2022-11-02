package com.nstudio.kanjipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton bt_play;
    private ImageButton bt_settings;
    private ImageButton bt_help;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bt_play = (ImageButton) findViewById(R.id.bt_play);
        this.bt_settings = (ImageButton) findViewById(R.id.bt_settings);
        this.bt_help = (ImageButton) findViewById(R.id.bt_help);

        this.bt_settings.setVisibility(View.INVISIBLE);
        this.bt_help.setVisibility(View.INVISIBLE);
    }

    public void launchLevelActivity(View v){
        String wantedKeyboard = "com.google.android.apps.handwriting";
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        List<InputMethodInfo> imi_list = imm.getEnabledInputMethodList();
        boolean isActive = false;
        for(InputMethodInfo imi : imi_list){
            if(imi.getId().contains(wantedKeyboard))
                isActive = true;
        }
        Intent i = null;
        if(!isActive)
            i = new Intent(this, KeyboardSelect.class);
        else
            i = new Intent(this, LevelActivity.class);
        startActivity(i);
    }
}