package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilePage {
    public FilePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void option(String string){
        Driver.getDriver().findElement(By.xpath("(//span[.='"+string+"'])[1]")).click();
    }

    @FindBy(xpath = "(//label[contains (@for, 'select-files')])[1]")
    public WebElement checkboxFromFile;

    @FindBy(xpath = "(//span[@class='innernametext'])[1]")
    public WebElement fileName;

    @FindBy(xpath = "//span[@class='icon icon-more']")
    public WebElement actionIcon;

    public void clickSubModule(String subModuleName){

        BrowserUtils.sleep(7);
           WebElement module= Driver.getDriver().findElement(By.xpath("//a[.='"+subModuleName+"']"));

           JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();
           js.executeScript("arguments[0].click();", module);

    }

}
