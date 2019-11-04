package Baaz.Mobile.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Baaz.Mobile.common.Helper;
import Baaz.Mobile.common.StateHelper;
import Baaz.Mobile.pages.BaazlinePage;
import Baaz.Mobile.pages.DiscussionPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class BaazlineSteps  {
	BaazlinePage baazline = new BaazlinePage();

	@When("Create Empty Post")
	public void createEmptyPost() throws InterruptedException {

		baazline.createEmptyPost();
	}

	@Then("Create New Post with $textContent")
	@When("Create New Post with $textContent")
	public void createTextPost(String textContent) throws InterruptedException {
		baazline.createTextPost(textContent);
	}
	
	@Then("User create post with link")
	@When("User create post with link")
	public void createPostWithLink() throws InterruptedException {
		baazline.createPostWithLink();
	}

	@Then("Create post with hashtag and remove keyword")
	@When("Create post with hashtag and remove keyword")
	public void CreatePostRemoveKywWord() throws InterruptedException {
		baazline.CreatePostRemoveKywWord();
	}

	@Then("proceed to friend profile and create a post")
	@When("proceed to friend profile and create a post")
	public void createPostFriendProfile() throws InterruptedException {
		baazline.createPostFriendProfile();
	}

	@Then("Check if text post $postContent exist")
	public void checkTextPost(String postContent) {
		if (!postContent.contains("#")) {
			assertEquals(postContent, baazline.checkTextPost());
		} else {
			assertTrue(baazline.checkTextPost().contains(postContent));
		}

	}

	@Then("Check post keywords contains $keyword")

	public void checkPostKeyowrds(String keyword) {
		assertEquals(keyword, baazline.checkPostKeyowrds());
	}

	@When("Create facebook post")
	@Then("Create facebook post")
	public void createFacebookPost() throws InterruptedException {
		baazline.createFacebookPost();
	}

	@Then("Check if facebook post exist")
	public void checkFacebookPost() {
		String facebookPost = StateHelper.getStepState("facebookPost").toString();
		System.err.println(facebookPost);
		assertTrue(baazline.checkFacebookPost(facebookPost));
	}

	@When("Create twitter post")
	@Then("Create twitter post")
	public void createTwitterPost() throws InterruptedException {
		baazline.createTwitterPost();
	}
	
	@When("User log out")
	@Then("User log out")
	public void logOut(){
		baazline.logOut();
	}

	@Then("Check if twitter post exist")
	public void checkTwitterPost() {
		String twitterPost = StateHelper.getStepState("twitterPost").toString();
		assertTrue(baazline.checkTwitterPost(twitterPost));
	}

	@When("Create combined post")
	@Then("Create combined post")
	public void createCombinedPost() throws InterruptedException {
		baazline.createCombinedPost();
	}

	@Then("Check if combined post exist")
	public void checkCombinedPost() {
		String combinedPost = StateHelper.getStepState("combinedPost").toString();
		assertTrue(baazline.checkCombinedPost(combinedPost));
	}

	@Then("Check if video post exist")
	public void checkVideoPost() {
		assertTrue(baazline.checkVideoPost());
	}

	@When("Create $privacy privacy baaz post")
	public void createPrivacyPost(String privacy) throws InterruptedException {
		baazline.createPrivacyPost(privacy);
	}

	@When("User change post privacy")
	@Then("User change post privacy")
	public void changePostPrivacy() {
		baazline.changePostPrivacy();
	}

	@When("User change shared post privacy")
	@Then("User change shared post privacy")
	public void changeSharedPostPrivacy() {
		baazline.changeSharedPostPrivacy();
	}

	@When("Create $imageType image post")
	@Then("Create $imageType image post")
	public void createImagePost(String imageType) throws InterruptedException {
		baazline.createImagePost(imageType);
	}

	@When("User save image")
	@Then("User save image")
	public void saveImage() {
		baazline.saveImage();
	}

	@When("user copy post and navigate to it")
	@Then("user copy post and navigate to it")
	public void copyPostAndNavigate() {
		baazline.copyPostAndNavigate();
	}
	
	@When("user navigate to shared story")
	@Then("user navigate to shared story")
	public void navigateToSharedStoy() {
		baazline.navigateToSharedStoy();
	}

	@When("Create $Type post with mention")
	@Then("Create $Type post with mention")
	public void createMentionVideoWithMedia(String Type) throws InterruptedException {
		baazline.createMentionPostWithMedia(Type);
	}

	@When("User captures $num photo")
	@Then("User captures $num photo")
	public void captureImagePost(int num) throws InterruptedException {
		baazline.captureImagePost(num);
	}

	@When("Create $videoType video post")
	@Then("Create $videoType video post")
	public void createVideoPost(String videoType) throws InterruptedException {
		baazline.createVideoPost(videoType);
	}

	@When("Create video post with text")
	public void createVideoPostWithText(String videoType) throws InterruptedException {
		baazline.createVideoPostWithText(videoType);
	}

	@Then("Check keep post page and discard")
	public void checkKeepAndDiscardPost() throws InterruptedException {
		assertTrue(baazline.checkKeepAndDiscardPost());
	}

	@Then("Check cancel upload image")
	public void cancelUploadImage() throws InterruptedException {
		assertTrue(baazline.cancelUploadImage());
	}

	@When("Create Mention Post")
	@Then("Create Mention Post")
	public void createMentionPost() throws InterruptedException {
		baazline.createMentionPost();
	}

	@When("edit mention")
	@Then("edit mention")
	public void editMentionPost() throws InterruptedException {
		baazline.editMentionPost();
	}

	@When("Remove Mention")
	@Then("Remove Mention")
	public void removeMentionPost() throws InterruptedException {
		baazline.removeMention();

	}

	@When("Like text post")
	@Then("Like text post")
	public void likeTextPost() {
		baazline.likeTextPost();
	}

	@When("Check who like post")
	public void whoLikePost() {

		Assert.assertTrue(baazline.whoLikePost().contains("Baaz User"));
	}

	@When("Check who like social post")
	public void whoLikeFacebookPost() {
		assertEquals("Automation Automation", baazline.whoLikeFacebookPost());
	}

	@When("Unlike text post")
	@Then("Unlike text post")
	public void unLikePost() {
		baazline.unLikePost();
	}

	@When("number of twitter likers should be $num")
	@Then("number of twitter likers should be $num")
	public void checkTwitterLikers(String num) {
		baazline.checkTwitterLikers(num);
	}

	@When("user like video post and check likers")
	@Then("user like video post and check likers")
	public void likeVideoPostAndCheckLikers() throws InterruptedException {
		baazline.likeVideoPostAndCheckLikers();
		;
	}

	@Then("Check if post without likers")
	public void postUnliked() {
		assertEquals("Like", baazline.numOfLikers().toString().trim());

	}

	@When("Like text post from detailed")
	@Then("Like text post from detailed")
	public void likeTextPostFromDetailed() {
		baazline.likeTextPostFromDetailed();
	}

	@When("Like Twitter post from detailed")
	@Then("Like Twitter post from detailed")
	public void likeTwitterPostFromDetailed() {
		baazline.likeTwitterPostFromDetailed();
	}

	@When("Comment on baaz post with $comment")
	@Then("Comment on baaz post with $comment")
	public void commentOnBaazPost(String comment) {
		baazline.commentOnBaazPost(comment);
	}
	
	@When("User retweet post and check")
	@Then("User retweet post and check")
	public void retweetPostAndCheck() {
		baazline.retweetPostAndCheck();
	}
	
	
	@When("Get the value of $element")
	@Then("Get the value of $element")
	public void getValue(String locator) {
		baazline.getValue(locator);
	}
	
	@When("check the number of comments")
	@Then("check the number of comments")
	public void chechNumOfCommentsAfter() {
		baazline.chechNumOfCommentsAfter();
	}

	@When("mention Should appear in $where")
	@Then("mention Should appear in $where")
	public void isMentionEquals(String where) {
		baazline.isMentionEquals(where);
	}

	@When("edited mention Should appear in comment")
	@Then("edited mention Should appear in comment")
	public void isEditedMentionEquals() {
		baazline.isEditedMentionEquals();
	}

	@When("Edit comment to be $comment")
	@Then("Edit comment to be $comment")
	public void editComment(String comment) {
		baazline.editComment(comment);
	}
	
	@When("delete comment")
	@Then("delete comment")
	public void deleteComment() throws InterruptedException {
		baazline.deleteComment();
	}
	
	@When("delete RSS comment")
	@Then("delete RSS comment")
	public void deleteRSSComment() throws InterruptedException {
		baazline.deleteRSSComment();
	}
	
	@When("share Rss post and check")
	@Then("share Rss post and check")
	public void shareRSSPost() throws InterruptedException {
		baazline.shareRSSPost();
	}

	@When("Share post to baaz")
	@Then("Share post to baaz")
	public void sharePosttoBaaz() throws InterruptedException {
		assertTrue(baazline.sharePosttoBaaz().contains("shared this post"));
	}
	
	@When("User share youtube post and check")
	@Then("User share youtube post and check")
	public void shareYouTubePostAndCheck(){
		baazline.shareYouTubePostAndCheck();
	}

	
	
	@When("delete shared story")
	@Then("delete shared story")
	public void deleteSharedStory() throws InterruptedException {
		baazline.deleteSharedStory();
	}
	
	@When("Share post to baaz from details page")
	@Then("Share post to baaz from details page")
	public String sharePostFromDetailsPage() throws InterruptedException {
		assertTrue(baazline.sharePostFromDetailsPage().contains("shared this post"));
		return null;
	}

	@When("Share post to like it")
	@Then("Share post to like it")
	public String shareToLike() throws InterruptedException {
		assertTrue(baazline.shareToLike().contains("shared this post"));
		return null;

	}

	@When("user copy post link and create a post")
	@Then("user copy post link and create a post")
	public void copyPostLinkAndShare() throws InterruptedException {
		baazline.copyPostLinkAndShare();
	}

	@When("user create post with copied profile name")
	@Then("user create post with copied profile name")
	public void createPostWithCopiedProfile() throws InterruptedException {
		baazline.createPostWithCopiedProfile();
	}

	@When("user copy story from trending and Create post")
	@Then("user copy story from trending and Create post")
	public void copyStoryAndCreatePost() throws InterruptedException {
		baazline.copyStoryAndCreatePost();
	}

	@When("user scroll to featured keywords")
	@Then("user scroll to featured keywords")
	public void scrollToFeatured() throws InterruptedException {
		baazline.scrollToFeatured();
	}

	@When("check redirection after clicking on keyword")
	@Then("check redirection after clicking on keyword")
	public void checkKeyWordRedirection() {
		baazline.checkKeyWordRedirection();
	}

	@When("check Featured keywords for SN")
	@Then("check Featured keywords for SN")
	public void checkFeaturedForSN() throws InterruptedException {
		baazline.checkFeaturedForSN();
	}

	@When("user copy post text and paste in commnet")
	@Then("user copy post text and paste in commnet")
	public void copyPostAndPaste() {
		baazline.copyPostAndPaste();
	}

	@When("user share post with more options")
	@Then("user share post with more options")
	public void sharePostWithMoreOptions() {
		baazline.sharePostWithMoreOptions();
	}

	@Then("Share rss post to baaz")
	@When("Share rss post to baaz")
	public void shareRssPostToFacebook() throws InterruptedException {
		assertTrue(baazline.sharePosttoBaaz().contains("Rss Mobile"));

	}

	@Then("Share post to baaz and twitter")
	public void sharePostToTwitter() throws InterruptedException {
		assertTrue(baazline.sharePostToTwitter().contains("Automation Automation"));

	}

	@Then("Share post to SN $only")
	@When("Share post to SN $only")
	public void sharePostToTwitterOnly(String type) throws InterruptedException {
		baazline.sharePostToTwitterOnly(type);
	}

	@Then("Share Post with text to SN only")
	@When("Share Post with text to SN only")
	public void sharePostToSNAddText() throws InterruptedException {
		baazline.sharePostToSNAddText();
	}

	@Then("Share post with $type")
	@When("Share post with $type")
	public void shareWithText(String type) throws InterruptedException {
		baazline.shareWithText(type);
	}

	@Then("User edit shared post with $editedPost")
	@When("User edit shared post with $editedPost")
	public void editSharedPost(String editedPost) throws InterruptedException {
		baazline.editSharedPost(editedPost);
	}

	@When("Edit text post with $editedPost")
	public void editPost(String editedPost) {
		baazline.editPost(editedPost);
	}

	@When("Edit text post from detailed with $editedPost")
	public void editPostFromDetailed(String editedPost) {
		baazline.editPostFromDetailed(editedPost);
	}

	@When("Delete post")
	@Then("Delete post")
	public void deletePost() {
		baazline.deletePosts();
	}

	@When("Delete shared post")
	@Then("Delete shared post")
	public void deleteSharedPost() throws InterruptedException {
		baazline.deleteSharedPost();
	}

	@Then("Delete $social post and check if deleted")
	public void deleteSNPost(String social) {
		if (social.equalsIgnoreCase("facebook")) {
			assertNotEquals(StateHelper.getStepState("facebookPost").toString(), baazline.deleteSNPost());
		}
		if (social.equalsIgnoreCase("twitter")) {
			assertNotEquals(StateHelper.getStepState("twitterPost").toString(), baazline.deleteSNPost());
		}
		if (social.equalsIgnoreCase("combined")) {
			assertNotEquals(StateHelper.getStepState("combinedPost").toString(), baazline.deleteSNPost());
		}

	}

	@When("Choose $mediaType filter")
	@Then("Choose $mediaType filter")
	public void chooseMediaFilter(String mediaType) {
		baazline.chooseMediaFilter(mediaType);
	}

	@When("Scroll $direction $times time(s)")
	@Then("Scroll $direction $times time(s)")
	public void scrollingFunc(String direction, int times) throws InterruptedException {
		Helper.scrollTo(direction, times);
	}

	@Then("Check $update filter")
	@When("Check $update filter")
	public void chooseFilter(String update) {
		baazline.chooseFilter(update);
	}

	@When("I want to create $numOfPosts post(s) from $user")
	@Then("I want to create $numOfPosts post(s) from $user")
	public void createPost(int numOfPosts, String user) throws MalformedURLException, IOException {
		String userToken = StateHelper.getStepState(user).toString();
		baazline.createPost(numOfPosts, userToken);
	}

	@When("Check if green bubble equal $numOfPosts")
	@Then("Check if green bubble equal $numOfPosts")
	public void checkGreenBubble(String numOfPosts) {
		assertEquals(numOfPosts, baazline.checkGreenBubble());
		baazline.clickOnkGreenBubble();

	}

	@Then("Check suggested friends box")
	public void checkSuggestedFriends() {
		assertTrue(baazline.checkSuggestedFriends());
	}

	@Then("Navigate to rss filter")
	@When("Navigate to rss filter")
	public void navigateToRss() throws InterruptedException {
		baazline.navigateToRss();
	}

	@Then("Like comment and reply to comment with $repliedComment")
	@When("Like comment and reply to comment with $repliedComment")
	public void repliedComment(String repliedComment) {
		baazline.repliedComment(repliedComment);
	}

	@Then("Check replied comment")
	@When("Check replied comment")
	public void checkRepliedComment() {
		assertTrue(baazline.getMobileElement("repliedCommentBody").getText().toString().contains("Hi"));
		assertTrue(baazline.getMobileElement("repliedCommentBody").getText().toString()
				.contains(StateHelper.getStepState("user1name").toString()));

	}

	@When("I navigate to disucssions")
	@Then("I navigate to disucssions")
	public void navigateToDisucssions() throws InterruptedException {

		baazline.navigateToDiscussions();


		if (Helper.platform.equals("Android")) {
			Helper.getMobileElement("menuButton").click();
			Thread.sleep(1000);
			baazline.getDiscussionsbutton();
			
		}

		else {
			Helper.getMobileElement("discussions").click();
			Thread.sleep(2000);
		}

		Thread.sleep(2000);


	}

	
	@When("App in background")
	@Then("App in background")
	public static void background(){
		Helper.driver.runAppInBackground(Duration.ofSeconds(10));
		
	}
	@When("I navigate to profile from settings")
	@Then("I navigate to profile from settings")
	public void navigateToProfileFromSettings() {

		if (Helper.platform.equals("Android")) {
			Helper.getMobileElement("trendingMenuButton").click();
			Helper.getMobileElement("menuAvatar").click();

		}

		else {
			Helper.getMobileElement("profile").click();
		}

	}
	/* this code for navigation and check tofail code
	@When("I navigate to $pagination")
	@Then("I navigate to $pagination")
	public void navigationMethod(String pagination) throws InterruptedException{
		
		String[] parts = pagination.split("->");
		for (int i = 0 ; i < parts.length ; i++){
			getElement(parts[i]).click();
			Thread.sleep(2000);
		}
	}

	@When("I navigate to $pagination and check if $visible visable")
	@Then("I navigate to $pagination and check if $visible visable")
	public void navigationMethod(String pagination , String visible) throws InterruptedException{
		
		String[] parts = pagination.split("->");
		for (int i = 0 ; i < parts.length ; i++){
			if (visible == "is") {
				getElement(parts[i]).isDisplayed();
			}
				getElement(parts[i]).click();
			
				Thread.sleep(2000);
		}
		
	}
	
	public MobileElement getElement(String ElementName){
		return Helper.getMobileElement(ElementName);
	}
	*/
	
	@When("I navigate to trending")
	@Then("I navigate to trending")
	public void navigateToTrending() throws InterruptedException {

		if (Helper.platform.equals("Android")) {
			baazline.getTrendingbutton();

		}

		else {
			Helper.getMobileElement("trending").click();
			Helper.getMobileElement("forYou").click();
			Helper.getMobileElement("followedTab").click();
			
		}
		Thread.sleep(5000);
	}

	@When("I navigate to profile")
	@Then("I navigate to profile")
	public void navigateToProfile() {

		if (Helper.platform.equals("Android")) {
			Helper.getMobileElement("menuButton").click();
			Helper.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Profile\")")).click();

		}

		else {
			Helper.getMobileElement("profile").click();

		}

	}

	@When("I navigate to settings")
	@Then("I navigate to settings")
	public void navigateToSettings() {
		if (Helper.platform.equals("Android")) {
			Helper.getMobileElement("menuButton").click();
			Helper.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Settings\")")).click();

		}

		else {
			Helper.getMobileElement("profile").click();
			Helper.getMobileElement("settings").click();

		}

	}

	@When("I navigate to notifications")
	@Then("I navigate to notifications")
	public void navigateToNotifications() throws InterruptedException {

		if (Helper.platform.equals("Android")) {
			Helper.getMobileElement("menuButton").click();
			Helper.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Notifications\")")).click();
		}

		else {
			Helper.getMobileElement("notificatoin").click();
		}

		Thread.sleep(2000);

	}

	@When("Block user")
	@Then("Block user")
	public void blockUser() throws InterruptedException {
		baazline.blockUser();
	}

	@When("Check all types of report post")
	@Then("Check all types of report post")
	public void reportPost() {
		baazline.reportPost();
	}

	@When("Add $numOfUsers friend(s) from suggested in profile page")
	public void addFriendFromProfile(int numOfUsersl) throws InterruptedException {
		baazline.addFriendFromProfile(numOfUsersl);
	}

	@When("User $action a friend then return back")
	@Then("User $action a friend then return back")
	public void addFriendProfile(String action) {
		baazline.addFriendProfile(action);
	}

	@When("remove $numOfUsers friend(s) from suggested in profile page")
	public void deleteFriendFromProfile(int numOfUsersl) throws InterruptedException {
		baazline.deleteFriendFromProfile(numOfUsersl);
	}

	@Then("Check sync between profile and baazline when add or remove 1 friend")
	public void syncBetweenBaazlineAndProfile() throws InterruptedException {
		assertTrue(baazline.syncBetweenBaazlineAndProfile());

	}

	@Then("Check sync between profile and baazline when add or remove all friends")
	public void syncBetweenBaazlineAndProfileForAllFriends() throws InterruptedException {
		assertTrue(baazline.syncBetweenBaazlineAndProfileForAllFriends());

	}

	@Then("Check sync between profile and baazline when add or remove all friends after pull to refresh")
	public void syncBetweenBaazlineAndProfileForAllFriendsAfterPullToRefresh() throws InterruptedException {
		assertTrue(baazline.syncBetweenBaazlineAndProfileForAllFriendsAfterPullToRefresh());

	}

	@When("User create a captured video post")
	@Then("User create a captured video post")
	public void cuaptureVideoPost() throws InterruptedException {
		baazline.cuaptureVideoPost();
	}

	@When("User create twitter post with $media")
	@Then("User create twitter post with $media")
	public void createTwitterPostImage(String media) throws InterruptedException {
		baazline.createTwitterPostImage(media);
	}

	@When("User opens keywors")
	@Then("User opens keywors")
	public void openKeyWords() {
		baazline.openKeyWords();
	}

	@When("User $action a friend")
	@Then("User $action a friend")
	public void addSuggestedFriend(String action) {
		baazline.addSuggestedFriend(action);
	}

	@When("Get the name of the $index suggestion")
	@Then("Get the name of the $index suggestion")
	public void getSecondSuggestionName(String index) {
		baazline.getSecondSuggestionName(index);
	}

	@When("User refresh until suggestions appear")
	@Then("User refresh until suggestions appear")
	public void refreshUntilsuggestions() throws InterruptedException {
		baazline.refreshUntilsuggestions();
	}

	@When("User navigate back")
	@Then("User navigate back")
	public void navigateBack() {
		baazline.navigateBack();
	}

	@When("User $action a friend from contacts")
	@Then("User $action a friend from contacts")
	public void findFriendContacts(String action) {
		baazline.findFriendContacts(action);
	}
	
	@When("User move to findfriend page")
	@Then("User move to findfriend page")
	public void navigatetoFindFriends() throws InterruptedException {
		
	}

	@When("User $action friend from profile and return back")
	@Then("User $action friend from profile and return back")
	public void findFiendFromProfileReturnBack(String action) {
		baazline.findFiendFromProfileReturnBack(action);
	}

	@When("user invite friend via $type")
	@Then("user invite friend via $type")
	public void inviteFriendViaWhatsApp(String type) {
		baazline.inviteFriendViaWhatsApp(type);
	}

	@When("user invite friends from phone contacts")
	@Then("user invite friends from phone contacts")
	public void inviteFriendsFromContacts() {
		baazline.inviteFriendsFromContacts();
	}

}
