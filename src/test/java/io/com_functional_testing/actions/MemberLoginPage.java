package io.com_functional_testing.actions;

import io.com_functional_testing.base.TestBase;
import io.com_functional_testing.pages.MemberLoginPageLocators;
import io.com_functional_testing.utils.CommonActions;
import io.com_functional_testing.utils.Logs;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class MemberLoginPage {
    // This is memeberLogin locator class variable
    MemberLoginPageLocators memberLoginPageLocators;

  // inside  memberLoginPage constructor I created memberLoginLocators object and used pageFactory to locate elements
    //so Every time MemberLoginPage is called automatically we can locate elements and perform actions
    public MemberLoginPage() {
        memberLoginPageLocators = new MemberLoginPageLocators();
        PageFactory.initElements(TestBase.getDriver(), memberLoginPageLocators);
    }

    public void verifyHomeHeader() throws IOException {

        CommonActions.waitForVisibilityOfEle(memberLoginPageLocators.header);
        String result = CommonActions.textFromEle(memberLoginPageLocators.header);
        CommonActions.highlightBorder(TestBase.getDriver(), memberLoginPageLocators.header);
        CommonActions.reportAndLog("--Home header is verified--" );
        Assert.assertEquals(result, "Memb Login");
        Logs.logInfo("Member Login is verified : ");
    }

    public void provideUserInfo(String name, String pass) {

        CommonActions.waitForVisibilityOfEle(memberLoginPageLocators.userName);
        memberLoginPageLocators.userName.sendKeys(name);
        memberLoginPageLocators.passWord.sendKeys(pass);

    }
    public void clickOnJoinUsLink(){
        CommonActions.waitForVisibilityOfEle(memberLoginPageLocators.joinUsLink);
        memberLoginPageLocators.joinUsLink.click();
        CommonActions.reportAndLog("Now we redirect to a new WebPage");
        // Here calling join us page object to because after this we are performing actions on joinUsPage
        TestBase.joinUsPage=TestBase.joinUsPageObject();

    }

}
