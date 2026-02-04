package io.com_functional_testing.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static io.com_functional_testing.base.TestBase.driver;

public class HighlightBorderOfElement {
    public static void highlightBorder(WebDriver driver,WebElement ele){
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='6px solid red'",ele);

    }






}
