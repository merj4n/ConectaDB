/**
 * Autor: Germán Belda Molina 2ºK
 * Versión: 1.0
 */

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class a210GBM {
    private static Connection conexion= conexionUp();
    public static void main(String[] args) throws SQLException {
        argument(args);
        conexion.close();
    }
    /**
     * Levanto la conexion con la base de datos.
     * @return
     */
    private static Connection conexionUp() {
        Connection conector = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejjdbcgbm?useSSL=false", "root", "Surfer25**");
            conector=conexion;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conector;
    }
    /**
     * Analizo los argumentos que le paso al inicio de la ejecución.
     * @param args
     */
    public static void argument(String[] args){

        int valor=Integer.parseInt(args[0]);

        if (valor==0){ // Para borrar
            if (numColumnas(args)=="empleados") {
                if (requisitosEmpleado(args) == false)
                borrar(args);
            } else if (numColumnas(args)=="departamentos"){
                if (requisitosDepart(args) == true)
                borrar(args);
            }

        }else if(valor==1){ // Para insertar
            if (numColumnas(args)=="empleados") {
                if (requisitosEmpleado(args) == true)
                    insertar(args);
            } else if (numColumnas(args)=="departamentos"){
                if (requisitosDepart(args) == false) {
                    insertar(args);
                }
                else {
                    System.out.println("Departamento ya existe.");
                }
            }
        } else {
            System.out.println("Primer valor no valido [" + args[0]+"].");
            System.exit(0);
        }
    }
    /**
     * Metodo que utilizo para evaluar si el numero de columnas coincide con el de argumentos.
     * @param args
     * @return
     */
    public static String numColumnas(String args[]) {

        int cont_dep = 0;
        int cont_emp = 0;
        String tabla="";

        try {
            DatabaseMetaData dbmd = conexion.getMetaData();
            ResultSet columnas_dep = dbmd.getColumns(null, null, "departamentos", null);
            ResultSet columnas_emp = dbmd.getColumns(null, null, "empleados", null);
            while (columnas_dep.next()) {
                cont_dep++;
            }
            while (columnas_emp.next()) {
                cont_emp++;
            }
            if (args.length - 1 == cont_dep) {
                tabla ="departamentos";
            } else if (args.length - 1 == cont_emp) {
                tabla ="empleados";
            } else {
                System.out.println("Numero de argumentos incorrectos.");
                System.exit(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tabla;
    }
    /**
     * Metodo para borrar tanto empleados como departamentos segun se solicite
     * @param args
     */
    private static void borrar(String args[]) {

        String sql_emp="delete from empleados where emp_no = "+args[1];
        String sql_dep="delete from departamentos where dept_no = "+args[1];

        Statement sentencia = null;
        Statement sentencia2 = null;
        try {
            if(args.length >= 6) {//Si son mas de 6 args borro de empleados.
                sentencia = conexion.createStatement();
                sentencia.execute(sql_emp);
                System.out.println(sql_emp);
                consultaTabla("empleados");
                System.out.println("------------------------------------");
                System.out.println("Empleado borrado.");
            }else { // Si son menos borro de departamentos.
                sentencia2 = conexion.createStatement();
                sentencia2.execute(sql_dep);
                System.out.println(sql_dep);
                consultaTabla("departamentos");
                System.out.println("------------------------------------");
                System.out.println("Departamento borrado.");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Metodo que verifica que se cumplen los requisitos para los empleados.
     * @param args
     * @return
     */
    private static boolean requisitosEmpleado(String[] args) {

        Statement sentencia = null;
        try {
            sentencia = conexion.createStatement();
            String sql = "SELECT emp_no,dir,fecha_alt FROM empleados";
            ResultSet resul = sentencia.executeQuery(sql);

            //Obtenemos la fecha actual.
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha_actual=sdf.format(date);

            //Recorremos el resultado para visualizar cada fila
            while (resul.next()) {
                int emp_no = resul.getInt(1);

                if ((emp_no == Integer.parseInt(args[1]))) {
                    System.out.println("El empleado existe.");
                    return false;
                }
                if (!buscandoDirector(args)) {
                    System.out.println("El director no existe.");
                    return false;
                }
                if (Integer.parseInt(args[6]) <= 0){
                    System.out.println("Salario inferior o igual a 0.");
                    return false;
                }
                if (!args[5].equals(fecha_actual)){
                    System.out.println("La fecha no es actual.");
                    return false;
                }

            }
            resul.close();//Cerramos el resultSet
            sentencia.close();//Cerramos Statment
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    /**
     * Metodo que verifica los requisitos para los departamentos.
     * @param args
     * @return
     */
        private static boolean requisitosDepart(String[] args){
            Statement sentencia = null;
            boolean existe = false;
            try {
                sentencia = conexion.createStatement();
                String sql = "SELECT dept_no FROM departamentos";
                ResultSet resul = sentencia.executeQuery(sql);
                while (resul.next()) {
                    int dept_no = resul.getInt(1);
                    if ((dept_no == Integer.parseInt(args[1]))){
                        existe = true;
                        return existe;
                    }else {
                        existe = false;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return existe;
        }
    /**
     * Metodo para insertar tanto empleados como departamentos si cumplen los requisitos.
     * @param args
     */
    private static void insertar(String[] args){


        if(numColumnas(args)=="departamentos"){ // Inserto en departamentos
            try {
                //Recuperar argumentos del main
                String dep = args[1];
                String dnombre = args[2];
                String loc = args[3];
                //Construir orden INSERT
                String sql = String.format("INSERT INTO departamentos VALUES (%s,'%s','%s')", dep, dnombre, loc);
                System.out.println(sql);
                Statement sentencia = conexion.createStatement();
                int filas = sentencia.executeUpdate(sql);
                System.out.printf("Filas afectadas: %d %n", filas);
                System.out.println("------------------------------------");
                consultaTabla("departamentos");
                sentencia.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else  if (numColumnas(args)=="empleados"){
            Statement sentencia_dir = null;
            boolean seguir=false;
            try { // Inserto en empleados.
                consultaTabla("empleados");
                //Recuperar argumentos del main
                String emp_no = args[1];
                String apellido = args[2];
                String oficio = args[3];
                String dir = args[4];
                String fecha_alt = args[5];
                String salario = args[6];
                String comision = args[7];
                String dept_no = args[8];
                //Construir orden INSERT
                String sql = String.format("INSERT INTO empleados VALUES ('%s','%s','%s','%s','%s','%s','%s','%s')",
                        emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no);
                System.out.println(sql);
                Statement sentencia = conexion.createStatement();
                int filas = sentencia.executeUpdate(sql);
                System.out.printf("Filas afectadas: %d %n", filas);
                sentencia.close();
                consultaTabla("empleados");
                System.out.println("Empleado insertado en la Base de datos.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        }
    /**
     * Metodo para mostrar los datos de tabla, tanto departamentos como empleados.
     * @param tabla
     */
    private static void consultaTabla(String tabla){

            try {
                if (tabla.equals("departamentos")) {
                    Statement sentencia = conexion.createStatement();
                    String sql_consulta = "SELECT * FROM " + tabla;
                    sentencia.execute(sql_consulta);
                    ResultSet rs = sentencia.getResultSet();
                    while (rs.next()) {
                        System.out.printf("%d, %s, %s %n", rs.getInt(1), rs.getString(2), rs.getString(3));
                    }
                }else {
                    Statement sentencia = conexion.createStatement();
                    String sql_consulta = "SELECT * FROM " + tabla;
                    sentencia.execute(sql_consulta);
                    ResultSet rs = sentencia.getResultSet();
                    System.out.println("------------------------------------");
                    while (rs.next()) {
                        System.out.printf("%d, %s, %s , %d, %s, %d, %d, %d, %n",
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getInt(4),
                                rs.getString(5),
                                rs.getInt(6),
                                rs.getInt(7),
                                rs.getInt(8));
                    }
                    System.out.println("------------------------------------"+"\n");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    /**
     * Metodo que nos devuelve mediante boolean si existe o no un director con los argumentos pasados.
     * @param args
     * @return
     */
    public static boolean buscandoDirector(String[] args){

            Statement sentencia = null;
            try {
                sentencia = conexion.createStatement();
                String sql = "SELECT emp_no FROM empleados";
                ResultSet resul = sentencia.executeQuery(sql);

                //Recorremos el resultado para visualizar cada fila
                while (resul.next()) {
                    int dir = resul.getInt(1);
                    if ((dir == Integer.parseInt(args[4]))) {
                        return true;
                    }
                }
                resul.close();//Cerramos el resultSet
                sentencia.close();//Cerramos Statment
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
    }