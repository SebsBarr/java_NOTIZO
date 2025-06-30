/* Authors: Nathaly Cisneros
            Sebastian Correa
            
    This is the Homepage of the project where you will find the most relevant news and news sections */

import java.util.ArrayList;
import java.util.List;

public class Homepage{

    //Attributes
    private News mainNews;
    private List<Section> sections;

    //Constructor

    public Homepage(News mainNews, List<Section> sections){

        this.mainNews = mainNews;
        this.sections = sections;

    }

    //Methods

    private void displayMainNews(){

    }
    private void displayFeaturedNews(){

    }
    private void addSection(Section section){
        this.sections.add(section);

    }
    private void removeSection(Section section){
        this.sections.remove(section);

    }
    
}