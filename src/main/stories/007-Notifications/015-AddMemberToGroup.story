Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario:  Add Member To Group
Given I want to create 4 users
When I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
Then I want to send friend request from user1 to user4 and accept
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Create group discussion with title Automaiton Group
Then add user4name to group


Scenario:  Check Member added to group notification
Given Open Baaz App
When I want to login with user3email and password is test123456 
And I navigate to notifications
Then Check discussion Add member to group notification



