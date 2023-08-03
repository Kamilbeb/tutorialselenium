import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class PageBasicTest {

    @Test
    public void pageTest(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.tagName("h1"))).perform();
        WebElement buttonClickMe = driver.findElement(By.id("clickOnMe"));
        actions.click(buttonClickMe).perform();
        driver.switchTo().alert().accept();
        WebElement inputName = driver.findElement(By.id("fname"));
        inputName.sendKeys("Kamil");
        String currentWindow = driver.getWindowHandle();

        driver.findElement(By.linkText("Visit W3Schools.com!")).click();
        Set<String> windowNames = driver.getWindowHandles();
        for(String window : windowNames){       //przełączenie się między oknami
            if(!window.equals(currentWindow)){      //jeżeli nazwa okna jest inna niż aktualnego to przełącz na to okno
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.id("accept-choices")).click();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        String currentWindow1 = driver.getWindowHandle();
        driver.findElement(By.linkText("IamWeirdLink")).click();
        Set<String> windowNames1 = driver.getWindowHandles();
        for(String window : windowNames1){       //przełączenie się między oknami
            if(!window.equals(currentWindow1)){      //jeżeli nazwa okna jest inna niż aktualnego to przełącz na to okno
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.id("L2AGLb")).click();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        System.out.println(driver.findElement(By.xpath("//tbody//tr[2]//td[1]")).getText());

        WebElement basicCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(basicCar);
        List<WebElement> options = cars.getOptions();
        for(WebElement option : options){
            System.out.println(option.getText());
        }
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();

        List<WebElement> radioCheck = driver.findElements(By.xpath("//input[@type='radio']"));
            for (WebElement radio : radioCheck) {
                System.out.println(radio.getAttribute("value"));
            }
        radioCheck.get(0).click();

        WebElement userName = driver.findElement(By.name("username"));
        userName.clear();
        userName.sendKeys("admin");
        WebElement pass = driver.findElement(By.name("password"));
        pass.clear();
        pass.sendKeys("admin1234");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();

        driver.findElement(By.id("newPage")).click();
        String currentWindow2 = driver.getWindowHandle();
        Set<String> windowNames2 = driver.getWindowHandles();
        for(String window : windowNames2){       //przełączenie się między oknami
            if(!window.equals(currentWindow2)){      //jeżeli nazwa okna jest inna niż aktualnego to przełącz na to okno
                driver.switchTo().window(window);
                driver.findElement(By.name("q")).sendKeys("Selenium");
                driver.close();
            }
        }
        driver.switchTo().window(currentWindow2);

        List<WebElement> listElements = driver.findElements(By.tagName("li"));
        for(WebElement elem : listElements){
            System.out.println(elem.getText());
        }
    }
}
