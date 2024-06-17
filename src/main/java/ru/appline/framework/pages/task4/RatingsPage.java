package ru.appline.framework.pages.task4;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.utils.PropConst;

public class RatingsPage extends BasePage {

    @FindBy(xpath = "//a[@href=\"/rating/votes/\"]")
    private WebElement ratingsScore;

    @FindBy(xpath =  "//a[@class=\"red pushstate\"]")
    private WebElement classRatingsSales;

    @Step("Нажать на ссылку «Оценки»")
    public RatingsScorePage moveToRatingsScore(){
        ratingsScore.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertNotEquals("Страница рейтинга по оценкам не прогрузилась.", "Оценки", classRatingsSales);
        return pageManager.getRatingsScorePage();
    }

}

