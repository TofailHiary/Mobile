Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario: Misc - play video from URL
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with videoURL
And playVideo should appear
And User clicks on playVideo
And User clicks on play
Then wait playButton to be invisible


Scenario: Misc - copy post text
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And textPost should contain baazText
And user copy post text and paste in commnet
Then commentBody should contain baazText 


Scenario: Misc - create a post in friend profile
Meta:
@android
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456 
And Search for friend
And proceed to friend profile and create a post
Then textPost should contain onFriend


Scenario: Misc - check AM and PM
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
Then timeStamp should contain AM


Scenario: Misc - play and pause video
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create video image post
And Pull to refresh
And User clicks on videoButton
Then tap on the centre


Scenario: Misc - put the app in background while video is uploading
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create video image post
And Put the App in background for 10
And Pull to refresh
And videoPost should appear


Scenario: Misc - Mute button
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create video image post
And Pull to refresh
And User clicks on muteButton


Scenario: Misc - play icon when autoplay off
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And user disable autoplay option
And Create video image post
And Pull to refresh
Then playVideo should appear


Scenario: Misc - open post details page while it's playing
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create video image post
And I want to scroll up 4 time(s)
And User clicks on timeStamp
Then videoPost should appear


Scenario: Misc - play icon when autoplay off
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create video image post
And I want to scroll up 2 time(s)
And User clicks on videoButton
And User waits for 3 seconds
And Pull to refresh
Then createPost should appear


Scenario: Misc - open video then minimize
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create video image post
And I want to scroll up 2 time(s)
And User clicks on videoButton
And User waits for 3 seconds
And Pull to refresh
Then createPost should appear


Scenario: Misc - close image icon
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create jpg image post
And photoPost should appear
And User clicks on photoPost
And User clicks on closeImage
Then createPost should appear

Scenario: Misc - save image
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create jpg image post
And photoPost should appear
And User clicks on photoPost
Then User save image


Scenario: Misc - navigate to a shared post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And user copy post link and create a post
And pastedPostText should appear with baazText
Then user copy post and navigate to it


Scenario:  Misc - Share Baaz profile - copy link
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I want to search for user
And search for user and copy profile link
And user create post with copied profile name
Then sharedPostLink should appear


Scenario: Misc - click on featured keyword
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And user scroll to featured keywords
Then check redirection after clicking on keyword


Scenario: Misc - proceed to a shared story
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And user copy story from trending and Create post
And user navigate to shared story
Then viewStoryToolBar should appear


Scenario: retweet post
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create twitter post
Then User retweet post and check


Scenario: retweet when have more than one twitter account
Meta:
@android
Given Open Baaz App
When I want to login with musab1@test.com and password is 123456qw
And Create twitter post
Then User retweet post and check