package conexion;

import java.sql.*;
import javax.swing.JOptionPane;

public class conexion {
    private static conexion con;    
    private static Connection db;
    private static int num_rows = 0;
    private conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            db = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_auto?useSSL=false", "root", "123456");
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error de conexion: " + e.getMessage());
        }
    }
    
    public static conexion getInstance(){
        if(con == null){
            con = new conexion();
        }
        return con;
    }
    
    public ResultSet select(String query){
        num_rows = 0;
        ResultSet RS = null;
        Statement ST;
        try{
            ST = db.createStatement();
            RS = ST.executeQuery(query);
            while(RS.next()){
                num_rows++;
            }
            RS.beforeFirst();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error SQL: " + e.getMessage());
        }        
        
        return RS;
    }
    
    public int getNumRows(){
        return num_rows;
    }
}
