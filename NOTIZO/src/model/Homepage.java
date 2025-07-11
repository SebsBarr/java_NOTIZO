package model;

import java.util.ArrayList;
import java.util.List;

public class Homepage {
    private News mainNews;
    private List<Section> sections;

    public Homepage(News mainNews, List<Section> sections) {
        this.mainNews = mainNews;
        this.sections = new ArrayList<>(sections);
    }

    public void displayMainNews() {
        if (mainNews != null) {
            System.out.println("Title: " + mainNews.getTitle());
            System.out.println("Summary: " + mainNews.getSummary());
        } else {
            System.out.println("There is no main news yet");
        }
    }

    public void displayFeaturedNews(int limit) {
        System.out.println("\n--- Featured News ---");
        for (Section section : sections) {
            List<News> featured = section.getFeaturedNews(limit);
            if (!featured.isEmpty()) {
                System.out.println("In section '" + section.getName() + "':");
                for (News news : featured) {
                    System.out.println("  Featured: " + news.getTitle());
                }
            }
        }
    }

    public void displaySections() {
        System.out.println("\n--- News Sections ---");
        if (sections.isEmpty()) {
            System.out.println("No sections to show.");
        } else {
            for (Section section : sections) {
                section.displayLatestNews();
                System.out.println("--------------------");
            }
        }
    }

    public void addSection(Section section) {
        if (section != null && !this.sections.contains(section)) {
            this.sections.add(section);
            System.out.println("Section '" + section.getName() + "' added.");
        }
    }

    public void removeSection(Section section) {
        if (section != null && this.sections.remove(section)) {
            System.out.println("Section '" + section.getName() + "' removed.");
        } else {
            System.out.println("Section not found or null");
        }
    }

    public News getMainNews() {
        return mainNews;
    }

    public List<Section> getSections() {
        return new ArrayList<>(sections);
    }
}