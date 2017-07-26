package com.example.andrick.mob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EnvoyerCred extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.envoyer_cred);


        ContactMod cm=new ContactMod();
        //String n=cm.getContacts();

    }
}
