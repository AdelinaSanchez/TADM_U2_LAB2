package mx.edu.ittepic.tadm_u2_lab2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by adelina on 07/03/2018.
 */

public class BasedeDatos extends SQLiteOpenHelper{
    public BasedeDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UtBasededatos.CREAR_TABLA_USUARIO);
        db.execSQL(UtBasededatos.CREAR_TABLA_MASCOTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+UtBasededatos.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS "+UtBasededatos.TABLA_MASCOTA);
        onCreate(db);
    }
}
