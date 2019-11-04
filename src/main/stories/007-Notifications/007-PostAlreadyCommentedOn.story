Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario: User 2 comment on User 1 Post
Given I want to create 3 users
When I want to send friend request from user1 to user2 and accept
When I want to send friend request from user1 to user3 and accept
And I want to create 1 post(s) from user1
Then I want to login with user2email and password is test123456 
And Comment on baaz post with comment on baaz post

Scenario: User 3 Comment On User 1 Post
Given Open Baaz App
Then I want to login with user3email and password is test123456 
And Comment on baaz post with comment on baaz post


Scenario:User3 Check Comment On Post Already commented on Notification
Given Open Baaz App
Then I want to login with user2email and password is test123456 
And I navigate to notifications
Then Check baazline Comment on post already commented on notification



