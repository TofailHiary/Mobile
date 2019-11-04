Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Scenario:  Send URL Message To Friend
Given Open Baaz App
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
Then I want to login with user1email and password is test123456
And I navigate to disucssions
Then Send googleLink message to friend


Scenario:  Check If Message Received
Given Open Baaz App
Then I want to login with user2email and password is test123456
When I navigate to disucssions
And Check if recent message equal googleLink and discussion title contains user1name
Then Check url preview in discusison


Scenario:  Send baaz link Message To Friend
Given Open Baaz App
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
Then I want to login with user1email and password is test123456
And I navigate to disucssions
Then Send link message to friend


Scenario:  Check If Message Received
Given Open Baaz App
Then I want to login with user2email and password is test123456
When I navigate to disucssions
And Check if recent message equal link and discussion title contains user1name
Then Check url preview in discusison