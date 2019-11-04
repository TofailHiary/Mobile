Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario: User 1 Create new post
Meta:
@android
Given I want to create 2 users
Then I want to send friend request from user1 to user2 and accept
When I want to login with user1email and password is test123456
And Create New Post with baazText
Then Comment on baaz post with comment

Scenario: User 2 Reply Comment
Meta:
@android
Given Open Baaz App
When I want to login with user2email and password is test123456
And Like comment and reply to comment with Hi
Then Check replied comment






