import java.sql.*;

public class Ejercicio2_6B {
    public static void main(String[] args) {
        try {
            //Cargar el driver
            Class.forName("org.hsqldb.jdbcDriver");
            //Establecemos la conexion con la DB
            Connection conexion = DriverManager.getConnection("jdbc:hsqldb:file:C:/DB/hsqldb/data/ejemploGBM/Empleados.sql",
                    "root",
                    "Surfer25**");
            //Preparamos la consulta
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT empleados.salario, empleados.apellido, departamentos.dnombre \n" +
                    "FROM empleados,departamentos \n" +
                    "WHERE empleados.dept_no=departamentos.dept_no\n" +
                    "AND empleados.salario=(SELECT MAX(empleados.salario) FROM empleados)";
            ResultSet resul = sentencia.executeQuery(sql);
            //Recorremos el resultado para visualizar cada fila
            while(resul.next()){
                System.out.printf("%d,%s,%s %n",
                        resul.getInt(1),
                        resul.getString(2),
                        resul.getString(3));
            }
            resul.close();//Cerramos el resultSet
            sentencia.close();//Cerramos Statment
            conexion.close();//Cerrar conexion
        }catch (ClassNotFoundException cn){
            cn.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
