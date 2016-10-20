import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by user on 2016/10/20.
 */
public class SearchTest {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private WebElement webElement;
    private final String HOME_PAGE = "http://store.demoqa.com/";

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
    public void InputAppel() {
        webElement = webDriver.findElement(By.xpath("//input[@value = 'Search Products']"));
        webElement.sendKeys("appel");
        webElement.sendKeys(Keys.ENTER);
        webElement = webDriver.findElement(By.xpath("//div[@id = 'content']/p"));
        assertEquals(webElement.getText(), "Sorry, but nothing matched your search criteria. Please try again with some different keywords.");
    }

    @Test
    public void InputApple() {
        webElement = webDriver.findElement(By.xpath("//input[@value = 'Search Products']"));
        webElement.sendKeys("apple");
        webElement.sendKeys(Keys.ENTER);
        java.util.List<WebElement> list = webDriver.findElements(By.xpath("//img[@class = 'product_image']"));
        assertTrue(!list.isEmpty());
    }

    @Test
    public void Input_Apple() {
        webElement = webDriver.findElement(By.xpath("//input[@value = 'Search Products']"));
        webElement.sendKeys("Apple");
        webElement.sendKeys(Keys.ENTER);
        java.util.List<WebElement> list = webDriver.findElements(By.xpath("//img[@class = 'product_image']"));
        assertTrue(!list.isEmpty());
    }
}
