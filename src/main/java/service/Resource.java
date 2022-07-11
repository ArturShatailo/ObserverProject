package service;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface Resource {

    Notification getNotification();

    //Class that helps to create objects and paste them into dashboard with the standard pattern and current time of adding.
    class Notification{

        public String title;
        public String date;

        public Notification(String title) {
            this.title = title;
            this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
    }

}
