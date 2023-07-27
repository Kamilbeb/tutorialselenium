import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    @Test
    void shouldAddingTwoNumbers() {
        Assertions.assertEquals(10, Calculator.addTwoNumbers(5, 5),
                "should return correct sum");
    }
    @Test
    //@Disabled("Enable when subtract method is fixed")
    void shouldReturnCorrectSubstractingResult() {
        Assertions.assertEquals(5, Calculator.subTwoNumbers(10, 5),
                "Should return correct subtract");
    }
    @Test
    void shouldReturnCorrectMultiplingResult(){
        Assertions.assertEquals(25,Calculator.multiTwoNumbers(5,5),
                "Should return correct multiply");

    }
}
