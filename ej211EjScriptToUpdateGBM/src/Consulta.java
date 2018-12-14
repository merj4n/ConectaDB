import java.io.*;
import java.sql.*;

public class Consulta {

    public static void ejecutarScriptMySQL(String pathNombreFichero) {

        File scriptFile = new File(pathNombreFichero);
        System.out.println("\n\nFichero de consulta : " + scriptFile.getName());
        System.out.println("Convirtiendo el fichero a cadena...");
        BufferedReader entrada = null;
        try{
            entrada = new BufferedReader(new FileReader(scriptFile));
        }catch (FileNotFoundException e){
            System.out.println("ERROR NO HAY FILE: " + e.getMessage());
        }
        String linea = null;
        StringBuilder stringBuilder = new StringBuilder();
        String salto = System.getProperty("line.separator");
        try{
            while ((linea = entrada.readLine()) != null){
                stringBuilder.append(linea);
                stringBuilder.append(salto);
            }
        } catch (IOException e){
            System.out.println("ERROR de E/S, al operar " + e.getMessage());
        }
        String consulta = stringBuilder.toString();
        System.out.println(consulta);
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("ERROR Driver:" + e.getMessage());
        }
        try {
            Connection connmysql = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemploGBM?allowMultiQueries=true&useSSL=false", "root", "Surfer25**");
            Statement sents = connmysql.createStatement();
            int res = sents.executeUpdate(consulta);
            System.out.println("Script creado con éxito, res = " + res);
            connmysql.close();
            sents.close();
        }catch (SQLException e){
            System.out.println("ERROR AL EJECUTAR EL SCRIPT: " + e.getMessage());
        }
    }

    public static void mostrarTabla(String tabla){
        Connection conexion= conexionUp();
        System.out.println("------------------------------------"+"\n");
        Statement st = null;
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery("select * from " + tabla);
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumnas = rsmd.getColumnCount();

            while (rs.next()) {
                for(int i = 1; i <= numColumnas; i++)
                    System.out.print(rs.getString(i) + " ");
                    System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
