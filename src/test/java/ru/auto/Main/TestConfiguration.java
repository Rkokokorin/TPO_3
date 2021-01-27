package ru.auto.Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Driver;
import java.util.Properties;

public  class TestConfiguration {
    private static WebDriver driver;
    private static FileInputStream fis;
    private static Properties property = new Properties();

    public static WebDriver initialize(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Peppe\\Downloads\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Peppe\\Downloads\\chromedriver.exe");
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            if (property.getProperty("test.browser").equals("chrome"))
                driver = new ChromeDriver();
                else
                    if (property.getProperty("test.browser").equals("firefox"))
                        driver = new FirefoxDriver();
                        else{
                            System.out.println("Некоректно указан браузер");
                            driver = new ChromeDriver();
                            }

        }
        catch (Exception e) {
            System.out.println("Ошибка загрузки проперти файла");
            driver = new ChromeDriver();
        }

        return (driver);
    }

}
