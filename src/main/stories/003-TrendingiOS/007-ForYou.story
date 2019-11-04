Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development




Meta:
@iOS
Scenario: Topics Of Intrest Negative Cases 
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
And I want to click on forYou
And I want to click on selectMyTobic 
And I want to click on news
And I want to click on saveTopics
Then I want to check if trendingErrorMessage equal You must select at least three topics to continue
And I want to click on dismissMessage
And I want to click on health 
And I want to click on saveTopics
Then I want to check if trendingErrorMessage equal You must select at least three topics to continue
And I want to click on dismissMessage
And I want to click on business 
And I want to click on saveTopics
And wait for 4 second(s)
Then I want to check if storyView is exist




Scenario: Choose Topics From Trending 
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
And I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on forYou
And I want to click on selectMyTobic 
And I want to click on news
And I want to click on business 
And I want to click on health 
And I want to click on saveTopics
And wait for 4 second(s)
Then I want to check if storyView is exist
