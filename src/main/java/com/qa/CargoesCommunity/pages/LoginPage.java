package com.qa.CargoesCommunity.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    //1.String Locators
    private String EmaiId_OR_Username = "//input[@id='input-email']";
    private String password = "//input[@id='input-password']";
    private String login = "//input[@value='Login']";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    public LoginPage(Page page){
        this.page=page;
    }

    public String getLoginpageTitle(){
        String ActualLoginPageTitle = page.title();
        System.out.println("The Actual LoginPageTitle is "+ ActualLoginPageTitle);
        return ActualLoginPageTitle;
    }

    public String getLoginpageURL(){
        String ActualLoginPageURL = page.url();
        System.out.println("The Actual URL is "+ ActualLoginPageURL);
        return ActualLoginPageURL;
    }

    public boolean Login(String emaiIdORUsername, String pwd){
        page.fill(EmaiId_OR_Username,emaiIdORUsername);
        page.fill(password,pwd);
        page.click(login);
        if(page.isVisible(logoutLink)){
            System.out.println("You have successfully logged in");
            return true;
        }
        return false;

    }




}
