package com.example.andrick.mob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activation);

        TextView mi=(TextView)findViewById(R.id.minute);
        TextView sm=(TextView)findViewById(R.id.sms);
        TextView mo=(TextView)findViewById(R.id.mega);

        assert mi !=null;
        assert sm !=null;
        assert mo !=null;

        mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activation.this,ActivationMin.class);
                startActivity(intent);
            }
        });

        sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activation.this,ActivationSms.class);
                startActivity(intent);
            }
        });
        mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activation.this,ActivationMega.class);
                startActivity(intent);
            }
        });
    }
}
