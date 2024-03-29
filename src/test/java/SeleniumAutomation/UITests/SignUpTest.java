package SeleniumAutomation.UITests;

import SeleniumAutomation.BaseTest;
import SeleniumAutomation.Pages.HomePage;
import SeleniumAutomation.Pages.NewUserPage;
import SeleniumAutomation.Pages.SignUpPage;
import SeleniumAutomation.Utils.FakeDataFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Month;

import static SeleniumAutomation.BasePage.getRandomNumber;
import static SeleniumAutomation.BasePage.getTitleText;

public class SignUpTest extends BaseTest {

    // This test verifies users can signUp and the proper profile page is shown to them
    @Test(priority = 1, description = "UI: Validate users can sign up and the proper profile page is shown to them")
    public void validateUserCanSignUp() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test verifies users can signUp and the proper profile page is shown to them");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        NewUserPage newUserPage = signUpPage.signUp(FakeDataFactory.getRandomUsername(), FakeDataFactory.getRandomStringNumber(),
                FakeDataFactory.getRandomFirstName(),FakeDataFactory.getRandomEmail(), FakeDataFactory.getRandomDay(),
                FakeDataFactory.getRandomMonth(), FakeDataFactory.getRandomYear());
        System.out.println("Validating profile page for new user");
        Assert.assertEquals(newUserPage.getWelcomeText(), "Welcome to your new profile page, " + "Emiliano!");
        System.out.println("Profile page for new user is correct");
    }

    @Test(priority = 1, description = "UI: Validate username is required on sign up")
    public void requiredSignUpFieldsUsernameTest() {
        // This case verifies that username is mandatory
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test validates username is required on signUp");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("", "123456", "Emiliano",
                "test@test.com", "19", Month.JUNE, "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        System.out.println("User with no username was not registered");
    }

    @Test(priority = 1, description = "UI: Validate password is required on sign up")
    public void requiredSignUpFieldsPasswordTest() {
        // This case verifies that password is mandatory
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test validates password is required on signUp");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano.pollero", "", "Emiliano",
                "test@test.com", "19", Month.JUNE, "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        System.out.println("User with no password was not registered");
    }

    @Test(priority = 1, description = "UI: Validate name is required on sign up")
    public void requiredSignUpFieldsNameTest() {
        // This case verifies that name is mandatory
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test validates name is required on signUp");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano,pollero", "123456", "",
                "test@test.com", "19", Month.JUNE, "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        System.out.println("User with no name was not registered");
    }

    @Test(priority = 1, description = "UI: Validate email is required on sign up")
    public void requiredSignUpFieldsEmailTest() {
        // This case verifies that email is mandatory
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test validates email is required on signUp");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano,pollero", "123456", "Emiliano",
                "", "19", Month.JUNE, "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        System.out.println("User with no email was not registered");
    }

    @Test(priority = 1, description = "UI: Validate day is required on sign up")
    public void requiredSignUpFieldsDayTest() {
        // This case verifies that day is mandatory
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test validates day is required on signUp");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano,pollero", "123456", "Emiliano",
                "test@test.com", "", Month.JUNE, "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        System.out.println("User with no email was not registered");
    }

    @Test(priority = 1, description = "UI: Validate month is required on sign up")
    public void requiredSignUpFieldsMonthTest() {
        // This case verifies that month is mandatory
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test validates month is required on signUp");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano,pollero", "123456", "Emiliano",
                "test@test.com", "19", "", "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        System.out.println("User with no email was not registered");
    }

    @Test(priority = 1, description = "UI: Validate year is required on sign up")
    public void requiredSignUpFieldsYearTest() {
        // This case verifies that year is mandatory
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test validates year is required on signUp");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano,pollero", "123456", "Emiliano",
                "test@test.com", "19", Month.JUNE, "");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        System.out.println("User with no year was not registered");
    }

    @Test(priority = 1, description = "UI: Validate email is required on sign up")
    public void incorrectEmailFormatTest() {
        // This case verifies email format
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test validates email is formatted properly");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano,pollero", "123456", "Emiliano",
                "email", "19", Month.JUNE, "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        System.out.println("User with incorrect email was not registered");
    }

    @Test(priority = 1, description = "UI: Validate email should have something before @ symbol")
    public void incorrectEmailFormatNothingBeforeAtTest() {
        // This case verifies email should have something before @ symbol
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test validates email should have something before @ symbol");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano,pollero", "123456", "Emiliano",
                "@email.com", "19", Month.JUNE, "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        System.out.println("User with incorrect email was not registered");
    }

    @Test(priority = 1, description = "UI: Validate email should have something after @ symbol")
    public void incorrectEmailFormatNothingAfterAtTest() {
        // This case verifies email should have something after @ symbol
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test validates email should have something after @ symbol");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano,pollero", "123456", "Emiliano",
                "email@", "19", Month.JUNE, "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        System.out.println("User with incorrect email was not registered");
    }

    @Test(priority = 1, description = "UI: Validate email has not invalid characters before @ symbol")
    public void incorrectEmailFormatInvalidCharactersBeforeAtTest() {
        // This case verifies email has not invalid characters before @ symbol
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test validates email has not invalid characters before @ symbol");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano,pollero", "123456", "Emiliano",
                "’àáâãäåæçèéêë@mail.com", "19", Month.JUNE, "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        System.out.println("User with incorrect email was not registered");
    }

    @Test(priority = 1, description = "UI: Validate email has not invalid characters after @ symbol")
    public void incorrectEmailFormatInvalidCharactersAfterAtTest() {
        // This case verifies email has not invalid characters after @ symbol
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test validates email has not invalid characters after @ symbol");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano,pollero", "123456", "Emiliano",
                "پ محسوس کر سک@email", "19", Month.JUNE, "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        System.out.println("User with incorrect email was not registered");
    }

    @Test(priority = 1, description = "UI: Validate system rejects signUp with an already taken username")
    public void alreadyPresentUsernameSignUpTest() {
        // This case verifies system rejects signUp with an already taken username
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test verifies system rejects signUp with an already taken username");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("tester", "123456", "Emiliano",
                "email@email.com", "19", Month.JUNE, "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        Assert.assertEquals("This hero is already registered. Try another one!", signUpPage.getStatusText());
        System.out.println("User with incorrect email was not registered");
    }

    @Test(priority = 1, description = "UI: Validate system rejects signUp with an already taken email")
    public void alreadyPresentEmailSignUpTest() {
        // This case verifies system rejects signUp with an already taken email
        System.out.println("----------------------------------------------------------------------");
        System.out.println("This test verifies system rejects signUp with an already taken email");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano.alejandro", "123456", "Emiliano",
                "as.tester@wearewaes.com", "19", Month.JUNE, "1982");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up");
        Assert.assertEquals("This hero is already registered. Try another one!", signUpPage.getStatusText());
        System.out.println("User with incorrect email was not registered");
    }

    @Test(priority = 1, description = "UI: Validate system rejects signUp with an invalid year")
    public void invalidDateRangeSignUpTest() {
        // UI: Validate system rejects signUp with an invalid year
        System.out.println("----------------------------------------------------------------------");
        System.out.println("UI: Validate system rejects signUp with an invalid year");
        System.out.println("----------------------------------------------------------------------");
        HomePage homePage = new HomePage();
        SignUpPage signUpPage = homePage.clickSignUp();
        signUpPage.signUp("emiliano.alejandro", "123456", "Emiliano",
                getRandomNumber() + "test@test.com", "19", Month.JUNE, "1900");
        System.out.println("Validating user has not been signed");
        Assert.assertEquals(getTitleText(), "Sign Up", "User was registered using DOB Year 1900");
        System.out.println("User with invalid year was not registered");
    }
}
