package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FilmsPortal implements Portal {

    private final ArrayList<Resource> films = new ArrayList<>();
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
    * Resource object instance of Film. This object is added into 'films' collection and sendNotification(), addDashboard() methods are called.
    * Thus, notifications about new Film creation will be sent to all subscribers from 'followers' collection field and
    * created Film object will be added into their dashboards.
    */
    public void addContent(Map<String, String> r, ArrayList<Tag> tags){
        Resource resource = new Film(
                r.get("director"),
                r.get("date"),
                r.get("name"),
                r.get("overview"),
                tags);

        films.add(resource);
        sendNotification(resource);
        addDashboard(resource);
    }

    /*
    * Calls method update() of each Follower object instance of User from 'followers' collection and send into this method
    * @param 'resource' as a parameter. Thus, all User objects from 'followers' collection will receive notification.
    */
    @Override
    public void sendNotification(Resource resource) {
        followers.forEach(n -> n.update(resource));
    }

    /*
    * Calls method addToDashboard() of each Follower object instance of User from 'followers' collection and send
    * into this method @param 'resource' as a parameter. Thus, all User objects from 'followers' collection will receive
    * Film object into 'dashboard' collections.
    */
    @Override
    public void addDashboard(Resource resource) {
        followers.forEach(n -> n.addToDashboard(resource));
    }

}
