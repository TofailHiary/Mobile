Scenario: Negative cases- Sign up without first name (Android)
Given Open Baaz App
When user move to sign up screen
And user tries to signup with noEmail
Then regEmailValidation should appear