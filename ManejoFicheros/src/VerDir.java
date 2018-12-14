import java.io.File;

public class VerDir {
    public static void main(String[] args) {
        String dir = "."; // Directorio actual
        File f = new File(dir); //Establece la ruta de fichero para el objeto file.
        String[] archivos=f.list(); // Almacena en un String el listado de archivos contenidos en ese directorio.
        System.out.printf("Ficheros en el directorio actual: %d %n",archivos.length);// Muestra el total de ficheros contenidos en el directorio actual
        for (int i=0;i<archivos.length;i++){ //Recorro el bucle con el maximo establecido al numero de ficheros
            File f2 = new File(f,archivos[i]);// Establece el nombre de fichero y su posicion en el array
            System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n",archivos[i],f2.isFile(),f2.isDirectory());// Muestra una salida formateada indicando si es un fichero o un directorio.
        }
    }
}
