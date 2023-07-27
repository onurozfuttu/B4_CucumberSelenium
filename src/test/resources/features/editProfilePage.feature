Feature: Edit Profile Page


  @editProfile
  Scenario Outline: edit profile test
    Given The user is on the login page
    When The user logs in using "<userEmail>" and "<password>"
    And The user navigates to "<name>" and "<menu>" sub menu
    And The user navigates to "<sub menu>"
    And The user adds "about" "<about>"
    And The user adds "company" "<company>"
    And The user select "<job>" from menu
    And The user adds "website" "<website>"
    And The user adds "location" "<location>"
    And The user adds "skills" "<skills>"
    And The user clicks on save changes button
    Examples:
      | userEmail             | password  | name        | menu       | sub menu     | about               | company | job              | website               | location | skills                   |
      | testerbfour@gmail.com | Tester333 | TesterBFour | My Profile | Edit Profile | graduated SDET 2023 | Kraft   | QA Test Engineer | www.krafttechxlab.com | Vienna   | Java, Selenium, Cucumber |