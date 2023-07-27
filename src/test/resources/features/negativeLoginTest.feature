Feature: Negative Login Test

  @negativeLogin
  Scenario Outline: Negative Login Test
    Given The user is on the login page
    When The user logs in using "<invalidUserEmail>" and "<invalidPassword>"
    Then Validate the warning message is "<message>"
    Examples:
      | invalidUserEmail      | invalidPassword | message                                  |
      | invalidUserEmail      | Test1234        | Email address is incorrect. Please check |
      | testerbfour@gmail.com | 333             | Password is incorrect. Please check      |
      |                       | Test1234        | Please enter your email.                 |
      | testerbfour@gmail.com |                 | Please enter your password!              |
      |                       |                 | Please enter your email.                 |