Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario: Edit Basic Informaiton
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to settings
Then Edit basic information
And Check if basic information eidted


Scenario: Edit Basic Informaiton
Meta:
@iOS
Given I want to create 1 users
Then I want to login with user1email and password is test123456
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I navigate to settings
And I want to click on basicInformation
And I want to fill basicInfoFirstName with Automation
And I want to fill basicInfoLastName with Baaz
And I want to click on basicInfoGender
And I want to click on basicInfoFemale
And I want to click on basicInfoRelation
And I want to click on single
And I want to fill basicInfoCity with Amman
And I want to click on saveBasicInfo
And I want to click on basicInformation
Then I want to check if firstNameValue equal Automation
Then I want to check if lastNameValue equal Baaz
Then I want to check if userGenderValue equal Female
Then I want to check if userCountryValue equal Jordan
Then I want to check if userCityValue equal Amman
And I want to click on backFromSettings
Then I navigate to profile from settings
And I want to check if profileUserName contains Automation
Then I want to check if profileUserName contains Baaz
And I want to click on aboutTab
Then I want to check if aboutUserFirstName equal Automation
Then I want to check if aboutUserLastName equal Baaz
Then I want to check if aboutGender equal Female
Then I want to check if aboutRelation equal Single
Then I want to check if aboutCity equal Amman
Then I want to check if aboutCountry equal Jordan

