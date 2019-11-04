Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Scenario: Help/FAQ
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to settings
Then Check Help/FAQ


Scenario: Feedback
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to settings
Then Check feedback form



Scenario: Contact Us
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to settings
Then Check contact us form


Scenario: Terms and Conditions
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to settings
Then Check terms and conditions text