//* This is the International News Section class that generates the list of latest international news, excluding national news */

public class InternationalNewsSection extends Section {

    //Attributes
    private String nationalCountry = "Colombia";

    //Constructor
    public InternationalNewsSection(String nationalCountry){
        super(name, newsList)
        this.nationalCountry = nationalCountry;
    }
    //Methods
    @Override
    public void addNews(News news){
        if (isInternationalNews(news)){
            super.addNews(news);
        } else{
            throw new IllegalArgumentException ("National news cannot be added to the international section.");
        }
    }

    /**
     * This validate International News methood, verifies whether the news is international or not..
     *
     * @param news receives the the news to verify.
     * @return The method returns a boolean whether the news is international or not .
     */
    private boolean isInternationalNews (News news){
        if (news instanceof InternationalNews){

            if ( news != null && news.getCountry() !=null && !news.getCountry().trim().equalsIgnoreCase(nationalCountry)){
                return true;
            }
            return false;
        }
        return false;
    }

    //Getters
    @Override
    public List<News> getLatestNews (int limit){

        
    }
    @Override
    public List<News> getFeaturedNews (int limit){

    }


}