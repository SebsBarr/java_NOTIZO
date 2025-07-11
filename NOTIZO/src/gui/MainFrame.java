package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
    private HeaderContainer header;
    private CenterPanel content;

    public MainFrame() {
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        initView();
        pack();
        setVisible(true);
    }

    private void initView() {
        header = new HeaderContainer();
        content = new CenterPanel();
        add(header, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);
    }

    public CenterPanel getCenterPanel() {
        return content;
    }
}