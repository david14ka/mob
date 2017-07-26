package com.example.andrick.mob;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrick.mob.ui.Footer;
import com.example.andrick.mob.ui.IFooter;

public class Recharge extends AppCompatActivity implements IFooter{

    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recharge);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        //toolbar.setTitle("Recharger votre compte");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_clear_black_24dp);
        getSupportActionBar().setTitle("");

        final String[] recharge_t = {"*525*", "*101*", "*100*", "*1001*", "*212*"};



        TextView re = (TextView) findViewById(R.id.btn_recharge);
        final EditText c = (EditText) findViewById(R.id.code_recharge);

        assert re != null;
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Footer footer=new Footer(getApplicationContext());
                int id=footer.reseau();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + recharge_t[id - 1] + c.getText().toString() + Uri.encode("#")));
                if (ActivityCompat.checkSelfPermission(Recharge.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });


    }

    @Override
    public void footerOnClick(View view) {
        Footer footer=new Footer(this);
        footer.click(view);
    }
}
