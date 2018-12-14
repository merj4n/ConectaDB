import java.sql.*;


public class MainGBM {

    private static final String PATH="C:/DB/scriptmysql.sql";

    public static void main(String[] args) {
        Consulta.ejecutarScriptMySQL(PATH);

        // --- Listar los nombres de las tablas de la base de datos ---
        ResultSet resultSet = null;
        String[] types = { "TABLE" };
        try {
            resultSet = Consulta.conexionUp().getMetaData().getTables("ejemploGBM", null, "%", types);
            String tableName = "";
            while (resultSet.next()) {
                tableName = resultSet.getString(3);
                Consulta.mostrarTabla(tableName);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
