import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SelectorTest {
    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.manage().window().maximize();

        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        //fname
        By firstName = By.name("fname");
        WebElement firstNameInput = driver.findElement(firstName);

        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden);

        By input = By.tagName("input");
        WebElement inputLocator = driver.findElement(input); //zwraca jeden element pierwszy typu input
        inputLocator.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(input); //zwraca listę input
        System.out.println(inputs.size());

        //link
        By linkText = By.linkText("Visit W3Schools.com!");
        WebElement schoolLink = driver.findElement(linkText);

        By partiaLink = By.partialLinkText("Visit");
        WebElement schoolPartial = driver.findElement(partiaLink);


    }
}
