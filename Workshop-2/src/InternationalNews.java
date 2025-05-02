//* This is the International News class that in addition to having the general attributes of news, it has geographical attributes */

public class InternationalNews extends News {

    //Attributes
    private String country;
    private String region;

    //Constructor
    public InternationalNews(String country, String region){

        super(nameId, title, content, date, isTopStory, author, image);
        this.country = country;
        this.region = region;
    }
    
    //Setters

    public void setCountry (String country){

        if (country == null || country.length > 44){
            throw new IllegalArgumentException (" The contry cannot be empty or the country should not have a very long name");
        }
        this.contry = country;
    }

    public void setRegion (String region){
        if (region == null || region.length > 50){
            throw new IllegalArgumentException (" The region cannot be empty the region should not have a very long name");
        }
        this.region = region;
    }
}
