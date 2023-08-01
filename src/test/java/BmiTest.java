import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BmiTest {
    @Test
    void bmiResultShouldBeDisplayed (){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bmi-online.pl/");
        driver.findElement(By.xpath("//span[@class='t-a-c__box__btn__label']")).click();
        List<WebElement> gender = driver.findElements(By.cssSelector(".radio-btn"));
        if(gender.size()>1){
            if(gender.get(1).isSelected()) gender.get(2).click();

        }
        driver.findElement(By.xpath("//input[@name='weight']")).sendKeys("88");
        driver.findElement(By.xpath("//input[@name='height']")).sendKeys("183");
        driver.findElement(By.tagName("button")).click();
        System.out.println(driver.findElement(By.className("result-value")).getText());
        driver.quit();

    }
}
