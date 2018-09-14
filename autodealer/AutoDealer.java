package autodealer;

import conexion.conexion;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vistas.Cargando;
import vistas.Login;

public class AutoDealer {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AutoDealer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AutoDealer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AutoDealer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AutoDealer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Cargando c = new Cargando();
        c.setLocationRelativeTo(null);
        c.setVisible(true);
        conexion con = conexion.getInstance();
        c.dispose();
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        
    }
    
}
