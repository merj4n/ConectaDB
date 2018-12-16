import java.awt.*;
import java.io.*;

public class Exa21GBM {
    public static void main(String[] args) throws IOException {

        int contador = 1;
        String nombre;
        Asignaturas inicial = null;
        File fichero = new File("C:/Users/merjan/Desktop/Asignaturas.dat");
       /* FileInputStream fis = new FileInputStream(fichero); //Lee el objeto de un fichero de datos
        DataInputStream dis = new DataInputStream(fis);
        */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
                menu.setLocation(dim.width/2-menu.getSize().width/2, dim.height/2-menu.getSize().height/2);
            }
        });
    }
}
