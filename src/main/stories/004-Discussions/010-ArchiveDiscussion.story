Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Meta:
@android
Scenario: Send Message to User
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
Then I navigate to disucssions
Then Send myFriendsText message to friend

Scenario:  User 2 Archive Message
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
And I want to archive discussion
Then archived should appear
Then I want to check discussion in archived
And I want to unarchive message
Then newDiscussion should appear
And firstDiscussion should appear


Scenario:  User 2 Archive Message then undo
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
And I want to archive discussion
And archived should appear
And User clicks on undoArchive
Then newDiscussion should appear
And firstDiscussion should appear


Scenario:  Remove archived message
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
And I want to archive discussion
And archived should appear
And I want to check discussion in archived
Then User removes archived message