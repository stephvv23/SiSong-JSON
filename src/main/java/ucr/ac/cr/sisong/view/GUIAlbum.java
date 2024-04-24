/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ucr.ac.cr.sisong.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ucr.ac.cr.sisong.model.Album;
import ucr.ac.cr.sisong.model.Artist;
import ucr.ac.cr.sisong.model.Song;

/**
 * //
 *
 *
 * @author Stephanie Venegas Villalobos C38405
 */
public class GUIAlbum extends javax.swing.JFrame {
    
    /**
     * Creates new form GUIAlbum
     */
    public GUIAlbum() {
        initComponents();
        
    }

    public JTable getTableRegisteredSongs() {
        return this.tblRegisteredSongs;
    }

    public JTable getTableSongToAlbum() {
        return this.tblSongToAlbum;
    }

    public JTable getTableRegisteredArtist() {
        return this.tblRegisteredArtist;
    }

    public JTable getTableArtistToAlbum() {
        return this.tblArtistToAlbum;
    }

    public int getSelectedRowSong() {

        int index = this.tblSongToAlbum.getSelectedRow();
        return index;
    }

    public int getSelectedRowArtist() {

        int index = this.tblArtistToAlbum.getSelectedRow();
        return index;
    }

    
    public Album getAlbum(ArrayList<Artist> artistArray, ArrayList<Song> songArray) {
        return new Album(this.txtTitleAlbum.getText(), Integer.parseInt(this.spReleaseYearAlbum.getValue().toString()), artistArray, songArray);
    }

    public void setDataTableSongRegistered(String[][] data, String[] title) {
        DefaultTableModel model = new DefaultTableModel(data, title);
        this.tblRegisteredSongs.setModel(model);
        this.jScrollPane1.setViewportView(this.tblRegisteredSongs);
    }

    public void setDataTableArtistRegistered(String[][] data, String[] title) {
        DefaultTableModel model = new DefaultTableModel(data, title);
        this.tblRegisteredArtist.setModel(model);
        this.jScrollPane4.setViewportView(this.tblRegisteredArtist);
    }

    public void setDataTableSongToAlbum(String[][] data, String[] title) {

        DefaultTableModel model = new DefaultTableModel(data, title);
        this.tblSongToAlbum.setModel(model);
        this.jScrollPane2.setViewportView(this.tblSongToAlbum);

    }

    public void setDataTableArtistToAlbum(String[][] data, String[] title) {
        DefaultTableModel model = new DefaultTableModel(data, title);
        this.tblArtistToAlbum.setModel(model);
        this.jScrollPane3.setViewportView(this.tblArtistToAlbum);
    }

    public String[] getDataRowRegisteredSongs() {
        String[] dataSong = new String[this.tblRegisteredSongs.getColumnCount()];
        int selectRow = this.tblRegisteredSongs.getSelectedRow();
        for (int i = 0; i < dataSong.length; i++) {
            dataSong[i] = this.tblRegisteredSongs.getValueAt(selectRow, i).toString();
        }
        return dataSong;
    }

    public String[] getDataRowRegisteredArtist() {
        String[] dataSong = new String[this.tblRegisteredArtist.getColumnCount()];
        int selectRow = this.tblRegisteredArtist.getSelectedRow();
        for (int i = 0; i < dataSong.length; i++) {
            dataSong[i] = this.tblRegisteredArtist.getValueAt(selectRow, i).toString();
        }
        return dataSong;
    }
    
    public void listenBottons(ActionListener controller){
        this.btnAddAlbum.addActionListener(controller);
        this.btnClose.addActionListener(controller);
    }
    
    public void listenMouse(MouseListener controller) {
        this.tblRegisteredSongs.addMouseListener(controller);
        this.tblSongToAlbum.addMouseListener(controller);
        this.tblRegisteredArtist.addMouseListener(controller);
        this.tblArtistToAlbum.addMouseListener(controller);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTitleAlbum = new javax.swing.JTextField();
        spReleaseYearAlbum = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegisteredSongs = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSongToAlbum = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAddAlbum = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblArtistToAlbum = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblRegisteredArtist = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("Song records");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jLabel2.setText("Title:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jLabel3.setText("Release date:");

        spReleaseYearAlbum.setModel(new javax.swing.SpinnerNumberModel(2024, 1582, 2024, 1));

        tblRegisteredSongs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRegisteredSongs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegisteredSongsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRegisteredSongs);

        tblSongToAlbum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblSongToAlbum);

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jLabel4.setText("Registered artist");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jLabel5.setText("Add Songs to Album");

        btnAddAlbum.setText("Add");
        btnAddAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAlbumActionPerformed(evt);
            }
        });

        btnClose.setText("Close");

        tblArtistToAlbum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane3.setViewportView(tblArtistToAlbum);

        tblRegisteredArtist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane4.setViewportView(tblRegisteredArtist);

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jLabel6.setText("Registered Song");

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 3, 18)); // NOI18N
        jLabel7.setText("Add artist to Album");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(btnAddAlbum)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(txtTitleAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(spReleaseYearAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(118, 118, 118)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddAlbum)
                            .addComponent(btnClose))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTitleAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spReleaseYearAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddAlbumActionPerformed

    private void tblRegisteredSongsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegisteredSongsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblRegisteredSongsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAlbum;
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner spReleaseYearAlbum;
    private javax.swing.JTable tblArtistToAlbum;
    private javax.swing.JTable tblRegisteredArtist;
    private javax.swing.JTable tblRegisteredSongs;
    private javax.swing.JTable tblSongToAlbum;
    private javax.swing.JTextField txtTitleAlbum;
    // End of variables declaration//GEN-END:variables
}
