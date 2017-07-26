package com.example.andrick.mob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Envoyer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.envoyer);

        TextView cr=(TextView)findViewById(R.id.env_credit);
        TextView sm=(TextView)findViewById(R.id.env_sms);
        TextView mg=(TextView)findViewById(R.id.env_mega);

        assert cr !=null;
        assert sm !=null;
        assert mg !=null;

        cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Envoyer.this,EnvoyerCred.class);
                startActivity(intent);
            }
        });

        sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Envoyer.this,EnvoyerCred.class);
                startActivity(intent);
            }
        });

        mg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Envoyer.this,EnvoyerCred.class);
                startActivity(intent);
            }
        });
    }
}
