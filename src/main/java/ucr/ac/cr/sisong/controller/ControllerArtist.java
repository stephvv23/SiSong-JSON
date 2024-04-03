/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.sisong.model.Artist;
import ucr.ac.cr.sisong.model.ArtistArray;
import ucr.ac.cr.sisong.view.ButtonsPanel;
import ucr.ac.cr.sisong.view.DataPanelArtist;
import ucr.ac.cr.sisong.view.FrTableDataArtist;
import ucr.ac.cr.sisong.view.GUIArtist;

/**
 *
 * @author sivv2
 */
public class ControllerArtist implements ActionListener {

    private GUIArtist guiArtist;
    private DataPanelArtist dataPanelArtist;
    private ButtonsPanel buttonsPanel;
    private Artist artist;
    private ArtistArray artistArray;

    public ControllerArtist() {
        this.guiArtist = new GUIArtist();
        this.dataPanelArtist = this.guiArtist.getDataPanelArtist();
        this.buttonsPanel = this.guiArtist.getButtonsPanel();
        this.buttonsPanel.listen(this);
        this.dataPanelArtist.listenComboID(this);
        this.artistArray = new ArtistArray();
        this.dataPanelArtist.setIdArtist(this.artistArray.getIdArtist());
        this.guiArtist.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Add":
                if (validationData()) {
                    dataPanelArtist.setIdArtist(artistArray.getIdArtist());
                    this.guiArtist.setMessage(this.artistArray.add(this.getArtist()));
                    dataPanelArtist.setIDCombo(artistArray.getIDList());
                    dataPanelArtist.clean();
                    dataPanelArtist.setIdArtist(artistArray.getIdArtist());
                }

                break;
            case "Edit":
                if (validationData()) {
                    this.guiArtist.setMessage(this.artistArray.edit(this.getArtist()));
                    dataPanelArtist.setIDCombo(artistArray.getIDList());
                    dataPanelArtist.clean();
                    dataPanelArtist.setIdArtist(artistArray.getIdArtist());
                }
                break;
            case "Report":
                FrTableDataArtist tableArtist = new FrTableDataArtist();
                tableArtist.setTableArtist(artistArray.getMatrixArtist(), Artist.TB_LABELS);
                tableArtist.setVisible(true);
                break;
            case "Delete":
                if (validationData()) {
                    this.guiArtist.setMessage(this.artistArray.delete(dataPanelArtist.getIdArtist()));
                    dataPanelArtist.setIDCombo(artistArray.getIDList());
                    dataPanelArtist.clean();
                    dataPanelArtist.setIdArtist(artistArray.getIdArtist());
                }

                break;
            case "comboIDArtist":
                Artist auxArtist = this.artistArray.search(Integer.parseInt(dataPanelArtist.getIDCombo()));
                dataPanelArtist.setIdArtist(auxArtist.getId());
                dataPanelArtist.setNameArtist(auxArtist.getArtistName());
                dataPanelArtist.setNation(auxArtist.getNation());
                dataPanelArtist.setMusicalGenre(auxArtist.getMusicalGenre());

                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }

    public Artist getArtist() {
        return new Artist(this.dataPanelArtist.getNameArtist(), this.dataPanelArtist.getMusicalGenre(), this.dataPanelArtist.getNation(), this.dataPanelArtist.getIdArtist());

    }

//    return new Song(Integer.parseInt(this.lbIdSong.getText()),
//                this.txTitle.getText(),
//                Double.parseDouble(this.spTime.getValue().toString()),
//                this.cbMusicGenre.getSelectedItem().toString(),
//                Integer.parseInt(this.spReleaseYear.getValue().toString()));
    public boolean validationData() {
        if (this.dataPanelArtist.getNameArtist().isEmpty()) {
            this.guiArtist.setMessage("The name field is empty");
            return false;
        }

        if (this.dataPanelArtist.getNation().equals("Selected option")) {
            this.guiArtist.setMessage("The nationality is empty");
            return false;
        }
        if (this.dataPanelArtist.getMusicalGenre().equals(("Selected option"))) {
            this.guiArtist.setMessage("The musical genre is empty");
            return false;
        }

        return true;
    }
}
