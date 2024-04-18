package JobsStepDefinition;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import JobsDriverSetup.SetupDriver;
import JobsPageFactory.Jobs;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JobsTest {

	static WebDriver driver;
	Jobs job;

	@Given("User is on Jobs page")
	public void user_is_on_jobs_page() throws InterruptedException, IOException {
		driver = SetupDriver.chromedriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		job = new Jobs(driver);
		job.login();

	}

//==========================================SCENARIO 1(Sharing Job Preferences with recruiters)========================================================================

	@When("User clicks on Preferences")
	public void user_clicks_on_preferences() throws InterruptedException {
		job.preferencesButton();
	}

	@And("User clicks on Open To work")
	public void user_clicks_on_open_to_work() throws InterruptedException {
		job.openToWorkButton();
	}

	@And("User enters title")
	public void user_enters_title(List<Map<String, String>> jobTitles) throws InterruptedException, AWTException {
		String title1 = jobTitles.get(0).get("Title");
		String title2 = jobTitles.get(1).get("Title");

		job.enterTitle(title1);
		job.enterTitle(title2);
	}

	@And("User selects Location types")
	public void user_selects_location_types() throws InterruptedException {
		job.locationType();
	}

	@And("User enters Locations")
	public void user_enters_locations(List<Map<String, String>> locations) throws InterruptedException, AWTException {

		String onsiteLocation1 = locations.get(0).get("Onsite");
		String remoteLocation1 = locations.get(0).get("Remote");

		String onsiteLocation2 = locations.get(1).get("Onsite");
		String remoteLocation2 = locations.get(1).get("Remote");
		job.enterLocation(onsiteLocation1, remoteLocation1);
		job.enterLocation(onsiteLocation2, remoteLocation2);
	}

	@And("User selects Employment types")
	public void user_selects_employment_types() throws InterruptedException {
		job.employmentTypes();
	}

	@And("User sets the visibility")
	public void user_sets_the_visibility() throws InterruptedException {
		job.visisbility();
	}

	@Then("User should be able to save the preferences")
	public void user_should_be_able_to_save_the_preferences() throws InterruptedException {

		job.saveDetails();
		String actual = job.assertSave();
		String expected = "Job preferences saved";
		Assert.assertEquals(expected, actual);
	}

//=======================================SCENARIO 2(Sending Job Feedback to Linkedin)==========================================================================

	@When("User perform a job search")
	public void user_perform_a_job_search() throws InterruptedException, IOException, AWTException {

		job.search();

	}

	@And("User apply Company and Easy Apply filter")
	public void user_apply_company_and_easy_apply_filter() throws InterruptedException, AWTException {
		job.filter();

	}

	@And("User clicks on Send Feedback option of Job")
	public void user_clicks_on_send_feedback_option_of_job() throws InterruptedException, AWTException {
		job.feedbackOption();
	}

	@And("User clicks on send button after writing feedback")
	public void user_clicks_on_send_button_after_writing_feedback() throws InterruptedException, IOException {
		job.send();
	}

	@Then("a confirmation message should be displayed")
	public void a_confirmation_message_should_be_displayed() throws InterruptedException {
		String expectedMessage = "Thanks for the feedback!";
		String actualMessage = job.feedbackSuccess();
		Assert.assertEquals(expectedMessage, actualMessage);

	}

//=======================================SCENARIO 3 (Practicing Interview Answers)=========================================================================

	@When("User clicks on Interview Prep in the left-hand menu")
	public void user_clicks_on_interview_prep_in_the_left_hand_menu() throws InterruptedException {
		job.interviewPrep();
	}

	@And("User selects a specific interview question from the list")
	public void user_selects_a_specific_interview_question_from_the_list() throws InterruptedException {
		job.practiceQues();
	}

	@And("User choose to write a text response for practice")
	public void user_choose_to_write_a_text_response_for_practice() throws InterruptedException {
		job.chooseTextResponse();
	}

	@And("User enters the following answer")
	public void user_enters_the_following_answer(DataTable dataTable) throws InterruptedException {
		List<String> answer = dataTable.asList(String.class);
		for (String ans1 : answer) {
			job.typeAnswer(ans1);
		}
	}

	@And("User save the the answer")
	public void user_save_the_the_answer() throws InterruptedException {
		job.saveAnswer();
	}

	@Then("User should be able to view saved answer")
	public void user_should_be_able_to_view_saved_answer() {
		String actual = job.assertAnswer();
		String expected = "You should hire me because I have the qualifications, experience, and attitude to contribute to your company.";
		Assert.assertEquals(expected, actual);

	}

//=====================================SCENARIO 4(Viewing Saved Job)==========================================================================

	@When("User enters {string} in the first search bar")
	public void user_enters_in_the_first_search_bar(String string) throws InterruptedException {
		job.keywordSearch(string);
	}

	@And("User enters {string} in the second search bar")
	public void user_enters_in_the_second_search_bar(String string) throws InterruptedException, AWTException {
		job.locationSearch(string);
	}

	@And("User save a job from search results")
	public void user_save_a_job_from_search_results() throws InterruptedException {
		job.saveButton();

	}

	@Then("User should be able to view that saved Job in My Jobs")
	public void user_should_be_able_to_view_that_saved_job_in_my_jobs() throws InterruptedException {

		String expectedUrl = "https://www.linkedin.com/my-items/saved-jobs/?cardType=SAVED";
		String actualUrl = job.viewJob();
		Assert.assertEquals(expectedUrl, actualUrl);

	}

//======================================SCENARIO 5(To Test Company filter for Invalid CompanyName)================================================================

	@When("the user performs a job search.")
	public void the_user_performs_a_job_search() throws InterruptedException, IOException, AWTException {
		job.search();
	}

	@And("the user clicks on the AllFilter button.")
	public void the_user_clicks_on_the_all_filter_button() throws InterruptedException {
		job.allFilter();
	}

	@And("the user applies the Company filter by adding a valid CompanyName.")
	public void the_user_applies_the_company_filter_by_adding_a_valid_company_name()
			throws InterruptedException, IOException, AWTException {
		job.addValidName();
	}

	@And("the user applies the Company filter by adding an Invalid CompanyName.")
	public void the_user_applies_the_company_filter_by_adding_an_invalid_company_name()
			throws InterruptedException, AWTException, IOException {
		job.addInvalidName();
	}

	@Then("the addCompany textbox should not take invalid CompanyName")
	public void the_add_company_textbox_should_not_take_invalid_company_name() {
		Boolean actual = job.error();
		Boolean expected = true;
		Assert.assertEquals(expected, actual);
	}

//==================================METHOD FOR TAKING SCREENSHOTS===================================================================

//	@AfterStep
//	public static void takeScreendown(Scenario scenerio) {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//		scenerio.attach(src, "image/png", scenerio.getName());
//	}

}
