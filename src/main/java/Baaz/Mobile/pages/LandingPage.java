package Baaz.Mobile.pages;

import java.util.Random;

import org.apache.bcel.verifier.exc.AssertionViolatedException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.AssertThrows;

import com.gargoylesoftware.htmlunit.javascript.host.ScreenOrientation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import Baaz.Mobile.common.Helper;
import Baaz.Mobile.common.StateHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class LandingPage extends Helper {

	public void loginWithEmail(String userEmail, String password) throws InterruptedException {
		if (platform.equals("Android")) {

			waitElementToBeVisibile("createPost");
		}
		if (userEmail.contains("user")) {
			userEmail = StateHelper.getStepState(userEmail).toString();
		}
		if (userEmail.equals("Edited Email")) {
			userEmail = StateHelper.getStepState("EditedEmail").toString();
		}
		if (Helper.platform.equalsIgnoreCase("Android")) {
			landingCoachMark();
			landingCoachMark();
			landingCoachMark();
			getMobileElement("menuButton").click();
			Helper.getMobileElement("allowPermession").click();

			getLoginEmail().setValue(userEmail);
			getLoginPassword().setValue(password);
			getLoginToBaaz().click();
			Helper.allowPermission();
			Helper.landingCoachMark();
			Helper.landingCoachMark();

		} else if (Helper.platform.equalsIgnoreCase("iOS")) {

			landingCoachMark();
			landingCoachMark();
			landingCoachMark();
			getMobileElement("forYou").click();

			
			
			
			
			getMobileElement("menuButton").click();

			getMobileElement("loginEmail").setValue(userEmail);
			getMobileElement("loginPassword").setValue(password);
			getMobileElement("loginToBaaz").click();
			waitElementToBeVisibile("allowPermession");
			getMobileElement("allowPermession").click();
			waitElementToBeVisibile("confirmPrivacy");
			getMobileElement("confirmPrivacy").click();
			Thread.sleep(1000);
			landingCoachMark();
			landingCoachMark();
			Thread.sleep(1000);

		}

	}

	public void confirmPrivacy() throws InterruptedException {
		int size = getconfirmPrivacy().getSize().height;

		if (size != 0) {
			getconfirmPrivacy().click();
			Thread.sleep(1000);
			Helper.landingCoachMark();
			Helper.landingCoachMark();
			Thread.sleep(1000);
		} else if (size == 0) {
			// getconfirmPrivacy().click();
			Thread.sleep(1000);
			Helper.landingCoachMark();
			Helper.landingCoachMark();
			Thread.sleep(1000);
		}
	}

	public void disableAutoPlay() {
		getMobileElement("menuButton").click();
		getMobileElement("settingsButton").click();
		getMobileElement("videoSettings").click();
		getMobileElement("autoPlayToggle").click();
		navigateBack();

		TouchAction touchAction = new TouchAction(Helper.driver);
		sleepTime(4);
		touchAction.tap(PointOption.point(80, 155)).perform();

		getMobileElement("baazlineButton").click();
	}

	public void loginWithout(String element) throws InterruptedException {
		tapOnCoachMark();
		tapOnCoachMark();
		tapOnCoachMark();
		clickOnElement("menuButton");
		switch (element) {
		case "noEmail":
			getMobileElement("loginPassword").sendKeys("123456qw");
			break;
		case "noPassword":
			getMobileElement("loginEmail").sendKeys("musab2@test.com");
			break;
		case "invalidEmail":
			getMobileElement("loginEmail").sendKeys("automation@test");
			getMobileElement("loginPassword").sendKeys("123456qw");
			break;
		case "invalidPassword":
			getMobileElement("loginEmail").sendKeys("musab2@test.com");
			getMobileElement("loginPassword").sendKeys("testautomation");
			break;
		case "notExistEmail":
			getMobileElement("loginEmail").sendKeys("musab2@test.com");
			getMobileElement("loginPassword").sendKeys("testautomation");
			break;
		case "wrongPassword":
			getMobileElement("loginEmail").sendKeys("musab2@test.com");
			getMobileElement("loginPassword").sendKeys("testautomation");
			break;

		}
		clickOnElement("loginToBaaz");
	}

	public void loginWithFaceBook(String value) throws InterruptedException {
		tapOnCoachMark();
		tapOnCoachMark();
		tapOnCoachMark();
		clickOnElement("menuButton");
		clickOnElement("loginWithFb");
		sleepTime(4);
		switch (value) {
		case "exist":
			fillTextField("emailFieldFb", "emailAddressFb");
			fillTextField("passwordFieldFb", "passwordFb");
			break;
		case "notExist":
			fillTextField("emailFieldFb", "notExistEmailAddressFb");
			fillTextField("passwordFieldFb", "notExistPasswordFb");
			break;
		}
		clickOnElement("loginBtnFb");
		sleepTime(4);
	}

	public void loginWithTwitter(String value) throws InterruptedException {
		tapOnCoachMark();
		tapOnCoachMark();
		tapOnCoachMark();
		clickOnElement("menuButton");
		clickOnElement("loginWithTwtr");
		sleepTime(4);
		switch (value) {
		case "exist":
			fillTextField("emailFieldTwitter", "userNameTwitter");
			fillTextField("passwordFieldTwitter", "passwordTwitter");
			break;
		case "notExist":
			fillTextField("emailFieldTwitter", "notExistUserNameTwitter");
			fillTextField("passwordFieldTwitter", "notExistPasswordTwitter");
			break;

		}

		clickOnElement("loginBtnTwitter");
		sleepTime(4);
	}

	public void forgotPassword(String value) throws InterruptedException {
		tapOnCoachMark();
		tapOnCoachMark();
		tapOnCoachMark();
		clickOnElement("menuButton");
		clickOnElement("forgotPassword");
		switch (value) {
		case "validEmail":
			fillTextField("emailForForgot", "emailAddressFb");
			break;
		case "validPhoneNum":
			fillTextField("emailForForgot", "validPhoneNumber");
			break;
		case "invalidEmail":
			fillTextField("emailForForgot", "invalidEmailAddress");
			break;
		case "invalidPhoneNum":
			fillTextField("emailForForgot", "invalidPhoneNumber");
			break;
		case "notFoundEmailAddress":
			fillTextField("emailForForgot", "notExistEmailAddress");
			break;
		case "notFoundPhoneNum":
			fillTextField("emailForForgot", "notExistPhoneNumber");
			break;
		}

		clickOnElement("resetPassword");
	}

	public void moveToSignUpScreen() throws InterruptedException {
		tapOnCoachMark();
		tapOnCoachMark();
		tapOnCoachMark();
		sleepTime(2);
		clickOnElement("menuButton");
		clickOnElement("signUp");
	}

	public void signUpWithout(String value) {
		switch (value) {
		case "noFirstName":
			fillTextField("LastNameField", "regTxtLastName");
			fillTextField("regEmailAddress", "regTxtEmailAddress");
			fillTextField("signUpPassword", "regTxtPassword");
			fillTextField("regConfirmPassword", "regTxtConfirmPassword");
			clickOnElement("regDateOfBirth");
			if(platform.equals("Android")) {
			clickOnElement("regDateOfBirthOk");}
			clickOnElement("regChooseGender");
			if(platform.equals("Android")) {
				clickOnElement("regChooseGenderMale");
			}
			else {
				tapOnGender();
			}
			break;
		case "noLastName":
			fillTextField("FirstNameField", "regTxtFirstName");
			fillTextField("regEmailAddress", "regTxtEmailAddress");
			fillTextField("signUpPassword", "regTxtPassword");
			fillTextField("regConfirmPassword", "regTxtConfirmPassword");
			clickOnElement("regDateOfBirth");
			if(platform.equals("Android")) {
			clickOnElement("regDateOfBirthOk");}
			clickOnElement("regChooseGender");
			if(platform.equals("Android")) {
				clickOnElement("regChooseGenderMale");
			}
			else {
				tapOnGender();
			}
			break;
		case "noEmail":
			fillTextField("FirstNameField", "regTxtFirstName");
			fillTextField("LastNameField", "regTxtLastName");
			fillTextField("signUpPassword", "regTxtPassword");
			fillTextField("regConfirmPassword", "regTxtConfirmPassword");
			clickOnElement("regDateOfBirth");
			if(platform.equals("Android")) {
			clickOnElement("regDateOfBirthOk");}
			clickOnElement("regChooseGender");
			if(platform.equals("Android")) {
				clickOnElement("regChooseGenderMale");
			}
			else {
				tapOnGender();
			}
			break;
		case "noPassword":
			fillTextField("FirstNameField", "regTxtFirstName");
			fillTextField("LastNameField", "regTxtLastName");
			fillTextField("regEmailAddress", "regTxtEmailAddress");
			fillTextField("regConfirmPassword", "regTxtConfirmPassword");
			clickOnElement("regDateOfBirth");
			if(platform.equals("Android")) {
			clickOnElement("regDateOfBirthOk");}
			clickOnElement("regChooseGender");
			if(platform.equals("Android")) {
				clickOnElement("regChooseGenderMale");
			}
			else {
				tapOnGender();
			}
			break;
		case "noDateOfBirth":
			fillTextField("FirstNameField", "regTxtFirstName");
			fillTextField("LastNameField", "regTxtLastName");
			fillTextField("regEmailAddress", "regTxtEmailAddress");
			fillTextField("signUpPassword", "regTxtPassword");
			fillTextField("regConfirmPassword", "regTxtConfirmPassword");
			clickOnElement("regChooseGender");
			if(platform.equals("Android")) {
				clickOnElement("regChooseGenderMale");
			}
			else {
				tapOnGender();
			}
			break;
		case "passwordDoesntMatchConfirm":
			fillTextField("FirstNameField", "regTxtFirstName");
			fillTextField("LastNameField", "regTxtLastName");
			fillTextField("regEmailAddress", "regTxtEmailAddress");
			fillTextField("signUpPassword", "regTxtPassword");
			fillTextField("regConfirmPassword", "regTxtConfirmPasswordD");
			clickOnElement("regDateOfBirth");
			if(platform.equals("Android")) {
			clickOnElement("regDateOfBirthOk");}
			clickOnElement("regChooseGender");
			if(platform.equals("Android")) {
				clickOnElement("regChooseGenderMale");
			}
			else {
				tapOnGender();
			}
			break;
		case "invalidEmailAddress":
			fillTextField("FirstNameField", "regTxtFirstName");
			fillTextField("LastNameField", "regTxtLastName");
			fillTextField("regEmailAddress", "invalidEmailAddress");
			fillTextField("signUpPassword", "regTxtPassword");
			fillTextField("regConfirmPassword", "regTxtConfirmPasswordD");
			clickOnElement("regDateOfBirth");
			if(platform.equals("Android")) {
			clickOnElement("regDateOfBirthOk");}
			clickOnElement("regChooseGender");
			if(platform.equals("Android")) {
				clickOnElement("regChooseGenderMale");
			}
			else {
				tapOnGender();
			}
			break;
		case "alreadyExistEmail":
			fillTextField("FirstNameField", "regTxtFirstName");
			fillTextField("LastNameField", "regTxtLastName");
			fillTextField("regEmailAddress", "validEmailAddress");
			fillTextField("signUpPassword", "regTxtPassword");
			fillTextField("regConfirmPassword", "regTxtConfirmPassword");
			clickOnElement("regDateOfBirth");
			if(platform.equals("Android")) {
			clickOnElement("regDateOfBirthOk");}
			clickOnElement("regChooseGender");
			if(platform.equals("Android")) {
				clickOnElement("regChooseGenderMale");
			}
			else {
				tapOnGender();
			}
			break;
		case "alreadyExistPhoneNumber":
			fillTextField("FirstNameField", "regTxtFirstName");
			fillTextField("LastNameField", "regTxtLastName");
			fillTextField("regEmailAddress", "validPhoneNumber");
			fillTextField("signUpPassword", "regTxtPassword");
			fillTextField("regConfirmPassword", "regTxtConfirmPassword");
			clickOnElement("regDateOfBirth");
			if(platform.equals("Android")) {
			clickOnElement("regDateOfBirthOk");}
			clickOnElement("regChooseGender");
			if(platform.equals("Android")) {
				clickOnElement("regChooseGenderMale");
			}
			else {
				tapOnGender();
			}
			break;
		case "invalidPhoneNumber":
			fillTextField("FirstNameField", "regTxtFirstName");
			fillTextField("LastNameField", "regTxtLastName");
			fillTextField("regEmailAddress", "invalidPhoneNumber");
			fillTextField("signUpPassword", "regTxtPassword");
			fillTextField("regConfirmPassword", "regTxtConfirmPassword");
			clickOnElement("regDateOfBirth");
			if(platform.equals("Android")) {
			clickOnElement("regDateOfBirthOk");}
			clickOnElement("regChooseGender");
			if(platform.equals("Android")) {
				clickOnElement("regChooseGenderMale");
			}
			else {
				tapOnGender();
			}
			break;
		case "validEmailAddress":
			fillTextField("FirstNameField", "regTxtFirstName");
			fillTextField("LastNameField", "regTxtLastName");
			getMobileElement("regEmailAddress").sendKeys(generate("email"));
			fillTextField("signUpPassword", "regTxtPassword");
			fillTextField("regConfirmPassword", "regTxtConfirmPassword");
			clickOnElement("regDateOfBirth");
			sleepTime(1);
			if(platform.equals("Android")) {
			clickOnElement("regDateOfBirthOk");}
			clickOnElement("regChooseGender");
			sleepTime(0.5);
			if(platform.equals("Android")) {
				clickOnElement("regChooseGenderMale");
			}
			else {
				tapOnGender();
			}
			break;
		case "validPhoneNumber":
			fillTextField("FirstNameField", "regTxtFirstName");
			fillTextField("LastNameField", "regTxtLastName");
			getMobileElement("regEmailAddress").sendKeys(generate("number"));
			fillTextField("signUpPassword", "regTxtPassword");
			fillTextField("regConfirmPassword", "regTxtConfirmPassword");
			clickOnElement("regDateOfBirth");
			if(platform.equals("Android")) {
			clickOnElement("regDateOfBirthOk");}
			clickOnElement("regChooseGender");
			if(platform.equals("Android")) {
				clickOnElement("regChooseGenderMale");
			}
			else {
				tapOnGender();
			}
			break;
		}
		sleepTime(1);
		clickOnElement("signUpButton");
		if(platform.equals("iOS")) {
		clickOnElement("signUpButton");}
		if (value.equals("alreadyExistEmail") || value.equals("alreadyExistPhoneNumber")
				|| value.equals("validEmailAddress") || value.equals("validPhoneNumber")) {
			sleepTime(2);
		}
	}
	
	public void tapOnGender() {
		TouchAction touchAction = new TouchAction(Helper.driver);
		sleepTime(1);
		touchAction.tap(PointOption.point(192, 729)).perform();
	}

	public void regShowPassword() {
		fillTextField("signUpPassword", "validPassword");
		clickOnElement("showPassword");
	}

	public void signUpSN(String type) throws InterruptedException {
		scrollTo("down", 1);
		switch (type) {
		case "ExistFb":
			clickOnElement("signUpWithFacebook");
			fillTextField("emailFieldFb", "emailAddressFb");
			fillTextField("passwordFieldFb", "passwordFb");
			clickOnElement("loginBtnFb");
			break;
		case "ExistTwitter":
			clickOnElement("signUpWithTwitter");
			fillTextField("emailFieldTwitter", "userNameTwitter");
			fillTextField("passwordFieldTwitter", "passwordTwitter");
			clickOnElement("loginBtnTwitter");
			break;
		}

		sleepTime(4);
	}

	public void signUpArabic() {
		getMobileElement("FirstNameField").sendKeys("مصعب");
		getMobileElement("LastNameField").sendKeys("عبدالهادي");
		getMobileElement("regEmailAddress").sendKeys(generate("email"));
		fillTextField("signUpPassword", "regTxtPassword");
		fillTextField("regConfirmPassword", "regTxtConfirmPassword");
		clickOnElement("regDateOfBirth");
		clickOnElement("regDateOfBirthOk");
		clickOnElement("regChooseGender");
		clickOnElement("regChooseGenderMale");
		clickOnElement("signUpButton");
		sleepTime(2);
	}

	public String generate(String value) {
		String x = null;
		switch (value) {
		case "number":
			x = gen();

			break;
		case "email":
			x = "baazmobile" + System.currentTimeMillis() + "@gmail.com";

			break;
		}
		return x;

	}

	public String gen() {
		Random r = new Random(System.currentTimeMillis());
		return "+9627910" + r.nextInt(20000);
	}

	public static String[] generateRandomWords(int numberOfWords) {
		String[] randomStrings = new String[numberOfWords];
		Random random = new Random();
		for (int i = 0; i < numberOfWords; i++) {
			char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are
															// boring.)
			for (int j = 0; j < word.length; j++) {
				word[j] = (char) ('a' + random.nextInt(26));
			}
			randomStrings[i] = new String(word);
		}
		return randomStrings;
	}

	public void removeSignUpWizardUserName() {
		String Locator = getLocator("userName");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(getLocator("userName"))));
		getMobileElement("userName").clear();
	}

	public void regAddUserNameAlreadyExist(String type) {
		sleepTime(5);
		getMobileElement("userName").clear();
		switch (type) {
		case "alreadyExist":
			fillTextField("userName", "sUWExistUserName");
			break;
		case "new":
			getMobileElement("userName").sendKeys(generateRandomWords(8));
			break;
		}
		clickOnElement("soundsGood");
		sleepTime(2);
	}

	public void regClearUserNameAndRefresh() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(getLocator("userName"))));
		getValue("userName");
		getMobileElement("userName").clear();
		getMobileElement("userName").sendKeys(generateRandomWords(8));
		sleepTime(1);
		getMobileElement("resetUserName").click();
		Assert.assertTrue(getMobileElement("userName").getText().trim().equals(glbalVar));

	}

	public void selectTopics(String num) throws InterruptedException {
		switch (num) {
		case "oneTopic":
			clickOnElement("selectFirstTopic");
			break;
		case "twoTopics":
			clickOnElement("selectFirstTopic");
			clickOnElement("selectSecondTopic");
			break;
		case "threeTopics":
			clickOnElement("selectFirstTopic");
			clickOnElement("selectSecondTopic");
			clickOnElement("selectThirdTopic");
			break;
		case "scrollThenThreeTopics":
			scrollTo("down", 1);
			clickOnElement("selectLastTopic");
			clickOnElement("selectLasterTopic");
			clickOnElement("selectLastesTopic");
			break;
		}
	}

	public void selectLanguageCountry(String type) throws InterruptedException {
		switch (type) {
		case "allLanguages":
			clickOnElement("allLanguages");
			break;
		case "arabic":
			clickOnElement("arabicLanguage");
			break;
		case "allLanguagesWithAfghanistan":
			clickOnElement("allLanguages");
			clickOnElement("afghanistan");
			break;
		case "arabicWithAfghanistan":
			clickOnElement("arabicLanguage");
			clickOnElement("afghanistan");
			break;
		case "arabicWithSearchForCountry":
			fillTextField("searchTextField", "jordan");
			TouchAction touchAction = new TouchAction(Helper.driver);
			sleepTime(4);
			touchAction.tap(PointOption.point(166, 325)).perform();
			clickOnElement("arabicLanguage");
			break;
		case "seachForNotExistCountry":
			fillTextField("searchTextField", "notExistCountry");
			break;
		case "scrollAndSelect":
			scrollTo("down", 3);
			clickOnElement("australia");
			break;
		}
		if (!type.equals("seachForNotExistCountry")) {
			clickOnElement("nextStepTopics");
			sleepTime(2);
		}
	}

	public void clickSearchXButton() {
		fillTextField("searchTextField", "jordan");
		clickOnElement("searchXButton");
	}

	public void connectSN(String type) throws InterruptedException {
		switch (type) {
		case "facebook":
			clickOnElement("connectFacebookold");
			break;
		case "twitter":
			clickOnElement("connectTwitter");
			break;
		case "youtube":
			clickOnElement("connectGoogle");
			break;
		case "otherSN":
			scrollTo("down", 1);
			clickOnElement("ohterSNTab");
			clickOnElement("connectOtherSN");
			break;
		}
		clickOnElement("confirmForward");
		sleepTime(2);
	}

	public void checkOpenCloseSection() {
		clickOnElement("closeSection");
		isElementVisible("bloggingTab");
		clickOnElement("mostPopularTab");
		isElementVisible("connectFacebookold");
	}

	public void addFriendFromSuggestedThenCancel(String type) {

		switch (type) {
		case "add":
			clickOnElement("add_SignupWizard");
			clickOnElement("addFriend_SignupWizard");
			isElementVisible("cancelRequest_SignupWizard");
			clickOnElement("cancelRequest_SignupWizard");
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(getLocator("yesPopUpOption"))));
			clickOnElement("yesPopUpOption");
			waitElementInvisibility("cancelRequest_SignupWizard");
			clickOnElement("skipStep");
			isElementVisible("dismissMessage");
			break;
		case "follow":
			clickOnElement("add_SignupWizard");
			clickOnElement("follow_SignupWizard");
			isElementVisible("following_SignupWizard");
			clickOnElement("following_SignupWizard");
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(getLocator("yesPopUpOption"))));
			clickOnElement("yesPopUpOption");
			waitElementInvisibility("following_SignupWizard");
			clickOnElement("skipStep");
			isElementVisible("dismissMessage");
			break;

		}
	}

	public void typePasswordAndClickOnShow() throws InterruptedException {
		tapOnCoachMark();
		tapOnCoachMark();
		tapOnCoachMark();
		clickOnElement("menuButton");
		fillTextField("loginPassword", "validPassword");
		clickOnElement("showPassword");
	}

	public void tapOnTermsAndConditionLogin() {
		TouchAction touchAction = new TouchAction(Helper.driver);
		sleepTime(4);
		touchAction.tap(PointOption.point(666, 1316)).perform();
	}

	public String loginErrorMessage() {
		return getloginError().getText().toString();
	}

	public void emailOnly() throws InterruptedException {
		getMenuButton().click();
		getLoginEmail().setValue("test");

	}

	public void emailOnlyCheck() {

		getLoginToBaaz().click();
	}

	public void getSignUp() {

		getSignUpPage().click();
	}

	public void getcheckSingupFirstname() {
		String altText = getSignUpPagetextfirstname().getText().toString();
		String actualaltText = "First Name";

		assertEquals(altText, actualaltText);

	}

	public void errorMsg(String field, String errorMessage) {

		if (field.equals("signUpLastName")) {
			String actualMsg = getLastName().getText().toString();
			String expected = errorMessage;
			assertEquals(expected, actualMsg);
		} else if (field.equals("signUpEmail")) {
			String actualMsg = getemailsignUp().getText().toString();
			String expected = errorMessage;
			assertEquals(expected, actualMsg);
		} else if (field.equals("signupErrorMessage")) {
			String actualMsg = getsignupErrorMessage().getText().toString();
			String expected = errorMessage;
			assertEquals(expected, actualMsg);

		} else if (field.equals("loginErrorMessage")) {
			String actualMsg = getloginError().getText().toString();
			String expected = errorMessage;
			assertEquals(expected, actualMsg);
		}
	}

	public void fillfields(String field, String data) {
		if (field.equals("signUpFirstName")) {
			getSignUpPagetextfirstname().sendKeys(data);
		} else if (field.equals("signUpLastName")) {
			getLastName().setValue(data);
		} else if (field.equals("signUpEmail")) {

			if (data.equals("random")) {

				getemailsignUp().setValue("baazmobile" + System.currentTimeMillis() + "@gmail.com");
			} else {
				getemailsignUp().setValue(data);
			}
		} else if (field.equals("signUpPassword")) {
			getFillpassword().setValue(data);
		} else if (field.equals("signUpConfirmPassword")) {
			getFillpasswordconfirm().sendKeys(data);
		} else if (field.equals("forgotPassword")) {
			String any = "test";
			if (data.equals(any)) {
				getForgotPassword(any);
			} else
				;
			{
				getForgotPassword(data);
			}
		} else if (field.equals("loginEmail")) {

			if (data.equals("test")) {
				getLoginEmail().sendKeys("test");

			} else {
				getLoginEmail().sendKeys(data);
			}

		} else if (field.equals("emailForForgot")) {
			getfillEmailForgot().sendKeys(data);
		}

		else if (field.equals("signUpFacebookEmail")) {
			getsignUpFacebookEmail().sendKeys(data);
		} else if (field.equals("signUpFacebookPassword")) {
			getsignUpFacebookPassword().sendKeys(data);
		} else if (field.equals("signUpTwitterEmail")) {
			getloginTwitterEmail().sendKeys(data);

		}
	}

	public MobileElement getElement(String ElementName) {
		return Helper.getMobileElement(ElementName);
	}

	public void getClickableElement(String myElement) throws InterruptedException {
		MobileElement myTempElement = getElement(myElement);
		myTempElement.click();
		Thread.sleep(5000);
	}

	public void getForgotPassword(String username) {
		getlocForgotPassword().click();
		fillEmailForgot(username);
		forgotPasswordbutton();
	}

	public void fillEmailForgot(String username) {
		getfillEmailForgot().sendKeys(username);

	}

	public void forgotPasswordbutton() {
		getresetForgot().click();

	}

	public String ConfirmMsg() {
		return getConfirmMsg().getText().toString();
	}

	public void fillEmail(String userName) {

	}

	public void fillPassword() {
		getFillpassword().sendKeys();

	}

	public void fillPasswordconfirm() {
		getFillpasswordconfirm().sendKeys();

	}

	public void birthday() {
		getBirthday().click();
		getBirthdayok().click();

	}

	public void getGender(String type) throws InterruptedException {
		chooseGender().click();
		Thread.sleep(2000);
		if (type.equals("male")) {

			getMale().click();
		} else if (type.equals("female")) {

			getFemale().click();
		}

	}

	public void NextB() {
		getnextButton().click();

	}

	// Check Sign up Wizard

	public void checkWizard() throws InterruptedException {
		Thread.sleep(2000);
		getuserName().clear();
		getuserName().clear();
		getuserName().sendKeys("test.test");
		getsoundsGoodButton().click();

		assertTrue(getsignupErrorMessage().getText().toString().equals("Username isn't avaliable."));
		getuserName().clear();
		getuserName().sendKeys("test@test.com");
		getsoundsGoodButton().click();
		assertTrue(getsignupErrorMessage().getText().toString()
				.equals("Usernames can be composed only from letters, numbers and '-', '_', '.' symbols"));
		getuserName().clear();
		getuserName().sendKeys("Test" + System.currentTimeMillis());
		getsoundsGoodButton().click();
		getbackButton().click();
		Thread.sleep(5000);
		assertTrue(getsoundsGoodButton().isDisplayed());
		getsoundsGoodButton().click();
		getbusiness().click();
		getskipStepButton().click();
		assertTrue(getsignupErrorMessage().getText().toString()
				.equals("You must select at least three topics to continue"));
		getentertainment().click();
		gethealth().click();
		getskipStepButton().click();
		getbackButton().click();
		getnews().click();
		getskipStepButton().click();
		getarabiclangwizard().click();
		getskipStepButton().click();
		getbackButton().click();
		assertTrue(getarabiclangwizard().isDisplayed());
		getskipStepButton().click();
		getconnectFacebook().click();
		assertTrue(getconnecttext().getText().toString().equals("Connect Facebook account"));
		getcancelb().click();
		getconnecttwitter().click();
		assertTrue(getconnecttext().getText().toString().equals("Connect Twitter account"));
		getcancelb().click();
		getconnectyoutubesign().click();
		assertTrue(getconnecttext().getText().toString().equals("Connect Youtube account"));
		getcancelb().click();
		getskipStepButton().click();
		Helper.allowPermission();
		getskipStepButton().click();
		getsubmitsign().click();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		assertTrue(getsearchIcon().isDisplayed());
		assertTrue(getPlusSN().isDisplayed());
		Helper.scrollTo("down", 4);
		assertTrue(getsuggestfriend().isDisplayed());

	}

	// Mobile Elements

	public MobileElement getMenuButton() {
		return Helper.getMobileElement("menuButton");
	}

	public MobileElement getLoginEmail() {
		return Helper.getMobileElement("loginEmail");
	}

	public MobileElement getLoginPassword() {
		return Helper.getMobileElement("loginPassword");
	}

	public MobileElement getLoginToBaaz() {
		return Helper.getMobileElement("loginToBaaz");
	}

	public MobileElement getForYou() {
		return Helper.getMobileElement("forYou");
	}

	public MobileElement getloginError() {
		return Helper.getMobileElement("errorMessage");

	}

	public MobileElement getSignUpPage() {
		return Helper.getMobileElement("createNewAccount");

	}

	public MobileElement getSignUpPagetextfirstname() {
		return Helper.getMobileElement("FirstNameField");

	}

	public MobileElement getLastName() {
		return Helper.getMobileElement("LastNameField");

	}

	public MobileElement getsignUpButton() {
		return Helper.getMobileElement("signUpButton");

	}

	public MobileElement getlocForgotPassword() {
		return Helper.getMobileElement("forgotpassword");

	}

	public MobileElement getfillEmailForgot() {
		return Helper.getMobileElement("emailForForgot");

	}

	public MobileElement getresetForgot() {
		return Helper.getMobileElement("forgotPasswordbutton");

	}

	public MobileElement getConfirmMsg() {
		return Helper.getMobileElement("confirmMsg");

	}

	public MobileElement getemailsignUp() {
		return Helper.getMobileElement("signUpEmail");

	}

	public MobileElement getFillpassword() {
		return Helper.getMobileElement("signUpPassword");

	}

	public MobileElement getFillpasswordconfirm() {
		return Helper.getMobileElement("signUpPassword2");

	}

	public MobileElement getBirthday() {
		return Helper.getMobileElement("signUpBirthday");

	}

	public MobileElement getBirthdayok() {
		return Helper.getMobileElement("okBirthday");

	}

	public MobileElement getGender() {
		return Helper.getMobileElement("userGender");
	}

	public MobileElement chooseGender() {
		return Helper.getMobileElement("chooseGender");
	}

	public MobileElement getMale() {
		return Helper.getMobileElement("selectmale");

	}

	public MobileElement getFemale() {
		return Helper.getMobileElement("selectFemale");

	}

	public MobileElement getsignupErrorMessage() {
		return Helper.getMobileElement("signupErrorMessage");

	}

	public MobileElement getnextButton() {
		return Helper.getMobileElement("next");

	}

	public MobileElement getsoundsGoodButton() {
		return Helper.getMobileElement("soundsGood");

	}

	public MobileElement getskipStepButton() {
		return Helper.getMobileElement("skipStep");

	}

	public MobileElement getchooseFromLibrary() {
		return Helper.getMobileElement("chooseFromLibrary");

	}

	public MobileElement getavatar() {
		return Helper.getMobileElement("avatar");

	}

	public MobileElement getCountryField() {
		return Helper.getMobileElement("country");

	}

	public MobileElement getsearchCountry() {
		return Helper.getMobileElement("searchCountry");

	}

	public MobileElement getselectCountry() {
		return Helper.getMobileElement("firstCountry");

	}

	public MobileElement getsearchIcon() {
		return Helper.getMobileElement("searchIcon");

	}

	public MobileElement getsubmitsign() {
		return Helper.getMobileElement("submitsign");
	}

	public MobileElement getcameraAlbum() {
		return Helper.getMobileElement("cameraAlbum");
	}

	public MobileElement getJpgAlbum() {
		return Helper.getMobileElement("jpgAlbum");
	}

	public MobileElement getFirstImage() {
		return Helper.getMobileElement("firstImage");
	}

	public MobileElement getUploadImage() {
		return Helper.getMobileElement("uploadImage");
	}

	public MobileElement getcropImage() {
		return Helper.getMobileElement("cropImage");
	}

	public MobileElement getpickimg() {
		return Helper.getMobileElement("pickimg");
	}

	public MobileElement getsignUpWithFacebook() {
		return Helper.getMobileElement("signUpWithFacebook");
	}

	public MobileElement getsignUpFacebookEmail() {
		return Helper.getMobileElement("logface");
	}

	public MobileElement getsignUpFacebookPassword() {
		return Helper.getMobileElement("logfacepass");
	}

	public MobileElement getsignUpTwitterEmail() {
		return Helper.getMobileElement("signUpTwitterEmail");
	}

	public MobileElement getloginToFacebook() {
		return Helper.getMobileElement("loginToFacebook");
	}

	public MobileElement getsignUpWithTwitter() {
		return Helper.getMobileElement("signUpWithTwitter");
	}

	public MobileElement getloginTwitterEmail() {
		return Helper.getMobileElement("signUpTwitterEmail");

	}

	public MobileElement getsignUpTwitterPassword() {
		return Helper.getMobileElement("signUpTwitterPassword");
	}

	public MobileElement getloginToTwitter() {
		return Helper.getMobileElement("loginToTwitter");
	}

	public MobileElement getuserName() {
		return Helper.getMobileElement("userName");
	}

	public MobileElement getbackButton() {
		return Helper.getMobileElement("backButton");
	}

	public MobileElement getbusiness() {
		return Helper.getMobileElement("business");
	}

	public MobileElement getentertainment() {
		return Helper.getMobileElement("entertainment");
	}

	public MobileElement gethealth() {
		return Helper.getMobileElement("health");
	}

	public MobileElement getnews() {
		return Helper.getMobileElement("news");
	}

	public MobileElement getarabiclangwizard() {
		return Helper.getMobileElement("arabiclangwizard");
	}

	public MobileElement getconnectFacebook() {
		return Helper.getMobileElement("connectFacebooksign");
	}

	public MobileElement getconnecttext() {
		return Helper.getMobileElement("connecttext");
	}

	public MobileElement getconnecttwitter() {
		return Helper.getMobileElement("connecttwittersign");
	}

	public MobileElement getconnecttwittertext() {
		return Helper.getMobileElement("connecttwittertext");
	}

	public MobileElement getcancelb() {
		return Helper.getMobileElement("cancelb");
	}

	public MobileElement getconnectyoutubesign() {
		return Helper.getMobileElement("connectyoutubesign");
	}

	public MobileElement getPlusSN() {
		return Helper.getMobileElement("profileConnectSN");
	}

	public MobileElement getsuggestfriend() {
		return Helper.getMobileElement("suggestfriend");
	}

	public void openTrending() {
		clickOnElement("menuButton");
		sleepTime(1);
		clickOnElement("trending");
	}

	public MobileElement getconfirmPrivacy() {
		return Helper.getMobileElement("confirmPrivacy");
	}

}
