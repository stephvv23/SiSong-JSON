/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.sisong.model.AlbumArray;
import ucr.ac.cr.sisong.model.ArtistArray;
import ucr.ac.cr.sisong.model.SongArray;
import ucr.ac.cr.sisong.view.GUIMain;
import ucr.ac.cr.sisong.view.GUIReportAlbum;

/**
 *
 * @author Stephanie
 */
public class ControllerMain implements ActionListener {

    private GUIMain guiMain;
    private GUIReportAlbum guiReportAlbum;
    private ControllerSong controllerSong;
    private SongArray songArray;
    private ArtistArray artistArray;
    private ControllerArtist controllerArtist;
    private ControllerAlbum controllerALbum;
    private ControllerReportAlbum controllerReportAlbum;
    private AlbumArray albumArray;

    public ControllerMain() {
        this.guiMain = new GUIMain();//Crear la instancia
        this.guiMain.listen(this);//Hacer escuchar los botones
        this.songArray = new SongArray();
        this.albumArray = new AlbumArray();
        this.artistArray = new ArtistArray();
        this.guiMain.setVisible(true);//Hacer visible la ventana

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Exit":
                System.exit(0);

                break;
            case "Artist":
                this.controllerArtist = new ControllerArtist(artistArray);
                break;
            case "Songs":
                this.controllerSong = new ControllerSong(songArray);

                break;
            case "Albums":
                this.controllerALbum = new ControllerAlbum(songArray, artistArray, albumArray);
                break;
            case "Album report":
                this.controllerReportAlbum = new ControllerReportAlbum(albumArray);
                break;

        }

    }
}
