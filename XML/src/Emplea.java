import java.io.Serializable;
import java.util.Date;

public class Emplea implements Serializable {
    private int emp_no;
    private String apellido;
    private String oficio;
    private String dir;
    private String fecha_alt;
    private int salario;
    private int comision;
    private String dept_no;

    public Emplea(int emp_no, String apellido, String oficio, String dir, String fecha_alt, int salario, int comision, String dept_no){

        this.emp_no=emp_no;
        this.apellido=apellido;
        this.oficio=oficio;
        this.dir=dir;
        this.fecha_alt=fecha_alt;
        this.salario=salario;
        this.comision=comision;
        this.dept_no=dept_no;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getFecha_alt() {
        return fecha_alt;
    }

    public void setFecha_alt(String fecha_alt) {
        this.fecha_alt = fecha_alt;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }
}


