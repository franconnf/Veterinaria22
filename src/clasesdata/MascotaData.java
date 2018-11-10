/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesdata;

import clasesprincipales.Cliente;
import clasesprincipales.Mascota;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class MascotaData {

    public MascotaData() {
    }

    public void guardarMascota(Mascota mascota) {
        Connection con = Conexion.getConexion();
        String sql = "INSERT INTO mascota VALUES (null,?,?,?,?,?,?,?,?,?);";
        try {           
            try (PreparedStatement stm = con.prepareStatement(sql)) {               
                stm.setString(1, mascota.getAlias());
                stm.setString(2, mascota.getSexo());
                stm.setString(3, mascota.getEspecie());
                stm.setString(4, mascota.getRaza());
                stm.setString(5, mascota.getColorDePelo());
                stm.setDate(6, new java.sql.Date(mascota.getFechaNacimiento().getTime()));
                stm.setDouble(7, mascota.getPesoPromedio());
                stm.setDouble(8, mascota.getPesoActual());
                stm.setString(9, mascota.getDuenio().getDni());

                if (stm.executeUpdate() == 0) {
                    System.out.println("Error al insertar mascota: " + mascota.getAlias());
                } else {
                    System.out.println("Se agrego la mascota: " + mascota.getAlias());
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        
        finally{
            Conexion.close();
        }
    }
    
    public List<Mascota> listarMascotas(){
        Connection con = Conexion.getConexion();
        List<Mascota> mascotas = new ArrayList<>();
        String sql = "SELECT * FROM mascota";
        ClienteData clienteData = new ClienteData();
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {                
                Mascota mascota = new Mascota();
                Cliente cliente = clienteData.buscarCliente(rs.getString("dniCliente1"));
                mascota.setId(rs.getInt("id_masc"));
                mascota.setAlias(rs.getString("alias"));
                mascota.setSexo(rs.getString("sexo"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColorDePelo(rs.getString("color_pelo"));
                mascota.setFechaNacimiento(new java.util.Date(rs.getDate("fecha_nac_aprox").getTime()));
                mascota.setPesoPromedio(rs.getDouble("peso_prom"));
                mascota.setPesoActual(rs.getDouble("peso_actual"));
                mascota.setDuenio(cliente);
                
                mascotas.add(mascota);
            }
            
            return mascotas;
        } catch (SQLException e) {
            return null;
        }
        
        finally{
            Conexion.close();
        }
        
        
    }
    
    public Mascota buscarMascota(int id){
        Connection con = Conexion.getConexion();
        String sql = "select * from mascota where id_masc = ?";
        Mascota mascota = new Mascota();
        ClienteData clienteData = new ClienteData();
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            
            if(rs.isBeforeFirst()){
                Cliente cliente = clienteData.buscarCliente(rs.getString("dniCliente1"));
                rs.next();
                mascota.setId(rs.getInt("id_masc"));
                mascota.setAlias(rs.getString("alias"));
                mascota.setSexo(rs.getString("sexo"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setAlias(rs.getString("raza"));
                mascota.setColorDePelo(rs.getString("color_pelo"));
                mascota.setFechaNacimiento(new java.util.Date(rs.getDate("fecha_nac_aprox").getTime()));
                mascota.setPesoPromedio(rs.getDouble("peso_prom"));
                mascota.setPesoActual(rs.getDouble("peso_actual"));
                mascota.setDuenio(cliente);
                
                return mascota;
                
            }else{
                System.out.print("Nothing found");
                return null;
            }           
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
            
        }
        finally{
            Conexion.close();
        }
        
    }

}
