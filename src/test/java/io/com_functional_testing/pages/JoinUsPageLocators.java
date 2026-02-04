package io.com_functional_testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinUsPageLocators {
    @FindBy(xpath = "//h1[text()='Join Us']")
    public WebElement joinUsHeader;

    @FindBy(xpath = "(//input[@type='submit'] )[1]")
    public WebElement buyLink;
}
