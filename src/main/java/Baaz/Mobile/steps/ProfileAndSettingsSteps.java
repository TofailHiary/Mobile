package Baaz.Mobile.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import Baaz.Mobile.common.Helper;
import Baaz.Mobile.pages.ProfileAndSettingsPage;

public class ProfileAndSettingsSteps {
	ProfileAndSettingsPage profileAndSettings = new ProfileAndSettingsPage();

	@Then("Check all elements on profile page")
	public void checkAllelementsProfile() {
		assertTrue(profileAndSettings.checkUserProfileElements());
	}

	@When("Edit basic information")
	@Then("Edit basic information")
	public void editBasicInformation() throws InterruptedException {
		profileAndSettings.editBasicInfo();
	}

	@When("Check if basic information eidted")
	@Then("Check if basic information eidted")
	public void checkIfBasicInfoEdited() throws InterruptedException {
		assertTrue(profileAndSettings.checkBasicInfo());

	}

	@When("Change app language")
	@Then("Change app language")
	public void changeAppLanguage() throws InterruptedException {
		profileAndSettings.changeAppLanguage();
	}

	@When("Check if App language changed")
	@Then("Check if App language changed")
	public void checkLanguageChanged() {
		assertEquals(
				Helper.driver.findElementById("com.baaz.baazapp.staging:id/welcomePostUserNameTV").getText().toString(),
				"فريق باز");
	}

	@When("Check Help/FAQ")
	@Then("Check Help/FAQ")
	public void checkHelpFAQ() throws InterruptedException {
		assertTrue(profileAndSettings.checkHelpFAQ());
	}

	@Then("Check feedback form")
	@When("Check feedback form")
	public void checkFeedback() throws InterruptedException {
		assertTrue(profileAndSettings.checkFeedback());
	}

	@When("Check contact us form")
	@Then("Check contact us form")
	public void checkContactUs() throws InterruptedException {
		assertTrue(profileAndSettings.checkContactUs());
	}

	@When("Check terms and conditions text")
	@Then("Check terms and conditions text")
	public void checkTermsAndConditions() throws InterruptedException {
		assertTrue(profileAndSettings.checkTermsAndConditions());
	}

	@When("Check negative cases for edit email")
	@Then("Check negative cases for edit email")
	public void editEmailNegativeCases() {
		assertTrue(profileAndSettings.negativeCasesForEditEmail());
	}

	@When("Change email")
	@Then("Change email")
	public void changeEmail() {
		profileAndSettings.editEamil();
	}

	@When("Check if email edited")
	@Then("Check if email edited")
	public void checkIfEmailEdited() {
		assertTrue(profileAndSettings.checkIfEmailEdited());
	}

	@When("Check social settings")
	@Then("Check social settings")
	public void checkSocialSettings() {
		assertTrue(profileAndSettings.checkSocialSettings());
	}

	@When("Check if blocked user list contains $userName")
	@Then("Check if blocked user list contains $userName")
	public void checkBlokcedList(String userName) {
		assertTrue(profileAndSettings.checkBlokcedList(userName));
	}

	@When("Check if user page not available")
	@Then("Check if user page not available")
	public void blockedUserPage() {
		assertTrue(profileAndSettings.blockedUserPage());
	}

	@When("Check if user page available")
	@Then("Check if user page available")
	public void userPageAvailable() {
		assertTrue(profileAndSettings.userPageAvailable());
	}

	@Then("Unblock user")
	@When("Unblock user")
	public void unBlockUser() {
		assertTrue(profileAndSettings.unBolckUser());
	}

	@When("Check negative case for change password")
	@Then("Check negative case for change password")
	public void negativeCaseChangePassword() {
		assertEquals("Your new password must be different than the current one",
				profileAndSettings.negativeCaseChangePasswrod());
	}

	@When("Change user password")
	@Then("Change user password")
	public void cheangePassword() {
		profileAndSettings.changePassword();
	}

	@When("Check if password changed successfully")
	@Then("Check if password changed successfully")
	public void checkIfPasswordChanged() {
		assertTrue(profileAndSettings.checkIfEmailEdited());
	}

	@When("Choose $privacy privacy for all privacy settings")
	@Then("Choose $privacy privacy for all privacy settings")
	public void chhosePrivacy(String privacy) {
		if (privacy.equals("everyone")) {
			profileAndSettings.everyOnePrivacy();
		} else if (privacy.equals("only me")) {
			profileAndSettings.onlyMePrivacy();
		} else if (privacy.equals("my friends")) {
			profileAndSettings.friendsPrivacy();
		} else if (privacy.equals("friends and their friends")) {
			profileAndSettings.friendsAndThierPrivacy();
		}
	}

	@When("Check if data available")
	@Then("Check if data available")
	public void checkIfDataAvailable() {
		assertTrue(profileAndSettings.dataAvailable());
	}

	@When("Check if data not available")
	@Then("Check if data not available")
	public void checkIfDataNotAvailable() {
		assertTrue(profileAndSettings.dataNotAvailable());
	}
}
