package entity;

import java.util.HashSet;
import java.util.Set;

public interface Statics {

    Set<User> users = new HashSet<>();

    static NewsPortal newsPortal = new NewsPortal();

    static FilmsPortal filmsPortal = new FilmsPortal();

}
