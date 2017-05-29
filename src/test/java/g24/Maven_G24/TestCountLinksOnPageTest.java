package g24.Maven_G24;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCountLinksOnPageTest extends TestBase
{

	@Test
	public void countLinks()
	{
		BasePageUkrNet basePageUkrNet = new BasePageUkrNet(m_driver, m_wait);

		basePageUkrNet.openPage();

		// List<WebElement> linkCountList =
		// m_driver.findElements(By.tagName("a"));
		// System.out.println(linkCountList.size());

		System.out.println(basePageUkrNet.allLinkElements.size());

	}

}
