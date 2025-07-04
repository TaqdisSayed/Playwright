package com.qa.CargoesComunity.Base;

import com.microsoft.playwright.Page;
import com.qa.CargoesCommunity.factory.PlaywriteFactory;
import com.qa.CargoesCommunity.pages.HomePage;
import com.qa.CargoesCommunity.pages.LoginPage;
import com.qa.CargoesCommunity.pages.RegisterPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    PlaywriteFactory playwriteFactory;
    Page page;
    protected LoginPage loginPage;
    protected Properties prop;
    protected HomePage homePage;
    protected RegisterPage registerPage;


    @BeforeTest
    public void setup(){
        playwriteFactory=new PlaywriteFactory();
        prop = playwriteFactory.init_prop();
        page=playwriteFactory.initBrowser(prop);
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
        registerPage = new RegisterPage(page);

    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }

}

