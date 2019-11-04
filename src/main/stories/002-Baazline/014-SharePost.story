Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario: Quick Share To Baaz
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
Then Share post to baaz



Scenario: Quick Share To Baaz from details page 
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456 
And Create New Post with baazText
Then Share post to baaz from details page



Scenario: Share To Tiwtter
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create New Post with baazText
Then Share post to baaz and twitter



Scenario: Share to SN only
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create New Post with baazText
And Share post to SN only
Then sharedOwner should contain AutomationAutomation 



Scenario: Share with text to SN only
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create New Post with baazText
And Share Post with text to SN only
Then sharedOwner should contain AutomationAutomation
And textForSharedPost should contain shareThisPost



Scenario: Share image post to SN
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create jpg image post
And Scroll down 1 time(s)
And photoPost should appear
And Share post to SN only
Then sharedOwner should contain AutomationAutomation 



Scenario: Share video post to SN
Meta:
@android
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456 
And Create video image post
And User waits for 20 seconds
And Scroll up 3 time(s)
And Scroll down 2 time(s)
And videoPost should appear
And Share post to SN only
Then sharedOwner should contain AutomationAutomation 



Scenario: Share URL post to SN
Meta:
@android
Given I want to create 1 users
When I want to login with baazmobile2017@gmail.com and password is test123456
And Create New Post with link
And Scroll down 1 time(s)
And Share post to SN only
Then sharedOwner should contain AutomationAutomation 



Scenario: Share Baaz post - copy link
Meta:
@android
Given I want to create 2 users
Then I want to send friend request from user1 to user2 and accept
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And user copy post link and create a post
Then pastedPostText should appear with baazText



Scenario: Share Baaz post - More options
Meta:
@android
Given I want to create 2 users
Then I want to send friend request from user1 to user2 and accept
When I want to login with user1email and password is test123456 
And Create New Post with baazText
And user share post with more options
Then androidTitle should appear


Scenario: share youtube post
Meta:
@android
Given Open Baaz App
When I want to login with test94@hotmail.com and password is test1234567
Then User share youtube post and check


Scenario: Share Rss Post
Meta:
@android
Given Open Baaz App
When I want to login with rssmobile@baazauto.com and password is test123456
And Navigate to rss filter
Then share Rss post and check

