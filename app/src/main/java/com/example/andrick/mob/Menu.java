package com.example.andrick.mob;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.andrick.mob.R.id.activation;

public class Menu extends AppCompatActivity {


    private BddInterne bdd;

    private final void createShortcutRecharge(){
        // Get preference value to know that is it first time application is
        // being called.
        SharedPreferences appPref = getSharedPreferences("isFirstTime", 0);
        boolean isFirstTime = appPref.getBoolean("isFirstTime", true);

        if (isFirstTime) {
            // Create explicit intent which will be used to call Our application
            // when some one clicked on short cut
            Intent shortcutIntent = new Intent(getApplicationContext(), Recharge.class);
            shortcutIntent.setAction(Intent.ACTION_MAIN);
            Intent intent = new Intent();

            // Create Implicit intent and assign Shortcut Application Name, Icon
            intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
            intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "Recharge");
            intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.drawable.racc));
            intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            getApplicationContext().sendBroadcast(intent);

            // Set preference to inform that we have created shortcut on Homescreen
            SharedPreferences.Editor editor = appPref.edit();
            editor.putBoolean("isFirstTime", false);
            editor.commit();

        }
    }
    private final void createShortcuVerific(){
        // Get preference value to know that is it first time application is
        // being called.
        SharedPreferences appPref = getSharedPreferences("isFirstTime", 0);
        boolean isFirstTime = appPref.getBoolean("isFirstTime", true);

        if (isFirstTime) {
            // Create explicit intent which will be used to call Our application
            // when some one clicked on short cut
            Intent shortcutIntent = new Intent(getApplicationContext(), Verification.class);
            shortcutIntent.setAction(Intent.ACTION_MAIN);
            Intent intent = new Intent();

            // Create Implicit intent and assign Shortcut Application Name, Icon
            intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
            intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "Verifications");
            intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.drawable.racc));
            intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            getApplicationContext().sendBroadcast(intent);

            // Set preference to inform that we have created shortcut on Homescreen
            SharedPreferences.Editor editor = appPref.edit();
            editor.putBoolean("isFirstTime", false);
            editor.commit();

        }
    }

    public void info_bloquer()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
        builder.setTitle(R.string.titre_bloc);
        builder.setMessage(R.string.texte_descript);
        builder.setPositiveButton(R.string.ok, null);
        //builder.setNegativeButton(R.string.annuler, null);
        builder.show();
    }
    public void en_parler_a()
    {
        String whatsAppMessage = "Telecharger l'application Mob sur https://";

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, whatsAppMessage);
        sendIntent.setType("text/plain");

        // Do not forget to add this to open whatsApp App specifically

        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);

        try {
            bdd.Inserer_donnees("0");
            //Toast.makeText(Menu.this,"Insertion",Toast.LENGTH_LONG).show();
        }catch (SQLiteException ex){
            //Toast.makeText(Menu.this,"No Insertion", Toast.LENGTH_LONG).show();
        }

    }
    public int check_si_debloquer()
    {
        if(bdd.compte_insertion()==0)
        {
            return 0;
        }
        return 1;
    }
    public void boit_de_dialogue()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
        builder.setTitle(R.string.info_titre);
        builder.setMessage(R.string.info_description);
        builder.setPositiveButton(R.string.envoyer, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                en_parler_a();


            }
        });
        builder.setNegativeButton(R.string.annuler, null);
        builder.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        createShortcutRecharge();
        createShortcuVerific();

        bdd= new BddInterne(Menu.this,"",null,1);




        TextView recharg=(TextView)findViewById(R.id.recharge_m);
        TextView activ=(TextView)findViewById(activation);
        TextView verifi=(TextView)findViewById(R.id.verification);
        TextView urgen=(TextView)findViewById(R.id.urgence);
        TextView envoy=(TextView)findViewById(R.id.envoyer_men);
        TextView abou=(TextView)findViewById(R.id.abouts);
        TextView arge=(TextView)findViewById(R.id.money);

        assert recharg != null;
        recharg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                if(check_si_debloquer()==0)
                {
                    boit_de_dialogue();
                }
                else
                {
                    Intent intent=new Intent(Menu.this,Recharge.class);
                    intent.putExtra("action",1);
                    startActivity(intent);
                }

                */

                Intent intent=new Intent(Menu.this,Recharge.class);
                intent.putExtra("action",1);
                startActivity(intent);

            }
        });
        assert activ != null;
        activ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                info_bloquer();
                /*
                if(check_si_debloquer()==0)
                {
                    boit_de_dialogue();
                }
                else
                {
                    Intent intent=new Intent(Menu.this,ChoixReseau.class);
                    intent.putExtra("action",2);
                    startActivity(intent);
                }
                */

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
                info_bloquer();
                /*
                Intent intent=new Intent(Menu.this,Urgence.class);
                //intent.putExtra("action",4);
                startActivity(intent);

                */
            }
        });
        assert envoy !=null;
        envoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_bloquer();
                /*
                if(check_si_debloquer()==0)
                {
                    boit_de_dialogue();
                }
                else
                {
                    Intent intent=new Intent(Menu.this,Envoyer.class);
                    intent.putExtra("action",4);
                    startActivity(intent);
                }
                */

            }
        });

        assert abou !=null;

        abou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
                builder.setTitle(R.string.titre_ab);
                builder.setMessage(R.string.descriptions);
                builder.setPositiveButton(R.string.ok,null);
                builder.show();
            }
        });




    }
}
