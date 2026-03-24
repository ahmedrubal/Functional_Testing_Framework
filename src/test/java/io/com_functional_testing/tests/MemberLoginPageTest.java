package io.com_functional_testing.tests;

import io.com_functional_testing.base.TestBase;
import io.com_functional_testing.utils.Logs;
import io.com_functional_testing.utils.ReadData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class MemberLoginPageTest extends TestBase {

    // Data provider used to supply test data from Excel file
    @DataProvider(name="data")
    public Object[][] getData(){
        String filePath="./data/data.xlsx";
        String sheetName="data";
        return ReadData.getExcelData(filePath,sheetName);
    }

    //Here i make two groups and run them from xml file
    // Must have to include group in TestBase class otherwise test will not run
    @Test(priority = 0,groups = "Sanity", dataProvider = "data")
    void provideUserInfo(String userName ,String passWord) {
        memberLoginPage.provideUserInfo(userName, passWord);

        Logs.logInfo("user name is --"+ userName+ "  Password is --"+passWord);

    }
    @Test(priority = 1, groups = "Sanity")
    void verifyHomeHeader() throws IOException {
        memberLoginPage.verifyHomeHeader();
    }
    @Test(priority = 2,groups = "Sanity")
    void joinUsLink(){
        memberLoginPage.clickOnJoinUsLink();

    }
    @Test(priority = 3,groups = "Regression")
    void joinUsPageVerify(){
        joinUsPage.joinUsHeaderVerify();

    }

}
