package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Section {
    private String name;
    protected List<News> newsList;

    public Section(String name, List<News> newsList) {
        this.name = name;
        this.newsList = new ArrayList<>(newsList);
    }

    protected void addNews(News news) {
        if (news != null) {
            this.newsList.add(news);
        }
    }

    protected void removeNews(News news) {
        this.newsList.remove(news);
    }

    public void displayLatestNews() {
        System.out.println("--- Section: " + this.name + " ---");
        List<News> latestNews = this.getLatestNews(9);
        if (latestNews.isEmpty()) {
            System.out.println("No recent news in this section.");
        } else {
            for (News news : latestNews) {
                System.out.println(news.getTitle());
            }
        }
    }

    public abstract List<News> getFeaturedNews(int limit);
    public abstract List<News> getLatestNews(int limit);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("The name of the section cannot be empty");
        }
        this.name = name;
    }
}