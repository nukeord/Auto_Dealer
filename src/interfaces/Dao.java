/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Cliente;

/**
 *
 * @author rami
 */
public interface Dao<T> {
    
      public void registrar(T t);
    public void actualizar(T t);
    public void eliminar(T t);
    public T buscarPorId(int id);
    public List<T> obtenerTodos();
    
    
}
