package ru.appline.framework.pages.task2;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class ShedulePage extends BasePage{

    @FindBy(xpath = "//a[@href = \"https://rasp.dmami.ru/\"]")
    private WebElement lookOnWeb;

    @FindBy(xpath = "//h1[contains(@class, \"h1 hero__title\")]")
    private WebElement title;


    @Step("В разделе “Расписания занятий” нажать “Смотрите на сайте”")
    public DMamiPage clickOnLookOnWeb(){
        Assert.assertEquals("Страница расписаний не прогрузилась", "Расписания", title.getText());
        lookOnWeb.click();
        driverManager.switchWindow();
        Assert.assertEquals("Новая вкладка не была открыта", 2, driverManager.seeAllPages());
        return pageManager.getDMamiPage();
    }



}
