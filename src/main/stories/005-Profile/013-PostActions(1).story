Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development





Scenario:Create Text Post from Profile
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to profile
Then Create New Post with Hello Baaz Text Post
And Check if text post Hello Baaz Text Post exist


Scenario:Create Hashtag Post from Profile
Given I want to create 1 users
Then I want to login with user1email and password is test123456
And I navigate to profile
And Create New Post with #Baaz
Then Check if text post #Baaz exist


Scenario:Create Link Post from Profile
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to profile
Then Create New Post with https://www.baaz.com
And Check if meta data exist


Scenario:Create Facebook Post from Profile
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456
And I navigate to profile
And Create facebook post
Then Check if facebook post exist


Scenario:Create Twitter Post from Profile
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456
Then I navigate to profile
And Create twitter post
Then Check if twitter post exist

Scenario: Create Combined Post from Profile
Given Open Baaz App
When I want to login with baazmobile2017@gmail.com and password is test123456
Then I navigate to profile
And Create combined post
Then Check if combined post exist


Scenario:  Create Image Post
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to profile
Then Create jpg image post
And Check if photo post exist



Scenario:  Create Video Post
Given I want to create 1 users
When I want to login with user1email and password is test123456
And I navigate to profile
Then Create mp4 video post
And Check if video post exist


