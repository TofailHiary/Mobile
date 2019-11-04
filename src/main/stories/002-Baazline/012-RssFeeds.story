Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Scenario: Like Rss Post
Meta:
@android
Given Open Baaz App
Then I want to login with rssmobile@baazauto.com and password is test123456
When Navigate to rss filter
And Like text post
Then likerName should contain rss
And Unlike text post
Then Check if post without likers


Scenario: Comment On Rss Post
Meta:
@android
Given Open Baaz App
When I want to login with rssmobile@baazauto.com and password is test123456
And Navigate to rss filter
And Get the value of numOfComments
And Comment on baaz post with comment
Then check the number of comments
And I want to scroll down 3 time(s)
Then commentBody should appear with comment


Scenario: Edit comment On Rss Post
Meta:
@android
Given Open Baaz App
When I want to login with rssmobile@baazauto.com and password is test123456
And Navigate to rss filter
And Get the value of numOfComments
And Comment on baaz post with comment
Then check the number of comments
And I want to scroll down 3 time(s)
Then commentBody should appear with comment
And Edit comment to be editedComment
Then commentBody should appear with editedComment