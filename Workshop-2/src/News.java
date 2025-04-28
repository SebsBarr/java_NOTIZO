import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class News {

    //Attributes
    private String newId;
    private String title;
    private String content;
    private LocalDate date;
    private String author;
    private boolean isTopStory;

    //Builder
    public News (String newId, String title, String content, String dateString, String author, boolean isTopStory){

        this.newId = newId;
        this.title = title;
        this.content = content;
        this.date = validateDate(dateString);
        this.author = author;
        this.isTopStory = isTopStory;

    }

    //Methods

    private LocalDate validateDate (String dateString){

        DateTimeFormatter dateFormatte = DateTimeFormatter.ofpattern("dd/mm/yyyy");

        if (dateString == null){

            throw new IllegalArgumentException (" La fecha no puede estar vacia. ");
        }

        try{
            return LocalDate.parse(dateString, dateFormatte);
        } catch (DateTimeParseException e){
            throw new IllegalArgumentException (" El formato de la fecha es erroneo. intente con (dd/mm/yyyy) ");
        }
    }

    //getters

    //Setters

    public void setDate (String dateString){
        this.date = validateDate(dateString);
    }
   
}
