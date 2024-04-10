/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.model;

import java.util.ArrayList;

/**
 *
 * @author Stephanie
 */
public class AlbumArray {

    private ArrayList<Album> albumArray;

    public AlbumArray() {
        this.albumArray = new ArrayList<>();
    }

    public String addAlbum(Album album) {

        if (album != null) {
            this.albumArray.add(album);
            return " Adding album  sucefully";
        }

        return "Error Adding artist";
    }

//    public String[][] getMatrixAlbumSong() {
//        String[][] matrixArtist = new String[albumArray.size()][Song.TBL_LABELS.length];
//        for (int f = 0; f < matrixArtist.length; f++) {
//            for (int c = 0; c < matrixArtist[0].length; c++) {
//                matrixArtist[f][c] = albumArray.get(f).getSongAlbum().get(f).getData(c);
//            }
//        }
//        return matrixArtist;
//
//    }
//
//    public String[][] getMatrixAlbumArtist(ArrayList<Artist> arrayArtistalbums) {
//
//        String[][] matrixArtist = new String[arrayArtistalbums.size()][Artist.TB_LABELS.length];
//        for (int f = 0; f < matrixArtist.length; f++) {
//            for (int c = 0; c < matrixArtist[0].length; c++) {
//                matrixArtist[f][c] = arrayArtistalbums.get(f).getData(c);
//            }
//        }
//        return matrixArtist;
//
//    }

    public String[] getComboAlbum() {
        String[] idsList = new String[this.albumArray.size()];

        for (int i = 0; i < this.albumArray.size(); i++) {
            idsList[i] = this.albumArray.get(i).getTitle();

        }
        return idsList;
    }

    public Album searchAlbum(String title) {
        for (Album listArtist1 : albumArray) {
            if (listArtist1.getTitle().equalsIgnoreCase(title)) {
                return listArtist1;

            }

        }
        return null;
    }

}
