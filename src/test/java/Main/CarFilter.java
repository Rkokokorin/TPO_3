package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarFilter {
    WebDriver driver;
    public CarFilter(WebDriver driver) {
        this.driver = driver;
    }
    public void getCarsByFirm(String firm) {
        this.getAutoRu();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='IndexMarks__item-name']")));
        firm = "//*[contains(@class,'IndexMarks__item-name') and contains(text(),'" + firm +"')]";
        driver.findElement(By.xpath(firm)).click();
    }
    public void setAgeFilter(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div[1]/span/div[1]/button/span/span")))
                .click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'MenuItem MenuItem_size_m' and  contains(text(), '2015')]"))).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button")).click();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> !driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItem-module__year']")));

    }
    public void setPriceFilter() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div[3]/span/label[2]/div/span/input"))).sendKeys("800000");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div[3]/span/label[1]/div/span/input"))).sendKeys("200000");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button")).click();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> !driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItemPrice-module__content']")));

    }
    public void setDestinationFilter() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div[2]/span/label[1]/div/span/input"))).sendKeys("100000");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[3]/div[2]/span/label[2]/div/span/input"))).sendKeys("200000");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button")).click();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> !driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItemPrice-module__content']")));

    }
    public void setCarcassFilter() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[1]/div/button")))
                .click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'MenuItem MenuItem_size_m' and  contains(text(), 'Хэтчбек 3 дв.')]"))).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button")).click();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> !driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItem-module__year']")));
    }
    public void setDriveFilter(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/button")))
                .click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'MenuItem MenuItem_size_m' and  contains(text(), 'Передний')]"))).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button")).click();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> !driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItem-module__year']")));
    }
    public void setModelFilter(){
        driver.get("https://auto.ru/sankt-peterburg/cars/luaz/all/");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div/button")))
                .click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'MenuItem MenuItem_size_m' and  contains(text(), '967')]"))).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button")).click();
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> !driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) driver -> driver.findElement
                (By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[2]/div/div[3]/div[3]/div[3]/button/span/span")).
                getText().contains("Показать"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class= 'ListingItem-module__year']")));

    }

    public void getAutoRu(){
        driver.get("https://auto.ru");
    }
}
