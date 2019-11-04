Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Scenario:  Send text Message To Friend #1
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
Then I navigate to disucssions
Then Send Hello My Friend message to friend

Scenario:  Check If Message Received #2 and Check seperator appear
Given Open Baaz App
Then I want to login with user2email and password is test123456
When I navigate to disucssions
And Check if recent message equal Hello My Friend and discussion title contains user1name
Then Check message inside room equal Hello My Friend
Then Check seperator inside Discussion appear

Scenario:  Check If Message Received #2 and Check seperator not appear
Given Open Baaz App
Then I want to login again with user2email and password is test123456
When I navigate to disucssions
And Check if recent message equal Hello My Friend and discussion title contains user1name
Then Check message inside room equal Hello My Friend
Then Check seperator inside Discussion notAppear

Scenario:  Send Image To a Friend TC#1 and open it 
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Sends Image to Friend
Then Open Image



Scenario:  Send Video To a Friend TC#3 and open it 
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Sends Video to Friend
Then Open Video

Scenario:  Check if user who is  create a group is admin
Given I want to create 3 users
Then I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Create group discussion with title Automation Group
Then Check if user1 admin