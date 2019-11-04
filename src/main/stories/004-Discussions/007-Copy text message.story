Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario: Send Message to User (not ready yet)
Given I want to create 2 users
When I want to login with user1email and password is test123456
And Search for user2name
And Send myFriendsText message to non friend
And Copy text message
Then errorMsg should appear with textCopied



