Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development




Scenario: Check Suggested Friends Box
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And Scroll down 2 time(s)
Then Check suggested friends box



Scenario: Add suggested friend and check if its removed from the list
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And Scroll down 3 time(s)
And Get the name of the second suggestion
And User add a friend
Then secondSuggestedName should not have friend name



Scenario: follow suggested friend and check if its removed from the list
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And Scroll down 3 time(s)
And Get the name of the second suggestion
And User follow a friend
Then secondSuggestedName should not have friend name



Scenario: View all suggested friends
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And Scroll down 2 time(s)
And User clicks on viewAllRecommendedFriends
Then suggestedTab should appear



Scenario: Check view all after scrolling 
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User clicks on resendEmail
And Scroll down 2 time(s)
And Scroll right 15 time(s)
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


