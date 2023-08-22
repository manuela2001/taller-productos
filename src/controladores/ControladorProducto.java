/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.ConexionBD;
import org.mariadb.jdbc.Connection;


/**
 *
 * @author Manuela Gomez
 */
public class ControladorProducto {
    
   private final ConexionBD conn;
   private final Connection con;
        
    public ControladorProducto() {
        conn = new ConexionBD();
        con = conn.getConexion();
    }
    
    public ResultSet buscarProducto(String codigo) {
        String where = "";
        
        if(!"".equals(codigo)){
            where = "WHERE codigo = '" + codigo + "'";
        }
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            
            String sql = "SELECT * FROM productos " + where;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            return rs;
            
        }catch(SQLException e){
            System.err.println(e);
            
        }
        return null;
        
    }
    public ResultSet listarProductos() {
               
        try{
            PreparedStatement ps;
            ResultSet rs;
            
            String sql = "SELECT * FROM productos ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            return rs;
            
        }catch(SQLException e){
            System.err.println(e);
            
        }
        return null;
    
    } 
            
    
}
