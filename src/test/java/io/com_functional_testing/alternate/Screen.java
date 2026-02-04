package io.com_functional_testing.alternate;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.File;
@Listeners(Listener.class)
public class Screen {

    public static WebDriver driver;
    public static ExtentTest test = null;
    static ExtentReports extent=null;
   @BeforeTest
    public static void setupExtentReport() {
        extent = new ExtentReports(
                System.getProperty("user.dir") + "/extentReport/Trial.html", true);

        extent.addSystemInfo("Host Name", "Test Project")
                .addSystemInfo("Environment", "QA Automation Testing")
                .addSystemInfo("User Name", "Khaled");
        extent.loadConfig(new File("./src/main/resources/"));


    }
    @AfterTest
    public static void flushReport(){

        extent.flush();
        extent.close();

    }
    public static WebDriver getDriverInstance(){
       return driver;
    }


}
