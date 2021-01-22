package ru.auto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class CarTests {
    static final String topNavigationLinksXPath ="/html/body/div/header/div/div[2]/div[2]/div[1]/div/a";
    private static WebDriver driver;
    @BeforeAll
    static void up() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peppe\\Downloads\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

    }
    @AfterAll
    static void close() {
      driver.quit();
    }

    @Test
    void checkNumberTest(){
        driver.get("https://auto.ru/lcv/used/sale/uaz/3909/16485582-76184ed9/");
        String a;
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button//*[text()='Показать телефон']"))).click();
        a= (new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='SellerPhonePopup-module__phoneNumber']")))).getText();
        assertEquals(a,"+7 982 640-31-55");
    }
    @Test
    void checkMapTest() {
        driver.get("https://auto.ru/lcv/used/sale/uaz/3909/16485582-76184ed9/");
        List<WebElement> a = new ArrayList<>();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='MetroListPlace__regionName MetroListPlace_space']"))).click();
        a.add(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='SellerPlacePopup__mapContainer']"))));
        assertEquals(1, a.size());
    }
    @Test
    void checkScore(){
        driver.get("https://auto.ru/lcv/used/sale/uaz/3909/16485582-76184ed9/");
        List<WebElement> a = new ArrayList<>();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='Link RatingInfo-module__RatingInfo__link']"))).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        a.add (new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Добавить отзыв']"))));
        assertEquals(1,a.size());

    }
    @Test
    void addFeedback(){
        driver.get("https://auto.ru/reviews/trucks/lcv/uaz/3909/?from=card");
        List<WebElement> a = new ArrayList<>();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Добавить отзыв']"))).click();
        a.add (new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ReviewFormPage__title']"))));
        assertEquals(1,a.size());

    }
    @Test
    void changeCityTest(){
        driver.get("https://auto.ru/");
        List<WebElement> a = new ArrayList<>();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='GeoSelect__title-shrinker']"))).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Регион, город, населенный пункт']/../input"))).sendKeys("Москва");
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Москва и Московская область']"))).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='GeoSelectPopup__regions']/../button"))).click();
        assertTrue(new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='GeoSelect__title-shrinker']"))).getText().contains("Москва"));


    }
}