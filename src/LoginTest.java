import com.google.common.base.Predicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 2016/10/20.
 */
public class LoginTest {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private WebElement webElement;
    private final String HOME_PAGE = "http://store.demoqa.com/products-page/your-account/";

    @Before
    public void SetUp() {
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 30);
        webDriver.get(HOME_PAGE);
    }

    @After
    public void cleanUp() {
        webDriver.quit();
    }

    @Test
    public void WrongAccountOnly() {
        webElement = webDriver.findElement(By.xpath("//input[@id='log']"));
        webElement.sendKeys("kAiyang");
        webElement = webDriver.findElement(By.xpath("//input[@id='pwd']"));
        webElement.sendKeys("123");
        webDriver.findElement(By.xpath("//input[@id='login']")).submit();
        assertEquals(webDriver.getCurrentUrl(), "http://store.demoqa.com/products-page/your-account/");
    }

    @Test
    public void WrongPasswordOnly() {
        webElement = webDriver.findElement(By.xpath("//input[@id='log']"));
        webElement.sendKeys("kaiyang");
        webElement = webDriver.findElement(By.xpath("//input[@id='pwd']"));
        webElement.sendKeys("1");
        webDriver.findElement(By.xpath("//input[@id='login']")).submit();
        assertEquals(webDriver.getCurrentUrl(), "http://store.demoqa.com/products-page/your-account/");
    }

    @Test
    public void BothWrong() {
        webElement = webDriver.findElement(By.xpath("//input[@id='log']"));
        webElement.sendKeys("kAIyang");
        webElement = webDriver.findElement(By.xpath("//input[@id='pwd']"));
        webElement.sendKeys("13");
        webDriver.findElement(By.xpath("//input[@id='login']")).submit();
        assertEquals(webDriver.getCurrentUrl(), "http://store.demoqa.com/products-page/your-account/");
    }


}
