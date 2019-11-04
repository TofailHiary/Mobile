Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Meta:
@android
Scenario: create users
Given I want to create 4 users
When I want to send friend request from user1 to user2 and accept
And I want to send friend request from user1 to user3 and accept
And I want to send friend request from user1 to user4 and accept
And I want to login with user2email and password is test123456
And I navigate to disucssions
And Send myFriendsText message to friend


Scenario: send message from second user
Given Open Baaz App
When I want to login with user3email and password is test123456
And I navigate to disucssions
And Send myFriendsText message to friend


Scenario: send message from third user
Given Open Baaz App
When I want to login with user4email and password is test123456
And I navigate to disucssions
And Send myFriendsText message to friend


Scenario: Check Discussion counters on discussion list
Given Open Baaz App
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Counters should appear correctly


Scenario: The counter for archived discussions
Given Open Baaz App
When I want to login with user1email and password is test123456
And I navigate to disucssions
And I want to archive discussion
And archived should appear
And I want to check discussion in archived
Then firstCounter should appear with 1


Scenario: Discussion counter when open the discussion
Given Open Baaz App
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then user opens first discussion and check counter



