import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecutorTest {
    @Test
    public void executeJavaScript(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium");
        driver.manage().window().maximize();
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        JavascriptExecutor executor = (JavascriptExecutor) driver; //stworzenie zmiennej executor typu JSE i skastowanie do drivera
        executor.executeScript("arguments[0].click();", basicPageLink); //wywołujemy metodę
    }
}
