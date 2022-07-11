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

    /*
    * Creates HashMap collection that will be a pattern for further Resource <News> object creating.
    *
    * Creates new HashMap collection 'content'.
    * Values of fields 'author', 'title', 'text' are sent to 'content' as elements with keys "author", "title", "text";
    * Calls method addContent() of 'newsPortal' field implemented from Statics through ViewController abstract class.
    * addContent() receives 'content' collection and result of inputValues() method as parameters.
    * inputValues() receives 'newsTags' field value as a parameter.
    */
    @FXML
    public void onPostNews() {

        Map<String, String> content = new HashMap<>();

        content.put("author", author.getText());
        content.put("title", title.getText());
        content.put("text", newsText.getText());
        newsPortal.addContent(content, inputValues(newsTags.getText()));

    }

    /*
     * Creates HashMap collection that will be a pattern for further Resource <Film> object creating.
     *
     * Creates new HashMap collection 'content'.
     * Values of fields 'director', 'date', 'name', 'overview' are sent to 'content' as elements with keys "director", "date", "name", "overview";
     * Calls method addContent() of 'filmsPortal' field implemented from Statics through ViewController abstract class.
     * addContent() receives 'content' collection and result of inputValues() method as parameters.
     * inputValues() receives 'filmTags' field value as a parameter.
     */
    @FXML
    public void onPostFilm() {

        Map<String, String> content = new HashMap<>();

        content.put("director", director.getText());
        content.put("date", date.getText());
        content.put("name", name.getText());
        content.put("overview", overview.getText());
        filmsPortal.addContent(content, inputValues(filmTags.getText()));

    }


    /*
    * Clears from spaces received String parameter 'values', and splits it into the array dividing after coma;
    * Received String array cast into ArrayList and returns it.
    */
    private static ArrayList<Tag> inputValues(String values) {

        String[] s = values.replaceAll(" ", "").split(",");

        ArrayList<Tag> t = new ArrayList<>();

        for(String string : s){
            t.add(new Tag(string));
        }

        return t;

    }


}
