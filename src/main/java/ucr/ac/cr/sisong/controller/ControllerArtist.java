/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.sisong.model.Artist;
import ucr.ac.cr.sisong.model.ArtistArray;
import ucr.ac.cr.sisong.view.ButtonsPanel;
import ucr.ac.cr.sisong.view.DataPanelArtist;
import ucr.ac.cr.sisong.view.GUIArtist;
import ucr.ac.cr.sisong.view.GUIReport;
import ucr.ac.cr.sisong.view.GUISong;

/**
 *
 * @author Stephanie Venegas Villalobos C38405
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
        this.dataPanelArtist.setCbMusicGenre();
        this.buttonsPanel = this.guiArtist.getButtonsPanel();
        this.buttonsPanel.listen(this);
        this.dataPanelArtist.listenComboName(this);
        this.artistArray = artistArray;
        this.dataPanelArtist.setCbNameArtist(artistArray.getNameList());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Add":
                this.artist = this.dataPanelArtist.getArtist();
                if (artist != null) {
                    if (this.validationData(artist)) {

                        GUISong.setMessage(this.artistArray.add(artist));
                        this.artistArray.getArrayArtist();//$$$$$$$$$$$$$$$$$$$$$$$$$$ ;b
                        this.dataPanelArtist.setCbNameArtist(artistArray.getNameList());
                        this.dataPanelArtist.clean();

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
                this.getReport();
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
                guiArtist.dispose();
                break;

        }
    }

    public void getReport() {
        this.guiReport = new GUIReport();
        this.guiReport.setDataTable(artistArray.getMatrixArtist(), Artist.TB_LABELS);
        this.guiReport.listenMouse(this);
        this.guiReport.setVisible(true);
    }

    public void setVisible() {
        this.guiArtist.setVisible(true);
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
    public void mouseClicked(MouseEvent e) {
        Artist auxArtist = this.artistArray.search(this.guiReport.getDataRow()[0]);
        this.dataPanelArtist.setArtist(auxArtist);
        this.guiArtist.setVisible(true);
        this.guiReport.dispose();
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
