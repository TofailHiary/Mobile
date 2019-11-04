Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@android
Scenario: Create Post On Story
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on postToThisStory
And I want to click on coachMark
And I want to fill postTextField with Hello Text Post
And I want to click on addPost
Then I want to check if textPost equal Hello Text Post


Scenario: Edit Post On Story 
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on postToThisStory
And I want to click on coachMark
And I want to fill postTextField with Hello Text Post
And I want to click on addPost
Then I want to check if textPost is exist
Then I want to click on postAction 
And I want to click on editPost
And I want to fill postTextField with Hello To Story Text Post
And I want to click on addPost
Then I want to check if textPost equal Hello To Story Text Post


Scenario: Delete Post From Story 
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on postToThisStory
And I want to tap on baazlineCoachMark
And I want to fill postTextField with Hello Text Post
And I want to click on addPost
And I want to click on postAction
And I want to click on deletePost
And I want to click on confirmDeletePost




Scenario: Create Facebook Post
Given Open Baaz App
Then I want to login with baazmobile2017@gmail.com and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on postToThisStory
And I want to click on coachMark
And I want to fill postTextField with RandomPost
And I want to click on facebookAvatar
And I want to click on addPost
Then I want to check if textPost equal RandomPost



Scenario: Create Twitter Post
Given Open Baaz App
Then I want to login with baazmobile2017@gmail.com and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on postToThisStory
And I want to click on coachMark
And I want to fill postTextField with RandomPost
And I want to click on twitterAvatar
And I want to click on addPost
Then I want to check if textPost equal RandomPost


Scenario: Create Facebook, Twitter Post 
Given Open Baaz App
Then I want to login with baazmobile2017@gmail.com and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on postToThisStory
And I want to click on coachMark
And I want to fill postTextField with RandomPost
And I want to click on facebookAvatar
And I want to click on twitterAvatar
And I want to click on addPost
Then I want to check if textPost equal RandomPost




Scenario: Delete Twitter Post 
Given Open Baaz App
Then I want to login with baazmobile2017@gmail.com and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on postToThisStory
And I want to click on coachMark
And I want to fill postTextField with RandomPost
And I want to click on twitterAvatar
And I want to click on addPost
And I want to click on postAction
And I want to click on deletePost
And I want to click on confirmDeletePost




Scenario: Delete Facebook Post 
Given Open Baaz App
Then I want to login with baazmobile2017@gmail.com and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on postToThisStory
And I want to click on coachMark
And I want to fill postTextField with RandomPost
And I want to click on facebookAvatar
And I want to click on addPost
And I want to check if textPost equal RandomPost
Then I want to click on postAction
And I want to click on deletePost
And I want to click on confirmDeletePost






Scenario: Edit Facebook Post
Given Open Baaz App
Then I want to login with baazmobile2017@gmail.com and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on postToThisStory
And I want to click on coachMark
And I want to fill postTextField with RandomPost
And I want to click on facebookAvatar
And I want to click on addPost
And I want to check if textPost equal RandomPost
Then I want to click on postAction
And I want to click on editPost
And I want to fill postTextField with RandomPost 
And I want to click on addPost
Then I want to check if textPost equal RandomPost




Scenario: Edit Twitter Post 
Given Open Baaz App
Then I want to login with baazmobile2017@gmail.com and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on postToThisStory
And I want to click on coachMark
And I want to fill postTextField with RandomPost
And I want to click on twitterAvatar
And I want to click on addPost
Then I want to check if textPost equal RandomPost
Then I want to click on postAction
And I want to click on editPost
And I want to fill postTextField with RandomPost 
And I want to click on addPost
Then I want to check if textPost equal RandomPost



Scenario: Edit Facebook, Twitter Post
Given Open Baaz App
Then I want to login with baazmobile2017@gmail.com and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to trending
And wait for 4 second(s)
And I want to click on storyView
And I want to click on postToThisStory
And I want to click on coachMark
And I want to fill postTextField with RandomPost
And I want to click on facebookAvatar
And I want to click on twitterAvatar
And I want to click on addPost
Then I want to check if textPost equal RandomPost
Then I want to click on postAction
And I want to click on editPost
And I want to fill postTextField with RandomPost 
Then I want to click on addPost
Then I want to check if textPost equal RandomPost
