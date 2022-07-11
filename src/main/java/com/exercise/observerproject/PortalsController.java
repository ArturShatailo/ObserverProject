package com.exercise.observerproject;

import entity.Tag;
import entity.Tech;
import entity.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PortalsController extends ViewController {

    public TextField director;

    public TextField date;

    public TextField name;

    public TextArea overview;

    public TextArea newsTags;

    public TextArea filmTags;

    public TextField author;

    public TextField title;

    public TextArea newsText;

    public void onPostNews() {

        Map<String, String> content = new HashMap<>();

        content.put("author", author.getText());
        content.put("title", title.getText());
        content.put("text", newsText.getText());
        newsPortal.addContent(content, inputValues(newsTags.getText()));

    }

    public void onPostFilm() {

        Map<String, String> content = new HashMap<>();

        content.put("director", director.getText());
        content.put("date", date.getText());
        content.put("name", name.getText());
        content.put("overview", overview.getText());
        filmsPortal.addContent(content, inputValues(filmTags.getText()));

    }

    private static ArrayList<Tag> inputValues(String values) {

        String[] s = values.replaceAll(" ", "").split(",");

        ArrayList<Tag> t = new ArrayList<>();

        for(String string : s){
            t.add(new Tag(string));
        }

        return t;

    }


}
