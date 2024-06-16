package ru.appline.framework.pages.task4;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.pages.task2.ShedulePage;
import ru.appline.framework.pages.task3.BasePage;
import ru.appline.utils.PropConst;

public class FirstPage4 extends BasePage {

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
/*
    public void loadFirstPage() {
        driverManager.getDriver().get(testPropManager.getProperty(PropConst.YANDEX_URL));
    }

 */
}
