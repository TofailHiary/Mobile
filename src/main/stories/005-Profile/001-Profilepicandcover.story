Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development
Meta:
@skip
Scenario: Check All Elements In Profile Page

Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to profile
Then Check all elements on profile page


Scenario: Change Profile Picture
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to profile
And I want to click on profileAvatar
And I want to click on allowPermession
And I want to click on allowPermession
And I want to click on chooseFromLibrary
And I want to click on cameraAlbum
And I want to click on pickImage
And I want to click on cropImage
Then I want to check if avatarChangedPost is exist


Scenario: Change Profile Cover
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to profile
And I want to click on changeCoverPhoto
And I want to click on allowPermession
And I want to click on allowPermession
And I want to click on chooseFromLibrary
And I want to click on cameraAlbum
And I want to click on pickImage
And I want to click on useCoverPhoto





Scenario: Change Profile Picture
Meta:
@iOS
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to profile
And I want to click on profileAvatar
And I want to click on photoLibrary
And I want to click on accessToLibrary
Then wait for 2 second(s)
And I want to click on cameraAlbum
And I want to click on pickImage
And I want to click on cropImage
Then I want to check if avatarChangedPost is exist


Scenario: Change Profile Cover
Meta:
@iOS
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to profile
And I want to click on changeCoverPhoto
And I want to click on chooseFromLibrary
And I want to click on accessToLibrary
And I want to click on cameraAlbum
And I want to click on pickImage
And I want to click on useCoverPhoto


Scenario: Connect Social Network From Profile
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to profile
And I want to click on profileConnectSN
Then I want to check if connectFacebook is exist
Then I want to check if connectTwitter is exist
Then I want to check if connectGoogle is exist

