package gui;

import java.awt.*;
import javax.swing.*;

public class CenterPanel extends JPanel {
    private OptionContainer sectionOptions;
    private StartPanel defaultSartPanel;
    private NewsView recentNews;
    private NewsView internationalNews;
    private CardLayout layout;
    private JPanel innerContainer;

    public CenterPanel() {
        layout = new CardLayout();
        this.setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        this.innerContainer = new JPanel();
        this.innerContainer.setLayout(layout);
        this.defaultSartPanel = new StartPanel();
        this.sectionOptions = new OptionContainer();
        this.recentNews = new NewsView(Constants.news_title[0], Constants.news_info[0]);
        this.internationalNews = new NewsView(Constants.news_title[1], Constants.news_info[1]);
        
        addPaneToLayout(this.defaultSartPanel, Constants.optionTitles[0]);
        addPaneToLayout(this.recentNews, Constants.optionTitles[1]);
        addPaneToLayout(this.internationalNews, Constants.optionTitles[2]);
        
        this.add(innerContainer, BorderLayout.CENTER);
        this.add(sectionOptions, BorderLayout.NORTH);
    }

    private void addPaneToLayout(JPanel desiredPanel, String name) {
        innerContainer.add(desiredPanel, name);
    }

    public void displayPanel(String panelName) {
        this.layout.show(this.innerContainer, panelName);
    }

    public OptionContainer getSectionOptions() {
        return sectionOptions;
    }

    public StartPanel getDefaultSartPanel() {
        return defaultSartPanel;
    }

    public NewsView getRecentNews() {
        return recentNews;
    }

    public NewsView getInternationalNews() {
        return internationalNews;
    }
}