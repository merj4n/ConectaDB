import java.sql.*;

public class ConsultaCallable {
    public static void subirNota(String[] args) {
        String asignatura = args[0];
        String subirNota = args[1];


        String sql = "{ call subirNota(?,?,?) }";
        try {
            CallableStatement llamada = ProcyFunc.conexionUp().prepareCall(sql);
            llamada.setInt(1, Integer.parseInt(asignatura));
            llamada.setInt(2, Integer.parseInt(subirNota));
            llamada.registerOutParameter(3, Types.ARRAY);
            llamada.executeUpdate();
            llamada.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static String nombreAsignatura(String[] args){
            String asignatura = args[0];
            String sql2 = "{? = call nombreAsignatura(?)}";
            try {
                CallableStatement llamada = ProcyFunc.conexionUp().prepareCall(sql2);
                llamada.registerOutParameter(1, Types.ARRAY);
                llamada.setInt(2, Integer.parseInt(asignatura));
                llamada.executeUpdate();
                String nombre = llamada.getString(1);
                llamada.close();
                return nombre;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "-1";
        }

    public static void mostrarAsignatura(String[] args){
        PreparedStatement psSelect = null;

        String sqldni="select dni from notas where cod = ?;";
        try {
            psSelect = ProcyFunc.conexionUp().prepareStatement(sqldni);
            psSelect.setInt(1, Integer.parseInt(args[0]));
            ResultSet rs = psSelect.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = rs.getString(i);
                    String sql3="{ call datosAlumno(?,?,?) }";
                    CallableStatement llamada = null;
                    try {
                        llamada = ProcyFunc.conexionUp().prepareCall(sql3);
                        llamada.setInt(1,Integer.parseInt(columnValue));
                        llamada.registerOutParameter(2, Types.ARRAY);
                        llamada.registerOutParameter(3, Types.ARRAY);
                        llamada.executeUpdate();
                        System.out.println(nombreAsignatura(args)+"  "+llamada.getString(2)+"  "+llamada.getString(3));
                        llamada.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
