Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@android
Scenario:  Negative cases- Login with empty email (Android)
Given Open Baaz App
When user tries to login with noEmail
Then errorMessage should appear with enterEmailValidation


Scenario:  Negative cases- Login with empty password (Android)
Meta:
@android
Given Open Baaz App
When user tries to login with noPassword
Then errorMessage should appear with enterPasswordValidation


Scenario:  Negative cases- Login with invalid email (Android)
Meta:
@android
Given Open Baaz App
When user tries to login with invalidEmail
Then errorMessage should appear with invalidEmailValidation


Scenario:  Negative cases- Login with invalid password (Android)
Meta:
@android
Given Open Baaz App
When user tries to login with invalidPassword
Then errorMessage should appear with wrongLoginValidation


Scenario:  Negative cases- Login with valid email but not exist (Android)
Meta:
@android
Given Open Baaz App
When user tries to login with notExistEmail
Then errorMessage should appear with wrongLoginValidation


Scenario:  Negative cases- Login with wrong password (Android)
Meta:
@android
Given Open Baaz App
When user tries to login with wrongPassword
Then errorMessage should appear with wrongLoginValidation


Scenario: Login with valid EMAIL address and valid password (Android)
Meta:
@android
Given Open Baaz App
And user taps on coach marks
When User clicks on menuButton
And User fill loginEmail with validEmailAddress
And User fill loginPassword with validPassword
And User clicks on loginToBaaz
Then createPost should appear


Scenario: Login with valid PHONE number and valid password (Android)
Meta:
@android
Given Open Baaz App
And user taps on coach marks
When User clicks on menuButton
And User fill loginEmail with validPhoneNumber
And User fill loginPassword with phoneValidPassword
And User clicks on loginToBaaz
Then createPost should appear


Scenario: Login with Facebook (Android)
Meta:
@android
Given Open Baaz App
When User login with exist facebook
Then createPost should appear


Scenario: Login with Twitter (Android)
Meta:
@android
Given Open Baaz App
When User login with exist Twitter
Then createPost should appear


Scenario: Login with Facebook not exit (Android)
Meta:
@android
Given Open Baaz App
When User login with notExist facebook
Then signUpButton should appear


Scenario: Login with Twitter not exist (Android)
Meta:
@android
Given Open Baaz App
When User login with notExist Twitter
Then signUpButton should appear


Scenario: check forgot password screen title (Android)
Meta:
@android
Given Open Baaz App
And user taps on coach marks
When User clicks on menuButton
And User clicks on forgotPassword
Then forgotPasswordTitle should appear


Scenario: check forgot password screen Baaz logo (Android)
Meta:
@android
Given Open Baaz App
And user taps on coach marks
When User clicks on menuButton
And User clicks on forgotPassword
Then baazLogo should appear


Scenario: Forgot password (Android)
Meta:
@android
Given Open Baaz App
When user tries to send a forget password validEmail
Then signupErrorMessage should appear with forgotPWMsg


Scenario: Forgot password for PHONE NUMBER (Android)
Meta:
@android
Given Open Baaz App
When user tries to send a forget password validPhoneNum
Then verificationCode should appear



Scenario: Forgot password - negaitve - invalid email (Android)
Meta:
@android
Given Open Baaz App
When user tries to send a forget password invalidEmail
Then errorMessage should appear with enterEmailValidation


Scenario: Forgot password - negaitve - not found phone number (Android)
Meta:
@android
Given Open Baaz App
When user tries to send a forget password notFoundPhoneNum
Then errorMessage should appear with notExistPhoneNumValidation


Scenario: Forgot password - negaitve - not found email (Android)
Meta:
@android
Given Open Baaz App
When user tries to send a forget password notFoundEmailAddress
Then errorMessage should appear with notFoundValidation


Scenario: Forgot password - negaitve - invalid phone number (Android)
Meta:
@android
Given Open Baaz App
When user tries to send a forget password invalidPhoneNum
Then errorMessage should appear with enterEmailValidation


Scenario: show password button(Android)
Meta:
@android
Given Open Baaz App
When user type a password and click on show button
Then passWordShown should appear


Scenario: Check terms and conditions button (Android)
Meta:
@android
Given Open Baaz App
When user taps on coach marks
And User clicks on menuButton
And user taps on terms and coditions on login
Then termsOfserviceTap should appear

