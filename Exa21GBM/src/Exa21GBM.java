import java.awt.*;
import java.io.*;

public class Exa21GBM {
    public static void main(String[] args){
        String path="Asignaturas.dat";
        File fichero = new File(path);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                MenuPrincipal menu = null;

                try {
                    menu = new MenuPrincipal();
                    menu.setTitle("Gestor Asignaturas");
                    menu.setVisible(true);
                    menu.setLocation(dim.width/2-menu.getSize().width/2, dim.height/2-menu.getSize().height/2);
                    Asignaturas.LeeFichero(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
