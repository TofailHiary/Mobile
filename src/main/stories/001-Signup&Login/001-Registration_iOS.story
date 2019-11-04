Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@android
Scenario:  Negative cases Signup (Android)

Given Open Baaz App
When I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on menuButton
When I want to click on signUp
Then I want to check Firstname text

Scenario:  Negative cases Signup with  fill first name  (Android)
Given Open Baaz App
When I want to click on trendingCoachMark

When I navigate to trendingCoachMark->menuButton->signUp

And I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on menuButton
When I want to click on signUp
And I want to fill signUpFirstName with test
And I want to click on signUpButton
Then I want to check if signUpLastName equal Please enter last name
When I want to fill signUpLastName with test
And I want to click on signUpButton
Then I want to check if signUpEmail equal Enter your email or phone number
When I want to fill signUpEmail with test
And I want to click on signUpButton
Then I want to check if signupErrorMessage equal Please enter a valid email address or correct phone number format
When I want to fill signUpEmail with belal.jarwan@baaz.com
And I want to click on signUpButton
Then I want to check if signupErrorMessage equal Passwords must be between 8 and 16 character include alphanumeric and one number
Then wait for 3 second(s)
When I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on signUpButton
Then I want to check if signupErrorMessage equal Set Date of Birth field.
Then wait for 3 second(s)
When I want to click on signUpBirthday
And I want to click on signUpButton
Then wait for 3 second(s)
When I want to click on signUpGender male
And I want to click on SelectCountry
And I want to click on signUpButton
Then I want to check if signupErrorMessage equal Email already exists


Scenario:  Signup With New Email (Android)
Meta:
@android
Given Open Baaz App
When I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on trendingCoachMark
When I want to click on menuButton
When I want to click on signUp
And I want to fill signUpFirstName with test
And I want to fill signUpLastName with test
And I want to fill signUpEmail with random
And I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on signUpBirthday
And I want to select on signUpGender male
And I want to click on SelectCountry
And I want to click on signUpButton
Then wait for 5 second(s)
When I want to click on soundsGood
And I want to click on skipStep
And I want to click on skipStep
And I want to click on skipStep
And I want to click on allowPermession
And I want to click on skipStep
And I want to click on allowPolicy
When I want to click on baazlineCoachMark
When I want to click on baazlineCoachMark
Then I want to check if searchIcon is exist




Scenario:  Signup With New Phone Number (Android)
Meta:
@android
@skip
Given Open Baaz App
When I want to click on menuButton
When I want to click on signUp
And I want to fill signUpFirstName with test
And I want to fill signUpLastName with test
And I want to fill signUpEmail with phone number
And I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on signUpBirthday
When I want to click on signUpGender male
And I want to click on signUpButton
And I want to fill verificationCode with verification code
And I want to click on next
Then wait for 5 second(s)
When I want to click on soundsGood
And I want to click on skipStep
And I want to click on skipStep
And I want to click on skipStep
And I want to click on allowPermession
And I want to click on skipStep
When I want to click on baazlineCoachMark
Then I want to check if searchIcon is exist



Scenario:  Signup With New Email+Image (Android)
Meta:
@android
Given Open Baaz App
When I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on menuButton
When I want to click on signUp
And I want to click on avatar
And I want to fill signUpFirstName with test
And I want to fill signUpLastName with test
And I want to fill signUpEmail with random
And I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on signUpBirthday
And I want to select on signUpGender male
And I want to click on SelectCountry
And I want to click on signUpButton
Then wait for 5 second(s)
When I want to click on soundsGood
And I want to click on skipStep
And I want to click on skipStep
And I want to click on skipStep
And I want to click on allowPermession
And I want to click on skipStep
And I want to click on allowPolicy
When I want to click on baazlineCoachMark
When I want to click on baazlineCoachMark
Then I want to check if searchIcon is exist

Scenario:  Signup With Facebook (Android)
Meta:
@android
Given Open Baaz App
When I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on menuButton
When I want to click on signUp
And I want to scroll down 1 time(s)
And I want to click on signUpWithFacebook
Then wait for 5 second(s)
When I want to fill signUpFacebookEmail with tofail.test@gmail.com
And I want to fill signUpFacebookPassword with a30801002545
And I want to click on loginToFacebook
And wait for 15 second(s)
And I want to fill signUpEmail with random
And I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on signUpGender
And I want to click on male
And I want to click on SelectCountry
And I want to click on signUpButton
When I want to click on soundsGood
And I want to click on skipStep
And I want to click on skipStep
And I want to click on skipStep
And I want to click on allowPermession
And I want to click on skipStep
And I want to click on allowPolicy
When I want to click on baazlineCoachMark
When I want to click on baazlineCoachMark
Then I want to check if searchIcon is exist


Scenario:  Signup With Twitter (Android)
Meta:
@android
Given Open Baaz App
When I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on menuButton
When I want to click on signUp
And I want to scroll down 1 time(s)
And I want to click on signUpWithTwitter
Then wait for 4 second(s)
When I want to fill signUpTwitterEmail with tofail.test@gmail.com
And I want to fill signUpTwitterPassword with a30801002545
And I want to click on loginToTwitter
Then wait for 4 second(s)
When I want to fill signUpLastName with test
And I want to fill signUpEmail with random
And I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on signUpBirthday
And I want to click on okBirthday
And I want to click on signUpGender
And I want to click on male
And I want to click on signUpButton
When I want to click on soundsGood
And I want to click on skipStep
And I want to click on skipStep
And I want to click on skipStep
And I want to click on allowPermession
And I want to click on skipStep
And I want to click on allowPolicy
When I want to click on baazlineCoachMark
When I want to click on baazlineCoachMark
Then I want to check if searchIcon is exist




Scenario:  Negative cases Signup (iOS)
Meta:
@android
Given Open Baaz App
When I want to click on signUp
And I want to click on signUpWithEmail
And I want to click on next
Then I want to check if errorMessage equal , Please enter valid first name.
When I want to fill signUpFirstName with test
And I want to click on next
Then I want to check if errorMessage equal , Please enter valid last name.
And I want to fill signUpLastName with test
And I want to click on next
Then I want to check if errorMessage equal , Please Enter a valid Email address or a correct number format
And I want to fill signUpEmail with test
And I want to click on next
Then I want to check if errorMessage equal , Please Enter a valid Email address or a correct number format
And I want to fill signUpEmail with belal.jarwan@baaz.com
And I want to click on next
Then I want to check if errorMessage equal , Passwords must be between 8 and 16 character include alphanumeric and one number.
And I want to fill signUpPassword with test123456
And I want to click on next
Then I want to check if errorMessage equal , Passwords don't match.
And I want to fill signUpConfirmPassword with test123456
And I want to click on next
Then I want to check if errorMessage equal , Set Date of Birth field.
And I want to click on signUpBirthday
And I want to click on next
Then I want to check if errorMessage equal , Set Gender field.
And I want to click on signUpGender
And I want to click on next
Then I want to check if errorMessage equal , Email already exists



Scenario:  Signup With New Email (iOS)
Meta:
@iOS
Given Open Baaz App
Then I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
When I want to click on forYou
When I want to click on openLogin
When I want to click on signUp
And I want to fill signUpFirstName with test
And I want to fill signUpLastName with test
And I want to fill signUpEmail with random
And I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on signUpBirthday
And I want to click on next
And I want to click on next
And wait for 5 second(s)
And I want to click on soundsGood
And I want to click on skipStep
And I want to click on nextStep
And I want to click on skipStep
And I want to click on accessToContact
And I want to click on finish
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
Then I want to check if searchIcon is exist


Scenario:  Signup With Phone number (iOS)
Meta:
@android
Given Open Baaz App
When I want to click on signUp
And I want to click on signUpWithEmail
And I want to fill signUpFirstName with test
And I want to fill signUpLastName with test
And I want to fill signUpEmail with phone number
And I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on signUpBirthday
And I want to click on signUpGender
And I want to click on next
And I want to fill verificationCode with verification code
And I want to click on next
And wait for 5 second(s)
And I want to click on soundsGood
And I want to click on skipStep
And I want to click on nextStep
And I want to click on skipStep
And I want to click on accessToContact
And I want to click on finish
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
Then I want to check if searchIcon is exist


Scenario:  Signup With New Email+Image (iOS)
Meta:
@iOS
Given Open Baaz App
Then I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
When I want to click on forYou
When I want to click on openLogin
When I want to click on signUp
And I want to click on avatar
And I want to click on chooseFromLibrary
And I want to click on accessToLibrary
And I want to click on cameraAlbum
And I want to click on pickImage
And I want to click on cropImage
And I want to fill signUpFirstName with test
And I want to fill signUpLastName with test
And I want to fill signUpEmail with random
And I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on signUpBirthday
And I want to click on next
And I want to click on next
And wait for 5 second(s)
And I want to click on soundsGood
And I want to click on skipStep
And I want to click on nextStep
And I want to click on skipStep
And I want to click on accessToContact
And I want to click on finish
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
Then I want to check if searchIcon is exist



Scenario:  Signup With Facebook (iOS)
Meta:
@iOS
Given Open Baaz App
Then I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
When I want to click on forYou
When I want to click on openLogin
When I want to click on signUp
And I want to click on signUpWithFacebook
Then wait for 3 second(s)
And I want to click on faceBookPermission
And I want to fill signUpEmail with random
And I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on next
And I want to click on next
And wait for 5 second(s)
And I want to click on soundsGood
And I want to click on skipStep
And I want to click on nextStep
Then I want to check if wizardAvatar is exist
And I want to click on deleteAccount
And I want to click on confirmDeleteAccount
Then I want to check if wizardAvatar not exist


Scenario:  Signup With Twitter (iOS)
Meta:
@iOS
Given Open Baaz App
Then I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
When I want to click on forYou
When I want to click on openLogin
When I want to click on signUp
And I want to click on signUpWithTwitter
Then wait for 4 second(s)
And I want to fill signUpLastName with test
And I want to fill signUpEmail with random
And I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on signUpBirthday
And I want to click on signUpGender
And I want to click on next
And I want to click on next
And wait for 5 second(s)
And I want to click on soundsGood
And I want to click on skipStep
And I want to click on nextStep
Then I want to check if wizardAvatar is exist
And I want to click on deleteAccount
And I want to click on confirmDeleteAccount
Then I want to check if wizardAvatar not exist

Scenario:  Check that Show Password is working 
Meta:
@android
Given Open Baaz App
When I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on menuButton
When I want to click on signUp
And I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on showPassword
And I want to click on showConfirmPassword
And wait for 3 second(s)
And I want to check if signUpPassword equal test123456
And I want to check if signUpConfirmPassword equal test123456

Scenario:  Check that Show Password is working 
Meta:
@iOS
Given Open Baaz App
Then I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
When I want to click on forYou
When I want to click on openLogin
When I want to click on signUp
And I want to fill signUpPassword with test123456
And I want to fill signUpConfirmPassword with test123456
And I want to click on showPassword
And I want to click on showConfirmPassword
And wait for 3 second(s)
And I want to check if signUpPassword equal test123456
And I want to check if signUpConfirmPassword equal test123456


