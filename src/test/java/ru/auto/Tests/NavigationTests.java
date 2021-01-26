package ru.auto.Tests;

import Main.SignUpPage;
import Main.SimpleNavigation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavigationTests {
    private static WebDriver driver;
    static SignUpPage signUpPage;
    static SimpleNavigation simpleNavigation;
    @BeforeAll
    public static void up() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Peppe\\Downloads\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peppe\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://auto.ru");
        simpleNavigation =new SimpleNavigation(driver);
        signUpPage = new SignUpPage(driver);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }
    @AfterAll
    static void close() {
        driver.quit();
    }
    @Test
    void navigateToSignUpPageTest() {
        simpleNavigation.navigateToSignUp();
        List<WebElement> list  = driver.findElements(By.xpath("//form//div[@class='AuthForm__title']"));
        driver.navigate().back();
        assertEquals(1, list.size());
}
    @Test
    void emailEnterSignUpPageTest() {
        simpleNavigation.navigateToSignUp();
        signUpPage.enterEmail();
        List<WebElement> list  = driver.findElements(By.xpath("/html/body/div/div/div/div/form/div/div[3]/div[2]/label/div"));
        driver.navigate().back();
        assertEquals(1, list.size());
    }
    @Test
    void magazinePageTest() {
        simpleNavigation.navigateToMagazine();
        List<WebElement> list  = driver.findElements(By.xpath("//*[@class='jrnl-logo']"));
        driver.navigate().back();
        assertEquals(1, list.size());
    }
    @Test
    void carPageTest() {
        simpleNavigation.navigateToCarPage();
        List<WebElement> list  = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[2]/h1"));
        driver.navigate().back();
        assertEquals(1, list.size());
    }
    @Test
    void commercialCarPageTest() {
        simpleNavigation.navigateToCommercialCars();
        List<WebElement> list  = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[2]/div[2]"));
        driver.navigate().back();
        assertEquals(1, list.size());
    }
    @Test
    void comparePageTest() {
        simpleNavigation.navigateToModelComparePage();
        List<WebElement> list  = driver.findElements(By.xpath("//*[@id=\"LayoutIndex\"]/div/h1"));
        driver.navigate().back();
        assertEquals(1, list.size());

    }
    @Test
    void feedbackPageTest() {
        simpleNavigation.navigateToFeedbackPage();
        List<WebElement> list  = driver.findElements(By.xpath("//*[text()='Отзывы об автомобилях']"));
        driver.navigate().back();
        assertEquals(1, list.size());
    }
    @Test
    void dropDownTest() {
        simpleNavigation.navigateToItemFromDropDownMenu();
        List<WebElement> list = driver.findElements(By.xpath("/html/body/div[2]/div/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]"));
        driver.navigate().back();
        assertEquals(1, list.size());
    }
}

