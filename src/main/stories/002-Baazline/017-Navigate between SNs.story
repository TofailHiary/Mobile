Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development


Scenario: Navigate between SNs and check posts
Meta:
@android
Given Open Baaz App
When I want to login with test94@hotmail.com and password is test1234567
And User clicks on secondAvatar
Then firstPostHeader should appear
And User clicks on thirdAvatar
Then firstPostHeader should appear
And User clicks on fourthAvatar
Then firstPostHeader should appear
And User clicks on fifthAvatar
Then firstPostHeader should appear
And User clicks on sixthAvatar
Then firstPostHeader should appear