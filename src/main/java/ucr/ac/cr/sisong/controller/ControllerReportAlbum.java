/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.sisong.model.Album;
import ucr.ac.cr.sisong.model.AlbumArray;
import ucr.ac.cr.sisong.view.GUIReportAlbum;

/**
 *
 * @author Stephanie
 */
public class ControllerReportAlbum implements ActionListener{
    private GUIReportAlbum guiReportAlbum;
    private AlbumArray albumArray;

    public ControllerReportAlbum(AlbumArray albumArray) {
        this.guiReportAlbum = new GUIReportAlbum();
        this.albumArray = albumArray;
        this.guiReportAlbum.setCbAlbum(albumArray.getComboAlbum());
        this.guiReportAlbum.listen(this);
        this.guiReportAlbum.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "cbAlbum":
                Album albumAux = albumArray.searchAlbum(guiReportAlbum.getCbAlbum());
                guiReportAlbum.setAlbum(albumAux.getMatrixAlbumSong(),albumAux.getMatrixAlbumArtist(), albumAux.getReleaseDate());
                break;
            
        }
    }
    
    
}
