package com.automation.training.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import java.util.List;
import java.util.logging.Logger;

public class Base {


    private WebDriver driver;

    private WebDriverWait wait;

    private final static Logger LOGGER= Logger.getLogger("com.automation.training.pages.Base");

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    @Parameters({"browser", "url"})
    public WebDriver driverConnection(String browser, String url){
        switch (browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver");
                driver = new FirefoxDriver();
                wait = new WebDriverWait(driver, 5);
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
                driver = new ChromeDriver();
                wait = new WebDriverWait(driver, 5);
                break;
            default:
                break;
        }
        return driver;
    }


    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public WebElement waitElementTobeVisible(By locator){
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    @Parameters({"url"})
    public void visit (String url){
        driver.get(url);
    }

    public void switchDisneyIframe(){
        driver.switchTo().frame("disneyid-iframe");
    }
}