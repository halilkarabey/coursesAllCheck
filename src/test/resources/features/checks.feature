@all
Feature: Checked

  Scenario: User should be able to see courses if status is publish
    Given User goes to "crmEnv" for crm
    And user enters "emailForCRM" in emailBox
    And User enters "passwordForCRM" in passwordBox
    And user clicks login button
    And user hoverOver campaigns
    And user clicks campaigns at crm
    And user clicks courses at crm
    And user clicks loadMore until it is unClickable
    Then User lists academyName, keyTakeAway,overview,PM,price,relatedCourses, statusCheck,courseOutline at crm
  # for checking each course checked all courses at leo
    And user goes to "leoEnv" for leo
    And user clicks courses at leo
    And user scrolls down
    And user lists all courses academyName, keyTakeAway,overview,PM,price,relatedCourses, statusCheck,courseOutline at leo
    Then user checks info StatusCheck at CRM with info StatusCheck at loe

  Scenario: User should be able to see relatedCourses
    Then user checks info relatedCourses at CRM with info relatedCourses at loe

  Scenario: User should be able to see PM
    Then user checks info PM at CRM with info PM at loe

  Scenario: User should be able to see price
    Then user checks info price at CRM with info price at loe

  Scenario: User should be able to see academyName
    Then user checks info academyName at CRM with info academyName at loe

  Scenario: User should be able to see overview
    Then user checks info overview at CRM with info overview at loe

  Scenario: User should be able to see keyTakeAway
    Then user checks info keyTakeAway at CRM with info keyTakeAway at loe

  Scenario: User should be able to see courseOutline
    Then user checks info courseOutline at CRM with info courseOutline at loe

