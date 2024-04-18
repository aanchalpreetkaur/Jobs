package JobsPageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Jobs {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//===========================================XPATHS===================================================================================================

	@FindBy(id = "session_key")
	@CacheLookup
	WebElement email;

	@FindBy(css = "#session_password")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//button[@data-id=\"sign-in-form__submit-btn\"]")
	WebElement lgbtn;

	@FindBy(css = "span[title=\"Jobs\"]")
	WebElement jobs;

	@FindBy(xpath = "//input[@class=\"jobs-search-box__text-input jobs-search-box__keyboard-text-input\"]")
	WebElement search1;

	@FindBy(xpath = "//input[@class=\"jobs-search-box__text-input\" and @role=\"combobox\"]")
	WebElement search2;

	@FindBy(xpath = "//button[@class=\"jobs-save-button artdeco-button artdeco-button--3 artdeco-button--secondary\"]")
	WebElement save1;

	@FindBy(xpath = "//a[@href=\"/my-items/saved-jobs/?cardType=SAVED\"]")
	WebElement alertLink;

	@FindBy(css = "button[aria-label=\"Easy Apply filter.\"]")
	WebElement easyApply;

	@FindBy(id = "searchFilter_company")
	WebElement company;

	@FindBy(css = "input[placeholder='Add a company']")
	WebElement companyName;

	@FindBy(xpath = "//div[@class=\"artdeco-dropdown jobs-options artdeco-dropdown--placement-bottom artdeco-dropdown--justification-right ember-view\"]")
	WebElement dots;

	@FindBy(xpath = "//div[@class=\"artdeco-dropdown jobs-options artdeco-dropdown--placement-bottom artdeco-dropdown--justification-right ember-view\"]/descendant::div")
	WebElement feedback;

	@FindBy(name = "feedbackText")
	WebElement feedbackText;

	@FindBy(xpath = "//div[@class=\"artdeco-modal__actionbar display-flex justify-flex-end ph5 pv4 ember-view\"]/button[2]")
	WebElement send;

	@FindBy(xpath = "//div[@class=\"artdeco-toast-item artdeco-toast-item--visible ember-view\"]/div/p/span")
	WebElement alert;

	@FindBy(xpath = "//a[@href=\"https://www.linkedin.com/jobs/preferences?viewType=SEEKING_PREFERENCES\"]\r\n" + "")
	WebElement preferences;

	@FindBy(xpath = "//a[@href=\"https://www.linkedin.com/jobs/opportunities/job-opportunities/onboarding?origin=JOB_SEEKING_PREFERENCES\"]\r\n"
			+ "")
	WebElement openToWork;

	@FindBy(xpath = "//fieldset[@id=\"pill-form-component-openToWorkPreferencesFormElement-JOB-TITLES\"]/descendant::div/descendant::button")
	WebElement title;

	@FindBy(xpath = "//fieldset[@id=\"pill-form-component-openToWorkPreferencesFormElement-JOB-TITLES\"]/descendant::div/descendant::input")
	WebElement titleInput;

	@FindBy(xpath = "//fieldset[@id=\"pill-form-component-openToWorkPreferencesFormElement-WORKPLACES\"]/descendant::button[3]")
	WebElement remote;

	@FindBy(xpath = "//fieldset[@id=\"pill-form-component-openToWorkPreferencesFormElement-JOB-LOCATIONS\"]/div/descendant::button")
	WebElement location;

	@FindBy(xpath = "//fieldset[@id=\"pill-form-component-openToWorkPreferencesFormElement-JOB-LOCATIONS\"]/div/descendant::input")
	WebElement locationInput;

	@FindBy(xpath = "//fieldset[@id=\"pill-form-component-openToWorkPreferencesFormElement-REMOTE-JOB-LOCATIONS\"]/div/descendant::button")
	WebElement remoteLocation;

	@FindBy(xpath = "//fieldset[@id=\"pill-form-component-openToWorkPreferencesFormElement-REMOTE-JOB-LOCATIONS\"]/div/descendant::input")
	WebElement remoteLocationInput;

	@FindBy(xpath = "//fieldset[@id=\"pill-form-component-openToWorkPreferencesFormElement-JOB-TYPES\"]/button[2]")
	WebElement partTime;

	@FindBy(xpath = "//fieldset[@id=\"pill-form-component-openToWorkPreferencesFormElement-JOB-TYPES\"]/button[4]")
	WebElement internship;

	@FindBy(xpath = "//fieldset[@id=\"radio-button-form-component-openToWorkPreferencesFormElement-VISIBILITY\"]/div[1]")
	WebElement checkbox;

	@FindBy(xpath = "//button[@data-view-name=\"open-to-work-job-preferences-save\"]")
	WebElement save2;

	@FindBy(xpath = "//div[@class=\"artdeco-modal__content ember-view relative \"]/descendant::div/descendant::h2")
	WebElement assertSave;

	@FindBy(xpath = "//a[@href=\"https://www.linkedin.com/interview-prep\"]")
	WebElement interview;

	@FindBy(xpath = "//ol[@class=\"list-style-none\"]/li[4]")
	WebElement ques;

	@FindBy(xpath = "//button[@class=\"interview-prep-question-details__answer-button mr2 artdeco-button artdeco-button--2 artdeco-button--primary ember-view\"]")
	WebElement practiceButton;

	@FindBy(xpath = "//div[@class=\"artdeco-modal__content ember-view\"]/button[2]")
	WebElement responseButton;

	@FindBy(xpath = "//textarea[@class=\"interview-prep-text-answer-modal__answer-input artdeco-text-input--input artdeco-text-input__textarea\"]")
	WebElement text;

	@FindBy(xpath = "//button[@class=\"mlA artdeco-button artdeco-button--2 artdeco-button--primary ember-view\"]/span")
	WebElement save3;

	@FindBy(xpath = "//span[@class=\"interview-prep__text-view-model t-16 t-black--light\"]")
	WebElement assertAns;

	@FindBy(xpath = "//button[@aria-label=\"Show all filters. Clicking this button displays all available filter options.\"]")
	WebElement allFiltersButton;

	@FindBy(xpath = "//ul[@class=\"list-style-none flex-1\"]/li[5]/descendant::button")
	WebElement addCompanyButton;

	@FindBy(xpath = "//ul[@class=\"list-style-none flex-1\"]/li[5]/descendant::div[2]/descendant::div/input")
	WebElement addCompanyInput;

	@FindBy(xpath = "//ul[@class=\"list-style-none flex-1\"]/parent::div")
	WebElement filterContainer;

	
	// METHOD FOR INITIATING THE DRIVER
	public Jobs(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	// METHOD FOR LOGIN INTO LINKEDIN
	public void login() throws InterruptedException, IOException {

		File file = new File("C:\\Users\\AANKAUR\\Desktop\\Sprint2\\Jobs\\src\\test\\resource\\ExcelData\\login.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheetAt(0);
		String cellvalue1 = s.getRow(2).getCell(0).getStringCellValue();
		double cellvalue2 = s.getRow(2).getCell(1).getNumericCellValue();
		int pass1 = (int) cellvalue2;
		String pass2 = Integer.toString(pass1);

		email.sendKeys(cellvalue1);
		wait.until(ExpectedConditions.elementToBeClickable(password));

		password.sendKeys(pass2);
		wait.until(ExpectedConditions.elementToBeClickable(lgbtn));

		lgbtn.click();
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(jobs));
		jobs.click();

	}

//==========================================SCENARIO 1(Sharing Job Preferences with recruiters)========================================================================

	public void preferencesButton() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(preferences));
		preferences.click();

	}

	public void openToWorkButton() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(openToWork));
		openToWork.click();

	}

	public void enterTitle(String titles) throws InterruptedException, AWTException {

		Actions act = new Actions(driver);
		Robot r = new Robot();

		r.delay(1000);
		title.click();

		r.delay(1000);
		titleInput.sendKeys(titles);

		r.delay(1000);
		act.sendKeys(Keys.DOWN).build().perform();

		r.delay(1000);
		act.sendKeys(Keys.ENTER).build().perform();

	}

	public void locationType() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(remote));
		remote.click();

	}

	public void enterLocation(String onsite, String remote) throws InterruptedException, AWTException {

		Actions act = new Actions(driver);
		Robot r = new Robot();

		r.delay(1000);
		location.click();

		r.delay(1000);
		locationInput.sendKeys(onsite);

		r.delay(1000);
		act.sendKeys(Keys.DOWN).build().perform();

		r.delay(1000);
		act.sendKeys(Keys.ENTER).build().perform();

		r.delay(1000);
		remoteLocation.click();

		r.delay(1000);
		remoteLocationInput.sendKeys(remote);

		r.delay(1000);
		act.sendKeys(Keys.DOWN).build().perform();

		r.delay(1000);
		act.sendKeys(Keys.ENTER).build().perform();

	}

	public void employmentTypes() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(partTime));
		partTime.click();

		wait.until(ExpectedConditions.elementToBeClickable(internship));
		internship.click();

	}

	public void visisbility() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(checkbox));
		checkbox.click();

	}

	public void saveDetails() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(save2));
		save2.click();

	}

	public String assertSave() {

		wait.until(ExpectedConditions.visibilityOf(assertSave));
		String text = assertSave.getText();
		return text;
	}

//=======================================SCENARIO 2(Sending Job Feedback to Linkedin)==========================================================================

	public void search() throws InterruptedException, IOException, AWTException {

		File file = new File("C:\\Users\\AANKAUR\\Desktop\\Sprint2\\Jobs\\src\\test\\resource\\ExcelData\\search.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheetAt(0);
		String keyword = s.getRow(0).getCell(0).getStringCellValue();
		String location = s.getRow(0).getCell(1).getStringCellValue();

		wait.until(ExpectedConditions.elementToBeClickable(search1));
		search1.sendKeys(keyword);

		wait.until(ExpectedConditions.elementToBeClickable(search2));
		search2.sendKeys(location);

		Robot r = new Robot();
		r.delay(1000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();

	}

	public void filter() throws InterruptedException, AWTException {

		wait.until(ExpectedConditions.elementToBeClickable(company));
		company.click();

		wait.until(ExpectedConditions.elementToBeClickable(companyName));
		companyName.sendKeys("Tata Consultancy Services");

		Robot r = new Robot();
		r.delay(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(1000);
		r.mouseMove(705, 600);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		r.delay(1000);
		r.mouseMove(1050, 250);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

	}

	public void feedbackOption() throws InterruptedException, AWTException {

		wait.until(ExpectedConditions.elementToBeClickable(dots));
		dots.click();

		Robot r = new Robot();
		r.delay(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public void send() throws IOException, InterruptedException {

		File file = new File("C:\\Users\\AANKAUR\\Desktop\\Sprint2\\Jobs\\src\\test\\resource\\ExcelData\\Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheetAt(0);
		String cellvalue = s.getRow(0).getCell(0).getStringCellValue();
       
		wait.until(ExpectedConditions.visibilityOf(feedbackText));
		feedbackText.sendKeys(cellvalue);

		wait.until(ExpectedConditions.elementToBeClickable(send));
		send.click();

	}

	public String feedbackSuccess() {

		wait.until(ExpectedConditions.visibilityOf(alert));
		String text = alert.getText();
		return text;
	}

//=======================================SCENARIO 3 (Practicing Interview Answers)=========================================================================

	public void interviewPrep() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(interview));
		interview.click();

	}

	public void practiceQues() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(ques));
		ques.click();

		wait.until(ExpectedConditions.elementToBeClickable(practiceButton));
		practiceButton.click();

	}

	public void chooseTextResponse() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(responseButton));
		responseButton.click();

	}

	public void typeAnswer(String keyword) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(text));
		text.sendKeys(keyword);

	}

	public void saveAnswer() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(save3));
		save3.click();

	}

	public String assertAnswer() {

		wait.until(ExpectedConditions.elementToBeClickable(assertAns));
		String text = assertAns.getText();
		return text;
	}

//=====================================SCENARIO 4(Viewing Saved Job)==========================================================================

	public void keywordSearch(String keyword) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(search1));
		search1.sendKeys(keyword);

	}

	public void locationSearch(String location) throws InterruptedException, AWTException {

		wait.until(ExpectedConditions.elementToBeClickable(search2));
		search2.sendKeys(location);

		Actions act = new Actions(driver);
		Robot r = new Robot();
		r.delay(1000);
		act.sendKeys(Keys.ENTER).build().perform();
		r.delay(1000);
		r.mouseMove(1050, 250);
		r.delay(1000);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.delay(1000);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

	}

	public void saveButton() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(save1));
		save1.click();

	}

	public String viewJob() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(alertLink));
		alertLink.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		return url;

	}

//======================================SCENARIO 5(To Test Company filter for Invalid CompanyName)================================================================

	public void allFilter() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(allFiltersButton));
		allFiltersButton.click();
	}

	public void addValidName() throws InterruptedException, IOException, AWTException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollBy(0, 900)", filterContainer);
      
		wait.until(ExpectedConditions.elementToBeClickable(addCompanyButton));
		addCompanyButton.click();

		File file = new File("C:\\Users\\AANKAUR\\Desktop\\Sprint2\\Jobs\\src\\test\\resource\\ExcelData\\companyName.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheetAt(0);
		String validName = s.getRow(0).getCell(0).getStringCellValue();

		wait.until(ExpectedConditions.elementToBeClickable(addCompanyInput));
		addCompanyInput.sendKeys(validName);

		Actions act = new Actions(driver);
		Robot r = new Robot();
		r.delay(1000);
		act.sendKeys(Keys.DOWN).build().perform();
		r.delay(1000);
		act.sendKeys(Keys.ENTER).build().perform();
		r.delay(2000);

	}

	public void addInvalidName() throws InterruptedException, AWTException, IOException {

		wait.until(ExpectedConditions.elementToBeClickable(addCompanyButton));
		addCompanyButton.click();

		File file = new File("C:\\Users\\AANKAUR\\Desktop\\Sprint2\\Jobs\\src\\test\\resource\\ExcelData\\companyName.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheetAt(0);
		String invalidName = s.getRow(0).getCell(1).getStringCellValue();

		wait.until(ExpectedConditions.elementToBeClickable(addCompanyInput));
		addCompanyInput.sendKeys(invalidName);

		Actions act = new Actions(driver);
		Robot r = new Robot();
		r.delay(1000);
		act.sendKeys(Keys.DOWN).build().perform();
		r.delay(1000);
		act.sendKeys(Keys.ENTER).build().perform();

	}

	public boolean error() {

		boolean present = addCompanyButton.isEnabled();
		return present;

	}

}
