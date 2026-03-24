package io.com_functional_testing.actions;

import io.com_functional_testing.base.TestBase;
import io.com_functional_testing.pages.JoinUsPageLocators;
import io.com_functional_testing.utils.CommonActions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class JoinUsPage {
    JoinUsPageLocators joinUsPageLocators;
    public JoinUsPage() {
        joinUsPageLocators = new JoinUsPageLocators();
        PageFactory.initElements(TestBase.getDriver(),joinUsPageLocators);
    }

    public void joinUsHeaderVerify(){
        CommonActions.waitForVisibilityOfEle(joinUsPageLocators.joinUsHeader);
        if(CommonActions.textFromEle(joinUsPageLocators.joinUsHeader).equals("Join Us")){
            CommonActions.reportAndLog("Join Us Header is present ");
        }else{
            CommonActions.reportAndLog("Join Us text not visible");
        }

        CommonActions.explicitWait(20);
        joinUsPageLocators.buyLink.click();
        CommonActions.reportAndLog("paypal payment options displayed");
        TestBase.getDriver().navigate().back();





    }
}
