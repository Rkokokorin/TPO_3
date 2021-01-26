package ru.auto;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class FilterTest {
    static final String topNavigationLinksXPath = "/html/body/div/header/div/div[2]/div[2]/div[1]/div/a";
    private static WebDriver driver;
    @BeforeAll
    static void up() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peppe\\Downloads\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://auto.ru");

    }
    @AfterAll
    static void close() {
       driver.quit();
    }

    @Test
    void firmTest() {
        boolean flag =true;
        driver.get("https://auto.ru");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='IndexMarks__item-name']")));
        driver.findElement(By.xpath("//*[contains(@class,'IndexMarks__item-name') and contains(text(),'MINI')]")).click();
        List<WebElement> foundcars = new LinkedList<>();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[9]/div[2]")));
        foundcars = driver.findElements(By.xpath("//h3/a[@class='Link ListingItemTitle-module__link']"));
        for (WebElement a:foundcars) {
            if (!a.getText().contains("MINI")) {
                flag = false;
            }
            assertTrue(flag);
        }

    }

    @Test
    void yearTest() throws InterruptedException {
        driver.get("https://auto.ru");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='IndexMarks__item-name']")));
        driver.findElement(By.xpath("//*[contains(@class,'IndexMarks__item-name') and contains(text(),'MINI')]")).click();
        List<WebElement> foundcars = new LinkedList<>();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div[1]/span/div[1]/button/span/span")))
                .click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'MenuItem MenuItem_size_m' and  contains(text(), '2015')]"))).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button")).click();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> !driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItem-module__year']")));
        foundcars = driver.findElements(By.xpath("//*[@class= 'ListingItem-module__year']"));
        boolean a = true;
        for (WebElement b : foundcars) {
            if ((Integer.parseInt(b.getText())) < 2015)
                a = false;
        }
        assertTrue(a);
    }
    @Test
    void priceTest() {
        driver.get("https://auto.ru");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='IndexMarks__item-name']")));
        driver.findElement(By.xpath("//*[contains(@class,'IndexMarks__item-name') and contains(text(),'MINI')]")).click();
        List<WebElement> foundcars = new LinkedList<>();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div[3]/span/label[2]/div/span/input"))).sendKeys("800000");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div[3]/span/label[1]/div/span/input"))).sendKeys("200000");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button")).click();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> !driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItemPrice-module__content']")));
        foundcars = driver.findElements(By.xpath("//*[@class= 'ListingItemPrice-module__content']"));
        boolean a = true;
        for (WebElement b : foundcars) {
            if ((((Integer.parseInt(b.getText().substring(0,b.getText().length()-2).replaceAll("\\s+",""))) > 800000)||((Integer.parseInt(b.getText()
                    .substring(0,b.getText().length()-2).replaceAll("\\s+",""))) < 200000) ))
                a = false;
            }
        assertTrue(a);
        }
    @Test
    void destinationTest() {
        driver.get("https://auto.ru");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='IndexMarks__item-name']")));
        driver.findElement(By.xpath("//*[contains(@class,'IndexMarks__item-name') and contains(text(),'Audi')]")).click();
        List<WebElement> foundcars = new LinkedList<>();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div[2]/span/label[1]/div/span/input"))).sendKeys("100000");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div[2]/span/label[2]/div/span/input"))).sendKeys("200000");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button")).click();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> !driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItemPrice-module__content']")));
        foundcars = driver.findElements(By.xpath("//*[@class= 'ListingItem-module__kmAge']"));
        boolean a = true;
        for (WebElement b : foundcars) {
            if ((((Integer.parseInt(b.getText().substring(0,b.getText().length()-3).replaceAll("\\s+",""))) > 200000)||((Integer.parseInt(b.getText()
                    .substring(0,b.getText().length()-2).replaceAll("\\s+",""))) < 100000) ))
                a = false;
        }
        assertTrue(a);
    }
    @Test
    void
    carcassTest() throws InterruptedException {
        driver.get("https://auto.ru");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='IndexMarks__item-name']")));
        driver.findElement(By.xpath("//*[contains(@class,'IndexMarks__item-name') and contains(text(),'MINI')]")).click();
        List<WebElement> foundcars = new LinkedList<>();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[1]/div/button")))
                .click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'MenuItem MenuItem_size_m' and  contains(text(), 'Хэтчбек 3 дв.')]"))).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button")).click();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> !driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItem-module__year']")));
        foundcars = driver.findElements(By.xpath("//*[@class= 'ListingItemTechSummaryDesktop__cell']"));

        boolean a = true;
        for (WebElement b : foundcars) {
            if ((((b.getText())).equals("Хэтчбек дв."))||(((b.getText())).equals("Седан"))||(((b.getText())).equals("Универсал"))
                    ||(((b.getText())).equals("Внедорожник"))||(((b.getText())).equals("Фургон"))||(((b.getText())).equals("Купе")))
                a = false;
        }
        assertTrue(a);
    }
    @Test
    void NotNewTest() {
        driver.get("https://auto.ru");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='IndexMarks__item-name']")));
        driver.findElement(By.xpath("//*[contains(@class,'IndexMarks__item-name') and contains(text(),'Audi')]")).click();
        List<WebElement> foundcars = new LinkedList<>();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[1]/div[1]/span/label[3]/button/span/span")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItemPrice-module__content']")));
        foundcars = driver.findElements(By.xpath("//*[@class= 'ListingItem-module__kmAge']"));
        boolean a = true;
        for (WebElement b : foundcars) {
            if (b.getText().equals("Новый"))
                a = false;
        }
        assertTrue(a);
    }
    @Test
    void driveTest(){
        driver.get("https://auto.ru");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='IndexMarks__item-name']")));
        driver.findElement(By.xpath("//*[contains(@class,'IndexMarks__item-name') and contains(text(),'BMW')]")).click();
        List<WebElement> foundcars = new LinkedList<>();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/button")))
                .click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'MenuItem MenuItem_size_m' and  contains(text(), 'Передний')]"))).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button")).click();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> !driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItem-module__year']")));
        foundcars = driver.findElements(By.xpath("//*[@class= 'ListingItemTechSummaryDesktop__cell']"));

        boolean a = true;
        for (WebElement b : foundcars) {
            if ((((b.getText())).equals("Полный"))||(((b.getText())).equals(""))||(((b.getText())).equals("Задний")))
                a = false;
        }
        assertTrue(a);
    }
    @Test
    void modelTest(){
        driver.get("https://auto.ru/sankt-peterburg/cars/luaz/all/");

        List<WebElement> foundcars = new LinkedList<>();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div/button")))
                .click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'MenuItem MenuItem_size_m' and  contains(text(), '967')]"))).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button")).click();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> !driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        boolean a = true;
            foundcars = driver.findElements(By.xpath("//h3/a[@class='Link ListingItemTitle-module__link']"));
            for (WebElement b : foundcars) {
                System.out.println(b.getText());
                if ((((b.getText())).equals("969"))||(((b.getText())).equals("1302 Волынь")))
                    a = false;

        }
        assertTrue(a);
    }

}







