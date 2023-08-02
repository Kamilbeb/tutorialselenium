import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class UploadTest {
    @Test
    public void uploadFile() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\admin\\Documents\\sample.txt");
        TakesScreenshot screenshot = (TakesScreenshot) driver; //castowanie drivera
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE); //pobranie do pliku
        FileUtils.copyFile(srcFile,new File("src/test/resources/screenshot.png")); //zapisanie pliku w lokalizacji wskazanej
    }
}
