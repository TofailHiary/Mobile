Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Scenario: Change App Language
Meta:
@android
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to settings
Then Change app language
Then Check if App language changed

