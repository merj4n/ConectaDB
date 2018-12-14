import java.io.*;

public class act162GBM {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:/Users/merjan/Desktop/fichBytesGBM.dat");
        File fic_entrada = new File("C:/Users/merjan/Desktop/Decalogo.txt");
        BufferedReader br = new BufferedReader(new FileReader(fic_entrada));
        FileOutputStream fos = new FileOutputStream(fichero);
        FileInputStream fis = new FileInputStream(fichero);
        int i;
        char b[] = new char[150];
        char s;
        String c;
        while((c= br.readLine())!= null){ //Leo del fichero de texto
            for (i=0;i<c.length();i++){
                b[i]=c.charAt(i); //Por cada caracter de la linea string.
                fos.write(b[i]); // Escribo en el fichero binario caracter a caracter.
            }
            char salto = (char) 10;
            fos.write(salto); //Escribo el caracter de final de linea al final de la frase
        }
        fos.close();
       while ((i = fis.read()) != -1){ //Recorro el fichero binario y lo muestro por pantalla.
            s=(char)i;
            System.out.print(s);
        }
        fis.close();
    }

    /*
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:/Users/merjan/Desktop/Act162GBM.dat");
        File fic_entrada = new File("C:/Users/merjan/Desktop/Decalogo.txt");
        String linea="";
        String copia="";
        String lectura;
        BufferedReader br = new BufferedReader(new FileReader(fic_entrada));
        FileOutputStream fos = new FileOutputStream(fichero);
        DataOutputStream dos = new DataOutputStream(fos);
        FileInputStream fis = new FileInputStream(fichero);
        DataInputStream dis = new DataInputStream(fis);
        try {
            while (linea != null){
                linea=br.readLine();
                if (linea != null) {
                    copia += linea + "\n";
                }
            }
            dos.writeUTF(copia);
            while (true){
                lectura = dis.readUTF();
                System.out.println(lectura);
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
*/

}