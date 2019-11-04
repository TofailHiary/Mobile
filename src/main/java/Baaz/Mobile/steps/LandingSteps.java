package Baaz.Mobile.steps;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.test.AssertThrows;

import Baaz.Mobile.common.Helper;
import Baaz.Mobile.common.StateHelper;
import Baaz.Mobile.pages.BaazlinePage;
import Baaz.Mobile.pages.LandingPage;

public class LandingSteps {
	private static final String String = null;
	LandingPage landing = new LandingPage();

	@Given("I want to create $numOfUseres users")
	@When("I want to create $numOfUseres users")
	public void createUsers(int numOfUseres) throws MalformedURLException, IOException, InterruptedException {
		Helper.createUser(numOfUseres);
		Helper.openApp();
	}

	@Given("Open Baaz App")
	@When("Open Baaz App")
	public void openApplication() throws InterruptedException, MalformedURLException {
		Helper.openApp();

	}

	@Given("user taps on coach marks")
	@When("user taps on coach marks")
	public static void tapOnCoachMark() throws InterruptedException {
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
	}

	@Given("user taps on terms and coditions on login")
	@When("user taps on terms and coditions on login")
	public void tapOnTermsAndConditionLogin() {
		landing.tapOnTermsAndConditionLogin();
	}

	@Given("user move to sign up screen")
	@When("user move to sign up screen")
	public void moveToSignUpScreen() throws InterruptedException {
		landing.moveToSignUpScreen();
	}

	@Given("I want to login with $userEmail and password is $password")
	@When("I want to login with $userEmail and password is $password")
	@Then("I want to login with $userEmail and password is $password")
	public void loginWithUser(String userEmail, String password) throws InterruptedException, IOException {
		landing.loginWithEmail(userEmail, password);
	}


	@When("user tries to login with $element")
	@Then("user tries to login with $element")
	public void loginWithout(String element) throws InterruptedException {
		landing.loginWithout(element);
	}

	@When("user tries to signup with $element")
	@Then("user tries to signup with $element")
	public void signUpWithout(String value) {
		landing.signUpWithout(value);
	}

	@When("user register with $type SN")
	@Then("user register with $type SN")
	public void signUpSN(String type) throws InterruptedException {
		landing.signUpSN(type);
	}

	@When("user Register with Arabic name")
	@Then("user Register with Arabic name")
	public void signUpArabic() {
		landing.signUpArabic();
	}

	@When("user Remove user name")
	@Then("user Remove user name")
	public void removeSignUpWizardUserName() {
		landing.removeSignUpWizardUserName();
	}

	@When("user add $type username")
	@Then("user add $type username")
	public void regAddUserNameAlreadyExist(String type) {
		landing.regAddUserNameAlreadyExist(type);
	}
	
	@When("user clear user name and refresh")
	@Then("user clear user name and refresh")
	public void regClearUserNameAndRefresh() {
		landing.regClearUserNameAndRefresh();
	}
	
	@When("user selects $num")
	@Then("user selects $num")
	public void selectTopics(String num) throws InterruptedException {
		landing.selectTopics(num);
	}
	
	@When("user Selects $type from language and country screen")
	@Then("user Selects $type from language and country screen")
	public void selectLanguageCountry(String type) throws InterruptedException {
		landing.selectLanguageCountry(type);
	}
	
	@When("user click on X button")
	@Then("user click on X button")
	public void clickSearchXButton() {
		landing.clickSearchXButton();
	}
	
	@When("user connect $type account")
	@Then("user connect $type account")
	public void connectSN(String type) throws InterruptedException {
		landing.connectSN(type);
	}
	
	@When("user check open and close sections")
	@Then("user check open and close sections")
	public void checkOpenCloseSection() {
		landing.checkOpenCloseSection();
	}
	
	@When("user $type a friend from suggested and cancel request")
	@Then("user $type a friend from suggested and cancel request")
	public void addFriendFromSuggestedThenCancel(String type) {
		landing.addFriendFromSuggestedThenCancel(type);
	}

	@When("user disable autoplay option")
	@Then("user disable autoplay option")
	public void disableAutoPlay() {
		landing.disableAutoPlay();
	}

	@When("I Want to swipe $direction")
	public void swipeandscroll(String direction) throws InterruptedException {

		Helper.scrollTo(direction, 4);
	}

	@Given("I want to send friend request from $user1 to $user2 and accept")
	@When("I want to send friend request from $user1 to $user2 and accept")
	@Then("I want to send friend request from $user1 to $user2 and accept")
	public void user1email(String user1, String user2) throws MalformedURLException, IOException {
		String user1Token = StateHelper.getStepState(user1).toString();
		String user2Token = StateHelper.getStepState(user2).toString();
		String user1ID = Helper.getUserID(user1Token);
		String user2ID = Helper.getUserID(user2Token);
		Helper.sendFriendRequest(user1Token, user2ID);
		Helper.acceptRequest(user2Token, user1ID);
	}

	@Given("I want to send friend request from $user1 to $user2 without accept")
	@When("I want to send friend request from $user1 to $user2 without accept")
	@Then("I want to send friend request from $user1 to $user2 without accept")
	public void sendFriendRequestWithoutAccept(String user1, String user2) throws MalformedURLException, IOException {
		String user1Token = StateHelper.getStepState(user1).toString();
		String user2Token = StateHelper.getStepState(user2).toString();
		String user2ID = Helper.getUserID(user2Token);
		Helper.sendFriendRequest(user1Token, user2ID);
	}

	@Then("I want to check if searchIcon is exist")
	public void searchicon() {
		assertTrue(landing.getsearchIcon().isDisplayed());
	}

	@Then("I want to scroll $direction $time time(s)")
	@When("I want to scroll $direction $time time(s)")
	public void scroll(String direction, int time) throws InterruptedException {
		Thread.sleep(2000);
		Helper.scrollTo(direction, time);
	}

	@When("wait for $number second(s)")
	@Then("wait for $number second(s)")
	public void waitfor(int number) throws InterruptedException {
		number = number * 1000;
		Thread.sleep(number);
	}

	@Then("I want to check Forgotten Password email received")
	public void Confirm() throws InterruptedException {
		landing.ConfirmMsg();
	}

	@When("Put the App in background for $time")
	@Then("Put the App in background for $time")
	public void putAppInBackGround(long time) {
		landing.putAppInBackGround(time);
	}

	@When("I want to check signUpWizard")
	@Then("I want to check signUpWizard")

	public void checkSignupWizard() throws InterruptedException {
		landing.checkWizard();
	}

	public void emailOnlyCheck()

	{
		landing.emailOnlyCheck();
	}

	@Then("I want to check Firstname text")

	public void signUpcheckFirstName() {
		landing.getcheckSingupFirstname();

	}

	@Then("I want to check if $errorType equal $errorMessage")
	public void ChekMsgError(String errorType, String errorMessage) {
		landing.errorMsg(errorType, errorMessage);
	}

	@When("I want to select on signUpGender $type")
	public void gender(String type) throws InterruptedException {
		landing.getGender(type);
	}

	@When("I want to fill $field with $data")

	public void fillFields(String field, String data) {
		landing.fillfields(field, data);
	}

	@When("User opens trendings page")
	@Then("User opens trendings page")
	public void openTrending() {
		landing.openTrending();
	}

	@When("User clicks on $locator")
	@Then("User clicks on $locator")
	public void clickOnElement(String locator) {
		Helper.clickOnElement(locator);
	}

	@When("User fill $locator with $value")
	@Then("User fill $locator with $value")
	public void fillTextField(String locator, String value) {
		landing.fillTextField(locator, value);
	}

	@When("User login with $type facebook")
	@Then("User login with $type facebook")
	public void loginWithFaceBook(String value) throws InterruptedException {
		landing.loginWithFaceBook(value);
	}

	@When("user tries to send a forget password $tpye")
	@Then("user tries to send a forget password $tpye")
	public void forgotPassword(String value) throws InterruptedException {
		landing.forgotPassword(value);
	}

	@When("user type a password and click on show button")
	@Then("user type a password and click on show button")
	public void typePasswordAndClickOnShow() throws InterruptedException {
		landing.typePasswordAndClickOnShow();
	}

	@When("user clicks on show password on registration")
	@Then("user clicks on show password on registration")
	public void regShowPassword() {
		landing.regShowPassword();
	}

	@When("User login with $type Twitter")
	@Then("User login with $type Twitter")
	public void loginWithTwitter(String value) throws InterruptedException {
		landing.loginWithTwitter(value);
	}

	@When("$locator should appear")
	@Then("$locator should appear")
	public void isElementVisible(String locator) {
		landing.isElementVisible(locator);
	}

	@When("$locator should contain $text")
	@Then("$locator should contain $text")
	public void isElementContainstext(String locator, String text) {
		landing.isElementContainstext(locator, text);
	}

	@When("$locator should appear with $text")
	@Then("$locator should appear with $text")
	public void isElementEqualsText(String locator, String text) {
		landing.isElementEqualsText(locator, text);
	}

	@When("check $locaotr doesn't have $text")
	@Then("check $locaotr doesn't have $text")
	public void elementDoesntHaveText(String locator, String text) {
		landing.elementDoesntHaveText(locator, text);
	}

	@When("User waits for $num seconds")
	public void sleepTime(int num) throws InterruptedException {
		Helper.sleepTime(num);
	}

	@When("Pull to refresh")
	public static void pullToRefresh() throws InterruptedException {
		Helper.pullToRefresh();
	}

	@When("$locator should not have friend name")
	@Then("$locator should not have friend name")
	public void checkTextIsNotExist(String locator) {
		landing.checkTextIsNotExist(locator);
	}

	@When("$locator should have friend name")
	@Then("$locator should have friend name")
	public void checkTextExist(String locator) {
		landing.checkTextExist(locator);
	}

	@When("wait $locator to be invisible")
	@Then("wait $locator to be invisible")
	public void waitElementInvisibility(String locator) {
		landing.waitElementInvisibility(locator);
	}

	@When("tap on the centre")
	@Then("tap on the centre")
	public void tapOnTheCentre() {
		landing.tapOnTheCentre();
	}

}
