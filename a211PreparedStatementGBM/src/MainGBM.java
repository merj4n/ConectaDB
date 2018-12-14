import java.sql.*;

public class MainGBM {
    public static void main(String[] args) {
        PreparedStatement psSelect = null;
            try {
                // Creamos el PreparedStatement si no estaba ya creado.
                String sql = "select al.DNI DNI,al.APENOM NOMBRE,al.DIREC DIRECCIÓN,al.POBLA POBLACIÓN,al.TELEF TELEFONO,asg.COD CÓDIGO,nt.NOTA NOTA \n" +
                        "from alumnos al inner join asignaturas asg join notas nt on asg.COD = nt.COD and al.dni = nt.dni \n" +
                        "where asg.cod= ?";
                psSelect = conexionUp().prepareStatement(sql);
                psSelect.setInt(1, Integer.parseInt(args[0]));
                ResultSet rs = psSelect.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                int contadorAlum=0;
                int notas=0;
                    if (rs.next()) {
                        rs.beforeFirst(); //Vuelvo al primer valor del rs.next
                        while (rs.next()) {
                            for (int i = 1; i <= columnsNumber; i++) {
                                if (i > 1) System.out.print(",  ");
                                String columnValue = rs.getString(i);
                                System.out.print(columnValue + " " + rsmd.getColumnName(i));
                            }
                            notas+=rs.getInt(7);
                            contadorAlum++;
                            System.out.println("");
                        }
                        int media=notas/contadorAlum;
                        System.out.println("Numero de alumnos: "+contadorAlum+", Nota media: "+media);
                    }else {
                        System.out.println("NO EXISTE EL ALUMNO");
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
        }
        public static Connection conexionUp() {
        Connection conector = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemploGBM?useSSL=false", "root", "Surfer25**");
            conector=conexion;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conector;
    }
}
