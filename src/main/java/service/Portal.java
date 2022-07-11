package service;

import java.util.ArrayList;
import java.util.Map;

public interface Portal {

    void addSubscriber(Follower f);

    void removeSubscriber(Follower f);

    void sendNotification(Resource r);

    void addDashboard(Resource r);

    void addContent(Map<String, String> r, ArrayList<Tag> t);

}
