package g24.Maven_G24;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webActionsHelper.WebActionsHelper;

public class BasePageUkrNet extends BasePage
{

	private String m_url = "https://www.ukr.net";
	
	
	@FindBy(xpath = "/html/body/div[2]/main/div[1]/header/section[1]/a/img")
	public WebElement logoUkrNetLink;
	
	@FindBy(xpath = "//*[@id='user-login-form']/input[2]")
	public WebElement loginField;

	@FindBy(xpath = "//*[@id='user-login-form']/input[3]")
	public WebElement passwordField;

	@FindBy(xpath = "//*[@id='user-login-form']/div[2]/div/button")
	public WebElement loginSubmitButton;
	
	@FindBy(xpath = "//*[@id='login-block']/div/ul/li[1]/a")
	public WebElement emailLink;

	@FindBy(xpath = "//*[@id='content']/aside/button")
	public WebElement NewEmailFormButton;

	@FindBy(xpath = "//*[@id='screens']/div/div[2]/section[1]/div[1]/div[4]/input[2]")
	public WebElement adresseeTextField;

	@FindBy(xpath = "//*[@id='screens']/div/div[2]/section[1]/div[4]/div[2]/input")
	public WebElement subjectTextField;

	@FindBy(xpath = "//*[@id='screens']/div/div[2]/section[3]/div/div[3]")
	public WebElement emailBodyText;

	@FindBy(xpath = "//*[@id='screens']/div/div[1]/div/button")
	public WebElement sendEmailButton;

	@FindBy(xpath = "//*[@id='screens']/div/div[2]/section[2]/div[2]/label/button")
	public WebElement attachFileToEmailButton;
	
	
	@FindAll(@FindBy(tagName = "a"))
	public List<WebElement> allLinkElements;
	
	
	
	public BasePageUkrNet(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
	}

	@Override
	public String getUrl()
	{
		return m_url;
	}
	
	
	
//	public void waitForPageLoaded()
//	{
//		m_wait.until(ExpectedConditions.visibilityOf(fieldEmail));
//	}
//
//	public void inputEmailToTextField(String email)
//	{
//		m_webActionsHelper.enterTextToField(fieldEmail, email);
//	}
//
//	public void clickLoginButton()
//	{
//		m_webActionsHelper.click(loginSubmitButton);
//	}

	
}

