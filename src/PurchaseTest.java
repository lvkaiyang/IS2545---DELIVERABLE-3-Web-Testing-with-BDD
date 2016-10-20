import com.google.common.base.Predicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by user on 2016/10/18.
 */
public class PurchaseTest {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private WebElement webElement;
    private final String HOME_PAGE = "http://store.demoqa.com/";

    @Before
    public void SetUp() {
        webDriver = new HtmlUnitDriver();
        webDriverWait = new WebDriverWait(webDriver, 30);
        webDriver.get(HOME_PAGE);
    }

    @After
    public void cleanUp() {
        webDriver.quit();
    }

    @Test
    public void CheckOutNullItem() {
        webDriver.findElement(By.xpath("//div[@id='header_cart']/a")).click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webElement = webDriver.findElement(By.xpath("//div[@class='entry-content']"));
        assertEquals(webElement.getText(), "Oops, there is nothing in your cart.");
    }

    @Test
    public void PurchaseNoInfo() {
        webDriver.findElement(By.linkText("Product Category")).click();
        webDriverWait.until((Predicate<WebDriver>) w -> {
            return webDriver.findElement(By.xpath("//div[@class='input-button-buy']")).isEnabled();
        });
        webDriver.findElements(By.xpath("//div[@class='input-button-buy']/span/input")).get(2).click();
        webDriverWait.until((Predicate<WebDriver>) w -> {
            return webDriver.findElement(By.xpath("//div[@id='fancy_notification_content']")).isEnabled();
        });
        webDriver.navigate().to("http://store.demoqa.com/products-page/checkout/");
        webDriverWait.until((Predicate<WebDriver>) w -> {
            return webDriver.findElement(By.xpath("//a[@class='step2']")).isEnabled();
        });
        webDriver.navigate().to(webDriver.findElement(By.xpath("//a[@class='step2']")).getAttribute("href"));
        webDriverWait.until((Predicate<WebDriver>) w -> {
            return webDriver.findElement(By.xpath("//div[@class = 'input-button-buy']/span/input")).isEnabled();
        });
        webDriver.findElement(By.xpath("//div[@class = 'input-button-buy']/span/input")).submit();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(webDriver.getCurrentUrl());
        // If the page show the update button, the web page is still in step 1
        assertTrue(webDriver.findElement(By.xpath("//input[@value= 'Update']")).isEnabled());
    }
    @Test
    public void PurchaseRemove(){
        webDriver.findElement(By.linkText("Product Category")).click();
        webDriverWait.until((Predicate<WebDriver>) w -> {
            return webDriver.findElement(By.xpath("//div[@class='input-button-buy']")).isEnabled();
        });
        webDriver.findElements(By.xpath("//div[@class='input-button-buy']/span/input")).get(2).click();
        webDriverWait.until((Predicate<WebDriver>) w -> {
            return webDriver.findElement(By.xpath("//div[@id='fancy_notification_content']")).isEnabled();
        });
        webDriver.navigate().to("http://store.demoqa.com/products-page/checkout/");
        webDriverWait.until((Predicate<WebDriver>) w -> {
            return webDriver.findElement(By.xpath("//a[@class='step2']")).isEnabled();
        });
        webDriver.findElement(By.xpath("//form[@class='adjustform remove']")).submit();
        webElement = webDriver.findElement(By.xpath("//div[@class='entry-content']"));
        assertEquals(webElement.getText(), "Oops, there is nothing in your cart.");
    }
}
