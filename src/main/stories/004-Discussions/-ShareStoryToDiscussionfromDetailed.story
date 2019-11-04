Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@android
Scenario: Share Story To Discussion
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
Then I want to login with user1email and password is test123456
And I navigate to trending
And Share story to discussion from detailed page



Scenario:  Check If Message Received and navigate to story
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message contains sent you a story and discussion title contains user1name
And Check story preview in discusison





