Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@android
Scenario: Check The Most Trend Posts
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to trending
Then Choose most trend trending filter from trend story
And Check if most trend trending filter working fine




Scenario: Check The Most Recent Posts
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to trending
Then Choose most recent trending filter from trend story
And Check if most recent trending filter working fine




Scenario: Check The Story Keywords
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to trending
Then Check keyword list in story