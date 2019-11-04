package Baaz.Mobile.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Baaz.Mobile.common.Helper;
import Baaz.Mobile.common.StateHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class TrendingPage extends Helper{
	public void followStoryFromMain() {
		getTrendThreeDotsmain() .click();
		getFollowStory().click();
	}

	public void followStoryFromMainIcon() {
		getAll().click();
		getFollowStoryMainIcon().click();
		
	
	}
	
	public void unfollowStoryFromMainIcon() throws InterruptedException {
		
		getAll().click();
		Thread.sleep(2000);
		getFollowStoryMainIcon().click();
		getConfirm().click();
	}
	

	
	public boolean checkIfStoryFollowed() {
		
		wait.until(ExpectedConditions.visibilityOf(getFollowedTab()));
		getFollowedTab().click();
		return getStoryView().isDisplayed();
	}

	public void unFollowStoryFromMain() {
		getAll().click();
		getTrendThreeDotsmain().click();
		getUnFollowStory().click();
		getConfirmUnFollow().click();
	}

	public boolean checkIfStoryUnFollowed() {
		getFollowedTab().click();
		return getNoTrendingStories().isDisplayed();
	}

	public boolean checkStatisticsPage() {
		return getNumOfPosts().isDisplayed() && getCategoryStatistics().isDisplayed()&&
				getNumOfPosts24().isDisplayed()
				&& getStatisticsCountries().isDisplayed() && getCategoryView().isDisplayed()
				&& getStatisticsSN().isDisplayed()&&storyNamefromStatistics().isDisplayed();

	}

	public void followStoryFromDetailed() throws InterruptedException {
		getAll().click();
		getStoryView().click();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		getTrendThreeDots().click();
		getViewStoryFeed().click();
		getFollowFromDetailed().click();
		Thread.sleep(4000);
		getBackFromTrendingDetailed().click();
		getcloseStoryView().click();
	
	}

	public void storyDetailedPage() throws InterruptedException {
	
		
		getStoryView().click();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		getTrendThreeDots().click();
		getViewStoryFeed().click();
		
	}
	
	
	public void unFollowStoryFromDetailed() throws InterruptedException {
		getAll().click();
		getStoryView().click();
		getTrendThreeDots().click();
		getViewStoryFeed().click();
		getFollowFromDetailed().click();
		getConfirm().click();
		Thread.sleep(4000);
		getBackFromTrendingDetailed().click();
		getcloseStoryView().click();
	}

	public void followStoryFromMoreIconInDetailed() throws InterruptedException {
		getStoryView().click();
		getMoreIcon().click();
		getFollowStory().click();
		Thread.sleep(5000);
		getBackFromTrendingDetailed().click();
	}

	public void unFollowStoryFromMoreIconInDetailed() throws InterruptedException {
		getStoryView().click();
		getMoreIcon().click();
		getUnFollowStory().click();
		getConfirmUnFollow().click();
		getBackFromTrendingDetailed().click();
	}

	public void openStatisticsFromMainPage() throws InterruptedException {
		getAll().click();
		getStoryView().click();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		getTrendThreeDots().click();
		getStoryStatistics().click();
		
	}

	public void openStatisticsFromDetailedPage() throws InterruptedException {
		getAll().click();
		getStoryView().click();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		getTrendThreeDots().click();
		getViewStoryFeed().click();
		storyStatistics().click();
	}

	public void openStatisticsFromThreedotsInDetailedPage() throws InterruptedException {
		getAll().click();
		getStoryView().click();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		getTrendThreeDots().click();
		getViewStoryFeed().click();
		getMoreIcon().click();
		getStoryStatistics().click();
	}

	public void quickShareStory() throws InterruptedException {
		getShareStory().click();
		getQuickSharePost().click();
		Thread.sleep(3000);
	}

	

	public boolean shareStoryToTwitter() throws InterruptedException {
		getShareStory().click();
		getShareSNPost().click();
		if (Helper.platform.equalsIgnoreCase("iOS")) {
			Helper.tapOnTwitterAvatar();
		}
		if (Helper.platform.equalsIgnoreCase("Android")) {
			getTwitterAvatar().click();
		}
		getAddPost().click();
		if (Helper.platform.equals("Android")) {
			getmenuButton().click();
			getBaazline().click();

		}

		else {
			Helper.getMobileElement("baazline").click();
		}
		Thread.sleep(2000);
		Helper.pullToRefresh();
		boolean checkStoryShared = getStoryView().isDisplayed();

		return checkStoryShared
				&& getSharedOwner().getText().contains(StateHelper.getStepState("user1name").toString());
	}

	public boolean checkIfStorySharedToBaazline() throws InterruptedException {
		if (Helper.platform.equals("Android")) {
			getmenuButton().click();
			getBaazline().click();
		}

		else {
			Helper.getMobileElement("baazline").click();
		}
		Thread.sleep(2000);
		Helper.pullToRefresh();
		boolean checkStoryShared = getStoryView().isDisplayed();

		return checkStoryShared
				&& getSharedOwner().getText().contains(StateHelper.getStepState("user1name").toString());
	}

	public void quickShareFromDetailed() throws InterruptedException {
		getAll().click();
		getStoryView().click();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		getTrendThreeDots().click();
		getViewStoryFeed().click();
		getShareFromDetailedPost().click();
		getQuickSharePost().click();
		Thread.sleep(5000);
		getBackFromTrendingDetailed().click();
		getcloseStoryView().click();
	}

	public boolean shareStoryToFacebookFromDetailed() throws InterruptedException {
		getStoryView().click();
		getShareFromDetailedPost().click();
		getShareSNPost().click();
		if (Helper.platform.equalsIgnoreCase("iOS")) {
			Helper.tapOnFacebookAvatar();
		}
		if (Helper.platform.equalsIgnoreCase("Android")) {
			getFacebookAvatar().click();
		}
		getAddPost().click();
		Thread.sleep(5000);
		getBackFromTrendingDetailed().click();
		if (Helper.platform.equals("Android")) {
			getmenuButton().click();
			getBaazline().click();

		}

		else {
			Helper.getMobileElement("baazline").click();
		}
		Thread.sleep(2000);
		Helper.pullToRefresh();
		boolean checkStoryShared = getSharedStory().isDisplayed();

		return checkStoryShared && getSharedOwner().getText().equals("Forgot User");
	}
	
	public void followStoryFromSlidView() throws InterruptedException {
		getAll().click();
		getStoryView().click();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		getTrendThreeDots().click();
		getFollowStory().click();
		getcloseStoryView().click();
	 
		
	}
	
	
public void unfollowStoryFromSlidView() {
	getAll().click();
	getStoryView().click();
	getTrendThreeDots().click();
	getunFollowStory().click();	
	getConfirmUnFollow().click();
	getcloseStoryView().click();
	}



	public boolean shareStoryToTwitterFromDetailed() throws InterruptedException {
		getAll().click();
		getStoryView().click();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		Helper.tapOnCoachMark();
		getTrendThreeDots().click();
		getViewStoryFeed().click();
		getShareFromDetailedPost().click();
		getShareSNPost().click();
		if (Helper.platform.equalsIgnoreCase("iOS")) {
			Helper.tapOnTwitterAvatar();
		}
		if (Helper.platform.equalsIgnoreCase("Android")) {
			getTwitterAvatar().click();
		}
		getAddPost().click();
		Thread.sleep(5000);
		getBackFromTrendingDetailed().click();
		getcloseStoryView().click();
		if (Helper.platform.equals("Android")) {
			getmenuButton().click();
			getBaazline().click();

		}

		else {
			Helper.getMobileElement("baazline").click();
		}
		Thread.sleep(2000);
		Helper.pullToRefresh();
		boolean checkStoryShared = getStoryView().isDisplayed();

		return checkStoryShared
				&& getSharedOwner().getText().contains(StateHelper.getStepState("user1name").toString());
	}

	public String getCateopryNameFromMainPage() {
		getNews().click();
		getTrendThreeDots().click();
		getStoryStatistics().click();
		String categoryName = getCategoryStatistics().getText().toString();
		getBackFromStatistics().click();
		return categoryName;

	}

	public String getCateopryNameFromDetailedPage() {
		getStoryView().click();
		String categoryName = getCategoryTitle().getText().toString();
		return categoryName;

	}

	public String getCateopryNameFromMoreIcon() {
		getMoreIcon().click();
		getStoryStatistics().click();
		String categoryName = getCategoryStatistics().getText().toString();
		return categoryName;

	}

	public void trendFilter(String filter) {
		getStoryView().click();
		if (filter.equals("most trend")) {
			getMostTrend().click();
		} else {
			getMostRecent().click();
		}
	}

	public boolean checkFilter(String filter) {

		if (filter.equals("most trend")) {
			return getMostTrendPosts().isDisplayed();
		} else {
			return getMostRecentPosts().isDisplayed();
		}
	}

	public boolean checkKeywords() {
		getStoryView().click();
		getStoryKeywordsFromDetailed().click();
		return getKeywordsList().isDisplayed();
	}
	
	

	public MobileElement getShareFromDetailedPost() {
		return Helper.getMobileElement("shareFromDetailed");

	}

	public MobileElement getShareSNPost() {
		return Helper.getMobileElement("shareSNPost");

	}

	public MobileElement getAddPost() {
		return Helper.getMobileElement("addPost");
	}

	public MobileElement getTrendThreeDots() {
		return Helper.getMobileElement("trendThreeDots");
	}

	public MobileElement getTrendThreeDotsmain() {
		return Helper.getMobileElement("trendThreeDotsmain");
	}
	
	
	public MobileElement getFollowStory() {
		return Helper.getMobileElement("followStory");
	}
	
	public MobileElement getunFollowStory() {
		return Helper.getMobileElement("unfollowStory");
	}
	

	public MobileElement getFollowedTab() {
		return Helper.getMobileElement("followedTab");
	}

	public MobileElement getStoryView() {
		return Helper.getMobileElement("storyView");
	}
	
	public MobileElement getcloseStoryView() {
		return Helper.getMobileElement("closeStoryview");
	}
	
	
	public MobileElement getAll() {
		return Helper.getMobileElement("all");
	}

	public MobileElement getUnFollowStory() {
		return Helper.getMobileElement("unFollowStory");
	}

	public MobileElement getConfirmUnFollow() {
		return Helper.getMobileElement("confirmUnFollow");
	}

	public MobileElement getTwitterAvatar() {
		return Helper.getMobileElement("twitterAvatar");
	}

	public MobileElement getNoTrendingStories() {
		return Helper.getMobileElement("noTrendingStories");
	}

	public MobileElement getFollowFromDetailed() {
		return Helper.getMobileElement("followFromDetailed");
	}

	public MobileElement getBackFromTrendingDetailed() {
		return Helper.getMobileElement("backFromTrendingDetailed");
	}

	public MobileElement getUnFollowFromDetailed() {
		return Helper.getMobileElement("unFollowFromDetailed");
	}

	public MobileElement getMoreIcon() {
		return Helper.getMobileElement("moreIcon");
	}

	public MobileElement getFacebookAvatar() {
		return Helper.getMobileElement("facebookAvatar");
	}

	public MobileElement getNumOfPosts() {
		return Helper.getMobileElement("numOfPosts");
	}

	public MobileElement getNumOfPosts24() {
		return Helper.getMobileElement("numOfPosts24");
	}

	public MobileElement getStatisticsCountries() {
		return Helper.getMobileElement("statisticsCountries");
	}

	public MobileElement getCategoryView() {
		return Helper.getMobileElement("categoryView");
	}

	public MobileElement getStatisticsSN() {
		return Helper.getMobileElement("statisticsSN");
	}

	public MobileElement getStoryStatistics() {
		return Helper.getMobileElement("storyStatistics");
	}

	public MobileElement getStoryStatisticsFromDetailed() {
		return Helper.getMobileElement("storyStatisticsFromDetailed");
	}

	public MobileElement getShareStory() {
		return Helper.getMobileElement("shareStory");
	}

	public MobileElement getQuickSharePost() {
		return Helper.getMobileElement("quickSharePost");
	}

	public MobileElement getSharedStory() {
		return Helper.getMobileElement("sharedStory");
	}

	public MobileElement getSharedOwner() {
		return Helper.getMobileElement("sharedOwner");
	}

	public MobileElement getNews() {
		return Helper.getMobileElement("news");
	}

	public MobileElement getCategoryStatistics() {
		return Helper.getMobileElement("categoryStatistics");
	}

	public MobileElement getBackFromStatistics() {
		return Helper.getMobileElement("backFromStatistics");
	}

	public MobileElement getCategoryTitle() {
		return Helper.getMobileElement("categoryTitle");
	}

	public MobileElement getMostTrend() {
		return Helper.getMobileElement("mostTrend");
	}

	public MobileElement getMostTrendPosts() {
		return Helper.getMobileElement("mostTrendPosts");
	}

	public MobileElement getMostRecent() {
		return Helper.getMobileElement("mostRecent");
	}

	public MobileElement getMostRecentPosts() {
		return Helper.getMobileElement("mostRecentPosts");
	}

	public MobileElement getStoryKeywordsFromDetailed() {
		return Helper.getMobileElement("storyKeywordsFromDetailed");
	}

	public MobileElement getKeywordsList() {
		return Helper.getMobileElement("keywordsList");
	}
	
	public MobileElement getFollowStoryMainIcon()
 {
		return Helper.getMobileElement("mainFollowIcon");
	}
	

	public MobileElement getViewStoryFeed()
 {
		return Helper.getMobileElement("viewStoryFeed");
	}
	
	
	public MobileElement getConfirm()
 {
		return Helper.getMobileElement("confirmBlock");
	}

	public MobileElement storyNamefromStatistics()
	 {
			return Helper.getMobileElement("storyNamefromStatistics");
		}
	public MobileElement storyStatistics()
	 {
			return Helper.getMobileElement("statisticsIcon");
		}
	
	public MobileElement getmenuButton()
	 {
			return Helper.getMobileElement("menuButton");
		}
	
	public MobileElement getBaazline()
	 {
			return Helper.getMobileElement("baazline");
		}
	
	

}
