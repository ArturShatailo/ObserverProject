package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class News implements Resource {

    private final String author;
    private final String date;
    private final String title;
    private final String text;
    private final ArrayList<Tag> tags;

    /*
    Object of Notification class that is coded in Resource interface and helps to show objects in dashboard with
    the standard pattern and current time of adding for instances of different classes.
     */
    private final Notification notification;

    public News(String author, String title, String text, ArrayList<Tag> tags) {
        this.author = author;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.title = title;
        this.text = text;
        this.tags = tags;
        this.notification = new Notification(title);
    }

    public Notification getNotification(){
        return notification;
    }

    @Override
    public String toString() {
        return "\n"+"author: "+author+"\n"+
                "date: "+date+"\n"+
                "title: "+title+"\n"+
                "text: "+text+"\n"+
                "tags: "+tags+"\n";
    }
}
