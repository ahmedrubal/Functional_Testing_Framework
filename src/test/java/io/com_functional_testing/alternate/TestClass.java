package io.com_functional_testing.alternate;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends Screen {
    @Test()
    void testOne(){
       // WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://nktechsolutions.com/membership-login/");
        WebElement ele =driver.findElement(By.xpath("//h1[text()='Member Login']"));
        Assert.assertEquals(ele,"Member ogin");
        test.log(LogStatus.INFO,"Test is passed");


    }
}
