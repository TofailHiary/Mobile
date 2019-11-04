Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@iOS
Scenario: Check The Trending Elements - Main Page
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
Then I want to click on trendThreeDots 
And I want to click on followStory
And I want to click on followedTab
Then I want to check if storyView is exist
And I want to click on storiesTab
And I want to check if searchIcon is exist
And I want to check if trendingFilter is exist
And I want to check if storiesTab is exist
And I want to check if followedTab is exist
And I want to check if topicsSlider is exist
And I want to check if storyTimeStamp is exist
And I want to check if storyArrows is exist
And I want to check if storyKeywords is exist
And I want to check if trendThreeDots is exist
And I want to check if shareStory is exist
Then I want to click on followedTab
And I want to check if trendingFilter is exist
And I want to check if storiesTab is exist
And I want to check if followedTab is exist
And I want to check if storyTimeStamp is exist
And I want to check if storyArrows is exist
And I want to check if storyKeywords is exist
And I want to check if shareStory is exist
And I want to check if trendThreeDots is exist
Then I want to check if noTrendingStories not exist