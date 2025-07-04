package com.qa.CargoesCommuity.Tests;


import com.qa.CargoesCommunity.constants.Appconstants;
import com.qa.CargoesComunity.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

@Test(priority = 1)
    public void navigateToLoginPageTest(){
    loginPage=homePage.navigateToLoginPage();
    Assert.assertEquals(loginPage.getLoginpageTitle(), Appconstants.LOGIN_PAGE_TITLE);
}

@Test(priority = 2)
    public void doLoginTest(){
    Assert.assertTrue(loginPage.Login(prop.getProperty("email"), prop.getProperty("passsword") ));

}



}
