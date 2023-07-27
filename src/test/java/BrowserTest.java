import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {

    static WebDriver driver;
    @BeforeAll
    static void prepareBrowser() {
        driver = new ChromeDriver();
        driver.get("https://pl.wikipedia.org/");
        driver.manage().window().maximize();

    }
    @Test
    void pageTitleAsExpected(){
        Assertions.assertEquals("Wikipedia, wolna encyklopedia", driver.getTitle());
    }
    @Test
    void pageSourceAsExpected(){
        Assertions.assertTrue(driver.getPageSource().contains("Stowarzyszenie Wikimedia Polska"));
    }
    @Test
    void wikiPageURLTest(){
        Assertions.assertEquals("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna",
                driver.getCurrentUrl());
    }
    @AfterAll
    static void closeBrowser(){
        driver.quit();
    }

}
