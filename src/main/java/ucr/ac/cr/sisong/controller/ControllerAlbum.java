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
import ucr.ac.cr.sisong.view.DataPanelSong;
import ucr.ac.cr.sisong.view.GUIAlbum;

/**
 *
 * @author Stephanie
 */
class ControllerAlbum implements ActionListener, MouseListener{

    private GUIAlbum guiAlbums;
    private DataPanelSong dataPanel;
    private SongArray songArray;

    public ControllerAlbum(SongArray songArray) {
        this.guiAlbums = new GUIAlbum();
        this.songArray = songArray;
        guiAlbums.setDataTable(this.songArray.getMatrixDataSongs(), Song.TBL_LABELS);
        guiAlbums.listenMouse(this);
        this.guiAlbums.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.songArray.addSongSelected(new Song((Integer.parseInt(this.guiAlbums.getDataRow()[0])),
                this.guiAlbums.getDataRow()[1],
                Double.parseDouble(this.guiAlbums.getDataRow()[2]),
                this.guiAlbums.getDataRow()[3],
                Integer.parseInt(this.guiAlbums.getDataRow()[4])));

        guiAlbums.setDataTableAlbum(this.songArray.getMatrixDataSongsSelected(), Song.TBL_LABELS);

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

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

    
