import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Asignaturas implements Serializable {
    String nombre;
    String profesor;
    int horas;
    String clase;
    int id;


    public Asignaturas(String nombre, String profesor, int horas, String clase, int id){
        this.nombre=nombre;
        this.profesor=profesor;
        this.horas=horas;
        this.clase=clase;
        this.id=id;
    }
    public Asignaturas(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List LeeFichero(String fichero){
        List<Asignaturas> lista = new ArrayList<>();
        Asignaturas as = null;
        try {
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            do{
                try {
                    as = (Asignaturas) ois.readObject();
                    lista.add(as);
                } catch (ClassNotFoundException e) {

                } catch (EOFException e){
                    ois.close();
                    fis.close();
                    break;
                }
            }while (as != null);

        } catch (FileNotFoundException e) {
           // e.printStackTrace();
        } catch (IOException e) {
           // e.printStackTrace();
        }

        return lista;
    }

    public static void EscribeFichero(List<Asignaturas> lista,String fichero){

        try {
            FileOutputStream fos = new FileOutputStream(fichero);
            ObjectOutputStream oos = new ObjectOutputStream(fos);


            for (Asignaturas as:lista) {
                oos.writeObject(as);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
