package ru.auto.Tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.auto.Main.CarPage;
import ru.auto.Main.TestConfiguration;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class CarTests {
    private static WebDriver driver;
    public static CarPage carPage;
    @BeforeAll
    static void up() {
        driver= TestConfiguration.initialize();
        driver = new FirefoxDriver();
        carPage = new CarPage(driver);
    }
    @AfterAll
    static void close() {
      driver.quit();
    }

    @Test
    void checkNumberTest(){
        carPage.getSellersNumber();
        String a= (new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(carPage.PHONE_XPATH)))).getText();
        assertEquals("+7 958 598-13-95",a);
    }
    @Test
    void checkMapTest() {
        List<WebElement> a = new ArrayList<>();
        carPage.getMap();
        a.add(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(carPage.MAP_XPATH))));
        assertEquals(1, a.size());
    }
    @Test
    void checkRatingTest(){
        List<WebElement> a = new ArrayList<>();
        carPage.getRating();
        a.add (new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(carPage.ADD_FEEDBACK_BUTTON_XPATH))));
        assertEquals(1,a.size());

    }
    @Test
    void addFeedback(){
        List<WebElement> a = new ArrayList<>();
        carPage.addFeedback();
        a.add (new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(carPage.REVIEW_FORM_XPATH))));
        assertEquals(1,a.size());

    }

}