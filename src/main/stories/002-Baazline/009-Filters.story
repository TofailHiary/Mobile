Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development



Scenario:Baazline Filter (Check all filters)
Meta:
@android
Given I want to create 1 users
Then I want to login with user1email and password is test123456 
When Create New Post with baazText
And Create New Post with link
And Create jpg image post
And Choose photos filter
Then photoPost should appear
And Choose text filter
Then textPost should contain baazText
And Choose links filter
Then metaData should appear



