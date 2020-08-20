Feature: Search for invalid user

  @regression
  Scenario: Search for invalid user
  #if username alphanumeric
    When search for user "xxx23df"
  #Bad request
    Then should return with status 400

  Scenario: Search for invalid user
  #if username digits
    When search for user "100"
  #Bad Request
    Then should return with status 400

  Scenario: Search for post of valid profileid
  #if there is no resource like profileid
    When search for profileid "sagarika"
  #resource not found
    Then should return with status 404
