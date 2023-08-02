import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasicActionsTest {
    @Test
    public void performAction(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");
        driver.manage().window().maximize();

        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPageLink.getText());
        basicPageLink.click();
        driver.findElement(By.id("fname")).sendKeys("Kamil");
        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.clear();
        userNameInput.sendKeys("admin");
        System.out.println(userNameInput.getAttribute("value")); //pobranie wartości z pola input

        userNameInput.sendKeys(Keys.ENTER); //symulacja naciśnięcia Enter

        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        driver.switchTo().alert().accept();


        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();

        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        cars.selectByValue("volvo");
        List<WebElement> options = cars.getOptions();
        for(WebElement option : options){
            System.out.println(option.getText());
        }
        SelectCheck selectCheck = new SelectCheck();
        System.out.println(selectCheck.checkOption("Audi",selectCar));

        WebElement para = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By text: "+ para.getAttribute("textContent")); //pobieranie tekstu z ukrytego elementu

    }
}
