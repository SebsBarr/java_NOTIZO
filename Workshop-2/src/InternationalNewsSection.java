//* This is the International News Section class that generates the list of latest international news, excluding national news */

public class InternationalNewsSection extends Section {

    //Constructor
    public InternationalNewsSection(){
        super(name, newsList)
    }
    //methoods

    /**
     * This validate International News methood, verifies whether the news is international or not..
     *
     * @param news receives the the news to verify.
     * @return The method returns a boolean whether the news is international or not .
     */
    private boolean isInternationalNews (News news){
        
        String nationalCountry = "Colombia";
        if ( news != null && news.getCountry() !=null && !news.getCountry().trim().equalsIgnoreCase(nationalCountry)){
            return true;
        }
        return false;

    }

}