package ua.kpi.tef.model.DB.entity;

public class Track {
    private int id;
    private String title;
    private String artist;
    private String album;
    private int genreId;
    private int year;
    private int durationMS;         //in seconds
    private int sizeKB;             //in kilobytes

    public Track() {
        this.title = "unknown";
        this.artist = "unknown";
        this.album = "unknown";
        this.genreId = 1;
        this.year = 1970;
        this.durationMS = 180_000;                      //3 minutes
        this.sizeKB = (int) (4e-2 * durationMS);        //2.4 megabytes per minutes
    }

    public Track(int id, String title, String artist, String album, int genreId, int year, int durationMS, int sizeKB) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genreId = genreId;
        this.year = year;
        this.durationMS = durationMS;
        this.sizeKB = sizeKB;
    }

    public Track(String title, int duration, int size) {
        this();

        this.title = title;
        this.durationMS = duration;
        this.sizeKB = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDurationMS() {
        return durationMS;
    }

    public void setDurationMS(int durationMS) {
        this.durationMS = durationMS;
    }

    public int getSizeKB() {
        return sizeKB;
    }

    public void setSizeKB(int sizeKB) {
        this.sizeKB = sizeKB;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{title: " + this.title
                + ", artist: " + artist
                + ", album: " + album
                + ", genreId: " + genreId
                + ", year: " + year
                + ", durationMS: " + durationMS
                + ", sizeKB: " + sizeKB;
    }
}