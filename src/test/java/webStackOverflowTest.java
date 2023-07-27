import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class webStackOverflowTest {
    static WebDriver driver;
    @BeforeAll
    static void prepareBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://serwer169007.lh.pl/autoinstalator/serwer169007.lh.pl/wordpress10772/");
    }
    @Test
    void countElements(){
        List<WebElement> elements = driver.findElements(By.className("attachment-woocommerce_thumbnail"));
        System.out.println(elements.size());
    }
    @Test
    void countPicture(){
        List<WebElement> elements1 = driver.findElements(By.tagName("img"));
        System.out.println(elements1.size());
    }
    @Test
    void checkIsSearchInput(){
        List<WebElement> elements2 = driver.findElements(By.linkText("zapisz się do newslettera"));
        System.out.println(elements2.size());
        Assertions.assertEquals(1,elements2.size());
    }
    @AfterAll
    static void closeBrowser(){
        driver.quit();
    }
}
