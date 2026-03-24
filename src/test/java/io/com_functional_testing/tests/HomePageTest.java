package io.com_functional_testing.tests;

import io.com_functional_testing.base.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    // Home page test I used test data from class itself. just to test different approach
    @DataProvider(name="homeData")
    public String[][] arrayData(){
        String[][] arrayData=new String[][]{
                {"Rubal","Ahmed"},
              //  {"John","Doe"}

        };
        return arrayData;
    }
    @Test(priority = 1)
    void homeTest(){
        homePage.verifyHome();

    }
    @Test(dataProvider = "homeData",priority = 2)
    void inputTest(String firstName,String lastName){
        homePage.enterInput(firstName,lastName);
    }
    @Test(priority = 3)
    void submitTest(){
        homePage.submit();
    }
    @Test(priority = 4)
    void infoMessageTest(){
        homePage.getMessage();
    }
    @Test(priority = 5)
    void memberLoginLink(){
        homePage.memberLoginPage();
    }

}
