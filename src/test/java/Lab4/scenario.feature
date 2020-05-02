Feature: Web pages test

  Scenario: Test search on home page
    Given Open home page
    When Search word dress
    Then Verify search results

   Scenario: Test category on home page
    Given Open home page
    When Go to coat category
    Then Verify category results

  Scenario: Test empty on basket page
    Given Open basket page
    When Go to empty
    Then Verify home page

  Scenario: Test account on basket page
    Given Open basket page
    When Go to account
    Then Verify account page

  Scenario: Test filter
    Given Open catalog page
    When Set filter
    Then Verify filter results

  Scenario: Test some clothes
    Given Open catalog page
    When Go to some clothes
    Then Verify clothes results