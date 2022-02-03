package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Base.BaseClass;

public class RegisterFacebookAccountPage extends BaseClass {
	
	@FindBy(xpath = "//*[@name='firstname']")
	private WebElement FirstName;
	
	@FindBy(xpath = "//*[@name='lastname']")
	private WebElement LastName;
	
	@FindBy(xpath = "//input[@name='reg_email__']")
	private WebElement Email;
			
	@FindBy(xpath = "//div[text()='Sign Up']")
	private WebElement SignInText;
	
	@FindBy(xpath = "//input[contains(@name,'reg_passwd__')]")
	private WebElement Password;
	
	@FindBy(xpath = "//select[@id='day']")
	private WebElement day;
	
	@FindBy(xpath = "//select[@id='month']")
	private WebElement month;
	
	@FindBy(xpath = "//select[@id='year']")
	private WebElement year;
			
	@FindBy(xpath = "//label[text()='Female']")
	private WebElement FemaleBtn;
	
	@FindBy(xpath = "//label[text()='Male']")
	private WebElement maleBtn;
	
	@FindBy(xpath = "//label[text()='Custom']")
	private WebElement CustomBtn;
	
	@FindBy(xpath="//button[@name='websubmit']")
	private WebElement SignUPBTN;
	
	
	public WebElement getSignUPBTN() {
		return SignUPBTN;
	}
	
	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getSignInText() {
		return SignInText;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getDay() {
		return day;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getFemaleBtn() {
		return FemaleBtn;
	}

	public WebElement getMaleBtn() {
		return maleBtn;
	}

	public WebElement getCustomBtn() {
		return CustomBtn;
	}

	public RegisterFacebookAccountPage() {
	    PageFactory.initElements(driver, this);
	}

	public void UserNavigateToSignInPage() {
		boolean text = SignInText.isDisplayed();
		Assert.assertTrue(text);
	}
	public void UserEnterCrediantial() throws InterruptedException {
	   FirstName.sendKeys("vijay");
	   Thread.sleep(5000);
	   LastName.sendKeys("chavhan");
	   Thread.sleep(5000);
	   Email.sendKeys("9699815049");
	   Password.sendKeys("Vijay@13101995");
	   Thread.sleep(5000);
	}
	
	public void UserHandleSelectBox() throws InterruptedException {
		 new Select(day).selectByVisibleText("12");
		 Thread.sleep(2000);
	     
		 new Select(month).selectByVisibleText("Oct");
	    Thread.sleep(2000);

	     new Select(year).selectByVisibleText("1995");
	     Thread.sleep(2000);
		
		
}
	public void GenderIsSelected() {
		if(maleBtn.getText().contentEquals("Male")) {
			maleBtn.click();
			
		}
		else if(FemaleBtn.getText().contentEquals("Female")) {
			FemaleBtn.click();
			
		}
		else {
			CustomBtn.click();
		}
	}
	
	public void ClickSignUpBtn() {
		SignUPBTN.click();
	}
}
