package Baaz.Mobile.pages;

import java.awt.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebElement;

import com.thoughtworks.selenium.webdriven.commands.GetConfirmation;

import Baaz.Mobile.common.Helper;
import Baaz.Mobile.common.StateHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class DiscussionPage extends Helper {

	public void sendMessageToNonFriend(String message) {
		getMobileElement("sendMessageButton").click();
		switch (message) {
		case "image":
			tapOnCameraIcon();
			sleepTime(1);
			getMobileElement("allowPermession").click();
			sleepTime(1);
			getMobileElement("allowPermession").click();
			getMobileElement("chooseFromLibrary").click();
			getMobileElement("jpgAlbum").click();
			getMobileElement("firstImage").click();
			getMobileElement("uploadImage").click();
			getMobileElement("sendMessage").click();
			waitElementInvisibility("sinding");
			break;

		case "video":
			tapOnCameraIcon();
			sleepTime(1);
			getMobileElement("allowPermession").click();
			sleepTime(1);
			getMobileElement("allowPermession").click();
			getMobileElement("chooseFromLibrary").click();
			getMobileElement("videoAlbum").click();
			getMobileElement("jpgAlbum").click();
			getMobileElement("firstImage").click();
			getMobileElement("uploadImage").click();
			getMobileElement("sendMessage").click();
			sleepTime(30);
			break;

		default:
			fillTextField("messageTextField", message);
			getMobileElement("sendMessage").click();
			sleepTime(3);
			break;
		}

	}

	public void checkRecentMsgAndTitle(String recentMessage, String discussionTitle) {
		// For iOS
		if (Helper.platform.equalsIgnoreCase("iOS")) {
			// for links
			if (recentMessage.contains(".com")) {
				String link_recent = "";
				int length = recentMessagelink().length();
				if (length > recentMessage.length() + 3) {
					link_recent = recentMessagelink().toString().trim().substring(1, length);
				} else {
					link_recent = recentMessagelink().toString().trim().substring(1, length - 2);
				}
				System.out.println(recentMessage);
				System.out.println(link_recent);
				assertTrue(link_recent.toString().trim().contains(recentMessage));

				if (discussionTitle.contains("user")) {
					discussionTitle = StateHelper.getStepState(discussionTitle).toString().trim();
				}
				assertTrue(discussionTitle().contains(discussionTitle));
			} // for images and videos

			else if (recentMessage.contains("Image") || recentMessage.contains("Video"))

			{
				String imagerecent = "";
				int length = RecentMessageImage().toString().length();
				if (length > recentMessage.length() + 4) {
					imagerecent = RecentMessageImage().toString().trim().substring(1, length);
				} else {
					imagerecent = RecentMessageImage().toString().trim().substring(1, length - 2);
				}
				System.out.println(recentMessage);
				System.out.println(imagerecent);
				assertTrue(imagerecent.toString().trim().contains(recentMessage));

				if (discussionTitle.contains("user")) {
					discussionTitle = StateHelper.getStepState(discussionTitle).toString().trim();
				}
				assertTrue(discussionTitle().contains(discussionTitle));
			}
			// for normal text
			else {
				int length = recentMessage().toString().length();
				System.out.println(length);
				System.out.println(recentMessage.length());
				System.out.println(recentMessage().toString().trim());
				System.out.println(recentMessage);
				assertEquals(recentMessage, recentMessage().toString().trim().substring(1, length));
				if (discussionTitle.contains("user")) {
					discussionTitle = StateHelper.getStepState(discussionTitle).toString();
				}
				assertTrue(discussionTitle().contains(discussionTitle));
			}

		}

		isElementEqualsText("recentMessage", recentMessage);
		if (discussionTitle.contains("user")) {
			discussionTitle = StateHelper.getStepState(discussionTitle).toString();
		}
		Assert.assertTrue(getMobileElement("discussionTitle").getText().trim().contains(discussionTitle.trim()));

	}

	public void sendMessageToFriend(String message) throws InterruptedException {
		switch (message) {
		case "mixedMsg":
			getMobileElement("newDiscussion").click();
			getMobileElement("firstFriend").click();
			getMobileElement("addFriendsToDiscussion").click();
			getMobileElement("messageTextField").sendKeys("test تست :( :*");
			getMobileElement("sendMessage").click();
			checkMessageInsideRoom("test تست :( :*");
			break;
		case "withEmoji":
			getMobileElement("newDiscussion").click();
			getMobileElement("firstFriend").click();
			getMobileElement("addFriendsToDiscussion").click();
			getMobileElement("messageTextField").sendKeys("test test😄😀🙂😕☹️😴❓");
			getMobileElement("sendMessage").click();
			waitElementInvisibility("sending");
			checkMessageInsideRoom("test test😄😀🙂😕☹️😴❓");
			break;
		case "googleLink":
			getMobileElement("newDiscussion").click();
			getMobileElement("firstFriend").click();
			getMobileElement("addFriendsToDiscussion").click();
			getMobileElement("messageTextField").sendKeys("https://www.google.com ");
			sleepTime(3);
			isMyElementVisible("urlPreviewImage");
			getMobileElement("sendMessage").click();
			sleepTime(5);
			isElementVisible("baazThumbnail");
			break;
		case "link":
			getMobileElement("newDiscussion").click();
			getMobileElement("firstFriend").click();
			getMobileElement("addFriendsToDiscussion").click();
			fillTextField("messageTextField", message);
			getMobileElement("sendMessage").click();
			sleepTime(5);
			isElementVisible("googleThumbnail");
			break;
		default:
			getMobileElement("newDiscussion").click();
			getMobileElement("firstFriend").click();
			if (platform.equals("Android")) {
				getMobileElement("addFriendsToDiscussion").click();
			}
			if (platform.equals("Android")) {
				fillTextField("messageTextField", message);
			} else {
				getMobileElement("sendMessage").sendKeys("message");
			}
			getMobileElement("sendMessage").click();
			waitElementInvisibility("sending");
			break;
		}

	}

	public void sendToMultiFriends() {
		getMobileElement("newDiscussion").click();
		getMobileElement("firstFriend").click();
		getMobileElement("addFriendsToDiscussion").click();
		fillTextField("messageTextField", "myFriendsText");
		getMobileElement("sendMessage").click();
		sleepTime(2);
		navigateBack();
		getMobileElement("newDiscussion").click();
		getMobileElement("secondFriend").click();
		getMobileElement("addFriendsToDiscussion").click();
		fillTextField("messageTextField", "myFriendsText");
		getMobileElement("sendMessage").click();
		sleepTime(2);
		navigateBack();
		getMobileElement("newDiscussion").click();
		getMobileElement("thirdFriend").click();
		getMobileElement("addFriendsToDiscussion").click();
		fillTextField("messageTextField", "myFriendsText");
		getMobileElement("sendMessage").click();
		sleepTime(2);
		navigateBack();
	}

	public void sendlinkmessage(String link) throws InterruptedException {
		getFirstDiscussion().click();
		getMessageTextField().sendKeys(link);
		getSendMessage().click();
		Thread.sleep(2000);
	}

	public void sendEmojiToFriend() {
		getNewDiscussion().click();
		// getNewDiscussion().click();
		getFirstFriend().click();
		// getAddFriendsToDiscussion().click();
		getMessageTextField().sendKeys("☺️☺️☺️☺️☺️☺️☺️☺️☺️");
		getSendMessage().click();

	}

	public void sendEmojiToGroup() {
		// getNewDiscussion().click();
		// getNewDiscussion().click();
		// getFirstFriend().click();
		// getAddFriendsToDiscussion().click();
		// getFirstDiscussion().click();
		getMessageTextField().sendKeys("☺️☺️☺️☺️☺️☺️☺️☺️☺️");
		getSendMessage().click();

	}

	public void createGroup(String discussionName) throws InterruptedException {
		getMobileElement("newDiscussion").click();
		if (Helper.platform.equalsIgnoreCase("iOS")) {

			getMobileElement("createGroup").click();
			Helper.pullToRefresh();
		}
		getMobileElement("firstFriend").click();
		getMobileElement("secondFriend").click();
		getMobileElement("addFriendsToDiscussion").click();
		fillTextField("discussionName", discussionName);
		getMobileElement("createDiscussion").click();
		sleepTime(5);
	}

	public void createGroupOfFive(String discussionName) throws InterruptedException {
		getMobileElement("newDiscussion").click();
		getMobileElement("firstFriend").click();
		getMobileElement("secondFriend").click();
		getMobileElement("thirdMember").click();
		getMobileElement("fourthMember").click();
		getMobileElement("fifthMember").click();
		getMobileElement("sixthMember").click();
		scrollTo("down", 1);
		getMobileElement("fourthMember").click();
		getMobileElement("fifthMember").click();
		getMobileElement("sixthMember").click();
		getMobileElement("addFriendsToDiscussion").click();
		fillTextField("discussionName", discussionName);
		getMobileElement("createDiscussion").click();
		sleepTime(5);

	}

	public void sendMessage(String message) {
		fillTextField("messageTextField", message);
		getMobileElement("sendMessage").click();
	}

	public void sendMessageInDiscussion(String message) {
		getFirstDiscussion().click();
		getMessageTextField().sendKeys(message);
		getSendMessage().click();
	}

	public String recentMessage() {

		return getRecentMessage().getText().toString();
	}

	public String recentMessagelink() {

		return getRecentMessagelink().getText().toString();

	}

	public String RecentMessageImage() {

		return getRecentMessageImage().getText().toString();

	}

	public String recentGroupMessage() {
		return getRecentGroupMessage().getText().toString();
	}

	public String getRecentMessageRemovemessage() throws InterruptedException {
		return getRecentMessageRemove().getText().toString();
	}

	public String discussionTitle() {
		return getDiscussionTitle().getText().toString().trim();
	}

	public void checkScrolling() throws InterruptedException {
		clickOnElement("firstDiscussion");
		scrollTo("up", 50);
	}

	public void imageCases(String action) throws InterruptedException {
		clickOnElement("firstDiscussion");
		clickOnElement("sentImage");
		switch (action) {
		case "close":
			clickOnElement("removeSuggestedFriend");
			isElementVisible("sendMessage");
			break;
		case "save":
			clickOnElement("imageThreeDots");
			clickOnElement("saveImage");
			allowPermission();
			allowPermission();
			isElementEqualsText("confirmMsg", "photoSaved");
			break;
		case "open":
			isElementVisible("imageThreeDots");
			isElementVisible("removeSuggestedFriend");
			break;
		}
	}

	public void videoCases(String action) throws InterruptedException {
		clickOnElement("firstDiscussion");
		clickOnElement("openVideo");
		clickOnElement("videoPost");
		switch (action) {
		case "close":
			clickOnElement("removeSuggestedFriend");
			isElementVisible("sendMessage");
			break;
		case "save":
			clickOnElement("imageThreeDots");
			clickOnElement("saveImage");
			allowPermission();
			isElementEqualsText("confirmMsg", "photoSaved");
			break;
		case "open":
			isElementVisible("imageThreeDots");
			isElementVisible("removeSuggestedFriend");
			break;

		}
	}

	// get iOS implementation
	public void checkMessageInsideRoom(String message) throws InterruptedException {

		if (platform.equals("iOS")) {
			Helper.getMobileElement("firstDiscussion").click();
			System.out.println(checkMessageInsideRoom().toString().trim());
			System.out.println(message);

			assertEquals(message.trim(), checkMessageInsideRoom().toString().trim());
		} else {
			String Text;
			switch (message) {
			case "test test😄😀🙂😕☹️😴❓":
				Text = message;
				navigateBack();
				break;
			case "test تست :( :*":
				Text = message;
				navigateBack();
				break;

			default:
				Text = getLocator(message);
				break;
			}
			waitElementToBeVisibile("firstDiscussion");
			getMobileElement("firstDiscussion").click();
			java.util.List<MobileElement> myList = new ArrayList();
			myList = getMobileElements("messageInsideRoom");
			MobileElement item = null;
			if (myList != null && !myList.isEmpty()) {
				item = myList.get(myList.size() - 1);
			}
			if (item != null) {
				Assert.assertTrue(item.getText().trim().contains(Text.trim()));
			}
		}

	}

	public void checkUrlPreview() {
		getMobileElement("firstDiscussion").click();
		Assert.assertTrue(getMobileElement("baazThumbnail").isDisplayed());
	}

	public String checkMessageInsideRoom() throws InterruptedException {
		// getFirstDiscussion().click();
		return getMessageInsideRoom().getText().toString();
	}

	public String checkMessageInsideRoomArabic() throws InterruptedException {
		// getFirstDiscussion().click();
		return getMessageInsideRoomArabic().getText().toString();
	}

	public boolean checkStoryPreview() {
		getFirstDiscussion().click();
		return getStoryViewInDiscussion().isDisplayed();
	}

	public void editGroupName(String editedName) {

		getMobileElement("groupInfo").click();
		getMobileElement("changeDiscussionName").click();
		getMobileElement("editedDiscussionName").clear();
		if (platform.equals("iOS")) {

			fillTextField("editedDiscussionName", editedName + "\n");
		} else {
			fillTextField("editedDiscussionName", editedName);
		}
		getMobileElement("editDiscussionName").click();

	}

	public void editGroupImage() {
		if (platform.equals("iOS")) {
			getInfo().click();
			sleepTime(4);
			getgroupImage().click();
			getphoto().click();
			sleepTime(4);
			getcameraAlbum().click();
			getfirstImageforGroup().click();
			getuseCoverPhoto().click();
			getBack().click();
		} else {
			getMobileElement("groupInfo").click();
			getMobileElement("galleryDiscussion").click();
			getMobileElement("allowPermession").click();
			getMobileElement("allowPermession").click();
			getMobileElement("disPhotoLibrary").click();
			getMobileElement("disGallery").click();
			tapOnImage();
			sleepTime(1);
			getMobileElement("cropImage").click();
			sleepTime(6);
		}
	}

	public void tapOnImage() {
		TouchAction touchAction = new TouchAction(Helper.driver);
		sleepTime(2);
		touchAction.tap(PointOption.point(535, 900)).perform();
	}

	public void removeMember() {
		getInfo().click();
		getFirstMember().click();
		getRemoveMember().click();
	}

	public void viewMemberProfile() {
		getMobileElement("groupInfo").click();
		clickOnElement("secondMember");
		clickOnElement("viewProfile");
		isElementVisible("createPost");
	}

	public String checkMemberRemoved() {

		return getLeftDiscussionMessage().getText();
	}

	public void addMemberToGroup(String userName) throws InterruptedException {
		Thread.sleep(2000);
		getInfo().click();
		Thread.sleep(2000);
		getaddMember().click();
		getdiscussionMemberSearch().sendKeys(userName);
		getNewMember().click();
		getDone().click();
		// getInvitePeople().click();

		// getFirstFriend().click();
		// getCreateDiscussion().click();
	}

	public void leaveDiscussion() throws InterruptedException {
		getFirstDiscussion().click();
		getInfo().click();
		getLeaveDiscusion().click();
		getConfirmLeaveDiscussion().click();
		Thread.sleep(2000);
	}

	public void checkGroupSettins() {
		getMobileElement("firstDiscussion").click();
		getMobileElement("groupInfo").click();
		isElementVisible("leaveDiscusion");
		isElementVisible("muteDiscussion");
	}

	public void forwardMessage(String type) throws InterruptedException {
		if (platform.equals("Android")) {
			switch (type) {
			case "image":
				longPress("sentImage");
				break;
			case "video":
				longPress("sentVideo");
				break;
			case "text":
				longPress("messageInsideRoom");
				break;
			case "url":
				longPress("sentURL");
				break;
			case "story":
				longPress("sharedStoryOwner");
				break;
			}
			sleepTime(2);
			getMobileElement("forwardMessage").click();
			getMobileElement("secondDiscussion").click();
			getMobileElement("confirmForward").click();
		} else {
			if (type.equals("message")) {
				Thread.sleep(3000);
				TouchAction action = new TouchAction(Helper.driver);
				int x = getMessageInsideRoom2().getCenter().x;
				int y = getMessageInsideRoom2().getCenter().y;
				action.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
						.release().perform();

			} else {
				Thread.sleep(3000);
				TouchAction action = new TouchAction(Helper.driver);
				int x = getImageInsideRoom().getCenter().x;
				int y = getImageInsideRoom().getCenter().y;
				action.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)))
						.release().perform();
			}

			getShareToDiscussion().click();
			getSecondDiscussion().click();
			getConfirmForward().click();
			Thread.sleep(2000);
			getCloseForward().click();
			Thread.sleep(2000);
		}
	}

	public void copyTextMsg() {
		longPress("messageInsideRoom");
		clickOnElement("copyTxtMsg");
	}

	public void sharePostToDiscussion() throws InterruptedException {
		getShareButton().click();
		getShareToDiscussion().click();
		if (platform.equals("Android")) {
			TouchAction touchAction = new TouchAction(Helper.driver);
			sleepTime(4);
			touchAction.tap(PointOption.point(945, 1635)).perform();
			waitElementToBeVisibile("firstFriend");
			clickOnElement("firstFriend");
			clickOnElement("addFriendsToDiscussion");
			sleepTime(4);
			isMyElementVisible("urlPreviewInsideDiscussion");
		} else {
			getShareButton().click();
			getShareToDiscussion().click();
			getFirstDiscussion().click();
			getConfirmForward().click();
			Thread.sleep(5000);
			isElementVisible("urlPreview");
		}
	}

	public void copyMessage() throws InterruptedException {

		Thread.sleep(3000);
		TouchAction action = new TouchAction(Helper.driver);
		int x = getMessageInsideRoom().getCenter().x;
		int y = getMessageInsideRoom().getCenter().y;
		action.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release()
				.perform();
		getCopy().click();

	}

	public void pastinTextField() throws InterruptedException {
		getSendMessageButton().click();
		TouchAction action = new TouchAction(Helper.driver);
		int x = getMessageTextField().getCenter().x;
		int y = getMessageTextField().getCenter().y;
		action.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release()
				.perform();
		getPaste().click();
		getSendMessage().click();
		Thread.sleep(2000);

	}

	// Mute and unmute for single chat
	public void muteAndUnMuteDiscussion(String muteStatus) throws InterruptedException {
		Thread.sleep(2000);
		if (muteStatus.equals("Mute")) {
			getInfo().click();
			getmute().click();
		} else if (muteStatus.equals("Unmute")) {
			getFirstDiscussion().click();
			getInfo().click();
			getunmute().click();
		}
		getBack().click();
	}

	// Mute and unmute for Groups

	public void muteAndUnMuteDiscussiongroup(String muteStatus) throws InterruptedException {
		Thread.sleep(2000);
		if (muteStatus.equals("Mute")) {
			getInfo().click();
			getmutegroup().click();
		} else if (muteStatus.equals("Unmute")) {
			getFirstDiscussion().click();
			getInfo().click();
			getmutegroup().click();
		}

		getBack().click();
		getBack().click();

	}

	public boolean checkMuteStatus(String muteStatus) {
		boolean status = false;
		navigateBack();
		if (muteStatus.equals("muted")) {
			status = getMuteIcon().isDisplayed();
		}
		if (muteStatus.equals("unmuted")) {
			String locator = Helper.getLocator("muteIcon");
			status = Helper.driver.findElementsById(locator).size() == 0
					&& Helper.driver.findElementsByXPath(locator).size() == 0
					&& Helper.driver.findElementsByAccessibilityId(locator).size() == 0;
		}
		return status;

	}

	public void archiveMessage() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getWidth() / 2;

		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(540, 350)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
				.moveTo(PointOption.point(10, 350)).release().perform();

	}

	public void checkCounters() {
		isElementEqualsText("firstCounter", "1");
		isElementEqualsText("secondCounter", "1");
		isElementEqualsText("thirdCounter", "1");
	}

	public void openFirstDiscussionAndCheckCounter() {
		clickOnElement("firstDiscussion");
		navigateBack();
		waitElementInvisibility("firstCounter");
	}

	public void archiveAllDiscussions() {
		Dimension dim = driver.manage().window().getSize();

		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(540, 350)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
				.moveTo(PointOption.point(10, 350)).release().perform();
		sleepTime(1);
		action.press(PointOption.point(540, 550)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
				.moveTo(PointOption.point(10, 550)).release().perform();
		sleepTime(1);
		action.press(PointOption.point(540, 550)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
				.moveTo(PointOption.point(10, 550)).release().perform();
	}

	public void unArchiveMessage() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getWidth() / 2;

		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(540, 350)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
				.moveTo(PointOption.point(1025, 350)).release().perform();

		if (Helper.platform.equalsIgnoreCase("iOS")) {
			getUnarchivedMessages().click();
		}
	}

	public void unArchiveAllMessages() {
		if (platform.equals("Android")) {
			Dimension dim = driver.manage().window().getSize();

			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(540, 350)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
					.moveTo(PointOption.point(1025, 350)).release().perform();
			sleepTime(1);
			action.press(PointOption.point(540, 550)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
					.moveTo(PointOption.point(1025, 550)).release().perform();
			sleepTime(1);
			action.press(PointOption.point(540, 550)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
					.moveTo(PointOption.point(1025, 550)).release().perform();
		} else// For iOS
		{
			Dimension dim = Helper.driver.manage().window().getSize();
			int startX = (int) (dim.getWidth() * 0.9);
			int startY = (int) (dim.getHeight() * 0.15);
			int endX = (int) (dim.getWidth() * 0.15);
			TouchAction action = new TouchAction(Helper.driver);
			action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
					.moveTo(PointOption.point(endX, startY)).release().perform();
			action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
					.moveTo(PointOption.point(endX, startY)).release().perform();
		}
	}

	public boolean discussionArchived() {
		return getArchivedMessages().isDisplayed();
	}

	public void discussionInArchived() throws InterruptedException {
		clickOnElement("groupInfo");
		clickOnElement("archivedMessages");
		waitElementInvisibility("trendingErrorMessage");
		isElementVisible("firstDiscussion");

	}

	public void removeArchivedMessage() {
		longPress("firstDiscussion");
		waitElementToBeVisibile("deleteMessage");
		clickOnElement("deleteMessage");
		clickOnElement("confirmDeleteDiscussion");
		waitElementInvisibility("trendingErrorMessage");
		waitElementInvisibility("firstDiscussion");
	}

	public void longPressMsgOptions(String action) {
		navigateBack();
		longPress("firstDiscussion");
		switch (action) {
		case "mute":
			clickOnElement("muteConversationList");
			isElementVisible("muteIcon");
			break;

		case "archive":
			clickOnElement("archiveConversationList");
			isElementVisible("archived");
			break;
		}
	}

	public boolean archiveDicussionCounter() {

		return getArchiveCounter().isDisplayed();

	}

	public String archiveCounter() {

		return getThreadCounter().getText().toString().trim();

	}

	public boolean archiveCounterZero() {

		if (getThreadCounter().getSize().equals(0)) {
			return true;
		}
		return true;

	}

	public void viewFriendProfile() {
		clickOnElement("friendProfile");
		sleepTime(2);
		isElementVisible("userProfileLayout");
	}

	public void checkNoDiscussionsNoFriends() {
		isElementVisible("noDiscussionsLabel");
		clickOnElement("createNewDiscussion");
		sleepTime(1);
		isElementVisible("noFriendsLabel");
	}

	public void checkDiscussionInArchived() {
		getArchivedMessages().click();
		getFirstDiscussion().click();
		getBackFromDiscussionRoom().click();
	}

	public boolean deleteDiscussion() throws InterruptedException {
		getArchivedMessages().click();
		Thread.sleep(2000);
		if (Helper.platform.equalsIgnoreCase("Android")) {
			Dimension dim = Helper.driver.manage().window().getSize();
			int startX = (int) (dim.getWidth() * 0.9);
			int startY = (int) (dim.getHeight() * 0.15);
			int endX = (int) (dim.getWidth() * 0.11);
			TouchAction action = new TouchAction(Helper.driver);
			action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
					.moveTo(PointOption.point(endX, startY)).release().perform();
		} else {
			Dimension dim = Helper.driver.manage().window().getSize();
			int startX = (int) (dim.getWidth());
			int startY = (int) (dim.getHeight() * 0.15);
			int endX = (int) (dim.getWidth() * 0.67);
			TouchAction action = new TouchAction(Helper.driver);
			action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
					.moveTo(PointOption.point(endX, startY)).release().perform();
			Thread.sleep(2000);
			// the following action to delete the message
			action.press(PointOption.point(194, 135)).release().perform();
		}
		Thread.sleep(1000);

		return getNoDiscussion().isDisplayed();

	}

	public boolean shareStoryToDiscussion() throws InterruptedException {
		if (platform.equals("Android")) {
			scrollTo("down", 2);
			getMobileElement("shareStory").click();
			getMobileElement("shareToDiscussion").click();
			getMobileElement("createDiscussionShared").click();
			getMobileElement("firstFriend").click();
			getMobileElement("addFriendsToDiscussion").click();
			sleepTime(4);
			return getMobileElement("storyViewInDiscussion").isDisplayed();
		} else {
			getShareStory().click();
			getShareToDiscussion().click();
			getFirstDiscussion().click();
			getConfirmForward().click();
			Thread.sleep(4000);
			return getStoryViewInDiscussion().isDisplayed();
		}
	}

	public boolean shareStoryToDiscussionFromDetailed() throws InterruptedException {
		if (Helper.platform.equalsIgnoreCase("Android")) {
			getStoryView().click();
			getShareFromDetailed().click();
			getShareToDiscussion().click();
			getCreateDiscussionShared().click();
			getFirstFriend().click();
			getAddFriendsToDiscussion().click();
			Thread.sleep(4000);
		} else {

			getStoryView().click();
			getShareFromDetailed().click();
			getShareToDiscussion().click();
			getFirstDiscussion().click();
			getConfirmForward().click();

		}
		return getStoryViewInDiscussion().isDisplayed();
	}

	public boolean shareStoryToDiscussionFromMoreIcon() throws InterruptedException {
		getStoryView().click();
		getMoreIcon().click();
		getShareFromDetailed().click();
		getShareToDiscussion().click();
		getCreateDiscussionShared().click();
		getFirstFriend().click();
		getAddFriendsToDiscussion().click();
		Thread.sleep(4000);
		return getStoryViewInDiscussion().isDisplayed();
	}

	public boolean SendMessageToBlockedUser() throws InterruptedException {
		getFirstDiscussion().click();
		getMessageTextField().sendKeys("test");
		getSendMessage().click();
		Thread.sleep(2000);
		getresend().click();
		Thread.sleep(2000);
		// return getDiscussionErrorMessage().isDisplayed();
		return getresend().isDisplayed();
	}

	public void dontGivePermession() {
		getMobileElement("newDiscussion").click();
		getMobileElement("firstFriend").click();
		getMobileElement("addFriendsToDiscussion").click();
		getMobileElement("messageTextField").sendKeys("Hello Team");
		getMobileElement("sendMessage").click();
		tapOnCameraIcon();
		clickOnElement("denyPermession");
		clickOnElement("denyPermession");
		isElementContainstext("trendingErrorMessage", "unableToOpenCamera");
	}

	public void toSend() {
		getMobileElement("newDiscussion").click();
		getMobileElement("firstFriend").click();
		getMobileElement("addFriendsToDiscussion").click();
		getMobileElement("messageTextField").sendKeys("Hello Team");
		getMobileElement("sendMessage").click();
		tapOnCameraIcon();
		getMobileElement("allowPermession").click();
		getMobileElement("allowPermession").click();
		getMobileElement("chooseFromLibrary").click();
	}

	public void sendImageToFriend(String imageType) throws InterruptedException {
		toSend();
		switch (imageType) {
		case "Png":
			getMobileElement("jpgAlbum").click();
			getMobileElement("firstImage").click();
			getMobileElement("uploadImage").click();
			getMobileElement("sendMessage").click();
			waitElementInvisibility("sending");
			navigateBack();
			isElementContainstext("recentMessage", "sentYouAPhoto");
			break;
		case "Jpg":
			getMobileElement("jpgAlbum").click();
			getMobileElement("secondImage").click();
			getMobileElement("uploadImage").click();
			getMobileElement("sendMessage").click();
			waitElementInvisibility("sending");
			navigateBack();
			isElementContainstext("recentMessage", "sentYouAPhoto");
			break;
		case "Mp4":
			getMobileElement("videoAlbum").click();
			getMobileElement("jpgAlbum").click();
			getMobileElement("firstImage").click();
			getMobileElement("uploadImage").click();
			getMobileElement("sendMessage").click();
			waitElementInvisibility("sending");
			navigateBack();
			isElementContainstext("recentMessage", "sentYouAVideo");
			break;
		}
	}

	public void sendMultiImages() {
		toSend();
		clickOnElement("jpgAlbum");
		clickOnElement("firstImage");
		clickOnElement("secondImage");
		clickOnElement("thirdImage");
		clickOnElement("fourthImage");
		clickOnElement("fifthImage");
		clickOnElement("sixthImage");
		clickOnElement("seventhImage");
		clickOnElement("eightthImage");
		clickOnElement("ninethImage");
		clickOnElement("tenthImage");
		clickOnElement("uploadImage");
		clickOnElement("sendMessage");
		waitElementInvisibility("sending");
		navigateBack();
		Assert.assertTrue(getMobileElement("recentMessage").getText().contains("Image"));
	}

	public void tapOnCameraIcon() {
		TouchAction touchAction = new TouchAction(Helper.driver);
		sleepTime(2);
		touchAction.tap(PointOption.point(77, 1680)).perform();
	}

	public void sendTakenMedia(int num, String type) throws InterruptedException {
		getMobileElement("newDiscussion").click();
		getMobileElement("firstFriend").click();
		getMobileElement("addFriendsToDiscussion").click();
		switch (type) {
		case "image":
			for (int i = 0; i < num; i++) {
				tapOnCameraIcon();
				sleepTime(2);
				Helper.allowPermission();
				sleepTime(5);
				Helper.allowPermission();
				getMobileElement("takePhoto").click();
				sleepTime(5);
				getMobileElement("shutterButton").click();
				sleepTime(2);
				getMobileElement("doneCaptureButton").click();
				sleepTime(1);
			}
			break;

		case "video":
			tapOnCameraIcon();
			Helper.allowPermission();
			Helper.allowPermission();
			getMobileElement("takeVideo").click();
			getMobileElement("shutterButton").click();
			sleepTime(5);
			getMobileElement("shutterButton").click();
			getMobileElement("doneCaptureButton").click();
			sleepTime(4);
			break;
		}

	}

	public void deleteBeforeSending(String mediaType) {
		getMobileElement("newDiscussion").click();
		getMobileElement("firstFriend").click();
		getMobileElement("addFriendsToDiscussion").click();
		getMobileElement("messageTextField").sendKeys("Hello Team");
		getMobileElement("sendMessage").click();
		tapOnCameraIcon();
		getMobileElement("allowPermession").click();
		getMobileElement("allowPermession").click();
		getMobileElement("chooseFromLibrary").click();
		if (mediaType.equalsIgnoreCase("imageBeforeSending") || mediaType.equalsIgnoreCase("imageFromField")) {
			getMobileElement("jpgAlbum").click();
		} else if (mediaType.equalsIgnoreCase("videoBeforeSending") || mediaType.equalsIgnoreCase("videoFromField")) {
			getMobileElement("videoAlbum").click();
			getMobileElement("jpgAlbum").click();
		}
		getMobileElement("firstImage").click();
		getMobileElement("uploadImage").click();
		sleepTime(1);
		switch (mediaType) {
		case "imageFromField":
			clickOnElement("removeFromMsgField");
			isElementVisible("takeVideo");
			break;
		case "videoFromField":
			clickOnElement("removeFromMsgField");
			isElementVisible("takePhoto");
			break;
		}
	}

	// Send Files (image and video to friend)
	// iOS
	public void getSendfile(String type, String where) throws InterruptedException {

		if (type.equals("Image")) {
			if (where.equals("Friend")) {
				SendImagetoFriend();
			} else {
				if (where.equals("Group")) {
					SendImagetoGroup();
				} else {
					SendImageforforward();
				}
			}

		} else if (type.equals("Video")) {
			if (where.equals("Friend")) {
				SendVideoToFriend();
			} else {
				if (where.equals("Group")) {
					SendVideoToGroup();
				} else {
					SendVideoforforward();
				}
			}
		}
	}

	private void SendImagetoFriend() throws InterruptedException {

		getNewDiscussion().click();
		getFirstFriend().click();
		getUpload().click();
		getphoto().click();
		Thread.sleep(2000);
		getallowGallery().click();
		Thread.sleep(3000);
		getfirstAlbum().click();
		getfirstImage().click();
		getDone().click();
		getSendMessage().click();
		Thread.sleep(30000);
	}

	private void SendImagetoGroup() throws InterruptedException {

		getUpload().click();
		getphoto().click();
		Thread.sleep(3000);
		getfirstAlbum().click();
		getfirstImage().click();
		getDone().click();
		getSendMessage().click();
		Thread.sleep(30000);
	}

	private void SendImageforforward() throws InterruptedException {

		getSendMessageButton().click();
		getUpload().click();
		getphoto().click();
		Thread.sleep(2000);
		getallowGallery().click();
		Thread.sleep(3000);
		getfirstAlbum().click();
		getfirstImage().click();
		getDone().click();
		getSendMessage().click();
		Thread.sleep(30000);
	}

	private void SendVideoToFriend() throws InterruptedException {

		getNewDiscussion().click();
		getFirstFriend().click();
		getUpload().click();
		getvideo().click();
		Thread.sleep(2000);
		getallowGallery().click();
		Thread.sleep(2000);
		getfirstAlbum().click();
		getfirstImage().click();
		// getDone().click();
		getSendMessage().click();
		Thread.sleep(30000);
	}

	private void SendVideoToGroup() throws InterruptedException {

		getUpload().click();
		getvideo().click();
		Thread.sleep(2000);
		getfirstAlbum().click();
		getfirstImage().click();
		// getDone().click();
		getSendMessage().click();
		Thread.sleep(30000);
	}

	private void SendVideoforforward() throws InterruptedException {

		getSendMessageButton().click();
		getUpload().click();
		getvideo().click();
		Thread.sleep(2000);
		getallowGallery().click();
		Thread.sleep(2000);
		getfirstAlbum().click();
		getfirstImage().click();
		// getDone().click();
		getSendMessage().click();
		Thread.sleep(30000);
	}

	public boolean OpenImage() throws InterruptedException {
		getImageInsideRoom().click();
		assertTrue(getCloseImage().isDisplayed() && getThreedotImage().isDisplayed());
		getThreedotImage().click();
		getSave().click();
		Thread.sleep(3000);
		assertTrue(getSaved().isDisplayed());
		getallowGallery().click();
		getCloseImage().click();
		return true;
	}

	public boolean OpenVideo() throws InterruptedException {
		getImageInsideRoom().click();
		getplayer().click();
		assertTrue(getCloseVideo().isDisplayed());
		assertTrue(getVideoZoom().isDisplayed());
		getCloseVideo().click();
		getBack().click();
		return true;
	}

	public void getBaazline() throws InterruptedException {
		getbaazline().click();
	}

	public boolean deleteSingelChat() throws InterruptedException {
		getInfo().click();
		getdeletesingelchat().click();
		Thread.sleep(2000);
		return getNoDiscussion().isDisplayed();
	}

	public boolean removeImageandvideo() throws InterruptedException {
		// for remove image
		getNewDiscussion().click();
		getFirstFriend().click();
		getUpload().click();
		getphoto().click();
		Thread.sleep(2000);
		getallowGallery().click();
		Thread.sleep(3000);
		getfirstAlbum().click();
		getfirstImage().click();
		getDone().click();
		getremoveImage().click();

		// for remove video
		getUpload().click();
		getvideo().click();
		getfirstAlbum().click();
		getfirstImage().click();
		getremoveImage().click();
		Thread.sleep(3000);
		return true;
	}

	public String Counter(String counterType) throws InterruptedException {
		Thread.sleep(2000);
		if (counterType.equals("mainthread")) {
			return getmainCounter().getText().toString().trim();
		} else {
			return getThreadCounter().getText().toString().trim();
		}

	}

	public boolean CounterResetMain() {
		getBack().click();
		if (getmainCounter().getText().toString().trim().equals(null)
				|| getmainCounter().getText().toString().trim().equals("0")) {

		}
		return true;
	}

	public boolean CounterResetThread() {
		getBack();
		if (getThreadCounter().getSize().equals(0)) {

		}
		return true;

	}

	public boolean Checkseperator() {
		return getSeperator().isDisplayed() && getSeperator().getText().toString().contains("1 Unread Message");

	}

	public boolean CheckseperatorNotExist() {
		getBack().click();
		return getSeperator().getSize().equals(0);

	}

	public void UrlPreviewInsideDiscussion(String link) throws InterruptedException {
		getNewDiscussion().click();
		getFirstFriend().click();
		getMessageTextField().sendKeys(link);
		Thread.sleep(4000);
		assertTrue(getUrlPreviewInsideDiscussion().isDisplayed());
	}

	public String Checkuseradmin() {
		getInfo().click();
		return getAdmin().getText().toString().trim();
	}

	// Elements
	public MobileElement getallowGallery() {
		return Helper.getMobileElement("allowGallery");

	}

	public MobileElement getphoto() {
		return Helper.getMobileElement("photo");

	}

	public MobileElement getvideo() {
		return Helper.getMobileElement("video");

	}

	public MobileElement getfirstAlbum() {
		return Helper.getMobileElement("firstAlbum");

	}

	public MobileElement getfirstImage() {
		return Helper.getMobileElement("firstImage");

	}

	public MobileElement getChooseFromLibrary() {
		return Helper.getMobileElement("chooseFromLibrary");

	}

	public MobileElement getAllowPermession() {
		return Helper.getMobileElement("allowPermession");

	}

	public MobileElement getCameraIcon() {
		return Helper.getMobileElement("cameraIcon");

	}

	public MobileElement getVideoAlbum() {
		return Helper.getMobileElement("videoAlbum");

	}

	public MobileElement getJpgAlbum() {
		return Helper.getMobileElement("jpgAlbum");

	}

	public MobileElement getMp4Album() {
		return Helper.getMobileElement("mp4Album");

	}

	public MobileElement getPngAlbum() {
		return Helper.getMobileElement("pngAlbum");

	}

	public MobileElement getGifAlbum() {
		return Helper.getMobileElement("gifAlbum");

	}

	public MobileElement getFirstImage() {
		return Helper.getMobileElement("firstImage");

	}

	public MobileElement getfirstImageforGroup() {
		return Helper.getMobileElement("firstImageforGroup");

	}

	public MobileElement getUploadImage() {
		return Helper.getMobileElement("uploadImage");

	}

	public MobileElement getSendMessageButton() {
		return Helper.getMobileElement("sendMessageButton");

	}

	public MobileElement getMessageTextField() {
		return Helper.getMobileElement("messageTextField");

	}

	public MobileElement getSendMessage() {
		return Helper.getMobileElement("sendMessage");

	}

	public MobileElement getRecentMessage() {
		return Helper.getMobileElement("recentMessage");

	}

	public MobileElement getDiscussionTitle() {
		return Helper.getMobileElement("discussionTitle");

	}

	public MobileElement getFirstDiscussion() {
		return Helper.getMobileElement("firstDiscussion");

	}

	public MobileElement getMessageInsideRoom() {
		return Helper.getMobileElement("messageInsideRoom");

	}

	public MobileElement getMessageInsideRoom2() {
		return Helper.getMobileElement("messageInsideRoom2");

	}

	public MobileElement getMessageInsideRoomArabic() {
		return Helper.getMobileElement("messageInsideRoomArabic");

	}

	public MobileElement getNewDiscussion() {
		return Helper.getMobileElement("newDiscussion");

	}

	public MobileElement getFirstFriend() {
		return Helper.getMobileElement("firstFriend");

	}

	public MobileElement getaddMember() {
		return Helper.getMobileElement("AddMember");

	}

	public MobileElement getNewMember() {
		return Helper.getMobileElement("addNewMember");

	}

	public MobileElement getAddFriendsToDiscussion() {
		return Helper.getMobileElement("addFriendsToDiscussion");

	}

	public MobileElement getUrlPreview() {
		return Helper.getMobileElement("urlPreview");

	}

	public MobileElement getSecondFriend() {
		return Helper.getMobileElement("secondFriend");

	}

	public MobileElement getDiscussionName() {
		return Helper.getMobileElement("discussionName");

	}

	public MobileElement getCreateDiscussion() {
		return Helper.getMobileElement("createDiscussion");

	}

	public MobileElement getRecentGroupMessage() {
		return Helper.getMobileElement("recentGroupMessage");

	}

	public MobileElement getInfo() {
		return Helper.getMobileElement("groupInfo");

	}

	public MobileElement getChangeDiscussionName() {
		return Helper.getMobileElement("changeDiscussionName");

	}

	public MobileElement getEditedDiscussionTextField() {
		return Helper.getMobileElement("editedDiscussionName");

	}

	public MobileElement getEditDiscussionName() {
		return Helper.getMobileElement("editDiscussionName");

	}

	public MobileElement getFirstMember() {
		return Helper.getMobileElement("firstMember");

	}

	public MobileElement getRemoveMember() {
		return Helper.getMobileElement("removeMember");

	}

	public MobileElement getLeftDiscussionMessage() {
		return Helper.getMobileElement("leftDiscussionMessage");

	}

	public MobileElement getInvitePeople() {
		return Helper.getMobileElement("invitePeople");

	}

	public MobileElement getChooseFriendTextField() {
		return Helper.getMobileElement("chooseFriendTextField");

	}

	public MobileElement getdiscussionMemberSearch() {
		return Helper.getMobileElement("discussionMemberSearch");

	}

	public MobileElement getLeaveDiscusion() {
		return Helper.getMobileElement("leaveDiscusion");

	}

	public MobileElement getConfirmLeaveDiscussion() {
		return Helper.getMobileElement("confirmLeaveDiscussion");

	}

	public MobileElement getForwardMessage() {
		return Helper.getMobileElement("forwardMessage");

	}

	public MobileElement getSecondDiscussion() {
		return Helper.getMobileElement("secondDiscussion");

	}

	public MobileElement getConfirmForward() {
		return Helper.getMobileElement("confirmForward");

	}

	public MobileElement getShareButton() {
		return Helper.getMobileElement("shareButton");

	}

	public MobileElement getShareToDiscussion() {
		return Helper.getMobileElement("shareToDiscussion");

	}

	public MobileElement getCreateDiscussionShared() {
		return Helper.getMobileElement("createDiscussionShared");

	}

	public MobileElement getUrlPreviewInsideDiscussion() {
		return Helper.getMobileElement("urlPreviewInsideDiscussion");

	}

	public MobileElement getMuteDiscussion() {
		return Helper.getMobileElement("muteDiscussion");

	}

	public MobileElement getConfirmMute() {
		return Helper.getMobileElement("confirmMute");

	}

	public MobileElement getBackFromDiscussionInfo() {
		return Helper.getMobileElement("backFromDiscussionInfo");

	}

	public MobileElement getBackFromDiscussionRoom() {
		return Helper.getMobileElement("backFromDiscussionRoom");

	}

	public MobileElement getMuteIcon() {
		return Helper.getMobileElement("muteIcon");

	}

	public MobileElement getUnMuteDiscussion() {
		return Helper.getMobileElement("unMuteDiscussion");

	}

	public MobileElement getConfirmUnMute() {
		return Helper.getMobileElement("confirmUnMute");

	}

	public MobileElement getNoDiscussion() {
		return Helper.getMobileElement("noDiscussion");

	}

	public MobileElement getArchivedMessages() {
		return Helper.getMobileElement("archivedMessages");

	}

	public MobileElement getUnarchivedMessages() {
		return Helper.getMobileElement("unarchivedMessages");

	}

	public MobileElement getDeleteMessage() {
		return Helper.getMobileElement("deleteMessage");

	}

	public MobileElement getdeletesingelchat() {
		return Helper.getMobileElement("deletesingelchat");

	}

	public MobileElement getConfirmDeleteDiscussion() {
		return Helper.getMobileElement("confirmDeleteDiscussion");

	}

	public MobileElement getShareStory() {
		return Helper.getMobileElement("shareStory");
	}

	public MobileElement getStoryViewInDiscussion() {
		return Helper.getMobileElement("storyViewInDiscussion");
	}

	public MobileElement getStoryView() {
		return Helper.getMobileElement("storyView");
	}

	public MobileElement getShareFromDetailed() {
		return Helper.getMobileElement("shareFromDetailed");
	}

	public MobileElement getMoreIcon() {
		return Helper.getMobileElement("moreIcon");
	}

	public MobileElement getDiscussionErrorMessage() {
		return Helper.getMobileElement("discussionErrorMessage");
	}

	public MobileElement getMessageStatus() {
		return Helper.getMobileElement("messageStatus");
	}

	public MobileElement getCreateGroup() {
		return Helper.getMobileElement("createGroup");
	}

	public MobileElement getRecentMessagelink() {
		return Helper.getMobileElement("recentMessageLink");
	}

	public RemoteWebElement getRecentMessageRemove() {

		return Helper.getMobileElement("recentMessageRemove");
	}

	public RemoteWebElement getDone() {

		return Helper.getMobileElement("done");
	}

	public MobileElement getBack() {

		return Helper.getMobileElement("back");
	}

	public MobileElement getCloseForward() {
		return Helper.getMobileElement("closeMessage");
	}

	public MobileElement getbaazline() {
		return Helper.getMobileElement("baazline");
	}

	public MobileElement getmute() {
		return Helper.getMobileElement("mute");
	}

	public MobileElement getunmute() {
		return Helper.getMobileElement("unmute");
	}

	public MobileElement getmutegroup() {
		return Helper.getMobileElement("muteGroup");
	}

	public MobileElement getresend() {
		return Helper.getMobileElement("resend");
	}

	public MobileElement getUpload() {
		return Helper.getMobileElement("Upload");
	}

	public MobileElement getremoveImage() {
		return Helper.getMobileElement("removeImage");
	}

	public MobileElement getRecentMessageImage() {
		return Helper.getMobileElement("Imagerecent");
	}

	public MobileElement getfollowed() {
		return Helper.getMobileElement("followedTab");
	}

	public MobileElement getstoryMessage() {
		return Helper.getMobileElement("storyMessage");
	}

	public MobileElement getcameraAlbum() {
		return Helper.getMobileElement("cameraAlbum");
	}

	public MobileElement getgroupImage() {
		return Helper.getMobileElement("groupImage");
	}

	public MobileElement getmainGroupImage() {
		return Helper.getMobileElement("mainGroupImage");
	}

	public MobileElement getuseCoverPhoto() {
		return Helper.getMobileElement("useCoverPhoto");
	}

	public MobileElement getImageInsideRoom() {
		return Helper.getMobileElement("ImageInsideRoom");
	}

	public MobileElement getCopy() {
		return Helper.getMobileElement("copy");
	}

	public MobileElement getPaste() {
		return Helper.getMobileElement("paste");
	}

	public MobileElement getmainCounter() {
		return Helper.getMobileElement("mainCounter");
	}

	public MobileElement getThreadCounter() {
		return Helper.getMobileElement("ThreadCounter");
	}

	public MobileElement getArchiveCounter() {
		return Helper.getMobileElement("Archive");
	}

	public MobileElement getSeperator() {
		return Helper.getMobileElement("seperator");
	}

	public MobileElement getCloseImage() {
		return Helper.getMobileElement("closeImage");
	}

	public MobileElement getThreedotImage() {
		return Helper.getMobileElement("threedotImage");
	}

	public MobileElement getSave() {
		return Helper.getMobileElement("save");
	}

	public MobileElement getClose() {
		return Helper.getMobileElement("close");
	}

	public MobileElement getSaved() {
		return Helper.getMobileElement("saved");
	}

	public MobileElement getCloseVideo() {
		return Helper.getMobileElement("closeVideo");
	}

	public MobileElement getVideoZoom() {
		return Helper.getMobileElement("videoZoom");
	}

	public MobileElement getplayer() {
		return Helper.getMobileElement("player");
	}

	public MobileElement getAdmin() {
		return Helper.getMobileElement("adminLabel");
	}

}
