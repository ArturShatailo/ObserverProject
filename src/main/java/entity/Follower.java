package entity;

public interface Follower {

    void update(Resource r);

    void subscribeRequest(Portal p);

    void unsubscribeRequest(Portal p);

    void addToDashboard(Resource r);

    //void showDashboard();

}
