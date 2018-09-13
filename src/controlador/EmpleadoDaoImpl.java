/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Crud;
import interfaces.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Empleado;

/**
 *
 * @author rami
 */
public class EmpleadoDaoImpl implements Dao<Empleado>{

    @Override
    public void registrar(Empleado t) {
               int id = t.getIdEmpleado();
                String nombre = t.getNombre();
                String apellido = t.getApellido();
                String telefono = t.getTelefono();
                String fax = t.getFax();
                String correo = t.getCorreo();
                String direccion = t.getDireccion();
                String sql = "inserto into templeado(nombre,apellido,direccion,telefono,correo,fax)"
                        + "values (?,?,?,?,?,?)";
                
                Crud.insert(sql,nombre,apellido,direccion,telefono,correo,fax);
    }

    @Override
    public void actualizar(Empleado t) {
                int id = t.getIdEmpleado();
                String nombre = t.getNombre();
                String apellido = t.getApellido();
                String telefono = t.getTelefono();
                String fax = t.getFax();
                String correo = t.getCorreo();
                String direccion = t.getDireccion();
                String sql = "update from templeado set nombre =? , "+
                             "apellido =? , direccion = ? ,telefono =? ,"+
                             "correo = ? ,fax = ? where id = " + id;
                
                Crud.update(sql,nombre,apellido,direccion,telefono,correo,fax);


    }

    @Override
    public void eliminar(Empleado t) {
        int id = t.getIdEmpleado();
        String sql = "delete from templeado where id " + id;
        Crud.delete(sql);
    }

    @Override
    public Empleado buscarPorId(int id) {
          
       for(Empleado e : obtenerTodos()){
           if(e.getIdEmpleado() == id){
               return e;
           }
          
       }
        JOptionPane.showMessageDialog(null, "No existe empleado con ese Id","Aviso",JOptionPane.INFORMATION_MESSAGE);
       return null;
    }

    @Override
    public List<Empleado> obtenerTodos() {
            List<Empleado> empleados=new ArrayList<>();
        ResultSet set = Crud.select("select * from templeado");
        
        try {
            while(set.next()){
                int id = set.getInt(1);
                String nombre = set.getString(2);
                String apellido =set.getString(3);
                String telefono = set.getString(4);
                String fax =set.getString(5);
                String correo = set.getString(6);
                String direccion =set.getString(7);
                Empleado c =new Empleado(nombre, apellido, telefono, fax, correo, direccion, id);
                empleados.add(c);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return empleados;
    }



  

   
  
    
}
