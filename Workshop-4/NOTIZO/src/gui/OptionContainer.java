package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionContainer extends JPanel{

    private ArrayList <JButton> sections;

    public OptionContainer(){
        FlowLayout titleLayout = new FlowLayout();
        titleLayout.setVgap(Constants.optionContainerVSpace);
        titleLayout.setHgap(Constants.optionContainerHSpace);
        titleLayout.setAlignment(FlowLayout.LEFT);
        this.setLayout(titleLayout);
        initComponents();
    }

    private void initComponents(){
        this.sections = new ArrayList<>();
        for (int i = 0; i < Constants.optionTitles.length; i++) {
            String val = Constants.optionTitles[i];
            createButton(val);
        }
        this.add(sections.get(1));
        this.add(sections.get(2));
    }

    private void createButton(String buttonText){
        JButton button = new JButton(buttonText);
        button.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Constants.optionDecoColor));
        button.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        button.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        this.sections.add(button);
        button.setActionCommand(buttonText);
    }

    public void displayOptionsExcept(int exceptIdx){
        this.removeAll();
        for (int i = 0; i < sections.size(); i++) {
            if (i != exceptIdx) {
                this.add(sections.get(i));
            }
        }
        this.revalidate();
        this.repaint();
    }

    public ArrayList<JButton> getOptions(){
        return this.sections;
    }

}
