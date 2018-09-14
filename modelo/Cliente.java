/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author rami
 */
public class Cliente extends Usuario{
  
    public Cliente() {
    }
     public Cliente(String nombre, String apellido, String telefono, String fax, String correo, String direccion) {
        super(nombre, apellido, telefono, fax, correo, direccion);
    }
    public Cliente(String nombre, String apellido, String telefono, String fax, String correo, String direccion, int idCliente) {
        super(nombre, apellido, telefono, fax, correo, direccion, idCliente);
    }


   

    
   
   
    

   

   
    
  
}
