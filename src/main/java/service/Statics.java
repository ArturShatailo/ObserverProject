package service;

import java.util.HashSet;
import java.util.Set;

public interface Statics {

    Set<User> users = new HashSet<>();

    NewsPortal newsPortal = new NewsPortal();

    FilmsPortal filmsPortal = new FilmsPortal();

}
