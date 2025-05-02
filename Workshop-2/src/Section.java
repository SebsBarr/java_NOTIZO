//* This is the Section class that separates the different news sections and creates lists with the latest news depending on the section */

import java.util.ArrayList;
import java.util.List;

public class Section {

    //Attributes
    private String name;
    private List<News> newsList;

    //Constructor 
    public Section(String name, List<News>, newsList){
        this.name = name;
        this.newsList = newsList;
    }

    //methoods

    private News addNews(news){

    }

    //getters

    private List<News> getLatestNews (int limit){


    }

    //Setters

    public void setName( String name){
        if (name == null){
            throw new IllegalArgumentException (" The name of the section cannot be empty ");
        }
        this.name = name;
    }
    
}
