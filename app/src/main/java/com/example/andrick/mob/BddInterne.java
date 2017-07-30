package com.example.andrick.mob;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Andricksen on 28/07/2017.
 */
public class BddInterne extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "ETAT";
    private static final String CHAMP1 = "ID";
    private static final String CHAMP2 = "ETAT_APP";


    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_NAME + " ("
            + CHAMP1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CHAMP2 + " TEXT NOT NULL);";


    public BddInterne(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //Heritage du constructeur de la classe mere
        super(context, "MOB.db", factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_NAME + ";");
        onCreate(db);

    }


    public void Inserer_donnees(String etat) {
        if(compte_insertion()==0)
        {
            ContentValues contenu = new ContentValues();
            contenu.put("ETAT_APP", etat);
            this.getWritableDatabase().insertOrThrow(TABLE_NAME, "", contenu);
        }


    }


    public void Mise_a_jour(String etat) {
        this.getWritableDatabase().execSQL("UPDATE" + TABLE_NAME + " set ETAT_APP ='" + etat + "'");

    }


    public ArrayList<String> Liste_info() {
        ArrayList<String> liste = new ArrayList<>();
        String etat = "";
        Cursor curseur = this.getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + "  ", null);
        while (curseur.moveToNext()) {
            etat = curseur.getString(2);
            liste.add(etat);
        }

        return liste;

    }
    public  int compte_insertion()
    {
        int i=0;
        Cursor curseur = this.getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + "  ", null);
        while (curseur.moveToNext()) {
            i++;
        }
        return  i;
    }
}
