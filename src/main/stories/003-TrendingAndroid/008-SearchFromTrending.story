Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@android
Scenario: Trending Search 
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on searchIcon
And I want to fill searchTextField with Baaz User1512988216344
And I want to click on seeAllResult
Then I want to check if searchUserResult equal Baaz User1512988216344 Last Baaz
And I want to fill searchTextField with Baaz Post 1514396222869
And I want to click on seeAllResult
And I want to click on postsResult
Then I want to check if searchPostResult equal Baaz Post 1514396222869
And I want to fill searchTextField with Story By Mobile Automation
And I want to click on seeAllResult
And I want to click on storiesResult
Then I want to check if searchStoriesResult equal Create Story By Mobile Automation




Scenario: Cancel Trending Search 
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on searchIcon
And I want to fill searchTextField with test
And I want to click on cancelSearch
Then I want to check if followedTab is exist



Scenario: Trending Search By Story Keywords 
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on storyKeywordsFromDetailed
And I want to click on firstKeyword
Then I want to check if postsResult is exist
And I want to click on storiesResult
Then I want to check if searchStoriesResult is exist


Scenario: Cancel Trending Search By Story Keywords 
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on storyKeywordsFromDetailed
And I want to click on firstKeyword
Then I want to click on cancelPeopleSearch
Then I want to click on cancelSearch
Then I want to check if storyStatisticsFromDetailed is exist





Scenario: Trending Search By Keywords From More Icon 
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on moreIcon
And I want to click on keyWords
And I want to click on firstKeyword
Then I want to check if postsResult is exist


Scenario: Cancel Trending Search By Keywords From More Icon 
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on moreIcon
And I want to click on keywords
Then I want to click on closeKeywordsPopup
Then I want to check if storyStatisticsFromDetailed is exist
