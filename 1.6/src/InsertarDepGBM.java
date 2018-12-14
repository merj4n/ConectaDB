import java.sql.*;

public class InsertarDepGBM {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejjdbcgbm?useSSL=false","root","Surfer25**");
            //Recuperar argumentos del main
            String dep = args[0];
            String dnombre = args[1];
            String loc =args[2];
            //Construir orden INSERT
            String sql = String.format("INSERT INTO departamentos VALUES (%s,'%s','%s')",dep,dnombre,loc);
            System.out.println(sql);
            Statement sentencia = conexion.createStatement();
            int filas = sentencia.executeUpdate(sql);
            System.out.printf("Filas afectadas: %d %n", filas);
            //Consulta
            String sql_consulta="SELECT * FROM departamentos";
            Statement sentencia_consulta = conexion.createStatement();
            sentencia_consulta.execute(sql_consulta);
            ResultSet rs = sentencia_consulta.getResultSet();

            while (rs.next()) {
                System.out.printf("%d, %s, %s %n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }

            rs.close();
            sentencia.close();
            sentencia_consulta.close();
            conexion.close();
        }catch (ClassNotFoundException cn){
            cn.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
