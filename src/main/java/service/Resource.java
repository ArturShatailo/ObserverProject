package service;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface Resource {

    Notification getNotification();

    class Notification{
        public String title;
        public String date;

        public Notification(String title) {
            this.title = title;
            this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
    }

}
