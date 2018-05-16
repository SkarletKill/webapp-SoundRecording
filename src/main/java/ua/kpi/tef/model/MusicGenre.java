package ua.kpi.tef.model;

/**
 * Created by SkarletRED on 17.04.2018.
 */

public enum MusicGenre {
    BLUES,
    CORE,
    ELECTRO,
    FLAT,
    JAZZ,
    METAL,
    NIGHTCORE,
    POP,
    RAP,
    ROCK,
    SHANSON,
    TRANCE,
    TRASH;

    public static MusicGenre getGenreByString(String genre){
        for (MusicGenre musicGenre:
            MusicGenre.values()) {
            if(musicGenre.name().equals(genre.toUpperCase())) return musicGenre;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
