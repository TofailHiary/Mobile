Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario: Delete Baaz Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And Delete post
Then check textPost doesn't have baazText


Scenario:  Delete Twitter Post
Meta:
@android
Given Open Baaz App
Then I want to login with musab1@test.com and password is 123456qw
When Create twitter post
Then Delete twitter post and check if deleted


Scenario:  Delete Combined Post
Meta:
@android
Given Open Baaz App
Then I want to login with baazmobile2017@gmail.com and password is test123456 
When Create combined post
Then Delete combined post and check if deleted


Scenario: delete shared post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And Share post with text
And Delete shared post
Then wait textForSharedPost to be invisible


Scenario: delete shared post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And user copy story from trending and Create post
And Delete shared post
Then wait textForSharedPost to be invisible


Scenario: delete shared story
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And user copy story from trending and Create post
Then delete shared story


Scenario: delete comment On Baaz Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And Comment on baaz post with comment
And commentBody should appear with comment
Then delete comment


Scenario: delete comment on shared post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And Share post to like it
And Comment on baaz post with comment
And commentBody should appear with comment
Then delete comment


Scenario: delete comment on shared story
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And user copy story from trending and Create post
And Comment on baaz post with comment
And Scroll down 1 time(s)
And commentBody should appear with comment
Then delete comment


Scenario: Delete comment On Rss Post
Meta:
@android
Given Open Baaz App
When I want to login with rssmobile@baazauto.com and password is test123456
And Navigate to rss filter
And Get the value of numOfComments
And Comment on baaz post with comment
And I want to scroll down 1 time(s)
And check the number of comments
And I want to scroll down 3 time(s)
And commentBody should appear with comment
Then delete RSS comment