package io.com_functional_testing.utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.com_functional_testing.base.Base;
import io.com_functional_testing.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestListener extends TestBase implements ITestListener, IAnnotationTransformer {

    public static ExtentTest test;


    @Override
    public void onTestStart(ITestResult result) {
        test=report.createTest( result.getMethod().getMethodName());
        test.log(Status.INFO,"Test is started");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test=report.createTest(result.getMethod().getMethodName());
      test.log(Status.PASS,"Test is successful");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test=report.createTest(result.getMethod().getMethodName());
        test.log(Status.FAIL,"Test is Failed");
      // Below code is used to store failed Screen shot in the screen folder in my local machine
        String methodName =result.getMethod().getMethodName();
        TakesScreenshot screen = (TakesScreenshot) TestBase.getDriver();
        File sourceFile = screen.getScreenshotAs(OutputType.FILE);
        File destinatonFile = new File("screen/"+methodName.toLowerCase()+".png");
        System.out.println(destinatonFile);
        try {
            FileHandler.copy(sourceFile,destinatonFile);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
      //  // Below code is used to attached screenshots in my report
        TakesScreenshot screenshot = (TakesScreenshot) TestBase.getDriver();
        String base64=screenshot.getScreenshotAs(OutputType.BASE64);
        test.log(Status.FAIL,test.addScreenCaptureFromBase64String(base64)+"--Exception Information--"+result.getThrowable());
        test.log(Status.FAIL,"Test failed and screen shot taken");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
      test=report.createTest(result.getMethod().getMethodName());
      test.info(result.getTestName());
      test.log(Status.SKIP,"Test is skipped");
    }

   // This method is added to TestListener to retry failed test cases to run multiple times before report to fail
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
        annotation.setRetryAnalyzer(RetryFailedTest.class);
    }
}
