Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario:  Signup Wizard - Remove user name (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And user Remove user name
Then resetUserName should appear


Scenario:  Signup Wizard - Add user name already exist (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And user add alreadyExist username
Then signupErrorMessage should appear with sUWExistUserNameValidation


Scenario:  Signup Wizard - Add new user name (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And user add new username
Then selectTopicsTitle should appear


Scenario:  Signup Wizard - Proceed with suggested user name (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
Then selectTopicsTitle should appear


Scenario:  Signup Wizard - Check refresh button (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
Then user clear user name and refresh


Scenario:  Signup Wizard - Don't select any topic	 (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
Then storyLanguageTitle should appear



Scenario:  Signup Wizard - Select 1 topic (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And user selects oneTopic
And User clicks on nextStepTopics
Then signupErrorMessage should appear with selectTopicsValidation



Scenario:  Signup Wizard - Select 2 topics (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And user selects twoTopics
And User clicks on nextStepTopics
Then signupErrorMessage should appear with selectTopicsValidation



Scenario:  Signup Wizard - Select 3 topics (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And user selects threeTopics
And User clicks on nextStepTopics
Then storyLanguageTitle should appear


Scenario:  Signup Wizard - Check Back button (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And user selects threeTopics
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And User clicks on backButton 
Then selectTopicsTitle should appear


Scenario:  Signup Wizard - Check scrolling (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And user selects scrollThenThreeTopics
And User clicks on nextStepTopics
Then storyLanguageTitle should appear


Scenario:  Signup Wizard - Proceed with default values (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And user selects scrollThenThreeTopics
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And User clicks on nextStepTopics
Then connectAccountTitle should appear


Scenario:  Signup Wizard - Choose all languages (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And user Selects allLanguages from language and country screen
Then connectAccountTitle should appear


Scenario:  Signup Wizard - Choose Arabic language (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And user Selects arabic from language and country screen
Then connectAccountTitle should appear


Scenario:  Signup Wizard - Choose All languages and choose country (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And user Selects allLanguagesWithAfghanistan from language and country screen
Then connectAccountTitle should appear


Scenario:  Signup Wizard - Choose Arabic language and choose country (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And user Selects arabicWithAfghanistan from language and country screen
Then connectAccountTitle should appear


Scenario:  Signup Wizard - Choose Arabic language and search for a country (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And user Selects arabicWithSearchForCountry from language and country screen
Then connectAccountTitle should appear


Scenario:  Signup Wizard - Check scrolling for language and country screen (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And user Selects seachForNotExistCountry from language and country screen
Then signupErrorMessage should appear with noResultsFound


Scenario:  Signup Wizard - X icon into search text field - language and country screen (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
Then user click on X button


Scenario:  Signup Wizard - Connect Facebook icon (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And User clicks on nextStepTopics
And user connect facebook account
Then facebookTitle should appear


Scenario:  Signup Wizard - Connect Twitter icon (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And User clicks on nextStepTopics
And user connect twitter account
Then twitterTitle should appear


Scenario:  Signup Wizard - Connect Google icon (Android) (not completed)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And User clicks on nextStepTopics
And user connect youtube account
Then twitterTitle should appear


Scenario:  Signup Wizard - Connect other SN (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And User clicks on nextStepTopics
And user connect otherSN account
Then dialogTitle should appear


Scenario: Signup Wizard - Check if user can close and open sections (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And User clicks on nextStepTopics
Then user check open and close sections


Scenario: Signup Wizard - Contact permission (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And User clicks on nextStepTopics
And connectFacebookold should appear
And User clicks on nextStepTopics
And User clicks on allowPermession
Then suggestedFriendsTitle should appear


Scenario: Signup Wizard - Add User from suggested friends and cancel request (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And User clicks on nextStepTopics
And connectFacebookold should appear
And User clicks on nextStepTopics
And User clicks on allowPermession
And suggestedFriendsTitle should appear
Then user add a friend from suggested and cancel request


Scenario: Signup Wizard - Follow User from suggested friends and cancel request (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
And User clicks on soundsGood
And selectTopicsTitle should appear
And User clicks on nextStepTopics
And storyLanguageTitle should appear
And User clicks on nextStepTopics
And connectFacebookold should appear
And User clicks on nextStepTopics
And User clicks on allowPermession
And suggestedFriendsTitle should appear
Then user follow a friend from suggested and cancel request

