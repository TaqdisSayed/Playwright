package com.qa.CargoesCommunity.pages;

import com.microsoft.playwright.Page;

public class RegisterPage {

   protected Page page;

    //1.locators
    private String registerPageHeader = "div[id='content'] h1";
    private String firstName = "#input-firstname";
    private String lastName = "#input-lastname";
    private String email = "#input-email";
    private String telephone = "#input-telephone";
    private String password = "#input-password";
    private String confirmPassword = "#input-confirm";
    private String subscribe = "input[value='0']";
    private String agree = "//input[@name='agree']";
    private String Continue = "//input[@value='Continue']";
    private String AccountCreationSuccessMessege = "//h1[normalize-space()='Your Account Has Been Created!']";


    //2.constructor
    public  RegisterPage(Page page){
        this.page=page;
    }

    //3.Page actions or methods

    public String  getRegisterpageTitle(){
        String RegisterPageTitle = page.title();
        System.out.println("On"+ RegisterPageTitle+ "Page");
        return RegisterPageTitle;

    }
     public String getAccountCreationSuccessMessega(){
        String SuccessMessege = page.textContent(AccountCreationSuccessMessege);
        System.out.println(SuccessMessege);
        return SuccessMessege;
     }

    public void doRegister(String firstname,String lastname,String e_mail,String Telephone, String Password, String ConfirmPassword){
        page.fill(firstName,firstname);
        page.fill(lastName,lastname);
        page.fill(email,e_mail);
        page.fill(telephone,Telephone);
        page.fill(password,Password);
        page.fill(confirmPassword,ConfirmPassword);
        page.click(subscribe);
        page.click(agree);
        page.click(Continue);
    }





}
