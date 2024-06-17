package ru.appline.framework.pages.task3;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.appline.utils.PropConst;

public class FirstPage3 extends BasePage{

    @FindBy(xpath = "//button[@class = '_30-fz button-focus-ring Hkr1q _1pHod _2rdh3 _3rbM-']")
    private WebElement catalogButton;

    @FindBy(xpath = "//span[contains(text(), 'Ноутбуки и компьютеры')]")
    private WebElement laptopsAndPC;

    @FindBy(xpath = "//a[text()='Серверы и СКС']")
    private WebElement button;



    @FindBy(xpath = "//a[text()='Ноутбуки']/..")
    private WebElement laptops;

    @FindBy(xpath = "//h1[@class = '_3lpeU _6tyDq _1ea6I _2Imo_']")
    private WebElement laptopsTitle;



    public void loadFirstPage() {
        driverManager.getDriver().get(testPropManager.getProperty(PropConst.YANDEX_URL));
    }

    @Step("В меню “Каталог” выбрать категорию: Ноутбуки и компьютеры -> Ноутбуки и планшеты -> Ноутбуки")
    public LaptopsPage clickOnLaptops() throws InterruptedException {

        Thread.sleep(15000); //на капчу
        catalogButton.click();
        Thread.sleep(2000);
        actions.moveToElement(laptopsAndPC).perform();
        Thread.sleep(2000);

        actions.moveToElement(button).perform();

        js.executeScript("window.scrollBy(1000, 0)");
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0, 0)");


        Thread.sleep(2000);
        laptops.click();
        Thread.sleep(1000);
        Assert.assertEquals("Страница 'Ноутбуки' не открылась ", "Ноутбуки", laptopsTitle.getText());
        return pageManager.getLaptopsPage();
    }


}

