Feature: Test if user can add offer, edit and delete it

  Scenario Outline: Log in as regular user: add offer, edit and delete it
    When I am on the website
    And I click Zaloguj Sie
    And I enter following user details: "piotr_z6@wp.pl", "aaasss123"
    And I click Publikuj Twoja Oferte Bezplatnie
    And I add offer as registerd user with following: "<category>", "<title>", "<description>", "<region>", "<city>", "<neighbourhood>", "<address>", "<photo>"
    Then I see a message that offer was published successfully
    When I click Moje Konto
    Then On search list I should see: "<category>", "<title>", "<description>", "<region>", "<city>"
    When I click Edytuj Ogloszenie
    And I replace existing description with "<new description>"
    And I click Moje Konto
    Then On search list I should see: "<category>", "<title>", "<new description>", "<region>", "<city>"
    When I click Usun
    Then I should see no offers
    When I click Wyloguj
    Then I should be able to click Zaloguj Sie again

    Examples:
      | category            | title        | description    | new description | region        | city | neighbourhood | address    | photo            |
      | Biżuteria i zegarki | Oddam Rolexa | Opis Opis Opis | Nowy Opis       | wielkopolskie | Piła | Nowe Miasto   | Czecha 2/6 | \depo\rolex.jpg  |
      | Ubrania             | Fajna kurtka | Opis Opis Opis | Nowy Opis       | wielkopolskie | Piła | Nowe Miasto   | czecha 2/6 | \depo\jacket.jpg |