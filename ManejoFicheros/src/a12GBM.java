import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class a12GBM {
    public static void main(String[] args) throws IOException {
        //declara fichero
        File fichero = new File("C:/ACCESOADATOS/villancico.txt");
        //crea el flujo de entrada hacia el fichero
        FileReader fic = new FileReader(fichero);
        int i;
        char b[] = new char[1];
        while ((i=fic.read(b)) != -1) // se va leyendo un caracter
            System.out.print(b);
        fic.close(); //cerrar fichero
    }
}
