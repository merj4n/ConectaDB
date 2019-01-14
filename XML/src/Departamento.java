import java.io.Serializable;

public class Departamento implements Serializable {
    private int deptN;
    private String nombre;
    private String localidad;

    public Departamento(int deptN, String nombre, String localidad){
        this.deptN = deptN;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public int getDeptN() {
        return deptN;
    }

    public void setDeptN(int deptN) {
        this.deptN = deptN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
