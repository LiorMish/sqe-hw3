#Feature: A set of scenarios for testing the "example" module
#
#  Scenario: Testing how a case where a user adds a product to the cart
#    Given an example scenario
#    When all step definitions are implemented
#    Then the scenario passes

Feature: Student is adding a comment in the forum course, teacher is deleting forum.

  Scenario: Student is adding a comment in the forum course
    Given User enters moodle with username as "lior" and password as "Lior1234!!" and enters forum Page
    When User Navigate to add discussion topic
    And User enters Subject as "VIP Subject" and Message as "Hi everyone, How are you today?"
    And Clicking on Post to forum
    Then Successfully post message


  Scenario: Teacher is deleting the forum course
    Given User enters moodle with username as "teacher" and password as "Teach1234!!" and enters main course Page
    When User clicking on Edit mode
    And Clicking on options of the forum
    And Clicking on Delete
    And Clicking on Yes on the confirm message
    Then the scenario passes

