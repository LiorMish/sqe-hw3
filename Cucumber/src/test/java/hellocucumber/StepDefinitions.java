package hellocucumber;

import Moodle.MoodleActuator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {

    private static List<MoodleActuator> allMoodles;
    private static MoodleActuator moodle_student;
    private static MoodleActuator moodle_teacher;



    public void moodleInit(String student_username, String student_password) {
        System.out.println("--------------- INITIALIZING MOODLE TEST - OPENING WEBPAGE ---------------");
        if(allMoodles == null){
            allMoodles = new ArrayList<>();
        }
        moodle_student = new MoodleActuator();
        allMoodles.add(moodle_student);
//        moodle.initSession(student_username, student_password, teacher_username, teacher_password);
        moodle_student.initSession(student_username, student_password);
    }

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








/*
    // $$*TODO* explain what this step does$$
    @When("User Navigate to add discussion topic")
    public void navigateTo_add_discussion_topic() {
        moodle.goToAddDiscussionPage();
    }
    @When("User Navigate to \"add discussion topic\"")
    public void navigateTo_add_discussion_topic() {
    }
    @When("^User enters SubjectName \"([^\"]*)\" and Message \"([^\"]*)\"$")
    public void enterLoginInfo(String username, String password){
        moodle.enterLoginInfo(username, password);
    }

    // $$*TODO* explain what this step does$$
    @Then("the scenario passes")
    public void theScenarioPasses() {
    }

    @And("User enters Subject <Subject> and Message <Message>")
    public void userEntersSubjectSubjectAndMessageMessage() {
    }*/
}
