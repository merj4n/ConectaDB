import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class act161GBM {
    public static void main(String[] args) {
        String fichero_salida="C:/Users/merjan/Desktop/Act161GBM.txt";
        String fichero_e1="C:/Users/merjan/Desktop/C1.txt";
        String fichero_e2="C:/Users/merjan/Desktop/C2.txt";
        String fichero_e3="C:/Users/merjan/Desktop/C3.txt";
        String fichero_e4="C:/Users/merjan/Desktop/C4.txt";
        String linea1,linea2,linea3,linea4;
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(fichero_e1));
            BufferedReader br2 = new BufferedReader(new FileReader(fichero_e2));
            BufferedReader br3 = new BufferedReader(new FileReader(fichero_e3));
            BufferedReader br4 = new BufferedReader(new FileReader(fichero_e4));
            FileWriter fic = new FileWriter(fichero_salida,true);
            do {
                linea1 = br1.readLine();
                linea2 = br2.readLine();
                linea3 = br3.readLine();
                linea4 = br4.readLine();
                if (linea1 != null){
                    fic.write(linea1+"\n");
                    fic.write(linea2+"\n");
                    fic.write(linea3+"\n");
                    fic.write(linea4+"\n");
                }
            }while(linea1!=null);
            br1.close();
            br2.close();
            br3.close();
            br4.close();
            fic.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
