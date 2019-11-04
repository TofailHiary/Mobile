Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:Create Post Negative Case
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create Empty Post
Then postErrorMessage should appear



Scenario:Create Text Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
Then textPost should contain baazText




Scenario:Create Link Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with link
Then metaData should appear




Scenario:Check Show More in long text
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with longText
Then textPost should contain longTexts



Scenario:Check Keep Post And Discard
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
Then Check keep post page and discard




Scenario: Check Cancel Upload Image
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
Then Check cancel upload image



Scenario:Create Hashtag Post and Check Keywords
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with hashTag
Then textPost should appear with hashTagAfter



Scenario:Create Text Post with Keywords
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with postWithKeyWords
And User opens keywors
Then thirdKeyWord should contain keywordText



Scenario:Create Text Post with Keywords and view keywords
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with postWithKeyWords
And User opens keywors
Then thirdKeyWord should contain keywordText
And User clicks on thirdKeyWord
Then mainSearchArea should appear



Scenario:Create Twitter Post
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create twitter post
Then Check if twitter post exist



Scenario:Create Twitter Post with image
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And User create twitter post with image
And User clicks on secondFilter
Then photoPost should appear



Scenario:Create Twitter Post with video
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And User create twitter post with video
And User clicks on secondFilter
Then videoPost should appear



Scenario:Create Video URL Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with videoURL
Then videoPostTitle should appear



Scenario:Create Text Post My Friends Privacy
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create my friends privacy baaz post
Then textPost should contain myFriendsText



Scenario:Create Text Post Friends and their Friends Privacy
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create their friends privacy baaz post
Then textPost should contain theirFriendsText



Scenario:Create Text Post Only me Privacy
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create only me privacy baaz post
Then textPost should contain onlyMeText



Scenario:Create JPG Image Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create jpg image post
Then photoPost should appear



Scenario:Create PNG Image Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create png image post
Then photoPost should appear



Scenario:Create Captured Image Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And User captures 1 photo
Then photoPost should appear



Scenario:Create Multi Captured Images Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And User captures 6 photo
Then photoPost should appear



Scenario: Create choose from library video Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create video image post
Then videoPost should appear



Scenario: Create captured video Post
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And User create a captured video post
Then videoPost should appear