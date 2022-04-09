package com.cydeo.runners;

/*
In the class we will be able to pass pre- & post- conditions to
each scenario and each step
 */

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import from io.cucumber.java NOT from junit
    @Before(order = 0)
    public void setupScenario(){
       // System.out.println("===Setting up a browser using cucumber @Before");
    }
    @Before(value="@login", order =1 )
    public void setupScenarioForLogins(){
       // System.out.println("===this will only apply to scenario with @login");
    }
    @Before(value = "@db", order = -1)
    public void setupScenarioForDatabaseScenarios(){
        //System.out.println("===this will only apply to scenario with @db");
    }


    @After
    public void teardownScenario(Scenario scenario){

        if(scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

      //  BrowserUtils.sleep(2);
        Driver.closeDriver();

       // System.out.println("===Closing browser using cucumber @After");
       // System.out.println("===Scenario ended/ Take screenshot if failed");
    }

    @BeforeStep
    public  void setupStep(){

       // System.out.println("----------> Applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep(){
       // System.out.println("----------> Applying tearDown using @AfterStep");
    }


}
