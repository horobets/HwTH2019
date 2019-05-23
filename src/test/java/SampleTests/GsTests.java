package SampleTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GsTests {

    @Test(invocationCount = 100)

    public void testA() {


        new ChromeDriver();

        System.out.println("TEST A");

    }


    @Test

    public void testB() {

        System.out.println("TEST B");

    }


}
