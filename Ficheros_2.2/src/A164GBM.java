import java.io.*;

public class A164GBM {
    public static void main(String[] args) throws IOException {
        File fichero = new File("personaSerial.dat");
        RandomAccessFile raf = new RandomAccessFile(fichero,"r");
        FileInputStream fis = new FileInputStream(raf.getFD());
        ObjectInputStream ois = new ObjectInputStream(fis); //Defino el tipo de entrada de datos en este caso objeto
        String par="",impar=""; //Para imprimir en el orden del ejercicio
        int n=0;
        while (n<raf.length()){ //Mientras no se lean todos los registros
            try {
                Persona pe=(Persona) ois.readObject(); //Leo el primer objeto
                if (pe.getId()%2 == 0) { //Determino si es par o impar y lo agrego a su String correspondiente
                    par = par + pe.getId() + " " + pe.getNombre() + " " + pe.getProfesion() + " " + pe.getEdad() + "\n";
                }
                else {
                    impar = impar + pe.getId() + " " + pe.getNombre() + " " + pe.getProfesion() + " " + pe.getEdad() + "\n";
                }
                int aux1=pe.getNombre().length();
                int aux2=pe.getProfesion().length();
               n = n + (8+(aux1*2)+(aux2*2)); // Obtencion del tamaño de cada registro
            } catch (ClassNotFoundException e) {
            } catch (EOFException e){ //Si finaliza la lectura del fichero imprimo el resultado y salgo
                System.out.println(impar);
                System.out.println(par);
                ois.close();
                raf.close();
                System.exit(0);
            }
        }


        /*int id,edad,pos=0;
        System.out.println(raf.length());
        char nombre[] = new char[10], profesion[]= new char[20], aux;
        for(;;){
            raf.seek(pos);
            id = raf.readInt();
            for (int i=0;i<nombre.length;i++){
                aux = raf.readChar();
                nombre[i]=aux;
            }
            String nom = new String(nombre);
            for (int i=0;i<profesion.length;i++){
                aux = raf.readChar();
                profesion[i]=aux;
            }
            String prof = new String(profesion);
            edad = raf.readInt();
            if (id>0){
                System.out.printf("ID: %s, Nombre: %s, Profesion: %s,Edad: %s\n",id,nom,prof,edad);
            }
            pos = pos + 68;
            if (raf.getFilePointer() == raf.length())
                break;
        }
        raf.close();*/
    }
}
