package ru.appline.framework.pages.task4;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.utils.PropConst;

import java.util.List;

public class SchoolClass9Page extends BasePage {

    @FindBy(xpath = "//input[@name=\"examtype[]\" and @value=\"2\"]/..")
    private WebElement ogeCheckbox;

    @FindBy(xpath = "//input[@id=\"section-search-form-price_max\"]")
    private WebElement maxPriceInput;

    @FindBy(xpath = "//input[@class=\"btn btn-primary btn-small\" and @value=\"Показать\"]")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//div[@class=\"product-padding\"]")
    private List<WebElement> books;

    @Step("В меню фильтров «Для экзаменов» выбрать «ОГЭ»")
    public SchoolClass9Page filterOge(){
        ogeCheckbox.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return pageManager.getSchoolClass9Page();
    }

    @Step("Выбрать цену до 600 рублей")
    public SchoolClass9Page filterPrice(){
        maxPriceInput.sendKeys("600");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return pageManager.getSchoolClass9Page();
    }

    @Step("Нажать кнопку «Показать»")
    public SchoolClass9Page clickSubmitButton(){
        buttonSubmit.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i<6 && i<books.size(); i++){
            String title = books.get(i).findElement(By.xpath(".//span[@class=\"product-title\"]")).getText();
            int price = Integer.parseInt(books.get(i).findElement(By.xpath(".//span[@class=\"price-gray\"]")).getText());
            Assert.assertTrue("Книга " + title + " не соответсвует выбранным фильтрам.",
                    title.contains("ОГЭ") && price < 600);
        }
        return pageManager.getSchoolClass9Page();
    }
}
