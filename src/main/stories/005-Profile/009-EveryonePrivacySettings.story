Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@android
Scenario: Check Everyone privacy
Given I want to create 4 users
When I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user2 to user3 and accept
And I want to login with user1email and password is test123456 
And I navigate to settings
Then Choose everyone privacy for all privacy settings


Scenario: Your Friend check your data
Given Open Baaz App
When I want to login with user2email and password is test123456
And Search for user1name
Then Check if data available


Scenario:  friend of my friend checked my profile 
Given Open Baaz App
When I want to login with user3email and password is test123456
And Search for user1name
Then Check if data available



Scenario: Baaz User Checked my profile
Given Open Baaz App
When I want to login with user4email and password is test123456
And Search for user1name
Then Check if data available






