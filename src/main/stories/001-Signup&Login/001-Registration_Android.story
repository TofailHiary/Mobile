Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@android
Scenario: Negative cases- Sign up without first name (Android)
Given Open Baaz App
When user move to sign up screen
And user tries to signup with noFirstName
Then regFirstNameValidation should appear


Scenario: Negative cases- Sign up without last name (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with noLastName
Then regLastNameValidation should appear


Scenario: Negative cases- Sign up without email address (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with noEmail
Then regEmailValidation should appear


Scenario: Negative cases- Sign up without password (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with noPassword
Then signupErrorMessage should appear with regpasswordValidation


Scenario: Negative cases- Sign up without birth date (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with noDateOfBirth
Then signupErrorMessage should appear with regBirthDateValidation


Scenario: Negative cases- Sign up with invalid email address (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with invalidEmailAddress
Then signupErrorMessage should appear with enterEmailValidation


Scenario: Negative cases- Sign up with not match password and confirm password (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with passwordDoesntMatchConfirm
Then signupErrorMessage should appear with regPasswordMatchValidation


Scenario: Negative cases- Sign up with email already exist (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with alreadyExistEmail
Then signupErrorMessage should appear with regEmailAlreadyExistValidation


Scenario: Negative cases- Sign up with phone number already exist (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with alreadyExistPhoneNumber
Then signupErrorMessage should appear with regMobileNumberAlreadyExistValidation


Scenario: Negative cases- Sign up with invalid phone number (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with invalidPhoneNumber
Then signupErrorMessage should appear with regInvalidMobileNumber


Scenario: Sign up with exist Facebook account (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user register with ExistFb SN
Then createPost should appear


Scenario: Sign up with exist Twitter account (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user register with ExistTwitter SN
Then createPost should appear


Scenario: Sign up with Arabic First and Last names (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user Register with Arabic name
Then soundsGood should appear


Scenario: Sign up with new EMAIL address (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validEmailAddress
Then soundsGood should appear


Scenario: Sign up with new PHONE number (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user tries to signup with validPhoneNumber
Then verificationCode should appear


Scenario: Sign up - check show password for password and confirm password (Android)
Meta:
@android
Given Open Baaz App
When user move to sign up screen
And user clicks on show password on registration
Then passWordShown should appear
