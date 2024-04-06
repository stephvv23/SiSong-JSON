/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sisong.model;

/**
 *
 * @author sivv2
 */
public class Artist {
    private String artistName;
    private String musicalGenre;
    private String nation;
    public static final String[] TB_LABELS = {"NAME", "NATION", "MUSICAL GENRE"};

    public Artist() {
    }

    public Artist(String artistName, String musicalGenre, String nation) {
        this.artistName = artistName;
        this.musicalGenre = musicalGenre;
        this.nation = nation;
      
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getMusicalGenre() {
        return musicalGenre;
    }

    public void setMusicalGenre(String musicalGenre) {
        this.musicalGenre = musicalGenre;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

   

    @Override
    public String toString() {
        return "Artist " + "artistName=" + artistName + ", musicalGenre=" + musicalGenre + ", nation=" + nation  ;
    }

    
}
