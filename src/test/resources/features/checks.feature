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

    Then user checks ınfo StatusCheck at CRM with ınfo StatusCheck at loe
    Then user checks ınfo relatedCourses at CRM with ınfo relatedCourses at loe
    Then user checks ınfo PM at CRM with ınfo PM at loe
    Then user checks ınfo price at CRM with ınfo price at loe
    Then user checks ınfo academyName at CRM with ınfo academyName at loe
    Then user checks ınfo overview at CRM with ınfo overview at loe
    Then user checks ınfo keyTakeAway at CRM with ınfo keyTakeAway at loe
    Then user checks ınfo courseOutline at CRM with ınfo courseOutline at loe