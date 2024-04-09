/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import ucr.ac.cr.sisong.model.Artist;
import ucr.ac.cr.sisong.model.ArtistArray;
import ucr.ac.cr.sisong.model.Song;
import ucr.ac.cr.sisong.model.SongArray;
import ucr.ac.cr.sisong.view.ButtonsPanel;
import ucr.ac.cr.sisong.view.DataPanelArtist;
import ucr.ac.cr.sisong.view.GUIArtist;
import ucr.ac.cr.sisong.view.GUIReport;
import ucr.ac.cr.sisong.view.GUISong;

/**
 *
 * @author sivv2
 */
public class ControllerArtist implements ActionListener, MouseListener {

    private GUIArtist guiArtist;
    private DataPanelArtist dataPanelArtist;
    private ButtonsPanel buttonsPanel;
    private Artist artist;
    private ArtistArray artistArray;
    private GUIReport guiReport;

    public ControllerArtist(ArtistArray artistArray) {
        this.guiArtist = new GUIArtist();
        this.dataPanelArtist = this.guiArtist.getDataPanelArtist();
        this.dataPanelArtist.setCbNation();
        this.dataPanelArtist.listenMouse(this);
//        this.songArray = songArray;
//        this.dataPanelArtist.setTblSongsRegistered(this.songArray.getMatrixDataSongs(), Song.TBL_LABELS);
        this.guiReport = new GUIReport();
        this.guiReport.listenMouse(this);
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
//                        this.dataPanelArtist.setTblSongsRegistered(this.songArray.getMatrixDataSongs(), Song.TBL_LABELS);
//                        this.artistArray.cleanListSongsSelected();
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
//                this.artistArray.cleanListSongsSelected();
                break;

            case "Report":

                guiReport.setDataTable(artistArray.getMatrixArtist(), Artist.TB_LABELS);
                guiReport.setVisible(true);
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
//                    this.dataPanelArtist.setTblArtistSongs(this.artistArray.getMatrixArtistSongsAlreadyExist(auxArtist.getArtistSongs()), Song.TBL_LABELS);
                }
                break;

            case "Exit":
                guiArtist.setVisible(false);
                break;

        }
    }

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

    @Override
//    "NAME", "NATION", "MUSICAL GENRE"};
    public void mouseClicked(MouseEvent e) {
//        this.artistArray.addSongsSelected(new Song(Integer.parseInt(this.dataPanelArtist.getDataRow()[0]),
//                this.dataPanelArtist.getDataRow()[1],
//                Double.parseDouble(this.dataPanelArtist.getDataRow()[2]),
//                this.dataPanelArtist.getDataRow()[3],
//                Integer.parseInt(this.dataPanelArtist.getDataRow()[4])));
//        this.dataPanelArtist.setTblArtistSongs(artistArray.getMatrixArtistSongs(), Song.TBL_LABELS);
//        this.guiReport.dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
