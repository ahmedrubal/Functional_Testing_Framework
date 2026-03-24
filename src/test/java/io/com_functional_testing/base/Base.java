package io.com_functional_testing.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.com_functional_testing.actions.MemberLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;
// This is another approach to generate extent report
public class Base {
    public static ExtentSparkReporter spark;
    public static ExtentReports report;
    public static ExtentTest test;
    public static WebDriver driver;
    public static MemberLoginPage memberLoginPage;

    public static MemberLoginPage memberLoginPageObject() {
        return memberLoginPage = new MemberLoginPage();
    }

    @Parameters("browser")
    @BeforeSuite
    public static void beforeMethod(String browser) {
        setupBrowser(browser);
        driver.get("https://nktechsolutions.com/membership-login/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Base.memberLoginPage=Base.memberLoginPageObject();

    }
    @BeforeTest(groups = "Sanity")
    public static void beforeTest(){
        Base.setupReport();
    }
    public static void setupReport(){
        spark = new ExtentSparkReporter
                (System.getProperty("user.dir")+"/extentReport/TrialBase.html");
        spark.config().setReportName("Test Automation");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setTimeStampFormat("mm/dd/yyyy");
        report = new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("Device_Name", "Windows");
        report.setSystemInfo("Tester_Name", "Rubal Ahmed");
    }
    @AfterTest(groups = "Regression")
    public static void afterTest(){
        Base.flushReport();
    }
    public static void flushReport(){
        report.flush();
    }

    @AfterSuite
    public void afterMethod(ITestResult result) {
//        if(result.getStatus()==ITestResult.FAILURE){
//            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" --Test is Failed--" ,
//                    ExtentColor.RED));
//            test.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+"-Test case Failed-",
//                    ExtentColor.RED));
//        }else if(result.getStatus()==ITestResult.SUCCESS) {
//            test.log(Status.PASS, MarkupHelper.createLabel("Test is Pass",
//                    ExtentColor.GREEN));
//        } else if (result.getStatus()==ITestResult.SKIP) {
//            test.log(Status.SKIP, MarkupHelper.createLabel("Test is Skipped",
//                    ExtentColor.ORANGE));
//
//        }
        driver.quit();
    }

    public static void setupBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();

            driver=new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
