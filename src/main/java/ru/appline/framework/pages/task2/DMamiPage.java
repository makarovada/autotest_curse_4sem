package ru.appline.framework.pages.task2;

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

    //@FindBy(xpath = "//h1[contains(@class, \"h1 hero__title\")]")
    //private WebElement title;



    public DMamiPage SelectGroup(){
        //ввести
        inputGroup.sendKeys("221-361");
        Assert.assertEquals("В результатах поиска отображается несколько групп", 1, group.size());

        //нажать на группу
        group.get(0).click();
        return pageManager.getDMamiPage();
    }


}
