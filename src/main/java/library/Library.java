package library;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by andrey.aleksandrov on 27.04.2017.
 */
public class Library {
    public static String getWebElementText(WebElement element) {
        return element.getText();
    }

    public static void setText(WebElement element, String text) {
        element.sendKeys(text);
    }


    public static void clickWebElement(WebElement element) {
        element.click();
        System.out.println("Click element");
    }

    public static void setDriverSettings(WebDriver driver, int implicitlyWait, String startURL) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        driver.get(startURL);

    }

    public static void setCheckboxState(WebElement element, boolean expectedState) {

        boolean currentState = element.isSelected();

        if (currentState != expectedState)
            clickWebElement(element);

    }

    public static boolean isElementPresent(WebDriver driver, String xpath) throws NoSuchElementException, Exception {
        try {
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e) {
            throw new Exception("Unexpected exception");
        }
    }

    public static boolean isElementPresent(WebElement element) throws NullPointerException, Exception {
        try {
            element.getText();
            return true;
        } catch (NullPointerException e) {
            return false;
        } catch (Exception e) {
            throw new Exception("Unexpected exception");
        }
    }
}
