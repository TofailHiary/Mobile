Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:  Delete Image before sending
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then remove imageBeforeSending

Scenario:  Delete video before sending
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then remove videoBeforeSending


Scenario: Remove image from message field
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then remove imageFromField


Scenario: Remove video from message field
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then remove videoFromField