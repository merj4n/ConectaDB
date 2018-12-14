import java.io.*;
import java.util.Scanner;

public class a122GBM {
    public static final String INTRODUCE_UN_NOMBRE_DE_FICHERO = "Introduce un nombre de fichero: ";
    public static final String C_ACCESOADATOS = "C:/ACCESOADATOS/";
    public static final String INTRO_DATOS = "Introduce todo lo que quieras en el fichero, finaliza con la cadena 'adiós'.";
    public static final String ADIÓS = "adiós";
    public static final String INTRODUCE_EL_NOMBRE_DEL_FICHERO_DE_DESTINO = "Introduce el nombre del fichero de destino: ";
    public static final String EL_FICHERO_NO_EXISTE = "EL FICHERO NO EXISTE!";

    public static void main(String[] args) {
        copiarfichero();
    }
        private static void copiarfichero() {
            String nombreorigen,nombredestino, leido;
            BufferedWriter bw;
            BufferedReader br;
            System.out.println(INTRODUCE_UN_NOMBRE_DE_FICHERO);
            Scanner sc = new Scanner(System.in);
            nombreorigen = sc.next();
            System.out.println(INTRODUCE_EL_NOMBRE_DEL_FICHERO_DE_DESTINO);
            nombredestino = sc.next();
            String rutaorigen = C_ACCESOADATOS + nombreorigen;
            String rutadestino = C_ACCESOADATOS + nombredestino;

            File archivo = new File(rutaorigen);
            //File archivodestino = new File(rutadestino);
            if (!archivo.exists()) {
                System.out.println(EL_FICHERO_NO_EXISTE);
            } else {
                try {
                    br = new BufferedReader(new FileReader(rutaorigen));
                    bw = new BufferedWriter(new FileWriter(rutadestino));
                    leido = br.readLine();
                    while (leido != null) {
                        bw.write(leido);
                        bw.newLine();
                        leido = br.readLine();
                    }
                    bw.close();
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}
