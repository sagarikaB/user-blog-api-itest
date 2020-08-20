Feature: search for post of valid user

  @regression
Scenario: Search for post of valid profileid
  #username is valid string
When search for profileid "1"
  #Internal server error
Then should return with status 500

Scenario: Search for post of valid profileid
  #username is valid string
When search for profileid "123456"
  #service unavilable error
Then should return with status 503

Scenario: Search for valid user
  #if username has more than 10 characters
When search for user "xxxyyyzzzdrrrrrrr"
  #Bad request
Then should return with status 400

