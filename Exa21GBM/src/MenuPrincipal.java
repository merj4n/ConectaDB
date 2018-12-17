
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author merjan
 */
public class MenuPrincipal extends javax.swing.JFrame {
    Asignaturas inicial = null;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    List<Asignaturas> lista = new ArrayList<>();

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Altas");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Altas alta = new Altas();
                alta.setLocation(dim.width/2-alta.getSize().width/2, dim.height/2-alta.getSize().height/2);
                alta.setVisible(true);
                alta.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        });

        jButton2.setText("Bajas");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bajas baja = new Bajas();
                baja.setLocation(dim.width/2-baja.getSize().width/2, dim.height/2-baja.getSize().height/2);
                baja.setVisible(true);
                baja.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        });

        jButton3.setText("Modificaciones");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modificacion mod = new Modificacion();
                mod.setLocation(dim.width/2-mod.getSize().width/2, dim.height/2-mod.getSize().height/2);
                mod.setVisible(true);
                mod.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        });


        jButton4.setText("Consultas");
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Consulta con = new Consulta();
                con.setLocation(dim.width/2-con.getSize().width/2, dim.height/2-con.getSize().height/2);
                con.setVisible(true);
                con.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        });

        jButton5.setText("Datos Iniciales");

        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.clear();
                cargarDatos(lista);
                mostrarDatos(lista);
            }
        });

        jLabel1.setText("Nombre del fichero:");

        jLabel2.setText("Ruta:");

        jLabel3.setText("Numero de registros:");

        jLabel4.setText("Tamaño:");

        jLabel5.setText("C:/User/merjan/desktop/LosDatos.txt");

        jLabel6.setText("LosDatos.txt");

        jLabel7.setText("");

        jLabel8.setText("56 Kb");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addComponent(jButton1)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButton2))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(44, 44, 44)
                                                                .addComponent(jButton4))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jButton3)
                                                                        .addComponent(jButton5)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1)
                                                        .addComponent(jButton2))
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton4)
                                                .addGap(20, 20, 20)
                                                .addComponent(jButton5)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel1)
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8)
                                                .addGap(0, 60, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel5))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void mostrarDatos(List<Asignaturas> lista) {
        String pantalla="";
        int con=0;
        for (Asignaturas as:lista) {
            pantalla+=as.id+" "+as.nombre+" "+as.clase+" "+as.profesor+" "+as.horas+"\n";
            con++;
        }
        jTextArea1.setText(pantalla);
        jLabel7.setText(""+con);
    }
    private static void cargarDatos(List<Asignaturas> lista) {

        lista.add(new Asignaturas("Algebra", "Mateo", 140, "2D/2E", 1));
        lista.add(new Asignaturas("Calculo Infinitesimal", "Susana", 120, "2D", 2));
        lista.add(new Asignaturas("Programacion I", "Ricardo", 125, "3E", 3));
        lista.add(new Asignaturas("Programacion II", "Ricardo", 90, "1D/3A", 4));
        lista.add(new Asignaturas("Sistemas Automatas", "Pablo", 300, "2D/2E", 5));
        lista.add(new Asignaturas("Redes", "Angela", 140, "2D/2E", 6));
        lista.add(new Asignaturas("Informatica Basica", "Carla", 140, "2D/2E", 7));
        lista.add(new Asignaturas("Estadistica", "Monkas", 140, "1D",8));
        lista.add(new Asignaturas("Relaciones Juridicas Basicas", "Carlos", 140, "1A",9));
        lista.add(new Asignaturas("Programacion Orientada a Objetos", "Alberto", 140, "1D/2C",10));
        lista.add(new Asignaturas("Sistemas Operativos", "Dario", 130, "1D/1E", 11));
        lista.add(new Asignaturas("Acceso a Datos", "Juan", 120, "3A/3B", 12));
    }

    private static void iniciarFichero(){




    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration
}
