/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rami
 */
public class Crud {
      private static PreparedStatement consultaPreparada;
  
      public static int nFilas = 0 ;
     
     private static Connection conex = conexion.getInstance().getConex();
  
     
     public static String[] nombreColumnas(String tabla){
         String[] s=null;
          try {
            ResultSetMetaData metaDatos = select("select * from " + tabla).getMetaData();
            s= new String[metaDatos.getColumnCount()];
            for(int i=0;i < metaDatos.getColumnCount();i++){
                  s[i] = metaDatos.getColumnName(i+1);
              }
            } catch (SQLException ex) {
              Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
            }
          return s;
     }
     
     public static ResultSet select(String sql){
          ResultSet rs=null;
          
          try {
              rs = conex.createStatement().executeQuery(sql);
              for (int i = 0;rs.next(); i++)
                    nFilas++;
                      
              rs.close();
          } catch (SQLException ex) {
              Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
          }
           
             return rs;
          
     }
     public static void update(String sql,String... parametros){
           
              try {
              
              consultaPreparada = conex.prepareStatement(sql);
               for(int i=0;i<parametros.length;i++){
               
                   consultaPreparada.setString(i+1, parametros[i]);
               }
               
              consultaPreparada.executeUpdate();
              
              
          } catch (SQLException ex) {
           
          }
         
          
     }
     public static void delete(String sql){
          try {
             conex.createStatement().executeUpdate(sql);
          } catch (SQLException ex) {
              Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
          }
     }
     public static boolean insert(String sql,String... parametros){
             boolean b = false;
              try {
              
              consultaPreparada = conex.prepareStatement(sql);
               for(int i=0;i<parametros.length;i++){
                
                   consultaPreparada.setString(i+1, parametros[i]);
               }
              consultaPreparada.executeUpdate();
              
              b = true;
              
          } catch (SQLException ex) {
           
          }
         
          return b;
         
     }

}
