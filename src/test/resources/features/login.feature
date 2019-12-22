

Feature: Login functionality
      #(Optional)#
        As an authorized user i should be able to login.
  #teacher, student, team_lead#

  Scenario : Teacher Login
    Given user is on the login page
    Then user enters teacher username
    And user enters teacher password
    When user clicks sign in button
    Then the page title must be correct

#    Scenario: Student Login
#      Given user is on the login page
#      Then user enters student username
#      And user enters student password
#      When user clicks sign in button
#      Then the page title must be correct


