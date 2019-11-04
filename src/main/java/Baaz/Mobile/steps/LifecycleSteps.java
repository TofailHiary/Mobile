package Baaz.Mobile.steps;

import java.io.IOException;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.ScenarioType;
import org.openqa.selenium.WebDriverException;

import Baaz.Mobile.common.StateHelper;
import Baaz.Mobile.util.Report;

public class LifecycleSteps{
	@BeforeStories
	public void runBeforeAllStories() {

		try {

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	@BeforeStory
	public void runBeforeEachStory() {

		try {
			// do something
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	@BeforeScenario
	public void runBeforeEachScenario() {

	}

	@AfterStory
	public void runAfterEachStory() {
		StateHelper.clearStepState();

	}

	@AfterStories
	public void runAfterStories() throws IOException {
		 Report.openReport();

	}

	@AfterScenario
	public void runAfterEachScenario() throws InterruptedException {

	}

	@BeforeScenario(uponType = ScenarioType.ANY)
	public void beforeEachExampleScenario() {

	}
	
	
}
