Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:User 1 Mention User 2 in post
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
Then I want to login with user1email and password is test123456 
Then Create Mention Post


Scenario:User2 Check Mention Notification
Given Open Baaz App
Then I want to login with user2email and password is test123456 
And I navigate to notifications
Then Check baazline Mention notification


