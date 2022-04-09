package com.cydeo.runners;

/*
In the class we will be able to pass pre- & post- conditions to
each scenario and each step
 */

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void teardownScenario(Scenario scenario){

        if(scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

       BrowserUtils.sleep(2);
        Driver.closeDriver();

       // System.out.println("===Closing browser using cucumber @After");
       // System.out.println("===Scenario ended/ Take screenshot if failed");
    }



}
