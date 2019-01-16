import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class A172GBM {
    public static void main(String[] args) throws IOException {
        obtenerdatos();
    }

    private static void obtenerdatos() throws IOException {
        List<Emplea> lista = new ArrayList<>();
        List<Emplea> lista2 = new ArrayList<>();
        File fichero = new File("empleadosGBM.dat");
        FileOutputStream fos = new FileOutputStream(fichero);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemplogbm?useSSL=false","root","Surfer25**");
            //Consulta
            String sql_consulta="SELECT e.EMP_NO as emp_no, e.apellido, e.oficio, e2.apellido as dir, e.fecha_alt, e.salario, e.comision, e.dept_no \n" +
                    "FROM emple e left join emple e2 on e2.emp_no = e.dir\n" +
                    ";";
            Statement sentencia_consulta = conexion.createStatement();
            sentencia_consulta.execute(sql_consulta);
            ResultSet rs = sentencia_consulta.getResultSet();

            while (rs.next()) {
                lista.add(new Emplea(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6),rs.getInt(7),rs.getInt(8)));
            }
            rs.close();
            sentencia_consulta.close();
            conexion.close();

            for (Emplea em:lista) {
                oos.writeObject(em); // Escribo las personas en el fichero de datos.
            }
            oos.close();
        }catch (ClassNotFoundException cn){
            cn.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

class creadorxml {
    public static class ListaEmple {
        private List<Emplea> lista = new ArrayList<>();

        public ListaEmple() {
        }

        public void add(Emplea em) {
            lista.add(em);
        }

        public List<Emplea> getListaEmple() {
            return lista;
        }
    }
}

class EscribirEmpleados {
    public static void main(String[] args) throws IOException {
        File fichero = new File("empleadosGBM.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);

        System.out.println("Comienza el proceso...");

        //Creamos un objeto Lista de Personas
        creadorxml.ListaEmple listaper = new creadorxml.ListaEmple();

        try{
            while (true){
                Emplea emp = (Emplea) dataIS.readObject();
                listaper.add(emp);
            }
        }catch (EOFException eo){} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dataIS.close();

        try{
            XStream xstream = new XStream();
            //Cambiar de nombre a las etiquetas XML
            xstream.alias("ListaEmple", creadorxml.ListaEmple.class);
            xstream.alias("Emple",Persona.class);
            //quitar etiqueta lista
            xstream.addImplicitCollection(creadorxml.ListaEmple.class,"lista");
            //Insertar los objetos en el XML
            xstream.toXML(listaper,new FileOutputStream("empleGBM.xml"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class LeerEmpleados {
    public static void main(String[] args) throws FileNotFoundException {
        XStream xstream = new XStream();

        xstream.alias("ListaEmple", creadorxml.ListaEmple.class);
        xstream.alias("Emple",Emplea.class);
        xstream.addImplicitCollection(creadorxml.ListaEmple.class,"lista");
        creadorxml.ListaEmple listadotodas = (creadorxml.ListaEmple) xstream.fromXML(new FileInputStream("empleGBM.xml"));

        System.out.println("Numero de empleados : " + listadotodas.getListaEmple().size());
        List<Emplea> listaempleados = new ArrayList<>();
        listaempleados = listadotodas.getListaEmple();

        Iterator iterador = listaempleados.listIterator();
        while (iterador.hasNext()){
            Emplea p = (Emplea) iterador.next();
            System.out.printf("Numero: %d, Nombre: %s, Localidad: %s %n", p.getEmp_no(),p.getApellido(),p.getDir());
        }
        System.out.println("Fin de listado...");
    }
}