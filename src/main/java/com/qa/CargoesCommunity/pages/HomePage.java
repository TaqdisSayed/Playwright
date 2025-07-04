package com.qa.CargoesCommunity.pages;


import com.microsoft.playwright.Page;


public class HomePage  {

    private Page page;
    //1.String Locators

    private String search = "input[placeholder='Search']";
    private String searchIcon = "button[class='btn btn-default btn-lg']";
    private String searchPageHeader = "div[id='content'] h1";
    private String myAccount = "a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']";
    private String register = "a[href='https://naveenautomationlabs.com/opencart/index.php?route=account/register']";
    private String login = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']";

    //2. Page constructor

    public HomePage(Page page) {
        this.page = page;

    }
    //3. Page action or methods

    public String getHomepageTitle(){
        String title = page.title();
        System.out.println(title);
        return title;
    }

    public String getHomePageUrl(){
        String URL =  page.url();
        System.out.println(URL);
        return URL;
    }

    public String doSearch(String productName){
        page.fill(search,productName);
        page.click(searchIcon);
        String header = page.textContent(searchPageHeader);
        System.out.println(header);
        return header;

    }

    public RegisterPage navigateToRegisterPage(){
        page.click(myAccount);
        page.click(register);
        return new RegisterPage(page);
    }

    public LoginPage navigateToLoginPage(){
        page.click(myAccount);
        page.click(login);
        return new LoginPage(page);
    }


}
