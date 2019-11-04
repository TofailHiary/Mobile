package Baaz.Mobile.common;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.XML;
import static org.jbehave.web.selenium.WebDriverHtmlOutput.WEB_DRIVER_HTML;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.failures.PendingStepStrategy;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.jbehave.web.selenium.ContextView;
import org.jbehave.web.selenium.LocalFrameContextView;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumContextOutput;
import org.jbehave.web.selenium.SeleniumStepMonitor;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;

import Baaz.Mobile.util.Report;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

/**
 * Class which provides the link between the JBehave's executor framework
 * (called Embedder) and the textual stories.
 */
@RunWith(JUnitReportingRunner.class)
public class Stories extends JUnitStories {
	String storyName = "001-test";
	String platform = System.getProperty("platform").toString();
	Embedder embedder = null;
	PendingStepStrategy pendingStepStrategy = new FailingUponPendingStep();
	CrossReference crossReference = new CrossReference().withJsonOnly().withPendingStepStrategy(pendingStepStrategy)
			.withOutputAfterEachStory(true).excludingStoriesWithNoExecutedScenarios(true);
	ContextView contextView = new LocalFrameContextView().sized(640, 120).located(250, 30);
	SeleniumContext seleniumContext = new SeleniumContext();
	SeleniumStepMonitor stepMonitor = new SeleniumStepMonitor(contextView, seleniumContext,
			crossReference.getStepMonitor());
	Format[] formats = new Format[] { new SeleniumContextOutput(seleniumContext), CONSOLE, WEB_DRIVER_HTML, XML,
			Report.REPORT };
	StoryReporterBuilder reporterBuilder = null;
	public static String reportName;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();

	@Override
	public Configuration configuration() {

		return new SeleniumConfiguration().useSeleniumContext(seleniumContext)
				.usePendingStepStrategy(pendingStepStrategy).useFailureStrategy(new FailingUponPendingStep())
				.useStoryControls(new StoryControls().doResetStateBeforeScenario(true))
//				 .doDryRun(true)
				// .useStepMonitor(stepMonitor).useStoryLoader(new
				// LoadFromClasspath(Stories.class))
				.useStoryReporterBuilder(reporterBuilder);
	}

	@Override
	public InjectableStepsFactory stepsFactory() {

		ApplicationContext context = new SpringApplicationContextFactory("Baaz-steps.xml").createApplicationContext();
		return new SpringStepsFactory(configuration(), context);
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
				asList("**/" + System.getProperty("storyFilter", storiesToRun()) + ".story"), null);
	}

	private String storiesToRun() {
		return storyName;
	}

	@Override
	public void run() throws Throwable {
		try {
			getEmbedder().runStoriesAsPaths(storyPaths());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getEmbedder().generateCrossReference();
		}
	}

	private Embedder getEmbedder() {
		if (embedder == null) {
			embedder = configuredEmbedder();
			embedder.embedderControls().doFailOnStoryTimeout(true);
			embedder.embedderControls().useStoryTimeoutInSecs(5000);
			embedder.embedderControls().useThreads(1);

			if (platform.equalsIgnoreCase("ios")) {
				embedder.useMetaFilters(asList("-android", "-skip"));
			} else if (platform.equalsIgnoreCase("android")) {
				embedder.useMetaFilters(asList("-iOS", "-skip"));

			}
		}

		return embedder;
	}

	public Stories() {
		reportName = "Baaz-Automation-Report" + System.currentTimeMillis() + ".html";
		Report.getInstance().setReportHeader("Baaz Mobile (" + platform + ")");
		Report.getInstance().setReportFileName(reportName);

		Report.getInstance().setReportPath(System.getProperty("user.dir") + File.separator + "Baaz_Reports"
				+ File.separator + platform + File.separator);

		reporterBuilder = new StoryReporterBuilder().withFailureTrace(true).withFailureTraceCompression(true)
				.withDefaultFormats().withFormats(formats).withCrossReference(crossReference);

		JUnitReportingRunner.recommendedControls(getEmbedder());
	}
}