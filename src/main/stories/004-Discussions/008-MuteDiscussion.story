Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario:Mute Discussion and Unmute.
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
And Send myFriendsText message to friend
And User Mute discussion
Then Check if discussion muted on room
And User Unmute discussion
Then Check if discussion unmuted on room


Scenario:Mute Group Discussion and Unmute. (not ready yet)
Given I want to create 3 users
And I want to send friend request from user1 to user2 and accept
And I want to send friend request from user1 to user3 and accept
When I want to login with user1email and password is test123456
And I navigate to disucssions
And Create group discussion with title automaitonGroup
And Send message automationMsg
And User Mute discussion
Then Check if discussion muted on room
And User Unmute discussion
Then Check if discussion unmuted on room