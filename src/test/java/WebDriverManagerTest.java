import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManagerTest {


    @Test
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        /*WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();*/
        driver.manage().window().maximize();
        //Dimension windowSize = new Dimension(200, 200); //ustawianie wielkości przeglądarki
        //driver.manage().window().setSize(windowSize);
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait( 5 , TimeUnit. SECONDS);
        driver.findElement(By.xpath("//div[text() = 'Zaakceptuj wszystko']")).click();


    }
}
