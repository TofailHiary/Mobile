Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Meta:
@iOS

Scenario:  Send Image To a Friend TC#1
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Sends Image to Friend


Scenario:  Check if user 2 Received  Image TC#2
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal Image and discussion title contains user1name




Scenario:  Send Video To a Friend TC#3
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Sends Video to Friend


Scenario:  Check if user 2 Received  Video TC#4
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal Video and discussion title contains user1name


Scenario:  Check delete image or video before send TC#5
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Delete image or video before Send




Scenario:  Check Send image to Group send TC#6
Given I want to create 3 users
Then I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Create group discussion with title Automation Group
Then Sends Image to Group


Scenario:  Check if user 2 Received  Image TC#7
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal Image and discussion title contains Automation Group


Scenario:  Check if user 3 Received  Image TC#8
Given Open Baaz App
When I want to login with user3email and password is test123456
And I navigate to disucssions
Then Check if recent message equal Image and discussion title contains Automation Group

Scenario:  Check Send video to Group send TC#8
Given I want to create 3 users
Then I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Create group discussion with title Automation Group
Then Sends Video to Group


Scenario:  Check if user 2 Received  Video TC#9
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal Video and discussion title contains Automation Group

Scenario:  Check if user 3 Received  Video TC#9
Given Open Baaz App
When I want to login with user3email and password is test123456
And I navigate to disucssions
Then Check if recent message equal Video and discussion title contains Automation Group

Meta:
@Skip
Scenario:  Send Image(JPG) To a Friend
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Sends Jpg Image to Friend

Scenario: User 2 Received Image
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal sent you a photo and discussion title contains user1name

Scenario:  Send Image(Png) To a Friend
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Sends Png Image to Friend

Scenario: User 2 Received Image
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal sent you a photo and discussion title contains user1name

Scenario:  Send Image(Gif) To a Friend
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Sends Gif Image to Friend

Scenario: User 2 Received Image
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal sent you a photo and discussion title contains user1name

Scenario:  Send Video(MP4) To a Friend
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Sends Mp4 Image to Friend

Scenario: User 2 Received Video
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal sent you a video and discussion title contains user1name
