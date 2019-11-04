Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario:User 1 Mention User 2 in post
Given I want to create 3 users
When I want to send friend request from user1 to user2 and accept
When I want to send friend request from user1 to user3 and accept
Then I want to login with user1email and password is test123456 
Then Create Mention Post

Scenario:User3 Comment On User1 Post
Given Open Baaz App
Then I want to login with user3email and password is test123456 
Then Comment on baaz post with comment on baaz post

Scenario:User2 Check Comment Notification
Given Open Baaz App
When I want to login with user2email and password is test123456 
And I navigate to notifications
Then Check baazline Comment on mention post notification


