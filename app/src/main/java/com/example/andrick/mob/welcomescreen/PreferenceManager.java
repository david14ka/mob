/*
 * Copyright (c) 2017. Irod, inc
 */

package com.example.andrick.mob.welcomescreen;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by David Kazad on 22/06/2017.
 *
 *  Description of PreferenceManager
 *  ce fichier permettra de garder dans les preferences les donnees du premier lancement de l'application
 *  afin de ne pas relancer le welcome une seconde fois.
 */
public class PreferenceManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "intro_slider-welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}