import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FacebookTest {
    static WebDriver driver;
    @BeforeAll
    static void prepareBrowser(){
        driver = new ChromeDriver();
        driver.get("https://pl-pl.facebook.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@title='Zezwól na wszystkie pliki cookie']")).click();
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
    }
    @Test
    void listAllAvailableMonths(){
        driver.findElement(By.xpath("//a[text() = 'Utwórz nowe konto']")).click();
        Select birdayMonth = new Select(driver.findElement(By.name("birthday_month")));
        List<WebElement> months = birdayMonth.getOptions();

        for(int i=0; i< months.size();i++){
            System.out.println(months.get(i).getText());
        }
    }
}
