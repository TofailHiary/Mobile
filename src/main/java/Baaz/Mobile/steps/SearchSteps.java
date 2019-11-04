package Baaz.Mobile.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import Baaz.Mobile.common.StateHelper;
import Baaz.Mobile.pages.SearchPage;

public class SearchSteps {
	SearchPage searchPage = new SearchPage();

	@When("Search for $userName")
	public void searchForUser(String userName) throws InterruptedException {
		if (userName.contains("user") && userName.contains("name")) {
			userName = StateHelper.getStepState(userName).toString();
		}
		searchPage.searchForUser(userName);
	}

	@When("I want to search for user")
	@Then("I want to search for user")
	public void userNameSearch() {
		assertEquals("Baaz User1512988216344 Last Baaz", searchPage.userNameSearch());
	}
	
	
	@When("search for user and copy profile link")
	@Then("search for user and copy profile link")
	public void searchForUserAndCopyName() {
		searchPage.searchForUserAndCopyName();
	}
	
	@When("User searches for $type")
	@Then("User searches for $type")
	public void searchFor(String type)  {
		searchPage.searchFor(type);
	}
	
	
	@When("User searche for the saved user")
	@Then("User searche for the saved user")
	public void searchforSavedUser() {
		searchPage.searchforSavedUser();
	}
	
	
	@When("check the name in search results and navigate to friend profile page")
	@Then("check the name in search results and navigate to friend profile page")
	public void checkFriendNameExist() {
		searchPage.checkFriendNameExist();
	}

	@When("I want to search for post")
	@Then("I want to search for post")
	public void postSearch() {
		assertEquals("Baaz Post 1514396222869", searchPage.postSearch());
	}

	@When("I want to search for story")
	@Then("I want to search for story")
	public void storySearch() {
		assertEquals("Create Story By Mobile Automation", searchPage.storySearch());
	}

	@When("Check negative search")
	@Then("Check negative search")
	public void negativeSearch() {
		searchPage.negativeSearch();
	}

}
