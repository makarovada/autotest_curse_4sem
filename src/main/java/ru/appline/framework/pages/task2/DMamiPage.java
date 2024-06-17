package ru.appline.framework.pages.task2;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.framework.pages.task1.FirstPage1;

import java.util.List;


public class DMamiPage extends BasePage{

    @FindBy(xpath = "//input[@placeholder='группа ...']")
    private WebElement inputGroup;

    @FindBy(xpath = "//div[@class='found-groups row not-print']/div")
    private List<WebElement> group;

    @FindBy(xpath = "//div[@class=\"message not-print\"]")
    private WebElement shedule;




    @Step("Ввести номер группы в поле поиска и выбрать предложенную группу")
    public DMamiPage selectGroup(){
        //ввести
        inputGroup.sendKeys("221-361");
        Assert.assertEquals("В результатах поиска отображается несколько групп", 1, group.size());

        //нажать на группу
        group.get(0).click();
        Assert.assertEquals("Выведено расписание другой группы.", "Не нашлось расписание для группы", shedule.getText());
        return pageManager.getDMamiPage();
    }


}
