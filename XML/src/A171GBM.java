import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class A171GBM {
    public static void main(String[] args) throws IOException {
        obtenerdatos();
    }

    private static void obtenerdatos() throws IOException {
        List<Departamento> lista = new ArrayList<>();
        File fichero = new File("departObjGBM.dat");
        FileOutputStream fos = new FileOutputStream(fichero);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemplogbm?useSSL=false","root","Surfer25**");
            //Consulta
            String sql_consulta="SELECT * FROM depart";
            Statement sentencia_consulta = conexion.createStatement();
            sentencia_consulta.execute(sql_consulta);
            ResultSet rs = sentencia_consulta.getResultSet();

            while (rs.next()) {
                lista.add(new Departamento(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }
            rs.close();
            sentencia_consulta.close();
            conexion.close();

            for (Departamento per:lista) {
                oos.writeObject(per); // Escribo las personas en el fichero de datos.
            }
            oos.close();
        }catch (ClassNotFoundException cn){
            cn.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

class creadorXML {
    public static class ListaEmpleados {
        private List<Departamento> lista = new ArrayList<>();

        public ListaEmpleados() {
        }

        public void add(Departamento per) {
            lista.add(per);
        }

        public List<Departamento> getListaEmpleados() {
            return lista;
        }
    }
}

class EscribirPersonas{
        public static void main(String[] args) throws IOException {
            File fichero = new File("departObjGBM.dat");
            FileInputStream filein = new FileInputStream(fichero);
            ObjectInputStream dataIS = new ObjectInputStream(filein);

            System.out.println("Comienza el proceso...");

            //Creamos un objeto Lista de Personas
            creadorXML.ListaEmpleados listaper = new creadorXML.ListaEmpleados();

            try{
                while (true){
                    Departamento persona = (Departamento) dataIS.readObject();
                    listaper.add(persona);
                }
            }catch (EOFException eo){} catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            dataIS.close();

            try{
                XStream xstream = new XStream();
                //Cambiar de nombre a las etiquetas XML
                xstream.alias("ListaDepartamentos", creadorXML.ListaEmpleados.class);
                xstream.alias("DatosDepartamento",Persona.class);
                //quitar etiqueta lista
                xstream.addImplicitCollection(creadorXML.ListaEmpleados.class,"lista");
                //Insertar los objetos en el XML
                xstream.toXML(listaper,new FileOutputStream("departGBM.xml"));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

class LeerDepartamentos{
    public static void main(String[] args) throws FileNotFoundException {
        XStream xstream = new XStream();

        xstream.alias("ListaDepartamentos", creadorXML.ListaEmpleados.class);
        xstream.alias("DatosDepartamento",Persona.class);
        xstream.addImplicitCollection(creadorXML.ListaEmpleados.class,"lista");
        creadorXML.ListaEmpleados listadotodas = (creadorXML.ListaEmpleados) xstream.fromXML(new FileInputStream("departGBM.xml"));

        System.out.println("Numero de departamentos : " + listadotodas.getListaEmpleados().size());
        List<Departamento> listaPersonas = new ArrayList<>();
        listaPersonas = listadotodas.getListaEmpleados();

        Iterator iterador = listaPersonas.listIterator();
        while (iterador.hasNext()){
            Departamento p = (Departamento) iterador.next();
            System.out.printf("Numero: %d, Nombre: %s, Localidad: %s %n", p.getDeptN(),p.getNombre(),p.getLocalidad());
        }
        System.out.println("Fin de listado...");
    }
}