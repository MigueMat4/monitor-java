/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Miguel Matul
 */
public class frmMain extends javax.swing.JFrame {
    
    // Región crítica
    private int valor = 0;
    private String letra = "";

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        spnVelocidad.setModel(new SpinnerNumberModel(10, 10, 1000, 10));
        spnVelocidad.setEditor(new JSpinner.DefaultEditor(spnVelocidad));
    }
    
    public class Productor extends Thread {
        public String idProductor;

        public Productor(String idProductor) {
            this.idProductor = idProductor;
        }
        
        @Override
        public void run() {
            while (true) {
                System.out.println(idProductor + " listo para aumentar valor");
                //
                if (valor <= 50) {
                    valor += 1;
                    lblValor.setText(String.valueOf(valor));
                    System.out.println(idProductor + " incrementé valor a " + valor);
                    letra = idProductor;
                    lblLetra.setText(letra);
                    try {
                        int velocidad = (Integer) spnVelocidad.getValue();
                        Thread.sleep(velocidad);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                //
                System.out.println(idProductor + " logró su cometido");
            }
        }
    }
    
    public class Consumidor extends Thread {
        public String idConsumidor = "-";

        public Consumidor() {
        }
        
        @Override
        public void run() {
            while (true) {
                System.out.println(idConsumidor + " listo para decrementar valor");
                //
                if (valor >= 10) {
                    valor -= 10;
                    lblValor.setText(String.valueOf(valor));
                    System.out.println(idConsumidor + " decrementé valor a " + valor);
                    letra = idConsumidor;
                    lblLetra.setText(letra);
                }
                //
                System.out.println(idConsumidor + " logró su cometido");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblLetra = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        btnProductores = new javax.swing.JButton();
        btnConsumidor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        spnVelocidad = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Tarea No. 3");

        lblLetra.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblLetra.setText("?");

        lblValor.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblValor.setText("0");

        btnProductores.setText("Iniciar productores");
        btnProductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoresActionPerformed(evt);
            }
        });

        btnConsumidor.setText("Iniciar consumidor");
        btnConsumidor.setActionCommand("Iniciar consumidor");
        btnConsumidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsumidorActionPerformed(evt);
            }
        });

        jLabel2.setText("Velocidad productores:");

        jLabel3.setText("milisegundos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(lblLetra)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnProductores)
                                .addGap(45, 45, 45)
                                .addComponent(btnConsumidor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spnVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addComponent(lblValor)
                    .addContainerGap(273, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(lblLetra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductores)
                    .addComponent(btnConsumidor))
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(17, 17, 17))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(113, 113, 113)
                    .addComponent(lblValor)
                    .addContainerGap(165, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoresActionPerformed
        // TODO add your handling code here:
        Productor p1 = new Productor("A");
        Productor p2 = new Productor("B");
        Productor p3 = new Productor("C");
        Productor p4 = new Productor("D");
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }//GEN-LAST:event_btnProductoresActionPerformed

    private void btnConsumidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsumidorActionPerformed
        // TODO add your handling code here:
        Consumidor c1 = new Consumidor();
        c1.start();
    }//GEN-LAST:event_btnConsumidorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsumidor;
    private javax.swing.JButton btnProductores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblLetra;
    private javax.swing.JLabel lblValor;
    private javax.swing.JSpinner spnVelocidad;
    // End of variables declaration//GEN-END:variables
}
