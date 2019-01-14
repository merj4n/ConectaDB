import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.thoughtworks.xstream.XStream;

public class mapeadoaxmlGBM {
    public static class ListaPersonas {
        private List<Persona> lista = new ArrayList<>();

        public ListaPersonas(){}

        public void add(Persona per){
            lista.add(per);
        }
        public List<Persona> getListaPersonas(){
            return lista;
        }
    }
    /*public static class EscribirPersonas{
        public static void main(String[] args) throws IOException {
            File fichero = new File("personaSerial.dat");
            FileInputStream filein = new FileInputStream(fichero);
            ObjectInputStream dataIS = new ObjectInputStream(filein);

            System.out.println("Comienza el proceso...");

            //Creamos un objeto Lista de Personas
            ListaPersonas listaper = new ListaPersonas();

            try{
                while (true){
                    Persona persona = (Persona) dataIS.readObject();
                    listaper.add(persona);
                }
            }catch (EOFException eo){} catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            dataIS.close();

            try{
                XStream xstream = new XStream();
                //Cambiar de nombre a las etiquetas XML
                xstream.alias("ListaPersonasMunicipio",ListaPersonas.class);
                xstream.alias("DatosPersona",Persona.class);
                //quitar etiqueta lista
                xstream.addImplicitCollection(ListaPersonas.class,"lista");
                //Insertar los objetos en el XML
                xstream.toXML(listaper,new FileOutputStream("Personas.xml"));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }*/
    public static class LeerPersonas{
        public static void main(String[] args) throws FileNotFoundException {
            XStream xstream = new XStream();

    xstream.alias("ListaPersonasMunicipio",ListaPersonas.class);
    xstream.alias("DatosPersona",Persona.class);
    xstream.addImplicitCollection(ListaPersonas.class,"lista");
    ListaPersonas listadotodas = (ListaPersonas) xstream.fromXML(new FileInputStream("Personas.xml"));

            System.out.println("Numero de personas : " + listadotodas.getListaPersonas().size());
            List<Persona> listaPersonas = new ArrayList<>();
            listaPersonas = listadotodas.getListaPersonas();

            Iterator iterador = listaPersonas.listIterator();
            while (iterador.hasNext()){
                Persona p = (Persona) iterador.next();
                System.out.printf("Nombre: %s, edad: %d %n", p.getNombre(),p.getEdad());
            }
            System.out.println("Fin de listado...");
        }
    }
}
