Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Meta:
@android
Scenario: Send Message to User
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
Then I navigate to disucssions
Then Send Hello My Friend message to friend

Scenario:  Archieve and delete discussion
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then I want to delete discussion





