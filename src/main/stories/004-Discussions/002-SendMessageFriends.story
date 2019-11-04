Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Scenario:  Send text Message To Friend #1
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
Then I navigate to disucssions
Then Send myFriendsText message to friend


Scenario:  Check If Message Received #2
Given Open Baaz App
Then I want to login with user2email and password is test123456
When I navigate to disucssions
And Check if recent message equal myFriendsText and discussion title contains user1name
Then Check message inside room equal myFriendsText

Scenario:  Send Message from exist user To Friend
Given Open Baaz App
When I want to login with musab5@test.com and password is 123456qw
And Search for musab1 test
Then Send myFriendsText message to non friend


Scenario:  Check If Message Received
Given Open Baaz App
And I want to login with musab1@test.com and password is 123456qw
When I navigate to disucssions
And Check if recent message equal myFriendsText and discussion title contains musab5 test
Then Check message inside room equal myFriendsText


Scenario:  Send Mixed Message To Friend
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Send mixedMsg message to friend


Scenario:  Send Mixed Message from exist user To Friend
Given Open Baaz App
And I want to login with musab1@test.com and password is 123456qw
When I navigate to disucssions
Then Send mixedMsg message to friend


Scenario:  Send Message with Emoji To Friend
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Send withEmoji message to friend


Scenario:  Send Message with Emoji from exist user To Friend
Given Open Baaz App
And I want to login with musab1@test.com and password is 123456qw
When I navigate to disucssions
Then Send withEmoji message to friend




Scenario:  Send arabic Message To Friend #3
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
Then I navigate to disucssions
Then Send اهلا بك في باز message to friend

Scenario:  Check If arabic Message Received #4
Given Open Baaz App
Then I want to login with user2email and password is test123456
When I navigate to disucssions
And Check if recent message equal اهلا بك في باز and discussion title contains user1name
Then arabic message inside room is اهلا بك في باز


Scenario:  Send Emoji Message To Friend #5
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
Then I navigate to disucssions
Then Send Emoji to friend


Scenario:  Check If Emoji received Message Received #6
Given Open Baaz App
Then I want to login with user2email and password is test123456
When I navigate to disucssions
Then Check if user2 receive ☺️☺️☺️☺️☺️☺️☺️☺️☺️


Scenario:  Send URL Message To Friend #7
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
Then I want to login with user1email and password is test123456
And I navigate to disucssions
Then Send www.baaz.com message to friend

Scenario:  Check If Message Received #8
Given Open Baaz App
Then I want to login with user2email and password is test123456
When I navigate to disucssions
And Check if recent message equal www.baaz.com and discussion title contains user1name
Then Check url preview in discusison


Scenario:  Send URL preview Message To Friend #7
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
Then I want to login with user1email and password is test123456
And I navigate to disucssions
Then Type Www.baaz.com and Check url preview