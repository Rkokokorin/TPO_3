package ru.auto.Tests;

import net.bytebuddy.jar.asm.Handle;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignInTests {
    static final String topNavigationLinksXPath ="/html/body/div/header/div/div[2]/div[2]/div[1]/div/a";
    private static WebDriver driver;
    private static Actions actions;
    @BeforeAll
    static void up() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Peppe\\Downloads\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peppe\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.get("https://auto.ru");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        WebElement element = driver.findElement(By.xpath("//*[text()='Войти']"));
        List<String> windows = new LinkedList<String>();
        String firstWindow = driver.getWindowHandle();
        System.out.println(firstWindow);
        element.click();
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='SocialIcon SocialIcon_mailru']"))).click();
        windows.addAll(driver.getWindowHandles());
        windows.remove(firstWindow);
        driver.switchTo().window(windows.get(0));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='login-form__2col']//input"))).sendKeys("tpo.labs@mail.ru");
        driver.findElement(By.xpath("//*[@class='login-form__password']")).sendKeys("fdharen3");
        driver.findElement(By.xpath("//*[@class='ui-button-main']")).click();
        driver.switchTo().window(firstWindow);
    }

    @AfterAll
    static void close() {

    }
    @Test
    public void addToFavoriteTest() {
        driver.get("https://auto.ru");
        List<WebElement> foundCars = new LinkedList<>();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='IndexMarks__item-name']")));
        driver.findElement(By.xpath("//*[contains(@class,'IndexMarks__item-name') and contains(text(),'MINI')]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='ListingItemTitle-module__clicker']"))));
        foundCars = driver.findElements(By.xpath("//*[@class='Link ListingItemTitle-module__link']"));
        actions.moveToElement(foundCars.get(0)).perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='ListingItemActions-module__container ListingItem-module__actions']")))).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='ButtonFavorite-module__notificationLink']")))).click();
        String s = "//*[@class='TopNavigationFavoritesPopupItem-module__clicker']";
        String a = foundCars.get(0).getText();
        boolean flag = false;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath((s))));
        foundCars = driver.findElements(By.xpath(s));
        for (WebElement o : foundCars) {
            if (a.contains(o.getText())) flag = true;
            assertTrue(flag);
        }
    }
    @Test
    public void addToCompareListTest() {
        driver.get("https://auto.ru");
        List<WebElement> foundCars = new LinkedList<>();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='IndexMarks__item-name']")));
        driver.findElement(By.xpath("//*[contains(@class,'IndexMarks__item-name') and contains(text(),'MINI')]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='ListingItemTitle-module__clicker']"))));
        foundCars = driver.findElements(By.xpath("//*[@class='Link ListingItemTitle-module__link']"));
        String a = foundCars.get(0).getText();
        actions.moveToElement(foundCars.get(0)).perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='IconSvg IconSvg_compare-small IconSvg_size_24 ButtonCompare-module__icon']")))).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='Link ButtonCompare-module__link']")))).click();
        String s= "//*[@class='Link ComparableOfferHeadCell__title']";
        boolean flag =false;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath((s))));
        foundCars = driver.findElements(By.xpath(s));
        for (WebElement o : foundCars){
                 if (a.contains(o.getText().substring(0,o.getText().length()-6)))
                flag = true;
        }
        assertTrue(flag);

    }
    @Test
    public void saveSearchTest() {
        driver.get("https://auto.ru");
        List<WebElement> foundCars = new LinkedList<>();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='IndexMarks__item-name']")));
        driver.findElement(By.xpath("//*[contains(@class,'IndexMarks__item-name') and contains(text(),'MINI')]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='SubscriptionSaveButton']")))).click();
        assertTrue((new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='Notifier__text']")))).getText()).contains("сохранён"));
    }
}









