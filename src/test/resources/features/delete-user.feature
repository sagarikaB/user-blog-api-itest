Feature: delete particular user

  @regression
Scenario: delete particular user
  # no access to delete user
When try to delete user "1"
  # unauthorized error
Then should return with status 401
