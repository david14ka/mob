/*
 * Copyright (c) 2017. Irod, inc  *
 */

package com.example.andrick.mob.welcomescreen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.andrick.mob.Menu;
import com.example.andrick.mob.R;

/**
 * Created by David Kazad on 22/06/2017.
 *
 *  splash permet de lancer l'activite premiere
 */

public class SplashScreenActivity extends AppCompatActivity {
    private static final String TAG="SplashScreenActivity";

    private static final int TIME_DISPLAY=2000;
    PreferenceManager prefManager;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        } else {
            //requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        setContentView(R.layout.splash);
        prefManager=new PreferenceManager(this);

        changeStatusBarColor();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                launchHomeScreen();
            }
        },3000);

    }

    private void launchHomeScreen(){
        Log.d(TAG,"launchHomeScreen");
        if (!prefManager.isFirstTimeLaunch()){
            startActivity(new Intent(SplashScreenActivity.this, Menu.class));
            finish();
        }else {
            startActivity(new Intent(SplashScreenActivity.this, WelcomeActivity.class));
            finish();
        }
    }

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
        getApplication().onTerminate();

    }
}
