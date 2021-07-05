Feature: J.P. Morgan logo to be displayed on official website

  Background: Launch the browser
    Given user launches the browser

@ui @priority=1 @bvt
  Scenario: Verify that J.P. Morgan logo is displayed when user launches the official website through Google search
    When user opens Google on browser
    And user searches for "J. P. Morgan" in the search box
    And clicks on the first result
    Then J.P. Morgan official website should be launched
    And company logo should be displayed
    