package webActionsHelper;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class TakeScreenshotToFile
{
///
	TakesScreenshot m_sshot_driver;
	private int count = 0;

	public TakeScreenshotToFile(WebDriver driver) throws Exception
	{
		if (driver instanceof TakesScreenshot)
		{
			m_sshot_driver = (TakesScreenshot) driver;
		} else
		{
			throw new Exception("Your driver is unable to take screenshots.");
		}
	}

	public String screenshot() throws IOException
	{
		File scrFile = m_sshot_driver.getScreenshotAs(OutputType.FILE);

		File outputFile = new File("./screenshots/webPage_screenshot_" + count + ".png");
		FileUtils.copyFile(scrFile, outputFile);
		count++;
		System.out.println(outputFile.getAbsolutePath());
		return outputFile.getAbsolutePath();

	}
}
