package controllers;

import javafx.fxml.FXML;
import service.Tag;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PortalsController extends ViewController {
    @FXML
    public TextField director;
    @FXML
    public TextField date;
    @FXML
    public TextField name;
    @FXML
    public TextArea overview;
    @FXML
    public TextArea newsTags;
    @FXML
    public TextArea filmTags;
    @FXML
    public TextField author;
    @FXML
    public TextField title;
    @FXML
    public TextArea newsText;

    @FXML
    public void onPostNews() {

        Map<String, String> content = new HashMap<>();

        content.put("author", author.getText());
        content.put("title", title.getText());
        content.put("text", newsText.getText());
        newsPortal.addContent(content, inputValues(newsTags.getText()));

    }
    @FXML
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
