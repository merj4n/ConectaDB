public class Empleado {

    private int id;
    private String apellido;
    private int dep;
    private Double salario;

    public Empleado(int id, String apellido, int dep, Double salario){
        this.id=id;
        this.apellido=apellido;
        this.dep=dep;
        this.salario=salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDep() {
        return dep;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
