package ru.auto.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class SignInPage {
    WebDriver driver;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterEmail() {
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div/div/div/div/form/div/div[2]/span/label/div/span/input"))).sendKeys("k.r.007.015@gmail.com");
        driver.findElement(By.xpath("//*[text()='Продолжить']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div/div/div/div/form/div/div[3]/div[2]/label/div")));
    }
    public void signUpUsingMailRu() {
        List<String> windows = new LinkedList<String>();
        String firstWindow = driver.getWindowHandle();
        System.out.println(firstWindow);
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='SocialIcon SocialIcon_mailru']"))).click();
        windows.addAll(driver.getWindowHandles());
        windows.remove(firstWindow);
        driver.switchTo().window(windows.get(0));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='login-form__2col']//input"))).sendKeys("tpo.labs@mail.ru");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@type='password']"))).sendKeys("fdharen3");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@class='ui-button-main']")))).click();
        driver.switchTo().window(firstWindow);
    }

}
