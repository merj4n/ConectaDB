import java.io.File;
import java.io.IOException;

public class CrearDir {
    public static void main(String[] args) {
        File d = new File("C:/ACCESOADATOS");//directorio que creo
        File f1 = new File(d,"GermanGBM1.TXT"); //Fichero 1 que creo
        File f2 = new File(d,"GermanGBM2.TXT"); //Fichero 2 que creo

        d.mkdir();//CREAR DIRECTORIO

        try {
            if (f1.createNewFile())
                //Nos informa si se ha creado el fichero correctamente o no
                System.out.println("GermanGBM1 creado correctamente...");
            else
                System.out.println("No se ha podido crear GermanGBM1...");
            if (f2.createNewFile())
                System.out.println("GermanGBM2 creado correctamente...");
            else
                System.out.println("No se ha podido crear GermanGBM2...");

        }catch (IOException ioe){ //Previene posibles errores de escritura o acceso
            ioe.printStackTrace();
        }
        f1.renameTo(new File(d,"GermanGBM1Renombrado.TXT"));//renombro FICHERO1
        try {
            File f3 = new File("C:/ACCESOADATOS/GermanGBM1GBM2.TXT");
            f3.createNewFile();//crea FICHERO3 en NUEVODIR
            if (f3.delete()) //borrado del fichero 3
                System.out.println("Fichero borrado...");
            else
                System.out.println("No se ha podido borrar el fichero...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
