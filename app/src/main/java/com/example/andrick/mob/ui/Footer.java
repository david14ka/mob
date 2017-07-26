package com.example.andrick.mob.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andrick.mob.R;

/**
 * Created by Espérance on 22/07/2017.
 */
public class Footer {
    private  Context context;
    private static String PREF_NETWORK="my_network";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public Footer(Context context) {
        this.context = context;
        preferences=context.getSharedPreferences(PREF_NETWORK,Context.MODE_PRIVATE);
        editor= preferences.edit();
    }

    public void click(View view) {
        String ch= (String) view.getContentDescription();
        int n= Integer.parseInt(ch);
        editor.putInt("numero",n);
        editor.commit();

        Drawable draw=context.getResources()
                .getDrawable(context.getResources()
                        .getIdentifier("btn_blue","drawable",context
                                .getPackageName()));

        View viewGroup=view.getRootView();

        viewGroup.findViewById(R.id.imageOrange).setBackgroundColor(Color.argb(255,238,238,241));
        viewGroup.findViewById(R.id.imageAirtel).setBackgroundColor(Color.argb(255,238,238,241));
        viewGroup.findViewById(R.id.imageAfricell).setBackgroundColor(Color.argb(255,238,238,241));
        viewGroup.findViewById(R.id.imageTigo).setBackgroundColor(Color.argb(255,238,238,241));
        viewGroup.findViewById(R.id.imageVodacom).setBackgroundColor(Color.argb(255,238,238,241));

        view.setBackgroundDrawable(draw);

        //Toast.makeText(context,""+reseau(),Toast.LENGTH_LONG).show();
    }

    public int reseau(){
        return preferences.getInt("numero",0);

    }
}
