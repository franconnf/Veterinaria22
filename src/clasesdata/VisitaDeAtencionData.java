/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesdata;

import clasesprincipales.VisitaDeAtencion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class VisitaDeAtencionData {

    public VisitaDeAtencionData() {
    }

    public ArrayList<VisitaDeAtencion> listarVisitas() {
        String sql = "select * from visita";
        ArrayList<VisitaDeAtencion> listaDeVisitas = new ArrayList<>();
        MascotaData mascotaData = new MascotaData();
        TratamientoData tratamientoData = new TratamientoData();

        try {
            PreparedStatement stm = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                VisitaDeAtencion visita = new VisitaDeAtencion();
                visita.setIdVisita(rs.getInt(1));
                visita.setMascota(mascotaData.buscarMascota(rs.getInt(2)));
                visita.setTratamiento(tratamientoData.buscar(rs.getInt(3)));
                visita.setFecha(rs.getDate(4));
                visita.setPrecio(rs.getDouble(5));

                listaDeVisitas.add(visita);
            }

            return listaDeVisitas;

        } catch (SQLException ex) {
            System.out.println("Error al devolver lista de visitas");
            System.out.println(ex);
            return null;
        } finally {
            Conexion.close();
        }
    }
    
    public VisitaDeAtencion buscarVisita(int id){
        String sql = "select * from visita where id_Visita = ?;";
        VisitaDeAtencion visita = new VisitaDeAtencion();
        MascotaData mascotaData = new MascotaData();
        TratamientoData tratamientoData = new TratamientoData();
        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                rs.next();
                visita.setIdVisita(rs.getInt("id_visita"));
                visita.setMascota(mascotaData.buscarMascota(rs.getInt(2)));
                visita.setTratamiento(tratamientoData.buscar(rs.getInt(3)));
                visita.setFecha(rs.getDate("fecha"));
                visita.setPrecio(rs.getDouble("precio"));
                return visita;
                
            } catch (Exception ex) {
                int stackNumber = 0;
                for (int i = 0; i < ex.getStackTrace().length; i++) {
                    if ("<init>".equals(ex.getStackTrace()[i].getMethodName())) {
                        stackNumber = i - 1;
                    }
                }
                System.out.println("*******************************************************");
                System.out.println("");
                System.out.println(ex);
                System.out.println("Error en: " + ex.getStackTrace()[stackNumber].getClassName() + " ---> " + ex.getStackTrace()[stackNumber].getMethodName() + " || Line: " + ex.getStackTrace()[stackNumber].getLineNumber());
                System.out.println("*******************************************************");
                return null;
            }
    }

    public void agregarVisita(VisitaDeAtencion visita) {
        try {           
            String sql = "insert into visita (id_tratamiento1, id_masc1, fecha, precio) values (?,?,?,?);";
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, visita.getTratamiento().getIdTratamiento());
            ps.setInt(2, visita.getMascota().getId());
            ps.setDate(3, new Date(visita.getFecha().getTime()));
            ps.setDouble(4, visita.getPrecio());

            if (ps.executeUpdate() > 0) {
                System.out.println("Se agrego visita con exito");
                JOptionPane.showMessageDialog(null, "Visita agregada");
            }
        } catch (SQLException ex) {

            System.out.println("*******************************************************");
            System.out.println("Error al agregar visita");
            System.out.println(ex);
            System.out.println("Error en: " + ex.getStackTrace()[0].getClassName() + " ---> " + ex.getStackTrace()[0].getMethodName() + " || Line: " + ex.getStackTrace()[0].getLineNumber());
            System.out.println("*******************************************************");

            JOptionPane.showMessageDialog(null, "Error al agregar visita");

        } finally {
            Conexion.close();
        }
    }

    public void borrarVisita(int idVisita) {
        String sql = "delete from visita where idVisita = ?;";
        try (PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)) {
            ps.setInt(1, idVisita);
            if (ps.executeUpdate() > 0) {
                System.out.println("Visita eliminada");
            } else {
                System.out.println("No se pudo eliminar");
            }

        } catch (Exception ex) {
            int stackNumber = 0;
            for (int i = 0; i < ex.getStackTrace().length; i++) {
                if ("<init>".equals(ex.getStackTrace()[i].getMethodName())) {
                    stackNumber = i - 1;
                }
            }
            System.out.println("*******************************************************");
            System.out.println("Error al borrar visita");
            System.out.println(ex);
            System.out.println("Error en: " + ex.getStackTrace()[stackNumber].getClassName() + " ---> " + ex.getStackTrace()[stackNumber].getMethodName() + " || Line: " + ex.getStackTrace()[stackNumber].getLineNumber());
            System.out.println("*******************************************************");

        }

    }

    public void editarVisita(VisitaDeAtencion visita) {
        try {
            String sql = "UPDATE visita SET id_masc1 = ?, id_Tratamiento1 = ?, fecha = ?, precio = ? where id_Visita = ?;";
            PreparedStatement stm = Conexion.getConexion().prepareStatement(sql);
            stm.setInt(1, visita.getMascota().getId());
            stm.setInt(2, visita.getTratamiento().getIdTratamiento());
            stm.setDate(3, new java.sql.Date(visita.getFecha().getTime()));
            stm.setDouble(4, visita.getPrecio());
            stm.setInt(5, visita.getIdVisita());
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al modificar visita");
            System.out.println(ex);
        } finally {
            Conexion.close();
        }
    }
}
