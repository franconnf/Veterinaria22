/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesdata;

import clasesprincipales.Tratamiento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class TratamientoData {

    public void guardar(Tratamiento tratamiento) {
        try {
            String sql = "INSERT INTO tratamiento (nombreTrat, descripcion, precio, fecha) VALUES (?,?,?,?);";
            PreparedStatement pstm = Conexion.getConexion().prepareStatement(sql);
            pstm.setString(1, tratamiento.getNombre());
            pstm.setString(2, tratamiento.getDescripcion());
            pstm.setDouble(3, tratamiento.getPrecio());
            pstm.setDate(4, new java.sql.Date(tratamiento.getFecha().getTime()));
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al guarda tratamiento en base de datos");
            Logger.getLogger(TratamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Conexion.close();
        }
    }

    public ArrayList<Tratamiento> listarTodos() {
        try {
            ArrayList<Tratamiento> tratamientos = new ArrayList<>();
            String sql = "SELECT * FROM tratamiento";
            PreparedStatement pstm = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Tratamiento tratamiento = new Tratamiento();
                tratamiento.setNombre(rs.getString("nombreTrat"));
                tratamiento.setDescripcion(rs.getString("descripcion"));
                tratamiento.setPrecio(rs.getDouble("precio"));
                tratamiento.setFecha(rs.getDate("fecha"));
                tratamientos.add(tratamiento);
            }

            return tratamientos;

        } catch (SQLException ex) {
            System.out.println("Error al listar tratamientos desde la base de datos");
            Logger.getLogger(TratamientoData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally{
            Conexion.close();
        }
    }

    public Tratamiento buscar(int id) {
        try {
            String sql = "SELECT * FROM tratamiento WHERE idTratamiento = ?;";
            PreparedStatement pstm = Conexion.getConexion().prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                Tratamiento tratamiento = new Tratamiento();
                tratamiento.setNombre(rs.getString("nombreTrat"));
                tratamiento.setDescripcion(rs.getString("descripcion"));
                tratamiento.setPrecio(rs.getDouble("precio"));
                tratamiento.setFecha(rs.getDate("fecha"));
                return tratamiento;
            } else {
                System.out.println("No se encontro el tratamiento");
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("Error al buscar tratamiento en la base de datos");
            Logger.getLogger(TratamientoData.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally{
            Conexion.close();
        }
    }

    public void editar(Tratamiento tratamiento) {
        try {
            String sql = "UPDATE tratamiento SET nombreTrat = ?, descripcion = ?, precio = ?, fecha = ? WHERE idTratamiento = ?;";
            PreparedStatement pstm = Conexion.getConexion().prepareStatement(sql);
            pstm.setString(1, tratamiento.getNombre());
            pstm.setString(2, tratamiento.getDescripcion());
            pstm.setDouble(3, tratamiento.getPrecio());
            pstm.setDate(4, new java.sql.Date(tratamiento.getFecha().getTime()));
            pstm.setInt(5, tratamiento.getIdTratamiento());
            if(pstm.executeUpdate()>0){
                System.out.println("Exito al editar");
            }else{
                System.out.println("Error al editar");
            }
        } catch (SQLException ex) {
            System.out.println("Error al editar tratamiento en la base de datos");
            Logger.getLogger(TratamientoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Conexion.close();
        }
    }

    public void borrar(Tratamiento tratamiento) {
        String sql = "DELETE FROM tratamiento WHERE idTratamiento = ?;";
        try(PreparedStatement pstm = Conexion.getConexion().prepareStatement(sql)) {
            pstm.setInt(1, tratamiento.getIdTratamiento());
            if (pstm.executeUpdate() > 0) {
                System.out.println("Tratamiento eliminado");
            } else {
                System.out.println("No se pudo eliminar tratamiento");
            }
        } catch (Exception e) {
        }
        finally{
            Conexion.close();
        }
    }
}
