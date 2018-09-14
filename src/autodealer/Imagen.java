/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autodealer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rami
 */
public class Imagen {
    
    
    
    public static void guardarImagen(String urlImagen, String nombreArchivo) {
            OutputStream salida = null;
            InputStream entrada = null;
            String ruta = "/src/images/autos/";
            try {
                
                File c = new File(ruta);
                if(!c.exists())c.mkdir();
                String destino = System.getProperty("user.dir")+ ruta + nombreArchivo;
                       System.out.println(destino);
                URL url = new URL(urlImagen);
                entrada = url.openStream();
               
                salida = new FileOutputStream(destino);
                byte[] b = new byte[2048];
                int length;
                while ((length = entrada.read(b)) != -1) {
                    salida.write(b, 0, length);
                }
                entrada.close();
                salida.close();
            } catch (IOException ex) {
                 
                  JOptionPane.showMessageDialog(null, ex.getMessage());
            }finally{
                try {
                    entrada.close();
                    salida.close();
                } catch (IOException ex) {
                    Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	}
    public static List<String> getRutaImagenesAutos(){
       
        List<String> lista = new ArrayList<>();
           File[] z = new File(System.getProperty("user.dir")+"/src/images/autos").listFiles();
        for(File x : z){
            if(x.isFile())
           lista.add(x.getPath());
        }
        
        return lista;
    }
}
