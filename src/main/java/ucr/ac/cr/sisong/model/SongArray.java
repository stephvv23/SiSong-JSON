/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.model;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Stephanie Venegas Villalobos C38405
 */
public class SongArray {

    private ArrayList<Song> listSongs;
    private ArrayList<Song> listSongsSelected;

    public SongArray() {
        this.getArraySong();
        this.listSongsSelected = new ArrayList<>();

    }

    //Metodo para desmenusar el JSONArray e irlos haciendo en objetos y añadiendo al array
    //es buenoi estarlo actualizando cada que guardamos o editamos y eliminamos
    public void getArraySong() {
        this.listSongs = new ArrayList<>();

        JSONFile jsonFile = new JSONFile("songs.json");
        JSONArray jsonArray = jsonFile.read();
        for (Object object : jsonArray) {

            JSONObject jsonObject = (JSONObject) object;

            Song song = new Song();

            song.setIdSong(Integer.parseInt(String.valueOf(jsonObject.get("id"))));//tener cuidado con las keys
            song.setTitle(String.valueOf(jsonObject.get("title")));
            song.setMusicGenre(String.valueOf(jsonObject.get("genre")));
            song.setTime(Double.parseDouble(String.valueOf(jsonObject.get("time"))));
            song.setReleaseYear(Integer.parseInt(String.valueOf(jsonObject.get("year"))));

            this.listSongs.add(song);
        }
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

                JSONFile jsonFile = new JSONFile("songs.json");
                JSONObject jsonObjectAdd = new JSONObject();
                jsonObjectAdd.put("id", song.getIdSong());
                jsonObjectAdd.put("title", song.getTitle());
                jsonObjectAdd.put("genre", song.getMusicGenre());
                jsonObjectAdd.put("time", song.getTime());
                jsonObjectAdd.put("year", song.getReleaseYear());

                jsonFile.writer(jsonObjectAdd);
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
        if (this.listSongs.size() > 0) {
            return listSongs.get(listSongs.size() - 1).getIdSong() + 1;
        }
        return 1;
    }

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

    public ArrayList getArraySongToAlbum() {
        return listSongsSelected;
    }

    public void deleteSongSelected(int index) {
        this.listSongsSelected.remove(index);
    }

    public String[][] getMatrixDataSongsSelected() {
        String[][] matrixDataSongs = new String[this.listSongsSelected.size()][Song.TBL_LABELS.length];
        if (listSongsSelected != null) {
            for (int f = 0; f < matrixDataSongs.length; f++) {
                for (int c = 0; c < matrixDataSongs[0].length; c++) {
                    matrixDataSongs[f][c] = this.listSongsSelected.get(f).getData(c);
                }

            }
            return matrixDataSongs;
        }
        return null;
    }

    //Metodo para limpiar el array
    public void limpiarLista() {
        this.listSongsSelected = new ArrayList<>();
    }
}
