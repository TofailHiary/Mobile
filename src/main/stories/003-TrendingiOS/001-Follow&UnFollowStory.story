Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@iOS
Scenario: Follow and Unfollow Story From Main Page
Given I want to create 1 users
Then I want to login with user1email and password is test123456 
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on trendThreeDots
And I want to click on followStory
And I want to click on followedTab
Then I want to check if storyView is exist
And I want to click on trendThreeDots
And I want to click on unFollowStory
And I want to click on confirUnFollow
Then I want to check if trendThreeDots not exist



Scenario: Follow and Unfollow Story From Detailed
Given I want to create 1 users
Then I want to login with user1email and password is test123456 
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to tap on storyView
And I want to click on followFromDetailed
And wait for 3 second(s)
And I want to click on backFromTrendingDetailed
And I want to click on followedTab
Then I want to check if storyView is exist
And I want to click on storiesTab
And wait for 2 second(s)
And I want to tap on storyView
And I want to click on unFollowFromDetailed
And I want to click on confirUnFollow
And I want to click on backFromTrendingDetailed
And I want to click on followedTab
Then I want to check if noTrendingStories equal You haven't followed any stories yet Start exploring and following Stories of your interest and stay up to speed



Scenario: Follow and Unfollow Story From Detailed 3 Dots
Given I want to create 1 users
Then I want to login with user1email and password is test123456 
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to tap on storyView
And I want to click on moreIcon
And I want to click on followStory
And I want to click on backFromTrendingDetailed
And I want to click on followedTab
Then I want to check if storyView is exist
And I want to click on storiesTab
And wait for 2 second(s)
And I want to tap on storyView
And I want to click on moreIcon
And I want to click on unFollowStory
And I want to click on confirUnFollow
And I want to click on backFromTrendingDetailed
And I want to click on followedTab
Then I want to check if noTrendingStories equal You haven't followed any stories yet Start exploring and following Stories of your interest and stay up to speed
