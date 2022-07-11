package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NewsPortal implements Portal {

    private final ArrayList<Resource> news = new ArrayList<>();
    private final Set<Follower> followers = new HashSet<>();

    //Adds received Follower instance 'f' into 'followers' field collection
    @Override
    public void addSubscriber(Follower f) {
        followers.add(f);
    }

    //Removes received Follower instance 'f' from 'followers' field collection
    @Override
    public void removeSubscriber(Follower f) {
        followers.remove(f);
    }

    /*
     * Receives ArrayList 'tags' of Tag objects and Map 'r' with elements and set them as fields of new created
     * Resource object instance of News. This object is added into 'news' collection and sendNotification(), addDashboard() methods are called.
     * Thus, notifications about new News creation will be sent to all subscribers from 'followers' collection field and
     * created News object will be added into their dashboards.
     */
    @Override
    public void addContent(Map<String, String> r, ArrayList<Tag> tags) {
        Resource resource = new News(
                r.get("author"),
                r.get("title"),
                r.get("text"),
                tags);

        news.add(resource);
        sendNotification(resource);
        addDashboard(resource);
    }

    /*
     * Calls method update() of each Follower object instance of User from 'followers' collection and send into this method
     * @param 'resource' as a parameter. Thus, all User objects from 'followers' collection will receive notification.
     */
    @Override
    public void sendNotification(Resource resource) {
        followers.forEach( n -> n.update(resource));
    }

    /*
    * Calls method addToDashboard() of each Follower object instance of User from 'followers' collection and send
    * into this method @param 'resource' as a parameter. Thus, all User objects from 'followers' collection will receive
    * News object into 'dashboard' collections.
    */
    @Override
    public void addDashboard(Resource resource) {
        followers.forEach(n -> n.addToDashboard(resource));
    }



}
