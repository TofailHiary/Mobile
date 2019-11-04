Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Scenario: Search (User+Post+Story)
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I want to search for user
Then I want to search for post
And I want to search for story



Scenario: Search Negative Cases
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Check negative search
Then confirmMsg should appear with noResultsFound



Scenario:Search - See all results
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User searches for test
And Scroll down 2 time(s)
And User clicks on seeAllResult
Then searchUserResult should contain test



Scenario:Search using Hashtag
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And User searches for hashTag
And Scroll down 2 time(s)
And User clicks on seeAllResult
Then searchUserResult should appear