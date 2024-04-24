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
public class ArtistArray {

    private ArrayList<Artist> listArtist;
    private ArrayList<Artist> listArtistToAlbum;

    public ArtistArray() {
        this.getArrayArtist();
        this.listArtistToAlbum = new ArrayList<>();
    }

    public void getArrayArtist() {
        this.listArtist = new ArrayList<>();

        JSONFile jsonFile = new JSONFile("artist.json");
        JSONArray jsonArray = jsonFile.read();
        for (Object object : jsonArray) {

            JSONObject jsonObject = (JSONObject) object;

            Artist artist = new Artist();

            //String artistName, String musicalGenre, String nation
            artist.setArtistName(String.valueOf(jsonObject.get("artistName")));//tener cuidado con las keys
            artist.setMusicalGenre(String.valueOf(jsonObject.get("musicalGenre")));
            artist.setNation(String.valueOf(jsonObject.get("nation")));

            this.listArtist.add(artist);
        }
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

            JSONFile jsonFile = new JSONFile("artist.json");
            JSONObject jsonObjectAdd = new JSONObject();

            //String artistName, String musicalGenre, String nation
            jsonObjectAdd.put("artistName", artist.getArtistName());
            jsonObjectAdd.put("musicalGenre", artist.getMusicalGenre());
            jsonObjectAdd.put("nation", artist.getNation());

            jsonFile.writer(jsonObjectAdd);
            return "Artist succesfuly added";
        }
        return "Error adding Artist.\nName already added";
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
        String[][] matrizArtist = new String[this.listArtist.size()][Artist.TB_LABELS.length];
        for (int f = 0; f < matrizArtist.length; f++) {
            for (int c = 0; c < matrizArtist[0].length; c++) {
                matrizArtist[f][c] = this.listArtist.get(f).getData(c);
            }

        }
        return matrizArtist;
    }

    //***************************************************************
    public boolean searchArtistSelected(Artist artist) {
        for (int i = 0; i < listArtistToAlbum.size(); i++) {
            if (artist.getArtistName().equals(listArtistToAlbum.get(i).getArtistName())) {
                return true;
            }
        }
        return false;
    }

    public void addArtistSelected(Artist artist) {
        if (searchArtistSelected(artist) == false) {
            this.listArtistToAlbum.add(artist);
        }
    }

    public void deleteArtistSelected(int index) {

        this.listArtistToAlbum.remove(index);

    }

    public ArrayList getArrayArtistToAlbum() {
        return listArtistToAlbum;
    }

    public void cleanListArtistSelected() {
        listArtistToAlbum.clear();
    }

    public String[][] getMatrixArtistToAlbum() {
        String[][] matrixArtistAlbum = new String[listArtistToAlbum.size()][Artist.TB_LABELS.length];
        if (listArtistToAlbum != null) {
            for (int f = 0; f < matrixArtistAlbum.length; f++) {
                for (int c = 0; c < matrixArtistAlbum[0].length; c++) {
                    matrixArtistAlbum[f][c] = this.listArtistToAlbum.get(f).getData(c);
                }

            }
            return matrixArtistAlbum;
        }
        return null;
    }

    //Metodo para limpiar el array
    public void limpiarLista() {
        this.listArtistToAlbum = new ArrayList<>();
    }
}
