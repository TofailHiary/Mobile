Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Scenario:Like Post From Profile
Given I want to create 1 users
When I want to login with user1email and password is test123456
Then I navigate to profile
And Create New Post with Hello Baaz Text Post
Then Like text post
When Check who like post
And Unlike text post
Then Check if post without likers



Scenario: Comment On Baaz Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
Then I navigate to profile
And Create New Post with Hello Baaz Text Post
Then Comment on baaz post with comment on baaz post
And Check comment body is equal comment on baaz post
Then Edit comment to be edited comment on baaz post
And Check comment body is equal edited comment on baaz post



Scenario: Quick Share To Baaz
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to profile
Then Create New Post with Hello Baaz Text Post
And Share post to baaz

Scenario: Edit Baaz Post
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to profile
Then Create New Post with Hello Baaz Text Post
When Edit text post with Hello Baaz Edited Text
Then Check if text post Hello Baaz Edited Text exist


Scenario: Delete Baaz Post
Given I want to create 1 users
Then I want to login with user1email and password is test123456
And I navigate to profile
And Create New Post with Hello Baaz Text Post
Then Delete post and check if Hello Baaz Text Post deleted