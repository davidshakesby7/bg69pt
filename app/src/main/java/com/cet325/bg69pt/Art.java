package com.cet325.bg69pt;



public class Art {
// Setting all the methords for the database
    public int id;
    public String artist;
    public String title;
    public String room;
    public String description;
    public String image;
    public int year;
    public int rank;
    public boolean owned;



    public Art (){}

    public Art (String artist, String title, String room, String description, String image, int year, int rank) {
        super();
        this.artist = artist;
        this.title = title;
        this.room = room;
        this.description = description;
        this.image = image;
        this.year = year;
        this.rank = rank;
    }
@Override
    public String toString () {
    return "Art [id=" + id + ", artist=" + artist +
            ", title=" + title + ", room=" + room +
            ", description=" + description + ", image=" + image +
            ", year=" + year + ", rank=" + rank + ", owned=" + owned + "]";
}


}
