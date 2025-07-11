package model;

public class InternationalNews extends News {
    private String country;
    private String region;

    public InternationalNews(String country, String region, String newId, String title, 
                            String content, String dateString, String author, 
                            boolean isFeaturedNew, NewsImage image) {
        super(newId, title, content, dateString, author, isFeaturedNew, image);
        this.country = country;
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public void setCountry(String country) {
        if (country == null || country.length() > 44) {
            throw new IllegalArgumentException("The country cannot be empty or too long");
        }
        this.country = country;
    }

    public void setRegion(String region) {
        if (region == null || region.length() > 50) {
            throw new IllegalArgumentException("The region cannot be empty or too long");
        }
        this.region = region;
    }

    @Override
    public String getSummary() {
        return super.getSummary() + " (" + country + ", " + region + ")";
    }
}