package ru.appline.framework.managers;


import ru.appline.utils.PropConst;
import org.openqa.selenium.WebDriver;

import java.util.Set;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static DriverManager INSTANCE = null;
    private WebDriver driver;
    private TestPropManager testPropManager = TestPropManager.getInstance();



    private DriverManager() {
        // Приватный конструктор, чтобы предотвратить создание экземпляров класса извне
    }

    public static DriverManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", testPropManager.getProperty(PropConst.PATH_CHROME_DRIVER_WINDOWS));
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    public void switchWindow() {
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(driver.getWindowHandle())) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }
    public int seeAllPages(){
        return driver.getWindowHandles().size();
    }
}