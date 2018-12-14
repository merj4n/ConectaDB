import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class a121GBM {

    public static final String INTRODUCE_UN_NOMBRE_DE_FICHERO = "Introduce un nombre de fichero: ";
    public static final String C_ACCESOADATOS = "C:/ACCESOADATOS/";
    public static final String FICHERO_YA_EXISTE = "Fichero ya existe";
    public static final String INTRO_DATOS = "Introduce todo lo que quieras en el fichero, finaliza con la cadena 'adiós'.";
    public static final String ADIÓS = "adiós";

    public static void main(String[] args) {
        generarfichero();
    }

    private static void generarfichero() {
    String nombre,leido;
    BufferedWriter bw;
        System.out.println(INTRODUCE_UN_NOMBRE_DE_FICHERO);
        Scanner sc = new Scanner(System.in);
        nombre=sc.next();
        String ruta= C_ACCESOADATOS +nombre;

        File archivo = new File(ruta);
        if (archivo.exists()){
            System.out.println(FICHERO_YA_EXISTE);
        }else {
            try {
                bw = new BufferedWriter(new FileWriter(ruta));
                System.out.println(INTRO_DATOS);
                do{
                    leido = sc.nextLine();
                    if (!leido.contains(ADIÓS)) {
                        bw.write(leido);
                        bw.newLine();
                    }
                }while (!leido.contains(ADIÓS));
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
