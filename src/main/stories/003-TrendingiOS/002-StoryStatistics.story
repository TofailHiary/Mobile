Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@iOS
Scenario: Statistics Story From Main Page
Given I want to create 1 users
When I want to click on login
And I want to click on loginWithEmail
And I want to fill loginEmail with user1email
And I want to fill loginPassword with test123456
And I want to click on loginToBaaz
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on trendThreeDots
And I want to click on storyStatistics
And wait for 1 second(s)
Then I want to check if numOfPosts is exist
Then I want to check if nomOfPosts24 is exist





Scenario: Statistics Story From Detailed
Given I want to create 1 users
When I want to click on login
And I want to click on loginWithEmail
And I want to fill loginEmail with user1email
And I want to fill loginPassword with test123456
And I want to click on loginToBaaz
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to tap on storyView
And I want to click on storyStatisticsFromDetailed
And wait for 1 second(s)
Then I want to check if numOfPosts is exist
Then I want to check if nomOfPosts24 is exist



Scenario: Statistics Story From Detailed 3 Dots
Given I want to create 1 users
When I want to click on login
And I want to click on loginWithEmail
And I want to fill loginEmail with user1email
And I want to fill loginPassword with test123456
And I want to click on loginToBaaz
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to tap on storyView
And I want to click on moreIcon
And I want to click on storyStatistics
And wait for 1 second(s)
Then I want to check if numOfPosts is exist
Then I want to check if nomOfPosts24 is exist
