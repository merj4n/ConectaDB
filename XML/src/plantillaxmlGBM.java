
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class plantillaxmlGBM {
    public static void main(String[] args) throws IOException {

        File fichero = new File("AleatorioEmple.dat");
        RandomAccessFile raf = new RandomAccessFile(fichero,"r");
        int id,dep,posicion=0; //para situarnos al principio del fichero.
        double salario;
        String apellido,aux;
        int tamanyoInt = 4;
        int tamanyoString = 20;
        double tamanyoDouble=8;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder(); // Creacion del parse

            DOMImplementation implementation = builder.getDOMImplementation(); //Creacion del documento XML
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0"); //Asignamos la version de nuestro documento.

            for(;;){
                raf.seek(posicion); //nos posicionamos
                id=raf.readInt(); // Obtengo id del empleado
                posicion = (posicion + tamanyoInt);
                raf.seek(posicion);
                apellido=raf.readUTF();
                posicion = (posicion + tamanyoString);
                raf.seek(posicion);
                dep = raf.readInt();
                posicion = (posicion + tamanyoInt);
                raf.seek(posicion);
                salario = raf.readDouble();
                posicion = (int) (posicion + tamanyoDouble);
                raf.seek(posicion);
                if (id>0){
                    //Creamos el nodo
                    Element raiz = document.createElement("empleado");
                    // Lo pegamos a la raiz del documento
                    document.getDocumentElement().appendChild(raiz);
                    //añadir ID
                    CrearElemento("id",Integer.toString(id), raiz, document);
                    //añadir apellido
                    CrearElemento("apellido",apellido.trim(), raiz, document);
                    //añadir DEP
                    CrearElemento("dep",Integer.toString(dep), raiz, document);
                    //añadir salario
                    CrearElemento("salario",Double.toString(salario), raiz, document);
                }
                posicion = posicion + 36 ;//me posiciono para el siguiente empleado
                if (raf.getFilePointer() == raf.length())
                    break;
            }// fin del for que recorre el fichero

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Empleados.xml")); //Fichero XML

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source,result);

            Result console = new StreamResult(System.out);
            transformer.transform(source,console);

        } catch (ParserConfigurationException | TransformerException | IOException e) {
            e.printStackTrace();
        }
        raf.close();
    }// fin del main
    static void CrearElemento(String datoEmple,String valor, Element raiz, Document document){

        Element elem = document.createElement(datoEmple); //Creamos hijo
        Text text = document.createTextNode(valor); //Damos valor
        raiz.appendChild(elem);//Pegamos el elemento hijo a la raiz
        elem.appendChild(text);//pegamos el valor

    }
}
