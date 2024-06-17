package ru.appline.framework.managers;

import ru.appline.framework.pages.task1.FirstPage1;
import ru.appline.framework.pages.task2.DMamiPage;
import ru.appline.framework.pages.task2.FirstPage2;
import ru.appline.framework.pages.task2.ShedulePage;
import ru.appline.framework.pages.task3.FirstPage3;
import ru.appline.framework.pages.task3.LaptopsPage;
import ru.appline.framework.pages.task4.*;


public class PageManager {

    private static PageManager pageManager;

    private FirstPage1 firstPage1;

    private FirstPage2 firstPage2;

    private ShedulePage shedulePage;

    private DMamiPage dMamiPage;

    private FirstPage3 firstPage3;

    private LaptopsPage laptopsPage;

    private FirstPage4 firstPage4;

    private RatingsPage ratingsPage;

    private RatingsScorePage ratingsScorePage;

    private SchoolClass9Page schoolClass9Page;

    private ReviewsPage reviewsPage;



    private PageManager() {
    }


    public static PageManager getInstance() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }


    public FirstPage1 getFirstPage1() {
        if (firstPage1 == null) {
            firstPage1 = new FirstPage1();
        }
        return firstPage1;
    }

    public FirstPage2 getFirstPage2(){
        if (firstPage2 == null) {
            firstPage2 = new FirstPage2();
        }
        return firstPage2;
    }

    public ShedulePage getShedulePage(){
        if (shedulePage == null) {
            shedulePage = new ShedulePage();
        }
        return shedulePage;
    }

    public DMamiPage getDMamiPage(){
        if (dMamiPage == null) {
            dMamiPage = new DMamiPage();
        }
        return dMamiPage;
    }
    public FirstPage3 getFirstPage3(){
        if (firstPage3 == null) {
            firstPage3 = new FirstPage3();
        }
        return firstPage3;
    }
    public LaptopsPage getLaptopsPage(){
        if (laptopsPage == null) {
            laptopsPage = new LaptopsPage();
        }
        return laptopsPage;
    }

    public FirstPage4 getFirstPage4(){
        if (firstPage4 == null) {
            firstPage4 = new FirstPage4();
        }
        return firstPage4;
    }

    public RatingsPage getRatingsPage(){
        if (ratingsPage == null) {
            ratingsPage = new RatingsPage();
        }
        return ratingsPage;
    }

    public RatingsScorePage getRatingsScorePage(){
        if (ratingsScorePage == null) {
            ratingsScorePage = new RatingsScorePage();
        }
        return ratingsScorePage;
    }

    public SchoolClass9Page getSchoolClass9Page(){
        if (schoolClass9Page == null) {
            schoolClass9Page = new SchoolClass9Page();
        }
        return schoolClass9Page;
    }

    public ReviewsPage getReviewsPage(){
        if (reviewsPage == null) {
            reviewsPage = new ReviewsPage();
        }
        return reviewsPage;
    }

}