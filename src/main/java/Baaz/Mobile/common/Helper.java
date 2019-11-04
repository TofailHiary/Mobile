package Baaz.Mobile.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.apache.tools.ant.taskdefs.Retry;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

public class Helper {
	public static String DAY_MONTH_YEAR = "dd/MM/yyyy";
	public static String MONTH_DAY_YEAR = "MM/dd/yyyy";
	public static String YEAR_MONTH_DAY = "yyyy/MM/dd";
	public static String userToken;
	public static String emailAddress;
	public static String lastPost;
	public static WebDriverWait wait;
	public static String suggestedFriendName;
	public static String glbalVar;
	public static AppiumDriver<MobileElement> driver;
	static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static String platform = System.getProperty("platform").toString();
	static String device = System.getProperty("device").toString();

	/**
	 * @param numberOfDays
	 *            get number of days to move after , before or stay in the current
	 *            day from story
	 * @param format
	 *            get the date format from class to set the date type
	 * @return the past,future or stay in current date
	 */
	public static String getDateInThePastOrFuture(int numberOfDays, String format) {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, numberOfDays);
		Date pastOrFeautureDate = cal.getTime();
		String dateInThePastOrFuture = getDateFormat(format).format(pastOrFeautureDate);
		return dateInThePastOrFuture;

	}

	public void getValue(String locator) {

		if (locator.equals("numOfComments")) {
			String y = getMobileElement(locator).getText().trim();
			String[] x = y.split(" ");
			glbalVar = x[0];
		} else {
			glbalVar = getMobileElement(locator).getText().trim();
		}

	}

	public void setValue(String locator) {
		getMobileElement(locator).sendKeys(glbalVar);
	}

	public static DateFormat getDateFormat(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat;

	}

	public static String getToken() throws MalformedURLException, IOException {
		String token = null;
		URL url = new URL("https://pre-www.baaz.com/api/1.2/tokens");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		String input = "{\"grant_type\" : \"client_credentials\", \"client_id\" : \"api\"}";
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			int indexFrom = output.indexOf(":");
			int indexTo = output.indexOf(",");
			token = output.substring(indexFrom + 2, indexTo - 1);
			// System.err.println(output.substring(indexFrom + 2, indexTo - 1));
		}
		conn.disconnect();
		return "bearer " + token;
	}

	public static String createUser(int numOfUsers) throws MalformedURLException, IOException {
		String email = null, firstName = null;
		for (int i = 1; i <= numOfUsers; i++) {
			email = "baazmobile" + System.currentTimeMillis() + "@gmail.com";
			firstName = "Baaz User" + System.currentTimeMillis();

			URL url = new URL("https://pre-www.baaz.com/api/1.2/me");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", getToken());

			String input = "{\"first_name\":" + '"' + firstName + '"' + ",\"last_name\":" + '"' + "Last Baaz" + '"'
					+ ",\"email\":" + '"' + email + '"'
					+ ",\"mobile_number\":\"\",\"sms_confirmation_code\":\"\",\"gender\":\"M\", \"birthday\": \"01-10-1970\", \"country\": \"JO\", \"password\": \"test123456\",\"password_confirmation\":\"test123456\", \"locale\":\"en_EN\", \"terms\": \"true\", \"time_zone\": \"Europe/London\", \"social_credentials_hash\": \"\", \"client_id\": \"api\"}\r\n";
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			String checkRes = null;
			while ((output = br.readLine()) != null) {
				checkRes = output + checkRes;
				int indexFrom = output.indexOf(":");
				int indexTo = output.indexOf(",");
				System.err.println(output);
				userToken = output.substring(indexFrom + 2, indexTo - 1);
			}
			conn.disconnect();

			StateHelper.setStepState("user" + i + "name", firstName);
			StateHelper.setStepState("user" + i + "email", email);
			StateHelper.setStepState("user" + i, "bearer " + userToken);
			System.err.println(email);
			emailAddress = email;

		}

		return email;

	}

	public void createPost(int numOfPosts, String userToken) throws MalformedURLException, IOException {
		for (int i = 0; i < numOfPosts; i++) {

			URL url = new URL("https://pre-www.baaz.com/api/1.2/me/posts");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", userToken);
			String input = "{\"body\":\"Test Post\",\"privacy\":\"4\",\"keywords\":[\"demo\", \"post\"]}";
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			while ((output = br.readLine()) != null) {
				int indexFrom = output.indexOf(":");
				int indexTo = output.indexOf(",");
				output.substring(indexFrom + 2, indexTo - 1);
			}
			conn.disconnect();

		}
	}

	public void createPost(int numOfPosts, String userToken, String Privacy) throws MalformedURLException, IOException {
		String privacyParam;

		switch (Privacy.toLowerCase()) {
		case "everyone":
			privacyParam = "4";
			break;
		case "friends & their friends":
			privacyParam = "3";
			break;
		case "friends":
			privacyParam = "2";
			break;
		case "only me":
			privacyParam = "1";
			break;
		default:
			privacyParam = "4";
		}

		for (int i = 0; i < numOfPosts; i++) {

			URL url = new URL("https://pre-www.baaz.com/api/1.2/me/posts");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", userToken);
			String input = "{\"body\":\"Test Post\",\"privacy\":\"" + privacyParam
					+ "\",\"keywords\":[\"demo\", \"post\"]}";
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			while ((output = br.readLine()) != null) {
				int indexFrom = output.indexOf(":");
				int indexTo = output.indexOf(",");
				output.substring(indexFrom + 2, indexTo - 1);
			}
			conn.disconnect();

		}
	}

	public static String createTopic(String userToken) throws MalformedURLException, IOException {
		String postID = createPostsWithKeywords(userToken);
		URL url = new URL("http://cs001.pre-www.mybaaz.net:30002/posts/" + postID + "/topics?postId=" + postID
				+ "&onlyPublished=false");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output = null;
		String x = null;
		while ((output = br.readLine()) != null) {
			x = x + output;

		}
		int indexFrom = x.indexOf("id");
		String storyID = x.substring(indexFrom + 5, indexFrom + 29);
		conn.disconnect();
		return storyID;
	}

	public static String createPostsWithKeywords(String userToken) throws MalformedURLException, IOException {
		for (int i = 0; i < 30; i++) {

			URL url = new URL("https://pre-www.baaz.com/api/1.2/me/posts");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "barer " + userToken);
			String input = "{\"body\":\"This post is to create a trending story \",\"privacy\":\"4\",\"keywords\":[\"{{lm1}}\", \"{{lm2}}\", \"{{lm3}}\", \"{{lm4}}\", \"{{lm5}}\"]}";
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			while ((output = br.readLine()) != null) {

				int indexFrom = output.indexOf(":");
				int indexTo = output.indexOf(",");
				lastPost = output.substring(indexFrom + 2, indexTo - 1);

			}
			conn.disconnect();

		}

		return lastPost;
	}

	public static void publishStory(String userToken) throws MalformedURLException, IOException {
		String storyID = createTopic(userToken);
		System.err.println(storyID);
		URL url = new URL("http://cs001.pre-www.mybaaz.net:30002/topics/updateAttributes");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		String input = "{\r\n" + "  \"topicId\":\"" + storyID + "\", \r\n"
				+ "  \"name\":\"Create Story By Mobile Automation\", \r\n \"category\":\"News\","
				+ "  \"isPublished\": 1,\r\n"
				+ "  \"keywords\":[\"{{lm1}}\", \"{{lm2}}\", \"{{lm3}}\", \"{{lm4}}\", \"{{lm5}}\", \"{{lm6}}\", \"{{lm7}}\", \"{{lm8}}\"]\r\n"
				+ "}";
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {

			System.err.println(output);

		}
		conn.disconnect();

	}

	public static String createAndPublishStory(String userToken) throws MalformedURLException, IOException {
		String storyID = createTopic(userToken);
		System.err.println(storyID);
		URL url = new URL("http://cs001.pre-www.mybaaz.net:30002/topics/updateAttributes");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		String input = "{\r\n" + "  \"topicId\":\"" + storyID + "\", \r\n"
				+ "  \"name\":\"Create Story By Mobile Automation" + System.currentTimeMillis()
				+ "\", \r\n \"category\":\"News\"," + "  \"isPublished\": 1,\r\n"
				+ "  \"keywords\":[\"{{lm1}}\", \"{{lm2}}\", \"{{lm3}}\", \"{{lm4}}\", \"{{lm5}}\", \"{{lm6}}\", \"{{lm7}}\", \"{{lm8}}\"]\r\n"
				+ "}";
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {

			System.err.println(output);

		}
		conn.disconnect();
		return storyID;
	}

	public static void createPostInStory(String StoryId, String userToken) throws MalformedURLException, IOException {

		URL url = new URL("https://pre-www.baaz.com/api/1.1.0/topics/" + StoryId + "/posts");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", userToken);
		String input = "{\"body\":\"Text In A Story\"}";
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			System.err.println("Test" + output);
		}
		conn.disconnect();

	}

	public static String getUserID(String userToken) throws MalformedURLException, IOException {
		String userID = null;
		URL url = new URL("https://pre-www.baaz.com/api/1.2/me");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", userToken);
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output = null;
		while ((output = br.readLine()) != null) {
			int indexFrom = output.indexOf(":");
			int indexTo = output.indexOf(",");
			userID = output.substring(indexFrom + 2, indexTo - 1);
			System.err.println(output);
		}

		conn.disconnect();
		return userID;

	}

	public static void sendFriendRequest(String user1Token, String user2ID) throws IOException {
		URL url = new URL("https://api.pre-www.mybaaz.net/api/1.1.0/friends/requests/" + user2ID);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", user1Token);
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output = null;
		while ((output = br.readLine()) != null) {
			int indexFrom = output.indexOf(":");
			int indexTo = output.indexOf(",");
			output.substring(indexFrom + 2, indexTo - 1);
			System.err.println(output);
			System.err.println(output.substring(indexFrom + 2, indexTo - 1));
		}

	}

	public static void subscribe(String user1Token, String user2ID) throws IOException {
		URL url = new URL("https://pre-www.baaz.com/api/1.2/subscribers/" + user2ID);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", user1Token);
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output = null;
		while ((output = br.readLine()) != null) {
			int indexFrom = output.indexOf(":");
			int indexTo = output.indexOf(",");
			output.substring(indexFrom + 2, indexTo - 1);
			System.err.println(output);
			System.err.println(output.substring(indexFrom + 2, indexTo - 1));
		}

	}

	public static void followUser(String user1Token, String user2ID) throws IOException {
		URL url = new URL("https://pre-www.baaz.com/api/1.2/following/" + user2ID);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", user1Token);
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output = null;
		while ((output = br.readLine()) != null) {
			int indexFrom = output.indexOf(":");
			int indexTo = output.indexOf(",");
			output.substring(indexFrom + 2, indexTo - 1);
			System.err.println(output);
			System.err.println(output.substring(indexFrom + 2, indexTo - 1));
		}

	}

	public static void acceptRequest(String user2Token, String user1ID) throws IOException {

		URL url = new URL("https://pre-www.baaz.com/api/1.2/friends/requests/" + user1ID);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Authorization", user2Token);
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output = null;
		while ((output = br.readLine()) != null) {
			int indexFrom = output.indexOf(":");
			int indexTo = output.indexOf(",");
			output.substring(indexFrom + 2, indexTo - 1);
			System.err.println(output);
			System.err.println(output.substring(indexFrom + 2, indexTo - 1));
		}

	}

	public static void openApp() throws MalformedURLException, InterruptedException {
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
			capabilities.setCapability("newCommandTimeout", 10000);

		} else {
			capabilities.setCapability("app", System.getProperty("user.dir") + "/Builds/Baaz.app");
			capabilities.setCapability("newCommandTimeout", 10000);
			capabilities.setCapability("simpleIsVisibleCheck", true);
		}

		driver = new AppiumDriver<MobileElement>(new URL(properties.getProperty("url")), capabilities);
		wait = new WebDriverWait(driver, 20);
		sleepTime(10);
	}

	public static void allElements() {
		List<MobileElement> myElements;
		myElements = driver.findElementsByAccessibilityId("*");
		for (int i = 0; i < myElements.size(); i++) {
			System.out.println(myElements.get(i).getTagName());
		}
	}

	public static MobileElement getMobileElement(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		locator = getLocator(locator);
		if (driver.findElementsById(locator).size() != 0) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
			return driver.findElementById(locator);
		} else if (driver.findElementsByAccessibilityId(locator).size() != 0) {
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(locator)));
			return driver.findElementByAccessibilityId(locator);
		} else if (driver.findElementsByXPath(locator).size() != 0) {
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(locator)));
			return driver.findElementByXPath(locator);
		} else {
			try {
				// do stuff...
				// fail(locator + " Not Exist");
			} catch (Exception e) {
			}
		}
		return null;
	}


	public static List<MobileElement> getMobileElements(String locator) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		locator = getLocator(locator);
		if (driver.findElementsById(locator).size() != 0) {
			return driver.findElementsById(locator);
		} else if (driver.findElementsByAccessibilityId(locator).size() != 0) {
			return driver.findElementsByAccessibilityId(locator);
		} else if (driver.findElementsByXPath(locator).size() != 0) {
			return driver.findElementsByXPath(locator);
		} else {
			try {
				// do stuff...
				// fail(locator + " Not Exist");
			} catch (Exception e) {
			}
		}
		return null;

	}

	public static String getLocator(String locator) {
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

	public static void tapOnCoachMark() throws InterruptedException {
		sleepTime(1);
		Dimension dim = driver.manage().window().getSize();
		int width = dim.getWidth() / 2;
		int height = (int) (dim.getHeight() * 0.3);
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(width, height)).perform();

		// new TouchAction(driver).press(pressOptions((width, height)).perform();
		sleepTime(1);

	}

	public static void landingCoachMark() throws InterruptedException {
		Dimension dim = driver.manage().window().getSize();
		int width = dim.getWidth() / 2;
		int height = (int) (dim.getHeight() * 0.3);
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(width, height)).perform();
		sleepTime(1);

	}

	@When("I want to tap on facebook avatar")
	@Then("I want to tap on facebook avatar")
	public static void tapOnFacebookAvatar() throws InterruptedException {
		Dimension dim = driver.manage().window().getSize();
		int width = (int) (dim.getWidth() * .82);
		int height = (int) (dim.getHeight() * .56);
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(width, height)).perform();
		// new TouchAction(driver).tap(width, height).perform();
		sleepTime(1);

	}

	@When("I want to tap on twitter avatar")
	@Then("I want to tap on twitter avatar")
	public static void tapOnTwitterAvatar() throws InterruptedException {
		Dimension dim = driver.manage().window().getSize();
		int width = (int) (dim.getWidth() * .94);
		int height = (int) (dim.getHeight() * .56);
		TouchAction action = new TouchAction(driver);
		action.tap(PointOption.point(width, height)).perform();
		// new TouchAction(driver).tap(width, height).perform();
		Thread.sleep(1000);

	}

	public void longPress(String locaotr) {

		ElementOption element = new ElementOption();
		element.withElement(getMobileElement(locaotr));
		TouchAction action = new TouchAction(driver);
		Duration duration = Duration.ofSeconds(3);
		sleepTime(3);
		action.longPress(LongPressOptions.longPressOptions().withElement(element).withDuration(duration)).release()
				.perform();
		sleepTime(3);
	}

	public static void pullToRefresh() throws InterruptedException {

		sleepTime(1);
		Dimension dim = driver.manage().window().getSize();
		int width = dim.getWidth() / 2;
		int startY = (int) (dim.getHeight() * 0.50);
		int endY = (int) (dim.getHeight() * 0.9);
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(width, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(width, endY)).release().perform();
		// new TouchAction(driver).press(width,
		// startY).waitAction(Duration.ofMillis(1000)).moveTo(width, endY).release()
		// .perform();
		Thread.sleep(2000);

	}

	public static void allowPermission() throws InterruptedException {

		String locator = null;
		String locator2 = null;
		locator = getLocator("allowPermession");
		locator2 = getLocator("confirmPrivacy");

		if (driver.findElementsById(locator).size() != 0) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator))).click();
		} else if (driver.findElementsByAccessibilityId(locator).size() != 0) {

			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(locator))).click();
		} else if (driver.findElementsByXPath(locator).size() != 0) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
		}

		if (driver.findElementsById(locator2).size() != 0) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator2))).click();
		} else if (driver.findElementsByAccessibilityId(locator2).size() != 0) {
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId(locator2))).click();
		} else if (driver.findElementsByXPath(locator2).size() != 0) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator2))).click();
		}

	}

	public static MobileElement getResendEmail() {
		return Helper.getMobileElement("resendEmail");
	}

	public static void scrollTo(String direction, int times) throws InterruptedException {
		if (direction.equals("down")) {

			Dimension dim = driver.manage().window().getSize();
			int width = dim.getWidth() / 2;
			for (int i = 0; i < times; i++) {
				sleepTime(1);
				int startY = (int) (dim.getHeight() * 0.65);
				int endY = (int) (dim.getHeight() * 0.35);
				sleepTime(1);
				TouchAction action = new TouchAction(driver);
				action.press(PointOption.point(width, startY))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
						.moveTo(PointOption.point(width, endY)).release().perform();
				sleepTime(1);

			}

		}

		if (direction.equals("up")) {
			//
			Thread.sleep(1000);
			Dimension dim = driver.manage().window().getSize();
			int width = dim.getWidth() / 2;
			for (int i = 0; i < times; i++) {
				int startY = (int) (dim.getHeight() * 0.3);
				int endY = (int) (dim.getHeight() * 0.7);
				TouchAction action = new TouchAction(driver);
				action.press(PointOption.point(width, startY))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
						.moveTo(PointOption.point(width, endY)).release().perform();

			}

		}
		if (direction.equals("right")) {
			Dimension dim = driver.manage().window().getSize();
			if (platform.equals("iOS")) {

				int Height = (int) (dim.height / 1.5);
				for (int i = 0; i < times; i++) {
					Double screenHeightStart = dim.width * 0.7;

					int scrollStart = screenHeightStart.intValue();

					Double screenHeightEnd = dim.width * 0.3;

					int scrollEnd = screenHeightEnd.intValue();
					TouchAction action = new TouchAction(driver);
					action.press(PointOption.point(scrollStart, Height))
							.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
							.moveTo(PointOption.point(scrollEnd, Height)).release().perform();
				}
			} else {
				int Height = dim.height / 2;
				for (int i = 0; i < times; i++) {
					Double screenHeightStart = dim.width * 0.7;
					int scrollStart = screenHeightStart.intValue();
					Double screenHeightEnd = dim.width * 0.3;
					int scrollEnd = screenHeightEnd.intValue();
					TouchAction action = new TouchAction(driver);
					action.press(PointOption.point(scrollStart, Height))
							.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
							.moveTo(PointOption.point(scrollEnd, Height)).perform();
				}
			}
		}

		if (direction.equals("left")) {

			Dimension dim = driver.manage().window().getSize();
			int Height = dim.height / 2;
			for (int i = 0; i < times; i++) {
				Double screenHeightStart = dim.width * 0.3;
				int scrollStart = screenHeightStart.intValue();
				Double screenHeightEnd = dim.width * 0.7;
				int scrollEnd = screenHeightEnd.intValue();
				TouchAction action = new TouchAction(driver);
				action.press(PointOption.point(scrollStart, Height))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
						.moveTo(PointOption.point(scrollEnd, Height)).release().perform();

			}

		}
	}

	public static boolean checkIfElementNotExist(String locator) {
		locator = getLocator(locator);

		boolean x = driver.findElementsById(locator).size() == 0;
		sleepTime(1);
		boolean y = driver.findElementsByXPath(locator).size() == 0;
		sleepTime(1);
		boolean z = driver.findElementsByAccessibilityId(locator).size() == 0;
		sleepTime(1);

		return x && y && z;
	}

	public static void clickOnElement(String locator) {
		getMobileElement(locator).click();
	}

	public void fillTextField(String locator, String value) {
		String Value = getLocator(value);
		getMobileElement(locator).sendKeys(Value);
	}

	public static void sleepTime(double time) {
		try {
			Thread.sleep((long) (time * 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void navigateBack() {
		Helper.driver.navigate().back();
	}

	public void waitElementInvisibility(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		locator = getLocator(locator);
		if (driver.findElementsById(locator).size() != 0) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locator)));

		} else if (driver.findElementsByAccessibilityId(locator).size() != 0) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.AccessibilityId(locator)));

		} else if (driver.findElementsByXPath(locator).size() != 0) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath(locator)));

		}

	}

	public void waitElementToBeVisibile(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		locator = getLocator(locator);
		if (driver.findElementsById(locator).size() != 0) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));

		} else if (driver.findElementsByAccessibilityId(locator).size() != 0) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(locator)));

		} else if (driver.findElementsByXPath(locator).size() != 0) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(locator)));

		}
	}

	public void putAppInBackGround(long time) {
		((AppiumDriver) driver).runAppInBackground(Duration.ofSeconds(time));

	}

	public void isElementVisible(String locator) {

		String Locator = getLocator(locator);
		Assert.assertTrue(getMobileElement(locator).isDisplayed());

	}

	public boolean isMyElementVisible(String locator) {

		String Locator = getLocator(locator);
		return getMobileElement(locator).isDisplayed();
		// Assert.assertTrue(getMobileElement(locator).isDisplayed());

	}

	public void isElementContainstext(String locator, String text) {
		String Locator = getLocator(locator);
		String Text = getLocator(text);
		if (text.equals("AM")) {
			Assert.assertTrue(getMobileElement(locator).getText().trim().contains("AM")
					|| getMobileElement(locator).getText().trim().contains("PM"));
		} else {
			Assert.assertTrue(getMobileElement(locator).getText().trim().contains(Text));
		}

	}

	public void checkTextIsNotExist(String locator) {
		String Locator = getLocator(locator);

		Assert.assertTrue(!getMobileElement(locator).getText().trim().contains(suggestedFriendName));

	}

	public static void elementDoesntHaveText(String locator, String text) {
		String Locator = getLocator(locator);
		String Text = getLocator(text);
		Assert.assertTrue(!getMobileElement(locator).getText().trim().contains(Text));
	}

	public void checkTextExist(String locator) {
		String Locator = getLocator(locator);

		Assert.assertTrue(getMobileElement(locator).getText().trim().contains(suggestedFriendName));
	}

	public void isElementEqualsText(String locator, String text) {
		String Locator = getLocator(locator);
		String Text = getLocator(text);
		Assert.assertTrue(getMobileElement(locator).getText().trim().contains(Text.trim()));
	}

	public void tapOnTheCentre() {
		TouchAction touchAction = new TouchAction(Helper.driver);
		sleepTime(4);
		touchAction.tap(PointOption.point(538, 739)).perform();
	}

}