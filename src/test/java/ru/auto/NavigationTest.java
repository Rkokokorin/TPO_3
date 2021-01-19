package ru.auto;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavigationTest {
    static final String topNavigationLinksXPath ="/html/body/div/header/div/div[2]/div[2]/div[1]/div/a";
    private static WebDriver driver;
    @BeforeAll
       static void up() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peppe\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://auto.ru");



    }

        @AfterAll
        static void close() {
        driver.quit();

    }

        @Test
        void navigateToSignUpPageTest() {

            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("/html/body/div[2]/div/header/div/div[4]/div[2]/div/a")));
            WebElement element = driver.findElement(By.xpath("//*[text()='Войти']"));
            element.click();
         List<WebElement> list  = driver.findElements(By.xpath("//form//div[@class='AuthForm__title']"));
            new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div/div/div/div/form/div/div[2]/span/label/div/span/input"))).sendKeys("k.r.007.015@gmail.com");
            driver.navigate().back();
            assertEquals(1, list.size());

    }

        @Test
        void emailEnterSignUpPageTest() {
            WebElement element = driver.findElement(By.xpath("//*[text()='Войти']"));
            element.click();
            new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("/html/body/div/div/div/div/form/div/div[2]/span/label/div/span/input"))).sendKeys("k.r.007.015@gmail.com");
            driver.findElement(By.xpath("//*[text()='Продолжить']")).click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("/html/body/div/div/div/div/form/div/div[3]/div[2]/label/div")));
            List<WebElement> list  = driver.findElements(By.xpath("/html/body/div/div/div/div/form/div/div[3]/div[2]/label/div"));
            driver.navigate().back();
            assertEquals(1, list.size());

        }


    @Test
    void magazinePageTest() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/header/div/div[2]/div[7]/div/a")));
        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/header/div/div[2]/div[7]/div/a"));
        element.click();
        List<WebElement> list  = driver.findElements(By.xpath("/html/body/div[5]/div/section/a"));
        driver.navigate().back();
        assertEquals(1, list.size());
    }
    @Test
    void carPageTest() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/header/div/div[2]/div[2]/div[1]/div/a")));
        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/header/div/div[2]/div[2]/div[1]/div/a"));
        element.click();
        List<WebElement> list  = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[2]/h1"));
        driver.navigate().back();

        assertEquals(1, list.size());
    }


//    @Test
//    void navigateToCars() throws InterruptedException {
//
//        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/header/div/div[2]/div[2]/div[1]/div/a"));
//        List<WebElement> list  = driver.findElements((By.xpath("//*[text()='Купить автомобиль']")));
//        assertEquals(1, list.size());
//
//    }
}

