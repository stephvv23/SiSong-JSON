/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.sisong.model.Song;
import ucr.ac.cr.sisong.model.SongArray;
import ucr.ac.cr.sisong.view.ButtonsPanel;
import ucr.ac.cr.sisong.view.DataPanelSong;
import ucr.ac.cr.sisong.view.GUISong;
import ucr.ac.cr.sisong.view.GUIReport;

/**
 *
 * @author Stephanie Venegas Villalobos C38405
 */
public class ControllerSong implements ActionListener, MouseListener {

    private GUISong guiSong;
    private DataPanelSong dataPanelSong;
    private ButtonsPanel buttonsPanel;
    private SongArray songArray;
    private Song song;
    private GUIReport guiReport;

    public ControllerSong(SongArray songArray) {
        this.guiSong = new GUISong();
        this.dataPanelSong = this.guiSong.getDataPanelSong();
        this.buttonsPanel = this.guiSong.getButtonsPanel();
        this.buttonsPanel.listen(this);
        this.dataPanelSong.listenCombo(this);
        this.songArray = songArray;
        this.dataPanelSong.setLbIdSong(this.songArray.getIDdLabel());
        this.dataPanelSong.setCbMusicGenre();
        this.guiSong.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Add":
                System.err.println("Add");

                this.song = this.dataPanelSong.getSong();
                if (this.song != null) {
                    if (this.validationData(song)) {
                        GUISong.setMessage(this.songArray.add(song));
                        this.dataPanelSong.setCbSong(this.songArray.getIDCombo());
                        this.dataPanelSong.setEditCbCombo(true);
                        this.dataPanelSong.clean();
                        this.dataPanelSong.setLbIdSong(this.songArray.getIDdLabel());
                    }
                }

                break;

            case "Edit":
                System.err.println("Edit");
                GUISong.setMessage( this.songArray.edit(this.dataPanelSong.getSong()));
                this.dataPanelSong.clean();
                break;

            case "Delete":
                System.err.println("Delete");
                GUISong.setMessage( this.songArray.delete(this.dataPanelSong.getSong().getIdSong()));
                this.dataPanelSong.clean();
                break;

            case "Report":
//                System.err.println("Report");
//                GUISong.setMessage(this.songArray.toString());
                this.guiReport = new GUIReport();
                guiReport.setDataTable(this.songArray.getMatrixDataSongs(), Song.TBL_LABELS);
                guiReport.listenMouse(this);
                guiReport.setVisible(true);
                break;

            case "songCombo":
                String id = this.dataPanelSong.getCbSong();
                if (!id.equalsIgnoreCase("Selected option")) {
                    this.song = this.songArray.search(Integer.parseInt(id.substring(0, id.indexOf("-"))));
                    this.dataPanelSong.setSong(song);
                }
                break;

            case "Exit":

                guiSong.dispose();
                break;

        }
    }

    public boolean validationData(Song songValidate) {
        if (songValidate.getTitle().isBlank()) {
            GUISong.setMessage("The title field is empty");
            return false;
        } else if (songValidate.getTime() < 0.1) {
            GUISong.setMessage("The duration field is empty");
            return false;
        } else if (songValidate.getMusicGenre().equals("Selected option")) {
            GUISong.setMessage("The music genre is empty");
            return false;
        } else {
            return true;
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.dataPanelSong.setSong(
                new Song(Integer.parseInt(this.guiReport.getDataRow()[0]),
                this.guiReport.getDataRow()[1],
                Double.parseDouble(this.guiReport.getDataRow()[2]),
                this.guiReport.getDataRow()[3],
                Integer.parseInt(this.guiReport.getDataRow()[4]))
        );
        this.guiReport.dispose();
    }

    @Override
    //Borrar los throwssssssssssssssssssssssssssssssssss
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

}//fin class
