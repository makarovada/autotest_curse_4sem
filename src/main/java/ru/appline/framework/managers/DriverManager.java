package ru.appline.framework.managers;


import ru.appline.utils.PropConst;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
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
        List<String> tabList = new ArrayList<>(allTabs);

        // Определение текущего окна
        String currentWindow = driver.getWindowHandle();
        int currentIndex = tabList.indexOf(currentWindow);

        // Определение следующего окна
        if (tabList.size() > 1) {
            int nextIndex = (currentIndex + 1) % tabList.size();
            String nextWindow = tabList.get(nextIndex);
            driver.switchTo().window(nextWindow);
        }
    }
    public int seeAllPages(){
        return driver.getWindowHandles().size();
    }
}