package Baaz.Mobile.pages;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Baaz.Mobile.common.Helper;
import Baaz.Mobile.common.StateHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.connection.HasNetworkConnection;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BaazlinePage extends Helper {

	public void createEmptyPost() throws InterruptedException {
		// Ok
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		getMobileElement("addPost").click();

	}

	public void createTextPost(String textContent) throws InterruptedException {
		// Ok
		WebDriverWait wait = new WebDriverWait(driver, 100);
		String locator = getLocator("createPost");
		String Text = getLocator(textContent);
		sleepTime(1);
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		sleepTime(2);
		getMobileElement("postTextField").sendKeys(Text);
		if (textContent.equals("postWithKeyWords")) {
			sleepTime(5);
		}
		if (textContent.equals("hashTag")) {
			Assert.assertTrue(getMobileElement("keywordInList").isDisplayed());
		}
		getMobileElement("addPost").click();
		sleepTime(2);
		if (Text.length() > 200) {
			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		if (textContent.equals("onFriend")) {

		} else {
			try {
				getMobileElement("resendEmail").click();
			} catch (Exception e) {

			}
			sleepTime(1);
			scrollTo("up", 1);
			Helper.pullToRefresh();
		}

	}

	public void createPostWithLink() throws InterruptedException {
		String locator = getLocator("createPost");
		String Text = getLocator("link");
		sleepTime(1);
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		sleepTime(2);
		getMobileElement("postTextField").sendKeys(Text);
		getMobileElement("addPost").click();
		sleepTime(2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		scrollTo("up", 1);
		Helper.pullToRefresh();
	}

	public void CreatePostRemoveKywWord() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		String locator = getLocator("createPost");

		sleepTime(1);
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		sleepTime(2);
		getMobileElement("postTextField").sendKeys("Baaz");
		sleepTime(1);
		getMobileElement("removeKeyword").click();
		waitElementInvisibility("keywordInList");
	}

	public void openKeyWords() {
		getMobileElement("threeDotsOptions").click();
		getMobileElement("keywordsButton").click();

	}

	public String checkTextPost() {

		sleepTime(1);
		System.err.println(getMobileElement("textPost").getText().toString());
		return getMobileElement("textPost").getText().toString().trim();
	}

	public String checkPostKeyowrds() {
		// Ok
		getMobileElement("postAction").click();
		getMobileElement("keyWords").click();
		return getMobileElement("postKeywords").getText().toString();

	}

	public void createFacebookPost() throws InterruptedException {
		String post = "Baaz Post " + System.currentTimeMillis();
		StateHelper.setStepState("facebookPost", post);
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		if (Helper.platform.equalsIgnoreCase("iOS")) {
			Helper.tapOnFacebookAvatar();
		}
		if (Helper.platform.equalsIgnoreCase("Android")) {
			getMobileElement("facebookAvatar").click();
		}

		getMobileElement("postTextField").sendKeys(post);
		getMobileElement("addPost").click();
		Thread.sleep(2000);
		Helper.pullToRefresh();
	}

	public boolean checkFacebookPost(String facebookPost) {
		if (getMobileElement("textPost").getText().equals(facebookPost)) {
			getMobileElement("facebookFilter").click();
			return getMobileElement("twitterFilter").getText().toString().equals(facebookPost);
		}

		return false;

	}

	public void logOut() {
		getMobileElement("menuButton").click();
		getMobileElement("logout").click();
		getMobileElement("confirmLogout").click();
	}

	public void shareYouTubePostAndCheck() {
		try {
			getMobileElement("resendEmail").click();
		} catch (Exception e) {

		}
		getMobileElement("thirdFilter").click();
		getMobileElement("shareYouTube").click();
		getMobileElement("quickSharePost").click();
		sleepTime(5);
		getMobileElement("firstFilter").click();
		isElementContainstext("sharedOwner", "sharedThisPost");
	}

	public void createTwitterPost() throws InterruptedException {
		// Ok

		String post = "Baaz Post " + System.currentTimeMillis();
		StateHelper.setStepState("twitterPost", post);
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		if (Helper.platform.equalsIgnoreCase("iOS")) {
			Helper.tapOnTwitterAvatar();
		}
		if (Helper.platform.equalsIgnoreCase("Android")) {
			getMobileElement("thirdFilter").click();
			getMobileElement("baazAvatar").click();
		}

		getMobileElement("postTextField").sendKeys(post);
		getMobileElement("addPost").click();
		sleepTime(3);
		try {
			getMobileElement("resendEmail").click();
		} catch (Exception e) {

		}

		sleepTime(2);
		pullToRefresh();
		sleepTime(2);
		getMobileElement("twitterFilter").click();
		pullToRefresh();
	}

	public void createTwitterPostImage(String media) throws InterruptedException {
		// Ok
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Helper.landingCoachMark();
		Helper.landingCoachMark();
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		getMobileElement("twitterAvatar").click();
		String post = "Baaz Post " + System.currentTimeMillis();
		StateHelper.setStepState("twitterPost", post);
		getMobileElement("cameraIcon").click();
		Helper.allowPermission();
		Helper.allowPermission();
		getMobileElement("chooseFromLibrary").click();
		if (media.equals("video")) {
			getMobileElement("videoAlbum").click();
			getMobileElement("jpgAlbum").click();
		}
		if (media.equals("image")) {
			getMobileElement("jpgAlbum").click();
		}

		getMobileElement("firstImage").click();
		getMobileElement("uploadImage").click();
		sleepTime(10);
		getMobileElement("addPost").click();
		sleepTime(2);
		Helper.pullToRefresh();
		Helper.pullToRefresh();
		if (media.equals("video")) {

			wait.until(ExpectedConditions.invisibilityOf(getMobileElement("processingVideo")));
			Helper.pullToRefresh();
		}
	}

	public void checkTwitterPostImage() {
		getMobileElement("twitterFilter").click();

	}

	public boolean checkTwitterPost(String twitterPost) {

		if (getMobileElement("textPost").getText().equals(twitterPost)) {
			getMobileElement("twitterFilter").click();
			return getMobileElement("textPost").getText().toString().equals(twitterPost);
		}

		return false;

	}

	public void retweetPostAndCheck() {
		getMobileElement("retweetPost").click();
		try {
			getMobileElement("secondTiwtter").click();
		} catch (Exception e) {

		}
		getMobileElement("dismissMessage").click();
		isElementEqualsText("numOfRetweets", "1");

	}

	public void createCombinedPost() throws InterruptedException {
		// Ok
		String post = "Baaz Post " + System.currentTimeMillis();
		StateHelper.setStepState("combinedPost", post);
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		if (Helper.platform.equalsIgnoreCase("iOS")) {

			Helper.tapOnTwitterAvatar();
		}
		if (Helper.platform.equalsIgnoreCase("Android")) {
			getMobileElement("twitterAvatar").click();

		}

		getMobileElement("postTextField").sendKeys(post);
		getMobileElement("addPost").click();
		Thread.sleep(3000);
		getMobileElement("resendEmail").click();
		Helper.pullToRefresh();
	}

	public boolean checkCombinedPost(String combinedPost) {
		// TODO Auto-generated method stub

		if (getMobileElement("textPost").getText().equals(combinedPost)) {
			getMobileElement("twitterFilter").click();
			boolean twitter = getMobileElement("textPost").getText().toString().equals(combinedPost);

			return twitter;
		}

		return false;

	}

	public boolean checkVideoPost() {
		String locator = getLocator("videoPost");
		boolean x = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(locator))) != null;
		return x;
	}

	public void createPrivacyPost(String privacy) throws InterruptedException {
		// Ok
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		getMobileElement("postPrivacy").click();
		if (privacy.equalsIgnoreCase("only me")) {
			getMobileElement("onlyMePrivacy").click();
		} else if (privacy.equalsIgnoreCase("their friends")) {
			getMobileElement("theirFriendsPrivacy").click();
		} else if (privacy.equalsIgnoreCase("my friends")) {
			getMobileElement("myFriendsPrivacy").click();
		}
		getMobileElement("postTextField").sendKeys("Hello " + privacy + " post");
		getMobileElement("addPost").click();
		Thread.sleep(3000);
		getMobileElement("resendEmail").click();
		Helper.pullToRefresh();

	}

	public void changePostPrivacy() {
		getMobileElement("postAction").click();
		getMobileElement("editPost").click();
		getMobileElement("postTextField").clear();
		getMobileElement("postTextField").sendKeys("Hello only me post");
		getMobileElement("postPrivacy").click();
		getMobileElement("onlyMePrivacy").click();
		getMobileElement("addPost").click();
	}

	public void changeSharedPostPrivacy() {

		getMobileElement("editSharedPost").click();
		getMobileElement("threeDotsOptionsSec").click();
		getMobileElement("editPost").click();
		getMobileElement("postTextField").clear();
		getMobileElement("postTextField").sendKeys("Hello only me post");
		getMobileElement("postPrivacy").click();
		getMobileElement("onlyMePrivacy").click();
		getMobileElement("addPost").click();
	}

	public void deleteSharedPost() throws InterruptedException {
		getMobileElement("timeStamp").click();
		try {
			getMobileElement("threeDotsOptionsSec").click();
		} catch (Exception e) {
			getMobileElement("threeDotsOptions").click();
		}

		getMobileElement("deletePost").click();
		getMobileElement("confirmDeletePost").click();
		pullToRefresh();
		scrollTo("up", 3);
	}

	public void deleteSharedStory() throws InterruptedException {
		getMobileElement("timeStamp").click();
		getMobileElement("threeDotsOptions").click();
		getMobileElement("deletePost").click();
		getMobileElement("confirmDeletePost").click();
		pullToRefresh();
		scrollTo("up", 3);
		waitElementInvisibility("sharedOwner");
	}

	public void createImagePost(String imageType) throws InterruptedException {
		// Ok
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		getMobileElement("cameraIcon").click();
		if (Helper.platform.equalsIgnoreCase("android")) {
			Helper.allowPermission();
			Helper.allowPermission();
			getMobileElement("chooseFromLibrary").click();

		}

		if (Helper.platform.equalsIgnoreCase("iOS")) {
			getMobileElement("chooseFromLibrary").click();
			getMobileElement("allowGallery").click();

		}
		if (imageType.equals("jpg") || imageType.equals("png")) {
			getMobileElement("jpgAlbum").click();

		} else if (imageType.equals("gif")) {
			getMobileElement("gifAlbum").click();

		} else if (imageType.equals("video")) {
			getMobileElement("videoAlbum").click();
			getMobileElement("jpgAlbum").click();
		}

		if (imageType.equals("png")) {
			getMobileElement("secondImage").click();
		} else {
			getMobileElement("firstImage").click();
		}

		getMobileElement("uploadImage").click();
		waitElementInvisibility("photoSpinner");
		getMobileElement("addPost").click();
		sleepTime(4);
		try {
			getMobileElement("resendEmail").click();
		} catch (Exception e) {
			System.out.println("no resend button displays");
		}

		scrollTo("up", 4);
		if (imageType.equals("video")) {
			waitElementInvisibility("processingVideo");
		}

	}

	public void saveImage() {
		getMobileElement("imageThreeDots").click();
		getMobileElement("saveImage").click();
		isElementEqualsText("errorMsg", "photoSaved");
	}

	public void copyPostAndNavigate() {
		getMobileElement("sharedPostLink").click();
		try {
			getMobileElement("always").click();
		} catch (Exception e) {

		}

		isElementVisible("postDetailsBar");

	}

	public void navigateToSharedStoy() {
		getMobileElement("sharedPostLink").click();
		try {
			getMobileElement("always").click();
		} catch (Exception e) {

		}
	}

	public void createMentionPostWithMedia(String Type) throws InterruptedException {
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		getMobileElement("cameraIcon").click();
		Helper.allowPermission();
		Helper.allowPermission();
		getMobileElement("chooseFromLibrary").click();
		switch (Type.toLowerCase()) {
		case "video":
			getMobileElement("videoAlbum").click();
			getMobileElement("jpgAlbum").click();

			break;
		case "image":
			getMobileElement("jpgAlbum").click();
			break;
		}
		getMobileElement("firstImage").click();
		getMobileElement("uploadImage").click();
		sleepTime(4);
		getMobileElement("postTextField").sendKeys("@" + StateHelper.getStepState("user2name").toString());
		sleepTime(4);
		getMobileElement("mentionCard").click();
		getMobileElement("addPost").click();
		sleepTime(2);
		getMobileElement("resendEmail").click();
		scrollTo("up", 4);
	}

	public void createPostFriendProfile() throws InterruptedException {

		createTextPost("onFriend");
		sleepTime(1);
		Dimension dim = driver.manage().window().getSize();
		int width = dim.getWidth() / 2;

		int startY = (int) (dim.getHeight() * 0.8);
		int endY = (int) (dim.getHeight() * 0.9);
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(width, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(width, endY)).release().perform();

	}

	public void captureImagePost(int num) throws InterruptedException {
		// Ok
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();

		for (int i = 0; i < num; i++) {
			getMobileElement("cameraIcon").click();
			Helper.allowPermission();
			Helper.allowPermission();
			getMobileElement("takePhoto").click();
			sleepTime(5);
			getMobileElement("shutterButton").click();
			sleepTime(2);
			getMobileElement("doneCaptureButton").click();
			sleepTime(1);
		}

		sleepTime(3);
		getMobileElement("addPost").click();
		sleepTime(2);
		getMobileElement("resendEmail").click();
		Helper.pullToRefresh();
		Helper.pullToRefresh();

	}

	public void cuaptureVideoPost() throws InterruptedException {
		// Ok
		try {
			getMobileElement("resendEmail").click();
		} catch (Exception e) {

		}
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		getMobileElement("cameraIcon").click();
		Helper.allowPermission();
		Helper.allowPermission();
		getMobileElement("takeVideo").click();
		getMobileElement("shutterButton").click();
		sleepTime(5);
		getMobileElement("shutterButton").click();
		getMobileElement("doneCaptureButton").click();
		sleepTime(4);
		getMobileElement("addPost").click();
		sleepTime(2);
		Helper.pullToRefresh();
		Helper.pullToRefresh();
	}

	public void createVideoPost(String videoType) throws InterruptedException {
		// TODO Auto-generated method stub
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		getMobileElement("cameraIcon").click();
		if (Helper.platform.equalsIgnoreCase("android")) {
			Helper.allowPermission();
			Helper.allowPermission();
			getMobileElement("chooseFromLibrary").click();
			getMobileElement("videoAlbum").click();

		}

		if (Helper.platform.equalsIgnoreCase("iOS")) {
			getMobileElement("chooseFromLibrary").click();
			getMobileElement("allowGallery").click();

		}
		if (videoType.equals("mp4")) {
			getMobileElement("mp4Album").click();

		}

		getMobileElement("firstImage").click();
		getMobileElement("uploadImage").click();
		getMobileElement("addPost").click();
		Thread.sleep(10000);
		Helper.pullToRefresh();
		Helper.pullToRefresh();

	}

	public void createVideoPostWithText(String videoType) {
		// TODO Auto-generated method stub

	}

	public boolean checkKeepAndDiscardPost() throws InterruptedException {
		// Ok
		boolean postPage;
		boolean baazline;
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		getMobileElement("postTextField").sendKeys("Test Discard Post");
		getMobileElement("backFromPostPage").click();
		getMobileElement("keepPostPage").click();
		postPage = getMobileElement("addPost").isDisplayed();
		getMobileElement("backFromPostPage").click();
		getMobileElement("discardPostPage").click();
		baazline = getMobileElement("createPost").isDisplayed();
		return postPage && baazline;
	}

	public boolean cancelUploadImage() throws InterruptedException {
		// Ok
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		getMobileElement("cameraIcon").click();
		if (Helper.platform.equalsIgnoreCase("android")) {
			Helper.allowPermission();
			Helper.allowPermission();
			getMobileElement("chooseFromLibrary").click();

		}

		if (Helper.platform.equalsIgnoreCase("iOS")) {
			getMobileElement("chooseFromLibrary").click();
			getMobileElement("allowGallery").click();

		}

		getMobileElement("jpgAlbum").click();
		getMobileElement("firstImage").click();
		getMobileElement("uploadImage").click();
		getMobileElement("cancelUpload").click();
		getMobileElement("addPost").click();
		return getMobileElement("addPost").isDisplayed();
	}

	public void createMentionPost() throws InterruptedException {
		// Ok
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		getMobileElement("postTextField").sendKeys("@" + StateHelper.getStepState("user2name").toString());
		Thread.sleep(4000);
		getMobileElement("mentionCard").click();
		getMobileElement("addPost").click();

	}

	public void editMentionPost() throws InterruptedException {
		// OK
		try {
			getMobileElement("resendEmail").click();
		} catch (Exception e) {
		}

		pullToRefresh();
		getMobileElement("postAction").click();
		getMobileElement("editPost").click();
		getMobileElement("editPostTextField").clear();
		getMobileElement("editPostTextField").sendKeys("@" + StateHelper.getStepState("user3name").toString());
		sleepTime(4);
		getMobileElement("mentionCard").click();
		getMobileElement("addPost").click();

	}

	public void removeMention() {
		// Ok
		getMobileElement("postAction").click();
		getMobileElement("removeMention").click();

	}

	public boolean isMentionRemoved() {
		// TODO Auto-generated method stub
		getMobileElement("textPost").click();
		return getMobileElement("textPost").isDisplayed();
	}

	public void likeTextPost() {

		sleepTime(1);
		getMobileElement("likeButtonPost").click();

	}

	public String whoLikePost() {
		getMobileElement("likersButton").click();
		return getMobileElement("likerName").getText().toString();
	}

	public MobileElement getRemoveSuggestedFriend() {
		return Helper.getMobileElement("removeSuggestedFriend");
	}

	public String whoLikeFacebookPost() {
		// TODO Auto-generated method stub
		getMobileElement("likersButton").click();
		return getMobileElement("likerName").getText().toString();
	}

	public void unLikePost() {
		// Ok
		getMobileElement("backFromLikers").click();
		getMobileElement("unlikeButtonPost").click();

	}

	public void checkTwitterLikers(String num) {
		String x = getMobileElement("twitterLikers").getText();
		Assert.assertTrue(x.equals(num));
	}

	public void likeVideoPostAndCheckLikers() throws InterruptedException {
		// OK
		sleepTime(25);
		pullToRefresh();
		pullToRefresh();
		scrollTo("up", 2);
		scrollTo("down", 2);
		getMobileElement("likeButtonPost").click();
		getMobileElement("likersButton").click();
		isElementContainstext("likerName", "baazUser");

	}

	public String numOfLikers() {
		// Ok
		return getMobileElement("likersButton").getText().toString();

	}

	public void likeTextPostFromDetailed() {
		// Ok
		getMobileElement("commentButton").click();
		sleepTime(1);
		getMobileElement("likeButtonPost").click();

	}

	public void likeTwitterPostFromDetailed() {
		getMobileElement("timeStamp").click();
		sleepTime(1);
		getMobileElement("likeTwitter").click();
	}

	public void commentOnBaazPost(String comment) {
		// Ok
		String Text = getLocator(comment);

		switch (comment.toLowerCase()) {
		case "mention":
			getMobileElement("commentButton").click();
			TouchAction touchAction = new TouchAction(Helper.driver);
			getMobileElement("commentTextField").sendKeys("@" + StateHelper.getStepState("user2name").toString());
			sleepTime(4);
			touchAction.tap(PointOption.point(300, 1515)).perform();
			break;
		case "twittercomment":

			getMobileElement("replyTwitter").click();
			try {
				getMobileElement("secondTwitterAvatar").click();
			} catch (Exception e) {
				// TODO: handle exception
			}
			getMobileElement("commentTextField").sendKeys(Text);

			break;
		default:
			getMobileElement("commentButton").click();
			getMobileElement("commentTextField").sendKeys(Text);
			break;
		}

		getMobileElement("addComment").click();

	}

	public void deleteComment() throws InterruptedException {
		longPress("commentBody");
		getMobileElement("deleteComment").click();
		scrollTo("down", 1);
		waitElementInvisibility("commentBody");

	}

	public void deleteRSSComment() throws InterruptedException {
		longPress("commentBody");
		getMobileElement("deleteComment").click();
	}

	public void chechNumOfCommentsAfter() {
		String y = getMobileElement("numOfComments").getText().trim();
		String[] x = y.split(" ");
		String comments = x[0];
		int num = Integer.parseInt(comments);
		int val = Integer.parseInt(glbalVar);
		Assert.assertTrue(num == val + 1);
	}

	public void editComment(String comment) {
		// Ok
		String Comment = getLocator(comment);
		if (Helper.platform.equalsIgnoreCase("iOS")) {
			getMobileElement("commentFrame").click();
			getMobileElement("editComment").click();
			getMobileElement("editCommentField").clear();
			getMobileElement("editCommentField").sendKeys(Comment);
			getMobileElement("confirmEditComment").click();
		} else if ((Helper.platform.equalsIgnoreCase("android"))) {

			ElementOption element = new ElementOption();
			element.withElement(getMobileElement("commentBody"));
			TouchAction touchAction = new TouchAction(Helper.driver);
			Duration duration = Duration.ofSeconds(3);

			touchAction.longPress(new LongPressOptions().withElement(element).withDuration(duration)).perform()
					.release();

			getMobileElement("editComment").click();
			getMobileElement("editCommentField").clear();
			switch (comment.toLowerCase()) {

			case "editedmention":
				getMobileElement("editCommentField").sendKeys("@" + StateHelper.getStepState("user3name").toString());
				sleepTime(4);
				TouchAction Action = new TouchAction(Helper.driver);
				Action.tap(PointOption.point(200, 480)).perform();
				break;

			default:
				getMobileElement("editCommentField").sendKeys(Comment);
				break;

			}
			getMobileElement("confirmEditComment").click();
		}

	}

	public void isMentionEquals(String where) {

		Assert.assertTrue(
				getMobileElement(where).getText().trim().contains(StateHelper.getStepState("user2name").toString()));
	}

	public void isEditedMentionEquals() {
		Assert.assertTrue(getMobileElement("commentBody").getText().trim()
				.contains(StateHelper.getStepState("user3name").toString()));
	}

	public String sharePosttoBaaz() throws InterruptedException {

		getMobileElement("commentButton").click();
		getMobileElement("shareButton").click();
		getMobileElement("quickSharePost").click();
		navigateBack();
		Helper.pullToRefresh();
		return getMobileElement("sharedOwner").getText().toString();
	}

	public void shareRSSPost() throws InterruptedException {
		scrollTo("down", 1);
		getMobileElement("shareButton").click();
		getMobileElement("quickSharePost").click();
		sleepTime(5);
		getMobileElement("baazFirstFilter").click();
		scrollTo("up", 3);
		isElementContainstext("sharedOwner", "sharedThisPost");
	}

	public String sharePostFromDetailsPage() throws InterruptedException {
		getMobileElement("commentButton").click();
		getMobileElement("shareButton").click();
		getMobileElement("quickSharePost").click();
		navigateBack();
		pullToRefresh();
		pullToRefresh();
		return getMobileElement("sharedOwner").getText().toString();
	}

	public String shareToLike() throws InterruptedException {
		getMobileElement("shareButton").click();
		getMobileElement("quickSharePost").click();
		Helper.pullToRefresh();
		return getMobileElement("sharedOwner").getText().toString();
	}

	public void sharePostToTwitterOnly(String type) throws InterruptedException {

		getMobileElement("shareButton").click();
		getMobileElement("share").click();

		getMobileElement("twitterAvatar").click();
		sleepTime(1);
		getMobileElement("baazAvatar").click();

		if (type.equals("withMention")) {
			getMobileElement("postTextField").sendKeys("@musab5");
			sleepTime(4);
			getMobileElement("mentionCard").click();
		}

		getMobileElement("addPost").click();
		sleepTime(4);
		scrollTo("up", 8);

	}

	public void sharePostToSNAddText() throws InterruptedException {
		getMobileElement("shareButton").click();
		getMobileElement("share").click();
		getMobileElement("postTextField").sendKeys("Share This Post");
		getMobileElement("twitterAvatar").click();
		getMobileElement("baazAvatar").click();

		getMobileElement("addPost").click();
		sleepTime(1);
		scrollTo("up", 3);
	}

	public void shareWithText(String type) throws InterruptedException {
		getMobileElement("shareButton").click();
		getMobileElement("share").click();
		switch (type.toLowerCase()) {
		case "text":
			getMobileElement("postTextField").sendKeys("Share This Post");
			break;
		case "mention":
			getMobileElement("postTextField").sendKeys("@" + StateHelper.getStepState("user2name").toString());
			Thread.sleep(4000);
			getMobileElement("mentionCard").click();
			break;

		}

		getMobileElement("addPost").click();
		pullToRefresh();
		scrollTo("up", 3);
	}

	public void copyPostLinkAndShare() throws InterruptedException {

		getMobileElement("shareButton").click();
		getMobileElement("copyLinkPost").click();
		getMobileElement("createPost").click();
		longPress("postTextField");
		getMobileElement("paste").click();
		getMobileElement("addPost").click();
		sleepTime(1);
		pullToRefresh();
		scrollTo("up", 1);
	}

	public void createPostWithCopiedProfile() throws InterruptedException {
		getMobileElement("createPost").click();
		Helper.tapOnCoachMark();
		longPress("postTextField");
		getMobileElement("paste").click();
		getMobileElement("addPost").click();
		sleepTime(2);
		try {
			getMobileElement("resendEmail").click();
		} catch (Exception e) {

		}
		scrollTo("up", 4);
	}

	public void copyStoryAndCreatePost() throws InterruptedException {
		getMobileElement("menuButton").click();
		getMobileElement("trending").click();
		try {
			Helper.landingCoachMark();
			Helper.landingCoachMark();
			Helper.landingCoachMark();
			Helper.landingCoachMark();

		} catch (Exception e) {
			// TODO: handle exception
		}
		String locator = getLocator("storyThreeDots");
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(locator)));
		getMobileElement("storyThreeDots").click();
		sleepTime(1);
		getMobileElement("copyLinkPost").click();
		navigateBack();
		createPostWithCopiedProfile();
	}

	public void copyPostAndPaste() {
		longPress("textPost");
		getMobileElement("androidTitle").click();
		getMobileElement("commentButton").click();
		longPress("commentTextField");

		TouchAction touchAction = new TouchAction(Helper.driver);
		sleepTime(4);
		touchAction.tap(PointOption.point(190, 1520)).perform();

		getMobileElement("addComment").click();

	}

	public void sharePostWithMoreOptions() {

		getMobileElement("shareButton").click();
		getMobileElement("moreOptionsPost").click();

	}

	public String sharePostToTwitter() throws InterruptedException {
		// Ok

		getMobileElement("shareButton").click();
		getMobileElement("share").click();
		if (Helper.platform.equalsIgnoreCase("iOS")) {
			Helper.tapOnTwitterAvatar();
		}
		if (Helper.platform.equalsIgnoreCase("Android")) {
			getMobileElement("twitterAvatar").click();
		}
		getMobileElement("addPost").click();
		waitElementToBeVisibile("createPost");
		pullToRefresh();
		return getMobileElement("sharedOwner").getText().toString();
	}

	public String editPost(String editedPost) {
		// Ok
		String Text = getLocator(editedPost);
		getMobileElement("postAction").click();
		getMobileElement("editPost").click();
		getMobileElement("editPostTextField").clear();
		getMobileElement("editPostTextField").sendKeys(Text);
		getMobileElement("addPost").click();
		return getMobileElement("textPost").getText().toString();
	}

	public void scrollToFeatured() throws InterruptedException {
		// String Locator2 = getLocator("resendEmail");
		// boolean resendEmail = driver.findElementsByXPath(Locator2).size() == 0;
		// if(resendEmail == true) {
		// getMobileElement("resendEmail").click();
		// }

		String Locator = getLocator("firstFeaturedKeyword");
		// boolean isFoundTheElement = driver.findElementsByXPath(Locator).size() == 0;
		while (driver.findElementsByXPath(Locator).size() == 0) {
			scrollTo("down", 1);
		}
	}

	public void editSharedPost(String editedPost) throws InterruptedException {
		pullToRefresh();
		String Text = getLocator(editedPost);
		getMobileElement("editSharedPost").click();
		getMobileElement("threeDotsOptionsSec").click();
		getMobileElement("editPost").click();
		getMobileElement("editPostTextField").clear();
		switch (editedPost.toLowerCase()) {
		case "mention":
			getMobileElement("editPostTextField").sendKeys("@" + StateHelper.getStepState("user3name").toString());
			sleepTime(4);
			getMobileElement("mentionCard").click();
			break;
		default:
			getMobileElement("editPostTextField").sendKeys(Text);
			break;
		}

		getMobileElement("addPost").click();

	}

	public String editPostFromDetailed(String editedPost) {
		// TODO Auto-generated method stub
		String text = getLocator(editedPost);
		getMobileElement("commentButton").click();
		getMobileElement("postAction").click();
		getMobileElement("editPost").click();
		getMobileElement("editPostTextField").clear();
		getMobileElement("editPostTextField").sendKeys(text);
		getMobileElement("addPost").click();
		return getMobileElement("textPost").getText().toString();
	}

	public String deletePost() {
		// TODO Auto-generated method stub
		getMobileElement("postAction").click();
		getMobileElement("deletePost").click();
		getMobileElement("confirmDeletePost").click();
		return getMobileElement("textPost").getText().toString();
	}

	public void deletePosts() {
		// Ok
		getMobileElement("postAction").click();
		getMobileElement("deletePost").click();
		getMobileElement("confirmDeletePost").click();

	}

	public String deleteSNPost() {
		// Ok
		getMobileElement("postAction").click();
		getMobileElement("deletePost").click();
		getMobileElement("confirmDeletePost").click();
		return getMobileElement("textPost").getText().toString();

	}

	public void chooseMediaFilter(String mediaType) {
		// TODO Auto-generated method stub
		getMobileElement("filterButton").click();
		if (mediaType.equals("photos")) {
			getMobileElement("photos").click();
		} else if (mediaType.equals("text")) {
			getMobileElement("text").click();
		} else if (mediaType.equals("links")) {
			getMobileElement("links").click();

		}
		getMobileElement("doneFilters").click();
		sleepTime(2);
	}

	public void chooseFilter(String update) {
		// TODO Auto-generated method stub
		getMobileElement("filterButton").click();
		if (update.equals("friends")) {
			getMobileElement("baazUpdateFriendFilter").click();
		} else if (update.equals("following")) {
			getMobileElement("baazUpdateFollowingFilter").click();

		}
		getMobileElement("doneFilters").click();
	}

	public String checkGreenBubble() {
		sleepTime(3);
		wait.until(ExpectedConditions.visibilityOfAllElements(getMobileElement("greenBubbleNum")));
		return getMobileElement("greenBubbleNum").getText().toString();
	}

	public void clickOnkGreenBubble() {
		getMobileElement("greenBubbleNum").click();

	}

	public boolean checkSuggestedFriends() {
		// Ok
		boolean Label = getMobileElement("suggestedFriendLabel").isDisplayed();
		boolean viewAll = getMobileElement("viewAllRecommendedFriends").isDisplayed();
		getMobileElement("viewAllRecommendedFriends").click();
		return getMobileElement("suggestedTab").isDisplayed() && getMobileElement("contactsTab").isDisplayed()
				&& getMobileElement("inviteTab").isDisplayed() && Label && viewAll;
	}

	public void getSecondSuggestionName(String index) {
		if (index.contains("findFriend")) {
			sleepTime(1);
			suggestedFriendName = getMobileElement("findFriendFirst").getText().trim();
		}
		switch (index.toLowerCase()) {
		case "first":
			suggestedFriendName = getMobileElement("firstSuggestedName").getText().trim();
			break;
		case "second":
			suggestedFriendName = getMobileElement("secondSuggestedName").getText().trim();
			break;
		case "third":
			suggestedFriendName = getMobileElement("thirdSuggestedName").getText().trim();
			break;
		}

	}

	public void checkKeyWordRedirection() {
		getValue("firstFeaturedKeyword");
		getMobileElement("firstFeaturedKeyword").click();
		Assert.assertTrue(getMobileElement("keyWordText").getText().trim().equals(glbalVar));

	}

	public void checkFeaturedForSN() throws InterruptedException {
		scrollToFeatured();
		checkKeyWordRedirection();
		navigateBack();
	}

	public void addSuggestedFriend(String action) {

		getMobileElement("addSuggestedFriend").click();

		switch (action.toLowerCase()) {
		case "add":
			getMobileElement("addFriendButton").click();
			break;
		case "follow":
			getMobileElement("followButton").click();
			break;
		}

	}

	private AndroidDriver<AndroidElement> capabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	public void navigateToRss() throws InterruptedException {
		getMobileElement("rssFilter").click();
		try {
			getMobileElement("resendEmail").click();
		} catch (Exception e) {

		}

		scrollTo("down", 1);

	}

	public void repliedComment(String repliedComment) {
		getMobileElement("commentButton").click();
		getMobileElement("likeComment").click();
		getMobileElement("replyComment").click();
		getMobileElement("commentTextField").sendKeys(repliedComment);
		getMobileElement("addComment").click();
	}

	public void blockUser() {
		getMobileElement("userProfileMoreIcon").click();
		getMobileElement("blockUser").click();
		getMobileElement("confirmBlock").click();
	}

	public void reportPost() {
		// Ok
		getMobileElement("postAction").click();
		getMobileElement("reportPost").click();
		getMobileElement("spamReportPost").click();
		getMobileElement("submitReport").click();

		getMobileElement("postAction").click();
		getMobileElement("reportPost").click();
		getMobileElement("fakeNewsReportPost").click();
		getMobileElement("submitReport").click();

		getMobileElement("postAction").click();
		getMobileElement("reportPost").click();
		getMobileElement("offensiveLanguageReportPost").click();
		getMobileElement("submitReport").click();

		getMobileElement("postAction").click();
		getMobileElement("reportPost").click();
		getMobileElement("graphicImagesOrVideoReportPost").click();
		getMobileElement("submitReport").click();

		getMobileElement("postAction").click();
		getMobileElement("reportPost").click();
		getMobileElement("copyrightReportPost").click();
		getMobileElement("submitReport").click();

	}

	public void addFriendFromProfile(int numOfUsersl) throws InterruptedException {

		Helper.scrollTo("down", 2);
		StateHelper.setStepState("firstUser", getMobileElements("recommendedFriendsNames").get(0).getText());
		getMobileElements("recommendedFriendsAvatars").get(1).click();
		getMobileElement("addFriend").click();
		getMobileElement("discardNotifications").click();
		Helper.scrollTo("down", 1);
		for (int i = 0; i < numOfUsersl; i++) {
			getMobileElement("addSuggestedFriend").click();
			getMobileElement("addFriend_Baazline").click();
		}
		Helper.driver.navigate().back();
	}

	public void addFriendProfile(String action) {

		switch (action.toLowerCase()) {
		case "add":
			getMobileElement("addFriend").click();
			break;
		case "follow":
			getMobileElement("followButton").click();
			break;
		}
		waitElementToBeVisibile("confirmBlock");
		getMobileElement("confirmBlock").click();
		Helper.driver.navigate().back();
	}

	public void deleteFriendFromProfile(int numOfUsersl) throws InterruptedException {

		Helper.scrollTo("down", 2);
		StateHelper.setStepState("firstUser", getMobileElements("recommendedFriendsNames").get(0).getText());
		getMobileElements("recommendedFriendsAvatars").get(1).click();
		getMobileElement("addFriend").click();
		getMobileElement("discardNotifications").click();
		Helper.scrollTo("down", 1);
		for (int i = 0; i < numOfUsersl; i++) {
			getMobileElement("removeSuggestedFriend").click();
		}
		Helper.driver.navigate().back();
	}

	public boolean syncBetweenBaazlineAndProfile() {

		return !getMobileElements("recommendedFriendsNames").get(0).getText()
				.equals(StateHelper.getStepState("firstUser").toString());

	}

	public boolean syncBetweenBaazlineAndProfileForAllFriends() {

		return getMobileElements("recommendedFriendsNames").size() == 1;

	}

	public boolean syncBetweenBaazlineAndProfileForAllFriendsAfterPullToRefresh() throws InterruptedException {
		Helper.pullToRefresh();
		Helper.pullToRefresh();
		Helper.pullToRefresh();
		Helper.scrollTo("down", 2);
		return Helper.checkIfElementNotExist("recommendedFriendsAvatars");

	}

	public void refreshUntilsuggestions() throws InterruptedException {
		String Locator = getLocator("promotedLabel");
		sleepTime(1);
		while (driver.findElementsByXPath(Locator).size() != 0) {

			pullToRefresh();

		}

	}

	public void findFriendContacts(String action) {
		getMobileElement("viewAllIcon").click();
		getMobileElement("contactsTab").click();
		getMobileElement("findContact").click();
		getMobileElement("allowPermession").click();

		switch (action.toLowerCase()) {
		case "add":
			getMobileElement("addFriendContact").click();
			break;
		case "follow":
			getMobileElement("followFriendContact").click();
			break;
		}
	}

	public void navigatetoFindFriends() throws InterruptedException {
		scrollTo("down", 2);
		scrollTo("right", 15);
	}

	public void findFiendFromProfileReturnBack(String action) {
		getMobileElement("viewAllIcon").click();
		getMobileElement("menuAvatar").click();
		switch (action.toLowerCase()) {
		case "add":
			getMobileElement("addFriendButton").click();
			break;
		case "follow":
			getMobileElement("followUser_Baazline").click();
			break;
		}

		getMobileElement("confirmUnfollowSuggestedFriend").click();
		navigateBack();

	}

	public void inviteFriendViaWhatsApp(String type) {
		getMobileElement("viewAllIcon").click();
		getMobileElement("inviteTab").click();
		switch (type.toLowerCase()) {
		case "whatsapp":
			getMobileElement("inviteViaWhatsApp").click();
			break;
		case "messanger":
			getMobileElement("inviteViaMessanger").click();
			break;
		case "otherapps":
			getMobileElement("inviteViaOtherApps").click();
			break;
		}

	}

	public void inviteFriendsFromContacts() {
		getMobileElement("viewAllIcon").click();
		getMobileElement("inviteTab").click();
		getMobileElement("inviteFromeContacts").click();
		getMobileElement("allowPermession").click();
	}

	public void likeVideoPost() throws InterruptedException {
		getMobileElement("resendEmail").click();
		waitElementInvisibility("processingVideo");
		scrollTo("down", 1);
		getMobileElement("likeButtonPost").click();
	}

	public void navigateToDiscussions() {
		if (Helper.platform.equals("Android")) {
			Helper.getMobileElement("menuButton").click();

			TouchAction touchAction = new TouchAction(Helper.driver);
			sleepTime(1);
			touchAction.tap(PointOption.point(290, 995)).perform();
		}

		else {
			Helper.getMobileElement("discussions").click();

		}

		waitElementToBeVisibile("newDiscussion");
	}

	public void getDiscussionsbutton() {
		getMobileElement("discussions").click();
	}

	public void getTrendingbutton() {
		getMobileElement("menuButton").click();
		getMobileElement("trending").click();
		// WebDriverWait wait = new WebDriverWait(Helper.driver, 10);
		// wait.until(ExpectedConditions.visibilityOfAllElements(getTrending()));
		// getTrending().click();
	}

	public List<MobileElement> getAllRecommendedFriendsAvatars() {
		return Helper.getMobileElements("recommendedFriendsAvatars");
	}

	public List<MobileElement> getAllRecomendedFriendsNames() {
		return Helper.getMobileElements("recommendedFriendsNames");
	}

	/*
	 * tofail code public MobileElement getElement(String ElementName){ return
	 * Helper.getMobileElement(ElementName); }
	 */

	public MobileElement getBack() {

		return Helper.getMobileElement("back");
	}
}
