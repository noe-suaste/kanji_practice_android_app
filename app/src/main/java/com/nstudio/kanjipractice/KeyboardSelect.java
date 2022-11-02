package com.nstudio.kanjipractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import java.util.List;

public class KeyboardSelect extends AppCompatActivity {

    Button bt_installKeyboard;
    Button bt_activateKeyboard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_select);

        this.bt_installKeyboard = (Button) findViewById(R.id.bt_installKeyboard);
        this.bt_activateKeyboard = (Button) findViewById(R.id.bt_activateKeyboard);
    }

    public void check(){

        // For Activate Keyboard button
        String wantedKeyboard = "com.google.android.apps.handwriting";
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        List<InputMethodInfo> imi_list = imm.getEnabledInputMethodList();
        boolean isActive = false;
        for(InputMethodInfo imi : imi_list){
            if(imi.getId().contains(wantedKeyboard))
                isActive = true;
        }
        if(isActive){
            Drawable buttonDrawable = bt_activateKeyboard.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, Color.GREEN);
            bt_activateKeyboard.setBackground(buttonDrawable);
            bt_activateKeyboard.setEnabled(false);
            finish();
        }else{
            Drawable buttonDrawable = bt_activateKeyboard.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, Color.DKGRAY);
            bt_activateKeyboard.setBackground(buttonDrawable);
            bt_activateKeyboard.setEnabled(true);
        }

        // For install keyboard button
        PackageManager pm = this.getPackageManager();
        String appId = "com.google.android.apps.handwriting.ime";
        try{
            pm.getPackageInfo(appId, 0);
            Drawable buttonDrawable = bt_installKeyboard.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, Color.GREEN);
            bt_installKeyboard.setBackground(buttonDrawable);
            bt_installKeyboard.setEnabled(false);
        }catch(PackageManager.NameNotFoundException e){
            Drawable buttonDrawable = bt_installKeyboard.getBackground();
            buttonDrawable = DrawableCompat.wrap(buttonDrawable);
            //the color is a direct color int and not a color resource
            DrawableCompat.setTint(buttonDrawable, Color.DKGRAY);
            bt_installKeyboard.setBackground(buttonDrawable);
            bt_installKeyboard.setEnabled(true);
        }
    }

    public void installKeyboard(View v){
        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.handwriting.ime");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void activateKeyboard(View v){
        startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS));
    }

    public void selectKeyboard(View v){
        InputMethodManager imeManager = (InputMethodManager) getApplicationContext().getSystemService(INPUT_METHOD_SERVICE);
        imeManager.showInputMethodPicker();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        if(hasFocus)
            check();
    }
}