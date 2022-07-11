package service;

public class Tag {

    public String link;

    public Tag(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "link: " + link;
    }

}
