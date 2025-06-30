// NewsPresenter.java
package presenter;

import gui.*;
import model.*;
import java.util.List;

public class NewsPresenter {
    private MainFrame view;
    private Homepage model;

    public NewsPresenter(MainFrame view, Homepage model) {
        this.view = view;
        this.model = model;
        initialize();
    }

    private void initialize() {
        setupMainNews();
        setupSectionListeners();
    }

    private void setupMainNews() {
        News mainNews = model.getMainNews();
        if (mainNews != null) {
            view.getCenterPanel().getDefaultSartPanel().updateWithNews(mainNews);
        }
    }

    private void setupSectionListeners() {
        CenterPanel centerPanel = view.getCenterPanel();
        OptionContainer options = centerPanel.getSectionOptions();

        for (int i = 0; i < options.getOptions().size(); i++) {
            final int idx = i;
            options.getOptions().get(i).addActionListener(e -> {
                handleSectionSelection(Constants.optionTitles[idx]);
                options.displayOptionsExcept(idx);
            });
        }
    }

    private void handleSectionSelection(String sectionName) {
        CenterPanel centerPanel = view.getCenterPanel();
        centerPanel.displayPanel(sectionName);

        switch (sectionName) {
            case "Inicio":
                setupMainNews();
                break;
            case "Últimas noticias":
                showRecentNews();
                break;
            case "Noticias internacionales":
                showInternationalNews();
                break;
        }
    }

    private Section findSection(String name) {
        return model.getSections()
                    .stream()
                    .filter(s -> s.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Sección no encontrada: " + name));
    }

    private void showRecentNews() {
        List<News> recentNews = findSection("Últimas noticias").getLatestNews(9);
        view.getCenterPanel().getRecentNews().updateNewsList(recentNews);
    }

    private void showInternationalNews() {
        List<News> intlNews = findSection("Noticias Internacionales").getLatestNews(9);
        view.getCenterPanel().getInternationalNews().updateNewsList(intlNews);
    }
}
