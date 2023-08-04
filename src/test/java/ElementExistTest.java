import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementExistTest {

    WebDriver driver;
    @Test
    public void elementExistTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));

        System.out.println(elementExistSecond(By.tagName("p")));
        System.out.println(elementExistSecond(By.id("topSecret")));

        System.out.println(driver.findElement(By.tagName("p")).isDisplayed()); //czy element się wyświetla
        System.out.println(driver.findElement(By.tagName("button")).isDisplayed());

        System.out.println(driver.findElement(By.tagName("button")).isEnabled()); //sprawdza czy element jest gotowy do edycji nie jest wyszarzony

        System.out.println("---------------------------------------");
        WebElement checkBox = driver.findElement(By.cssSelector("[type='checkbox']"));
        System.out.println(checkBox.isSelected());      //sprawdzenie czy checkbox jest zaznaczony
        checkBox.click();
        System.out.println(checkBox.isSelected());


    }

    public boolean elementExist(By locator){
        try {                                   //obsługa wyjątku jeżeli lokator istnieje zwróci true
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException ex){     //jeżeli nie znajdzie lokatora zwróci false
            return false;
        }
    }
    public boolean elementExistSecond(By locator){  //drugi sposób jest znalezienie listy elementów

           return driver.findElements(locator).size() >0 ; //sprawdzamy czy lokator istnieje jeżeli lista jest pusta to oznacza że nie istnieje
        }
}
