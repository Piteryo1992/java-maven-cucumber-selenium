Feature: Strona internetowa umożliwiająca użytkownikom wystawianie swoich ofert, przedmiotów, usług oraz ich wyszukiwanie.

  Scenario Outline: Add offer to the website and check if the offer exists and can be found
    When I am on the website
    And I click Publikuj Twoja Oferte Bezplatnie
    And I add offer with following: "<category>", "<title>", "<description>", "<region>", "<city>", "<neighbourhood>", "<address>", "<contact name>", "<contact email>", "<photo>"
    Then I see a message that offer was published successfully
    When I navigate to home page
    And I search for following: "<category>", "<title>", "<region>", "<city>"
    Then On search list I should see: "<category>", "<title>", "<description>", "<region>", "<city>"

    Examples:
      | category             | title           | description    | region             | city         | neighbourhood | address             | contact name | contact email     | photo              |
      | Komputery i hardware | Nowy laptop     | Opis Opis Opis | mazowieckie        | Warszawa     | Praga         | Sucha 4/1           | Maciej       | Maciej@onet.pl    | \depo\computer.jpg |
      | Ubrania              | Kurta ramoneska | Opis Opis Opis | zachodniopomorskie | Szczecin     | Pogodno       | Słoneczna 3/3       | Joanna       | Joanna@gmails.com | \depo\jacket.jpg   |
      | Zwierzęta            | Kot rasowy      | Opis Opis Opis | podkarpackie       | Stalowa Wola | Pławo         | Poniatowskiego 31/8 | Magda        | Magda@onetx.pl    | \depo\cat.jpg      |
      | Elektronika          | Pilot do TV     | Opis Opis Opis | podlaskie          | Białystok    | Bojary        | Bojarska 6/2        | Józef        | Jozef@interias.pl | \depo\remote.jpg   |
      | Naprawy              | Naprawię płot   | Opis Opis Opis | lubelskie          | Lublin       | Centrum       | Dworcowa 4A         | Ela          | Ela@vpp.pl        | \depo\fence.jpg    |