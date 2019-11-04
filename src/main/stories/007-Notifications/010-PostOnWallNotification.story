Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario: User 1 Post On User 1 Wall
Given I want to create 3 users
When I want to send friend request from user1 to user2 and accept
When I want to send friend request from user1 to user3 and accept
When I want to send friend request from user2 to user3 and accept
Then I want to login with user1email and password is test123456 
When Search for user2name
Then Create New Post with Hello Baaz Text Post

Scenario: User 1 Check Posted On Wall Notification
Given Open Baaz App
When I want to login with user2email and password is test123456 
And I navigate to notifications
Then Check baazline Post on your wall notification


Scenario: User 3 Like Post
Given Open Baaz App
When I want to login with user3email and password is test123456 
Then Like text post


Scenario: User 2 Check Notification
Given Open Baaz App
When I want to login with user3email and password is test123456 
And I navigate to notifications
Then Check baazline Like post on your wall notification



Scenario: User 3 Comment on Post
Given Open Baaz App
When I want to login with user3email and password is test123456 
Then Comment on baaz post with comment on baaz post


Scenario: User 2 Check Notification
Given Open Baaz App
When I want to login with user3email and password is test123456 
And I navigate to notifications
Then Check baazline Comment on post on your wall notification