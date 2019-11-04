Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:  Create New Group 
Given I want to create 3 users
Then I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Create group discussion with title Automation Group


Scenario:  let User 2 Leave Discussion and check if user left 
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then User leave discussion room and check if user let the group


