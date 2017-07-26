package com.example.andrick.mob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.andrick.mob.ui.Footer;
import com.example.andrick.mob.ui.IFooter;

public class ActivationMin extends AppCompatActivity implements IFooter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activation_min1);


    }

    @Override
    public void footerOnClick(View view) {
        Footer footer=new Footer(this);
        footer.click(view);
    }
}
