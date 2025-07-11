package model;

import java.util.ArrayList;
import java.util.List;

public class InternationalNewsSection extends Section {
    private String nationalCountry;

    public InternationalNewsSection(String name, String nationalCountry) {
        super(name, new ArrayList<>());
        this.nationalCountry = nationalCountry;
    }

    @Override
    public void addNews(News news) {
        if (isInternationalNews(news)) {
            super.addNews(news);
        } else {
            throw new IllegalArgumentException("National news cannot be added to the international section.");
        }
    }

    private boolean isInternationalNews(News news) {
        if (news instanceof InternationalNews) {
            InternationalNews intlNews = (InternationalNews) news;
            return intlNews.getCountry() != null && 
                    !intlNews.getCountry().trim().equalsIgnoreCase(nationalCountry);
        }
        return false;
    }

    @Override
    public List<News> getLatestNews(int limit) {
        return newsList.subList(0, Math.min(limit, newsList.size()));
    }

    @Override
    public List<News> getFeaturedNews(int limit) {
        List<News> featured = new ArrayList<>();
        for (News news : newsList) {
            if (news.isFeaturedNew() && featured.size() < limit) {
                featured.add(news);
            }
        }
        return featured;
    }

    @Override
    public void displayLatestNews() {
        System.out.println("--- Section: " + this.getName() + " ---");
        List<News> latestNews = this.getLatestNews(9);
        if (latestNews.isEmpty()) {
            System.out.println("No recent news in this section.");
        } else {
            for (News news : latestNews) {
                System.out.println(news.getTitle() + " - " + 
                    ((InternationalNews)news).getCountry());
            }
        }
    }
}