package Baaz.Mobile.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import Baaz.Mobile.common.Helper;
import Baaz.Mobile.common.StateHelper;
import Baaz.Mobile.pages.DiscussionPage;

public class DiscussionSteps {

	DiscussionPage discussionPage = new DiscussionPage();

	@Then("Send $message message to non friend")
	@When("Send $message message to non friend")
	public void sendMessageToNonFriend(String message) throws InterruptedException {
		discussionPage.sendMessageToNonFriend(message);
	}

	@When("Copy messsage")
	@Then("Copy messsage")
	public void copyMessage() throws InterruptedException {
		discussionPage.copyMessage();
	}

	@When("Paste messsage and send it")
	@Then("Paste messsage and send it")
	public void PasteMessage() throws InterruptedException {
		discussionPage.pastinTextField();

	}

	@Then("Check if recent message equal $recentMessage and discussion title contains $discussionTitle")
	@When("Check if recent message equal $recentMessage and discussion title contains $discussionTitle")
	public void checkRecentMessage(String recentMessage, String discussionTitle) {
		discussionPage.checkRecentMsgAndTitle(recentMessage, discussionTitle);
	}

	@When("Sends $files to $Friend")
	@Then("Sends $files to $Friend")
	public void getSendImage(String type, String Where) throws InterruptedException {
		if (Helper.platform.equalsIgnoreCase("Android")) {
			discussionPage.sendImageToFriend(type);
		} else {
			discussionPage.getSendfile(type, Where);
		}
	}

	@Then("Open $type")
	public void openImage(String type) throws InterruptedException {
		if (type.contains("Image")) {
			assertTrue(discussionPage.OpenImage());
		} else {
			discussionPage.OpenVideo();

		}
	}

	@Then("Delete image or video before Send")
	public void getRemoveImageandvideo() throws InterruptedException {
		discussionPage.removeImageandvideo();

	}

	@Then("I navigate to baazline")
	@When("I navigate to baazline")

	public void getBaazline() throws InterruptedException {
		discussionPage.getBaazline();
	}

	@Then("Check if recent message contains $recentMessage and discussion title contains $discussionTitle")
	@When("Check if recent message contains $recentMessage and discussion title contains $discussionTitle")
	public void checkRecentMessageContains(String recentMessage, String discussionTitle) {

		// For Android
		if (Helper.platform.equalsIgnoreCase("Android")) {
			assertEquals(recentMessage.trim(), discussionPage.recentMessage().toString().trim());
			if (discussionTitle.contains("user")) {
				discussionTitle = StateHelper.getStepState(discussionTitle).toString();
			}
			assertTrue(discussionPage.discussionTitle().contains(discussionTitle));
		}
		// For iOS
		else if (Helper.platform.equalsIgnoreCase("iOS")) {

			if (recentMessage.contains(".com")) {
				int link_recentlength = discussionPage.recentMessagelink().toString().length();
				// String link_recent=discussionPage.recentMessagelink().toString().trim();
				System.out.println(link_recentlength);
				// System.out.println(link_recent);
				System.out.println(recentMessage);
				assertTrue((discussionPage.recentMessagelink().toString().trim().substring(1, link_recentlength - 2))
						.contains(recentMessage.trim()));

				if (discussionTitle.contains("user")) {
					discussionTitle = StateHelper.getStepState(discussionTitle).toString().trim();
				}
				assertTrue(discussionPage.discussionTitle().contains(discussionTitle));
			} else {
				int length = discussionPage.recentMessage().toString().length();
				System.out.println(length);
				System.out.println(discussionPage.recentMessage().toString().trim());
				System.out.println(recentMessage);
				assertEquals(recentMessage.trim(),
						discussionPage.recentMessage().toString().trim().substring(1, length));
				if (discussionTitle.contains("user")) {
					discussionTitle = StateHelper.getStepState(discussionTitle).toString();
				}
				assertTrue(discussionPage.discussionTitle().contains(discussionTitle));
			}
		}
	}

	@Then("Check if recent group message equal $recentMessage and discussion title equal $discussionTitle")
	@When("Check if recent group message equal $recentMessage and discussion title equal $discussionTitle")
	public void checkGroupRecentMessage(String recentMessage, String discussionTitle) {

		if (recentMessage.contains("user")) {
			recentMessage = StateHelper.getStepState(recentMessage).toString();
		}
		System.out.println(recentMessage);
		System.out.println(recentMessage.length());
		System.out.println(discussionPage.recentGroupMessage().toString().trim());
		System.out.println(discussionPage.recentGroupMessage().toString().length());
		assertTrue(discussionPage.recentGroupMessage().toString().trim().contains(recentMessage));

		if (discussionTitle.contains("user")) {
			discussionTitle = StateHelper.getStepState(discussionTitle).toString();
		}
		System.out.println(recentMessage);
		System.out.println(discussionPage.discussionTitle());
		assertEquals(discussionTitle, discussionPage.discussionTitle());
	}

	@Then("Check if recent group message contains $recentMessage and discussion title equal $discussionTitle")
	@When("Check if recent group message contains $recentMessage and discussion title equal $discussionTitle")
	public void checkGroupRecentMessage2(String recentMessage, String discussionTitle) {
		assertTrue(discussionPage.recentGroupMessage().contains(recentMessage));
		assertEquals(discussionTitle, discussionPage.discussionTitle());
	}

	@When("Check if discussion title equal $discussionTitle")
	@Then("Check if discussion title equal $discussionTitle")
	public void checkDiscussionTitle(String discussionTitle) {
		assertEquals(discussionTitle, discussionPage.discussionTitle());
	}

	@Then("Check message inside room equal $message")
	public void checkMessageInsideRoom(String message) throws InterruptedException {
		discussionPage.checkMessageInsideRoom(message);
	}

	@When("arabic message inside room is $messageinarabic")
	@Then("arabic message inside room is $messageinarabic")
	public void checkMessageInsideRoomArabic(String messageinarabic) throws InterruptedException {
		Helper.getMobileElement("firstDiscussion").click();
		Thread.sleep(5000);
		// System.out.println(discussionPage.checkMessageInsideRoomArabic().toString().trim());
		System.out.println(discussionPage.checkMessageInsideRoomArabic().toString().length());
		System.out.println(messageinarabic.length());

		assertEquals(messageinarabic.trim(), discussionPage.checkMessageInsideRoomArabic().toString().trim());
	}

	@Then("Send $message message to friend")
	@When("Send $message message to friend")
	public void sendMessageToFriend(String message) throws InterruptedException {
		discussionPage.sendMessageToFriend(message);
	}

	@Then("Check Scrolling inside room")
	@When("Check Scrolling inside room")
	public void checkScrolling() throws InterruptedException {
		discussionPage.checkScrolling();

	}

	@Then("User check $action Image")
	@When("User check $action Image")
	public void imageCases(String action) throws InterruptedException {
		discussionPage.imageCases(action);
	}

	@Then("User check $action Video")
	@When("User check $action Video")
	public void videoCases(String action) throws InterruptedException {
		discussionPage.videoCases(action);
	}

	@Then("Send messages to multi friends")
	@When("Send messages to multi friends")
	public void sendToMultiFriends() {
		discussionPage.sendToMultiFriends();
	}

	@Then("Send Emoji to $value")
	@When("Send Emoji to $value")
	public void sendEmoji(String value) {
		if (value.equals("friend")) {
			discussionPage.sendEmojiToFriend();
		} else
			discussionPage.sendEmojiToGroup();
	}

	@Then("Check if user2 receive $emoji")
	public void CheckEmoji(String emoji) {
		int length = discussionPage.recentMessage().toString().length();
		System.out.println(discussionPage.recentMessage().toString().trim().substring(0, length));
		System.out.println(length);

		System.out.println(emoji.length());
		assertEquals(emoji, discussionPage.recentMessage().toString().trim().substring(1, length));

	}

	@Then("Check group message is $emoji")
	public void CheckEmojiGroup(String emoji) {
		int length = discussionPage.recentMessage().toString().length();
		System.out.println(discussionPage.recentMessage().toString().trim().substring(0, length));
		System.out.println(length);
		System.out.println(emoji.length());
		String actual = discussionPage.recentMessage().toString().trim().substring(1, length);
		assertTrue(actual.contains(emoji));

	}

	@Then("Check url preview in discusison")
	@When("Check url preview in discusison")
	public void checkURLPreview() throws InterruptedException {
		discussionPage.checkUrlPreview();
	}

	@Then("Type $link and Check url preview")
	public void checkURLPreviewinDisucssion(String link) throws InterruptedException {
		discussionPage.UrlPreviewInsideDiscussion(link);

	}

	@Then("Check story preview in discusison")
	@When("Check story preview in discusison")
	public void checkStoryPreview() {
		assertTrue(discussionPage.checkStoryPreview());
	}

	@Then("Create group discussion with title $groupTitle")
	@When("Create group discussion with title $groupTitle")
	public void createGroup(String groupTitle) throws InterruptedException {
		discussionPage.createGroup(groupTitle);
	}

	@Then("Check if user1 admin")
	public void checkAdmin() {

		assertTrue(discussionPage.Checkuseradmin().contains("ADMIN"));
	}

	@Then("Create group discussion of 10 members with title $groupTitle")
	@When("Create group discussion of 10 members with title $groupTitle")
	public void createGroupOfFive(String discussionName) throws InterruptedException {
		discussionPage.createGroupOfFive(discussionName);
	}

	@When("Send message $message")
	@Then("Send message $message")
	public void sendMessage(String message) {
		discussionPage.sendMessage(message);
	}

	@When("Send Link $link to Group")
	@Then("Send Link $link to Group")
	public void sendlinkmessage(String link) throws InterruptedException {
		discussionPage.sendlinkmessage(link);
	}

	@Then("Edit group name to $editedName")
	@When("Edit group name to $editedName")
	public void editGroupName(String editedName) {
		discussionPage.editGroupName(editedName);
	}

	@Then("Edit group picture")
	public void editGroupImage() throws InterruptedException {
		discussionPage.editGroupImage();

	}

	@Then("Edit group Image")
	@When("Edit group Image")
	public void editGroupImage2() {
		discussionPage.editGroupImage();
	}

	@Then("Remove member from discussion")
	@When("Remove member from discussion")
	public void removeMember() {
		discussionPage.removeMember();
	}

	@Then("view member profile")
	@When("view member profile")
	public void viewMemberProfile() {
		discussionPage.viewMemberProfile();
	}

	@Then("Check if user removed")
	@When("Check if user removed")
	public void checkIfUserRemoved() {
		assertTrue(discussionPage.getRecentMessage().getText().toString()
				.contains("Admin removed you from this discussion"));
		discussionPage.getFirstDiscussion().click();
		assertEquals("You can't send messages in this group because you're no longer a member.",
				discussionPage.checkMemberRemoved());
	}

	@Then("add $username to group")
	@When("add $username to group")
	public void addMemberToGroup(String userName) throws InterruptedException {
		userName = StateHelper.getStepState(userName).toString();
		discussionPage.addMemberToGroup(userName);
	}

	@Then("Check if user added")
	@When("Check if user added")
	public void checkIfUserAdded() {
		assertTrue(discussionPage.getFirstDiscussion().isDisplayed());

	}

	@When("User leave discussion room and check if user let the group")
	@Then("User leave discussion room and check if user let the group")
	public void leaveDiscussion() throws InterruptedException {
		discussionPage.leaveDiscussion();
		System.out.println(discussionPage.getRecentMessage().getText().toString());

		assertEquals("‎You left this discussion", discussionPage.getRecentMessage().getText().toString());
	}

	 @When("check group settings screen")
	 @Then("check group settings screen")

	public void checkGroupSettins() {
		discussionPage.checkGroupSettins();
	}

	@When("Forward $type message to second discussion")
	@Then("Forward $type message to second discussion")
	public void forwardMessage(String type) throws InterruptedException {
		discussionPage.forwardMessage(type);
	}

	@When("Copy text message")
	@Then("Copy text message")
	public void copyTextMsg() {
		discussionPage.copyTextMsg();
	}

	@When("Forward $message to second discussion")
	@Then("Forward $message to second discussion")
	public void forwardMessage2(String message) throws InterruptedException {
		discussionPage.forwardMessage(message);
	}

	@When("Share post to discussion")
	@Then("Share post to discussion")
	public void sharePostToDiscussion() throws InterruptedException {
		discussionPage.sharePostToDiscussion();
	}

	@When("User $muteStatus discussion")
	@Then("User $muteStatus discussion")
	public void muteAndUnMuteDiscussion(String muteStatus) throws InterruptedException {
		discussionPage.muteAndUnMuteDiscussion(muteStatus);
	}

	@When("User $muteStatus discussion group")
	@Then("User $muteStatus discussion group")
	public void muteAndUnMuteDiscussiongroup(String muteStatus) throws InterruptedException {
		discussionPage.muteAndUnMuteDiscussiongroup(muteStatus);
	}

	@When("Check if discussion $muteStatus on room")
	@Then("Check if discussion $muteStatus on room")
	public void checkMuteStatus(String muteStatus) {
		assertTrue(discussionPage.checkMuteStatus(muteStatus));
	}

	@When("Check $action when long press on a discussion")
	@Then("Check $action when long press on a discussion")
	public void longPressMsgOptions(String action) {
		discussionPage.longPressMsgOptions(action);
	}

	@When("view Friend's profile")
	@Then("view Friend's profile")
	public void viewFriendProfile() {
		discussionPage.viewFriendProfile();
	}

	@When("I want to archive discussion")
	@Then("I want to archive discussion")
	public void archiveMessage() {
		discussionPage.archiveMessage();
	}

	 @When("Counters should appear correctly")
	 @Then("Counters should appear correctly")
	public void checkCounters() {
		discussionPage.checkCounters();
	 }
	 
	@When("I want to check if discussion archived")
	@Then("I want to check if discussion archived")
	public void checkIfDiscussionArchived() {
		assertTrue(discussionPage.discussionArchived());


	}

	@When("user opens first discussion and check counter")
	@Then("user opens first discussion and check counter")
	public void openFirstDiscussionAndCheckCounter() {
		discussionPage.openFirstDiscussionAndCheckCounter();
	}

	@When("I want to archive ALL discussion")
	@Then("I want to archive ALL discussion")
	public void archiveAllDiscussions() {
		discussionPage.archiveAllDiscussions();
	}

	@When("I want to check discussion in archived")
	@Then("I want to check discussion in archived")
	public void checkDiscussionInArchived() throws InterruptedException {
		discussionPage.discussionInArchived();
	}

	@When("check that no discussions and no friends")
	@Then("check that no discussions and no friends")
	public void checkNoDiscussionsNoFriends() {
		discussionPage.checkNoDiscussionsNoFriends();
	}

	@When("User removes archived message")
	@Then("User removes archived message")
	public void removeArchivedMessage() {
		discussionPage.removeArchivedMessage();
	}

	@When("Check archive discussion counter is $value")
	@Then("Check archive discussion counter is $value")
	public void checkArchivedDiscussionCounter(String value) throws InterruptedException {
		Thread.sleep(5000);

		if (value.equals(0)) {
			assertTrue(discussionPage.archiveCounterZero());
		} else {
			assertTrue(value.contains(discussionPage.archiveCounter()));
		}
	}

	@When("I want to unarchive message")
	@Then("I want to unarchive message")
	public void unarchiveMessage() throws InterruptedException {
		discussionPage.unArchiveMessage();

	}

	@When("I want to unarchive ALL message")
	@Then("I want to unarchive ALL message")
	public void unArchiveAllMessages() {
		discussionPage.unArchiveAllMessages();
	}

	@When("I want to delete discussion")
	@Then("I want to delete discussion")
	public void deleteDiscussion() throws InterruptedException {
		discussionPage.archiveMessage();
		assertTrue(discussionPage.deleteDiscussion());

	}

	@Then("Delete message from the same discussion")
	public void deleteSingelDiscussion() throws InterruptedException {
		assertTrue(discussionPage.deleteSingelChat());
	}

	@When("Share story to discussion")
	@Then("Share story to discussion")
	public void shareStoryToDiscussion() throws InterruptedException {
		assertTrue(discussionPage.shareStoryToDiscussion());
	}

	@When("Share story to discussion from detailed page")
	@Then("Share story to discussion from detailed page")
	public void shareStoryToDiscussionFromDetailed() throws InterruptedException {
		assertTrue(discussionPage.shareStoryToDiscussionFromDetailed());
	}

	@When("Share story to discussion from more icon")
	@Then("Share story to discussion from more icon")
	public void shareStoryToDiscussionFromMoreIcon() throws InterruptedException {
		assertTrue(discussionPage.shareStoryToDiscussionFromMoreIcon());
	}

	@When("I want to send message to blocked user")
	@Then("I want to send message to blocked user")
	public void sendMessageToBlockedUser() throws InterruptedException {
		assertTrue(discussionPage.SendMessageToBlockedUser());
	}

	 @When("Send $imageType Image to Friend")
	 @Then("Send $imageType Image to Friend")

	public void sendImageMessage(String imageType) throws InterruptedException {
		discussionPage.sendImageToFriend(imageType);
	}

	@When("check when don't give permession to open camera")
	@Then("check when don't give permession to open camera")
	public void dontGivePermession() {
		discussionPage.dontGivePermession();
	}

	@When("Send Multi Images")
	@Then("Send Multi Images")
	public void sendMultiImages() {
		discussionPage.sendMultiImages();
	}

	@When("send taken $num $type to Friend")
	@Then("send taken $num $type to Friend")
	public void sendTakenMedia(int num, String type) throws InterruptedException {
		discussionPage.sendTakenMedia(num, type);
	}

	@When("remove $mediaType")
	@Then("remove $mediaType")
	public void deleteBeforeSending(String mediaType) {
		discussionPage.deleteBeforeSending(mediaType);
	}
	
	@Then("Check $Countertype Counter equal $num") 
	public void Counters (String counterType,String num) throws InterruptedException {
		if (counterType.equals("mainthread")){
		assertEquals(num,discussionPage.Counter(counterType));
		} else
		{
			assertEquals(num,discussionPage.Counter(counterType));	
		}
		
	}

	@Then("Check Reset $Counter")
	public void CounterReset(String Counter) {
		if (Counter.equals("mainCounter")) {
			assertTrue(discussionPage.CounterResetMain());
		} else {
			assertTrue(discussionPage.CounterResetThread());

		}
	}

	@Then("Check seperator inside Discussion $appear")
	public void checkSeperator(String appear) {
		if (appear.equals("appear"))
			assertTrue(discussionPage.Checkseperator());
		else {
			assertTrue(discussionPage.CheckseperatorNotExist());

		}
	}

	@Then("Send $Message to Automation Group")
	public void sendMessageInDiscussion(String message) {
		discussionPage.sendMessageInDiscussion(message);
	}

}
