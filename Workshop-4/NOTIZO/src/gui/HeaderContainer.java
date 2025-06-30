package gui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.*;

public class HeaderContainer extends JPanel {

    private final String title = Constants.headerTitle;
    private JLabel titleContainer;

    public HeaderContainer() {
        initComponents();
    }

    private void initComponents() {
        adjustPanel();
        addTitleLabel();

    }

    private void addTitleLabel() {
        this.titleContainer = new JLabel(this.title);
        this.titleContainer.setHorizontalAlignment(SwingConstants.CENTER);
        this.titleContainer.setHorizontalTextPosition(SwingConstants.CENTER);
        this.titleContainer.setPreferredSize(new Dimension(200, 50));
        this.titleContainer.setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, Constants.titleDecoColor));
        this.titleContainer.setFont(Constants.titleFont);
        this.add(titleContainer);
    }

    private void adjustPanel() {
        FlowLayout titleLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);
        this.setPreferredSize(new Dimension(500, 122));
        titleLayout.setVgap(Constants.headerTitleSpace);
        titleLayout.setAlignment(FlowLayout.CENTER);
        this.setLayout(titleLayout);
    }

}
