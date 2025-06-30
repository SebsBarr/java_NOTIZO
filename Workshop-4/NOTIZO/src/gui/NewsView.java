// NewsView.java
package gui;

import java.awt.*;
import java.net.URL;
import java.util.List;
import javax.swing.*;
import model.News;

public class NewsView extends JPanel {
    private JPanel headerPanel;
    private JTextArea infoLabel;
    private JLabel newsTitle;

    public NewsView(String title, String sectionInfo) {
        setLayout(new BorderLayout());
        createHeader();
        createTitleLabel(title);
        createInfoLabel(sectionInfo);
        add(headerPanel, BorderLayout.NORTH);
    }

    public void updateNewsList(List<News> newsList) {
        if (getComponentCount() > 1) {
            remove(1);
        }
        createNewsGrid(newsList);
        revalidate();
        repaint();
    }

    private void createHeader() {
        headerPanel = new JPanel();
        headerPanel.setOpaque(false);
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 1));
        headerPanel.setPreferredSize(new Dimension(0, 105));
    }

    private void createTitleLabel(String title) {
        newsTitle = new JLabel(title);
        newsTitle.setHorizontalAlignment(SwingConstants.LEFT);
        newsTitle.setHorizontalTextPosition(SwingConstants.LEFT);
        newsTitle.setFont(Constants.titleFont);
        headerPanel.add(newsTitle);
    }

    private void createInfoLabel(String info) {
        infoLabel = new JTextArea(info);
        infoLabel.setPreferredSize(new Dimension(1000, 50));
        infoLabel.setLineWrap(true);
        infoLabel.setAlignmentX(LEFT_ALIGNMENT);
        infoLabel.setEditable(false);
        infoLabel.setOpaque(false);
        infoLabel.setForeground(Constants.newsInfoColor);
        headerPanel.add(infoLabel);
    }

    private void createNewsGrid(List<News> newsList) {
        int n = newsList.size();
        int cols = 3;
        int rows = (int) Math.ceil(n / (double) cols);
        JPanel auxContainer = new JPanel(new GridLayout(rows, cols, 10, 10));
        auxContainer.setPreferredSize(new Dimension(cols * 180, rows * 220));

        for (News news : newsList) {
            JPanel newsPanel = createNewsPanel(news);
            auxContainer.add(newsPanel);
        }

        add(auxContainer, BorderLayout.CENTER);
    }

    private JPanel createNewsPanel(News news) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        if (news.getImage() != null) {
            JLabel imageLabel = createLabelIcon(news.getImage().getUrl());
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(imageLabel, BorderLayout.CENTER);
        }

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel titleLabel = new JLabel(news.getTitle(), SwingConstants.CENTER);
        titleLabel.setFont(new Font(Font.SERIF, Font.BOLD, 14));

        JTextArea summary = new JTextArea(news.getSummary());
        summary.setEditable(false);
        summary.setLineWrap(true);
        summary.setWrapStyleWord(true);
        summary.setBackground(null);
        summary.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        textPanel.add(titleLabel, BorderLayout.NORTH);
        textPanel.add(summary, BorderLayout.CENTER);
        panel.add(textPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JLabel createLabelIcon(String path) {
        URL location = getClass().getResource(path);
        ImageIcon img = new ImageIcon(location);
        JLabel imgHolder = new JLabel(img);
        imgHolder.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2, true));
        return imgHolder;
    }
}
