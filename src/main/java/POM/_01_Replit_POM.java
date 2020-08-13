package POM;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class _01_Replit_POM extends _01_ParentClass {

    public _01_Replit_POM() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".login")
    private WebElement loginButton;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(css = "span>i[class='icon-lock left']")
    private WebElement signIn;

    @FindBy(css = "a[title='Information']>span")
    private WebElement myPersonalInformation;

    @FindBy(id = "firstname")
    public WebElement firstName;

    @FindBy(id = "old_passwd")
    public WebElement currentPassword;

    @FindBy(id = "passwd")
    public WebElement newPassword;

    @FindBy(id = "confirmation")
    public WebElement confirmation;

    @FindBy(xpath = "(//div[@class='form-group']//button)[1]")
    public WebElement saveButton;

    @FindBy(css = "a[class='account']>span")
    public WebElement updatedFirstName;


    WebElement myElement;

    public void findElementAndClickFunction(String ElementName) {

        switch (ElementName) {
            case "loginButton":
                myElement = loginButton;
                break;
            case "signIn":
                myElement = signIn;
                break;
            case "myPersonalInformation":
                myElement = myPersonalInformation;
                break;
            case "saveButton":
                myElement = saveButton;
                break;
            case "updatedFirstName":
                myElement = updatedFirstName;
                break;

        }

        clickFunction(myElement);
    }

    public void findElementAndSendKeysFunction(String ElementName, String value) {

        switch (ElementName) {

            case "emailInput":
                myElement = emailInput;
                break;
            case "password":
                myElement = password;
                break;
            case "firstName":
                myElement = firstName;
                break;
            case "currentPassword":
                myElement = currentPassword;
                break;
            case "newPassword":
                myElement = newPassword;
                break;
            case "confirmation":
                myElement = confirmation;
                break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findElementAndVerifyElementContainText(String elementName, String WhichText) {

        switch (elementName) {
            case "updatedFirstName":
                myElement = updatedFirstName;
                break;
        }
        ElementContainsText(myElement, WhichText);

    }
}