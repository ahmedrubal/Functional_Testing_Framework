package io.com_functional_testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {
    @FindBy(xpath = "//h1[text()='Home']")
    public WebElement homeHeader;

    @FindBy(xpath = "//input[@placeholder='First']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last']")
    public WebElement lastName;

    @FindBy(xpath = "//button[text() ='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//label[text()=\"This field is required.\"]")
    public WebElement infoMessage;
    @FindBy(linkText = "Member Login")
    public WebElement memberLoginLink;

}
