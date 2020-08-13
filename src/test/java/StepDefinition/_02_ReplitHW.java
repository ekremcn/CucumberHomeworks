package StepDefinition;

import POM._02_Replit_POM;
import Utilities.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class _02_ReplitHW {

    public WebDriver driver = Driver.getDriver();
    _02_Replit_POM cucumber2 = new _02_Replit_POM();
    String modelName;


    @And("^Navigate to Dresses page$")
    public void navigateToDressesPage() {

        cucumber2.findElementAndClickFunction("DressesButton");

    }

    @Then("^Choose a random item and add it to the cart$")
    public void chooseARandomItemAndAddItToTheCart() {

        cucumber2.randomChooseAndClick();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        modelName =driver.findElement(By.cssSelector(".editable")).getText();

        cucumber2.findElementAndClickFunction("addToCart");
        cucumber2.findElementAndClickFunction("proceedButton");
    }

    @And("^Verify the total price of the product$")
    public void verifyTheTotalPriceOfTheProduct() {
        cucumber2.isTotalSame();
    }

    @And("^Proceed to the checkout page$")
    public void proceedToTheCheckoutPage() {
        cucumber2.findElementAndClickFunction("proceedButton2");
        cucumber2.findElementAndClickFunction("proceedButton3");
        cucumber2.findElementAndClickFunction("agreeButton");
        cucumber2.findElementAndClickFunction("proceedButton4");
    }

    @When("^I do payment and confirm it$")
    public void iDoPaymentAdnConfirmIt() {
        cucumber2.findElementAndClickFunction("PayBankWire");
        cucumber2.findElementAndClickFunction("confirmOrder");
    }

    @Then("^Order confirmation message should be appeared$")
    public void orderConfirmationMessageShouldBeAppeared() {
        cucumber2.findElementAndVerifyElementContainText("orderConfirm", "Your order on My Store is complete");
    }

    @Given("^Navigate to the My Order page$")
    public void navigateToTheMyOrderPage() {

        cucumber2.findElementAndClickFunction("MyOrders");
    }

    @Then("^The last order name in the table should be the same as the name of the ordered item$")
    public void theLastOrderNameInTheTableShouldBeTheSameAsTheNameOfTheOrderedItem() {
        cucumber2.findElementAndClickFunction("firstOrder");
        cucumber2.findElementAndClickFunction("details");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1500);");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement modelInOrderHistory=driver.findElement((By.xpath("(//table[@class='table table-bordered']/tbody/tr/td)[1]")));
        String element = modelInOrderHistory.getText();
        System.out.println(element);
        System.out.println(modelName);
        Assert.assertEquals(modelName,element);

    }


}
/*
NOTE: For each cucumber homework you should create a feature file step definition
and for the different classes there should be page classes as well.

Navigate to:  http://automationpractice.com/index.php
Click on sign in button
Enter the Email Address and Password (Create your own account from left side)
Click on sign in button

Click on the dresses

Click on the any item from the page

Click on the add to cart

Click on the proceed to checkout button

Verify Total products + Total shipping = Total

Click on the proceed to checkout button

If you dont have the address yet you need to create one

If you have it click Click on the proceed to checkout button

Click on the "I agree...." checkbox

Click on the proceed to checkout button

Click on the Pay by bank wire

Click on the I confirm my order button

Verify Order confirmation text  is displayed
 */