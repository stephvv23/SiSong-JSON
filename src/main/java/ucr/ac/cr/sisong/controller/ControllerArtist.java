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
import ucr.ac.cr.sisong.view.GUISong;

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

    public ControllerArtist(ArtistArray artistArray) {
        this.guiArtist = new GUIArtist();
        this.dataPanelArtist = this.guiArtist.getDataPanelArtist();
        this.dataPanelArtist.setCbNation();
        this.buttonsPanel = this.guiArtist.getButtonsPanel();
        this.buttonsPanel.listen(this);
        this.dataPanelArtist.listenComboName(this);
        this.artistArray = artistArray;
        this.guiArtist.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Add":
                this.artist = this.dataPanelArtist.getArtist();
                if (artist != null) {
                    if (this.validationData(artist)) {
                        GUISong.setMessage(this.artistArray.add(artist));
                        this.dataPanelArtist.clean();
                        this.dataPanelArtist.setCbNameArtist(artistArray.getNameList());
                    }
                }

                break;

            case "Edit":
                if (validationData(dataPanelArtist.getArtist())) {
                    this.guiArtist.setMessage(this.artistArray.edit(dataPanelArtist.getArtist()));
                    dataPanelArtist.setNameCombo(artistArray.getNameList());
                    dataPanelArtist.clean();
                    this.dataPanelArtist.setCbNameArtist(artistArray.getNameList());
                }
                break;

            case "Report":
                FrTableDataArtist tableArtist = new FrTableDataArtist();
                tableArtist.setTableArtist(artistArray.getMatrixArtist(), Artist.TB_LABELS);
                tableArtist.setVisible(true);
                break;

            case "Delete":
                if (validationData(dataPanelArtist.getArtist())) {
                    this.guiArtist.setMessage(this.artistArray.delete(dataPanelArtist.getArtist().getArtistName()));
                    this.dataPanelArtist.setCbNameArtist(artistArray.getNameList());
                    dataPanelArtist.clean();

                }

                break;

            case "cbNameArtist":

                if (!dataPanelArtist.getNameCombo().equalsIgnoreCase("Artist name")) {
                    Artist auxArtist = this.artistArray.search(dataPanelArtist.getNameCombo());
                    dataPanelArtist.setArtist(auxArtist);
                }
                break;

            case "Exit":
                System.exit(0);
                break;

        }
    }

//    return new Song(Integer.parseInt(this.lbIdSong.getText()),
//                this.txTitle.getText(),
//                Double.parseDouble(this.spTime.getValue().toString()),
//                this.cbMusicGenre.getSelectedItem().toString(),
//                Integer.parseInt(this.spReleaseYear.getValue().toString()));
    public boolean validationData(Artist artistValidate) {
        if (artistValidate.getArtistName().isEmpty()) {
            this.guiArtist.setMessage("The name field is empty");
            return false;
        }
        if (artistValidate.getNation().equals("Selected option")) {
            this.guiArtist.setMessage("The nationality is empty");
            return false;
        }
        if (artistValidate.getMusicalGenre().equals(("Selected option"))) {
            this.guiArtist.setMessage("The musical genre is empty");
            return false;
        }

        return true;
    }
}
