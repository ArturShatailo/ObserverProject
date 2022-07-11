package service;

import java.util.ArrayList;

public class Film implements Resource {

    private final String director;
    private final String date;
    private final String name;
    private final String overview;
    private final ArrayList<Tag> genre;

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
