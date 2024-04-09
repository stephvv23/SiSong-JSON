/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.sisong.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import ucr.ac.cr.sisong.model.Artist;

/**
 *
 * @author Stephanie Venegas
 */
public class DataPanelArtist extends javax.swing.JPanel {

    /**
     * Creates new form DataPanelArtist
     */
    public DataPanelArtist() {
        initComponents();
    }

    //String artistName, String musicalGenre, String nation, int id
    public Artist getArtist() {
        return new Artist(this.txtNameArtist.getText(),
                this.cbMusicalGenre.getSelectedItem().toString(),
                this.cbNation.getSelectedItem().toString());
    }

////    "ID", "Title", "Duration", "Music genre", "Release year"
//    public Song[] getSongsList() {
//        Song[] listSongs = new Song[this.tblSongsArtist.getRowCount()];
//        for (int f = 0; f < tblSongsArtist.getRowCount(); f++) {
//            int id = Integer.parseInt(this.tblSongsArtist.getValueAt(f, 0).toString());
//            String title = this.tblSongsArtist.getValueAt(f, 1).toString();
//            double duration = Double.parseDouble(this.tblSongsArtist.getValueAt(f, 2).toString());
//            String musicGenre = this.tblSongsArtist.getValueAt(f, 3).toString();
//            int year = Integer.parseInt(this.tblSongsArtist.getValueAt(f, 4).toString());
//
//            listSongs[f] = new Song(id, title, duration, musicGenre, year);
//        }
//
//        return listSongs;
//    }
    
    public String[] getDataRow() {
        String[] dataSong = new String[this.tblSongsRegistered2.getColumnCount()];
        int selectedRow = this.tblSongsRegistered2.getSelectedRow();
        for (int i = 0; i < dataSong.length; i++) {
            dataSong[i] = this.tblSongsRegistered2.getValueAt(selectedRow, i).toString();
        }
        return dataSong;
    }

    public void setArtist(Artist artist) {
        this.txtNameArtist.setText(String.valueOf((artist.getArtistName())));
        this.cbMusicalGenre.setSelectedItem(artist.getMusicalGenre());
        this.cbNation.setSelectedItem(artist.getNation());
    }

    public void clean() {

        this.txtNameArtist.setText("");
        this.cbMusicalGenre.setSelectedIndex(0);
        this.cbNation.setSelectedIndex(0);
        this.tblSongsArtist.setModel(new DefaultTableModel());

    }

    public void setNameCombo(String[] idList) {
        this.cbArtistsName.setModel(new DefaultComboBoxModel<>(idList));
    }

    public String getNameCombo() {
        return this.cbArtistsName.getSelectedItem().toString();
    }

    public void listenComboName(ActionListener controller) {
        this.cbArtistsName.addActionListener(controller);
    }

    public void setCbNation() {
        this.cbNation.setModel(new DefaultComboBoxModel<>(new String[]{
            "Argentina",
            "Bolivia",
            "Brazil",
            "Canada",
            "Chile",
            "Colombia",
            "Costa Rica",
            "Cuba",
            "Dominican Republic",
            "Ecuador",
            "El Salvador",
            "Guatemala",
            "Haiti",
            "Honduras",
            "Jamaica",
            "Mexico",
            "Nicaragua",
            "Panama",
            "Paraguay",
            "Peru",
            "United States",
            "Uruguay",
            "Venezuela"
        }));
    }

    public void setCbMusicGenre() {
        this.cbMusicalGenre.setModel(new DefaultComboBoxModel<>(new String[]{"Selected option", "Pop", "Rock", "Metal", "Regueton", "Salsa", "Cumbia", "Clasica", "Hip-Hop", "Jazz", "Bachata", "Merengue"}));
    }

    public void setCbNameArtist(String[] vectorNames) {
        this.cbArtistsName.setModel(new DefaultComboBoxModel<>(vectorNames));
    }

    public void setTblSongsRegistered(String[][] matrix, String[] TB_LABELS) {
        this.tblSongsRegistered2.setModel(new DefaultTableModel(matrix, TB_LABELS));
    }

    public void listenMouse(MouseListener controller) {
        this.tblSongsRegistered2.addMouseListener(controller);
    }

    public void setTblArtistSongs(String[][] matrix, String[] TB_LABELS) {
        this.tblSongsArtist.setModel(new DefaultTableModel(matrix, TB_LABELS));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbNation = new javax.swing.JComboBox<>();
        cbMusicalGenre = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNameArtist = new javax.swing.JTextField();
        cbArtistsName = new javax.swing.JComboBox<>();
        lbBackground = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSongsRegistered2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSongsArtist = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(450, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbNation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selected option", "Afganistán", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bangladés", "Barbados", "Baréin", "Bélgica", "Belice", "Benín", "Bielorrusia", "Birmania (Myanmar)", "Bolivia", "Bosnia y Herzegovina", "Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi", "Bután", "Cabo Verde", "Camboya", "Camerún", "Canadá", "Catar", "Chad", "Chile", "China", "Chipre", "Ciudad del Vaticano", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador", "Emiratos Árabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia", "Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gabón", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guyana", "Guinea", "Guinea-Bisáu", "Guinea Ecuatorial", "Haití", "Honduras", "Hungría", "India", "Indonesia", "Irak", "Irán", "Irlanda", "Islandia", "Islas Marshall", "Islas Salomón", "Israel", "Italia", "Jamaica", "Japón", "Jordania", "Kazajistán", "Kenia", "Kirguistán", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "Líbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Macedonia del Norte", "Madagascar", "Malasia", "Malaui", "Maldivas", "Malí", "Malta", "Marruecos", "Mauricio", "Mauritania", "México", "Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "Níger", "Nigeria", "Noruega", "Nueva Zelanda", "Omán", "Países Bajos", "Pakistán", "Palaos", "Panamá", "Papúa Nueva Guinea", "Paraguay", "Perú", "Polonia", "Portugal", "Reino Unido", "República Centroafricana", "República Checa", "República del Congo", "República Democrática del Congo", "República Dominicana", "República Sudafricana", "Ruanda", "Rumania", "Rusia", "Samoa", "San Cristóbal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Lucía", "Santo Tomé y Príncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Suazilandia", "Sudán", "Sudán del Sur", "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikistán", "Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago", "Túnez", "Turkmenistán", "Turquía", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekistán", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue" }));
        add(cbNation, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 150, -1));

        cbMusicalGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selected option", "Rock", "Pop", "Hip-hop", "Rap", "Jazz", "Blues", "Reggae", "Country", "Electronic", "Folk", "Indie", "Metal", "Punk", "Funk", "Soul", "Gospel", "Classical", "Alternative", "Disco" }));
        add(cbMusicalGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 90, -1));

        jLabel3.setFont(new java.awt.Font("Source Serif Pro Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name:");
        jLabel3.setToolTipText("");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Source Serif Pro Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nation:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        jLabel1.setFont(new java.awt.Font("Source Serif Pro Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Musical genre:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Artist registry");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        txtNameArtist.setActionCommand("");
        add(txtNameArtist, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 120, -1));

        cbArtistsName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Artist Name" }));
        cbArtistsName.setToolTipText("");
        cbArtistsName.setActionCommand("cbNameArtist");
        add(cbArtistsName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        lbBackground.setFont(new java.awt.Font("Source Serif Pro Light", 1, 18)); // NOI18N
        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ArtistBackground2.jpg"))); // NOI18N
        lbBackground.setText(" ");
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 210));

        tblSongsRegistered2.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSongsRegistered2.setColumnSelectionAllowed(false);
        jScrollPane1.setViewportView(tblSongsRegistered2);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 420, 140));

        tblSongsArtist.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblSongsArtist);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 420, 140));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Songs Registered");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Artist songs...");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbArtistsName;
    private javax.swing.JComboBox<String> cbMusicalGenre;
    private javax.swing.JComboBox<String> cbNation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JTable tblSongsArtist;
    private javax.swing.JTable tblSongsRegistered2;
    private javax.swing.JTextField txtNameArtist;
    // End of variables declaration//GEN-END:variables
}
