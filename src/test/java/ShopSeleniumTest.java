import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShopSeleniumTest {
    static WebDriver driver;
    @BeforeAll
    static void prepareBrowser(){
        driver = new ChromeDriver();
        driver.get("http://seleniumdemo.com/");
        driver.manage().window().maximize();
    }
    @Test
    void IsThereASeleniumCourse(){
        driver.findElement(By.xpath("//span[text()='Shop']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//h2[text()='Java Selenium WebDriver']")).isDisplayed());


    }
    @AfterAll
    static void closeBrowser(){
        driver.close();
    }


}
