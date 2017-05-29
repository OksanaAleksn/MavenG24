package g24.Maven_G24;

import java.util.ArrayList;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webActionsHelper.TakeScreenshotToFile;
import webActionsHelper.WebActionsHelper;

public class EmailSendingUkrNet
{

	WebDriver m_driver;
	private WebDriverWait m_wait;
	WebActionsHelper m_webActionsHelper;

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

	public void initialize()
	{
		m_driver = new ChromeDriver();
		m_wait = new WebDriverWait(m_driver, 25);
		m_webActionsHelper = new WebActionsHelper(m_driver, m_wait);
		PageFactory.initElements(m_driver, this);

	}

	public void sendEmail() throws Exception
	{
		m_driver.get("https://www.ukr.net/");

		String myLogin = "codepark@ukr.net";
		String myPassword = "qwerty123";

		String addresseeEmail = "terraco_kiev@ukr.net";
		// String addresseeEmail = "axksyu@gmail.com";

		String emailMessage = "Sending message - test";
		String emailBodyMessage = "Hello, Andrey!";

		// m_wait.until(ExpectedConditions.visibilityOf(loginField));
		System.out.println(m_driver.getTitle());// UKR.NET: Всі новини України,
												// останні новини дня в Україні
												// та Світі
		
		String windowAtStart = m_driver.getWindowHandle();

		m_webActionsHelper.enterTextToField(loginField, myLogin);

		// myLogiWebElement loginField =
		// m_driver.findElement(By.xpath("//*[@id='user-login-form']/input[2]"));
		// loginField.sendKeys(myLogin);

		m_webActionsHelper.enterTextToField(passwordField, myPassword);
		// WebElement passwordField =
		// m_driver.findElement(By.xpath("//*[@id='user-login-form']/input[3]"));
		// passwordField.sendKeys(myPassword);

		m_webActionsHelper.click(loginSubmitButton);
		// WebElement loginSubmitButton =
		// m_driver.findElement(By.xpath("//*[@id='user-login-form']/div[2]/div/button"));
		// loginSubmitButton.click();
		Thread.sleep(1000);

		m_webActionsHelper.click(emailLink);
		// WebElement emailLink =
		// m_driver.findElement(By.xpath("//*[@id='login-block']/div/ul/li[1]/a"));
		// emailLink.click();
		Thread.sleep(4000);

		
		ArrayList<String> Windows = new ArrayList<String>(m_driver.getWindowHandles());
		Windows.remove(windowAtStart);
		m_driver.switchTo().window(Windows.get(0));

		// System.out.println(m_driver.getTitle());// Вхідні • codepark@ukr.net
		// Thread.sleep(1000);
		

		m_webActionsHelper.click(NewEmailFormButton);
		// WebElement NewEmailFormButton =
		// m_driver.findElement(By.xpath("//*[@id='content']/aside/button"));
		// NewEmailFormButton.click();
		// Thread.sleep(1000);

		m_webActionsHelper.enterTextToField(adresseeTextField, addresseeEmail);
		// WebElement adresseeTextField = m_driver
		// .findElement(By.xpath("//*[@id='screens']/div/div[2]/section[1]/div[1]/div[4]/input[2]"));
		// adresseeTextField.sendKeys("axksyu@gmail.com");
		// Thread.sleep(1000);

		m_webActionsHelper.enterTextToField(subjectTextField, emailMessage);
		// WebElement subjectTextField = m_driver
		// .findElement(By.xpath("//*[@id='screens']/div/div[2]/section[1]/div[4]/div[2]/input"));
		// subjectTextField.sendKeys("Sending message - test");
		// Thread.sleep(1000);

		m_webActionsHelper.enterTextToField(emailBodyText, emailBodyMessage);
		// WebElement emailBodyText = m_driver
		// .findElement(By.xpath("//*[@id='screens']/div/div[2]/section[3]/div/div[3]"));
		// emailBodyText.sendKeys("Hello, Andrey!");
		Thread.sleep(1000);

		String pathToSshotForEmail = "";
		TakeScreenshotToFile sShot = new TakeScreenshotToFile(m_driver);
		pathToSshotForEmail = sShot.screenshot();

		m_webActionsHelper.click(attachFileToEmailButton);
		Thread.sleep(1000);

		m_webActionsHelper.clipboardActionOnActiveWindow(pathToSshotForEmail);

		Thread.sleep(2000);
		m_webActionsHelper.click(sendEmailButton);

		// m_driver.switchTo().window(windowAtStart);
		// System.out.println( m_driver.getWindowHandle());
		// Thread.sleep(8000);
	}

	public void driverQuit()
	{
		if (m_driver != null)
		{
			m_driver.quit();
			// System.out.println("quit driver");
		}
	}

}
