package ru.auto.Tests;

import Main.CarFilter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class CarFilterTest {
    static final String topNavigationLinksXPath = "/html/body/div/header/div/div[2]/div[2]/div[1]/div/a";
    private static WebDriver driver;
    public static CarFilter carFilter;
    @BeforeAll
    static void up() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peppe\\Downloads\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Peppe\\Downloads\\geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        carFilter = new CarFilter(driver);
    }
    @AfterAll
    static void close() {
       driver.quit();
    }

    @Test
    void firmTest() {
        boolean flag =true;
        carFilter.getCarsByFirm("MINI");
        List<WebElement> foundcars = new LinkedList<>();
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
        List<WebElement> foundCars = new LinkedList<>();
        carFilter.getCarsByFirm("MINI");
        carFilter.setAgeFilter();
        foundCars = driver.findElements(By.xpath("//*[@class= 'ListingItem-module__year']"));
        boolean a = true;
        for (WebElement b : foundCars) {
            if ((Integer.parseInt(b.getText())) < 2015)
                a = false;
        }
        assertTrue(a);
    }

    @Test
    void priceTest() {
        List<WebElement> foundCars = new LinkedList<>();
        carFilter.getCarsByFirm("MINI");
        carFilter.setPriceFilter();
        foundCars = driver.findElements(By.xpath("//*[@class= 'ListingItemPrice-module__content']"));
        boolean a = true;
        for (WebElement b : foundCars) {
            if ((((Integer.parseInt(b.getText().substring(0,b.getText().length()-2).replaceAll("\\s+",""))) > 800000)||((Integer.parseInt(b.getText()
                    .substring(0,b.getText().length()-2).replaceAll("\\s+",""))) < 200000) ))
                a = false;
            }
        assertTrue(a);
        }
    @Test
    void destinationTest() {
        List<WebElement> foundCars = new LinkedList<>();
        carFilter.getCarsByFirm("Audi");
        carFilter.setDestinationFilter();
        foundCars = driver.findElements(By.xpath("//*[@class= 'ListingItem-module__kmAge']"));
        boolean a = true;
        for (WebElement b : foundCars) {
            if ((((Integer.parseInt(b.getText().substring(0,b.getText().length()-3).replaceAll("\\s+",""))) > 200000)||((Integer.parseInt(b.getText()
                    .substring(0,b.getText().length()-2).replaceAll("\\s+",""))) < 100000) ))
                a = false;
        }
        assertTrue(a);
    }
    @Test
    void
    carcassTest() throws InterruptedException {
        List<WebElement> foundCars = new LinkedList<>();
        carFilter.getCarsByFirm("Ford");
        carFilter.setCarcassFilter();
        foundCars = driver.findElements(By.xpath("//*[@class= 'ListingItemTechSummaryDesktop__cell']"));
        boolean a = true;
        for (WebElement b : foundCars) {
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
        List<WebElement> foundCars = new LinkedList<>();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[1]/div[1]/span/label[3]/button/span/span")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItemPrice-module__content']")));
        foundCars = driver.findElements(By.xpath("//*[@class= 'ListingItem-module__kmAge']"));
        boolean a = true;
        for (WebElement b : foundCars) {
            if (b.getText().equals("Новый"))
                a = false;
        }
        assertTrue(a);
    }
    @Test
    void driveTest(){
        List<WebElement> foundCars = new LinkedList<>();
        carFilter.getCarsByFirm("BMW");
        carFilter.setDriveFilter();
        foundCars = driver.findElements(By.xpath("//*[@class= 'ListingItemTechSummaryDesktop__cell']"));
        boolean a = true;
        for (WebElement b : foundCars) {
            if ((((b.getText())).equals("Полный"))||(((b.getText())).equals(""))||(((b.getText())).equals("Задний")))
                a = false;
        }
        assertTrue(a);
    }
    @Test
    void modelTest(){
        List<WebElement> foundCars = new LinkedList<>();
        carFilter.setModelFilter();
        boolean a = true;
            foundCars = driver.findElements(By.xpath("//h3/a[@class='Link ListingItemTitle-module__link']"));
            for (WebElement b : foundCars) {
                System.out.println(b.getText());
                if ((((b.getText())).equals("969"))||(((b.getText())).equals("1302 Волынь")))
                    a = false;
        }
        assertTrue(a);
    }

}







