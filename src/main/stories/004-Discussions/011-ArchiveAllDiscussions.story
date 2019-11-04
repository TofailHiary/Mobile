Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Meta:
@android
Scenario: Archive all discussions
Meta: musab
Given I want to create 4 users
When I want to send friend request from user1 to user2 and accept
And I want to send friend request from user1 to user3 and accept
And I want to send friend request from user1 to user4 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
And Send messages to multi friends
And I want to archive ALL discussion
Then archived should appear
And I want to check discussion in archived
And I want to unarchive ALL message
Then newDiscussion should appear
And firstDiscussion should appear