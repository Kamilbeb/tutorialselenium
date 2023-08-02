import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class NewWindowTest {
    @Test
    public void testWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.manage().window().maximize();
        String currentWindow = driver.getWindowHandle(); //nazwa pierwotnego okna
        driver.findElement(By.id("newPage")).click();
        Set<String> windowNames = driver.getWindowHandles(); //pobranie nazw wszystkich otwartych okien
        for(String window : windowNames){       //przełączenie się między oknami
            if(!window.equals(currentWindow)){      //jeżeli nazwa okna jest inna niż aktualnego to przełącz na to okno
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.switchTo().window(currentWindow); // przełączenie do pierwotnego okna
        driver.findElement(By.name("fname")).sendKeys("Kamil");
    }
}
