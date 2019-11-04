Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:  Check if user that create a group is admin
Given I want to create 3 users
Then I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Create group discussion with title Automation Group
Then Check if user1 admin
