package mx.edu.ittepic.tadm_u2_lab2;

import java.io.Serializable;

/**
 * Created by adelina on 14/03/2018.
 */

public class Usuario implements Serializable {
    private Integer id;
    private String nombre;
    private String telefono;

    public Usuario(Integer id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Usuario(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
