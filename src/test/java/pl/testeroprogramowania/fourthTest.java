package pl.testeroprogramowania;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class fourthTest {

    @Test(dependsOnMethods = {"thirdTest"})
    public void firstTest(){
        System.out.println("I am first test");
    }
    @Test(dependsOnMethods = {"firstTest"})
    public void secondTest(){
        System.out.println("I am second test");
    }
    @Test
    public void thirdTest(){
        System.out.println("I am third test");
    }


    @Test(dataProvider = "data")        //określamy że nasza metoda bedzie korzystała z dataProvider
    public void dpTest(String val, String number){

        System.out.println(val);
        System.out.println(number);

    }

    @DataProvider(name = "data")        //oznaczamy dataProvidera 0raz w nawiasie tworzymy jego nazwę
    public Object[][] dataProvider(){       //będzie zwracało tablicę dwuwymiarową
        return new Object[][]{{"I am first test","First"},{"I am second test","Second"},{"I am third test","Third"}}; //nasza metoda będzie zwracała 3 wartości podane w klamrach
    }
}
