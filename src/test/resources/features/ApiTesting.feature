Feature: Api testing for CRUID operators

  Background:
    Given users given api url "https://gorest.co.in/"

  Scenario Outline: POST -Create a new user
    Given set api end point "public/v2/users"
    And User creates new user with request body "<Name>","<Gender>","<Email>","<Status>"
    Then validate the status code 201
    And validate the userId is not null
    And validate the user name is "<Name>"
    And validate the user Gender is "<Gender>"
    And validate the user Email is "<Email>"
    And validate the user Status is "<Status>"


    Examples:
      | Name       | Gender | Email                 | Status   |
      | Fatih Turk | male   | fthturker82@gmail.com | inactive |

