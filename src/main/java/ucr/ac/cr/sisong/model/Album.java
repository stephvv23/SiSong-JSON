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
public class Album {

    private String title;
    private int releaseDate;
    private ArrayList<Artist> artistAlbum;
    private ArrayList<Song> songAlbum;

    public Album(String title, int releaseDate, ArrayList<Artist> artistAlbum, ArrayList<Song> songAlbum) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.artistAlbum = artistAlbum;
        this.songAlbum = songAlbum;
    
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<Artist> getArtistAlbum() {
        return artistAlbum;
    }

    public void setArtistAlbum(ArrayList<Artist> artistAlbum) {
        this.artistAlbum = artistAlbum;
    }

    public ArrayList<Song> getSongAlbum() {
        return songAlbum;
    }

    public void setSongAlbum(ArrayList<Song> songAlbum) {
        this.songAlbum = songAlbum;
    }
    
    public String[][] getMatrixAlbumSong() {
        String[][] matrixSong = new String[songAlbum.size()][Song.TBL_LABELS.length];
        for (int f = 0; f < matrixSong.length; f++) {
            for (int c = 0; c < matrixSong[0].length; c++) {
                matrixSong[f][c] = songAlbum.get(f).getData(c);
            }
        }
        return matrixSong;

    }

    public String[][] getMatrixAlbumArtist() {

        String[][] matrixArtist = new String[artistAlbum.size()][Artist.TB_LABELS.length];
        for (int f = 0; f < matrixArtist.length; f++) {
            for (int c = 0; c < matrixArtist[0].length; c++) {
                matrixArtist[f][c] = artistAlbum.get(f).getData(c);
            }
        }
        return matrixArtist;

    }

}
