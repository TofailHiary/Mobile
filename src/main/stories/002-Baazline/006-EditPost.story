Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario: Edit Post 
Meta:
@android
Given I want to create 1 users
Then I want to login with user1email and password is test123456 
When Create New Post with baazText
And Edit text post with editedPost
Then textPost should appear with editedPost



Scenario:  Edit Combined Post
Meta:
@android
Given Open Baaz App
Then I want to login with baazmobile2017@gmail.com and password is test123456 
When Create combined post
And Edit text post with editedPost
Then textPost should appear with editedPost


Scenario: Edit Post From Detailed
Meta:
@android
Given I want to create 1 users
Then I want to login with user1email and password is test123456 
When Create New Post with baazText
And Edit text post from detailed with editedPost
Then textPost should appear with editedPost



Scenario: edit shared post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And Share post with text
And User edit shared post with editedPost
Then sharedPostText should appear with editedPost



Scenario: edit shared post privacy
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And Share post with text
And User change shared post privacy
Then sharedPostText should appear with onlyMeText