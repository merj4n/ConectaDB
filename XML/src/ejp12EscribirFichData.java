import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ejp12EscribirFichData {
    public static void main(String[] args) throws IOException {

        List<Empleado> lista = new ArrayList<>();
        lista.add(new Empleado(1,"Martinez",12,2000.00));
        lista.add(new Empleado(2,"Sanchez",16,1500.00));
        lista.add(new Empleado(3,"Perez",12,1200.00));
        lista.add(new Empleado(4,"Marcos",14,1400.00));
        lista.add(new Empleado(5,"Albano",13,1320.00));
        lista.add(new Empleado(6,"Rondas",10,900.00));
        lista.add(new Empleado(7,"Carlae",14,2200.00));
        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile raf = new RandomAccessFile(fichero,"rw");

        //Variables sobre el tamaño de los int y tamaño del String. Además de las variables para objeto Persona
        long posicion = 0;
        int tamanyoInt = 4;
        int tamanyoString = 20;
        double tamanyoDouble=8;
        int id;
        String apellido;
        int departamento;
        double salario;

        //Nos posicionamos en la posición 0
        raf.seek(posicion);
        //Creamos un objeto StringBuffer para ajustar los textos
        StringBuffer buffer = null;
        //Recorremos la lista y guardamos cada Persona en un fichero RandomAccess
        for (Empleado p : lista) {
            //Obtenemos la id de la persona
            id = p.getId();
            //Escribimos la id de la persona en el fichero
            raf.writeInt(id);
            //Sumamos a la posición la misma posición que estamos más el tamaño del int (4 bytes)
            posicion = (posicion + tamanyoInt);
            //Nos movemos a la posición de nuevo
            raf.seek(posicion);
            //Obtenemos el nombre de la persona
            apellido = p.getApellido();
            //Creamos un StringBuffer sobre ese String
            buffer = new StringBuffer(apellido);
            //Definimos el largo del String
            buffer.setLength(10);
            //Escribimos en el archivo
            raf.writeUTF(buffer.toString());
            //Sumamos a la posición su misma posición la cual nos encontramos más el tamanyo del String
            posicion = (posicion + tamanyoString);
            //Nos movemos a la posición
            raf.seek(posicion);
            departamento = p.getDep();
            raf.writeInt(departamento);
            posicion = (posicion + tamanyoInt);
            raf.seek(posicion);
            salario = p.getSalario();
            raf.writeDouble(salario);
            posicion = (long) (posicion + tamanyoDouble);
            raf.seek(posicion);
        }
    }
}
