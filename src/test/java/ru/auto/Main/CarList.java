package ru.auto.Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CarList {
    WebDriver driver;
    public CarList(WebDriver driver) {
        this.driver = driver;
    }
    public List<WebElement> getCarsFromPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='ListingItemTitle-module__clicker']"))));
        return (driver.findElements(By.xpath("//*[@class='Link ListingItemTitle-module__link']")));
    }
    public void addToFavorite() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='IconSvg IconSvg_favorite-small IconSvg_size_24 ButtonFavorite-module__icon']")))).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='ButtonFavorite-module__notificationLink']")))).click();
    }
    public   List<WebElement> getElementsFromFavoriteList(){
        String s = "//*[@class='TopNavigationFavoritesPopupItem-module__clicker']";
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath((s))));
        return(driver.findElements(By.xpath(s)));
    }
    public void addToCompareList() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='IconSvg IconSvg_compare-small IconSvg_size_24 ButtonCompare-module__icon']")))).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='Link ButtonCompare-module__link']")))).click();
    }
    public List<WebElement> getElementsFromCompareList(){
        String s= "//*[@class='Link ComparableOfferHeadCell__title']";
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath((s))));
        return(driver.findElements(By.xpath(s)));
    }
    public void saveSearch() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='SubscriptionSaveButton']")))).click();
    }
    public String getUpNotifierText() {
        return (new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='Notifier__text']")))).getText());
    }
    public List<WebElement> getCarsAgeFromPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='ListingItemTitle-module__clicker']"))));
        return ( driver.findElements(By.xpath("//*[@class= 'ListingItem-module__year']")));
    }
    public List<WebElement> getCarsPriceFromPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='ListingItemTitle-module__clicker']"))));
        return ( driver.findElements(By.xpath("//*[@class= 'ListingItemPrice-module__content']")));
    }
    public List<WebElement> getCarsKmAgeFromPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='ListingItemTitle-module__clicker']"))));
        return (driver.findElements(By.xpath("//*[@class= 'ListingItem-module__kmAge']")));
    }
    public List<WebElement> getCarsTechSummaryFromPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(("//*[@class='ListingItemTitle-module__clicker']"))));
        return (driver.findElements(By.xpath("//*[@class= 'ListingItemTechSummaryDesktop__cell']")));
    }
    public List<WebElement> getCarsModelsFromPage() {
        return (driver.findElements(By.xpath("//h3/a[@class='Link ListingItemTitle-module__link']")));
    }

}
