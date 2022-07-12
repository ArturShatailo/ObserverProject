package service;

import java.util.*;
public class User implements Follower {

    private final String name;

    private final String email;

    private final String password;

    private final LinkedList<Resource> dashboard = new LinkedList<>();

    private final Set<Portal> portals = new HashSet<>();

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public LinkedList<Resource> getDashboard() {
        return dashboard;
    }

    public Set<Portal> getPortals() {
        return portals;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    //Shows notification in console about receiving it from Portal subscribed to.
    @Override
    public void update(Resource content) {
        System.out.println(name + "(" + email + ")" + " got "+"\n"+content+"\n\n");
    }

    //Adds new Resource object @param 'content' into 'dashboard' collection
    @Override
    public void addToDashboard(Resource content) {
        dashboard.addFirst(content);
    }

    //Adds new Portal object @param 'portal' into 'portals' collection and adds this User object into 'followers'
    //collection field of @param 'portal' by method addSubscriber().
    @Override
    public void subscribeRequest(Portal portal) {
        portals.add(portal);
        portal.addSubscriber(this);
    }

    //Removes Portal object @param 'portal' from 'portals' collection and removes this User object from 'followers'
    //collection field of @param 'portal' by method removeSubscriber().
    @Override
    public void unsubscribeRequest(Portal portal) {
        portals.remove(portal);
        portal.removeSubscriber(this);
    }
}
