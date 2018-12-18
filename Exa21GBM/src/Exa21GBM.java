import java.awt.*;
import java.io.*;

public class Exa21GBM {
    public static void main(String[] args){

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                MenuPrincipal menu = null;
                try {
                    menu = new MenuPrincipal();
                    menu.setVisible(true);
                    menu.setLocation(dim.width/2-menu.getSize().width/2, dim.height/2-menu.getSize().height/2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
