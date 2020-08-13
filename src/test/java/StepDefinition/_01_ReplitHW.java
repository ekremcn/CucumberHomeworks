package StepDefinition;

import POM._01_Replit_POM;
import Utilities.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;


public class _01_ReplitHW {

    _01_Replit_POM cucumber1 = new _01_Replit_POM();
    WebDriver driver;

    @Given("^Navigate to site$")
    public void navigate_to_site() {
        driver = Driver.getDriver();

        driver.get("http://automationpractice.com/index.php ");
     //     driver.manage().window().maximize();
    }

    @When("^Enter the username and password and click on login button$")
    public void enter_the_username_and_password_and_click_on_login_button() {

        cucumber1.findElementAndClickFunction("loginButton");
        cucumber1.findElementAndSendKeysFunction("emailInput", "ekrem20092013@gmail.com");
        cucumber1.findElementAndSendKeysFunction("password", "3229e");
        cucumber1.findElementAndClickFunction("signIn");
    }

    @And("^Navigate to MyPersonalInformation page$")
    public void navigateToMyPersonalInformationPage() {
        cucumber1.findElementAndClickFunction("myPersonalInformation");
    }

    @When("^User edit the firstName as \"([^\"]*)\" and password \"([^\"]*)\" as \"([^\"]*)\"$")
    public void userEditTheFirstNameAsAndPasswordAs(String name, String currentPass, String newPass)  {
        cucumber1.findElementAndSendKeysFunction("firstName", name);
        cucumber1.findElementAndSendKeysFunction("currentPassword", currentPass);
        cucumber1.findElementAndSendKeysFunction("newPassword", newPass);
        cucumber1.findElementAndSendKeysFunction("confirmation", newPass);
        cucumber1.findElementAndClickFunction("saveButton");
    }

    @Then("^User should verify the updated firstname as \"([^\"]*)\"$")
    public void userShouldVerifyTheUpdatedFirstnameAs(String nameEditted)  {
        cucumber1.findElementAndVerifyElementContainText("updatedFirstName", nameEditted);
        cucumber1.findElementAndClickFunction("updatedFirstName");
    }

}

/*
NOTE: For each cucumber homework you should create a feature file step definition
 and for the different classes there should be page classes as well.

Navigate to:  http://automationpractice.com/index.php
Click on sign in button
Enter the Email Address and Password (Create your own account from left side)
Click on sign in button
Click on the " My personal information "

Change the first name

Enter the currentPassword
Enter the new password
Enter the Confirmation

NOTE: Do not change the password if you change it then other test cases will fail

Click on the save button

Verify the name on the top right is updated as your first name

Click on the " My personal information "

Change the first name as the previous name in the first time

Enter the currentPassword
Enter the new password
Enter the Confirmation

Click on the save button

Verify the name on the top right is updated as your first name
 */