import java.sql.*;

public class ModificarSalarioGBM {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejjdbcgbm?useSSL=false","root","Surfer25**");
            //Recuperar argumentos del main
            String dep = args[0];
            String subida = args[1];
            //CONSULTA EMPLEADOS SIN MODIFICAR
            Statement sentencia_emple = conexion.createStatement();
            String sql_emple = "SELECT apellido,oficio,salario FROM empleados where dept_no = 30";
            ResultSet resul = sentencia_emple.executeQuery(sql_emple);
            //Recorremos el resultado para visualizar cada fila mostrando solo los empleados del departamento modificado
            while(resul.next()){
                System.out.printf("%s,%s,%s %n",
                        resul.getString(1),
                        resul.getString(2),
                        resul.getString(3));
            }
            //Construir orden INSERT
            String sql = String.format("UPDATE empleados SET salario = salario + %s WHERE dept_no = %s",subida,dep);
            System.out.println(sql);
            Statement sentencia = conexion.createStatement();
            int filas = sentencia.executeUpdate(sql);
            System.out.printf("Empleados modificados: %d %n", filas);
            //CONSULTA EMPLEADOS MODIFICADOS
            Statement sentencia_emple_modif = conexion.createStatement();
            String sql_emple_modif = "SELECT apellido,oficio,salario FROM empleados where dept_no = 30";
            ResultSet resul_modif = sentencia_emple_modif.executeQuery(sql_emple_modif);
            //Recorremos el resultado para visualizar cada fila mostrando solo los empleados del departamento modificado
            while(resul_modif.next()){
                System.out.printf("%s,%s,%s %n",
                        resul_modif.getString(1),
                        resul_modif.getString(2),
                        resul_modif.getString(3));
            }
            resul.close();//Cerramos el resultSet
            resul_modif.close();
            sentencia_emple.close();//Cerramos Statment
            sentencia_emple_modif.close();//Cerramos Statment

            sentencia.close();
            conexion.close();
        }catch (ClassNotFoundException cn){
            cn.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
