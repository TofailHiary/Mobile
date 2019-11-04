Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Meta:
@android
Scenario:Check suggested friends sync between baazline and profile when add 1 friend
Given I want to create 1 users
When I want to login with user1email and password is test123456
And Add 1 friend(s) from suggested in profile page
Then Check sync between profile and baazline when add or remove 1 friend

Scenario:Check suggested friends sync between baazline and profile when add all friends
Given I want to create 1 users
When I want to login with user1email and password is test123456
And Add 5 friend(s) from suggested in profile page
Then Check sync between profile and baazline when add or remove all friends

Scenario:Check suggested friends sync between baazline and profile when add all friends after pull to refresh
Given I want to create 1 users
When I want to login with user1email and password is test123456
And Add 5 friend(s) from suggested in profile page
Then Check sync between profile and baazline when add or remove all friends after pull to refresh

Scenario:Check suggested friends sync between baazline and profile when remove 1 friend
Given I want to create 1 users
When I want to login with user1email and password is test123456
And remove 1 friend(s) from suggested in profile page
Then Check sync between profile and baazline when add or remove 1 friend

Scenario:Check suggested friends sync between baazline and profile when remove all friends
Given I want to create 1 users
When I want to login with user1email and password is test123456
And remove 5 friend(s) from suggested in profile page
Then Check sync between profile and baazline when add or remove all friends

Scenario:Check suggested friends sync between baazline and profile when remove all friends after pull to refresh
Given I want to create 1 users
When I want to login with user1email and password is test123456
And Add 5 friend(s) from suggested in profile page
Then Check sync between profile and baazline when add or remove all friends after pull to refresh