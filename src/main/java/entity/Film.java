package entity;

import java.util.ArrayList;

public class Film implements Resource {

    private String director;
    private String date;
    private String name;
    private String overview;
    private ArrayList<Tag> genre;

    private final Notification notification;

    public Film(String director, String name, String date, String overview, ArrayList<Tag> genre) {
        this.director = director;
        this.date = date;
        this.name = name;
        this.overview = overview;
        this.genre = genre;
        this.notification = new Notification(name);
    }

    @Override
    public Notification getNotification(){
        return notification;
    }

    @Override
    public String toString() {
        return "\n"+"director: "+director+"\n"+
                "date: "+date+"\n"+
                "name: "+name+"\n"+
                "overview: "+overview+"\n"+
                "genre: "+genre+"\n";
    }

}
