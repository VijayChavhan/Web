package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.BaseClass;

public class FacebookLoginPage extends BaseClass {
	@FindBy(xpath = "//a[text()='Create New Account']")
	private WebElement create_account_btn;
	
	
	public WebElement getCreate_account_btn() {
		return create_account_btn;
	}
	
	@FindBy(xpath = "//img[@alt='Facebook']")
	private WebElement Logo;
	
	public WebElement getLogo() {
		return Logo;
	}

	
	public FacebookLoginPage() {
	    PageFactory.initElements(driver, this);
	}
	
	public void CurrentURL() {
		String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.facebook.com/");
		
	}
    
	public void TitleIsPresent() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
		
	}
	
	public void FacebookLogo() {
		boolean logo = Logo.isDisplayed();
		Assert.assertTrue(logo);
	}
	 
	public RegisterFacebookAccountPage CreateAccountBtnIsClick() {
		create_account_btn.click();
		return new RegisterFacebookAccountPage();
	}

}
