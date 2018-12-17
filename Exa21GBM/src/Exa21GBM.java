import java.awt.*;
import java.io.*;

public class Exa21GBM {
    public static void main(String[] args) throws IOException {
        String path="C:/Users/merjan/Desktop/Asignaturas.dat";
        File fichero = new File(path);
        FileInputStream fis = new FileInputStream(fichero); //Lee el objeto de un fichero de datos
        FileOutputStream fos = new FileOutputStream(fichero);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ObjectInputStream ois = new ObjectInputStream(fis);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                MenuPrincipal menu = null;
                    menu = new MenuPrincipal();
                    menu.setVisible(true);
                    menu.setLocation(dim.width/2-menu.getSize().width/2, dim.height/2-menu.getSize().height/2);
            }
        });
    }
}
