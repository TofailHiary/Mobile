package Baaz.Mobile.pages;

import Baaz.Mobile.common.Helper;
import Baaz.Mobile.common.StateHelper;
import io.appium.java_client.MobileElement;
import junit.framework.Assert;

public class SearchPage extends Helper {

	public void searchForUser(String userName) throws InterruptedException {
		if(Helper.platform.equalsIgnoreCase("Android"))
		{
		getSearchIcon().click();
		switch (userName.toLowerCase()) {
		case "friend":
			getMobileElement("searchTextField").sendKeys(StateHelper.getStepState("user2name").toString());
			
			break;
		
		default:
			getSearchTextField().sendKeys(userName);
		}
		
		getSearchResult().click();
		}
		else
		{
			
			{
				getSearchIcon().click();
				getSearchTextField().sendKeys(userName);
				Thread.sleep(3000);
				getSearchResult().click();
				}
			
		}
	}

	public String userNameSearch() {
		// OK
		getMobileElement("searchIcon").click();
		getMobileElement("searchTextField").sendKeys("Baaz User1512988216344");
		sleepTime(2);
		getMobileElement("seeAllResult").click();
		return getMobileElement("searchUserResult").getText().toString();
	}
	
	public void searchForUserAndCopyName() {
		getMobileElement("firstSearchResult").click();
		getMobileElement("userProfileMoreIcon").click();
		getMobileElement("shareProfile").click();
		navigateBack();
		navigateBack();
		navigateBack();
		
	}

	public void searchFor(String type) {
		// Ok
		String Type = getLocator(type);
		getMobileElement("searchIcon").click();
		getMobileElement("searchTextField").sendKeys(Type);
		sleepTime(4);

	}
	
	public void searchforSavedUser() {
		getMobileElement("searchIcon").click();
		getMobileElement("searchTextField").sendKeys(suggestedFriendName);
		sleepTime(4);
	}
	
	
	public void checkFriendNameExist() {
		

		Assert.assertTrue(getMobileElement("firstSearchResult").getText().trim().contains(suggestedFriendName) || getMobileElement("secondSearchResult").getText().trim().contains(suggestedFriendName));
		if(getMobileElement("firstSearchResult").getText().trim().contains(suggestedFriendName)) {
			getMobileElement("firstSearchResult").click();
		}else {
			getMobileElement("secondSearchResult").click();
		}
	}

	public String postSearch() {
		getSearchTextField().clear();
		getSearchTextField().sendKeys("Baaz Post 1514396222869");
		sleepTime(1);
		getSeeAllResult().click();
		getPostsResult().click();
		return getSearchPostResult().getText().toString();
	}

	public String storySearch() {
		getSearchTextField().clear();
		getSearchTextField().sendKeys("Create Story By Mobile Automation");
		sleepTime(1);
		getSeeAllResult().click();
		getStoriesResult().click();
		return getSearchStoriesResult().getText().toString();
	}

	public void negativeSearch() {
		sleepTime(1);
		getSearchIcon().click();
		getSearchTextField().sendKeys("Hello Team This is Error Message Plz Stop");
		sleepTime(3);
	}

	public MobileElement getSearchIcon() {
		return Helper.getMobileElement("searchIcon");

	}

	public MobileElement getSearchTextField() {
		return Helper.getMobileElement("searchTextField");

	}

	public MobileElement getSearchResult() {
		return Helper.getMobileElement("searchResult");

	}

	public MobileElement getSeeAllResult() {
		return Helper.getMobileElement("seeAllResult");

	}

	public MobileElement getSearchUserResult() {
		return Helper.getMobileElement("searchUserResult");

	}

	public MobileElement getPostsResult() {
		return Helper.getMobileElement("postsResult");

	}

	public MobileElement getSearchPostResult() {
		return Helper.getMobileElement("searchPostResult");

	}

	public MobileElement getStoriesResult() {
		return Helper.getMobileElement("storiesResult");

	}

	public MobileElement getSearchStoriesResult() {
		return Helper.getMobileElement("searchStoriesResult");

	}

	public MobileElement getSearchErrorMessage() {
		return Helper.getMobileElement("searchErrorMessage");

	}

	

}
