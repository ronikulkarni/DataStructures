/**
 * VinylRecord.java - A class that defines a Vinyl Record
 */


public class VinylRecord  {
    private String albumTitle;
    private String artist;
    private String genre;

    // Constructor that accepts album title, artist, and genre as input parameters
     public VinylRecord(String albumTitle, String artist, String genre) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.genre = genre;
    }

    // Gets the album title
    // @return String, which is the album title
    public String getAlbumTitle() {
        return albumTitle;
    }

    // Gets the album artist
    // @return String, which is the album artist
    public String getArtist() {
        return artist;
    }

    // Gets the album genre
    // @return String, which is the album genre
    public String getGenre() {
        return genre;
    }

    // Sets the album title which is passed as a string to the method
    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    // Sets the album artist which is passed as a string to the method
    public void setArtist(String artist) {
        this.artist = artist;
    }

    //Sets the album genre which is passed as a string to the method
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Override equals() to compare VinylRecord objects based on album title, artist, and genre
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VinylRecord that = (VinylRecord) obj;
        return albumTitle.equals(that.albumTitle) &&
               artist.equals(that.artist) &&
               genre.equals(that.genre);
    }

    // Override toString() for easy display of a VinylRecord's information
    @Override
    public String toString() {
        return "Album: " + albumTitle + ", Artist: " + artist + ", Genre: " + genre;
    }
}