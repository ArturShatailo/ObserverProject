package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main extends Thread implements Statics{

    public static void main(String[] args) {

        Main thread = new Main();
        thread.start();

    }

    public void start() {

        Map<String, String> content = new HashMap<>();

        System.out.println("Input information of your film: ");
        System.out.print("Input director name ");
        content.put("director", Tech.GetInputStringFunction());
        System.out.print("Input release date ");
        content.put("date", Tech.GetInputStringFunction());
        System.out.print("Input name ");
        content.put("name", Tech.GetInputStringFunction());
        System.out.print("Input short overview ");
        content.put("overview", Tech.GetInputStringFunction());
        System.out.print("Input genre tags (one by one, divide with Enter). Double Enter is exit ");
        filmsPortal.addContent(content, inputValues());


        Map<String, String> content2 = new HashMap<>();

        System.out.println("Input information of your news: ");
        System.out.print("Input author name ");
        content2.put("author", Tech.GetInputStringFunction());
        System.out.print("Input title ");
        content2.put("title", Tech.GetInputStringFunction());
        System.out.print("Input text ");
        content2.put("text", Tech.GetInputStringFunction());
        System.out.print("Input news tags (one by one, divide with Enter). Double Enter is exit ");
        newsPortal.addContent(content2, inputValues());

    }

    private static ArrayList<Tag> inputValues() {

        ArrayList<Tag> t = new ArrayList<>();

        boolean active = true;
        while (active){
            String a = Tech.GetInputStringFunction();
            if (a.equals("")) {
                active = false;
            }else{
                t.add(new Tag(a));
            }
        }

        return t;

    }

}
