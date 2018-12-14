import java.sql.*;

public class ProcyFunc {
    public static void crearProcedimientos() {
        Statement call1 = null;
        Statement call2 = null;
        Statement call3 = null;

        try {
            String proc1 = "drop procedure if exists subirNota;\n"+
                    "create procedure subirNota (codigo int, subida int, out valor varchar(15))\n" +
                    "begin\n" +
                    "set valor = 'INEXISTENTE';\n" +
                    "update notas set nota = nota + subida where cod = codigo;\n" +
                    "select cod into valor from notas where cod = codigo and cod = cod limit 1;\n" +
                    "commit;\n" +
                    "end;\n";
            String func1 ="SET GLOBAL log_bin_trust_function_creators = 1;\n"+ //Para el error 1418 de MySql
                    "drop function if exists nombreAsignatura;\n" +
                    "create function nombreAsignatura (codigo int) returns varchar(30) \n" +
                    "begin\n" +
                    "declare asignatura varchar(30);\n" +
                    "set asignatura ='INEXISTENTE';\n" +
                    "select nombre into asignatura from asignaturas where cod = codigo;\n" +
                    "return asignatura;\n" +
                    "end;\n";
            String proc2 = "drop procedure if exists datosAlumno;\n" +
                    "create procedure datosAlumno (dniIn varchar(10), out apenomOut varchar(30), out telefOut varchar(12))\n" +
                    "begin\n" +
                    "set apenomOut = 'INEXISTENTE';\n" +
                    "set telefOut = 'INEXISTENTE';\n" +
                    "select apenom, telef into apenomOut,telefOut from alumnos where dni = dniIn;\n" +
                    "commit;\n" +
                    "end;\n";
            call1 = conexionUp().createStatement();
            call1.execute(proc1);
            call2 = conexionUp().createStatement();
            call2.execute(proc2);
            call3 = conexionUp().createStatement();
            call3.execute(func1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (call1 != null) {
                try {
                    call1.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (call2 != null) {
                try {
                    call2.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (call3 != null) {
                try {
                    call3.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }

    public static Connection conexionUp() {
        Connection conector = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemploGBM?allowMultiQueries=true&useSSL=false", "root", "Surfer25**");
            conector=conexion;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conector;
    }
}
