Feature: Trendyol UI Test

  Scenario: Add Product to Favorite

    Given Start Driver and Browser
    When Navigate to Trendyol
    And Click Login Area
    Then Verify Login Page

    When Enter Validation Criterias
    And Click Login Button
    Then Verify Logined

    When Search Product
    And Verify Searched Page
    And Verify Products Counts
    And Click Product
    Then Verify Product Page

    When Add Product to Favorite
    And Enter Favorite Page
    Then Verify Favorite Page

    When Check Added Product
    And Remove Favorite Product
    And Check Removed Product
    And Logout
    Then Verify Logout
