Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario: Add suggested friend - Find Friend
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And Scroll down 2 time(s)
And User clicks on viewAllRecommendedFriends
And Get the name of the findFriendFirst suggestion
And User clicks on addFriend_Baazline
And User navigate back
Then firstSuggestedName should not have friend name
And Scroll up 1 time(s)
And User searche for the saved user
And check the name in search results and navigate to friend profile page
Then cancelRequest should appear



Scenario: follow suggested friend - Find Friend
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And Scroll down 2 time(s)
And User clicks on viewAllRecommendedFriends
And Get the name of the findFriendFirst suggestion
And User clicks on followButton
And User navigate back
Then firstSuggestedName should not have friend name
And Scroll up 1 time(s)
And User searche for the saved user
And check the name in search results and navigate to friend profile page
Then followUser should contain following


Scenario: Remove suggested friend - Find Friend
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And Scroll down 2 time(s)
And User clicks on viewAllRecommendedFriends
And Get the name of the findFriendFirst suggestion
And User clicks on removeSuggestedFriend
Then findFriendFirst should not have friend name



Scenario: Check view all after scrolling 
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And User move to findfriend page
Then viewAllIcon should appear


Scenario: Remove suggested friend and check if its removed from the list
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And Scroll down 2 time(s)
And Get the name of the second suggestion
And User clicks on removeSuggestedFriend
Then secondSuggestedName should not have friend name



Scenario: Add friend from profile and check sync with suggestions box
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And Scroll down 2 time(s)
And User clicks on secondSuggestionImage
And User add a friend then return back
Then cancelRequestButoon should appear



Scenario: Follow friend from profile and check sync with suggestions box - follow button
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And Scroll down 2 time(s)
And User clicks on secondSuggestionImage
And User follow a friend then return back
Then followingButton should appear with following



Scenario: add a friend from contacts
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And User move to findfriend page
And viewAllIcon should appear
And User add a friend from contacts
Then cancelRequest should appear



Scenario: follow a friend from contacts
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And User move to findfriend page
And viewAllIcon should appear
And User follow a friend from contacts
Then baazUpdateFollowingFilter should appear



Scenario: add a friend from contacts from profile
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And User move to findfriend page
And viewAllIcon should appear
And User add friend from profile and return back
Then cancelRequest should appear
And User navigate back
And User clicks on viewAllIcon
And User clicks on contactsTab
Then findContact should appear



Scenario: follow a friend from contacts from profile
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And User move to findfriend page
And viewAllIcon should appear
And User follow friend from profile and return back
Then baazUpdateFollowingFilter should appear
And User navigate back
And User clicks on viewAllIcon
And User clicks on contactsTab
Then findContact should appear



Scenario: invite friend via Whats App - negative case
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And User move to findfriend page
And viewAllIcon should appear
And user invite friend via whatsapp
Then errorMsg should contain sorryErrorMsg



Scenario: invite friend via Messanger - negative case
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And User move to findfriend page
And viewAllIcon should appear
And user invite friend via messanger
Then errorMsg should contain sorryErrorMsg



Scenario: invite friend from phone contacts
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And User move to findfriend page
And viewAllIcon should appear
And user invite friends from phone contacts
Then inviteButton should appear