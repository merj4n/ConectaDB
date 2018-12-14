import java.io.*;

public class ActEsFiDataGBM {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:/Users/merjan/Desktop/persona.dat");
        String [] nombres = {"Gema","German","Gervasio","Gertrudis","Gladis","Galilea","Gabriel","Ginebra","Gustavo","Greta"};
        String [] profesion = {"Programador","Pintor","Pasante","Peletero","Comercial","Obrero","Técnico de antenas","Profesor","Camarero","Conductor"};
        int [] edades = {18,22,35,21,27,56,44,19,37,65};
        FileOutputStream fos = new FileOutputStream(fichero);
        DataOutputStream dos = new DataOutputStream(fos);
        FileInputStream fis = new FileInputStream(fichero);
        DataInputStream dis = new DataInputStream(fis);
        try { //Escribo en el fichero los Arrays dependiendo del dato con un bucle.
            for (int i=0;i<nombres.length;i++) {
                dos.writeUTF(nombres[i]);
                dos.writeUTF(profesion[i]);
                dos.writeInt(edades[i]);
            }
            while (true){ //Leo dato a dato y lo muestro formateado
                String leeNom = dis.readUTF();
                String leeProf = dis.readUTF();
                int leeEdad = dis.readInt();
                System.out.println(leeNom +" "+leeEdad+" "+leeProf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fos.close();
            dos.close();
            dis.close();
            fis.close();
        }
    }
}
