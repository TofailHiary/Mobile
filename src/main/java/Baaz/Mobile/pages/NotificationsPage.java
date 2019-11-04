package Baaz.Mobile.pages;

import Baaz.Mobile.common.Helper;
import Baaz.Mobile.common.StateHelper;
import io.appium.java_client.MobileElement;

public class NotificationsPage {

	public boolean checkAndAcceptFriendRequest() {
		boolean firstCheck = getFriendRequestsNotificationUserName().getText().toString()
				.contains(StateHelper.getStepState("user1name").toString());
		boolean secondCheck = getFriendRequestsNotificationTime().getText().toString().equals("Just Now");
		getFriendRequestsNotificationAcceptUser().click();
		return firstCheck && secondCheck;
	}

	public boolean checkAndDeclineFriendRequest() {
		boolean firstCheck = getFriendRequestsNotificationUserName().getText().toString()
				.contains(StateHelper.getStepState("user1name").toString());
		boolean secondCheck = getFriendRequestsNotificationTime().getText().toString().equals("Just Now");
		getFriendRequestsNotificationDeclineUser().click();
		return firstCheck && secondCheck;
	}

	public boolean checkFriendListFromViewAll() {
		getFriendRequestsViewAll().click();
		boolean firstCheck = getFriendRequestList().isDisplayed();
		getBackFromFriendRequestList().click();
		boolean secondCheck = Helper.checkIfElementNotExist("friendRequestList");
		return firstCheck && secondCheck;
	}

	public boolean checkAvatarFunctionality() {
		getFriendRequestsViewAll().click();
		getUserAvatarFromFriendRequestList().click();
		return getAboutTab().isDisplayed();
	}

	public boolean checkBaazlineNotifications(String action) {
		boolean firstCheck = false, secondCheck = false;
		if (action.equals("Like")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user2name").toString());
			secondCheck = getBaazlineActivityName().getText().equals("liked your post");
		} else if (action.equals("Comment")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user2name").toString());
			secondCheck = getBaazlineActivityName().getText().equals("commented on your post");
		} else if (action.equals("Mention")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user1name").toString());
			secondCheck = getBaazlineActivityName().getText().equals("mentioned you in a post");
		} else if (action.equals("Comment on mention post")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user3name").toString());
			secondCheck = getBaazlineActivityName().getText().equals("commented on a post you're mentioned in");
		} else if (action.equals("Like a mention post")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user3name").toString());
			secondCheck = getBaazlineActivityName().getText().equals("liked a post you're mentioned in");
		} else if (action.equals("Comment on post already commented on")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user3name").toString());
			secondCheck = getBaazlineActivityName().getText().contains("also commented on");
		} else if (action.equals("Accept friend request")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user2name").toString());
			secondCheck = getBaazlineActivityName().getText().equals("accepted your friendship request");
		} else if (action.equals("Shared post")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user2name").toString());
			secondCheck = getBaazlineActivityName().getText().equals("shared your post");
		} else if (action.equals("Post on your wall")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user1name").toString());
			secondCheck = getBaazlineActivityName().getText().equals("posted on your wall");
		} else if (action.equals("Like post on your wall")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user3name").toString());
			secondCheck = getBaazlineActivityName().getText().equals("liked a posted on your wall");
		} else if (action.equals("Comment on post on your wall")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user3name").toString());
			secondCheck = getBaazlineActivityName().getText().equals("commented on a posted on your wall");
		} else if (action.equals("Owner comment")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user1name").toString());
			secondCheck = getBaazlineActivityName().getText().equals("also commented on their post");
		} else if (action.equals("Mentioned in comment")) {
			firstCheck = getBaazlineNotificationUserName().getText()
					.contains(StateHelper.getStepState("user2name").toString());
			secondCheck = getBaazlineActivityName().getText().equals("mentioned you in a comment");
		}

		return firstCheck && secondCheck;
	}

	public boolean checkDiscussionNotification(String action) {
		boolean firstCheck = false, secondCheck = false;
		if (action.equals("Send message")) {
			firstCheck = getDiscussionUserName().getText().contains(StateHelper.getStepState("user1name").toString());
			secondCheck = getDiscussionMessageContent().getText().contains("sent you a message");
		} else if (action.equals("Send message to group")) {
			firstCheck = getDiscussionUserName().getText().contains(StateHelper.getStepState("user1name").toString());
			secondCheck = getDiscussionMessageContent().getText().equals(" @ Automaiton Group: Hello Automation Group");
		} else if (action.equals("Add member to group")) {
			firstCheck = getDiscussionUserName().getText().contains(StateHelper.getStepState("user2name").toString());
			secondCheck = getDiscussionMessageContent().getText().contains("joined the discussion");
		} else if (action.equals("Remove member from group")) {
			firstCheck = getDiscussionUserName().getText().contains(StateHelper.getStepState("user2name").toString());
			secondCheck = getDiscussionMessageContent().getText().contains("removed from this discussion");
		} else if (action.equals("Edit group name")) {
			firstCheck = getDiscussionUserName().getText().contains(StateHelper.getStepState("user1name").toString());
			secondCheck = getDiscussionMessageContent().getText().contains("changed group title");
		}

		return firstCheck && secondCheck;
	}

	public MobileElement getFriendRequestsNotificationUserName() {
		return Helper.getMobileElement("friendRequestsNotificationUserName");
	}

	public MobileElement getFriendRequestsNotificationTime() {
		return Helper.getMobileElement("friendRequestsNotificationTime");
	}

	public MobileElement getFriendRequestsNotificationAcceptUser() {
		return Helper.getMobileElement("friendRequestsNotificationAcceptUser");
	}

	public MobileElement getFriendRequestsNotificationDeclineUser() {
		return Helper.getMobileElement("friendRequestsNotificationDeclineUser");
	}

	public MobileElement getFriendRequestsViewAll() {
		return Helper.getMobileElement("friendRequestsViewAll");
	}

	public MobileElement getFriendRequestList() {
		return Helper.getMobileElement("friendRequestList");
	}

	public MobileElement getBackFromFriendRequestList() {
		return Helper.getMobileElement("backFromFriendRequestList");
	}

	public MobileElement getUserAvatarFromFriendRequestList() {
		return Helper.getMobileElement("userAvatarFromFriendRequestList");
	}

	public MobileElement getAboutTab() {
		return Helper.getMobileElement("aboutTab");
	}

	public MobileElement getBaazlineNotificationUserName() {
		return Helper.getMobileElement("baazlineNotificationUserName");
	}

	public MobileElement getBaazlineActivityName() {
		return Helper.getMobileElement("baazlineActivityName");
	}

	public MobileElement getDiscussionUserName() {
		return Helper.getMobileElement("discussionUserName");
	}

	public MobileElement getDiscussionMessageContent() {
		return Helper.getMobileElement("discussionMessageContent");
	}

}
