Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development




Scenario:  Send Message To Friend
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
Then I navigate to disucssions
Then Send myFriendsText message to friend

Scenario:  Check If Message Received
Given Open Baaz App
Then I want to login with user2email and password is test123456
When I navigate to disucssions
And Check if recent message equal myFriendsText and discussion title contains user1name
Then Check message inside room equal myFriendsText


Scenario:  Send Mixed Message To Friend
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
Then I navigate to disucssions
Then Send mixedMsg message to friend


Scenario:  Send Message with Emoji To Friend
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
Then I navigate to disucssions
Then Send withEmoji message to friend