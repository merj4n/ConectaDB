import java.sql.*;

public class CreateViewGBM {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejjdbcgbm?useSSL=false", "root", "Surfer25**");

            // Construir orden CREATE VIEW
            StringBuilder sql = new StringBuilder();
            sql.append("CREATE OR REPLACE VIEW totales ");
            sql.append("(dep, dnombre, nemp, media) AS ");
            sql.append("SELECT d.dept_no, dnombre, COUNT(emp_no), AVG(salario) ");
            sql.append("FROM departamentos d LEFT JOIN empleados e " );
            sql.append("ON e.dept_no = d.dept_no ");
            sql.append("GROUP BY d.dept_no, dnombre ");
            System.out.println(sql);

            Statement sentencia = conexion.createStatement();
            int filas = sentencia.executeUpdate(sql.toString());
            System.out.printf("Resultado de la ejecución: %d %n", filas);

            //Consulta
            String sql_consulta="SELECT * FROM totales";
            Statement sentencia_consulta = conexion.createStatement();
            sentencia_consulta.execute(sql_consulta);
            ResultSet rs = sentencia_consulta.getResultSet();

            while (rs.next()) {
                System.out.printf("%s, %s, %d, %s %n", rs.getString(1), rs.getString(2),rs.getInt(3), rs.getString(4));
            }

            rs.close();

            sentencia.close();
            conexion.close();

        }catch (ClassNotFoundException cl){
            cl.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
