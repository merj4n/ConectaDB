import java.io.File;
import java.util.Scanner;

public class Act11GBM {
    public static void main(String[] args) {

        if (args.length<=0){
            System.out.println("Introduce la ruta a analizar: ");
            Scanner sc = new Scanner(System.in);
            String dir=sc.next();
            muestraDirectorioInicialesAlumno(dir);
        }else {
            muestraDirectorioInicialesAlumno(args[0]);
        }
    }

    private static void muestraDirectorioInicialesAlumno(String arg) {
        File f = new File(arg);
        String[] archivos=f.list();
        System.out.printf("Ficheros en el directorio actual: %d %n",archivos.length);
        for (int i=0;i<archivos.length;i++){
            File f2 = new File(f,archivos[i]);
            System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n",archivos[i],f2.isFile(),f2.isDirectory());
        }
    }
}
