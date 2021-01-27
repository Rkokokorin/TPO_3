package ru.auto.Tests;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import ru.auto.Main.CarFilter;
import ru.auto.Main.CarList;
import ru.auto.Main.SignInPage;
import ru.auto.Main.SiteNavigation;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class  SignInTests {
    private static WebDriver driver;
    private static Actions actions;
    private static SiteNavigation siteNavigation;
    private static SignInPage signInPage;
    private static CarFilter carFilter;
    private static CarList carList;
    @BeforeAll
    static void up() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Peppe\\Downloads\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peppe\\Downloads\\chromedriver.exe");
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        siteNavigation =new SiteNavigation(driver);
        carFilter = new CarFilter(driver);
        carList = new CarList(driver);
        signInPage = new SignInPage(driver);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        siteNavigation.navigateToSignUp();
        signInPage.signUpUsingMailRu();
    }

    @AfterAll
    static void close() {
        driver.quit();

    }
    @Test
    public void addToFavoriteTest() {
        List<WebElement> foundCars = new LinkedList<>();
        String a;
        boolean flag = false;
        siteNavigation.getAutoRu();
        carFilter.getCarsByFirm("MINI");
        foundCars =carList.getCarsFromPage();
        a = foundCars.get(0).getText();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)", "");
        actions.moveToElement(foundCars.get(0)).build().perform();
        carList.addToFavorite();
        foundCars = carList.getElementsFromFavoriteList();
        for (WebElement o : foundCars) {
            if (a.contains(o.getText())) flag = true;
            jse.executeScript("window.scrollBy(0,-500)", "");
            assertTrue(flag);
        }
    }
    @Test
    public void addToCompareListTest() {
        List<WebElement> foundCars = new LinkedList<>();
        String a;
        boolean flag = false;
        siteNavigation.getAutoRu();
        carFilter.getCarsByFirm("MINI");
        foundCars =carList.getCarsFromPage();
        a = foundCars.get(0).getText();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)", "");
        actions.moveToElement(foundCars.get(0)).build().perform();
        carList.addToCompareList();
        foundCars = carList.getElementsFromCompareList();
        for (WebElement o : foundCars){
            if (a.contains(o.getText().substring(0,o.getText().length()-6)))
                flag = true;
        }
        jse.executeScript("window.scrollBy(0,-500)", "");
        assertTrue(flag);
    }
    @Test
    public void saveSearchTest() {
        List<WebElement> foundCars = new LinkedList<>();
        carFilter.getCarsByFirm("MINI");
        carList.saveSearch();
        assertTrue((carList.getUpNotifierText().contains("сохранён")));
    }
}






