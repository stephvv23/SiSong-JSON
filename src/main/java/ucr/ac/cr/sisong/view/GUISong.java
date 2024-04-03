/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ucr.ac.cr.sisong.view;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class GUISong extends javax.swing.JFrame {

    /**
     * Creates new form GUISong
     */
    public GUISong() {
        initComponents();
    }

    public DataPanelSong getDataPanelSong() {
        return this.dataPanelSong1;
    }

    public ButtonsPanel getButtonsPanel() {
        return this.buttonsPanel2;
    }
    
    //Al ser estatic se puede obtener este metodo en todo el proyecto sin necesidad de instanciar ni nada, creo ;b
    public static void setMessage(String msj){
        JOptionPane.showMessageDialog(null, msj);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataPanelSong1 = new ucr.ac.cr.sisong.view.DataPanelSong();
        buttonsPanel2 = new ucr.ac.cr.sisong.view.ButtonsPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(dataPanelSong1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 389));
        getContentPane().add(buttonsPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 380, 490, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ucr.ac.cr.sisong.view.ButtonsPanel buttonsPanel2;
    private ucr.ac.cr.sisong.view.DataPanelSong dataPanelSong1;
    // End of variables declaration//GEN-END:variables
}