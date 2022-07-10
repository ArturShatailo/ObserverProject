package entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NewsPortal implements Portal {

    private ArrayList<Resource> news = new ArrayList<>();
    private Set<Follower> followers = new HashSet<>();

    public Set<Follower> getFollowers() {
        return followers;
    }

    @Override
    public void addSubscriber(Follower f) {
        followers.add(f);
    }

    @Override
    public void removeSubscriber(Follower f) {
        followers.remove(f);
    }

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

    @Override
    public void sendNotification(Resource resource) {
        followers.forEach( n -> n.update(resource));
    }

    @Override
    public void addDashboard(Resource resource) {
        followers.forEach(n -> n.addToDashboard(resource));
    }



}
