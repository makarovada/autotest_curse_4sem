package ru.appline.framework.pages.task2;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.utils.PropConst;


public class FirstPage2 extends BasePage{

    @FindBy(xpath = "//a[contains(@href, \"raspisaniya\")]")
    private WebElement shedule;

    @FindBy(xpath = "//h2[contains(@class, \"main-hero-content-slide__heading\")]")
    private WebElement title;

    public void loadFirstPage() {
        driver.get(testPropManager.getProperty(PropConst.MOSPOLYTECH_URL));
    }



    public ShedulePage clickOnSchedule(){
        Assert.assertEquals("Главная страница не прогрузилась", "Флагман проектного обучения в России", title.getText());
        shedule.click();
        return pageManager.getShedulePage();
    }


    public void loadHomePage() {
        driver.get(testPropManager.getProperty(PropConst.MOSPOLYTECH_URL));

    }
}


/*
1.	Перейти по ссылке: https://mospolytech.ru/
        2. Нажать на кнопку Расписания
3. В разделе “Расписания занятий” нажать “Смотрите на сайте”
        4. Ввести номер группы в поле поиска
5. Нажать на найденную группу в результатах поиска

 */
