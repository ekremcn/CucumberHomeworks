Feature: Update personal Information

  Scenario: Updating personal information of the website

    Given Navigate to site
    When Enter the username and password and click on login button
    And Navigate to MyPersonalInformation page
    When User edit the firstName as "Ekremeditted" and password "3229e" as "pass1"
    Then User should verify the updated firstname as "Ekremeditted"
    And Navigate to MyPersonalInformation page
    When User edit the firstName as "Ekrem" and password "pass1" as "3229e"
    Then User should verify the updated firstname as "Ekrem"

