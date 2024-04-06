/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.model;

import java.util.ArrayList;

/**
 *
 * @author sivv2
 */
public class ArtistArray {

    private ArrayList<Artist> listArtist;

    public ArtistArray() {
        this.listArtist = new ArrayList<>();
    }

    public Artist search(String name) {
        for (Artist artist : listArtist) {
            if (artist.getArtistName().equalsIgnoreCase(name)) {
                return artist;
            }
        }
        return null;
    }

    public String add(Artist artist) {
        if (this.search(artist.getArtistName()) == null) {
            listArtist.add(artist);
            return "Artist succesfuly added";
        }
        return "Error adding song.\nId already added";
    }

    public String delete(String name) {
        if (this.listArtist.remove(this.search(name))) {
            return "Artist delete succesfully!";
        } else {
            return "Artist not found";
        }
    }

    public String edit(Artist artistEdit) {
        for (int i = 0; i < this.listArtist.size(); i++) {
            if (this.listArtist.get(i).getArtistName().equalsIgnoreCase(artistEdit.getArtistName())) {
                this.listArtist.set(i, artistEdit);
                return "Artist edited succesfully!";
            }
        }
        return "Artist not found";
    }

    public String toString() {
        String message = "Artis list: \n";
        for (Artist artist : listArtist) {
            message += artist.toString() + "\n";
        }
        return message;
    }

    public String[] getNameList() {
        String[] idList = new String[this.listArtist.size()];
        for (int i = 0; i < this.listArtist.size(); i++) {
            idList[i] = listArtist.get(i).getArtistName();
        }
        return idList;
    }

    public String[][] getMatrixArtist() {
        String[][] matrizArtist = new String[this.listArtist.size()][Song.TBL_LABELS.length];
        for (int f = 0; f < matrizArtist.length; f++) {
            for (int c = 0; c < matrizArtist[0].length; c++) {
                matrizArtist[f][c] = this.listArtist.get(f).getData(c);
            }

        }
        return matrizArtist;
    }

    public String[][] getMatrixArtistSongs(Song[] listArtistSongs) {
        String[][] matrixArtistSongs = new String[listArtistSongs.length][Song.TBL_LABELS.length];
        for (int f = 0; f < matrixArtistSongs.length; f++) {
            for (int c = 0; c < matrixArtistSongs[0].length; c++) {
                matrixArtistSongs[f][c] = this.listArtist.get(f).getData(c);
            }

        }
        return matrixArtistSongs;
    }

}
