import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Modificacion extends javax.swing.JFrame {
    List<Asignaturas> lista = new ArrayList<>();
    String path="C:/Users/merjan/Desktop/Asignaturas.dat";
    File fichero = new File(path);

    /**
     * Creates new form Modificacion
     */
    public Modificacion() {
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

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();


        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);


        /*jTextField5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                System.out.println(e.getKeyChar());
            }
        });*/

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Horas");

        jLabel4.setText("Clase");

        jTextField1.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("EDITAR ASIGNATURA");

        jTextField2.setToolTipText("");

        jTextField3.setToolTipText("");

        jTextField4.setToolTipText("");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jTextField5.getText().length()==0){

                }else {
                    int id=Integer.parseInt(jTextField5.getText());
                    lista=Asignaturas.LeeFichero(path);
                    for (Asignaturas as:lista) {
                        if(as.id==id){
                            jTextField1.setText(as.nombre);
                            jTextField2.setText(as.profesor);
                            jTextField3.setText(""+as.horas);
                            jTextField4.setText(as.clase);
                        }
                    }
                    jTextField1.setEnabled(true);
                    jTextField2.setEnabled(true);
                    jTextField3.setEnabled(true);
                    jTextField4.setEnabled(true);
                    jButton1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Asignaturas ar = new Asignaturas();
                            int codigo = Integer.parseInt(jTextField5.getText());

                            for (Asignaturas asig:lista) {
                                if(asig.id==codigo){
                                    asig.nombre= jTextField1.getText();
                                    asig.horas=Integer.parseInt(jTextField3.getText());
                                    asig.profesor=jTextField2.getText();
                                    asig.clase=jTextField4.getText();
                                }
                            }
                            Asignaturas.EscribeFichero(lista,path);
                            setVisible(false);
                            MenuPrincipal.mostrarDatos(lista);

                        }
                    });
                }
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        jLabel1.setText("Asignatura");

        jLabel2.setText("Profesor");

        jTextField5.setToolTipText("");

        jLabel6.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addComponent(jButton1)
                                                .addGap(37, 37, 37)
                                                .addComponent(jButton2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addComponent(jLabel6)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jLabel1)
                                                                .addGap(49, 49, 49)
                                                                .addComponent(jLabel2)
                                                                .addGap(46, 46, 46)
                                                                .addComponent(jLabel3)
                                                                .addGap(50, 50, 50)
                                                                .addComponent(jLabel4))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(73, 73, 73)
                                                                .addComponent(jLabel5)))))
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration
}