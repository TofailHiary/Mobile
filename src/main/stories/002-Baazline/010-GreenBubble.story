Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development





Scenario: User 1 Create new post and User 2 check green bubble
Meta:
@android
Given I want to create 2 users
Then I want to send friend request from user1 to user2 and accept
When I want to login with user1email and password is test123456 
And I want to create 1 post(s) from user2
Then Check if green bubble equal 1
Then Check if text post Test Post exist



Scenario: User 1 Create new post and User 2 check green bubble
Meta:
@android

Given I want to create 2 users
Then I want to send friend request from user1 to user2 and accept
Then I want to login with user1email and password is test123456
Then I want to create 100 post(s) from user2
Then Check if green bubble equal +99
Then Check if text post Test Post exist