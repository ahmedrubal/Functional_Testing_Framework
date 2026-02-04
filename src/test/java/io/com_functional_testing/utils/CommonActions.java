package io.com_functional_testing.utils;
import com.relevantcodes.extentreports.LogStatus;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;
import io.com_functional_testing.base.Base;
import io.com_functional_testing.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.time.Duration;

import static io.com_functional_testing.base.TestBase.report;
import static io.com_functional_testing.base.TestBase.test;

public class CommonActions {
    static final int max_wait_time =10;
    public static void waitForVisibilityOfEle(WebElement ele){
        WebDriverWait wait =new WebDriverWait(Base.getDriver(), Duration.ofSeconds(max_wait_time));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    public static void implicitlyWaitForEle(WebDriver driver,int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
    public static String textFromEle(WebElement text) {
        return text.getText().trim();
    }

    public static void explicitWait(int time){
        TestBase.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
    // Result class is used to capture method name dynamically
    public static void screenShot( ITestResult result){

        String methodName =result.getMethod().getMethodName();

        TakesScreenshot screenshot = (TakesScreenshot) TestBase.getDriver();
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinatonFile = new File("screen/"+methodName+".png");
        System.out.println(destinatonFile);
        try {
            FileHandler.copy(sourceFile,destinatonFile);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void reportAndLog(String mes){
        Logs.logInfo(mes);






    }


}
