@login_tag
Feature: Login functionality


  @student @wip
  Scenario: Student Login
    Given user is on the login page
    Then user enters username: 'student_username'
    Then user enters password: 'student_password'
    When user clicks sign in button
    Then the page title must be correct
    Then 4 menu options are shown

    @teacher
  Scenario: Teacher Login
    Given user is on the login page
    Then user enters username: 'teacher_username'
    Then user enters password: 'teacher_password'
    When user clicks sign in button
    Then the page title must be correct
      Then 4 menu options are shown

 @teamLead
  Scenario: Team Lead Login
    Given user is on the login page
    Then user enters username: 'teamlead_username'
    Then user enters password: 'teamlead_password'
    When user clicks sign in button
    Then the page title must be correct
   Then 4 menu options are shown