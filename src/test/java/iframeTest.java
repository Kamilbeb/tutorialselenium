import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class iframeTest {
    @Test
    public void testWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);  //przełączenie na ifrema
        driver.findElement(By.id("fname")).sendKeys("Kamil");
        driver.switchTo().defaultContent(); //powrót do pierwotnej strony
        System.out.println(driver.findElement(By.tagName("h1")).getText());




    }
}
