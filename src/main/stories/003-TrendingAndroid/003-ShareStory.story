Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Meta:
@android
Scenario: Share Story From Main Page (Quick Share To Baazline)
Given I want to create 1 users
When I want to login with user1email and password is test123456
Then I navigate to trending
And Quick share story to baazline
Then Check if story shared to baazline


Scenario: Share Story From Main Page (Share To Twitter)
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456
And I navigate to trending
Then Share story to twitter

Scenario: Share Story From Detailed (Quick Share to Baazline)
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to trending
And Quick share story to baazline from detailed page
Then Check if story shared to baazline



Scenario: Share Story From Detailed (Share To Twitter)
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456
And I navigate to trending
Then Share story to twitter from detailed page

