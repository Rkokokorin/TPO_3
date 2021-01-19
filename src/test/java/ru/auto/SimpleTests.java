package ru.auto;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleTests {
    private static WebDriver driver;
    @BeforeAll
       static void up() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peppe\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://auto.ru");

    }

        @Test
        void afterTIFFClickThereIsSignUpPage() {
            WebElement element = driver.findElement(By.xpath("//*[text()='Войти']"));
            element.click();
         List<WebElement> list  = driver.findElements(By.xpath("//form//div[@class='AuthForm__title']"));
         assertEquals(1, list.size());
         driver.quit();

        }

        }

