Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Meta:
@android
Scenario: Statistics Story From Slide View
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to trending
Then Open statistics page from main page
Then Check trending statistics page



Scenario: Statistics Story From Detailed
Given I want to create 1 users
Then I want to login with user1email and password is test123456
And I navigate to trending
Then Open statistics page from detailed page
Then Check trending statistics page


Scenario: Statistics Story From threedots In Trending Detailed Page
Given I want to create 1 users
Then I want to login with user1email and password is test123456
And I navigate to trending
Then Open statistics page from three dots in trending detailed page
Then Check trending statistics page
