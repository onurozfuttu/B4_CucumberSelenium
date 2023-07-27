@c_ListAndMap
Feature: Dashboard Menu Checks

  Background:
    Given The user is on the login page

  @cList
  Scenario: Example-1 for Cucumber List
    #Given The user is on the login page
    When The user logs in using "testerbfour@gmail.com" and "Tester333"
    Then The user should be able to login
    And The user should be able to see following menu
      | Dashboard   |
      | Developers  |
      | Components  |
      | Forms       |
      | JavaScript  |
      | TesterBFour |

  @cMap
  Scenario: Example-2 for Cucumber Map
      #Given The user is on the login page
    When The user logs in using following menu
      | username | testerbfour@gmail.com |
      | password | Tester333             |
      | name     | TesterBFour           |
    Then The user should be able to login
    And The user should be able to see following menu
      | Dashboard   |
      | Developers  |
      | Components  |
      | Forms       |
      | JavaScript  |
      | TesterBFour |

      # Class Task f1
      #go to web page
      #login with user credentials
      #navigates to my Profile menu
      #see following menu Overview,Edit Profile,Add Experience,Add Education,Change Password

  @c_Task_f1
  Scenario: Example-3 for Task
        #Given The user is on the login page
    When The user logs in using "testerbfour@gmail.com" and "Tester333"
    And The user navigates to "TesterBFour" and "My Profile" sub menu
    Then The user should be able to see following subMenu
      | Overview        |
      | Edit Profile    |
      | Add Experience  |
      | Add Education   |
      | Change Password |


    #day 5 Class Task f3
    # example 2 with scenario outline
    # use 3 different credentials

  Scenario Outline: Example-2 for Cucumber Map
      #Given The user is on the login page
    When The user logs in using "<userEmail>" and "<password>"
    Then Validate that username is "<name>"
    Then The user should be able to login
    And The user should be able to see following menu
      | Dashboard   |
      | Developers  |
      | Components  |
      | Forms       |
      | JavaScript  |
      | <name> |
    Examples:
      | userEmail        | password  | name         |
      | mike@gmail.com   | mike1234  | mike         |
      | john@gmail.com   | John1234. | John         |
      | eddiem@kraft.com | eddiem12  | Eddie Murphy |

  @c_dataTable_S_outline
  Scenario Outline: Example-2 for "<name>" with Scenario  Outline
    When The user logs in using following menu
      | username | <userEmail> |
      | password | <password>  |
      | name     | <name>      |
    Then The user should be able to login
    And The user should be able to see following menu
      | Dashboard  |
      | Developers |
      | Components |
      | Forms      |
      | JavaScript |
      | <name>     |
    Examples:
      | userEmail        | password  | name         |
      | mike@gmail.com   | mike1234  | mike         |
      | john@gmail.com   | John1234. | John         |
      | eddiem@kraft.com | eddiem12  | Eddie Murphy |


