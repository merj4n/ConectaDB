import java.io.*;

public class Act163GBM {
    public static void main(String[] args) throws IOException {
    File fichero = new File("C:/Users/merjan/Desktop/persona.dat");
    File fichero2 = new File("personaSerial.dat");
    FileOutputStream fos = new FileOutputStream(fichero);
    FileOutputStream fos2 = new FileOutputStream(fichero2);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
    }
}
