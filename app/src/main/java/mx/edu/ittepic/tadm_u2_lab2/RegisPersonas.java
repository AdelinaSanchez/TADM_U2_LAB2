package mx.edu.ittepic.tadm_u2_lab2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisPersonas extends AppCompatActivity {

    EditText campoClave,campoNombre,campoSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis_personas);
        campoClave= findViewById(R.id.campoId);
        campoNombre= findViewById(R.id.campoNombre);
        campoSalario= findViewById(R.id.campoTelefono);

    }

    public void onClick(View view) {
        registrarUsuarios();
    }
    private void registrarUsuarios() {
        BasedeDatos conn=new BasedeDatos(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(UtBasededatos.CAMPO_ID,campoClave.getText().toString());
        values.put(UtBasededatos.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(UtBasededatos.CAMPO_TELEFONO,campoSalario.getText().toString());

        Long idResultante=db.insert(UtBasededatos.TABLA_USUARIO,UtBasededatos.CAMPO_ID,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}
