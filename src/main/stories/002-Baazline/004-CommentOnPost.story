Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development




Scenario: Comment On Baaz Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And Comment on baaz post with comment
Then commentBody should appear with comment



Scenario: Edit comment On Baaz Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And Comment on baaz post with comment
And commentBody should appear with comment
And Edit comment to be editedComment
Then commentBody should appear with editedComment



Scenario:  Comment on Twitter Post
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create twitter post
And Comment on baaz post with twitterComment
Then confirmMsg should appear with replySuccess


Scenario:  Comment on Combined Post
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create combined post
And Comment on baaz post with comment
Then commentBody should appear with comment



Scenario:  Edit comment on Combined Post
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create combined post
And Comment on baaz post with comment
And commentBody should appear with comment
And Edit comment to be editedComment
Then commentBody should appear with editedComment



Scenario:  Comment on Image Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create jpg image post
And Scroll down 2 time(s)
And Comment on baaz post with comment
And Scroll down 1 time(s)
Then commentBody should appear with comment



Scenario:  Edit comment on Image Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create jpg image post
And Scroll down 2 time(s)
And Comment on baaz post with comment
And Scroll down 1 time(s)
And commentBody should appear with comment
And Edit comment to be editedComment
Then commentBody should appear with editedComment



Scenario: comment on shared post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And Share post to like it
And Comment on baaz post with comment
Then commentBody should appear with comment



Scenario: edit comment on shared post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And Share post to like it
And Comment on baaz post with comment
And commentBody should appear with comment
And Edit comment to be editedComment
Then commentBody should appear with editedComment



Scenario: Comment on shared story
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And user copy story from trending and Create post
And Comment on baaz post with comment
Then commentBody should appear with comment



Scenario: Edit comment on shared story
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And user copy story from trending and Create post
And Comment on baaz post with comment
And commentBody should appear with comment
And Edit comment to be editedComment
Then commentBody should appear with editedComment


Scenario: Add comment - Mention 
Meta:
@android
Given I want to create 3 users
When I want to send friend request from user1 to user2 and accept
And I want to send friend request from user1 to user3 and accept
And I want to login with user1email and password is test123456
And Create New Post with baazText
And Comment on baaz post with mention
Then mention Should appear in commentBody


Scenario: Edit comment - Mention 
Meta:
@android
Given I want to create 3 users
When I want to send friend request from user1 to user2 and accept
And I want to send friend request from user1 to user3 and accept
And I want to login with user1email and password is test123456
And Create New Post with baazText
And Comment on baaz post with mention
And mention Should appear in commentBody
And Edit comment to be editedmention
Then edited mention Should appear in comment


Scenario: reply to Twitter Post
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create twitter post
Then Comment on baaz post with twitterComment


Scenario: reply to Twitter Post when have more than one twitter account
Given Open Baaz App
When I want to login with musab1@test.com and password is 123456qw
And Create twitter post
Then Comment on baaz post with twitterComment

