package g24.Maven_G24;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import webActionsHelper.WebActionsHelper;

public abstract class BasePage
{
	protected WebDriver m_driver;
	protected WebDriverWait m_wait;
	protected WebActionsHelper m_webActionsHelper;

	BasePage(WebDriver driver, WebDriverWait wait)
	{
		m_driver = driver;
		m_wait = wait;
		m_webActionsHelper = new WebActionsHelper(m_driver, m_wait);
	}

	abstract public String getUrl();

	protected void openPage(String url)
	{
		m_driver.get(url);
	}

	public void openPage()
	{
		openPage(getUrl());
		PageFactory.initElements(m_driver, this);
	}
	
	
}
