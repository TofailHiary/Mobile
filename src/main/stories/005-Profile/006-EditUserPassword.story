Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario: change User Password Negative Cases
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to settings
Then Check negative case for change password




Scenario: Edit User Password
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to settings
Then Change user password




Scenario: Check Password Edited
Given Open Baaz App
When I want to login with user1email and password is test1234567
Then Check if password changed successfully


