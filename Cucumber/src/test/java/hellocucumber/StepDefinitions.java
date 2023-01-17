package hellocucumber;

import Moodle.MoodleActuator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class StepDefinitions {

    private static List<MoodleActuator> allMoodles;
    private static MoodleActuator moodle_student;
    private static MoodleActuator moodle_teacher;

/*
    Student Scenario
*/
    @Given("User enters moodle with username as {string} and password as {string} and enters forum Page")
    public void userEntersMoodleWithUsernameAsAndPasswordAsAndEntersForumPage(String username, String password) {
        //moodleInit(username, password);
        moodle_student = new MoodleActuator();
        moodle_student.initSession(username, password);
    }

    @When("User Navigate to add discussion topic")
    public void userNavigateToAddDiscussionTopic() {
        moodle_student.navigateTo_AddDiscussionTopic();
    }

    @And("User enters Subject as {string} and Message as {string}")
    public void userEntersSubjectAsAndMessageAs(String subject, String message) {
        moodle_student.entersSubjectAndMessage(subject, message);
    }

    @And("Clicking on Post to forum")
    public void clickingOnPostToForum() {
        moodle_student.postToForum();
    }

    @Then("Successfully post message")
    public void theScenarioPasses_successfullyPosted() {
        System.out.println(moodle_student.successfullyPostMessage());
    }


    /*
    Teacher Scenario
*/
    @Given("User enters moodle with username as {string} and password as {string} and enters main course Page")
    public void userEntersMoodleWithUsernameAsAndPasswordAsAndEntersMainCoursePage(String username, String password) {
        moodle_teacher = new MoodleActuator();
        moodle_teacher.initSession(username, password);
    }

    @When("User clicking on Edit mode")
    public void userClickingOnEditMode() {
        moodle_teacher.click_on_edit_mode();

    }

    @And("Clicking on options of the forum")
    public void clickingOnOptionsOfTheForum() {
        moodle_teacher.click_on_forum_options();
    }

    @And("Clicking on Delete")
    public void clickingOnDelete() {
        moodle_teacher.click_on_delete();
    }

    @And("Clicking on Yes on the confirm message")
    public void clickingOnYesOnTheConfirmMessage() {
        moodle_teacher.click_on_yes();
    }

    @Then("the scenario passes")
    public void theScenarioPasses_successfullyDeleted() {
        System.out.println("Forum Successfully Deleted");
    }

}
