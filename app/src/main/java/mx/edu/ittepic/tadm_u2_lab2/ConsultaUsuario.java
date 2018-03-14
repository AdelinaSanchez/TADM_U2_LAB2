package mx.edu.ittepic.tadm_u2_lab2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConsultaUsuario extends AppCompatActivity {
    EditText campoId,campoNombre,campoTelefono;
    BasedeDatos con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_usuario);
        con=new BasedeDatos(getApplicationContext(),"bd_usuarios",null,1);

        campoId= findViewById(R.id.documentoId);
        campoNombre=  findViewById(R.id.campoNombreConsulta);
        campoTelefono= findViewById(R.id.campoTelefonoConsulta);
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnConsultar:
                consultarSql();
                break;
            case R.id.btnActualizar: actualizarUsuario();
                break;
            case R.id.btnEliminar: eliminarUsuario();
                break;
        }

    }

    private void eliminarUsuario() {
        SQLiteDatabase db=con.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};

        db.delete(UtBasededatos.TABLA_USUARIO, UtBasededatos.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el usuario", Toast.LENGTH_LONG).show();
        campoId.setText("");
        limpiar();
        db.close();
    }

    private void actualizarUsuario() {
        SQLiteDatabase db=con.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(UtBasededatos.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(UtBasededatos.CAMPO_TELEFONO,campoTelefono.getText().toString());

        db.update(UtBasededatos.TABLA_USUARIO,values,UtBasededatos.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el usuario", Toast.LENGTH_LONG).show();
        db.close();

    }

    private void consultarSql() {
        SQLiteDatabase db=con.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};

        try {
            Cursor cursor=db.rawQuery("SELECT "+UtBasededatos.CAMPO_NOMBRE+","+UtBasededatos.CAMPO_TELEFONO+
                    " FROM "+UtBasededatos.TABLA_USUARIO+" WHERE "+UtBasededatos.CAMPO_ID+"=? ",parametros);

            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoTelefono.setText(cursor.getString(1));

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe", Toast.LENGTH_LONG).show();
            limpiar();
        }

    }
    private void limpiar() {
        campoNombre.setText("");
        campoTelefono.setText("");
    }
}
