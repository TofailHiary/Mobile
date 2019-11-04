Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:  Edit Group Name
Given I want to create 3 users
When I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
And I want to login with user1email and password is test123456
When I navigate to disucssions
And Create group discussion with title automaitonGroup
Then Edit group name to editedGroupName


Scenario:  Check If Group Name Edited For User 2
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then discussionTitle should appear with editedGroupName




Scenario:  Check If Group Name Edited For User 3
Given Open Baaz App
Then I want to login with user3email and password is test123456
And I navigate to disucssions
Then discussionTitle should appear with editedGroupName


Scenario:  Edit Group Image
Given I want to create 3 users
When I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
And I want to login with user1email and password is test123456
When I navigate to disucssions
And Create group discussion with title automaitonGroup
Then Edit group Image


