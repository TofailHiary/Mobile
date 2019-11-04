Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario: User1 blocked User2
Given I want to create 2 users
When I want to login with user1email and password is test123456
And Search for user2name
Then Block user


Scenario: Check Blocked Users List 
Given Open Baaz App
When I want to login with user1email and password is test123456
And I navigate to settings
Then Check if blocked user list contains user2name



Scenario: User1 Check User2 in searech
Given Open Baaz App
When I want to login with user1email and password is test123456
And Search for user2name
Then Check if user page not available



Scenario: User1 Unblock User2 
Given Open Baaz App
When I want to login with user1email and password is test123456
And I navigate to settings
Then Unblock user



Scenario: User1 Check if he can access User2 Profile
Given Open Baaz App
When I want to login with user1email and password is test123456
And Search for user2name
Then Check if user page available
