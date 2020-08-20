Feature: Validate User Blog Comments

  @regression
Scenario: Posts with valid comments
Given user "Delphine" is available
Then get the user posts
And get comments of all posts of the user
Then validate email of the users commented

Scenario: Search for valid user
  #username is valid string
When search for user "xxx"
  #Bad request
Then should return with status 200









