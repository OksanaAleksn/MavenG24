package g24.Maven_G24;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUkrNetGolovne extends BasePageUkrNet
{
	private String m_url = "https://www.ukr.net/news/main.html";

	public PageUkrNetGolovne(WebDriver driver, WebDriverWait wait)
	{
		super(driver, wait);
	}

	@FindAll(@FindBy(xpath = "//section[@class ='im']"))
	public List<WebElement> elementForNewsList;

	@Override
	public String getUrl()
	{
		return m_url;
	}
}
