package com.example.andrick.mob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChoixReseau extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_reseau);

        ImageView air=(ImageView)findViewById(R.id.airtel);
        ImageView vod=(ImageView)findViewById(R.id.vodacom);
        ImageView org=(ImageView)findViewById(R.id.orange);
        ImageView afr=(ImageView)findViewById(R.id.africell);
        ImageView tig=(ImageView)findViewById(R.id.tigo);

        assert air !=null;
        assert vod !=null;
        assert org !=null;
        assert afr !=null;
        assert tig !=null;

        final Intent intent=getIntent();
        int op = intent.getIntExtra("action", 0);

        if(op==1)
        {

            air.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentetion=new Intent(ChoixReseau.this,Recharge.class);
                    intentetion.putExtra("id_reseau",1);
                    startActivity(intentetion);
                }
            });
            vod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Recharge.class);
                    intent1.putExtra("id_reseau",2);
                    startActivity(intent1);

                }
            });

            org.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Recharge.class);
                    intent1.putExtra("id_reseau",3);
                    startActivity(intent1);

                }
            });

            afr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Recharge.class);
                    intent1.putExtra("id_reseau",4);
                    startActivity(intent1);

                }
            });
            tig.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Recharge.class);
                    intent1.putExtra("id_reseau",5);
                    startActivity(intent1);

                }
            });
        }
        else if(op==2)
        {

            air.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Activation.class);
                    intent1.putExtra("id_reseau",1);
                    startActivity(intent1);
                }
            });
            vod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Activation.class);
                    intent1.putExtra("id_reseau",2);
                    startActivity(intent1);

                }
            });

            org.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Activation.class);
                    intent1.putExtra("id_reseau",3);
                    startActivity(intent1);

                }
            });

            afr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Activation.class);
                    intent1.putExtra("id_reseau",4);
                    startActivity(intent1);

                }
            });
            tig.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Activation.class);
                    intent1.putExtra("id_reseau",5);
                    startActivity(intent1);

                }
            });
        }
        else if(op==3)
        {

            air.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Verification.class);
                    intent1.putExtra("id_reseau",1);
                    startActivity(intent1);
                }
            });
            vod.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Verification.class);
                    intent1.putExtra("id_reseau",2);
                    startActivity(intent1);

                }
            });

            org.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Verification.class);
                    intent1.putExtra("id_reseau",3);
                    startActivity(intent1);

                }
            });

            afr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Verification.class);
                    intent1.putExtra("id_reseau",4);
                    startActivity(intent1);

                }
            });
            tig.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(ChoixReseau.this,Verification.class);
                    intent1.putExtra("id_reseau",5);
                    startActivity(intent1);

                }
            });
        }


    }
}
