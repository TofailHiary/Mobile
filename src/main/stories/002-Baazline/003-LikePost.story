Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario: Like Baaz Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And User clicks on likeButtonPost
And User clicks on likersButton
Then likerName should contain baazUser
And Unlike text post
Then Check if post without likers



Scenario: Like Combined Post
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create combined post
And User clicks on likeButtonPost
And User clicks on likersButton
Then likerName should contain AutomationAutomation
And Unlike text post
Then Check if post without likers



Scenario: Like Twitter Post
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create twitter post
And User clicks on likeTwitter
Then number of twitter likers should be 1
And User clicks on likeTwitter
Then wait twitterLikers to be invisible



Scenario: Like Twitter Post from details page
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create twitter post
And Like Twitter post from detailed
Then number of twitter likers should be 1
And User clicks on likeTwitter
Then wait twitterLikers to be invisible



Scenario: Like a Post From Details Page 
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with comment
Then Like text post from detailed
When Check who like post
And Unlike text post
Then Check if post without likers


Scenario:Like Image Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create png image post
And Scroll down 1 time(s)
And User clicks on likeButtonPost
When Check who like post
And Unlike text post
Then Check if post without likers



Scenario: Like video post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create video image post
And videoPost should appear
And user like video post and check likers
And Unlike text post
Then Check if post without likers



Scenario: like shared post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And Share post to like it
And User clicks on likeButtonPost
And User clicks on likersButton
Then likerName should contain baazUser
And Unlike text post
Then Check if post without likers


Scenario: like shared story
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And user copy story from trending and Create post
And User clicks on likeButtonPost
And Check who like post
And Unlike text post
Then Check if post without likers
