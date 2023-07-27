import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstTest {

    //WebDriver driver = new ChromeDriver();

    @Test
    void checkIfOneIsBiggerThanTwo(){

        Assertions.assertTrue(2>1,"Should confirm that if 1 is less than 2");
    }
    @Test
    void printWordHello(){
        System.out.println("Hello");
    }
    @Test
    void checkTwoNumber(){
        Assertions.assertEquals(23,23);
    }
    @Test
    void shouldCompareTwoSameString(){
        Assertions.assertEquals("ANNA","anna".toUpperCase());
    }
    @Test
    void shouldAddNumbers(){
        int result = addNumbers(2,3);
        Assertions.assertEquals(5,result,"should return sum of two numbers");
    }
    int addNumbers(int a, int b){
        return (a+b);
    }
    @Test
    void shouldSurfaceAreaOfCircle(){
        double result = areaCircle(5);
        Assertions.assertEquals(78.5,result);
    }
    double areaCircle(double r){
        return 3.14*r*r;
    }
    @Test
    void shouldReturnUpperCaseWordWithoutSpaces(){
        Assertions.assertEquals("KOT W WORKU",removeSpaces("  kot w worku  "));
    }
    String removeSpaces(String wordToTransfer){
        return wordToTransfer.trim().toUpperCase();
    }
}
