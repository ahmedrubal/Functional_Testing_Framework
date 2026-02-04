package io.com_functional_testing.actions;

import io.com_functional_testing.base.TestBase;
import io.com_functional_testing.pages.MemberLogin;
import io.com_functional_testing.utils.CommonActions;
import io.com_functional_testing.utils.HighlightBorderOfElement;
import io.com_functional_testing.utils.Logs;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class MemberLoginPage {
    // This is memeberLogin locator class variable
    MemberLogin memberLogin;

  // This is memberLoginPage constructor and creating object of memberLogin and using pageFactory to initElements
    // Every time MemberLoginPage is called automatically we can locate elements and perform actions
    public MemberLoginPage() {
        memberLogin = new MemberLogin();
        PageFactory.initElements(TestBase.getDriver(), memberLogin);
    }

    public void verifyHomeHeader() throws IOException {

        CommonActions.waitForVisibilityOfEle(memberLogin.header);
        String result = CommonActions.textFromEle(memberLogin.header);
        CommonActions.reportAndLog("--Home header is verified--" );
        HighlightBorderOfElement.highlightBorder(TestBase.getDriver(),memberLogin.header);
        Assert.assertEquals(result, "Member Login");

        Logs.logInfo("Member Login is verified : ");

    }

    public void provideUserInfo(String name, String pass) {

        CommonActions.waitForVisibilityOfEle(memberLogin.userName);
        memberLogin.userName.sendKeys(name);
        memberLogin.passWord.sendKeys(pass);

    }
    public void clickOnJoinUsLink(){
        CommonActions.waitForVisibilityOfEle(memberLogin.joinUsLink);
        memberLogin.joinUsLink.click();
        CommonActions.reportAndLog("Now we redirect to a new WebPage");
        // Here calling join us page object to because after this we are performing actions on joinUsPage
        TestBase.joinUsPage=TestBase.joinUsPageObject();

    }

}
