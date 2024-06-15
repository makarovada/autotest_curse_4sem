package ru.appline.framework.pages.task1;

import ru.appline.framework.managers.DriverManager;
import ru.appline.framework.managers.PageManager;
import ru.appline.framework.managers.TestPropManager;
import ru.appline.utils.PropConst;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    private TestPropManager testPropManager = TestPropManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    public BasePage() {
        driver = DriverManager.getInstance().getDriver();
        driver.get(testPropManager.getProperty(PropConst.LAMDA_URL));
        PageFactory.initElements(driver, this);
    }
}
