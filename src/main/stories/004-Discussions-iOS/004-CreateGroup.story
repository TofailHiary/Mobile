Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:  Send Message To Group TC#1
Given I want to create 3 users
Then I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Create group discussion with title Automation Group
And Send message Hello Automation Group


Scenario:  Check If Message Received User 2 TC#2
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent group message equal Hello Automation Group and discussion title equal Automation Group



Scenario:  Check If Message Received User 3 TC#3
Given Open Baaz App
When I want to login with user3email and password is test123456
And I navigate to disucssions
Then Check if recent group message equal Hello Automation Group and discussion title equal Automation Group



Scenario:  Send Arabic Message To Group TC#4
Given I want to create 3 users
Then I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Create group discussion with title اهلا بك في باز
And Send message اهلا بك في باز

Scenario:  Check If Arabic Message Received User 2 TC#5
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent group message equal اهلا بك في باز and discussion title equal اهلا بك في باز 



Scenario:  Check If Arabic Message Received User 3 TC#6
Given Open Baaz App
When I want to login with user3email and password is test123456
And I navigate to disucssions
Then Check if recent group message equal اهلا بك في باز and discussion title equal اهلا بك في باز


Scenario:  Send Emoji Message To Group TC#7
Given I want to create 3 users
Then I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Create group discussion with title Automation Group
Then Send Emoji to Group  



Scenario:  Check If Emoji Message received to user2 TC#8
Given Open Baaz App
Then I want to login with user2email and password is test123456
When I navigate to disucssions
Then Check group message is ☺️☺️☺️☺️☺️☺️☺️☺️☺️

Scenario:  Check If Emoji Message received to user3 TC#9
Given Open Baaz App
Then I want to login with user3email and password is test123456
When I navigate to disucssions
Then Check group message is ☺️☺️☺️☺️☺️☺️☺️☺️☺️

Scenario:  Send URL Message To Group TC#10
Given I want to create 3 users
Then I want to send friend request from user1 to user2 and accept
Then I want to send friend request from user1 to user3 and accept
When I want to login with user1email and password is test123456
And I navigate to disucssions
Then Create group discussion with title Automation Group
Then Send Link www.baaz.com to Group

Scenario:  Check If URL Message Received User 2 TC#11
Given Open Baaz App
When I want to login with user2email and password is test123456
And I navigate to disucssions
Then Check if recent message equal www.baaz.com and discussion title contains Automation Group


Scenario:  Check If URL Message Received User 3 TC#12
Given Open Baaz App
When I want to login with user3email and password is test123456
And I navigate to disucssions
Then Check if recent message equal www.baaz.com and discussion title contains Automation Group
