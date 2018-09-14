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
import modelo.Usuario;

/**
 *
 * @author rami
 */
public class UsuarioDao implements Dao{
    
    private static UsuarioDao instancia = null;
    public static UsuarioDao getInstancia(){
        if(instancia == null)
            instancia = new UsuarioDao();
        
        return instancia;
    }
 
    @Override
    public void registrar(Usuario t) {
        String nombre = t.getNombre();
        String apellido = t.getApellido();
        String direccion = t.getDireccion();
        String telefono = t.getTelefono();
        String correo = t.getCorreo();
        String fax = t.getFax();
        String tabla = t instanceof Cliente ? "tcliente" : "templeado";
         Crud.select("SELECT * FROM "+tabla +" WHERE correo = '" + correo + "'");
         if(Crud.nFilas>0){
             alerta("Ya existe un Usuario con ese Correo", JOptionPane.INFORMATION_MESSAGE);
             return;
         }
      
        boolean resultado = 
                Crud.insert("insert into "+ tabla +"(nombre,apellido,telefono,fax,correo,direccion)"
                + "values (?,?,?,?,?,?)",nombre,apellido,telefono,fax,correo,direccion);
             if(resultado){
                 t.setId(buscarId(t));
                  alerta("Usuario Registrado", JOptionPane.INFORMATION_MESSAGE);
             }
             
             else          
               alerta("Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
          
        
    }

    @Override
    public void actualizar(Usuario t) {
               
                if(t.getId() == 0) t.setId(buscarId(t));
                
                if(t.getId() == 0) return;
                String nombre = t.getNombre();
                String apellido = t.getApellido();
                String telefono = t.getTelefono();
                String fax = t.getFax();
                String correo = t.getCorreo();
                String direccion = t.getDireccion();
                String tabla = t instanceof Cliente ? "tcliente" : "templeado";
                String columId = t instanceof Cliente ? "id_cliente" : "id_empleado";
                
                String sql = "update from "+ tabla +" set nombre =? , "+
                             "apellido =? , direccion = ? ,telefono =? ,"+
                             "correo = ? ,fax = ? where " + columId +" = " + t.getId();
                
                Crud.update(sql,nombre,apellido,direccion,telefono,correo,fax);
    }
    private int buscarId(Usuario t){
           int id = t.getId();
           if(t instanceof Cliente){
                  for(Cliente c : getClientes()){
                      if(c.getCorreo().equalsIgnoreCase(t.getCorreo())){
                          id = c.getId();
                          break;
                          
                      }     
                  }
             }
           else{
                    for(Empleado c : getEmpleados()){
                        if(c.getCorreo().equalsIgnoreCase(t.getCorreo())){
                          id = c.getId();
                          break;     
                      }    
                  }
             }
           
           return id;
           
    }
    @Override
    public void eliminar(Usuario t) {
        
         if(t.getId() == 0) t.setId(buscarId(t));
         
          if(t.getId() == 0) return;
          String tabla = t instanceof Cliente ? "tcliente" : "templeado";
          String columId = t instanceof Cliente ? "id_cliente" : "id_empleado";
          String sql = "delete from "+ tabla +" where "+ columId +" = " + t.getId();
          Crud.delete(sql);
         
       
    }

    @Override
    public Cliente getCliente(int id) {
        for(Cliente c : getClientes()){
           if(c.getId()== id){
               return c;
           }
          
       }
        alerta("No existe Cliente con ese Id",JOptionPane.INFORMATION_MESSAGE);
       return null;
    }
     @Override
    public Empleado getEmpleado(int id) {
        for(Empleado c : getEmpleados()){
           if(c.getId()== id){
               return c;
           }
          
       }
        alerta("No existe Empleado con ese Id",JOptionPane.INFORMATION_MESSAGE);
       return null;
    }

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> clientes=new ArrayList<>();
        ResultSet set = Crud.select("select * from tcliente");
        
        try {
            set.beforeFirst();
            while(set.next()){
                int id = set.getInt(1);
                String nombre = set.getString(2);
                String apellido =set.getString(3);
                String telefono = set.getString(4);
                String fax =set.getString(5);
                String correo = set.getString(6);
                String direccion =set.getString(7);
                Cliente c =new Cliente(nombre, apellido, telefono, fax, correo, direccion, id);
                 clientes.add(c);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return clientes;
    }
    
    @Override
    public List<Empleado> getEmpleados() {
        List<Empleado> empleados=new ArrayList<>();
        ResultSet set = Crud.select("select * from templeado");
        
        try {
            set.beforeFirst();
            while(set.next()){
                int id = set.getInt(1);
                String nombre = set.getString(2);
                String apellido =set.getString(3);
                String telefono = set.getString(4);
                String fax =set.getString(5);
                String correo = set.getString(6);
                String direccion =set.getString(7);
                Empleado e =new Empleado(nombre, apellido, telefono, fax, correo, direccion, id);
                 empleados.add(e);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return empleados;
    }
    
       private void alerta(String mensaje,int tipoMensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Aviso", tipoMensaje);
        
    }

  
    
    
}
