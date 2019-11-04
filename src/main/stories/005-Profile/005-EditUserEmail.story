Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development




Scenario: Edit User Email Negative Cases
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to settings
Then Check negative cases for edit email





Scenario: Edit User Email
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to settings
Then Change email



Scenario: Check Email Edited
Given Open Baaz App
When I want to login with Edited Email and password is test123456
Then Check if email edited


