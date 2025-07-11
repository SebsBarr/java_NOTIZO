package gui;

import java.awt.*;
import java.net.URL;
import javax.swing.*;
import model.News;

public class StartPanel extends JPanel {
    private JTextArea infoLabel;
    private JLabel newsTitle;
    private JPanel headerPanel;
    private String imgRoute = Constants.newsStart[0];
    private JLabel imgDescription;
    private JLabel imgHolder;
    private JPanel cenerPanel;

    public StartPanel() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        createHeader();
        createInfoLabel(Constants.secInfo);
        createTitleLabel(Constants.newsTitle);
        this.add(headerPanel, BorderLayout.NORTH);
        createCenterInfo();
        createOtherNews();
    }

    public void updateWithNews(News news) {
        if (news.getImage() != null) {
            URL location = this.getClass().getResource(news.getImage().getUrl());
            if (location != null) {
                ImageIcon img = new ImageIcon(location);
                imgHolder.setIcon(img);
            }
        }
        
        this.newsTitle.setText(news.getTitle());
        this.imgDescription.setText(news.getSummary());
    }

    public void createHeader() {
        this.headerPanel = new JPanel();
        this.headerPanel.setOpaque(false);
        this.headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 1));
        this.headerPanel.setPreferredSize(new Dimension(0, 105));
    }

    public void createTitleLabel(String title) {
        this.newsTitle = new JLabel(title);
        this.newsTitle.setHorizontalAlignment(SwingConstants.LEFT);
        this.newsTitle.setHorizontalTextPosition(SwingConstants.LEFT);
        this.newsTitle.setFont(Constants.titleFont);
        this.headerPanel.add(newsTitle);
    }

    public void createInfoLabel(String info) {
        this.infoLabel = new JTextArea(info);
        this.infoLabel.setPreferredSize(new Dimension(1000, 50));
        this.infoLabel.setLineWrap(true);
        this.infoLabel.setAlignmentX(LEFT_ALIGNMENT);
        this.infoLabel.setEditable(false);
        this.infoLabel.setForeground(Color.DARK_GRAY);
        this.infoLabel.setOpaque(false);
        this.infoLabel.setForeground(Constants.newsInfoColor);
        this.headerPanel.add(infoLabel);
    }

    private void createCenterInfo() {
        URL location = this.getClass().getResource(this.imgRoute);
        ImageIcon img = new ImageIcon(location);

        this.cenerPanel = new JPanel(new BorderLayout());
        JPanel imgAndDescPanel = new JPanel();
        imgAndDescPanel.setLayout(new BoxLayout(imgAndDescPanel, BoxLayout.Y_AXIS));
        imgAndDescPanel.setOpaque(false);

        this.imgHolder = new JLabel(img);
        imgHolder.setAlignmentX(CENTER_ALIGNMENT);
        imgHolder.setHorizontalAlignment(SwingConstants.CENTER);
        imgHolder.setVerticalAlignment(SwingConstants.TOP);

        JPanel descPanel = new JPanel();
        descPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 50));
        descPanel.setOpaque(false);
        this.imgDescription = new JLabel(Constants.imgDescription);
        this.imgDescription.setHorizontalAlignment(SwingConstants.LEFT);
        this.imgDescription.setHorizontalTextPosition(SwingConstants.LEFT);
        this.imgDescription.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        this.imgDescription.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 0, 0));
        descPanel.add(this.imgDescription);

        imgAndDescPanel.add(imgHolder);
        imgAndDescPanel.add(descPanel);

        JPanel centerWrapper = new JPanel();
        centerWrapper.setOpaque(false);
        centerWrapper.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        centerWrapper.add(imgAndDescPanel);

        this.cenerPanel.add(centerWrapper, BorderLayout.CENTER);
        this.add(this.cenerPanel, BorderLayout.CENTER);
    }

    private void createOtherNews() {
        int n = Math.min(Constants.newsStart.length - 1, Constants.newsDescripStart.length - 1);
        int cols = 3;
        int rows = (int) Math.ceil(n / (double) cols);
        int cellSize = 110; 
        JPanel auxContainer = new JPanel(new GridLayout(rows, cols, 10, 10));
        auxContainer.setOpaque(false);
        for (int i = 1; i <= n; i++) {
            JPanel cell = new JPanel();
            cell.setLayout(new BoxLayout(cell, BoxLayout.Y_AXIS));
            cell.setOpaque(false);
            cell.setPreferredSize(new Dimension(cellSize, cellSize+50));
            cell.setMaximumSize(new Dimension(cellSize, cellSize));
            cell.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(200,200,200), 1, true));

            JLabel auxImg = createLabelIconScaled(Constants.newsStart[i], cellSize +50, cellSize +10);
            auxImg.setAlignmentX(CENTER_ALIGNMENT);

            JTextArea auxDesc = new JTextArea(Constants.newsDescripStart[i]);
            auxDesc.setLineWrap(true);
            auxDesc.setWrapStyleWord(true);
            auxDesc.setEditable(false);
            auxDesc.setOpaque(false);
            auxDesc.setFocusable(false);
            auxDesc.setForeground(Color.black);
            auxDesc.setAlignmentX(CENTER_ALIGNMENT);
            auxDesc.setMaximumSize(new Dimension(cellSize - 16, 48));
            auxDesc.setPreferredSize(new Dimension(cellSize - 16, 32));
            auxDesc.setRows(2);

            cell.add(auxImg);
            cell.add(auxDesc);
            auxContainer.add(cell);
        }

        this.add(auxContainer, BorderLayout.SOUTH);
    }

    private JLabel createLabelIconScaled(String path, int width, int height) {
        URL location = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(location);
        java.awt.Image scaled = icon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaled);
        JLabel imgHolder = new JLabel(scaledIcon);
        imgHolder.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 2, true));
        return imgHolder;
    }
}