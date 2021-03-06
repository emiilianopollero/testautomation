package SeleniumAutomation.Pages;

import SeleniumAutomation.BasePage;
import SeleniumAutomation.Interfaces.HeaderInterface;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import static SeleniumAutomation.Utils.WaitUtil.waitForElementToBeClickable;
import static SeleniumAutomation.Utils.WaitUtil.waitForElementToBeVisible;

public class SignUpPage extends BasePage implements HeaderInterface {
    @FindBy(id = "username_input")
    private WebElement usernameField;
    @FindBy(id = "password_input")
    private WebElement passwordField;
    @FindBy(id = "name_input")
    private WebElement nameField;
    @FindBy(id = "email_input")
    private WebElement emailField;
    @FindBy(id = "day_select")
    private WebElement calendarDay;
    @FindBy(id = "month_select")
    private WebElement calendarMonth;
    @FindBy(id = "year_select")
    private WebElement calendarYear;
    @FindBy(id = "submit_button")
    private WebElement submitBtn;

    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    //    Signs up a new user, with all the required parameters and clicks on the submit button, and returns a new NewUserPage
    public NewUserPage signUp(String username, String password, String name, String email,
                              String day, Month month, String year) {
        System.out.println("Signing up new user");
        enterUsername(username);
        enterPassword(password);
        enterName(name);
        enterEmail(email);
        selectDay(day);
        selectMonth(month);
        selectYear(year);
        submit();
        return new NewUserPage();
    }

    //         Signs up a new user, with all the required parameters and clicks on the submit button,
    //         and returns a new NewUserPage, this method accepts a String month for testing purposes
    public NewUserPage signUp(String username, String password, String name, String email,
                              String day, String month, String year) {
        System.out.println("Signing up new user");
        enterUsername(username);
        enterPassword(password);
        enterName(name);
        enterEmail(email);
        selectDay(day);
        selectMonth(month);
        selectYear(year);
        submit();
        return new NewUserPage();
    }

    //         Clears username field and enters username
    private void enterUsername(String username) {
        System.out.println("Entering username: " + username);
        waitForElementToBeClickable(usernameField);
        enterText(usernameField, username);
    }

    //         Clears password field and enters password
    private void enterPassword(String password) {
        System.out.println("Entering password: " + password);
        waitForElementToBeClickable(passwordField);
        enterText(passwordField, password);
    }

    //         Clears name field and enters username
    private void enterName(String name) {
        System.out.println("Entering name: " + name);
        waitForElementToBeClickable(nameField);
        enterText(nameField, name);
    }

    //         Clears email field and enters email
    private void enterEmail(String email) {
        System.out.println("Entering email: " + email);
        waitForElementToBeClickable(emailField);
        enterText(emailField, email);
    }

    //         Selects day from day select dropdown
    private void selectDay(String day) {
        System.out.println("Selecting day: " + day);
        getSelectElement(calendarDay).selectByValue(day);
    }

    //         Selects month from month select dropdown
    private void selectMonth(Month month) {
        Locale locale = Locale.ENGLISH;
        System.out.println("Selecting month: " + month.getDisplayName(TextStyle.FULL, locale));
        getSelectElement(calendarMonth).selectByValue(month.getDisplayName(TextStyle.FULL, locale));
    }

    //         Selects month from month select dropdown using a String month value
    private void selectMonth(String month) {
        System.out.println("Selecting month: " + month);
        getSelectElement(calendarMonth).selectByValue(month);
    }

    //         Selects year from year select dropdown
    private void selectYear(String year) {
        System.out.println("Selecting year: " + year);
        getSelectElement(calendarYear).selectByValue(year);
    }

    //         Clicks on the submit button
    private void submit() {
        waitForElementToBeClickable(submitBtn);
        scrollIntoElement(submitBtn);
        submitBtn.click();
    }
}
