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
public class SongArray {

    private ArrayList<Song> listSongs;
    private ArrayList<Song> listSongsSelected;

    public SongArray() {
        this.listSongs = new ArrayList<>();
        this.listSongsSelected = new ArrayList<>();
    }

    public Song search(int idSong) {
        for (Song song : this.listSongs) {
            if (song.getIdSong() == idSong) {
                return song;
            }
        }
        return null;
    }

    public String add(Song song) {
        if (song != null) {
            if (this.search(song.getIdSong()) == null) {
                this.listSongs.add(song);
                return "Song added succesfully!";
            } else {
                return "The song is already registred";
            }
        }
        return "Error adding song";
    }//fin metodo

    public String delete(int idSong) {
        if (this.listSongs.remove(this.search(idSong))) {
            return "Song succesfully eliminated";
        }
        return "Error when deleting song";
    }

    public String edit(Song songEdit) {
        for (int i = 0; i < this.listSongs.size(); i++) {
            if (this.listSongs.get(i).getIdSong() == songEdit.getIdSong()) {
                this.listSongs.set(i, songEdit);
                return "Song succesfully modified";
            }
        }
        return "Error while modified song";
    }

    public String toString() {
        String out = "List songs: \n";
        for (Song song : listSongs) {
            out += song + "\n";
        }
        return out;
    }

    public int getIDdLabel() {
        return listSongs.size() + 1;
    }

    //ojo*************************************************************************************************
    public String[] getIDCombo() {
        String[] idsList = new String[this.listSongs.size()];
        for (int i = 0; i < this.listSongs.size(); i++) {
            idsList[i] = this.listSongs.get(i).getIdSong() + "-" + this.listSongs.get(i).getTitle();
        }
        return idsList;
    }

    public String[][] getMatrixDataSongs() {
        String[][] matrixDataSongs = new String[this.listSongs.size()][Song.TBL_LABELS.length];
        for (int f = 0; f < matrixDataSongs.length; f++) {
            for (int c = 0; c < matrixDataSongs[0].length; c++) {
                matrixDataSongs[f][c] = this.listSongs.get(f).getData(c);
            }

        }
        return matrixDataSongs;
    }

    public boolean searchSongSelected(Song song) {
        for (int i = 0; i < listSongsSelected.size(); i++) {
            if (song.getIdSong() == listSongsSelected.get(i).getIdSong()) {
                return true;
            }
        }
        return false;
    }

    public void addSongSelected(Song song) {
        if (searchSongSelected(song) == false) {
            this.listSongsSelected.add(song);
        }
    }

    public void deleteSongSelected(int index) {

        this.listSongsSelected.remove(index);

    }
    
    public String[][] getMatrixDataSongsSelected() {
        String[][] matrixDataSongs = new String[this.listSongsSelected.size()][Song.TBL_LABELS.length];
        for (int f = 0; f < matrixDataSongs.length; f++) {
            for (int c = 0; c < matrixDataSongs[0].length; c++) {
                matrixDataSongs[f][c] = this.listSongsSelected.get(f).getData(c);
            }

        }
        return matrixDataSongs;
    }

}
