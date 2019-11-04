Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@android
Scenario:  Negative cases Login (Android)
Given Open Baaz App
When I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on menuButton
And I want to click on loginToBaaz
Then I want to check if errorMessage equal Please enter a valid email address or correct phone number format

Scenario:  Negative cases Login emailOnly (Android)
Given Open Baaz App
When I want to click on trendingCoachMark
When I want to click on trendingCoachMark
When I want to click on trendingCoachMark
And I want to click on menuButton
When I want to fill loginEmail with test
And I want to click on loginToBaaz
Then I want to check if errorMessage equal Please enter a valid email address or correct phone number format
When I want to fill loginEmail with belal.jarwan@baaz.com
And I want to fill loginPassword with test
And I want to click on loginToBaaz
Then I want to check if errorMessage equal Oops, it seems you entered wrong email or phone number or password
When I want to fill loginEmail with belal.jarwan200100200@test.net
And I want to fill loginPassword with test
And I want to click on loginToBaaz
Then I want to check if errorMessage equal Oops, it seems you entered wrong email or phone number or password

Scenario:  Negative cases Login (iOS)
Meta:
@iOS
Given Open Baaz App
Then I want to click on baazlineCoachMark
Then I want to click on baazlineCoachMark
Then I want to click on baazlineCoachMark
And I want to click on forYou
And I want to click on openLogin
And I want to click on loginToBaaz
Then I want to check if loginErrorMessage equal Please enter a valid email address or correct phone number format
When I want to fill loginEmail with test
And I want to click on loginToBaaz
Then I want to check if loginErrorMessage equal Oops, it seems you entered wrong email or phone number or password
When I want to fill loginEmail with belal.jarwan@baaz.com
And I want to click on loginToBaaz
Then I want to check if loginErrorMessage equal Please enter your password
When I want to fill loginEmail with belal.jarwan@baaz.com
When I want to fill loginPassword with 1234
And I want to click on loginToBaaz
Then I want to check if loginErrorMessage equal Oops, it seems you entered wrong email or phone number or password
When I want to fill loginEmail with belal.jarwan200100200@test.net
And I want to fill loginPassword with 1234
And I want to click on loginToBaaz
Then I want to check if loginErrorMessage equal Oops, it seems you entered wrong email or phone number or password

Scenario: Login With Email (iOS)
Meta:
@iOS
Given Open Baaz App
Then I want to tap on trending coach mark
Then I want to tap on trending coach mark
Then I want to tap on trending coach mark
And I want to click on forYou
And I want to click on openLogin
And I want to fill loginEmail with belal.jarwan@baaz.com
And I want to fill loginPassword with test1234567
And I want to click on loginToBaaz
Then wait for 3 second(s)
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
Then I want to check if searchIcon is exist

Scenario:  Login With Email (Android)
Meta:
@android
Given Open Baaz App
When I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on trendingCoachMark
And I want to click on menuButton
And I want to fill loginEmail with belal.jarwan@baaz.com
And I want to fill loginPassword with test1234567
And I want to click on loginToBaaz
Then wait for 3 second(s)
When Allow Permission Popup if exist
And I want to tap on baazlineCoachMark
And I want to tap on baazlineCoachMark
Then I want to check if searchIcon is exist
