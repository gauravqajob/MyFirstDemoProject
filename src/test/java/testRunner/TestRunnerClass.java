package testRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "D:\\eclipse-workspace\\Cucumber_Selenium\\src\\test\\java\\features",
glue= {"stepDefinition"},
tags= {"@tag3"},
//plugin = { "pretty", "html:target/htmlreports" },
plugin = { "pretty", "io.qameta.allure.cucumberjvm.AllureCucumberJvm" },
//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
monochrome = true
)

public class TestRunnerClass 
{
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));
    
    }
}
