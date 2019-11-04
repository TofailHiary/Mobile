Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Meta:
@android
Scenario: Check Story Category
Given I want to create news topic from user1
When I want to login with user1email and password is test123456
And I navigate to trending
Then Check if category name in main page equal News
And Check if category name in detailed page equal News
And Check if category name from more icon in detailed page equal News
