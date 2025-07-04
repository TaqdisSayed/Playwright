package com.qa.CargoesCommuity.Tests;

import com.qa.CargoesCommunity.constants.Appconstants;
import com.qa.CargoesComunity.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {



@Test(priority = 1)
    public void NavigateToRegisterPageTest(){
    registerPage = homePage.navigateToRegisterPage();
    String RegisterPageTitle = registerPage.getRegisterpageTitle();
    Assert.assertEquals(RegisterPageTitle, Appconstants.REGISTER_PAGE_TITLE);

}

@Test(priority = 2)
    public void RegisterNewUserTest(){
    registerPage.doRegister(prop.getProperty("firstname"),prop.getProperty("lastname"), prop.getProperty("email"),
            prop.getProperty("telephone"), prop.getProperty("passsword"), prop.getProperty("confirmpassword"));
    Assert.assertEquals(registerPage.getAccountCreationSuccessMessega(),Appconstants.ACCT_CREATION_SUCCESS_MESSEGE);

}

}
