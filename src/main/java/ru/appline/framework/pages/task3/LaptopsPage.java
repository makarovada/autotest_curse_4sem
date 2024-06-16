package ru.appline.framework.pages.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LaptopsPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(LaptopsPage.class);

    @FindBy(xpath = "//div[@data-auto-themename=\"listDetailed\"]")
    private List<WebElement> laptopItems;

    @FindBy(xpath = "//div[@data-filter-value-id=\"resale_resale\"]")
    private WebElement filterResale;

    @FindBy(xpath = "//div[@data-auto-themename=\"listDetailed\"]")
    private List<WebElement> filterLaptopItems;


    public LaptopsPage infoToLogs(){
        logger.info("3 ШАГ ТЕСТ-КЕЙСА");


        for (int i = 0; i < 5 && i < laptopItems.size(); i++) {

            String name = laptopItems.get(i).findElement(By.xpath(".//h3[@data-auto='snippet-title']")).getText();
            String price = laptopItems.get(i).findElement(By.xpath(".//span[@data-auto='snippet-price-current']")).getText();
            boolean resale = !laptopItems.get(i).findElements(By.xpath(".//div[@data-zone-name = 'resale-badge']")).isEmpty();
            if(resale){
                logger.info("Ноутбук " + (i + 1) + ": \nНазвание - " + name + ", \nЦена - " + price + ", Уценка.");

            }
            else {
                logger.info("Ноутбук " + (i + 1) + ": \nНазвание - " + name + ", \nЦена - " + price + ", Новый.");
            }

        }

        return pageManager.getLaptopsPage();
    }

    public LaptopsPage selectResale(){
        filterResale.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10 && i < laptopItems.size(); i++) {

            String name = filterLaptopItems.get(i).findElement(By.xpath(".//h3[@data-auto='snippet-title']")).getText();
            boolean resale = !filterLaptopItems.get(i).findElements(By.xpath(".//div[@data-zone-name = 'resale-badge']")).isEmpty();
            Assert.assertTrue(name + " не относится к уценке.", resale);

        }

        return pageManager.getLaptopsPage();
    }


}
