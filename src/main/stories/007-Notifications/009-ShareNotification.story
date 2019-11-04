Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario: User 2 comment on User 1 Post
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to create 1 post(s) from user1
Then I want to login with user2email and password is test123456 
And Share post to baaz


Scenario: User 1 Check Share Notification
Given Open Baaz App
When I want to login with user1email and password is test123456 
And I navigate to notifications
Then Check baazline Shared post notification

