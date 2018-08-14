package pageClasses;

import java.util.List;

import org.apache.log4j.net.SyslogAppender;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import utils.WebDriverUtils;

public class MyProjects extends WebDriverUtils{
	
	static String myproject_link="linkText__My Projects";
	static String downarrow_icon="xpath__//span[@class='sleekIcon-rightarrow']";
	static String addnewproject_dropdown="xpath__//a[text()='Add New Project']";
	static String projecttitle_textbox="xpath__//input[@placeholder='Project Title']";
	static String projectnumber_textbox="xpath__//input[@placeholder='Project Number']";
	static String projecttype_textbox="xpath__//input[@placeholder='Project Type']";
	static String description_textarea="xpath__//textarea";
	static String save_button="xpath__//*[@type='submit']";
	static String plus_icon="xpath__//i[@class='icons8-plus newCustomIcon']";
	static String projectname_label="xpath__//h1[@itemprop='name']";
	static String close_icon="xpath__//span[@class='icons8-delete fontSizeDelete  fa-3x deleteIcon pull-right link']";

	
	static String projecttype_list="xpath__//div[@class='extra-padding-right ellipsis']";
	static String downarrow_list="xpath__//a[@class='textEllipsis']";
	static String dashboardnavigation_list="xpath__//span[@class='link  fontSize16']";
	static String topnavigation_list="xpath__//a[@class='dropdown-toggle link landingLinks']/span";
	
	///////////////
	static String membername_textbox="xpath__//input[@placeholder='Select a Member']";
	static String role_textbox="xpath__//input[@placeholder='Select Role']";
	static String datacollabration_button="xpath__//button[@data-toggle='dropdown']";
	static String datacollabration_list="xpath__//ul[@role='menu']//li";
	
	////////////////
	
	
	public static void clickTab(String[] args) throws Exception
	{
		String tabName="";
		try {
			
			List<WebElement> list=getWebElements(topnavigation_list);
			Thread.sleep(3000);
			for (String string : args) {
				
				boolean flag=false;
				tabName=string;
				for (WebElement webElement : list) {
					if(webElement.getText().equalsIgnoreCase(string))
					{
						flag=true;
						webElement.click();
						test.log(Status.PASS, "Clicked on tab :"+tabName);
						test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
						break;
					}
				}
				if(!flag)
					throw new Exception("Unable to click tab :"+tabName);
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click tab :"+tabName);
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
			throw e;
		}
	}
	
	public static void validateTopNavigationLabels(String[] args) throws Exception
	{
		try {
			waitUntilPageLoads(30);
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='dropdown-toggle link landingLinks']/span")));
			List<WebElement>tabElements=getWebElements(topnavigation_list);
				Thread.sleep(3000);
				int i=0;
				for (WebElement webElement : tabElements) {
					
					if(!(webElement.getText().equalsIgnoreCase(args[i])))
					{
						test.log(Status.FAIL, "Expected navigation label is :"+args[i]+" but actual label is :"+webElement.getText());
						throw new Exception("Labels are not in correct order");
					}
					i=i+1;
				}

			test.log(Status.PASS, "All labels are present and is in expected order");
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
		} catch (Exception e) {
			// TODO: handle exception
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
			throw e;
		}
	}
	
	
	public static void clickCloseIcon(String[] args) throws Exception
	{
		try {
			getWebElement(close_icon).click();
			test.log(Status.PASS, "Clikced on close icon");
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click on close icon");
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
			throw e;
		}
	}
	
	public static void validateCreateProject(String[] args) throws Exception
	{
		WebElement ele=getWebElement("xpath__//*[@id='nameInCompleteError']");
		try {
			if(ele.isDisplayed())
			{
				throw new Exception("Error message displayed :"+ele.getText());
			}
			else{
				if(getWebElement(projectname_label).getText().equals(args[0]))
				{
					test.log(Status.PASS, "New Project with name :"+args[0]+" is created succesfully");
					test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
				}
				else
				{
					throw new Exception("Unable to create project with project name :"+args[0]);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Error Message:"+ele.getText());	
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
			throw e;
		}
	}
	
	public static void selectPlusIcon() throws Exception
	{
		try {
			getWebElement(plus_icon).click();
			test.log(Status.PASS, "Clicked on plus icon");
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click on plus icon");
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
			throw e;
		}
	}
	
	
	public static void selectDashboardItem(String dashboardName) throws Exception
	{
		try {
			List<WebElement> list=getWebElements(dashboardnavigation_list);
			for (WebElement webElement : list) {
				if(webElement.getText().equalsIgnoreCase(dashboardName))
				{
					webElement.click();
					test.log(Status.PASS, "Clicked on dashboard :"+dashboardName);
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click on dashboard :"+dashboardName );
			throw e;
		}
	}
	
	public static void selectProjectDownArrow(String projectName) throws Exception
	{
		try {
			List<WebElement> list=getWebElements(downarrow_list);
			
			for (WebElement webElement : list) {
				if(webElement.getText().equalsIgnoreCase(projectName))
				{
					Actions action=new Actions(driver);
					action.moveToElement(getWebElement(downarrow_icon)).click(webElement).build().perform();
					test.log(Status.PASS, "Selected project as : "+projectName);
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to select project :"+projectName);
			throw e;
		}
	}
	
	public static void createNewProject(String[] args) throws Exception
	{
		try {
			String projectname=args[0];
			String projectnumber=args[1];
			String projecttype=args[2];
			String description=args[3];
			
			
			Actions action=new Actions(driver);
			
			action.moveToElement(getWebElement(downarrow_icon)).click(getWebElement(addnewproject_dropdown)).build().perform();
			test.log(Status.PASS, "Cliked on Add New Project link");
			enterProjectName(projectname);
			enterProjectNumber(projectnumber);
			selectProjectType(projecttype);
			enterDescription(description);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public static void enterDescription(String description) throws Exception
	{
		try 
		{
			getWebElement(description_textarea).click();
			getWebElement(description_textarea).sendKeys(description);
			test.log(Status.PASS, "Description entered as "+description);
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to enter description "+description);
			throw e;
		}
	}
	
	public static void enterProjectName(String projectname) throws Exception
	{
		try {
			getWebElement(projecttitle_textbox).sendKeys(projectname);
			test.log(Status.PASS, "project name entered as "+projectname);
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "unable to enter project name as "+projectname);
			throw e;
		}
	}
	
	public static void enterProjectNumber(String projectnumber) throws Exception
	{
		try {
			getWebElement(projectnumber_textbox).sendKeys(projectnumber);
			test.log(Status.PASS, "project number entered as "+projectnumber);
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "unable to enter project number as "+projectnumber);
			throw e;
		}
	}
	
	public static void selectProjectType(String projectType) throws Exception
	{
		try {
			getWebElement(projecttype_textbox).click();
			getWebElement(projecttype_textbox).sendKeys(projectType);
			
			Thread.sleep(3000);
			List<WebElement> list=getWebElements(projecttype_list);
			for (WebElement webElement : list) {
				if(webElement.getText().equalsIgnoreCase(projectType))
				{
					webElement.click();
					test.log(Status.PASS, "Project Type :"+projectType+" selected");
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to select Projet Type :"+projectType);
			throw e;
		}
	}
	
	public static void clickMyProjectLink() throws Exception
	{
		try {
			getWebElement(myproject_link).click();
			test.log(Status.PASS, "Clicked on myproject link");
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click on myproject link");
			throw e;
		}
	}
	
	public static void clickSaveButton() throws Exception
	{
		try {
WebElement ele1=getWebElement("xpath__//*[@id='nameInCompleteError']");
			
			System.out.println(ele1.isDisplayed());
			WebElement ele=getWebElement(save_button);
			scrollIntoElementView(ele);
			ele.click();
			test.log(Status.PASS, "clicked  on save buton");
			waitUntilPageLoads(20);
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click on save button");
			throw e;
		}
	}
	
	

}
