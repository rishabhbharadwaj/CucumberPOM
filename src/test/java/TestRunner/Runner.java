package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"E:\\Eclipse_IDE\\SeleniumFramework\\CucumberPOM\\src\\test\\resources\\Features"},
		glue = {"StepDefinations","AppHooks"},
		plugin = {"pretty"},
		monochrome = true
		)
public class Runner {

}
