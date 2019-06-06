Feature: Test creating new users and trying to log in with created users credentials

  Scenario Outline: Create new user and log to the website with created user
    When I am on the website
    And I click Stworz Bezplatne Konto
    And I create new user with follwing: "<user name>", "<password>", "<e-mail>"
    Then I see a message that new user has been added
    When I click Zaloguj Sie
    And I enter following user details: "<e-mail>", "<password>"
    Then I see a message that user was not registered yet

    Examples:
      | user name | password     | e-mail           |
      | Bartosz   | Bartosz123   | bartosz@xxx.pl   |
      | Angelika  | AngelikaXYZ2 | angelika@wp.pl   |
      | Hilary    | HilaryAbc1   | hilary03@xxx.com |