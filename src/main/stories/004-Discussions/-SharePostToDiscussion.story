Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario: Share Post To Discussion (not completed)
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And Create New Post with myFriendsText
Then Share post to discussion


Scenario:  Check If Message Received and navigate to post detailed page (not completed)
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message contains https://pre-www.baaz.com/post and discussion title contains user1name
Then Check url preview in discusison




