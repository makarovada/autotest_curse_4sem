package ru.appline.framework.pages.task4;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.utils.PropConst;

import java.util.List;

public class RatingsScorePage extends BasePage {


    @FindBy(xpath = "//span[@class=\"sorting-value menu-open\"]")
    private WebElement sortMenu;

    @FindBy(xpath = "//a[@href=\"?order=popularity&way=forward\"]")
    private WebElement popularItemSortMenu;

    @FindBy(xpath = "//div[@class=\"product-padding\"]")
    private List<WebElement> books;

    @Step("В выпадающем списке выбрать «Сначала популярные»")
    public RatingsScorePage assertFilter(){
        Assert.assertEquals("Фильтр по умолчанию не \"популярные\"", "популярные", sortMenu.getText());
        int score;
        int lastScore = 5000;
        for(int i = 0; i<6 && i<books.size(); i++){
            score = Integer.parseInt(books.get(i).findElement(By.xpath(".//span[@class=\"countvotesbg\"]")).getText());
            Assert.assertTrue("Порядок книг при использованных филтрах не соблюден.", lastScore > score);
        }
        return pageManager.getRatingsScorePage();
    }




}


