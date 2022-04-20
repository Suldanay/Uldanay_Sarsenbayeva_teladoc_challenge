package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Setter
@Getter
public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@class='btn btn-link pull-right']")
    private WebElement addButton;

    @FindBy(xpath = "//input[@name='FirstName']")
    private WebElement firstName;

    @FindBy(name = "LastName")
    private WebElement lastName;

    @FindBy(name = "UserName")
    private WebElement userName;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passWord;

    @FindBy(xpath = "//input[@value='16' ]")
    private WebElement radioButtonBBB;

    @FindBy(xpath = "//input[@value='15' ]")
    private WebElement radioButtonAAA;

    @FindBy(xpath = "//select[@name='RoleId']")
    private WebElement dropDownSelect;

    @FindBy(xpath = "//input[@name='Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='Mobilephone']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    private WebElement saveButton;

    @FindBy(xpath = "//td[.='Uldanay']")
    private   WebElement newAddedUser;

    @FindBy(xpath = "//td[.='Mark']/following-sibling::td[@class=\"smart-table-data-cell\"]/button/i[@class=\"icon icon-remove\"]")
    private WebElement editButton;

    @FindBy(xpath = "//p[.='Do you really want to delete the user?']")
    private WebElement confirmationText;

    @FindBy(xpath = "//button[.='OK']")
    private WebElement okButton;


    public void AddBUttonClick(){
        addButton.click();
    }

    public void sendAllInformation(String firstname, String lastname, String username, String password){
        this.firstName.sendKeys(firstname);
        this.lastName.sendKeys(lastname);
        this.userName.sendKeys(username);
        this.passWord.sendKeys(password);
    }

   public void selectRadioButton(){
        radioButtonAAA.click();
   }
    public void FromDropDownSelect(){
      Select select=new Select(dropDownSelect);
      select.selectByValue("2");
    }
    public void sendData(String email,String phone){
        this.email.sendKeys(email);
        this.phoneNumber.sendKeys(phone);
    }
    public void addSaveButton(){
        saveButton.click();
    }

    public void deleteUser(){
        editButton.click();
    }
    public String ValidateDelatedUser() {

        return confirmationText.getText().trim();
    }

    public void ConfirmationOkButton(){

        okButton.click();
    }
}
