package io.com_functional_testing.actions;
import io.com_functional_testing.base.TestBase;
import io.com_functional_testing.pages.HomePageLocators;
import io.com_functional_testing.utils.CommonActions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    public HomePageLocators homePageLocators;

    public HomePage() {
        homePageLocators = new HomePageLocators();
        PageFactory.initElements(TestBase.getDriver(), homePageLocators);
    }

    public void verifyHome() {
        CommonActions.waitForVisibilityOfEle(homePageLocators.homeHeader);
        Assert.assertEquals(CommonActions.textFromEle(homePageLocators.homeHeader), "Home");
        CommonActions.reportAndLog("Home element verified");
    }

    public void enterInput(String firstName, String lastName) {
        CommonActions.explicitWait(10);
        CommonActions.scrollToSpecificElement(homePageLocators.submitButton);
        CommonActions.waitForVisibilityOfEle(homePageLocators.firstName);
        CommonActions.reportAndLog("First name field displayed");
        CommonActions.sendkeysToEle(homePageLocators.firstName, firstName);
        CommonActions.reportAndLog("Entered first name");
        CommonActions.sendkeysToEle(homePageLocators.lastName, lastName);
        CommonActions.reportAndLog("Entered last name");
    }

    public void submit() {
        Actions actions = new Actions(TestBase.getDriver());
        actions.moveToElement(homePageLocators.submitButton);
        CommonActions.explicitWait(20);
        homePageLocators.submitButton.click();
        CommonActions.reportAndLog("element clicked");

    }

    public void getMessage() {
        CommonActions.waitForVisibilityOfEle(homePageLocators.infoMessage);
        Assert.assertEquals(CommonActions.textFromEle(homePageLocators.infoMessage),
                "This field is required.");
        CommonActions.reportAndLog("info message displayed");

    }

    public void memberLoginPage() {
        CommonActions.navigateToUrl("https://nktechsolutions.com/membership-login/");
        CommonActions.reportAndLog("member login page launch");
        TestBase.memberLoginPage = TestBase.memberLoginPageObject();
    }


}
