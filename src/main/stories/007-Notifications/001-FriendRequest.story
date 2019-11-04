Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario: Check Friend Request Notification And Accept
Given I want to create 2 users
When I want to send friend request from user1 to user2 without accept
And I want to login with user2email and password is test123456 
Then I navigate to notifications
And Check friend request and accept

Scenario: Check Friend Request Notification And Decline
Given I want to create 2 users
When I want to send friend request from user1 to user2 without accept
Then I want to login with user2email and password is test123456 
And I navigate to notifications
And Check friend request and decline

Scenario: Check View All Friend Request and check back button
Given I want to create 3 users
When I want to send friend request from user1 to user2 without accept
And I want to send friend request from user3 to user2 without accept
Then I want to login with user2email and password is test123456 
And I navigate to notifications
Then Check friend request list from view all button and check back button


Scenario:Check Avatar Button Lead User to profile page From Friend Request List
Given I want to create 3 users
When I want to send friend request from user1 to user2 without accept
Then I want to login with user2email and password is test123456 
And I navigate to notifications
Then Check when click on avatar will lead user to profile page
