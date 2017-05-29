package g24.Maven_G24;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ukrnet.ukrnet.BasePage;
import webActionsHelper.WebActionsHelper;

public class TestBase
{
	protected WebDriver m_driver;
	protected WebDriverWait m_wait;
	protected BasePage m_testBasePage;
	protected WebActionsHelper m_webActionsHelper;


	@Before
	public void initialize()
	{
		m_driver = new ChromeDriver();
		
		m_driver.manage().window().maximize();
		m_driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		m_wait = new WebDriverWait(m_driver, 15);
		
		m_webActionsHelper = new WebActionsHelper(m_driver, m_wait);
		
	}

	@After
	public void afterTestActions()
	{
		if (m_driver != null)
		{
			m_driver.quit();
		}

	}
}
