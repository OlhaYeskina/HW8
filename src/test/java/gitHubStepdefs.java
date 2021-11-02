import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import steps.BaseTest;

import static org.junit.Assert.assertEquals;

public class gitHubStepdefs extends BaseTest {


    private WebDriver driver;
    private static final String GIT_HUB_LOGIN = "https://github.com";

    @Before
    public void profileSetUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dreyk\\IdeaProjects\\HW8\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(GIT_HUB_LOGIN);
    }
    @After
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }


    @Given("Github home page is opened")
    public void githubHomePageIsOpened() {
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();
    }

    @When("user enters {string} into email field")
    public void userEntersIntoEmailField(String arg0) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(arg0);
    }


    @Then("error message below email field should be displayed")
    public void errorMessageBelowEmailFieldShouldBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-err")));
        //  assertEquals();
    }


    @And("click Continue button")
    public void clickContinueButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-optimizely-event='click.signup_continue.email']"))).click();
        //  getDriver().findElement(By.cssSelector("button[data-optimizely-event='click.signup_continue.email']")).click();
    }

    @When("user enters {string} into password field")
    public void userEntersIntoPasswordField(String arg0) {

        getDriver().findElement(By.id("password")).clear();
        getDriver().findElement(By.id("password")).sendKeys(arg0);
    }

    @Then("{string} message should appears")
    public void messageShouldBeMarkedRed(String arg0) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        // //*[@id="password-err"]/p[1]
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password-err\"]/p[1]")));
        assertEquals(arg0, message.getText());
    }


    @When("user enters already existent username into username field")
    public void userEntersAlreadyExistentUsernameIntoUsernameField() {
        userEntersIntoEmailField("florolga99@gmail.com");

    }

}
