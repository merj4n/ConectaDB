import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class pltreadsaxGBM {

    public static void main(String[] args) throws SAXException, IOException {

        //Creacion del objeto que procesa el XML
        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        //Indicamos al procesador los objetos que tratan el evento.
        GestionContenido gestor = new GestionContenido();
        procesadorXML.setContentHandler(gestor);
        //Definimos el fichero a leer
        InputSource fileXML = new InputSource("Empleados.xml");
        // Iniciamos el parser
        procesadorXML.parse(fileXML);
    }


    private static class GestionContenido extends DefaultHandler{
    public GestionContenido(){
        super();
    }
    public void startDocumet(){
        System.out.println("Comienzo del documento XML");
    }
    public void endDocument(){
        System.out.println("Final del documento XML.");
    }
    public void startElement(String uri, String nombre, String nombreC,Attributes atts){
        System.out.printf("\tPrincipio Elemento: %s %n",nombre);
    }
    public void endElement(String uri, String nombre, String nombreC){
        System.out.printf("\tFin Elemento: %s %n",nombre);
    }
    public void characters(char[] ch,int inicio,int longitud){
        String car= new String(ch,inicio,longitud);
        //quitar saltos de linea
        car = car.replaceAll("[\t\n]","");
        System.out.printf("", "\tCaracteres: %s %n",car);
    }
    }
}
