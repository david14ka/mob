package com.example.andrick.mob;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrick.mob.ui.Footer;
import com.example.andrick.mob.ui.IFooter;

public class Verification extends AppCompatActivity implements IFooter{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verification1);

        TextView so = (TextView) findViewById(R.id.solde);
        TextView mo = (TextView) findViewById(R.id.mega);
        TextView mi = (TextView) findViewById(R.id.minute);
        TextView sm = (TextView) findViewById(R.id.sms);
        TextView soe = (TextView) findViewById(R.id.solde_emprunt);
        TextView bo = (TextView) findViewById(R.id.bonus);

        assert so != null;
        assert mo != null;
        assert mi != null;
        assert sm != null;
        assert soe != null;
        assert bo != null;

        final String[] solde_t = {"*565", "*100#", "*100*", "*1001*", "*212*"};
        final String[] mega_t = {"*565*3", "*100*2", "*124*121", "*1050*225", "*124*121"};
        final String[] bonus_t = {"*565*707", "*100*1", "*124*212", "*111", "*124*212"};
        final String[] emprunt_t = {"*565*8", "*260*01", "*123", "*111", "*123"};
        final String[] minutes_t = {"*565*707", "*100*1", "*101*2", "*1050*225", "*101*2"};
        final String[] sms_t = {"*565*7", "*100*1", "", "*1050*255", ""};

        //final int id = getIntent().getIntExtra("id_reseau", 0);
        final Footer footer=new Footer(this);


        so.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id=footer.reseau();
                if (id==0) {
                    Toast.makeText(getApplicationContext(),"Veuillez choisir un reseau svp",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent veri = new Intent(Intent.ACTION_CALL);
                veri.setData(Uri.parse("tel:" + solde_t[id - 1]+Uri.encode("#")));
                if (ActivityCompat.checkSelfPermission(Verification.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(veri);
            }
        });

        mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id=footer.reseau();
                if (id==0) {
                    Toast.makeText(getApplicationContext(),"Veuillez choisir un reseau svp",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent veri = new Intent(Intent.ACTION_CALL);
                veri.setData(Uri.parse("tel:" + mega_t[id - 1]+Uri.encode("#")));
                if (ActivityCompat.checkSelfPermission(Verification.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(veri);
            }
        });
        soe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id=footer.reseau();
                if (id==0) {
                    Toast.makeText(getApplicationContext(),"Veuillez choisir un reseau svp",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent veri = new Intent(Intent.ACTION_CALL);
                veri.setData(Uri.parse("tel:" + emprunt_t[id - 1]+Uri.encode("#")));
                if (ActivityCompat.checkSelfPermission(Verification.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(veri);
            }
        });

        sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id=footer.reseau();
                if (id==0) {
                    Toast.makeText(getApplicationContext(),"Veuillez choisir un reseau svp",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent veri = new Intent(Intent.ACTION_CALL);
                veri.setData(Uri.parse("tel:" + sms_t[id - 1]+Uri.encode("#")));
                if (ActivityCompat.checkSelfPermission(Verification.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(veri);
            }
        });

        bo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id=footer.reseau();
                if (id==0) {
                    Toast.makeText(getApplicationContext(),"Veuillez choisir un reseau svp",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent veri = new Intent(Intent.ACTION_CALL);
                veri.setData(Uri.parse("tel:" + bonus_t[id - 1]+Uri.encode("#")));
                if (ActivityCompat.checkSelfPermission(Verification.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(veri);
            }
        });

        mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id=footer.reseau();
                if (id==0) {
                    Toast.makeText(getApplicationContext(),"Veuillez choisir un reseau svp",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent veri = new Intent(Intent.ACTION_CALL);
                veri.setData(Uri.parse("tel:" + minutes_t[id - 1]+Uri.encode("#")));
                if (ActivityCompat.checkSelfPermission(Verification.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(veri);
            }
        });


    }

    @Override
    public void footerOnClick(View view) {
        Footer footer=new Footer(this);
        footer.click(view);
    }
}
