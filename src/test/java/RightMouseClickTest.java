import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class RightMouseClickTest {
    @Test
    public void uploadFile() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        driver.manage().window().maximize();
        int randomNumber = (int) (Math.random()*1000);


        Actions actions = new Actions(driver);
        //actions.contextClick().perform(); //kliknięcie PPM - czyli wyświetla się menu kontekstowe
        actions.contextClick(driver.findElement(By.id("myFile"))).perform(); //kliknięcie PPM w konkretny element


    }
}
