package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseClass;
import pages.FacebookLoginPage;
import pages.RegisterFacebookAccountPage;



public class TestClass extends BaseClass {
	FacebookLoginPage facebookloginpage;
	RegisterFacebookAccountPage rfa;
	@BeforeClass
   public  void  OpenTheBrowser() {
		facebookloginpage=new FacebookLoginPage();
		facebookloginpage.Open_The_Browser();
	}
	@Test(priority = -10)
   public void VerifyCurrentURLTitleLogo() {
		facebookloginpage=new FacebookLoginPage();
		facebookloginpage.CurrentURL();
		facebookloginpage.TitleIsPresent();
		facebookloginpage.FacebookLogo();
		logger.info("Current url , title and logo is checked");
	}
	
	@Test(priority = -9)
	public void verifyCreateaccountBtnisClick() {
		
		rfa=facebookloginpage.CreateAccountBtnIsClick();
        logger.info("Create account btn is click");
	}
	@Test(priority = -8)
	public void VerifyUserNavigateToSignInPage() {
		rfa=new RegisterFacebookAccountPage();
		rfa.UserNavigateToSignInPage();
		logger.info("signIn text is present");
	}
	
	@Test(priority = -7)
	public void verifyUserEnterCreadential() throws InterruptedException {
		rfa=new RegisterFacebookAccountPage();
		rfa.UserEnterCrediantial();
		logger.info("credential is pass");
	}
	@Test(priority = -6)
	public void VerifyUserHandleSelectBox() throws InterruptedException {
		rfa=new RegisterFacebookAccountPage();
		rfa.UserHandleSelectBox();
		rfa.GenderIsSelected();
		logger.info("Select or drop down box is handle");
	}
	@AfterClass
	public void TearDown() {
	ClosetheBrowser();
	logger.info("Browser is Closed");
	}

}
