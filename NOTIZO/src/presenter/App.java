package presenter;

import gui.MainFrame;
import model.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Inicializo modelo con datos provicionados por el desarrollador
        NewsImage mainImage = new NewsImage("/Images/test.jpeg", "Imagen principal", "Caption", 800, 600, "1");
        News mainNews = new News("1", "¡Noticia en tendencia!", 
            "Contenido detallado de la noticia principal...", 
            "01/07/2023", "Autor Principal", true, mainImage);
        
        List<Section> sections = new ArrayList<>();
        
        //Instancio sección de noticias recientes
        List<News> recentNewsList = new ArrayList<>();
        recentNewsList.add(new News("2", "Noticia reciente 1", "Contenido noticia 1...", "30/06/2023", "Autor 1", false, 
            new NewsImage("/Images/aux.jpeg", "Desc 1", "Cap 1", 400, 300, "2")));
        recentNewsList.add(new News("3", "Noticia reciente 2", "Contenido noticia 2...", "29/06/2023", "Autor 2", true, 
            new NewsImage("/Images/auxOn.jpeg", "Desc 2", "Cap 2", 400, 300, "3")));
        recentNewsList.add(new News("4", "Noticia reciente 3", "Contenido noticia 3...", "28/06/2023", "Autor 3", false, 
            new NewsImage("/Images/auxTw.jpeg", "Desc 3", "Cap 3", 400, 300, "4")));
        
        Section recentSection = new Section("Últimas noticias", recentNewsList) {
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
            public List<News> getLatestNews(int limit) {
                return newsList.subList(0, Math.min(limit, newsList.size()));
            }
        };
        
        //Instancio esta sección tambien de noticias internacionales
        List<News> internationalNewsList = new ArrayList<>();
        internationalNewsList.add(new InternationalNews("EEUU", "Norteamérica", 
            "5", "Noticia internacional 1", "Contenido internacional 1...", "28/06/2023", "Autor Int 1", true, 
            new NewsImage("/Images/testTwo.jpeg", "Desc Int 1", "Cap Int 1", 400, 300, "5")));
        internationalNewsList.add(new InternationalNews("Francia", "Europa", 
            "6", "Noticia internacional 2", "Contenido internacional 2...", "27/06/2023", "Autor Int 2", false, 
            new NewsImage("/Images/testThree.jpeg", "Desc Int 2", "Cap Int 2", 400, 300, "6")));
        
        InternationalNewsSection internationalSection = new InternationalNewsSection("Noticias Internacionales", "Colombia");
        for (News news : internationalNewsList) {
            internationalSection.addNews(news);
        }
        
        sections.add(recentSection);
        sections.add(internationalSection);
        
        Homepage homepage = new Homepage(mainNews, sections);

        //Creo la vista
        MainFrame mainFrame = new MainFrame();

        //Inicio el paquete presenter con los parametros :D
        new NewsPresenter(mainFrame, homepage);
    }
}