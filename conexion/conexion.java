package conexion;

import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Usuario;

public class conexion {
    private static conexion con;    
    private static Connection db;
  
    private conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            db = DriverManager.getConnection(
                    "jdbc:mysql://20y10cambita.ddns.net:3306/db_auto?useSSL=false", "db_auto", "123456");
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexion: " + e.getMessage());
        }
    }
    public Connection getConex(){
        
        
        return db;
    }
   
    public static conexion getInstance(){
        if(con == null){
            con = new conexion();
        }
        return con;
    }
    

}
