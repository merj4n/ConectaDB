import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Act163GBM {
    public static void main(String[] args) throws IOException {
        int contador = 1;
        String nombre;
        List<Persona> lista = new ArrayList<>();
        Persona pe = null;
        File fichero = new File("C:/Users/merjan/Desktop/persona.dat");
        File fichero2 = new File("personaSerial.dat");
        FileOutputStream fos = new FileOutputStream(fichero2); //Escribe el objeto a un fichero
        FileInputStream fosob = new FileInputStream(fichero2);
        FileInputStream fis = new FileInputStream(fichero); //Lee el objeto de un fichero de datos
        ObjectOutputStream oos = new ObjectOutputStream(fos); //Variable para trabajar con la escritura del objeto
        ObjectInputStream ois = new ObjectInputStream(fosob);
        DataInputStream dis = new DataInputStream(fis);

            try{
                do {
                    nombre = dis.readUTF();
                    String profesion = dis.readUTF();
                    int edad = dis.readInt();
                    Persona p = new Persona(contador, nombre, profesion, edad);
                    lista.add(p);
                    contador++;
                }while (nombre!=null);
            }catch (IOException e){
                //System.out.println("Fin de fichero");
            }finally {
                for (Persona per:lista) {
                    oos.writeObject(per); // Escribo las personas en el fichero de datos.
                }
                oos.close();
                do{
                    try {
                        pe = (Persona) ois.readObject();
                        System.out.println(pe.getId()+" "+pe.getNombre()+" "+pe.getProfesion()+" "+pe.getEdad());
                    } catch (ClassNotFoundException e) {

                    } catch (EOFException e){
                        ois.close();
                        fos.close();
                        fis.close();
                        dis.close();
                        System.exit(0);
                    }
                }while (pe != null);

            }
        }
    }
