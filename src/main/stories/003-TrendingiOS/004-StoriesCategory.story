Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@iOS
Scenario: Check Story Category
Given I want to create news topic from user1
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
And I want to click on news
And I want to click on trendThreeDots
And I want to click on storyStatistics
Then I want to check if categoryStatistics equal News
And I want to click on backFromStatistics
And I want to tap on storyView
Then I want to check if categoryTitle equal News
And I want to click on storyStatisticsFromDetailed
Then I want to check if categoryStatistics equal News
And I want to click on backFromStatistics
And I want to click on moreIcon
And I want to click on storyStatistics
Then I want to check if categoryStatistics equal News
