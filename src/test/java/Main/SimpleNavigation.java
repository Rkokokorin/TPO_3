package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class SimpleNavigation {
    WebDriver driver;
    public SimpleNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToSignUp() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/header/div/div[4]/div[2]/div/a")));
        driver.findElement(By.xpath("//*[text()='Войти']")).click();
    }
    public void navigateToMagazine(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/header/div/div[2]/div[7]/div/a")));
        driver.findElement(By.xpath("/html/body/div[2]/div/header/div/div[2]/div[7]/div/a")).click();
    }
    public void navigateToCommercialCars() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/header/div/div[2]/div[3]/div[1]/div/a")));
        driver.findElement(By.xpath("/html/body/div[2]/div/header/div/div[2]/div[3]/div[1]/div/a")).click();
    }
    public void navigateToModelComparePage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[2]/div[5]")));
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[2]/div[5]")).click();
    }
    public void navigateToFeedbackPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[1]/div/a[4]")));
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[1]/div/a[4]")).click();
    }
    public void navigateToCarPage(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/header/div/div[2]/div[2]/div[1]/div/a"))).click();

    }
    public void navigateToItemFromDropDownMenu() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='Dropdown__switcher HeaderHamburgerMenu']")));
        WebElement element = driver.findElement(By.xpath("//*[@class='Dropdown__switcher HeaderHamburgerMenu']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/header/div/div[2]/div[1]/div[2]/div/div[1]/div[3]/a")));
        driver.findElement(By.xpath("/html/body/div[2]/div/header/div/div[2]/div[1]/div[1]")).click();

    }

}
