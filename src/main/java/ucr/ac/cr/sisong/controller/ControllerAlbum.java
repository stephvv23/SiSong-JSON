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
import ucr.ac.cr.sisong.model.Song;
import ucr.ac.cr.sisong.model.SongArray;
import ucr.ac.cr.sisong.view.DataPanelSong;
import ucr.ac.cr.sisong.view.GUIAlbum;

/**
 *
 * @author Stephanie
 */
class ControllerAlbum implements ActionListener, MouseListener {

    private GUIAlbum guiAlbums;
    private DataPanelSong dataPanel;
    private SongArray songArray;
    private ArtistArray artistArray;

    public ControllerAlbum(SongArray songArray, ArtistArray artistArray) {
        this.guiAlbums = new GUIAlbum();
        this.songArray = songArray;
        this.artistArray = artistArray;
        guiAlbums.setDataTableSongRegistered(this.songArray.getMatrixDataSongs(), Song.TBL_LABELS);
        guiAlbums.setDataTableArtistRegistered(this.artistArray.getMatrixArtist(), Artist.TB_LABELS);
        guiAlbums.listenMouse(this);
        this.guiAlbums.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().toString().equals(guiAlbums.getTableRegisteredSongs())) {
            this.songArray.addSongSelected(new Song((Integer.parseInt(this.guiAlbums.getDataRowRegisteredSongs()[0])),
                    this.guiAlbums.getDataRowRegisteredSongs()[1],
                    Double.parseDouble(this.guiAlbums.getDataRowRegisteredSongs()[2]),
                    this.guiAlbums.getDataRowRegisteredSongs()[3],
                    Integer.parseInt(this.guiAlbums.getDataRowRegisteredSongs()[4])));

            guiAlbums.setDataTableSongToAlbum(this.songArray.getMatrixDataSongsSelected(), Song.TBL_LABELS);
        }

        if (e.getSource().toString().equals(guiAlbums.getTableRegisteredArtist())) {
            this.artistArray.addArtistSelected(new Artist(this.guiAlbums.getDataRowRegisteredArtist()[0],
                    this.guiAlbums.getDataRowRegisteredArtist()[1],
                    this.guiAlbums.getDataRowRegisteredArtist()[2]));
            guiAlbums.setDataTableArtistToAlbum(this.artistArray.getMatrixArtistToAlbum(), Artist.TB_LABELS);
        }

        if (e.getSource().toString().equals(guiAlbums.getTableSongToAlbum())) {
            System.out.print(guiAlbums.getSelectedRowSong());
            this.songArray.deleteSongSelected(guiAlbums.getSelectedRowSong());
            guiAlbums.setDataTableSongToAlbum(this.songArray.getMatrixDataSongsSelected(), Song.TBL_LABELS);

        }

        if (e.getSource().toString().equals(guiAlbums.getTableArtistToAlbum())) {
            System.out.print(guiAlbums.getSelectedRowArtist());
            this.artistArray.deleteArtistSelected(guiAlbums.getSelectedRowArtist());
            guiAlbums.setDataTableArtistToAlbum(this.artistArray.getMatrixArtistToAlbum(), Artist.TB_LABELS);

        }
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
