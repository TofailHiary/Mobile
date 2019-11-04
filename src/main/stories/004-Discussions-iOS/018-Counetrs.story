Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:  send message to users not friends 
Given I want to create 2 users
When I want to login with user1email and password is test123456
And Search for user2name
Then Send Hello My Friend message to non friend



Scenario: Send Message to User
Given Open Baaz App
Then I want to login with user2email and password is test123456
Then Check mainthread Counter equal 1 item
And I navigate to disucssions
Then Check Threadcounter Counter equal 1
Then Check if recent message equal Hello My Friend and discussion title contains user1name
Then Check message inside room equal Hello My Friend
Then Check Reset mainCounter
Then Check Reset Threadcounter




Scenario: Send Message to User 2
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
Then I navigate to disucssions
Then Send Hello My Friend message to friend


Scenario:  Check If Message Received #2
Given Open Baaz App
Then I want to login with user2email and password is test123456
When I navigate to disucssions
And Check if recent message equal Hello My Friend and discussion title contains user1name
Then Check message inside room equal Hello My Friend

Scenario:  Archive Message Counter
Given Open Baaz App
When I want to login again with user2email and password is test123456
And I navigate to disucssions
Then I want to archive discussion
Then Check archive discussion counter is 1
Then I want to check discussion in archived
And I want to unarchive message
Then Check archive discussion counter is 0
And I wnat to check if discussion unarchived