Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:  Send Message To Group
Given I want to create 3 users
Then I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Create group discussion with title automaitonGroup
And Send message automationMsg


Scenario:  Check If Message Received User 2 
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent group message equal Hello Automation Group and discussion title equal Automation Group 


Scenario:  Check If Message Received User 3
Given Open Baaz App
When I want to login with user3email and password is test123456
And I navigate to disucssions
Then Check if recent group message equal Hello Automation Group and discussion title equal Automation Group 