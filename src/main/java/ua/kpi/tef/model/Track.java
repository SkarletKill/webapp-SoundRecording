package ua.kpi.tef.model;

/**
 * Created by SkarletRED on 17.04.2018.
 */

public class Track {
    private String title;
    private String artist;
    private String album;
    private MusicGenre genre;
    private int year;
    private int durationMS;         //in milliseconds
    private int sizeKB;             //in kilobytes

    public Track() {
        fillDefaultValues();
    }

    public Track(String title, int durationMS, int sizeKB) {
        this.title = title;
        this.durationMS = durationMS;
        this.sizeKB = sizeKB;
    }

    public Track(String title, String artist, String album, MusicGenre genre, int year, int durationMS, int sizeKB) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.year = year;
        this.durationMS = durationMS;
        this.sizeKB = sizeKB;
    }

    private void fillDefaultValues() {
        this.title = "unknown";
        this.artist = "unknown";
        this.album = "unknown";
        this.genre = MusicGenre.TRASH;
        this.year = 1970;
        this.durationMS = 180_000;                      //3 minutes
        this.sizeKB = (int) (4e-2 * durationMS);        //2.4 megabytes per minutes
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public int getDuration() {
        return durationMS;
    }

    public int getSizeKB() {
        return sizeKB;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDurationMS(int durationMS) {
        this.durationMS = durationMS;
    }

    public void setSizeKB(int sizeKB) {
        this.sizeKB = sizeKB;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{title: " + this.title
                + ", artist: " + artist
                + ", album: " + album
                + ", genre: " + genre.name()
                + ", year: " + year
                + ", durationMS: " + durationMS
                + ", sizeKB: " + sizeKB;
    }
}
