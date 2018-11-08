/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.ComboBoxItems;

/**
 *
 * @author MrLyoto
 */
public class ComboBoxMascotaItems {

    private int id;
    private String nombre;
    private String nombreDuenio;

    public ComboBoxMascotaItems(int id, String nombre, String nombreDuenio) {
        this.id = id;
        this.nombre = nombre;
        this.nombreDuenio = nombreDuenio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    @Override
    public String toString() {
        return nombre + "  -  dueño: " + nombreDuenio;
    }

}
