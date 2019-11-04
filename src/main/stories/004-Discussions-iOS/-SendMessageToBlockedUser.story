Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario:  Send Message To Friend
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
Then I navigate to disucssions
Then Send Hello My Friend message to friend


Scenario:  Block User
Given Open Baaz App
When I want to login with user1email and password is test123456
And Search for user2name
Then Block user

Scenario:  Check Error Message When send message to blocked user
Given Open Baaz App
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then I want to send message to blocked user

