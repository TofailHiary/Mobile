Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario: Add Post From Friend
Meta:
@android
Given Open Baaz App
When I want to create 3 users
Then I want to send friend request from user1 to user2 and accept
When I want to send friend request from user1 to user3 without accept
And I want to login with user2email and password is test123456
Then Create New Post with friendText


Scenario: Add Post From Following
Meta:
@android
Given Open Baaz App
Then I want to login with user3email and password is test123456
Then Create New Post with followingText


Scenario: Add Post From Friend
Meta:
@android
Given Open Baaz App
When I want to create 3 users
Then I want to send friend request from user1 to user2 and accept
When I want to send friend request from user1 to user3 without accept
And I want to login with user2email and password is test123456
Then Create New Post with friendText


Scenario: Add Post From Following
Meta:
@android
Given Open Baaz App
Then I want to login with user3email and password is test123456
Then Create New Post with followingText



Scenario: Check Baazline Update Filter
Meta:
@android
Given Open Baaz App
When I want to login with user1email and password is test123456
Then Check friends filter
Then Check if text post Hello Baaz Text Post Friend exist
And Check following filter
Then Check if text post Hello Baaz Text Post Following exist