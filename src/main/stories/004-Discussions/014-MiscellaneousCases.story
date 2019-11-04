Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Meta:
@android
Scenario: scroll to top to view old messages
Given Open Baaz App
When I want to login with testscroll2@baaz.com and password is 123456qw
And I navigate to disucssions
Then Check Scrolling inside room


Scenario: View Image
Given Open Baaz App
When I want to login with testscroll2@baaz.com and password is 123456qw
And I navigate to disucssions
Then User check open Image


Scenario: Save Image
Given Open Baaz App
When I want to login with testscroll2@baaz.com and password is 123456qw
And I navigate to disucssions
Then User check save Image


Scenario: close Image
Given Open Baaz App
When I want to login with testscroll2@baaz.com and password is 123456qw
And I navigate to disucssions
Then User check close Image


Scenario: Open Video
Given Open Baaz App
When I want to login with testscroll2@baaz.com and password is 123456qw
And I navigate to disucssions
Then User check open Image


Scenario: Save Video
Given Open Baaz App
When I want to login with testscroll2@baaz.com and password is 123456qw
And I navigate to disucssions
Then User check save Image


Scenario: close Video
Given Open Baaz App
When I want to login with testscroll2@baaz.com and password is 123456qw
And I navigate to disucssions
Then User check close Image


Scenario: check the screen when you have no discussions and no friends
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then check that no discussions and no friends


Scenario: Date outside in the list of messages
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
And Send myFriendsText message to friend
And User navigate back
Then justNowLabel should appear


Scenario: Mute when long Press on a message (not completed)
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
And Send myFriendsText message to friend
Then Check mute when long press on a discussion


Scenario: Archive when long Press on a message (not completed)
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
And Send myFriendsText message to friend
Then Check archive when long press on a discussion


Scenario: Veiw friend profile in 1-1 discussion
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
And Send myFriendsText message to friend
Then view Friend's profile


Scenario: open archived discussions and view the messages 
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then Send myFriendsText message to friend


Scenario: open archived discussions and view the messages 
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
And I want to archive discussion
And archived should appear
And I want to check discussion in archived
Then user opens first discussion and check counter


Scenario: Don't give permission to take photo or video
Given I want to create 2 users
When I want to send friend request from user1 to user2 and accept
And I want to login with user1email and password is test123456
And I navigate to disucssions
Then check when don't give permession to open camera




