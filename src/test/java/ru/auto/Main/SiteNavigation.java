package ru.auto.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiteNavigation {
    public final String CITY_XPATH = "//*[@class='GeoSelect__title-shrinker']";
    public final String AUTH_FORM_XPATH ="//form//div[@class='AuthForm__title']";
    public final String SIGN_IN_HEADER_XPATH = "/html/body/div/div/div/div/form/div/div[3]/div[2]/label/div";
    public final String MAGAZINE_LOGO_XPATH = "//*[@class='jrnl-logo']";
    public final String CARS_HEADER_XPATH = "/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[2]/h1";
    public final String COMMERCIAL_HEADER_XPATH = "/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[2]/div[2]";
    public final String COMPARE_HEADER_XPATH ="//*[@id=\"LayoutIndex\"]/div/h1";
    public final String CARS_FEEDBACK_HEADER ="//*[text()='Отзывы об автомобилях']";
    public final String DROP_DOWN_MENU_XPATH ="/html/body/div[2]/div/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]";
    WebDriver driver;
    public SiteNavigation(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToSignUp() {
        this.getAutoRu();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/header/div/div[4]/div[2]/div/a")));
        driver.findElement(By.xpath("//*[text()='Войти']")).click();
    }
    public void navigateToMagazine(){
        this.getAutoRu();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/header/div/div[2]/div[7]/div/a")));
        driver.findElement(By.xpath("/html/body/div[2]/div/header/div/div[2]/div[7]/div/a")).click();
    }
    public void navigateToCommercialCars() {
        this.getAutoRu();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/header/div/div[2]/div[3]/div[1]/div/a")));
        driver.findElement(By.xpath("/html/body/div[2]/div/header/div/div[2]/div[3]/div[1]/div/a")).click();
    }
    public void navigateToModelComparePage() {
        this.getAutoRu();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[2]/div[5]")));
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[2]/div[5]")).click();
    }
    public void navigateToFeedbackPage() {
        this.getAutoRu();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[1]/div/a[4]")));
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[1]/div/a[4]")).click();
    }
    public void navigateToCarPage(){
        this.getAutoRu();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/header/div/div[2]/div[2]/div[1]/div/a"))).click();

    }
    public void navigateToItemFromDropDownMenu() {
        this.getAutoRu();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='Dropdown__switcher HeaderHamburgerMenu']")));
        WebElement element = driver.findElement(By.xpath("//*[@class='Dropdown__switcher HeaderHamburgerMenu']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div/header/div/div[2]/div[1]/div[2]/div/div[1]/div[3]/a")));
        driver.findElement(By.xpath("/html/body/div[2]/div/header/div/div[2]/div[1]/div[1]")).click();

    }
    public void changeCity() {
        this.getAutoRu();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='GeoSelect__title-shrinker']"))).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Регион, город, населенный пункт']/../input"))).sendKeys("Москва");
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Москва и Московская область']"))).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='GeoSelectPopup__regions']/../button"))).click();
    }
    public void getAutoRu() {
        driver.get("https://auto.ru");
    }

}
