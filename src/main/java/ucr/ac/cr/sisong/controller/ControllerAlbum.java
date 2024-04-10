/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.sisong.model.Album;
import ucr.ac.cr.sisong.model.AlbumArray;
import ucr.ac.cr.sisong.model.Artist;
import ucr.ac.cr.sisong.model.ArtistArray;
import ucr.ac.cr.sisong.model.Song;
import ucr.ac.cr.sisong.model.SongArray;
import ucr.ac.cr.sisong.view.DataPanelSong;
import ucr.ac.cr.sisong.view.GUIAlbum;
import ucr.ac.cr.sisong.view.GUISong;

/**
 *
 * @author Stephanie
 */
class ControllerAlbum implements ActionListener, MouseListener {

    private GUIAlbum guiAlbums;
    private DataPanelSong dataPanel;
    private SongArray songArray;
    private ArtistArray artistArray;
    private Album album;
    private AlbumArray albumArray;

    public ControllerAlbum(SongArray songArray, ArtistArray artistArray, AlbumArray albumArray) {
        this.guiAlbums = new GUIAlbum();
        this.songArray = songArray;
        this.artistArray = artistArray;
        this.albumArray = albumArray;
        guiAlbums.setDataTableSongRegistered(this.songArray.getMatrixDataSongs(), Song.TBL_LABELS);
        guiAlbums.setDataTableArtistRegistered(this.artistArray.getMatrixArtist(), Artist.TB_LABELS);
        guiAlbums.setDataTableSongToAlbum(new String[0][0], Song.TBL_LABELS);
        guiAlbums.setDataTableArtistToAlbum(new String[0][0], Artist.TB_LABELS);
        guiAlbums.listenMouse(this);
        guiAlbums.listenBottons(this);
        this.guiAlbums.setVisible(true);

    }

    public boolean validateAlbum(Album albumValidate) {
        if (albumValidate.getTitle().isBlank()) {
            GUISong.setMessage("The title field is empty");
            return false;
        } else if (albumValidate.getReleaseDate() == 0) {
            GUISong.setMessage("The released year is empty");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Close":
                guiAlbums.dispose();
                break;
            case "Add":
                System.out.println("Nashe");
                Album album = guiAlbums.getAlbum(artistArray.getArrayArtistToAlbum(), songArray.getArraySongToAlbum());
                if (this.validateAlbum(album)) {
                    albumArray.addAlbum(album);
                }
                break;
        }
        artistArray.limpiarLista();
        songArray.limpiarLista();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == guiAlbums.getTableRegisteredSongs()) {

            this.songArray.addSongSelected(new Song((Integer.parseInt(this.guiAlbums.getDataRowRegisteredSongs()[0])),
                    this.guiAlbums.getDataRowRegisteredSongs()[1],
                    Double.parseDouble(this.guiAlbums.getDataRowRegisteredSongs()[2]),
                    this.guiAlbums.getDataRowRegisteredSongs()[3],
                    Integer.parseInt(this.guiAlbums.getDataRowRegisteredSongs()[4])));

            guiAlbums.setDataTableSongToAlbum(this.songArray.getMatrixDataSongsSelected(), Song.TBL_LABELS);
//            guiAlbums.clearSelection();
        }

        else if (e.getSource() == guiAlbums.getTableRegisteredArtist()) {

            this.artistArray.addArtistSelected(new Artist(this.guiAlbums.getDataRowRegisteredArtist()[0],
                    this.guiAlbums.getDataRowRegisteredArtist()[1],
                    this.guiAlbums.getDataRowRegisteredArtist()[2]));
            guiAlbums.setDataTableArtistToAlbum(this.artistArray.getMatrixArtistToAlbum(), Artist.TB_LABELS);
//            guiAlbums.clearSelection();
        }

        //Para eliminar
        else if (e.getSource() == guiAlbums.getTableSongToAlbum()) {
            System.out.print(guiAlbums.getSelectedRowSong());
            this.songArray.deleteSongSelected(guiAlbums.getSelectedRowSong());

            guiAlbums.setDataTableSongToAlbum(this.songArray.getMatrixDataSongsSelected(), Song.TBL_LABELS);
            guiAlbums.clearSelection();

        }

        else {
            System.out.print(guiAlbums.getSelectedRowArtist());
            this.artistArray.deleteArtistSelected(guiAlbums.getSelectedRowArtist());
            guiAlbums.setDataTableArtistToAlbum(this.artistArray.getMatrixArtistToAlbum(), Artist.TB_LABELS);
            guiAlbums.clearSelection();

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

}
