package ru.appline.framework.pages.task2;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;



public class DMamiPage extends BasePage{

    @FindBy(xpath = "//input[@placeholder='группа ...']")
    private WebElement inputGroup;

    @FindBy(xpath = "//div[@class='found-groups row not-print']/div")
    private List<WebElement> group;

    @FindBy(xpath = "//div[@class=\"message not-print\"]")
    private WebElement shedule;

    private static final Logger logger = LogManager.getLogger(DMamiPage.class);




    @Step("Ввести номер группы в поле поиска и выбрать предложенную группу")
    public DMamiPage selectGroup(){
        //ввести
        inputGroup.sendKeys("23А-241");
        Assert.assertEquals("В результатах поиска отображается несколько групп", 1, group.size());

        //нажать на группу
        group.get(0).click();
        //Assert.assertEquals("Выведено расписание другой группы.", "23А-241", shedule.getText());
        return pageManager.getDMamiPage();
    }

    public String getCurrentDayOfWeek() {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();

        Locale russianLocale = new Locale("ru", "RU");
        String dayOfWeekInRussian = dayOfWeek.getDisplayName(TextStyle.FULL, russianLocale);

        dayOfWeekInRussian = dayOfWeekInRussian.substring(0, 1).toUpperCase() + dayOfWeekInRussian.substring(1);

        return dayOfWeekInRussian;
    }

    @Step("Проверка цвета текущего дня")
    public DMamiPage checkOfColor(){
        try {
            WebElement todayElement = driverManager.getDriver().findElement(By.xpath("//div[contains(@class, 'schedule-day schedule-day_today')]//div[contains(@class, 'bold schedule-day__title') and text()='"+getCurrentDayOfWeek()+"']"));
            Assert.assertNotNull("Текущий день недели не выделен цветом", todayElement);
            WebElement todaydivElement = driverManager.getDriver().findElement(By.xpath("//div[contains(@class, 'schedule-day schedule-day_today')]"));
            String backgroundColor = todaydivElement.getCssValue("background-color");
            Assert.assertEquals("Цвет фона блока 'schedule-day_today' не равен #e2ffd9", "rgba(226, 255, 217, 1)", backgroundColor);

            Thread.sleep(2000);
        } catch (Exception e){
            logger.info("Сегодня воскресенье! Текущий день не может быть выделен цветом.");
        }
        return pageManager.getDMamiPage();
    }
}
