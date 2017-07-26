package com.example.andrick.mob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.andrick.mob.R.id.activation;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        TextView recharg=(TextView)findViewById(R.id.recharge_m);
        TextView activ=(TextView)findViewById(activation);
        TextView verifi=(TextView)findViewById(R.id.verification);
        TextView urgen=(TextView)findViewById(R.id.urgence);
        TextView envoy=(TextView)findViewById(R.id.envoyer_men);

        assert recharg != null;
        recharg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this,Recharge.class);
                intent.putExtra("action",1);
                startActivity(intent);
            }
        });
        assert activ != null;
        activ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this,ChoixReseau.class);
                intent.putExtra("action",2);
                startActivity(intent);
            }
        });
        assert verifi != null;
        verifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this,Verification.class);
                intent.putExtra("action",3);
                startActivity(intent);
            }
        });
        assert urgen !=null;
        urgen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this,Urgence.class);
                //intent.putExtra("action",4);
                startActivity(intent);
            }
        });
        assert envoy !=null;
        envoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this,Envoyer.class);
                intent.putExtra("action",4);
                startActivity(intent);
            }
        });
    }
}
