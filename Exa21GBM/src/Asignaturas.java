import java.util.ArrayList;
import java.util.List;

public class Asignaturas {
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
}
