package ru.appline.framework.pages.task1;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FirstPage1 extends BasePage {

    @FindBy(xpath = "//span[@class='ng-binding']")
    private WebElement upText;

    @FindBy(xpath = "//ul[@class='list-unstyled']/li/span")
    private List<WebElement> spans;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(id = "sampletodotext")
    private WebElement inputField;

    @FindBy(xpath = "//ul/li[-1]/span")
    private WebElement newSpan;

    @FindBy(xpath = "//ul/li[-1]/input")
    private WebElement newCheckbox;



    public FirstPage1 getUpText() {
        Assert.assertEquals("Не тот текст", "5 of 5 remaining", upText.getText());
        return pageManager.getFirstPage1();
    }

    public FirstPage1 getSpanClass(int a) {
        Assert.assertTrue(a + " элемент списка зачеркнут", spans.get(a).isDisplayed() && spans.get(a).getAttribute("class").contains("false"));
        return pageManager.getFirstPage1();
    }

    public FirstPage1 isCheckboxSelected(int a) {
        Assert.assertFalse("Чекбокс уже выбран", checkboxes.get(a).isSelected());
        return pageManager.getFirstPage1();
    }

    public FirstPage1 clickCheckbox(int a) {
        checkboxes.get(a).click();
        Assert.assertTrue(a + " чекбокс не выбран", checkboxes.get(a).isSelected());
        return pageManager.getFirstPage1();
    }

    public void addItem(String text) {
        inputField.sendKeys(text);
        inputField.sendKeys(Keys.ENTER);
    }

    public int getRemainingCount() {
        String remainingCountText = upText.getText().split(" ")[0];
        return Integer.parseInt(remainingCountText);
    }
    public FirstPage1 clickAllCheckboxes() {
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        int itemCountAfter = pageManager.getFirstPage1().getRemainingCount();
        Assert.assertEquals("Отображаемое число оставшихся элементов не уменьшилось до 0!", 0, itemCountAfter);
        return pageManager.getFirstPage1();
    }



    public FirstPage1 addNewElement(){
        String newItemText = "Sixth item";
        addItem(newItemText);
        checkboxes.add(newCheckbox);
        spans.add(newSpan);
        getSpanClass(spans.size()-1);
        clickCheckbox(checkboxes.size()-1);
        Assert.assertTrue("Новый чекбокс не выбран", checkboxes.get(checkboxes.size()-1).isSelected());
        return pageManager.getFirstPage1();
    }

}