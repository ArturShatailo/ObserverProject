package service;

import java.util.*;
public class User implements Follower {

    private final String name;

    private final String email;

    private final String password;

    private final LinkedList<Resource> dashboard = new LinkedList<>();

    public LinkedList<Resource> getDashboard() {
        return dashboard;
    }

    private final Set<Portal> portals = new HashSet<>();

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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

    @Override
    public void update(Resource content) {
        System.out.println(name + "(" + email + ")" + " got "+"\n"+content+"\n\n");
    }

    @Override
    public void addToDashboard(Resource content) {
        dashboard.addFirst(content);
    }

    @Override
    public void subscribeRequest(Portal portal) {
        portals.add(portal);
        portal.addSubscriber(this);
    }

    @Override
    public void unsubscribeRequest(Portal portal) {
        portals.remove(portal);
        portal.removeSubscriber(this);
    }
}
