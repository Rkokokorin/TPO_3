package ru.auto.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
public class CarPage {
    public final String PHONE_XPATH = "//*[@class='SellerPhonePopup-module__phoneNumber']";
    public final String MAP_XPATH = "//*[@class='SellerPlacePopup__mapContainer']";
    public final String ADD_FEEDBACK_BUTTON_XPATH = "//*[text()='Добавить отзыв']";
    public final String REVIEW_FORM_XPATH = "//*[@class='ReviewFormPage__title']";
    WebDriver driver;
    public CarPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getSellersNumber() {
        this.getCarPage();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button//*[text()='Показать телефон']"))).click();
    }
    public void getMap() {
        this.getCarPage();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='MetroListPlace__regionName MetroListPlace_space']"))).click();
    }
    public void getRating() {
        driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
        this.getCarPage();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='Link RatingInfo-module__RatingInfo__link']"))).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    public void addFeedback(){
        driver.get("https://auto.ru/reviews/cars/vaz/2107/2307270/?category=cars&from=card");
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Добавить отзыв']"))).click();
    }

    private void getCarPage() {
        driver.get("https://auto.ru/cars/used/sale/vaz/2107/1102269757-c5fc0f60/");

    }
}
