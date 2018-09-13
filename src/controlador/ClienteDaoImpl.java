/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Crud;
import interfaces.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ClienteDaoImpl implements Dao<Cliente>{
    
    
    
    private void alerta(String mensaje,int tipoMensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Aviso", tipoMensaje);
        
    }

    @Override
    public void registrar(Cliente t) {
        String nombre = t.getNombre();
        String apellido = t.getApellido();
        String direccion = t.getDireccion();
        String telefono = t.getTelefono();
        String correo = t.getCorreo();
        String fax = t.getFax();
        boolean resultado = 
                Crud.insert("insert into tcliente(nombre,apellido,telefono,fax,correo,direccion)"
                + "values (?,?,?,?,?,?)",nombre,apellido,telefono,fax,correo,direccion);
             if(resultado)
              alerta("Cliente Registrado", JOptionPane.INFORMATION_MESSAGE);
             else          
               alerta("Ha ocurrido un error inesperado", JOptionPane.ERROR_MESSAGE);
          
        
    }

    @Override
    public void actualizar(Cliente t) {
                int id = t.getIdCliente();
                String nombre = t.getNombre();
                String apellido = t.getApellido();
                String telefono = t.getTelefono();
                String fax = t.getFax();
                String correo = t.getCorreo();
                String direccion = t.getDireccion();
                String sql = "update from tcliente set nombre =? , "+
                             "apellido =? , direccion = ? ,telefono =? ,"+
                             "correo = ? ,fax = ? where id = " + id;
                
                Crud.update(sql,nombre,apellido,direccion,telefono,correo,fax);
    }

    @Override
    public void eliminar(Cliente t) {
          int id = t.getIdCliente();
        String sql = "delete from tcliente where id " + id;
        Crud.delete(sql);
    }

    @Override
    public Cliente buscarPorId(int id) {
        for(Cliente e : obtenerTodos()){
           if(e.getIdCliente()== id){
               return e;
           }
          
       }
        JOptionPane.showMessageDialog(null, "No existe Cliente con ese Id","Aviso",JOptionPane.INFORMATION_MESSAGE);
       return null;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        List<Cliente> clientes=new ArrayList<>();
        ResultSet set = Crud.select("select * from tcliente");
        
        try {
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
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return clientes;
    }
    
  
    
}
