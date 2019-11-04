package Baaz.Mobile.pages;

import Baaz.Mobile.common.Helper;
import Baaz.Mobile.common.StateHelper;
import Baaz.Mobile.steps.BaazlineSteps;
import io.appium.java_client.MobileElement;

public class ProfileAndSettingsPage {
	BaazlineSteps baazlineSteps = new BaazlineSteps();

	public boolean checkUserProfileElements() {
		boolean firstTab = getProfileUserName().isDisplayed() && getUserCountry().isDisplayed()
				&& getPostsTab().isDisplayed() && getAboutTab().isDisplayed() && getMediaTab().isDisplayed()
				&& getFriendsTab().isDisplayed() && getUserCountry().isDisplayed()
				&& getProfileUserName().getText().toString().contains(StateHelper.getStepState("user1name").toString())
				&& getProfileUserName().getText().toString().contains("Last Baaz");
		getAboutTab().click();
		boolean secondTab = getFullName().isDisplayed() && getUserGender().isDisplayed();
		getMediaTab().click();
		boolean thirdTab = getPhotosTab().isDisplayed() && getAlbumsTab().isDisplayed();
		getFriendsTab().click();
		boolean fourthTab = getuserFriendsTab().isDisplayed() && getUserFollowersTab().isDisplayed()
				&& getUserFollowingTab().isDisplayed() && getNoFriends().isDisplayed();
		getUserFollowersTab().click();
		boolean noFollowers = getNoFollowers().isDisplayed();
		getUserFollowingTab().click();
		boolean noFollowing = getNoFollowing().isDisplayed();
		return firstTab && secondTab && thirdTab && fourthTab && noFollowers && noFollowing;

	}

	public void editBasicInfo() throws InterruptedException {
		getBasicInformation().click();
		getEditBasicInfo().click();
		getBasicInfoFirstName().clear();
		getBasicInfoFirstName().sendKeys("Automation");
		getBasicInfoLastName().clear();
		getBasicInfoLastName().sendKeys("Baaz");
		Helper.scrollTo("down", 2);
		getBasicInfoGender().click();
		getBasicInfoFemale().click();
		getBasicInfoRelation().click();
		getSingle().click();
		getBasicInfoCity().sendKeys("Amman");
		getSaveBasicInfo().click();
	}

	public boolean checkBasicInfo() throws InterruptedException {
		boolean firstCheck = getUserNameValue().getText().toString().equals("Automation Baaz")
				&& getUserGenderValue().getText().toString().equals("Female")
				&& getUserCountryValue().getText().toString().equals("Jordan")
				&& getUserCityValue().getText().toString().equals("Amman");
		getBackFromSettings().click();
		baazlineSteps.navigateToProfileFromSettings();
		boolean secondCheck = getProfileUserName().getText().toString().contains("Automation")
				&& getProfileUserName().getText().toString().contains("Baaz");
		getAboutTab().click();
		Helper.scrollTo("down", 2);
		boolean thirdCheck = getAboutUserName().getText().toString().contains("Automation")
				&& getAboutUserName().getText().toString().contains("Baaz")
				&& getAboutGender().getText().toString().equals("Female")
				&& getAboutRelation().getText().toString().equals("Single")
				&& getAboutCity().getText().toString().equals("Amman")
				&& getAboutCountry().getText().toString().equals("Jordan");

		return firstCheck && secondCheck && thirdCheck;

	}

	public void changeAppLanguage() throws InterruptedException {
		getAccountInformation().click();
		getAccountInfoLanguage().click();
		getAccountArabicLanguage().click();
		getRestartApp().click();
		Thread.sleep(7000);
	}

	public boolean checkHelpFAQ() throws InterruptedException {
		getHelpAndSupport().click();
		getHelpFAQ().click();
		Thread.sleep(3000);
		return getAboutBaaz().isDisplayed();
	}

	public boolean checkFeedback() throws InterruptedException {
		getHelpAndSupport().click();
		getFeedback().click();
		Thread.sleep(2000);
		return getPostAnIdea().isDisplayed();
	}

	public boolean checkContactUs() throws InterruptedException {

		getHelpAndSupport().click();
		getContactUs().click();
		Thread.sleep(3000);
		getContactUsTextField().sendKeys("test");
		getNextPage().click();
		Thread.sleep(3000);
		getSupportEmail().sendKeys("test@test.test");
		getContactType().click();
		getReportIssue().click();
		getContactInfo().click();
		getGeneralInfo().click();
		if (Helper.platform.equalsIgnoreCase("Android")) {
			Helper.scrollTo("down", 1);
		}

		getSendToSupport().click();
		return getContactUs().isDisplayed();
	}

	public boolean checkTermsAndConditions() throws InterruptedException {
		getHelpAndSupport().click();
		getPrivacyAndPolicy().click();
		Thread.sleep(3000);
		return getTermsAndConditionText().isDisplayed();
	}

	public boolean negativeCasesForEditEmail() {
		getAccountInformation().click();
		getAccountInfoEmail().click();
		getAccountInfoEmailValue().sendKeys("test");
		getSaveEmail().click();
		boolean firstCheck = getMessageAlert().getText().toString()
				.equals("Please enter a valid email address or correct phone number format");
		getOkAlertButton().click();
		getAccountInfoEmailValue().sendKeys("belal.jarwan@baaz.com");
		getSaveEmail().click();
		getEditEmailPassword().sendKeys("test123456");
		getConfirmEditEmail().click();
		boolean secondCheck = getAccountErrorMessage().getText().toString().equals("Email already exists");
		getSaveEmail().click();
		getEditEmailPassword().sendKeys("test1234567");
		getConfirmEditEmail().click();
		boolean thirdCheck = getAccountErrorMessage().getText().toString().equals("Invalid password");
		return firstCheck && secondCheck && thirdCheck;

	}

	public void editEamil() {
		getAccountInformation().click();
		getAccountInfoEmail().click();
		String value = "editedemail" + System.currentTimeMillis() + "@gmail.com";
		StateHelper.setStepState("EditedEmail", value);
		getAccountInfoEmailValue().clear();
		getAccountInfoEmailValue().sendKeys(value);
		getSaveEmail().click();
		getEditEmailPassword().sendKeys("test123456");
		getConfirmEditEmail().click();
	}

	public boolean checkIfEmailEdited() {
		return getSearchIcon().isDisplayed();
	}

	public boolean checkSocialSettings() {

		boolean firstCheck, secondCheck, thirdCheck;
		getSocialSettings().click();
		getConnectFacebook().click();
		if (Helper.platform.equalsIgnoreCase("Android")) {
			firstCheck = getDialogTitle().getText().toString().equals("Connect Facebook account");
		} else {
			firstCheck = getDialogTitle().getText().toString().equals("Connect Facebook");
		}

		getCancelDialog().click();
		getConnectTwitter().click();
		if (Helper.platform.equalsIgnoreCase("Android")) {
			secondCheck = getDialogTitle().getText().toString().equals("Connect Twitter account");
		} else {
			secondCheck = getDialogTitle().getText().toString().equals("Connect Twitter");
		}
		getCancelDialog().click();
		getConnectGoogle().click();
		if (Helper.platform.equalsIgnoreCase("Android")) {
			thirdCheck = getDialogTitle().getText().toString().equals("Connect Youtube account");
		} else {
			thirdCheck = getDialogTitle().getText().toString().equals("Connect YouTube");
		}
		return firstCheck && secondCheck && thirdCheck;
	}

	public boolean checkBlokcedList(String userName) {
		userName = StateHelper.getStepState(userName).toString();
		getBlockedUsers().click();
		return getBlockedUserName().getText().toString().contains(userName);
	}

	public boolean blockedUserPage() {
		return getNotAvailablePage().isDisplayed();
	}

	public boolean userPageAvailable() {
		return getAddFriend().isDisplayed();
	}

	public boolean unBolckUser() {
		getBlockedUsers().click();
		getUnBlockUser().click();
		getConfirmUnblockUser().click();
		return getNoBlockedUsers().isDisplayed();
	}

	public String negativeCaseChangePasswrod() {
		getAccountInformation().click();
		getAccountInfoPassword().click();
		getCurrentPassword().sendKeys("test123456");
		getNewPassword().sendKeys("test123456");
		getConfirmNewPassword().sendKeys("test123456");
		getSavePassword().click();
		if (Helper.platform.equalsIgnoreCase("Android")) {
			return getAccountErrorMessage().getText().toString();
		}
		return null;
	}

	public void changePassword() {
		getAccountInformation().click();
		getAccountInfoPassword().click();
		getCurrentPassword().sendKeys("test123456");
		getNewPassword().sendKeys("test1234567");
		getConfirmNewPassword().sendKeys("test1234567");
		getSavePassword().click();
	}

	public void everyOnePrivacy() {
		getPrivacySettings().click();
		getWallPrivacy().click();
		getEveryOne().click();
		getBasicInfoPrivacy().click();
		getEveryOne().click();
		getFriendRequestPrivacy().click();
		getEveryOne().click();
		getFriendListPrivacy().click();
		getEveryOne().click();
		getEmailPrivacy().click();
		getEveryOne().click();
		getDateOfBirthPrivacy().click();
		getEveryOne().click();
		getSavePrivacySettings().click();

	}

	public void onlyMePrivacy() {
		getPrivacySettings().click();
		getWallPrivacy().click();
		getOnlyMe().click();
		getBasicInfoPrivacy().click();
		getOnlyMe().click();
		getFriendListPrivacy().click();
		getOnlyMe().click();
		getFriendRequestPrivacy().click();
		getNoOne().click();
		getEmailPrivacy().click();
		getOnlyMe().click();
		getDateOfBirthPrivacy().click();
		getOnlyMe().click();
		getSavePrivacySettings().click();

	}

	public void friendsPrivacy() {
		getPrivacySettings().click();
		getWallPrivacy().click();
		getMyFriends().click();
		getBasicInfoPrivacy().click();
		getMyFriends().click();
		getFriendListPrivacy().click();
		getMyFriends().click();
		getFriendRequestPrivacy().click();
		getEveryOne().click();
		getEmailPrivacy().click();
		getMyFriends().click();
		getDateOfBirthPrivacy().click();
		getMyFriends().click();
		getSavePrivacySettings().click();

	}

	public void friendsAndThierPrivacy() {
		getPrivacySettings().click();
		getWallPrivacy().click();
		getFriendsAndTheirFriends().click();
		getBasicInfoPrivacy().click();
		getFriendsAndTheirFriends().click();
		getFriendRequestPrivacy().click();
		getEveryOne().click();
		getFriendListPrivacy().click();
		getFriendsOfFriends().click();
		getEmailPrivacy().click();
		getFriendsAndTheirFriends().click();
		getDateOfBirthPrivacy().click();
		getFriendsAndTheirFriends().click();
		getSavePrivacySettings().click();

	}

	public boolean dataAvailable() {
		boolean firstCheck = getProfileCreatePost().isDisplayed();
		getAboutTab().click();
		boolean secondCheck = getAboutList().isDisplayed();
		getFriendsTab().click();
		boolean thirdCheck = getFriendList().isDisplayed();
		return firstCheck && secondCheck && thirdCheck;
	}

	public boolean dataNotAvailable() {
		boolean firstCheck = Helper.checkIfElementNotExist("profileCreatePost");
		getAboutTab().click();
		boolean secondCheck = getPrivateSection().isDisplayed();
		getFriendsTab().click();
		boolean thirdCheck = getPrivateSection().isDisplayed();
		return firstCheck && secondCheck && thirdCheck;
	}

	public MobileElement getNoFollowing() {
		return Helper.getMobileElement("noFollowing");

	}

	public MobileElement getNoFollowers() {
		return Helper.getMobileElement("noFollowers");

	}

	public MobileElement getProfileUserName() {
		return Helper.getMobileElement("profileUserName");

	}

	public MobileElement getUserFollowingTab() {
		return Helper.getMobileElement("userFollowingTab");

	}

	public MobileElement getNoFriends() {
		return Helper.getMobileElement("noFriends");

	}

	public MobileElement getUserFollowersTab() {
		return Helper.getMobileElement("userFollowersTab");

	}

	public MobileElement getuserFriendsTab() {
		return Helper.getMobileElement("userFriendsTab");

	}

	public MobileElement getAlbumsTab() {
		return Helper.getMobileElement("albumsTab");

	}

	public MobileElement getPhotosTab() {
		return Helper.getMobileElement("photosTab");

	}

	public MobileElement getUserGender() {
		return Helper.getMobileElement("userGender");

	}

	public MobileElement getFullName() {
		return Helper.getMobileElement("fullName");

	}

	public MobileElement getUserCountry() {
		return Helper.getMobileElement("userCountry");

	}

	public MobileElement getFriendsTab() {
		return Helper.getMobileElement("friendsTab");

	}

	public MobileElement getMediaTab() {
		return Helper.getMobileElement("mediaTab");

	}

	public MobileElement getAboutTab() {
		return Helper.getMobileElement("aboutTab");

	}

	public MobileElement getPostsTab() {
		return Helper.getMobileElement("postsTab");

	}

	public MobileElement getBasicInformation() {
		return Helper.getMobileElement("basicInformation");

	}

	public MobileElement getEditBasicInfo() {
		return Helper.getMobileElement("editBasicInfo");

	}

	public MobileElement getBasicInfoFirstName() {
		return Helper.getMobileElement("basicInfoFirstName");

	}

	public MobileElement getBasicInfoLastName() {
		return Helper.getMobileElement("basicInfoLastName");

	}

	public MobileElement getBasicInfoGender() {
		return Helper.getMobileElement("basicInfoGender");

	}

	public MobileElement getBasicInfoFemale() {
		return Helper.getMobileElement("basicInfoFemale");

	}

	public MobileElement getBasicInfoRelation() {
		return Helper.getMobileElement("basicInfoRelation");

	}

	public MobileElement getSingle() {
		return Helper.getMobileElement("single");

	}

	public MobileElement getBasicInfoCity() {
		return Helper.getMobileElement("basicInfoCity");

	}

	public MobileElement getSaveBasicInfo() {
		return Helper.getMobileElement("saveBasicInfo");

	}

	public MobileElement getUserNameValue() {
		return Helper.getMobileElement("userNameValue");

	}

	public MobileElement getUserGenderValue() {
		return Helper.getMobileElement("userGenderValue");

	}

	public MobileElement getUserCountryValue() {
		return Helper.getMobileElement("userCountryValue");

	}

	public MobileElement getUserCityValue() {
		return Helper.getMobileElement("userCityValue");

	}

	public MobileElement getBackFromSettings() {
		return Helper.getMobileElement("backFromSettings");

	}

	public MobileElement getAboutUserName() {
		return Helper.getMobileElement("aboutUserName");

	}

	public MobileElement getAboutGender() {
		return Helper.getMobileElement("aboutGender");

	}

	public MobileElement getAboutRelation() {
		return Helper.getMobileElement("aboutRelation");

	}

	public MobileElement getAboutCity() {
		return Helper.getMobileElement("aboutCity");

	}

	public MobileElement getAboutCountry() {
		return Helper.getMobileElement("aboutCountry");

	}

	public MobileElement getAccountInformation() {
		return Helper.getMobileElement("accountInformation");

	}

	public MobileElement getAccountInfoLanguage() {
		return Helper.getMobileElement("accountInfoLanguage");

	}

	public MobileElement getAccountArabicLanguage() {
		return Helper.getMobileElement("accountArabicLanguage");

	}

	public MobileElement getRestartApp() {
		return Helper.getMobileElement("restartApp");

	}

	public MobileElement getHelpAndSupport() {
		return Helper.getMobileElement("helpAndSupport");

	}

	public MobileElement getHelpFAQ() {
		return Helper.getMobileElement("helpFAQ");

	}

	public MobileElement getAboutBaaz() {
		return Helper.getMobileElement("aboutBaaz");

	}

	public MobileElement getFeedback() {
		return Helper.getMobileElement("feedback");

	}

	public MobileElement getPostAnIdea() {
		return Helper.getMobileElement("postAnIdea");

	}

	public MobileElement getContactUs() {
		return Helper.getMobileElement("contactUs");

	}

	public MobileElement getContactUsTextField() {
		return Helper.getMobileElement("contactUsTextField");

	}

	public MobileElement getNextPage() {
		return Helper.getMobileElement("nextPage");

	}

	public MobileElement getSupportEmail() {
		return Helper.getMobileElement("supportEmail");

	}

	public MobileElement getContactType() {
		return Helper.getMobileElement("contactType");

	}

	public MobileElement getReportIssue() {
		return Helper.getMobileElement("reportIssue");

	}

	public MobileElement getContactInfo() {
		return Helper.getMobileElement("contactInfo");

	}

	public MobileElement getGeneralInfo() {
		return Helper.getMobileElement("generalInfo");

	}

	public MobileElement getSendToSupport() {
		return Helper.getMobileElement("sendToSupport");

	}

	public MobileElement getPrivacyAndPolicy() {
		return Helper.getMobileElement("privacyAndPolicy");

	}

	public MobileElement getTermsAndConditionText() {
		return Helper.getMobileElement("termsAndConditionText");

	}

	public MobileElement getAccountInfoEmail() {
		return Helper.getMobileElement("accountInfoEmail");

	}

	public MobileElement getAccountInfoEmailValue() {
		return Helper.getMobileElement("accountInfoEmailValue");

	}

	public MobileElement getSaveEmail() {
		return Helper.getMobileElement("saveEmail");

	}

	public MobileElement getMessageAlert() {
		return Helper.getMobileElement("messageAlert");

	}

	public MobileElement getOkAlertButton() {
		return Helper.getMobileElement("okAlertButton");

	}

	public MobileElement getEditEmailPassword() {
		return Helper.getMobileElement("editEmailPassword");

	}

	public MobileElement getConfirmEditEmail() {
		return Helper.getMobileElement("confirmEditEmail");

	}

	public MobileElement getAccountErrorMessage() {
		return Helper.getMobileElement("accountErrorMessage");

	}

	public MobileElement getSearchIcon() {
		return Helper.getMobileElement("searchIcon");

	}

	public MobileElement getCancelDialog() {
		return Helper.getMobileElement("cancelDialog");

	}

	public MobileElement getDialogTitle() {
		return Helper.getMobileElement("dialogTitle");

	}

	public MobileElement getConnectFacebook() {
		return Helper.getMobileElement("connectFacebook");

	}

	public MobileElement getSocialSettings() {
		return Helper.getMobileElement("socialSettings");

	}

	public MobileElement getConnectTwitter() {
		return Helper.getMobileElement("connectTwitter");

	}

	public MobileElement getConnectGoogle() {
		return Helper.getMobileElement("connectGoogle");

	}

	public MobileElement getBlockedUsers() {
		return Helper.getMobileElement("blockedUsers");

	}

	public MobileElement getBlockedUserName() {
		return Helper.getMobileElement("blockedUserName");

	}

	public MobileElement getNotAvailablePage() {
		return Helper.getMobileElement("notAvailablePage");

	}

	public MobileElement getUnBlockUser() {
		return Helper.getMobileElement("unBlockUser");

	}

	public MobileElement getConfirmUnblockUser() {
		return Helper.getMobileElement("confirmUnblockUser");

	}

	public MobileElement getNoBlockedUsers() {
		return Helper.getMobileElement("noBlockedUsers");

	}

	public MobileElement getAddFriend() {
		return Helper.getMobileElement("addFriend");

	}

	public MobileElement getSavePassword() {
		return Helper.getMobileElement("savePassword");

	}

	public MobileElement getConfirmNewPassword() {
		return Helper.getMobileElement("confirmNewPassword");

	}

	public MobileElement getNewPassword() {
		return Helper.getMobileElement("newPassword");

	}

	public MobileElement getCurrentPassword() {
		return Helper.getMobileElement("currentPassword");

	}

	public MobileElement getAccountInfoPassword() {
		return Helper.getMobileElement("accountInfoPassword");

	}

	public MobileElement getPrivacySettings() {
		return Helper.getMobileElement("privacySettings");

	}

	public MobileElement getEveryOne() {
		return Helper.getMobileElement("everyOne");

	}

	public MobileElement getSavePrivacySettings() {
		return Helper.getMobileElement("savePrivacySettings");

	}

	public MobileElement getDateOfBirthPrivacy() {
		return Helper.getMobileElement("dateOfBirthPrivacy");

	}

	public MobileElement getEmailPrivacy() {
		return Helper.getMobileElement("emailPrivacy");

	}

	public MobileElement getFriendListPrivacy() {
		return Helper.getMobileElement("friendListPrivacy");

	}

	public MobileElement getBasicInfoPrivacy() {
		return Helper.getMobileElement("basicInfoPrivacy");

	}

	public MobileElement getWallPrivacy() {
		return Helper.getMobileElement("wallPrivacy");

	}

	public MobileElement getOnlyMe() {
		return Helper.getMobileElement("onlyMe");

	}

	public MobileElement getMyFriends() {
		return Helper.getMobileElement("myFriends");

	}

	public MobileElement getFriendsAndTheirFriends() {
		return Helper.getMobileElement("friendsAndTheirFriends");

	}

	public MobileElement getProfileCreatePost() {
		return Helper.getMobileElement("profileCreatePost");

	}

	public MobileElement getFriendList() {
		return Helper.getMobileElement("friendList");

	}

	public MobileElement getPrivateSection() {
		return Helper.getMobileElement("privateSection");

	}

	public MobileElement getAboutList() {
		return Helper.getMobileElement("aboutList");

	}

	public MobileElement getNoOne() {
		return Helper.getMobileElement("noOne");

	}

	public MobileElement getFriendsOfFriends() {
		return Helper.getMobileElement("friendsOfFriends");

	}

	public MobileElement getFriendRequestPrivacy() {
		return Helper.getMobileElement("friendRequestPrivacy");

	}

}
