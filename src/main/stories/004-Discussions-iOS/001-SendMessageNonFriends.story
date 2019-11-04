Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:  send message to users not friends 
Given I want to create 2 users
When I want to login with user1email and password is test123456
And Search for user2name
Then Send myFriendsText message to non friend



Scenario: Send Message to User
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal myFriendsText and discussion title contains user1name
And Check message inside room equal myFriendsText





