/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesprincipales;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class VisitaDeAtencion {

    private int idVisita;
    private int idMascota;
    private int idTratamiento;
    private Date fecha;
    private double precio;

    public VisitaDeAtencion() {
    }

    public VisitaDeAtencion(int idMascota, int idTratamiento, Date fecha, double precio) {
        this.idMascota = idMascota;
        this.idTratamiento = idTratamiento;
        this.fecha = fecha;
        this.precio = precio;
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
