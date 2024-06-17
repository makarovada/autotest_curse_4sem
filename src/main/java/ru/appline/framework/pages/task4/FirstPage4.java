package ru.appline.framework.pages.task4;


import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.utils.PropConst;

public class FirstPage4 extends BasePage {

    @FindBy(xpath = "//li[@data-event-content=\"Рейтинги\"]")
    private WebElement ratingsMenu;

    @FindBy(xpath = "//h1[contains(text(), \"Рейтинг: лучшие книги мира 2024 года\")]")
    private WebElement ratingsTitle;

    @FindBy(xpath = "//li[@data-event-content=\"Школа\" and contains(@class, '768')]")
    private WebElement schoolMenu;

    @FindBy(xpath = "//a[@href=\"/school/?klass[]=9#right\"]")
    private WebElement schoolMenuClass9;

    @FindBy(xpath = "//input[@name=\"klass[]\" and @value=\"9\"]")
    private WebElement schoolClass9Checkbox;

    @FindBy(xpath = "//li[@data-event-content=\"Клуб\"]")
    private WebElement clubMenu;

    @FindBy(xpath = "//a[@href=\"/reviews/\" and @class=\"b-sub-menu-sub-title\"]")
    private WebElement clubMenuReviews;

    @FindBy(xpath = "//li[contains(@class, \"b-stab-e-slider-item-m-active\")]/a")
    private WebElement reviewsSlider;

    @Step("В меню перейти в раздел «Рейтинги»")
    public RatingsPage moveToRatings(){
        ratingsMenu.click();
        Assert.assertEquals("Страница рейтингов не загрузилась", "Рейтинг: лучшие книги мира 2024 года", ratingsTitle.getText());
        return pageManager.getRatingsPage();
    }

    @Step("В меню перейти в раздел «Школа» → «Классы» → «9»")
    public SchoolClass9Page moveToSchoolClass9(){
        actions.moveToElement(schoolMenu).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        schoolMenuClass9.click();
        Assert.assertTrue("Страница книг для 9 классов не открылась.", schoolClass9Checkbox.isSelected());
        return pageManager.getSchoolClass9Page();
    }

    @Step("В меню перейти в раздел «Клуб» → «Журнал» → «Рецензии читателей»")
    public ReviewsPage moveToReviews(){
        actions.moveToElement(clubMenu).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clubMenuReviews.click();
        Assert.assertEquals("Страница рецензий не открылась.", "Рецензии", reviewsSlider.getText());
        return pageManager.getReviewsPage();
    }



    public void loadFirstPage() {
        driverManager.getDriver().get(testPropManager.getProperty(PropConst.LABIRINT_URL));
    }

}
