Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario: Send Message to User (not ready yet)
Given I want to create 3 users
When I want to login with user1email and password is test123456
And Search for user2name
Then Send myFriendsText message to non friend



Scenario:  Send Text Message to User 3 and forward to User 2
Meta: musab
Given Open Baaz App
When I want to login with user1email and password is test123456
And Search for user3name
Then Send myFriendsText2 message to non friend
And Forward text message to second discussion



Scenario:  User 2 check if received forward Text message from user 1
Meta: musab
Given Open Baaz App
Then I want to login with user2email and password is test123456
And I navigate to disucssions
And Check if recent message equal myFriendsText2 and discussion title contains user1name


Scenario:  Send image Message to User 3 and forward to User 2
Meta: musab
Given Open Baaz App
When I want to login with user1email and password is test123456
And Search for user3name
Then Send image message to non friend
And Forward image message to second discussion


Scenario:  User 2 check if received forward image message from user 1
Meta: musab
Given Open Baaz App
Then I want to login with user2email and password is test123456
And I navigate to disucssions
And Check if recent message equal sentYouAPhoto and discussion title contains user1name


Scenario:  Send Media Message to User 3 and forward to User 2
Meta: musab
Given Open Baaz App
When I want to login with user1email and password is test123456
And Search for user3name
Then Send video message to non friend
And Forward video message to second discussion


Scenario:  User 2 check if received forward Media message from user 1
Meta: musab
Given Open Baaz App
Then I want to login with user2email and password is test123456
And I navigate to disucssions
And Check if recent message equal sentYouAVideo and discussion title contains user1name


Scenario:  Send 	Link Message to User 3 and forward to User 2
Meta: musab
Given Open Baaz App
When I want to login with user1email and password is test123456
And Search for user3name
Then Send googleLink message to non friend
And Forward text message to second discussion


Scenario:  User 2 check if received forward Link message from user 1
Meta: musab
Given Open Baaz App
Then I want to login with user2email and password is test123456
And I navigate to disucssions
And Check if recent message equal googleLink and discussion title contains user1name


Scenario: Share Story To Discussion
Meta: musab
Given Open Baaz App
When I want to login with user1email and password is test123456
And I navigate to trending
And Share story to discussion
Then Forward story message to second discussion


Scenario:  User 2 check if received forward Story message from user 1
Meta: musab
Given Open Baaz App
Then I want to login with user2email and password is test123456
And I navigate to disucssions
And Check if recent message equal myFriendsText2 and discussion title contains user1name


Scenario: Send Message to User
Meta: musab
Given I want to create 3 users
And I want to send friend request from user1 to user2 and accept
And I want to send friend request from user1 to user3 and accept
When I want to login with user1email and password is test123456
And Search for user2name
Then Send myFriendsText message to non friend


Scenario: Share Story To Discussion
Meta: musab
Given Open Baaz App
When I want to login with user1email and password is test123456
And I navigate to trending
And Share story to discussion
Then Forward story message to second discussion


Scenario:  User 2 check if received forward Text message from user 1
Meta: musab
Given Open Baaz App
Then I want to login with user2email and password is test123456
And I navigate to disucssions
And Check if recent message equal sentYouAStory and discussion title contains user1name









