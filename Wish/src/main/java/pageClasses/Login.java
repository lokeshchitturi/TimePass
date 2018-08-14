package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import utils.WebDriverUtils;

public class Login extends WebDriverUtils{
	
	static String login_Icon="xpath__//i[@alt='login']";
	static String username_textbox="id__userName";
	static String passowrd_textbox="id__password";
	static String continue_button="id__continueLoginButton";
	static String user_image="xpath__//div[@id='userImage']//img";
	static String logout_link="linkText__LOGOUT";
	
	public static void loginIntoApplication() throws Exception
	{
		try {
			navigateToURL();
			clickLoginIcon();
			enterCredntials();
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
			clickContinue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		
	}
	
	public static void logoutFromApplication() throws Exception
	{
		try {
			getWebElement(user_image).click();
			getWebElement(logout_link).click();
			waitUntilPageLoads(30);
			getWebElement(login_Icon);
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
			test.log(Status.PASS, "User logged out of application succesfully");
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "User unable to logout of application");
			throw e;
		}
	}
	
	public static void navigateToURL() throws Exception
	{
		try {
			driver.get(prop.getProperty("url"));
			test.log(Status.PASS, "Navigated to URL :"+prop.getProperty("url"));
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable tp navigate to URL :"+prop.getProperty("url"));
			throw e;
		}
	}
	public static void clickLoginIcon() throws Exception
	{
		try {
			waitUntilPageLoads(30);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			WebElement loginIcon=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@alt='login']")));
			loginIcon.click();
			test.log(Status.PASS, "Clicked on Login Icon");
			//enterCredntials();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			test.log(Status.FAIL, "Unable to click on Login Icon");
			throw e;
		}
	}
	
	public static void enterCredntials() throws Exception
	{
		try {
			getWebElement(username_textbox).sendKeys(prop.getProperty("username"));
			getWebElement(passowrd_textbox).sendKeys(prop.getProperty("password"));
			test.log(Status.PASS, "Entered username and password");
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to enter either username/password");
			throw e;
		}	
	}
	
	public static void clickContinue() throws Exception
	{
		try {
			getWebElement(continue_button).click();
			test.log(Status.PASS, "Clicked on continue button");
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click on continue button");
			throw e;
		}
	}
	
	public static void validateLogin() throws Exception
	{
		try {
			if(getWebElements("linkText__My Projects").size()==1)
			{
				System.out.println("Login sucessful");
				test.log(Status.PASS, "User logged into application succesfully");
				/*MyProjects.clickMyProjectLink();
				MyProjects.createNewProject("projetTests","12345","Educational","Sample text");*/
			}
			else
				throw new Exception("Login unsucessful");
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "User unable to login into application");
			throw e;
		}
	}
	
	
	
}
