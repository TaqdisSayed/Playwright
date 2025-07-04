package com.qa.CargoesCommuity.Tests;

import com.qa.CargoesCommunity.constants.Appconstants;
import com.qa.CargoesComunity.Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    /*PlaywriteFactory pf;
    Properties properties;
    Page page;
    HomePage homePage;*/


    @Test
    public void HomePageTitleTest() {
        String ActualTitle = homePage.getHomepageTitle();
        Assert.assertEquals(ActualTitle, Appconstants.HOME_PAGE_TITLE);
    }

    @Test
    public void HomePageUrlTest() {
        String Actual_URL = homePage.getHomePageUrl();
        Assert.assertEquals(Actual_URL,prop.getProperty("url"));
    }

    @DataProvider
    public Object[] getProductData() {
        return new Object[][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "getProductData")
    public void SeachTest(String productName) {
        String Actual_header = homePage.doSearch(productName);
        Assert.assertEquals(Actual_header, "Search - " + productName);
    }
}

/*@AfterTest
    public void tearDown(){
    page.context().browser().close();
}

}*/
