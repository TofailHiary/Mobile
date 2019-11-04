Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Meta:
@iOS
Scenario: Share Story From Main Page (Quick Share To Baazline)
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
And I want to click on shareStory
And I want to click on quickSharePost
And I navigate to baazline
Then I want to check if sharedStory is exist
Then I want to check if sharedOwner contains user1name
Then I want to check if sharedOwner contains shared this story




Scenario: Share Story From Main Page (Share To Facebook)
Given Open Baaz App
When I want to click on login
And I want to click on loginWithEmail
And I want to fill loginEmail with baazmobile2017@gmail.com
And I want to fill loginPassword with test123456
And I want to click on loginToBaaz
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on shareStory
And I want to click on shareSNPost
And I want to click on facebookAvatar
And I want to click on addPost
Then wait for 2 second(s)
And I navigate to baazline
And I want to click on facebookFilter
And I want pull to refresh
Then I want to check if sharedOwner contains Forgot User
Then I want to check if sharedOwner contains shared this story
Then I want to check if sharedStory is exist



Scenario: Share Story From Main Page (Share To Twitter)
Given Open Baaz App
When I want to click on login
And I want to click on loginWithEmail
And I want to fill loginEmail with baazmobile2017@gmail.com
And I want to fill loginPassword with test123456
And I want to click on loginToBaaz
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on shareStory
And I want to click on shareSNPost
And I want to click on twitterAvatar
And I want to click on addPost
Then wait for 2 second(s)
And I navigate to baazline
And I want to click on twitterFilter
And I want pull to refresh
Then I want to check if sharedOwner contains Forgot User
Then I want to check if sharedOwner contains shared this story
Then I want to check if sharedStory is exist




Scenario: Share Story From Detailed (Quick Share to Baazline)
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
And I want to click on shareFromDetailed
And I want to click on quickSharePost
Then wait for 3 second(s)
And I want to click on backFromTrendingDetailed
And I navigate to baazline
Then wait for 3 second(s)
And I want pull to refresh
Then I want to check if sharedStory is exist
Then I want to check if sharedOwner contains user1name
Then I want to check if sharedOwner contains shared this story



Scenario: Share Story From Detailed (Share To Twitter)
Given Open Baaz App
When I want to click on login
And I want to click on loginWithEmail
And I want to fill loginEmail with baazmobile2017@gmail.com
And I want to fill loginPassword with test123456
And I want to click on loginToBaaz
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to tap on storyView
And I want to click on shareFromDetailed
And I want to click on shareSNPost
And I want to click on twitterAvatar
And I want to click on addPost
Then wait for 3 second(s)
And I want to click on backFromTrendingDetailed
And I navigate to baazline
And I want to click on twitterFilter
And I want pull to refresh
Then I want to check if sharedOwner contains Forgot User
Then I want to check if sharedOwner contains shared this story
Then I want to check if sharedStory is exist




Scenario: Share Story From Detailed (Share To Facebook)
Given Open Baaz App
When I want to click on login
And I want to click on loginWithEmail
And I want to fill loginEmail with baazmobile2017@gmail.com
And I want to fill loginPassword with test123456
And I want to click on loginToBaaz
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to tap on storyView
And I want to click on shareFromDetailed
And I want to click on shareSNPost
And I want to click on facebookAvatar
And I want to click on addPost
Then wait for 3 second(s)
And I want to click on backFromTrendingDetailed
And I navigate to baazline
And I want to click on facebookFilter
And I want pull to refresh
Then I want to check if sharedOwner contains Forgot User
Then I want to check if sharedOwner contains shared this story
Then I want to check if sharedStory is exist





Scenario: Share Story From Detailed 3 Dots (Quick Share to Baazline)
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
And I want to click on quickSharePost
Then wait for 2 second(s)
And I want to click on backFromTrendingDetailed
And I navigate to baazline
Then wait for 3 second(s)
And I want pull to refresh
Then I want to check if sharedStory is exist
Then I want to check if sharedOwner contains user1name
Then I want to check if sharedOwner contains shared this story



Scenario: Share Story From Detailed 3 Dots (Share To Twitter)
Given Open Baaz App
When I want to click on login
And I want to click on loginWithEmail
And I want to fill loginEmail with baazmobile2017@gmail.com
And I want to fill loginPassword with test123456
And I want to click on loginToBaaz
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to tap on storyView
And I want to click on moreIcon
And I want to click on shareSNPost
And I want to click on twitterAvatar
And I want to click on addPost
Then wait for 2 second(s)
And I want to click on backFromTrendingDetailed
And I navigate to baazline
And I want to click on twitterFilter
And I want pull to refresh
Then I want to check if sharedOwner contains Forgot User
Then I want to check if sharedOwner contains shared this story
Then I want to check if sharedStory is exist




Scenario: Share Story From Detailed 3 Dots (Share To Facebook)
Given Open Baaz App
When I want to click on login
And I want to click on loginWithEmail
And I want to fill loginEmail with baazmobile2017@gmail.com
And I want to fill loginPassword with test123456
And I want to click on loginToBaaz
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to tap on storyView
And I want to click on moreIcon
And I want to click on shareSNPost
And I want to click on facebookAvatar
And I want to click on addPost
Then wait for 2 second(s)
And I want to click on backFromTrendingDetailed
And I navigate to baazline
And I want to click on facebookFilter
And I want pull to refresh
Then I want to check if sharedOwner contains Forgot User
Then I want to check if sharedOwner contains shared this story
Then I want to check if sharedStory is exist