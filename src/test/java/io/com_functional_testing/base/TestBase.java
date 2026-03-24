package io.com_functional_testing.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.com_functional_testing.actions.HomePage;
import io.com_functional_testing.actions.JoinUsPage;
import io.com_functional_testing.actions.MemberLoginPage;
import io.com_functional_testing.utils.CommonActions;
import io.com_functional_testing.utils.ReadPropFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestBase {
    public static WebDriver driver;
    public static ExtentSparkReporter spark;
    public static ExtentReports report;
    public static ExtentTest test;
    public static HomePage homePage;
    public static MemberLoginPage memberLoginPage;
    public static JoinUsPage joinUsPage;

    // I  created object for every pages using method then
    //I don't have to create new object everytime instead just call methods

    public static HomePage homePageObject(){
            return homePage = new HomePage();}

     public static JoinUsPage joinUsPageObject(){
        return joinUsPage = new JoinUsPage();
    }

    public static MemberLoginPage memberLoginPageObject() {
        return memberLoginPage = new MemberLoginPage();
    }
    //if  I am supplying baseUrl from xml file then add another parameter in @Parameters like ({"baseUrl"})
    // parameters name and beforeSuite method arguments name must be same
    @Parameters({"browserName"})
    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite( String browserName){
//        Below line is used to  get url or anything from properties file
        // getProperty method accept string key value pairs
    String base= ReadPropFile.propertyFile(ReadPropFile.propFilePath).getProperty("url");
        setupBrowser(browserName);
        driver.get(base);

        // if i use xml file to pass parameters then i use bellow code
     //  setupBrowser(browserName);
      //  driver.get(baseUrl);
        driver.manage().window().maximize();
        CommonActions.implicitlyWaitForEle(TestBase.getDriver(),20);
        TestBase.homePage=TestBase.homePageObject();
        TestBase.memberLoginPage=TestBase.memberLoginPageObject();
        TestBase.joinUsPage=TestBase.joinUsPageObject();
    }
    @AfterSuite(alwaysRun = true)
    public static void afterSuite(){
        driver.quit();
    }
    //groups that running first must to add @BeforeTest
    @BeforeTest(groups="Sanity")
    public static void getReport(){

        TestBase.setReport();
    }
    // if we use groups for our test then must have to specify groups name at @AfterTest that running last
    @AfterTest(groups = "Regression")
    public static void tearDownReport(){
        TestBase.flushReport();
    }

    public static WebDriver setupBrowser(String browser){
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
        return driver;
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public static void setReport() {
      //  // here I used extentSparkReporter class so i don't need  config_xml file
        //// I am easily setup every configuration of report
        spark = new ExtentSparkReporter
            (System.getProperty("user.dir")+"/extentReport/TestReport.html");
        spark.config().setDocumentTitle("Automation Document Title");
        spark.config().setReportName("Test Automation");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setTimelineEnabled(true);
        report = new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("Device_Name", "Windows");
        report.setSystemInfo("Tester_Name", "Rubal Ahmed");
        report.setSystemInfo("Environment", "Qa Automation");

    }

    public static void flushReport(){

        report.flush();



    }
}
