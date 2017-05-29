package webActionsHelper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//https://www.ukr.net
import org.openqa.selenium.JavascriptExecutor;
/**
 * @author uarc
 *
 */
public class WebActionsHelper
{
	protected WebDriver m_driver;
	protected WebDriverWait m_waitDriver;

	public WebActionsHelper(WebDriver driver, WebDriverWait waitDriver)
	{
		m_driver = driver;
		m_waitDriver = waitDriver;
	}

	// public static void setDriverSettings(WebDriver driver, int
	// implicitlyWait,
	// String startUrl) {
	//
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(implicitlyWait,
	// TimeUnit.SECONDS);
	// driver.get(startUrl);
	// }

	
	public void jsExecute(String jscriptIn) throws Exception{
		
		JavascriptExecutor m_js_driver;
		
		if (m_driver instanceof JavascriptExecutor )
		{
			m_js_driver = (JavascriptExecutor) m_driver;
		} else
		{
			throw new Exception("Your driver is unable to do execute javascript");
		}
		m_js_driver.executeScript(jscriptIn);
		
	}
	
	
	//  
	
	public void clipboardActionOnActiveWindow(String pathToFileForEmail) throws AWTException {
		
	Robot m_robot = new Robot();
	
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	StringSelection stringSelection = new StringSelection(pathToFileForEmail);
	clipboard.setContents(stringSelection, null);// ClipboardOwner - wtf?

	m_robot.keyPress(KeyEvent.VK_CONTROL);
	m_robot.keyPress(KeyEvent.VK_V);
	m_robot.keyRelease(KeyEvent.VK_V);
	m_robot.keyRelease(KeyEvent.VK_CONTROL);

	m_robot.keyPress(KeyEvent.VK_ENTER);
	m_robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void click(WebElement button)
	{
		m_waitDriver.until(ExpectedConditions.elementToBeClickable(button));
		button.click();

	}

	
	public void enterTextToField(WebElement inputText, String text)
	{
		m_waitDriver.until(ExpectedConditions.visibilityOf(inputText));
		inputText.sendKeys(text);
	}

	
	public void switchToNewWindow(WebDriver driver, WebElement causeOfNewWindow){
		Set<String> oldHandles = driver.getWindowHandles(); //get handles before opening new window
		
		// click element to open new window
		causeOfNewWindow.click();
		
		//get all handles after new window
		Set<String> newHandles = driver.getWindowHandles();
		//String currentPage;
		for (String nHandle : newHandles)
		{
			if(!oldHandles.contains(nHandle)){
				//currentPage = nHandle;
				driver.switchTo().window(nHandle);
			}
		}
		
		
	}
	
	
	public void setCheckboxState(WebElement element, boolean expectedState)
	{

		boolean currentState = element.isSelected();
		if (currentState != expectedState)
		{
			click(element);
		}
	}

	public static boolean isElementPresent(WebDriver driver, String xpath) throws Exception
	{

		try
		{
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (NoSuchElementException e)
		{
			return false;
		}
	}

	public static boolean isElementPresent(WebElement element) throws Exception
	{
		try
		{
			element.getText();
			return true;

		} catch (NullPointerException e)
		{
			return false;
		} 
	}

}