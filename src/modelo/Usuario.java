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
public abstract class Usuario {
     private String nombre,apellido,telefono,fax,correo,direccion;   
     private int id;
       
    public Usuario() {
    }
    public Usuario(String nombre, String apellido, String telefono, String fax, String correo, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fax = fax;
        this.correo = correo;
        this.direccion = direccion;
       
    }
    public Usuario(String nombre, String apellido, String telefono, String fax, String correo, String direccion, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fax = fax;
        this.correo = correo;
        this.direccion = direccion;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
      
    
 
    
    
}
