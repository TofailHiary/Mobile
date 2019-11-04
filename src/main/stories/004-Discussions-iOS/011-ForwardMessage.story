Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario: Send Message to User TC#1
Given I want to create 3 users
When I want to login with user1email and password is test123456
And Search for user2name
Then Send myFriendsText message to non friend

Scenario:  Send Message to User 3 and forward to User 2 TC#2
Given Open Baaz App
When I want to login again with user1email and password is test123456
And Search for user3name
Then Send myFriendsText2 message to non friend
And Forward message to second discussion

Scenario:  User 2 check if received forward message from user 1 TC#3
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal Hello My Friend 2 and discussion title contains user1name

Scenario: Send Message to User TC#4
Given I want to create 3 users
When I want to login with user1email and password is test123456
And Search for user2name
Then Send Hello My Friend message to non friend

Scenario:  Send Image to User 3 and forward to User 2 TC#5
Given Open Baaz App
When I want to login again with user1email and password is test123456
And Search for user3name
Then Sends Image to forforward
Then Forward Image to second discussion

Scenario:  User 2 check if received forward Image message from user 1 TC#6
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal Image and discussion title contains user1name


Scenario: Send Message to User TC#7
Given I want to create 3 users
When I want to login with user1email and password is test123456
And Search for user2name
Then Send Hello My Friend message to non friend

Scenario:  Send Video to User 3 and forward to User 2 TC#8
Given Open Baaz App
When I want to login again with user1email and password is test123456
And Search for user3name
Then Sends Video to forforward
Then Forward video to second discussion

Scenario:  User 2 check if received forward Video message from user 1 TC#9
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
<<<<<<< HEAD:src/main/stories/004-Discussions-iOS/011-ForwardMessage.story
And Check if recent message equal myFriendsText2 and discussion title contains user1name
=======
Then Check if recent message equal Video and discussion title contains user1name
>>>>>>> 0809ce5db513c6dac26a47c6b9598a909fb37d59:src/main/stories/004-Discussions/011-ForwardMessage.story

Scenario: Send Message to User TC#10
Given I want to create 3 users
When I want to login with user1email and password is test123456
And Search for user2name
Then Send Hello My Friend message to non friend

Scenario: Send Link to User TC#11
Given Open Baaz App
When I want to login again with user1email and password is test123456
And Search for user3name
Then Send www.baaz.com message to non friend
Then Forward link to second discussion

Scenario:  User 2 check if received forward Link message from user 1 TC#12
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal www.baaz.com and discussion title contains user1name
