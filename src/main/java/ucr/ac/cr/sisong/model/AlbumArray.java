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
public class AlbumArray {

    private ArrayList<Album> albumArray;

    public AlbumArray() {
        this.getArrayAlbum();
    }

    public void getArrayAlbum() {
        this.albumArray = new ArrayList<>();

        JSONFile jsonFile = new JSONFile("albums.json");
        JSONArray jsonArray = jsonFile.read();

        //OBJETO POR OBJETO
        for (Object object : jsonArray) {

            //obtenemos el jsonObject
            JSONObject jsonObject = (JSONObject) object;

            //le damos los atributos a un nuevo album
            Album album = new Album();

            album.setTitle(String.valueOf(jsonObject.get("title")));//tener cuidado con las keys
            album.setReleaseDate(Integer.parseInt(String.valueOf(jsonObject.get("release date"))));

            //convertir albumSong//
            JSONArray songsArray = (JSONArray) jsonObject.get("songs");
            ArrayList<Song> songAlbum = new ArrayList<>();

            for (Object songObject : songsArray) {

                JSONObject songJson = (JSONObject) songObject;

                Song song = new Song();
                song.setIdSong(Integer.parseInt(String.valueOf(songJson.get("id"))));//tener cuidado con las keys
                song.setTitle(String.valueOf(songJson.get("title")));
                song.setMusicGenre(String.valueOf(songJson.get("genre")));
                song.setTime(Double.parseDouble(String.valueOf(songJson.get("time"))));
                song.setReleaseYear(Integer.parseInt(String.valueOf(songJson.get("year"))));

                songAlbum.add(song);

            }

            album.setSongAlbum(songAlbum);
            //añadido//

            //convertir albumArtist//
            JSONArray artistArray = (JSONArray) jsonObject.get("artists");
            ArrayList<Artist> artistAlbum = new ArrayList<>();

            for (Object aristObject : artistArray) {

                JSONObject artistJson = (JSONObject) aristObject;

                Artist artist = new Artist();

                //String artistName, String musicalGenre, String nation
                artist.setArtistName(String.valueOf(artistJson.get("artistName")));
                artist.setMusicalGenre(String.valueOf(artistJson.get("musicalGenre")));
                artist.setNation(String.valueOf(artistJson.get("nation")));

                artistAlbum.add(artist);

            }

            album.setArtistAlbum(artistAlbum);
            //añadido//

            this.albumArray.add(album);
        }
    }

    public String addAlbum(Album album) {

        if (album != null) {
            if (!this.existAlbum(album.getTitle())) {

                //creamos el file
                JSONFile jsonFile = new JSONFile("albums.json");
                JSONObject jsonObjectAdd = new JSONObject();// creamos el objeto general o album como tal

                jsonObjectAdd.put("title", album.getTitle());//a este edamos titulo y fecha
                jsonObjectAdd.put("release date", album.getReleaseDate());

                JSONArray jasonArrarArtist = new JSONArray();//creamos el array de artistas

                for (Artist artist : album.getArtistAlbum()) {//artista por artista vamos creando un jsonObject que obtene los datos del objeto en el array

                    JSONObject jsonArtist = new JSONObject();

                    jsonArtist.put("artistName", artist.getArtistName());
                    jsonArtist.put("musicalGenre", artist.getMusicalGenre());
                    jsonArtist.put("nation", artist.getNation());

                    jasonArrarArtist.add(jsonArtist);
                }

                jsonObjectAdd.put("artists", jasonArrarArtist);//se añade en el object general

                JSONArray jasonArrarSong = new JSONArray();

                for (Song song : album.getSongAlbum()) {

                    JSONObject jsonSong = new JSONObject();

                    jsonSong.put("id", song.getIdSong());
                    jsonSong.put("title", song.getTitle());
                    jsonSong.put("music genre", song.getMusicGenre());
                    jsonSong.put("release year", song.getReleaseYear());
                    jsonSong.put("time", song.getTime());

                    jasonArrarSong.add(jsonSong);
                }

                jsonObjectAdd.put("songs", jasonArrarSong);

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
