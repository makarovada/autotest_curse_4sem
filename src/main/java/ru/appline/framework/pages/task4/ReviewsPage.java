package ru.appline.framework.pages.task4;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.utils.PropConst;

import java.util.List;

public class ReviewsPage extends BasePage{

    @FindBy(xpath = "//span[contains(@class, \"navisort-part-4\")]")
    private WebElement navisort;

    @FindBy(xpath = "//a[@data-url=\"/reviews/?itemtype=authors\"]")
    private WebElement navisortByAuthor;

    @FindBy(xpath = "//span[@class=\"navisort-autocats-inputs\"]/input[@type=\"text\"]")
    private WebElement authorField;

    @FindBy(xpath = "//li[contains(@class, \"ui-state-focus\")]")
    private WebElement focusAuthor;

    @FindBy(xpath = "//a[@class=\"book-qtip\"]")
    private List<WebElement> booksTitle;

    @FindBy(xpath = "//input[@name=\"itemtype\"]")
    private WebElement hiddenField;

    @Step("Нажать на выпадающее меню «Все товары» и выбрать «По автору»")
    public ReviewsPage selectSortByAuthor(){
        navisort.click();
        navisortByAuthor.click();
        Assert.assertEquals("Поле для ввода авторов не появилось.", "authors", hiddenField.getAttribute("value"));
        return pageManager.getReviewsPage();
    }

    @Step("Ввести «Лондон Джек»")
    public ReviewsPage inputAuthor(){
        authorField.sendKeys("Лондон Джек");
        Assert.assertEquals("Среди выведенных авторов нет Джека Лондона", "Лондон Джек", focusAuthor.getText());
        return pageManager.getReviewsPage();
    }

    @Step("Нажать на найденного автора в результатах поиска")
    public ReviewsPage sortByAuthor(){
        focusAuthor.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i < booksTitle.size(); i++){
            String title = booksTitle.get(i).getText();
            Assert.assertTrue("Книга " + title + " не имеет автора 'Джек Лондон'.", title.contains("Лондон"));
        }
        return pageManager.getReviewsPage();
    }
}
