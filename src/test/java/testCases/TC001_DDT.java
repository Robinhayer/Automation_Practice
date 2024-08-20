package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SignUpPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC001_DDT extends BaseClass
{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
    public void RegisterTest(String Fname,String Lname,String email,String pwd,String pwd1,String Gender, String day, String Month,String Year,String address,String address1, String Country, String State,String city,String Zip, String num)
    {
	logger.debug("Application Started");
	logger.info("----TC001 Started-----");
	try
	{
		HomePage hp=new HomePage(driver);
		hp.ClickOnLoginSignup();
		hp.Entername(randomString());
		hp.EnterEmail(email);
		hp.ClickOnSignUp();
		SignUpPage sp=new SignUpPage(driver);
		sp.SelectTitle(Gender);
		sp.EnterName(randomString());
		sp.EnterPwd(pwd);
		sp.SelectDay(day);
		sp.SelectMonth(Month);
		sp.SelectYear(Year);
		sp.EnterFname(Fname);
		sp.EnterLname(Lname);
		sp.EnterCompanyName(randomString());
		sp.EnterAddress1(address);
		sp.EnterAddress2(address1);
		sp.SelectCountry(Country);
		sp.EnterState(State);
		sp.EnterCity(city);
		sp.EnterZipCode(Zip);
		sp.EnterMobileNumber(num);
		sp.CLickCreateAccount();
		sp.AccountCreated();
	}
	catch(Exception e)
	{
		System.out.println("Test FAiled"+e.getMessage());
		Assert.fail();
	}
    }
}
