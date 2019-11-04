Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@android

Scenario: Follow and Unfollow Story From Main Page and main Follow Icon 
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to trending
Then Follow story from trending main page
And Check if story followed
Then Unfollow story from trending main page
Then Check if story unfollowed

Scenario: Follow and Unfollow Story From Main Follow Icon 
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to trending
And Follow story from follow icon in trending main page
And Check if story followed
Then Unfollow story from unfollow icon in trending main page
Then Check if story unfollowed


Scenario: Follow and Unfollow Story From Detailed
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to trending
Then Follow story from trending detailed page
And Check if story followed
Then Unfollow story from trending detailed page
Then Check if story unfollowed

Scenario: Follow and Unfollow Story From slide view 
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to trending
Then Follow Story from Slide view
And Check if story followed
Then Unfollow story from Slide view
Then Check if story unfollowed







