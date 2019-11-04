Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:Create Mention Post
Meta:
@android
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456 
Then Create Mention Post


Scenario:Remove Mention
Meta:
@android
Given Open Baaz App
When I want to login with user2email and password is test123456 
And Remove Mention
And User clicks on textPost
Then textPost should appear


Scenario:Edit Mention Post
Meta:
@android
Given I want to create 3 users
When I want to send friend request from user1 to user2 and accept
And I want to send friend request from user1 to user3 and accept
And I want to login with user1email and password is test123456 
And Create Mention Post
Then edit mention


Scenario:Edit Mention for shared post
Meta:
@android
Given I want to create 3 users
When I want to send friend request from user1 to user2 and accept
And I want to send friend request from user1 to user3 and accept
And I want to login with user1email and password is test123456
And Create New Post with baazText 
And Share post with mention
Then User edit shared post with mention


Scenario: create mention post with video
Meta:
@android
Given I want to create 3 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And Create video post with mention
Then videoPost should appear


Scenario: Share To SN - mention user 
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create New Post with baazText
And Share post to SN withMention
Then mentionShared should appear

