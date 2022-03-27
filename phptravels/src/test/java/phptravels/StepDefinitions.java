package phptravels;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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

    @And("error message is shown")
    public void errorMessageIsShown() throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Please fill out this field.");
    }
}