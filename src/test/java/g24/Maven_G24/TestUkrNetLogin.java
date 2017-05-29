package g24.Maven_G24;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestUkrNetLogin extends TestBase
{

	@Test
	public void UkrNetLoginIncorrectrData() throws InterruptedException
	{
		BasePageUkrNet basePageUkrNet = new BasePageUkrNet(m_driver, m_wait);
		basePageUkrNet.openPage();

		String incorrectLogin = "abcbcaqwerty";
		String myPassword = "qwerty123";
		WebElement errLogin = m_driver.findElement(By.xpath("//*[@id='login-block']/div/div[2]"));
		//String resultTitle = "UKR.NET: Всі новини України,";
		
		m_webActionsHelper.enterTextToField(basePageUkrNet.loginField, incorrectLogin);
		m_webActionsHelper.enterTextToField(basePageUkrNet.passwordField, myPassword);
		m_webActionsHelper.click(basePageUkrNet.loginSubmitButton);
	
		Thread.sleep(3000);

		m_wait.until(ExpectedConditions.visibilityOf(errLogin));

		Assert.assertTrue(" Login Failed", false);

		//Assert.assertTrue(m_driver.getTitle().contains(resultTitle));
		
		
		
		Actions actions = new Actions(m_driver);
		
		// the same action twice:
		actions.sendKeys(basePageUkrNet.loginField, incorrectLogin).sendKeys(basePageUkrNet.loginField, incorrectLogin).perform();
		
		
		Actions actionForRepeat = new Actions(m_driver);
		actionForRepeat.sendKeys(basePageUkrNet.loginField, incorrectLogin).build();
		actionForRepeat.perform();
		actionForRepeat.perform();
		actionForRepeat.perform();
	
	}

}