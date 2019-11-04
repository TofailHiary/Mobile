package Baaz.Mobile.steps;

import Baaz.Mobile.common.Helper;
import io.appium.java_client.MobileElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import Baaz.Mobile.common.StateHelper;
import Baaz.Mobile.pages.NotificationsPage;

public class NotificationsSteps {
	NotificationsPage notificationsPage = new NotificationsPage();

	@Then("Check friend request and accept")
	@When("Check friend request and accept")
	public void checkAndAcceptFriendRequest() {
		assertTrue(notificationsPage.checkAndAcceptFriendRequest());
	}

	@Then("Check friend request and decline")
	@When("Check friend request and decline")
	public void checkAndDeclineFriendRequest() {
		assertTrue(notificationsPage.checkAndDeclineFriendRequest());
	}

	@Then("Check friend request list from view all button and check back button")
	@When("Check friend request list from view all button and check back button")
	public void checkFriendListFromViewAll() {
		assertTrue(notificationsPage.checkFriendListFromViewAll());
	}

	@Then("Check when click on avatar will lead user to profile page")
	@When("Check when click on avatar will lead user to profile page")
	public void checkAvatarFunctionality() {
		assertTrue(notificationsPage.checkAvatarFunctionality());
	}

	@Then("Check baazline $action notification")
	@When("Check baazline $action notification")
	public void checkBaazlineNotification(String action) {
		assertTrue(notificationsPage.checkBaazlineNotifications(action));
	}
	@Then("Check discussion $action notification")
	@When("Check discussion $action notification")
	public void checkDiscussionNotification(String action) {
		assertTrue(notificationsPage.checkDiscussionNotification(action));
	}
}
