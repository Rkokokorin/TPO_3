package ru.auto.Tests;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.auto.Main.SignInPage;
import ru.auto.Main.SiteNavigation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.auto.Main.TestConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavigationTests {
    private static WebDriver driver;
    static SignInPage signInPage;
    static SiteNavigation siteNavigation;
    @BeforeAll
    public static void up() {
        driver= TestConfiguration.initialize();
        siteNavigation =new SiteNavigation(driver);
        signInPage = new SignInPage(driver);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }
    @AfterAll
    static void close() {
        driver.quit();
    }

    @Test
    void changeCityTest(){
        siteNavigation.changeCity();
        List<WebElement> a = new ArrayList<>();
        assertTrue(new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(siteNavigation.CITY_XPATH))).getText().contains("Москва"));
    }

    @Test
    void navigateToSignUpPageTest() {
        siteNavigation.navigateToSignUp();
        List<WebElement> list  = driver.findElements(By.xpath(siteNavigation.AUTH_FORM_XPATH));
        assertEquals(1, list.size());
}
    @Test
    void emailEnterSignUpPageTest() {
        siteNavigation.navigateToSignUp();
        signInPage.enterEmail();
        List<WebElement> list  = driver.findElements(By.xpath(siteNavigation.SIGN_IN_HEADER_XPATH));
        assertEquals(1, list.size());
    }
    @Test
    void magazinePageTest() {
        siteNavigation.navigateToMagazine();
        List<WebElement> list  = driver.findElements(By.xpath(siteNavigation.MAGAZINE_LOGO_XPATH));
        assertEquals(1, list.size());
    }
    @Test
    void carPageTest() {
        siteNavigation.navigateToCarPage();
        List<WebElement> list  = driver.findElements(By.xpath(siteNavigation.CARS_HEADER_XPATH));
        assertEquals(1, list.size());
    }
    @Test
    void commercialCarPageTest() {
        siteNavigation.navigateToCommercialCars();
        List<WebElement> list  = driver.findElements(By.xpath(siteNavigation.COMMERCIAL_HEADER_XPATH));
        assertEquals(1, list.size());
    }
    @Test
    void comparePageTest() {
        siteNavigation.navigateToModelComparePage();
        List<WebElement> list  = driver.findElements(By.xpath(siteNavigation.COMPARE_HEADER_XPATH));
        assertEquals(1, list.size());

    }
    @Test
    void feedbackPageTest() {
        siteNavigation.navigateToFeedbackPage();
        List<WebElement> list  = driver.findElements(By.xpath(siteNavigation.CARS_FEEDBACK_HEADER));
        assertEquals(1, list.size());
    }
    @Test
    void dropDownTest() {
        siteNavigation.navigateToItemFromDropDownMenu();
        List<WebElement> list = driver.findElements(By.xpath(siteNavigation.DROP_DOWN_MENU_XPATH));
        assertEquals(1, list.size());
    }
}

