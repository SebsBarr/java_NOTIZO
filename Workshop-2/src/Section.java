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

    //Methods

    protected void addNews(News news){
        this.newsList.add(news);

    }
    protected void removeNews(News news){
        this.newsList.remove(news);
    }
    private void displayLatestNews (){

    }

    //Getters

    public List<News> getLatestNews (int limit){


    }
    public List<News> getFeaturedNews (int limit){

    }

    //Setters

    public void setName( String name){
        if (name == null){
            throw new IllegalArgumentException (" The name of the section cannot be empty ");
        }
        this.name = name;
    }
    
}
