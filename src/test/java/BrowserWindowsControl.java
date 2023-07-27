import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowsControl {
    @Test
    void checkWindowsSize() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(480,800));
        driver.manage().window().maximize();
        Assertions.assertEquals(new Dimension(1920,1080),
                driver.manage().window().getSize());
    }
}
