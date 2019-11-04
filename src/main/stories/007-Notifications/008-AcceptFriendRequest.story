Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario: Check Friend Request And Accept
Given I want to create 2 users
When I want to send friend request from user1 to user2 without accept
Then I want to login with user2email and password is test123456 
And I navigate to notifications
Then Check friend request and accept


Scenario: Check Accept Friend Request Notification
Given Open Baaz App
Then I want to login with user1email and password is test123456 
And I navigate to notifications
Then Check baazline Accept friend request notification