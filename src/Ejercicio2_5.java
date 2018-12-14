import java.sql.*;

public class Ejercicio2_5 {
    public static void main(String[] args) {
        try {
            //Cargar el driver
            Class.forName("org.hsqldb.jdbcDriver");
            //Establecemos la conexion con la DB
            Connection conexion = DriverManager.getConnection("jdbc:hsqldb:file:C:/DB/hsqldb/data/ejemploGBM/ejemploGBM");
            //Preparamos la consulta
            Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM empleados";
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
