/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ucr.ac.cr.sisong.view;

import javax.swing.JOptionPane;

/**
 *
 * @author sivv2
 */
public class GUIArtist extends javax.swing.JFrame {

    /**
     * Creates new form GUIArtist
     */
    public GUIArtist() {
        initComponents(); 
    }

    public ButtonsPanel getButtonsPanel() {
        return buttonsPanel2;
    }

    public DataPanelArtist getDataPanelArtist() {
        return dataPanelArtist1;
    }

  
    
    //ojo es el mismo de GUISong
    public void setMessage(String msj){
        JOptionPane.showMessageDialog(this, msj);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataPanelArtist1 = new ucr.ac.cr.sisong.view.DataPanelArtist();
        buttonsPanel2 = new ucr.ac.cr.sisong.view.ButtonsPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(dataPanelArtist1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(buttonsPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ucr.ac.cr.sisong.view.ButtonsPanel buttonsPanel2;
    private ucr.ac.cr.sisong.view.DataPanelArtist dataPanelArtist1;
    // End of variables declaration//GEN-END:variables
}
