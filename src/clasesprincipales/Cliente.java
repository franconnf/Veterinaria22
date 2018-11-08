/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesprincipales;

/**
 *
 * @author Usuario
 */
public class Cliente {
    private String dni;
    private String nombre_apellido;
    private String tel;
    private String persona_alt;
    private String direccion;

    public Cliente(String dni, String nombre_apellido, String tel, String persona_alt, String direccion) {
        this.dni = dni;
        this.nombre_apellido = nombre_apellido;
        this.tel = tel;
        this.persona_alt = persona_alt;
        this.direccion = direccion;
    }

    public Cliente() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPersona_alt() {
        return persona_alt;
    }

    public void setPersona_alt(String persona_alt) {
        this.persona_alt = persona_alt;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nombre_apellido=" + nombre_apellido + ", tel=" + tel + ", persona_alt=" + persona_alt + ", direccion=" + direccion + '}';
    }
    
    
}

