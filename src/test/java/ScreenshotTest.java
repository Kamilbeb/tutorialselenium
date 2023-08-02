import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest {
    @Test
    public void uploadFile() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");
        driver.manage().window().maximize();

        TakesScreenshot screenshot = (TakesScreenshot) driver; //castowanie drivera

        File before = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(before,new File("src/test/resources/beforeUpload.png"));

        driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\admin\\Documents\\sample.txt");

        File after = screenshot.getScreenshotAs(OutputType.FILE); //pobranie do pliku
        FileUtils.copyFile(after,new File("src/test/resources/afterUpload.png")); //zapisanie pliku w lokalizacji wskazanej
    }
}
