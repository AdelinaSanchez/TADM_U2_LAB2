package mx.edu.ittepic.tadm_u2_lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetUsuario extends AppCompatActivity {

    TextView campoClave, campoNombre, campoSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_det_usuario);

        campoClave =  findViewById(R.id.campoId);
        campoNombre =  findViewById(R.id.campoNombre);
        campoSalario =  findViewById(R.id.campoTelefono);

        Bundle objetoEnviado=getIntent().getExtras();
        Usuario user=null;

        if(objetoEnviado!=null){
            user= (Usuario) objetoEnviado.getSerializable("usuario");
            campoClave.setText(user.getId().toString());
            campoNombre.setText(user.getNombre().toString());
            campoSalario.setText(user.getTelefono().toString());

        }
    }
}
