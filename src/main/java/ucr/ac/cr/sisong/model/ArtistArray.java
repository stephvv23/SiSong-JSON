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

    public Artist search(int id) {
        for (Artist artist : listArtist) {
            if (artist.getId() == id) {
                return artist;
            }
        }
        return null;
    }

    public String add(Artist artist) {
        this.listArtist.add(artist);
        return "Artist added succesfully!";
    }

    public String delete(int id) {
        if (this.listArtist.remove(this.search(id))) {
            return "Artist delete succesfully!";
        } else {
            return "Artist not found";
        }
    }

    public String edit(Artist artistEdit) {
        for (int i = 0; i < this.listArtist.size(); i++) {
            if (this.listArtist.get(i).getId() == artistEdit.getId()) {
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

    public int getIdArtist() {
        return listArtist.size() +1;
    }

    public String[] getIDList() {
        String[] idList = new String[this.listArtist.size()];
        for (int i = 0; i < this.listArtist.size(); i++) {
            idList[i] = Integer.toString(listArtist.get(i).getId());
        }
        return idList;
    }
    
    public String[][] getMatrixArtist(){
        String[][] matrizArtist = new String[listArtist.size()][Artist.TB_LABELS.length];
        for(int i = 0; i < listArtist.size(); i++) {
            matrizArtist[i][0] = Integer.toString(listArtist.get(i).getId());
            matrizArtist[i][1] = listArtist.get(i).getArtistName();
            matrizArtist[i][2] = listArtist.get(i).getNation();
            matrizArtist[i][3] = listArtist.get(i).getMusicalGenre();
        }
        return matrizArtist;
    }
}