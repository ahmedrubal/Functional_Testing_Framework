package io.com_functional_testing.alternate;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listener extends Screen implements ITestListener {



    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("test is started");
        test=extent.startTest(result.getMethod().getMethodName());
        test.log(LogStatus.INFO,"Test Started"+result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        result.getMethod().getMethodName();
        extent.endTest(test);

    }

    @Override
    public void onTestFailure(ITestResult result) {
                TakesScreenshot screenshot = (TakesScreenshot) Screen.getDriverInstance();
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinatonFile = new File("screen/shots.png");
        System.out.println(destinatonFile);
        try {
            FileHandler.copy(sourceFile,destinatonFile);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        test.log(LogStatus.INFO,"Test is failed");
    }
}
