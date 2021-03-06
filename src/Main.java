
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Angelo
 */
public class Main extends javax.swing.JFrame {

    private CashDrawerController cashDrawerDriver;
    private ReadXMLFile xml;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon img = new ImageIcon("drawer.png");
        this.setIconImage(img.getImage());
        cashDrawerDriver = new CashDrawerController();
        cashDrawerDriver.runComm();
        xml = new ReadXMLFile();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        closeBox = new javax.swing.JButton();
        openBox = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        stateTitle = new javax.swing.JLabel();
        state = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        configMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        passwordMenu = new javax.swing.JMenu();
        changePasswordMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainLabel.setFont(new java.awt.Font("Tamil MN", 0, 11)); // NOI18N
        mainLabel.setText("Controlador de Caja de dinero");

        closeBox.setFont(new java.awt.Font("Tamil MN", 0, 11)); // NOI18N
        closeBox.setText("Cerrar Caja");
        closeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBoxActionPerformed(evt);
            }
        });

        openBox.setFont(new java.awt.Font("Tamil MN", 0, 11)); // NOI18N
        openBox.setText("Abrir Caja");
        openBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openBoxActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Tamil MN", 0, 11)); // NOI18N
        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        stateTitle.setFont(new java.awt.Font("Tamil MN", 0, 11)); // NOI18N
        stateTitle.setText("Estado:");

        state.setFont(new java.awt.Font("Tamil MN", 0, 11)); // NOI18N
        state.setText("cerrada");

        configMenu.setText("Configuración");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Configuración del puerto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        configMenu.add(jMenuItem1);

        jMenuBar1.add(configMenu);

        passwordMenu.setText("Contraseña");

        changePasswordMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        changePasswordMenuItem.setText("Cambiar contraseña");
        changePasswordMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordMenuItemActionPerformed(evt);
            }
        });
        passwordMenu.add(changePasswordMenuItem);

        jMenuBar1.add(passwordMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(openBox)
                        .addGap(55, 55, 55)
                        .addComponent(closeBox)
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(mainLabel)
                        .addGap(101, 101, 101))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(exitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(stateTitle)
                        .addGap(18, 18, 18)
                        .addComponent(state)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainLabel)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeBox)
                    .addComponent(openBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateTitle)
                    .addComponent(state))
                .addGap(18, 18, 18)
                .addComponent(exitButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBoxActionPerformed
        cashDrawerDriver.sendData("c");
        state.setText("cerrada");
    }//GEN-LAST:event_closeBoxActionPerformed

    private void openBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openBoxActionPerformed
        cashDrawerDriver.sendData("o");
        state.setText("abierta");
    }//GEN-LAST:event_openBoxActionPerformed

    private void changePasswordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordMenuItemActionPerformed
        // TODO add your handling code here:
        System.out.println("click");
    }//GEN-LAST:event_changePasswordMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        String port = JOptionPane.showInputDialog(null, "Ingresa el puerto a conectar",xml.readFile()[0]);
        if (port != null) {
            if (!port.equals("")) {
                if (port.matches("COM[1-9]")) {
                    xml.writeFile("port", port);
                    System.out.println("Port to connect: " + port);
                    try {
                        cashDrawerDriver.close();
                    } catch (Exception e) {
                        System.err.println(e.toString());
                    }
                    cashDrawerDriver.runComm();
                } else {
                    System.out.println("No matches to COM[1-9] regex");
                }
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        cashDrawerDriver.keepRunning = false;
        try {
            cashDrawerDriver.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem changePasswordMenuItem;
    private javax.swing.JButton closeBox;
    private javax.swing.JMenu configMenu;
    private javax.swing.JButton exitButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JButton openBox;
    private javax.swing.JMenu passwordMenu;
    private javax.swing.JLabel state;
    private javax.swing.JLabel stateTitle;
    // End of variables declaration//GEN-END:variables
}
