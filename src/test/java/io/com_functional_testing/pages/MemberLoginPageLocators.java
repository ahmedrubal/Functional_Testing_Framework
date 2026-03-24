package io.com_functional_testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MemberLoginPageLocators {
    @FindBy (xpath = "//input[@type='text']")
   public WebElement userName;

    @FindBy(xpath = "//input[@type='password']")
   public WebElement passWord;

    @FindBy(xpath = "//h1[text()='Member Login']")
    public WebElement header;

    @FindBy(xpath = "//a[text()='Join Us']")
    public WebElement joinUsLink;
}
