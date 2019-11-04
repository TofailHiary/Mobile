Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development




Scenario:  Send Message To Friend
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
Then I navigate to disucssions
Then Send myFriendsText message to friend


Scenario:  Check If Message Received
Given Open Baaz App
Then I want to login with user2email and password is test123456
When I navigate to disucssions
And Check if recent message equal myFriendsText and discussion title contains user1name
Then Check message inside room equal myFriendsText


Scenario:  Send Image(JPG) To a Friend
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Send Jpg Image to Friend

Scenario: User 2 Received Image
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal sentYouAPhoto and discussion title contains user1name


Scenario:  Send Video(MP4) To a Friend (not ready yet)
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Send Mp4 Image to Friend

Scenario: User 2 Received Video (not ready yet)
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal sentYouAVideo and discussion title contains user1name



