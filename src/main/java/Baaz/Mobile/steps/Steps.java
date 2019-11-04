package Baaz.Mobile.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import Baaz.Mobile.common.Helper;
import Baaz.Mobile.common.StateHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class Steps {/*
	public static AppiumDriver<MobileElement> driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();
	public static String elementText = "";
	protected String platform = System.getProperty("platform").toString();
	String device = System.getProperty("device").toString();

	@Given("Open Baaz App")
	public void test() throws InterruptedException, MalformedURLException {
		openApp();
	}

	@When("I want to tap on storyView")
	@Then("I want to tap on storyView")
	public void tapOnXY() {
		Dimension dim = driver.manage().window().getSize();
		int width = dim.getWidth() / 2;
		int height = (int) (dim.getHeight() * 0.3);
		new TouchAction(driver).tap(width, height).perform();

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

	@Given("I want $user1 to get notifications from $user2")
	@When("I want $user1 to get notifications from $user2")
	@Then("I want $user1 to get notifications from $user2")
	public void user1SubscribeToUser2(String user1, String user2) throws MalformedURLException, IOException {
		String user1Token = StateHelper.getStepState(user1).toString();
		String user2Token = StateHelper.getStepState(user2).toString();
		String user2ID = Helper.getUserID(user2Token);
		Helper.subscribe(user1Token, user2ID);
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
	
	
	@Given("I want to send follow request from $user1 to $user2")
	@When("I want to send follow request from $user1 to $user2")
	@Then("I want to send follow request from $user1 to $user2")
	public void sendFollowRequest(String user1, String user2) throws MalformedURLException, IOException {
		String user1Token = StateHelper.getStepState(user1).toString();
		String user2Token = StateHelper.getStepState(user2).toString();
		String user2ID = Helper.getUserID(user2Token);
		Helper.followUser(user1Token, user2ID);
	}
	
	

	@When("I want to check if $locator not visible")
	@Then("I want to check if $locator not visible")
	public void visible(String locator) {
		MobileElement element = getMobileElement(locator);
		assertTrue(element.getAttribute("visible").equals("false"));
	}

	@Given("I want to create news topic from $userNum")
	@When("I want to create news topic from $userNum")
	public void createTopic(String userNum) throws MalformedURLException, IOException, InterruptedException {
		Helper.createUser(1);
		String userToken = StateHelper.getStepState(userNum).toString();
		Helper.publishStory(userToken);
		openApp();
	}

	@When("I want to click on $locator")
	@Then("I want to click on $locator")
	public void clickOnElement(String locator) throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(driver, 3);
		MobileElement element = getMobileElement(locator);
		element.click();
		Thread.sleep(2000);

	}

	@When("I want to create $numOfPosts post(s) from $user")
	@Then("I want to create $numOfPosts post(s) from $user")
	public void createPost(int numOfPosts, String user) throws MalformedURLException, IOException {
		String userToken = StateHelper.getStepState(user).toString();
		Helper.createPost(numOfPosts, userToken);
	}

	
	@When("let $user create a post in a story")
	@Then("let $user create a post in a story")
	public void createPostInAStory(String user) throws MalformedURLException, IOException {
		String userToken = StateHelper.getStepState(user).toString();
		//String storyId = Helper.createTopic(userToken);
		String storyId = Helper.createAndPublishStory(userToken);
		Helper.createPostInStory(storyId, userToken);
		
	}
	

	@When("I want to create $numOfPosts post(s) using $user and let the privacy of the post be $privacy")
	@Then("I want to create $numOfPosts post(s) using $user and let the privacy of the post be $privacy")
	public void createPost(int numOfPosts, String user, String privacy) throws MalformedURLException, IOException {
		String userToken = StateHelper.getStepState(user).toString();
		Helper.createPost(numOfPosts, userToken, privacy);
	}
	@Alias("I want to tap on trending coach mark")
	@When("I want to tap on baazlineCoachMark")
	@Then("I want to tap on baazlineCoachMark")
	public void tapOnCoachMark() throws InterruptedException {

		Dimension dim = driver.manage().window().getSize();
		int width = dim.getWidth() / 2;
		int height = (int) (dim.getHeight() * 0.3);
		new TouchAction(driver).tap(width, height).perform();
		Thread.sleep(2000);

	}

	@When("I want to tap on facebook avatar")
	@Then("I want to tap on facebook avatar")
	public void tabOnFacebookAvatar() throws InterruptedException {
		Dimension dim = driver.manage().window().getSize();
		int width = (int) (dim.getWidth() * .82);
		int height = (int) (dim.getHeight() * .93);
		new TouchAction(driver).tap(width, height).perform();
		Thread.sleep(1000);

	}

	@When("I want to tap on twitter avatar")
	@Then("I want to tap on twitter avatar")
	public void tabOnTwitterAvatar() throws InterruptedException {
		Dimension dim = driver.manage().window().getSize();
		int width = (int) (dim.getWidth() * .94);
		int height = (int) (dim.getHeight() * .93);
		new TouchAction(driver).tap(width, height).perform();
		Thread.sleep(1000);

	}

	@When("Allow Permission Popup if exist")
	@Then("Allow Permission Popup if exist")
	@Given("Allow Permission Popup if exist")
	public void allowPermission() throws InterruptedException {
		Thread.sleep(3000);
		String locator = null;
		locator = this.getLocator("allowPermession");
		if (driver.findElementsById(locator).size() != 0) {
			driver.findElementById(locator).click();
		} else if (driver.findElementsByAccessibilityId(locator).size() != 0) {
			driver.findElementByAccessibilityId(locator).click();
		} else if (driver.findElementsByXPath(locator).size() != 0) {
			driver.findElementByXPath(locator).click();
		}
		Thread.sleep(3000);

	}

	@When("wait for $num second(s)")
	@Then("wait for $num second(s)")
	public void waitFor(int numOfSeconds) throws InterruptedException {
		Thread.sleep(numOfSeconds * 1000);
	}

	@When("I want to mention $value")
	@Then("I want to mention $value")
	public void mentionUser(String value) throws InterruptedException {
		value = "@" + StateHelper.getStepState(value).toString();
		MobileElement element = getMobileElement("postTextField");
		element.sendKeys(value);
		Thread.sleep(2000);

	}

	@Then("I want to fill $locator with $value")
	@When("I want to fill $locator with $value")
	public void fillText(String locator, String value) throws InterruptedException, IOException {
		if (value.contains("random")) {
			value = "baazmobile" + System.currentTimeMillis() + "@gmail.com";
		}
		if (value.contains("user")) {
			value = StateHelper.getStepState(value).toString();
		}
		if (value.equals("generatedUser")) {
			value = "baazmobile" + System.currentTimeMillis();
		}
		if (value.equals("RandomPost")) {
			value = "Baaz Post " + System.currentTimeMillis();
			StateHelper.setStepState("RandomPost", value);

		}
		if (value.equals("Edited Email")) {

			value = StateHelper.getStepState("EditedEmail").toString();

		}

		if (value.equals("phone number")) {
			value = getPhoneNumber();
		}
		if (value.equals("verification code")) {
			value = getConfirmationNumber();
		}
		MobileElement element = getMobileElement(locator);
		element.clear();
		element.sendKeys(value);
		Thread.sleep(2000);
	}

	@Then("I want to type $value with $locator")
	@When("I want to type $value with $locator")
	public void typeText(String locator, String value) throws InterruptedException, IOException {
		// locator = getLocator(locator);
		if (value.contains("random")) {
			value = "baazmobile" + System.currentTimeMillis() + "@gmail.com";
		}
		if (value.contains("user")) {
			value = StateHelper.getStepState(value).toString();
		}
		if (value.equals("generatedUser")) {
			value = "baazmobile" + System.currentTimeMillis();
		}
		if (value.equals("RandomPost")) {
			value = "Baaz Post " + System.currentTimeMillis();
			StateHelper.setStepState("RandomPost", value);

		}

		if (value.equals("phone number")) {
			value = getPhoneNumber();
		}
		if (value.equals("verification code")) {
			value = getConfirmationNumber();
		}
		MobileElement element = getMobileElement(locator);
		element.sendKeys(value);

	}

	@Then("I want to close App")
	public void closeApp() {
		driver.removeApp("com.baaz.baazapp");
	}

	@Given("I want to create $numOfUseres users")
	@When("I want to create $numOfUseres users")
	public void createUsers(int numOfUseres) throws MalformedURLException, IOException, InterruptedException {
		Helper.createUser(numOfUseres);
		openApp();

	}

	@When("I want to check if $locator is exist")
	@Then("I want to check if $locator is exist")
	public void checkIfElementExist(String locator) {
		MobileElement element = getMobileElement(locator);
		Assert.assertTrue(element.isDisplayed());

	}

	@When("I want to check if $locator not exist")
	@Then("I want to check if $locator not exist")
	public void checkIfElementNotExist(String locator) {
		locator = getLocator(locator);

		Assert.assertTrue(
				driver.findElementsById(locator).size() == 0 && driver.findElementsByXPath(locator).size() == 0
						&& driver.findElementsByAccessibilityId(locator).size() == 0);
	}

	@When("I want to check if $locator equal $value")
	@Then("I want to check if $locator equal $value")
	public void checkElementContent(String locator, String value) {
		// locator = getLocator(locator);
		if (value.contains("user")) {
			value = StateHelper.getStepState(value).toString();
		}
		if (value.equals("RandomPost")) {
			value = StateHelper.getStepState("RandomPost").toString();

		}
		MobileElement element = getMobileElement(locator);
		Assert.assertEquals(value, element.getText());

	}

	@When("check if $locator not equal $value")
	@Then("check if $locator not equal $value")
	public void checkElementNotEqual(String locator, String value) {
		if (value.contains("user")) {
			value = StateHelper.getStepState(value).toString();
		}
		if (value.equals("RandomPost")) {
			value = StateHelper.getStepState("RandomPost").toString();

		}

		MobileElement element = getMobileElement(locator);
		Assert.assertNotEquals(value, element.getText());

	}

	@When("I want to check if $locator contains $value")
	@Then("I want to check if $locator contains $value")
	public void checkElementContains(String locator, String value) {
		if (value.contains("user")) {
			value = StateHelper.getStepState(value).toString();
		}
		if (value.equals("randomPost")) {
			value = StateHelper.getStepState("RandomPost").toString();

		}
		MobileElement element = getMobileElement(locator);
		Assert.assertTrue(element.getText().contains(value));

	}

	@When("I want to check that $locator doesn't contain $value")
	@Then("I want to check that $locator doesn't contain $value")
	public void checkElementNotContains(String locator, String value) {
		if (value.contains("user")) {
			value = StateHelper.getStepState(value).toString();
		}
		if (value.equals("randomPost")) {
			value = StateHelper.getStepState("RandomPost").toString();

		}
		MobileElement element = getMobileElement(locator);
		Assert.assertTrue(!element.getText().contains(value));

	}

	public void openApp() throws MalformedURLException, InterruptedException {
		Properties properties = new Properties();
		try {
			File file = new File(
					System.getProperty("user.dir") + "/Devices/" + platform + "/" + device + ".properties");
			FileInputStream fileInput = new FileInputStream(file);
			properties.load(fileInput);
			fileInput.close();
			Enumeration<?> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				capabilities.setCapability(key, value);

				System.out.println(key + ": " + value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (platform.equals("Android")) {
			capabilities.setCapability("app", System.getProperty("user.dir") + "/Builds/Baaz.apk");
		} else {
			capabilities.setCapability("app", System.getProperty("user.dir") + "/Builds/Baaz.app");
		}

		driver = new AppiumDriver<MobileElement>(new URL(properties.getProperty("url")), capabilities);
		Thread.sleep(7000);
	}

	@Then("I want to press and hold on $locator")
	@When("I want to press and hold on $locator")
	public void pressAndHold(String locator) {
		TouchAction touchAction = new TouchAction(driver);
		Duration duration = Duration.ofSeconds(3);
		MobileElement element = getMobileElement(locator);
		touchAction.longPress(element, duration).release().perform();
	}

	public String getLocator(String locator) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(
					System.getProperty("user.dir") + "/Locators/" + platform + "/locators.properties");
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(locator);

	}

	public String getPhoneNumber() throws IOException {
		String firstNumber = Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/MobileNumber.txt")).get(0);
		return firstNumber;
	}

	public String getConfirmationNumber() throws IOException {
		String line = null;
		URL oracle = new URL("https://smsreceivefree.com/info/" + getPhoneNumber().replace("+", "") + "/");
		URLConnection yc = oracle.openConnection();
		yc.setRequestProperty("User-Agent", "Mozilla/5.0");
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			line = inputLine + line;
		in.close();
		int start = line.lastIndexOf("registration:");

		System.out.println(line.substring(start + 14, start + 20));
		return line.substring(start + 14, start + 20);
	}

	@When("I want pull to refresh")
	@Then("I want pull to refresh")
	public void pullToRefresh() throws InterruptedException {
		Thread.sleep(3000);
		Dimension dim = driver.manage().window().getSize();
		int width = dim.getWidth() / 2;
		int startY = (int) (dim.getHeight() * 0.55);
		int endY = (int) (dim.getHeight() * 0.9);
		new TouchAction(driver).press(width, startY).waitAction(Duration.ofMillis(1000)).moveTo(width, endY).release()
				.perform();
		Thread.sleep(3000);
	}

	@When("I want to archive message")
	@Then("I want to archive message")
	public void archiveMessage() {
		Dimension dim = driver.manage().window().getSize();
		int startX = (int) (dim.getWidth() * 0.9);
		int startY = (int) (dim.getHeight() * 0.15);
		int endX = (int) (dim.getWidth() * 0.11);
		new TouchAction(driver).press(startX, startY).waitAction(Duration.ofMillis(1000)).moveTo(endX, startY).release()
				.perform();

	}

	@When("I want to unarchive message")
	@Then("I want to unarchive message")
	public void unarchiveMessage() throws InterruptedException {
		Dimension dim = driver.manage().window().getSize();
		int startX = (int) (dim.getWidth() * 0.9);
		int startY = (int) (dim.getHeight() * 0.15);
		int endX = (int) (dim.getWidth() * 0.11);
		new TouchAction(driver).press(startX, startY).waitAction(Duration.ofMillis(1000)).moveTo(endX, startY).release()
				.perform();
		if (platform.equalsIgnoreCase("iOS")) {
			clickOnElement("unarchivedMessages");
		}

	}

	@When("I navigate to profile from settings")
	@Then("I navigate to profile from settings")
	public void navigateToProfileFromSettings() {

		if (platform.equals("Android")) {
			getMobileElement("trendingMenuButton").click();
			getMobileElement("profile").click();

		}

		else {
			getMobileElement("profile").click();
		}

	}

	@When("I navigate to baazline")
	@Then("I navigate to baazline")
	public void navigateToBaazline() throws InterruptedException {
		if (platform.equals("Android")) {
			getMobileElement("menuButton").click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Baazline\")")).click();

		}

		else {
			getMobileElement("baazline").click();
		}
		Thread.sleep(2000);
	}

	@When("I navigate to trending")
	@Then("I navigate to trending")
	public void navigateToTrending() {

		if (platform.equals("Android")) {
			getMobileElement("menuButton").click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Trending\")")).click();
		}

		else {
			getMobileElement("trending").click();

		}

	}

	@When("I navigate to disucssions")
	@Then("I navigate to disucssions")
	public void navigateToDisucssions() throws InterruptedException {

		if (platform.equals("Android")) {
			getMobileElement("menuButton").click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Discussions\")")).click();
		}

		else {
			getMobileElement("discussions").click();

		}

		Thread.sleep(2000);

	}

	@When("I navigate to profile")
	@Then("I navigate to profile")
	public void navigateToProfile() {

		if (platform.equals("Android")) {
			getMobileElement("menuButton").click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Profile\")")).click();

		}

		else {
			getMobileElement("profile").click();

		}

	}

	@When("I navigate to notifications")
	@Then("I navigate to notifications")
	public void navigateToNotifications() {

		if (platform.equals("Android")) {
			getMobileElement("menuButton").click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Notifications\")")).click();
		}

		else {
			getMobileElement("notificatoin").click();
		}

	}

	@When("I navigate to settings")
	@Then("I navigate to settings")
	public void navigateToSettings() {
		if (platform.equals("Android")) {
			getMobileElement("menuButton").click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Settings\")")).click();

		}

		else {
			getMobileElement("profile").click();
			getMobileElement("settings").click();

		}

	}

	@When("I want to logout")
	@Then("I want to logout")
	public void logoutFromSystem() {
		if (platform.equals("Android")) {
			getMobileElement("menuButton").click();
			driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Logout\")")).click();
			getMobileElement("confirmLogout").click();

		}

		else {
			getMobileElement("profile").click();
			getMobileElement("settings").click();
			getMobileElement("logout").click();
			getMobileElement("confirmLogout").click();

		}
	}

	@Then("I want to scroll down")
	@When("I want to scroll down")
	public void scrollDown() {
		Dimension dim = driver.manage().window().getSize();
		int width = dim.getWidth() / 2;
		int startY = (int) (dim.getHeight() * 0.9);
		int endY = (int) (dim.getHeight() * 0.3);
		new TouchAction(driver).press(width, startY).waitAction(Duration.ofMillis(1000)).moveTo(width, endY).release()
				.perform();
	}

	@Then("I want to scroll Up")
	@When("I want to scroll Up")
	public void scrollUp() {
		Dimension dim = driver.manage().window().getSize();
		int width = dim.getWidth() / 2;
		int startY = (int) (dim.getHeight() * 0.9);
		int endY = (int) (dim.getHeight() * 0.5);
		new TouchAction(driver).press(width, startY).waitAction(Duration.ofMillis(1000)).moveTo(width, endY).release()
				.perform();
	}

	@When("I will generate edited email")
	@Then("I will generate edited email")
	public void generateEditedEmail() {
		String value = "editedemail" + System.currentTimeMillis() + "@gmail.com";
		StateHelper.setStepState("EditedEmail", value);

	}

	@Then("I want to check App language changed")
	public void checkLanguageChanged() {
		assertEquals(driver.findElementById("com.baaz.baazapp.staging:id/welcomePostUserNameTV").getText().toString(),
				"Ù�Ø±ÙŠÙ‚ Ø¨Ø§Ø²");
	}

	@Then("I want to check $subject email received")
	public void checkEmail(String subject) throws FileNotFoundException, IOException, MessagingException {
		Properties props = new Properties();

		props.load(new FileInputStream(new File(System.getProperty("user.dir") + "/smtp.properties")));
		Session session = Session.getDefaultInstance(props, null);

		Store store = session.getStore("imaps");
		store.connect("smtp.gmail.com", "baazmobile2017@gmail.com", "Applause1");

		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_WRITE);
		int messageCount = inbox.getMessageCount();
		Message[] messages = inbox.getMessages();
		System.out.println(messages[messageCount - 1].getSubject());
		Assert.assertEquals(subject, messages[messageCount - 1].getSubject());

	}

	public MobileElement getMobileElement(String locator) {
		locator = this.getLocator(locator);
		if (driver.findElementsById(locator).size() != 0) {
			return driver.findElementById(locator);
		} else if (driver.findElementsByAccessibilityId(locator).size() != 0) {
			return driver.findElementByAccessibilityId(locator);
		} else if (driver.findElementsByXPath(locator).size() != 0) {
			return driver.findElementByXPath(locator);
		} else {
			try {
				// do stuff...
				//fail(locator + " Not Exist");
			} catch (Exception e) {
			}
		}
		return null;

	}

	@SuppressWarnings("deprecation")
	@Then("I want to scroll down $numOfScrolls time(s)")
	@When("I want to scroll down $numOfScrolls time(s)")
	public void scrollDown(int numOfScrolls) {
		int count = 1;
		while (count <= numOfScrolls) {
			Dimension dim = driver.manage().window().getSize();
			int width = dim.getWidth() / 2;
			int startY = (int) (dim.getHeight() * 0.7);
			int endY = (int) (dim.getHeight() * 0.5);
			new TouchAction(driver).press(width, startY).waitAction(Duration.ofMillis(1000)).moveTo(width, endY)
					.release().perform();
			count++;
		}

	}

	@SuppressWarnings("deprecation")
	@Then("I want to scroll up $numOfScrolls time(s)")
	@When("I want to scroll up $numOfScrolls time(s)")
	public void scrollUp(int numOfScrolls) {
		int count = 1;
		while (count <= numOfScrolls) {
			Dimension dim = driver.manage().window().getSize();
			int width = dim.getWidth() / 2;
			int startY = (int) (dim.getHeight() * 0.5);
			int endY = (int) (dim.getHeight() * 0.7);
			new TouchAction(driver).press(width, startY).waitAction(Duration.ofMillis(1000)).moveTo(width, endY)
					.release().perform();
			count++;
		}

	}

	@When("I want to login with $userEmail and password is $password")
	@Then("I want to login with $userEmail and password is $password")
	public void loginWithUser(String userEmail, String password) throws InterruptedException, IOException {

		if (userEmail.contains("user")) {
			userEmail = StateHelper.getStepState(userEmail).toString();
		}
		if (userEmail.equals("Edited Email")) {

			userEmail = StateHelper.getStepState("EditedEmail").toString();

		}
		if (platform.equalsIgnoreCase("Android")) {
			tapOnCoachMark();
			tapOnCoachMark();
			tapOnCoachMark();
			clickOnElement("menuButton");
			fillText("loginEmail", userEmail);
			fillText("loginPassword", password);
			clickOnElement("loginToBaaz");
		} else if (platform.equalsIgnoreCase("iOS")) {
			tapOnCoachMark();
			tapOnCoachMark();
			tapOnCoachMark();
			clickOnElement("forYou");
			clickOnElement("openLogin");
			fillText("loginEmail", userEmail);
			fillText("loginPassword", password);
			clickOnElement("loginToBaaz");

		}
	}

	@When("I want to store the value for $locator")
	@Then("I want to store the value for $locator")
	public void storeElementValue(String locator) {
		MobileElement element = getMobileElement(locator);
		elementText = element.getText();

	}

	@When("I want to check that $locator value is equal the stored value above")
	@Then("I want to check that $locator value is equal the stored value above")
	public void checkIfElementIsEqalStoredValue(String locator) {
		MobileElement element = getMobileElement(locator);
		Assert.assertEquals(elementText, element.getText());

	}
	
	@When("I want to share the post using $action")
	@Then("I want to share the post using $action")
	public void sharePost(String action) throws InterruptedException {
		MobileElement element = getMobileElement("baazPostIcon");
		if(element == null){
			clickOnElement("shareTwitterPost");
			clickOnElement(action);
		}else {
			clickOnElement("shareButton");
			clickOnElement(action);
		}			
	}
	
	@When("I want to like the post")
	@Then("I want to like the post")
	public void likePost() throws InterruptedException {
		MobileElement element = getMobileElement("baazPostIcon");
		if(element == null){
			clickOnElement("likeTwitterPost");
		}else {
			clickOnElement("likeButton");
		}			
	}
	
	@When("I want to comment on the post")
	@Then("I want to comment on the post")
	public void commentOnPost() throws InterruptedException {
		MobileElement element = getMobileElement("baazPostIcon");
		if(element == null){
			clickOnElement("replyTwitter");
		}else {
			clickOnElement("commentButton");
		}			
	}

	@When("I want to check that $locator value is not equal the stored value above")
	@Then("I want to check that $locator value is not equal the stored value above")
	public void checkIfElementIsNotEqalStoredValue(String locator) {
		MobileElement element = getMobileElement(locator);
		Assert.assertNotEquals(elementText, element.getText());
	}

	
	@When("I want to scroll to $text")
	@Then("I want to scroll to $text")
	public void scrollToElement(String text) {
		
		if (platform.equals("Android")) {
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text +"\"))"));
	}

		else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        HashMap scrollObject = new HashMap<>();
	        scrollObject.put("predicateString", "value == '" + text + "'");
	        js.executeScript("mobile: scroll", scrollObject);
		}
	}
	
	
	@When("I want to check that the shared post owner contains $text")
	@Then("I want to check that the shared post owner contains $text")
	public void checkSharedPostOwner(String text) {
		
		if (text.contains("user")) {
			text = StateHelper.getStepState(text).toString();
		}
		java.util.List<MobileElement> postOwners = driver.findElements(By.id("com.baaz.baazapp.staging:id/ownerUserNameLayout"));
		Assert.assertTrue(postOwners.get(1).getText().contains(text));
	}
	
	
	
	@When("I want to check that the first comment owner contains $text")
	@Then("I want to check that the first comment owner contains $text")
	public void checkFirstCommentOwner(String text) {
		
		if (text.contains("user")) {
			text = StateHelper.getStepState(text).toString();
		}
		java.util.List<MobileElement> postOwners = driver.findElements(By.id("com.baaz.baazapp.staging:id/ownerUserNameLayout"));
		Assert.assertTrue(postOwners.get(1).getText().contains(text));
	}
	
	@When("click on the three dots for the shared post")
	@Then("click on the three dots for the shared post")
	public void clickOnThreeDotsForSharedPost() {
		
		java.util.List<MobileElement> threeDots = driver.findElements(By.id("com.baaz.baazapp.staging:id/downArrowPopIB"));
		threeDots.get(1).click();
	}
	
	@When("I want to check that the shared post body contains $text")
	@Then("I want to check that the shared post body contains $text")
	public void checkSharedPostBody(String text) {
		
		java.util.List<MobileElement> postBody = driver.findElements(By.id("com.baaz.baazapp.staging:id/postBodyLayout"));
		Assert.assertTrue(postBody.get(1).getText().contains(text));
	}
	
	
	@When("I want to get a Story title from post Label and open the Story")
	@Then("I want to get a Story title from post Label and open the Story")
	public void getStoryTitleAndOpenIt() throws InterruptedException {
		
		MobileElement element = getMobileElement("postOwner");
		String elementText= element.getText();
		int startIndex = elementText.indexOf("story");
		startIndex = elementText.indexOf(" ", startIndex);
		int endIndex = elementText.length();
		String storyTitle = elementText.substring(startIndex, endIndex );
		System.err.println(storyTitle);
		clickOnElement("searchIcon");	
		MobileElement element2 = getMobileElement("searchTextField");
		element2.sendKeys(storyTitle);
		clickOnElement("seeAllResult");		
		clickOnElement("storiesTabSearchResult");
		Thread.sleep(3000);
		clickOnElement("searchStoriesResult");		
	}

*/}
