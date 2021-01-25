package ru.auto;

import net.bytebuddy.jar.asm.Handle;
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

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignInTests {
    static final String topNavigationLinksXPath ="/html/body/div/header/div/div[2]/div[2]/div[1]/div/a";
    private static WebDriver driver;
    @BeforeAll
    static void up() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peppe\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
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
    }
    @AfterAll
    static void close() {

    }
    @Test
    public void addToFavoriteTest(){
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//a[contains(@class,'IndexMarks__item')]"))).click();
            List<WebElement> foundcars = new LinkedList<>();
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//*[@class= 'ListingItemPrice-module__content']")));
            foundcars = driver.findElements(By.xpath("//*[@class= 'ListingItem-module__container ListingCars-module__listingItem']"));
            for (int i=0;i<3;i++)
                System.out.println(foundcars.get(i));
        }

    }


