Feature: Validate User Blog Comments

  @regression
  Scenario: Get User Details
    Given user "Delphine" is available
    Then get the user posts
    And get comments of all posts of the user
    Then validate email of the users commented

