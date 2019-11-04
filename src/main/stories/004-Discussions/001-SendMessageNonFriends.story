Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario: Send message to users not friends

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



Scenario: Send message from exist user to users not friends

Given I want to create 1 users
When I want to login with musab5@test.com and password is 123456qw
And Search for user1name
Then Send myFriendsText message to non friend


Scenario: Send Message to User
Given Open Baaz App
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Check if recent message equal myFriendsText and discussion title contains musab5 test
And Check message inside room equal myFriendsText
