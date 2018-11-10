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
public class Mascota {
    
    private int id;
    private String alias;
    private String sexo;
    private String especie;
    private String raza;
    private String colorDePelo;
    private Date fechaNacimiento;
    private double pesoPromedio;
    private double pesoActual;
    private Cliente duenio;

    public Mascota(String alias, String sexo, String especie, String raza, String colorDePelo, Date fechaNacimiento, double pesoPromedio, double pesoActual, Cliente duenio) {
        this.alias = alias;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
        this.colorDePelo = colorDePelo;
        this.fechaNacimiento = fechaNacimiento;
        this.pesoPromedio = pesoPromedio;
        this.pesoActual = pesoActual;
        this.duenio = duenio;
    }

    public Mascota() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @return the colorDePelo
     */
    public String getColorDePelo() {
        return colorDePelo;
    }

    /**
     * @param colorDePelo the colorDePelo to set
     */
    public void setColorDePelo(String colorDePelo) {
        this.colorDePelo = colorDePelo;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the pesoPromedio
     */
    public double getPesoPromedio() {
        return pesoPromedio;
    }

    /**
     * @param pesoPromedio the pesoPromedio to set
     */
    public void setPesoPromedio(double pesoPromedio) {
        this.pesoPromedio = pesoPromedio;
    }

    /**
     * @return the pesoActual
     */
    public double getPesoActual() {
        return pesoActual;
    }

    /**
     * @param pesoActual the pesoActual to set
     */
    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public Cliente getDuenio() {
        return duenio;
    }

    public void setDuenio(Cliente duenio) {
        this.duenio = duenio;
    }

    /**
     * @return the dni_dueno
     */
    
    
    
}
