package ru.appline.framework.pages.task3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import ru.appline.framework.managers.DriverManager;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.managers.TestPropManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    protected WebDriver driver;
    protected TestPropManager testPropManager = TestPropManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    protected DriverManager driverManager = DriverManager.getInstance();
    protected Actions actions = new Actions(driverManager.getDriver());

    protected JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();





    public BasePage() {
        driver = DriverManager.getInstance().getDriver();
        //driver.get(testPropManager.getProperty(PropConst.YANDEX_URL));
        PageFactory.initElements(driver, this);
    }


}


