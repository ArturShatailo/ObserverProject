package service;

import java.util.HashSet;
import java.util.Set;

public interface Statics {

    /*
    Collection of registered User objects. Two and more equals User objects cannot be added because of HashSet collection is used.
    */
    Set<User> users = new HashSet<>();

    NewsPortal newsPortal = new NewsPortal();

    FilmsPortal filmsPortal = new FilmsPortal();

}
