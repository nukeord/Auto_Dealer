/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Usuario;

/**
 *
 * @author rami
 */
public interface Dao {
    
      public void registrar(Usuario user);
    public void actualizar(Usuario user);
    public void eliminar(Usuario user);
    public Cliente getCliente(int id);
    public Empleado getEmpleado(int id);
    public List<Cliente> getClientes();
    public List<Empleado> getEmpleados();
    
    
    
}
