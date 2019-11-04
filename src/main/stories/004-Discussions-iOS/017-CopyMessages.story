Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:  send message to users not friends 
Given I want to create 3 users
When I want to login with user1email and password is test123456
And Search for user2name
Then Send Hello My Friend message to non friend
Then Copy messsage

Scenario:  send message to users not friends 
Given Open Baaz App
When I want to login again with user1email and password is test123456
And Search for user3name
Then Paste messsage and send it

Scenario: Send Message to User
Given Open Baaz App
Then I want to login with user3email and password is test123456
And I navigate to disucssions
Then Check if recent message equal Hello My Friend and discussion title contains user1name
Then Check message inside room equal Hello My Friend


