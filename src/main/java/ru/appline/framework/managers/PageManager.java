package ru.appline.framework.managers;

import ru.appline.framework.pages.task1.FirstPage;
import ru.appline.framework.pages.task2.FirstPage;


public class PageManager {

    private static PageManager pageManager;

    private FirstPage firstPage;




    private PageManager() {
    }


    public static PageManager getInstance() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link FirstPage}
     *
     * @return StartPage
     */
    public FirstPage getFirstPage() {
        if (firstPage == null) {
            firstPage = new FirstPage();
        }
        return firstPage;
    }

}