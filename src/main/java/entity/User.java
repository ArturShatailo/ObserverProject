package entity;

import java.util.ArrayList;
import java.util.List;

public class User implements Follower {

    private final String name;

    private final String email;

    private final List<Resource> dashboard = new ArrayList<>();

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public void update(Resource content) {
        System.out.println(name + "(" + email + ")" + " got "+"\n"+content+"\n\n");
    }

    @Override
    public void addToDashboard(Resource content) {
        dashboard.add(content);
    }

    @Override
    public void showDashboard() {
        dashboard.forEach(System.out::println);
    }

    @Override
    public void subscribeRequest(Portal portal) {
        portal.addSubscriber(this);
    }

    @Override
    public void unsubscribeRequest(Portal portal) {
        portal.removeSubscriber(this);
    }
}
