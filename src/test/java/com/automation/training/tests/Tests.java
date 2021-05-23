package com.automation.training.tests;

import com.automation.training.pages.Home;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Tests {

    boolean afterToBeLaunched;
    private WebDriver driver;
    Home home;

    @BeforeClass
    public void createAccount(){

    }

    @BeforeMethod
    @Parameters({"browser","url"})
    public void setUp(String browser, String url){
        afterToBeLaunched = false;
        home = new Home(driver);
        driver = home.driverConnection(browser, url);
        home.visit(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if(afterToBeLaunched==true){
            home.logoutUser();
        }else{}
        driver.quit();
    }



    @DataProvider(name = "credentials")
    public Object [][] getData(){
        return new Object[][]{
                {"angelavalbuena19@gmail.com", "espnglobant.123"}
        };
    }

    @Test(dataProvider = "credentials")
    public void loginTest(String userName, String Password){
        afterToBeLaunched = true;
        home.loginUser(userName, Password);
        home.openMainMenu();
        assertEquals(home.loggedInUser(), "Log Out");
    }

    @Test(dataProvider = "credentials")
    public void logoutTest(String userName, String Password){
        afterToBeLaunched=false;
        home.loginUser(userName, Password);
        home.logoutUser();
        home.openMainMenu();
        assertEquals(home.loggedOutUser(), "Log In");
    }

    @Test(enabled = false)//(dataProvider = "credentials")
    public void cancelAccount(String userName, String Password){
        afterToBeLaunched=false;
        home.loginUser(userName, Password);
        home.deleteAccount();// disabled the real deactivation because it is pending the automation of account creation
        assertEquals(home.deletedAccount(), "AccountDeleted");
    }


}
