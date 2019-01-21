import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Exa22GBM {
    public static void main(String[] args) throws IOException {
        //obtenerventas();
        crearfDatos();
        escribirProductos();
    }

    private static void crearfDatos() throws IOException {
        List<Productos> lista;
        lista=obtenerventas();
        File fichero = new File("productos.dat");
        //RandomAccessFile raf = new RandomAccessFile(fichero,"rw");
        FileOutputStream fos = new FileOutputStream(fichero);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        //Variables sobre el tamaño de los int y tamaño del String. Además de las variables para objeto Persona
        /*long posicion = 0;
        int tamanyoInt = 4;
        int tamanyoString = 30;
        double tamanyoDouble=10;

        String codVenta;
        String producto;
        String fechaVenta;
        int unidadesVendidas;
        Double precioUnitario;
        Double precioVenta;

        //Nos posicionamos en la posición 0
        raf.seek(posicion);
        //Creamos un objeto StringBuffer para ajustar los textos
        StringBuffer buffer = null;*/
        //Recorremos la lista y guardamos cada Persona en un fichero RandomAccess
        for (Productos p : lista) {
            oos.writeObject(p);
            //Obtenemos la id de la persona
            /*codVenta = p.getCodVenta();
            raf.writeUTF(codVenta);
            buffer = new StringBuffer(codVenta);
            buffer.setLength(30);
            raf.writeUTF(buffer.toString());
            posicion = (posicion + tamanyoString);
            raf.seek(posicion);

            producto = p.getProducto();
            raf.writeUTF(producto);
            buffer = new StringBuffer(producto);
            buffer.setLength(30);
            raf.writeUTF(buffer.toString());
            posicion = (posicion + tamanyoString);
            raf.seek(posicion);

            fechaVenta = p.getFechaVenta();
            raf.writeUTF(fechaVenta);
            buffer = new StringBuffer(fechaVenta);
            buffer.setLength(30);
            raf.writeUTF(buffer.toString());
            posicion = (posicion + tamanyoString);
            raf.seek(posicion);

            unidadesVendidas = p.getUnidadesVendidas();
            raf.writeInt(unidadesVendidas);
            posicion = (posicion + tamanyoInt);
            raf.seek(posicion);

            precioUnitario = p.getPrecioUnitario();
            raf.writeDouble(precioUnitario);
            posicion = (long) (posicion + tamanyoDouble);
            raf.seek(posicion);

            precioVenta = p.getPrecioVenta();
            raf.writeDouble(precioVenta);
            posicion = (long) (posicion + tamanyoDouble);
            raf.seek(posicion);*/
            }
    }

    private static List obtenerventas() throws IOException {
        List<Productos> lista = new ArrayList<>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection
                    ("jdbc:mysql://localhost/ejemplogbm?useSSL=false","root","Surfer25**");
            //Consulta
            String sql_consulta="select v.codVenta,p.Nombre producto,v.FechaVenta fechaVenta,v.UnidadesVendidas unidadesVendidas,p.PrecioUnitario precioUnitario,p.PrecioUnitario*v.UnidadesVendidas precioVenta from productos p,ventas v where p.CodProducto=v.CodProducto;";
            Statement sentencia_consulta = conexion.createStatement();
            sentencia_consulta.execute(sql_consulta);
            ResultSet rs = sentencia_consulta.getResultSet();

            while (rs.next()) {
                lista.add(new Productos(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getInt(4),rs.getDouble(5),rs.getDouble(6)));
            }
            rs.close();
            sentencia_consulta.close();
            conexion.close();

            for (Productos pr:lista){
                System.out.printf("codVenta: %s, Producto: %s,fechaVenta: %s, unidadesVendidas: %d, precioUnitario: %.1f, precioVenta: %.1f %n", pr.getCodVenta(),pr.getProducto(),pr.getFechaVenta(),pr.getUnidadesVendidas(),pr.getPrecioUnitario(),pr.getPrecioVenta());
            }

        }catch (ClassNotFoundException cn){
            cn.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    static class creadorxml {
        public static class ListaProductos {
            private List<Productos> lista = new ArrayList<>();

            public ListaProductos() {
            }

            public void add(Productos pr) {
                lista.add(pr);
            }

            public List<Productos> getListaProductos() {
                return lista;
            }
        }
    }
    public static void escribirProductos() throws IOException {

            File fichero = new File("productos.dat");
            FileInputStream filein = new FileInputStream(fichero);
            ObjectInputStream dataIS = new ObjectInputStream(filein);

            System.out.println("Comienza el proceso...");
            //Creamos un objeto Lista de Personas
            creadorxml.ListaProductos listaper = new creadorxml.ListaProductos();
            try{
                while (true){
                    Productos pr = (Productos) dataIS.readObject();
                    listaper.add(pr);
                }
            }catch (EOFException eo){} catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            dataIS.close();
            try{
                XStream xstream = new XStream();
                //Cambiar de nombre a las etiquetas XML
                xstream.alias("ListaVentas", creadorxml.ListaProductos.class);
                xstream.alias("Ventas",Productos.class);
                //quitar etiqueta lista
                xstream.addImplicitCollection(creadorxml.ListaProductos.class,"lista");
                //Insertar los objetos en el XML
                xstream.toXML(listaper,new FileOutputStream("ventasGBM.xml"));
            }catch (Exception e){
                e.printStackTrace();
            }

    }
}

