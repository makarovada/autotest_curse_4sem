package task1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest {

    @Test
    public void test(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().getPageLoadTimeout();
        driver.manage().timeouts().getImplicitWaitTimeout();

        // step 1
        // Перейти по ссылке: https://lambdatest.github.io/sample-todo-app/

        driver.manage().window().maximize();
        driver.get("https://lambdatest.github.io/sample-todo-app/ ");

        // step 2
        // Проверить, что присутствует текст: “5 of 5 remaining”

        //WebElement upText = driver.findElement(By.className("ng-binding"));
        WebElement upText = driver.findElement(By.xpath("//span[contains(text(), '5 of 5 remaining')]"));

        Assert.assertEquals("Не тот текст", "5 of 5 remaining", upText.getText());
        //Assert.assertTrue("Не тот текст. Ожидали '5 of 5 remaining', фактически: " + upText.getText(), upText.isDisplayed() && upText.getText().contains("5 of 5 remaining"));


        // step 3
        // Проверить, что первый элемент списка не зачеркнут

        WebElement firstSpan = driver.findElement(By.xpath("//ul/li[1]/span"));
        Assert.assertTrue("Первый элемент списка зачеркнут", firstSpan.isDisplayed() && firstSpan.getAttribute("class").contains("false"));


        // step 4
        // Поставить галочку у первого элемента

        WebElement firstCheckbox = firstSpan.findElement(By.xpath(".//../input"));
        firstCheckbox.click();
        Assert.assertTrue("Первый чекбокс не выбран", firstCheckbox.isSelected());


        // step 5
        // Повторить шаги 3, 4 для остальных элементов списка

        WebElement span;
        WebElement checkbox;

        for(int i = 2; i<6; i++){
            span = driver.findElement(By.xpath("//ul/li[" + i + "]/span"));
            Assert.assertTrue(i + " элемент списка зачеркнут", span.isDisplayed() && span.getAttribute("class").contains("false"));

            checkbox = span.findElement(By.xpath(".//../input"));
            checkbox.click();
            Assert.assertTrue(i + " чекбокс не выбран", checkbox.isSelected());
        }


        // step 6
        // Добавить новый элемент списка

        String newText = "Sixth item";
        WebElement inputField = driver.findElement(By.id("sampletodotext"));
        inputField.sendKeys(newText);

        //inputField.sendKeys(Keys.ENTER);
        WebElement inputButton = driver.findElement(By.xpath("//form/input[@class = 'btn btn-primary']"));
        inputButton.click();

        WebElement newSpan = driver.findElement(By.xpath("//ul/li[6]/span"));
        Assert.assertEquals("Новый элемент не добавился", newText, newSpan.getText());


        // step 7
        // Нажать на новый элемент списка

        WebElement newCheckbox = newSpan.findElement(By.xpath(".//../input"));
        newCheckbox.click();
        Assert.assertTrue("Новый чекбокс не выбран", newCheckbox.isSelected());



        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();


    }
}
