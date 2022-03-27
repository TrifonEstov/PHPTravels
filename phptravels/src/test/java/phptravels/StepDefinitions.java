package phptravels;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class StepDefinitions {

    public WebDriver driver;

    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "/home/trifon/Desktop/QaiWare/PHPTravels/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void closeDriver(){
        driver.quit();
    }


    @Given("the user is on PHP Travels homepage")
    public void theUserIsOnPHPTravelsHomepage() {
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, "PHPTRAVELS - PHPTRAVELS");
    }

    @When("he navigates to the sign in page")
    public void heNavigatesToTheSignInPage() {
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"fadein\"]/header/div[1]/div/div/div[2]/div/div/a[2]"));
        signInButton.click();
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals(loginPageTitle, "Login - PHPTRAVELS");
    }

    @And("he enters {string} as account email")
    public void heEntersAsAccountEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input"));
        emailField.sendKeys(email);
    }

    @And("he enters {string} as a password")
    public void heEntersAsAPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input"));
        passwordField.sendKeys(password);
    }

    @And("he clicks Login button")
    public void heClicksLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button"));
        loginButton.click();
    }

    @Then("ensure that the account is successfully logged in")
    public void ensureThatTheAccountIsSuccessfullyLoggedIn() {
        String userDashboardTitle = driver.getTitle();
        Assert.assertEquals(userDashboardTitle, "Dashboard - PHPTRAVELS");
    }

    @Then("ensure that the login is unsuccessful")
    public void ensureThatTheLoginIsUnsuccessful() {
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals(loginPageTitle, "Login - PHPTRAVELS");
    }

    @And("he clicks on Logout button")
    public void heClicksOnLogoutButton() {
        WebElement logOutButton = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[5]/a"));
        logOutButton.click();
    }

    @Then("ensure that the account is successfully logged out")
    public void ensureThatTheAccountIsSuccessfullyLoggedOut() {
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals(loginPageTitle, "Login - PHPTRAVELS");
    }

//    @But("make sure that error message is shown")
//    public void makeSureThatErrorMessageIsShown() throws InterruptedException {
//        Thread.sleep(2000);
//        Alert alert = driver.switchTo().alert();
//        String alertMessage = driver.switchTo().alert().getText();
//        Assert.assertEquals(alertMessage, "Please fill out this field.");
//    }

    @When("he navigates to the sign up page")
    public void heNavigatesToTheSignUpPage() {
        WebElement signupButton = driver.findElement(By.xpath("//*[@id=\"fadein\"]/header/div[1]/div/div/div[2]/div/div/a[1]"));
        signupButton.click();
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals(loginPageTitle, "Signup - PHPTRAVELS");
    }

    @And("he enters {string} as first name and {string} as last name")
    public void heEntersAsFirstNameAndAsLastName(String firstName, String lastName) {
        WebElement firstNameInputField = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input"));
        WebElement lastNameInputField = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div/input"));
        firstNameInputField.sendKeys(firstName);
        lastNameInputField.sendKeys(lastName);

    }

    @And("he enters {string} as first name,{string} as last name and {string} as phone number")
    public void heEntersAsFirstNameAsLastNameAndAsPhoneNumber(String firstName, String lastName, String phoneNumber) {
        WebElement firstNameInputField = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input"));
        WebElement lastNameInputField = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div/input"));
        WebElement phoneNumberInputField = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/div/input"));
        firstNameInputField.sendKeys(firstName);
        lastNameInputField.sendKeys(lastName);
        phoneNumberInputField.sendKeys(phoneNumber);
    }

    @And("he enters email")
    public void heEntersEmail() {
        Random numGenerator = new Random();
        int randomNumber = numGenerator.nextInt(1000);
        String emailForSignup = "test" + randomNumber + "@gmail.com";
        WebElement emailInputField = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[4]/div/input"));
        emailInputField.sendKeys(emailForSignup);
    }

    @And("he enters {string} as password")
    public void heEntersAsPassword(String password) {
        WebElement passwordInputField = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[5]/div/input"));
        passwordInputField.sendKeys(password);
    }

    @And("he clicks on Signup button")
    public void heClicksOnSignupButton() {
        WebElement signupButton = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[7]/button"));
        signupButton.click();
    }

    @Then("ensure that the sign up is successful")
    public void ensureThatTheSignUpIsSuccessful() throws InterruptedException {
        Thread.sleep(2000);
        WebElement congratsMessage = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/div"));
        String congratsMessageText = congratsMessage.getText();
        Assert.assertEquals(congratsMessageText, "Signup successfull please login.");
    }

    @And("he enters {string} as email")
    public void heEntersAsEmail(String email) {
        WebElement emailInputField = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[4]/div/input"));
        emailInputField.sendKeys(email);
    }

    @Then("ensure that the sign up is unsuccessful due to already existing user")
    public void ensureThatTheSignUpIsUnsuccessfulDueToAlreadyExistingUser() throws InterruptedException {
        Thread.sleep(2000);
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/div[1]"));
        String errorMessageText = errorMessage.getText();
        Assert.assertEquals(errorMessageText, "Email already exist!");
    }
}