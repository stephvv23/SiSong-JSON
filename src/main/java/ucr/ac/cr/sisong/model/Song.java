/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.model;

/**
 *
 * @author Stephanie Venegas Villalobos C38405
 */
public class Song {
    
    private int idSong;
    private String title;
    private double time;
    private String musicGenre;
    private int releaseYear;
    ///TITLE_SONGh
    public static final String[] TBL_LABELS = {"ID", "Title", "Duration", "Music genre", "Release year"};

    public Song() {
    }

    public String getData(int colum){
        switch (colum) {
            case 0:return String.valueOf(this.getIdSong());
            case 1: return this.getTitle();
            case 2: return String.valueOf(this.getTime());
            case 3: return this.getMusicGenre();
            case 4: return String.valueOf(this.getReleaseYear());
        }
        return "";
    }
    
    public Song(int idSong, String title, double time, String musicGenre, int releaseYear) {
        this.idSong = idSong;
        this.title = title;
        this.time = time;
        this.musicGenre = musicGenre;
        this.releaseYear = releaseYear;
    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Song{" + "idSong=" + idSong + ", title=" + title + ", time=" + time + ", musicGenre=" + musicGenre + ", releaseYear=" + releaseYear + '}';
    }

   
    
    
}
