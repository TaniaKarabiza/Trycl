package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeletedFilePage {
    public DeletedFilePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> eachDeleted;

    public void locatingAnyDeletedFile(String fileName){

        String locateFile="((//span[.='"+fileName+"'])[1])";
        Assert.assertTrue( Driver.getDriver().findElement(By.xpath(locateFile)).isDisplayed());



    }
}
