import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitTest {

    WebDriver driver;
    @Test
    public void imageTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        //Thread.sleep(5000);                     //zatrzymanie na 5s
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);        //definiowanie wyjątku z biblioteki selenium wybieramy
        wait.withTimeout(Duration.ofSeconds(10));           //definiowanie timeout
        wait.pollingEvery(Duration.ofSeconds(1));       //ustaiwenie co ile będzie sprawdzane czy jest już element
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));


        driver.findElement(By.cssSelector("p"));


        }
}
