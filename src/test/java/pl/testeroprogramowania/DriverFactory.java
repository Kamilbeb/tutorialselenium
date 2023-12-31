package pl.testeroprogramowania;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {     //sprawdzamy czy nasz driver został utworzony jeżeli nie to go stworzymy
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;    //jeżeli zmienna driver jest już utworzona i zainicjalizowana to od razu zwracamy ją
    }
}
