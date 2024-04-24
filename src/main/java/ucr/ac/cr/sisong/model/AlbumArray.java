/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.model;

import java.util.ArrayList;

/**
 *
 * @author Stephanie Venegas Villalobos C38405
 */
public class AlbumArray {

    private ArrayList<Album> albumArray;

    public AlbumArray() {
        this.albumArray = new ArrayList<>();
    }

    public String addAlbum(Album album) {

        if (album != null) {
            if (!this.existAlbum(album.getTitle())) {
                this.albumArray.add(album);
            }
            return " Adding album  sucefully";
        }

        return "Error Adding artist\n Lists void or title already exist.";
    }

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

    public boolean existAlbum(String title) {
        for (Album listArtist1 : albumArray) {
            if (listArtist1.getTitle().equalsIgnoreCase(title)) {
                return true;

            }

        }
        return false;
    }

}
