package ru.auto.Tests;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.auto.Main.CarFilter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.auto.Main.CarList;
import ru.auto.Main.TestConfiguration;

import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.*;
public class CarFilterTest {
    private static WebDriver driver;
    private static CarList carList;
    public static CarFilter carFilter;
    @BeforeAll
    static void up() {
        driver= TestConfiguration.initialize();;
        carFilter = new CarFilter(driver);
        carList =new CarList(driver);
    }
    @AfterAll
    static void close() {
       driver.quit();
    }

    @Test
    void firmTest() {
        boolean flag =true;
        carFilter.getCarsByFirm("MINI");
        List<WebElement> foundCars = new LinkedList<>();
        foundCars =carList.getCarsFromPage();
        for (WebElement a:foundCars) {
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
        foundCars =carList.getCarsAgeFromPage();
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
        boolean a = true;
        carFilter.getCarsByFirm("MINI");
        carFilter.setPriceFilter();
        foundCars = carList.getCarsPriceFromPage();
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
        foundCars =carList.getCarsKmAgeFromPage();
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
        foundCars =carList.getCarsTechSummaryFromPage() ;
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
        List<WebElement> foundCars = new LinkedList<>();
        carFilter.getCarsByFirm("Audi");
        carFilter.setOldCar();
        foundCars = carList.getCarsKmAgeFromPage();
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
        foundCars =carList.getCarsTechSummaryFromPage() ;
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
            foundCars = carList.getCarsModelsFromPage();
            for (WebElement b : foundCars) {
                if ((((b.getText())).equals("969"))||(((b.getText())).equals("1302 Волынь")))
                    a = false;
        }
        assertTrue(a);
    }

}







