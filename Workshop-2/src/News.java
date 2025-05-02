//* This is the News class that defines the structure of the each news */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class News {

    //Attributes
    private String newId;
    private String title;
    private String content;
    private LocalDate date;
    private boolean isTopStory;
    private String author;
    private String image;

    //Constructor
    public News (String newId, String title, String content, String dateString, String author, boolean isTopStory){

        this.newId = newId;
        this.title = title;
        this.content = content;
        this.date = validateDate(dateString);  //assigns to the date attribute the date of the parameter (string) previously validated
        this.author = author;
        this.isTopStory = isTopStory;

    }

    //Methods

    /**
     * This validateDate methood, converts a date it receives into a string data and passes it to localdate, applying the format specified.
     *
     * @param dateString receives the date in string data in dd/mm/yyyy format.
     * @return The method returns the date in a localdate, considering the restrictions (empty date).
     * @throws IllegalArgumentException If the date string is null or the format is incorrect.
     */
    private LocalDate validateDate (String dateString){

        DateTimeFormatter dateFormatte = DateTimeFormatter.ofpattern("dd/mm/yyyy");

        if (dateString == null){

            throw new IllegalArgumentException (" The date cannot be empty. ");
        }

        try{
            return LocalDate.parse(dateString, dateFormatte);
        } catch (DateTimeParseException e){
            throw new IllegalArgumentException (" The date format is incorrect. Try (dd/mm/yyyy) ");
        }
    }

    

    //getters

    /**
     * This getSummary methood, From the text create a "summary", combining the title, the author and the first characters of the news.
     * @return The method returns brief summary of the news.
     */
    public String getSummary(){
        int maxCharacters = 150;

        if (content.length >= maxCharacters){

            return title +" , "+ author +" : "+ content.substring(0, maxCharacters) +" . . .";
        }
        else {
            return  title +" , "+ author +" : "+ content;
        }

    }
    public String getCountry(){
        return country;
    }

    //Setters

    public void setDate (String dateString){
        this.date = validateDate(dateString);
    }

    private void markAsTopStory(){
        this.isTopStory = true;
    }

    public void setNewId (int newId){

        if ( newId <= 0 ){
            throw new IllegalArgumentException (" The id cannot be a negative number or zero. "); 
        }
        this.newId = newId;
        
    } 

    public void setTitle (String title){
        if (title == null){
            throw new IllegalArgumentException (" The title cannot be null. "); 
        }
        this.title = title;
    } 

    public void setContent (String content){
        if (content == null){
            throw new IllegalArgumentException ("The content cannot be null.");
        }
        this.content = content;
    }

    public void setAuthor (String author){
        if (author == null){
            this.author = "anonymous"; 
        }
        else {
            this.author = author;
        }
    }
   
}
