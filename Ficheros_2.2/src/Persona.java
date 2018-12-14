import java.io.Serializable;

public class Persona implements Serializable {
    private int id;
    private String nombre;
    private String profesion;
    private int edad;

    public Persona(int id, String nombre, String profesion, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.profesion = profesion;
        this.edad = edad;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}