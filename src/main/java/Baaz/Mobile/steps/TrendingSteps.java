package Baaz.Mobile.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import Baaz.Mobile.common.Helper;
import Baaz.Mobile.common.StateHelper;
import Baaz.Mobile.pages.TrendingPage;

public class TrendingSteps {
	TrendingPage trendingPage = new TrendingPage();

	@When("Follow story from trending main page")
	@Then("Follow story from trending main page")
	public void followStoryFromMain() {
		trendingPage.followStoryFromMain();
	}
    
	
	@When ("Unfollow story from unfollow icon in trending main page")
	@Then ("Unfollow story from unfollow icon in trending main page")
	public void unfollowStoryFromMainIcon() throws InterruptedException {
		trendingPage.unfollowStoryFromMainIcon();
		Thread.sleep(2000);
		
	}
	@When("Follow story from follow icon in trending main page")
	@Then("Follow story from follow icon in trending main page")
	public void followStoryFromMainIcon() throws InterruptedException {
		trendingPage.followStoryFromMainIcon();
		Thread.sleep(2000);
	}
	
	@Then("Follow Story from Slide view")
	
		public void followStoryFromSlideview() throws InterruptedException {
			trendingPage.followStoryFromSlidView();
			
	}
	
	@Then("Unfollow story from Slide view")
	
	public void unfollowStoryFromSlideview() throws InterruptedException {
		trendingPage.unfollowStoryFromSlidView();
		
}

	
		
	
	
	@When("Unfollow story from trending main page")
	@Then("Unfollow story from trending main page")
	public void unFollowStoryFromMain() {
		trendingPage.unFollowStoryFromMain();
	}

	@When("Follow story from trending detailed page")
	@Then("Follow story from trending detailed page")
	public void followStoryFromDetailed() throws InterruptedException {
		trendingPage.followStoryFromDetailed();
	}

	
	@When("Navigate to story detailed page")
	@Then("Navigate to story detailed page")
	
		public void storyDetailedPage() throws InterruptedException {
			trendingPage.storyDetailedPage();
		}
	
	@When("Unfollow story from trending detailed page")
	@Then("Unfollow story from trending detailed page")
	public void unFollowStoryFromDetailed() throws InterruptedException {
		trendingPage.unFollowStoryFromDetailed();
	}

	@When("Follow story from more icon in trending detailed page")
	@Then("Follow story from more icon in trending detailed page")
	public void followStoryFromMoreIconInDetailed() throws InterruptedException {
		trendingPage.followStoryFromMoreIconInDetailed();
	}

	@When("Unfollow story from more icon in trending detailed page")
	@Then("Unfollow story from more icon in trending detailed page")
	public void unFollowStoryFromMoreIconInDetailed() throws InterruptedException {
		trendingPage.unFollowStoryFromMoreIconInDetailed();
	}

	@When("Check if story followed")
	@Then("Check if story followed")
	public void checkIfStoryFollowed() {
		assertTrue(trendingPage.checkIfStoryFollowed());
	}

	@When("Check if story unfollowed")
	@Then("Check if story unfollowed")
	public void checkIfStoryUnFollowed() throws InterruptedException {
		assertTrue(trendingPage.checkIfStoryUnFollowed());
		Thread.sleep(3000);
	}

	@When("Check trending statistics page")
	@Then("Check trending statistics page")
	public void checkStatisticsPage() {
		assertTrue(trendingPage.checkStatisticsPage());
	}

	@When("Open statistics page from main page")
	@Then("Open statistics page from main page")
	public void openStatisticsFromMainPage() throws InterruptedException {
		trendingPage.openStatisticsFromMainPage();
	}

	@When("Open statistics page from detailed page")
	@Then("Open statistics page from detailed page")
	public void openStatisticsFromDetailedPage() throws InterruptedException {
		trendingPage.openStatisticsFromDetailedPage();
	}

	@When("Open statistics page from three dots in trending detailed page")
	@Then("Open statistics page from three dots in trending detailed page")
	public void openStatisticsFromThreedotsInDetailedPage() throws InterruptedException {
		trendingPage.openStatisticsFromThreedotsInDetailedPage();
	}

	@When("Quick share story to baazline")
	@Then("Quick share story to baazline")
	public void quickShareStory() throws InterruptedException {
		trendingPage.quickShareStory();
	}

	

	@When("Share story to twitter")
	@Then("Share story to twitter")
	public void shareStoryToTwitter() throws InterruptedException {
		trendingPage.shareStoryToTwitter();
	}

	@When("Quick share story to baazline from detailed page")
	@Then("Quick share story to baazline from detailed page")
	public void quickShareFromDetailed() throws InterruptedException {
		trendingPage.quickShareFromDetailed();
	}

	@When("Share story to facebook from detailed page")
	@Then("Share story to facebook from detailed page")
	public void shareStoryToFacebookFromDetailed() throws InterruptedException {
		trendingPage.shareStoryToFacebookFromDetailed();
	}

	@When("Share story to twitter from detailed page")
	@Then("Share story to twitter from detailed page")
	public void shareStoryToTwitterFromDetailed() throws InterruptedException {
		trendingPage.shareStoryToTwitterFromDetailed();
	}

	@When("Check if story shared to baazline")
	@Then("Check if story shared to baazline")
	public void checkIfStorySharedToBaazline() throws InterruptedException {
		assertTrue(trendingPage.checkIfStorySharedToBaazline());

	}

	@Given("I want to create news topic from $userNum")
	@When("I want to create news topic from $userNum")
	public void createTopic(String userNum) throws MalformedURLException, IOException, InterruptedException {
		Helper.createUser(1);
		String userToken = StateHelper.getStepState(userNum).toString();
		Helper.publishStory(userToken);
		Helper.openApp();
	}

	@When("Check if category name in main page equal $category")
	@Then("Check if category name in main page equal $category")
	public void checkCategpryNameInMainPage(String category)
			throws MalformedURLException, IOException, InterruptedException {
		assertEquals(category, trendingPage.getCateopryNameFromMainPage());
	}

	@When("Check if category name in detailed page equal $category")
	@Then("Check if category name in detailed page equal $category")
	public void checkCategpryNameInDetailedPage(String category)
			throws MalformedURLException, IOException, InterruptedException {
		assertEquals(category, trendingPage.getCateopryNameFromDetailedPage());
	}

	@When("Check if category name from more icon in detailed page equal $category")
	@Then("Check if category name from more icon in detailed page equal $category")
	public void checkCateopryNameFromMoreIcon(String category)
			throws MalformedURLException, IOException, InterruptedException {
		assertEquals(category, trendingPage.getCateopryNameFromMoreIcon());
	}

	@Then("Choose $filter trending filter from trend story")
	@When("Choose $filter trending filter from trend story")
	public void trendFilter(String filter) {
		trendingPage.trendFilter(filter);
	}

	@Then("Check if $filter trending filter working fine")
	@When("Check if $filter trending filter working fine")
	public void checkFilter(String filter) {
		assertTrue(trendingPage.checkFilter(filter));
	}

	@When("Check keyword list in story")
	@Then("Check keyword list in story")
	public void checkKeywords() {
		assertTrue(trendingPage.checkKeywords());
	}

}
