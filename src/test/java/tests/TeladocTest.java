package tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.ConfigReader;

public class TeladocTest extends TestBase{
        @Test
        public void addUserAndValidate()  {

            mainPage.AddBUttonClick();
            mainPage.sendAllInformation(ConfigReader.readProperty("firstnameforTeladoc"),ConfigReader.readProperty("lastnameforTeladoc"),
                    ConfigReader.readProperty("usernameforTeladoc"),ConfigReader.readProperty("passwordforTeladoc"));
            mainPage.selectRadioButton();
            mainPage.FromDropDownSelect();
            mainPage.sendData(ConfigReader.readProperty("emailforTeladoc"),ConfigReader.readProperty("phoneforTeladoc"));
            mainPage.addSaveButton();
        }
        @Test
        public void deleteUserAndValidate()  {
            mainPage.deleteUser();
            String actual = mainPage.ValidateDelatedUser();
            String expected = "Do you really want to delete the user?";
            Assert.assertEquals(expected,actual);
            mainPage.ConfirmationOkButton();
        }
    }


