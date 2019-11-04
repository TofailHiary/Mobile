Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Meta:
@skip
Scenario: User 1 Create new post
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
When I want to login with user1email and password is test123456 
And Create New Post with Hello Baaz Text Post
Then Comment on baaz post with comment on baaz post



Scenario: User 2 Reply Comment
Given Open Baaz App
Then I want to login with user2email and password is test123456 
And Like comment and reply to comment with Hi



Scenario: User 1 Check Notification
Given Open Baaz App
When I want to login with user1email and password is test123456 
And I navigate to notifications
Then Check baazline Mentioned in comment notification