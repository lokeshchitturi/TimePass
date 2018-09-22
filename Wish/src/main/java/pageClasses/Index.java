package pageClasses;

import java.util.List;
import java.util.Set;

import org.apache.velocity.runtime.directive.Foreach;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.sun.jna.platform.win32.OaIdl.VARKIND;

import utils.JSONUtils;
import utils.WebDriverUtils;

public class Index extends WebDriverUtils{
	
	static String account_link="linkText__Accounts";
	static String accountname_textbox="id__txtAccountName";
	static String search_button="id__btnSearch";
	static String registrationtab_link="linkText__Registrations";
	static String doumentsrequired_textbox="id__txtEmail";
	static String send_button="id__btnSave";
	static String peoplesoftnumber_textbox="id__txtPeopleSoftNumber";
	static String pricingcategory_dropdown="id__cboPricingCategory";
	static String activateaccount_button="xpath__//input[@value='Activate Account']";
	static String accountcolumn_accounttable="xpath__//table[@id='grdAccounts']//tr[@class='gridRow']/td[1]/a"; 
	static String sidetab_list="xpath__//table[@id='tab']//tr/td[@class]";
	static String employeesrows_table="xpath__//table[@id='employees']//tr[@class='gridRow']";
	static String employeesheader_table="xpath__//table[@id='employees']//tr[@class='gridHeader']/th";
	static String latestapplication_tab="name__applications";
	static String logout_impersonate="xpath__//*[@id='menuFrontOffice']/div/div/ul[2]/li[2]/a";
	static String categorynames_list="xpath__//table[@id='grdPricingCategories']//td[1]/a";
	static String addinstitution_button="id__btnAdd";
	
	//add institute locators
	static String instituion_textbox="id__txtInstitution";
	static String contactname_tetbox="id__txtContactName";
	static String contactnumber_textbox="id__txtContactNumber";
	static String contactemail_textbox="id__txtContactEmail";
	static String additionalcharge_textbox="id__txtAdditionalCharge";
	static String update_button="xpath__//input[@value='Update']";
	static String searchacademicinstituion_textbox="id__txtInstitutionName";
	
	public static void deleteInstitute(String[] args) throws Exception
	{
		try {
			searchInstitute(args);
			List<WebElement> instituteRows=getWebElements("xpath__//table[@id='grdAcademicInstitutions']//*[@class='gridRow']");
			boolean flag=false;
			for (WebElement row : instituteRows) {
				List<WebElement> cols=row.findElements(By.tagName("td"));
				WebElement instituion=cols.get(0).findElement(By.tagName("a"));
				System.out.println("Institution name :"+instituion.getText());
				if(instituion.getText().equals(args[0]))
				{
					cols.get(cols.size()-1).click();
					driver.switchTo().alert().accept();
					test.log(Status.PASS, "Institute deleted succesfully");
					flag=true;
					break;
				}
			}
			
			
			if(flag==false)
			{
				throw new Exception("unable to delete institue with name :"+args[0]);
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.PASS, "unable to delete institue with name :"+args[0]);
			throw e;
		}
	}
	
	public static void searchInstitute(String[] args) throws Exception
	{
		try {
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			waitUntilFrameAvailableAndSwitch(30, "frmDisplay");
			getWebElement(searchacademicinstituion_textbox).sendKeys(args[0]);
			getWebElement("xpath__//table[@id='tblCriteria']//input[@value='Search']").click();
			Thread.sleep(4000);
			test.log(Status.PASS, "Entered institute name in search box with text :"+args[0]);
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to search institute name in search box with text :"+args[0]);
			throw e;
		}
	}
	public static void searchAndValidateAcademicInstituion(String[] args) throws Exception
	{
		try {
			searchInstitute(args);
			List<WebElement> instituteRows=getWebElements("xpath__//table[@id='grdAcademicInstitutions']//*[@class='gridRow']");
			boolean flag=false;
			for (WebElement row : instituteRows) {
				List<WebElement> cols=row.findElements(By.tagName("td"));
				WebElement instituion=cols.get(0).findElement(By.tagName("a"));
				System.out.println("Institution name :"+instituion.getText());
				if(instituion.getText().equals(args[0]))
				{
					test.log(Status.PASS, "Institute added succesfully");
					flag=true;
					break;
				}
			}
			
			if(!flag)
			{
				throw new Exception("Institue not added succesfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to search and validate institute in table with data :"+args[0]);
			throw e;
		}
	}
	
	public static void addInstituionForm(String[] args) throws Exception
	{
		try {
			
			getWebElement(addinstitution_button).click();
			test.log(Status.PASS, "Clicked on add instituion button");
			
			driver.switchTo().defaultContent();
			List<WebElement> list=getWebElements("xpath__//iframe");
			Thread.sleep(5000);

			for (WebElement webElement : list) {
				
				System.out.println(webElement.getAttribute("name")+" "+webElement.isDisplayed());
				
				String framename=webElement.getAttribute("name");
				if(framename.contains("hs") && webElement.isDisplayed())
				{
					
					driver.switchTo().frame(framename);
					break;
				}
			}
			
			System.out.println(getWebElement("xpath__//*[@id='tblAddAcademicInstitution']//td[@class='popupHeader']").getText());
			
			getWebElement(instituion_textbox).sendKeys(args[0]);
			getWebElement(contactname_tetbox).sendKeys(args[1]);
			getWebElement(contactnumber_textbox).sendKeys(args[2]);
			getWebElement(contactemail_textbox).sendKeys(args[3]);
			getWebElement(additionalcharge_textbox).sendKeys(args[4]);
			
			test.log(Status.PASS, "Enterd Instituion field values");
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
			getWebElement(update_button).click();
			//*[@id="tblAddAcademicInstitution"]//tr[7]/td[@class='fieldCell']
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to fill add instituion form");
			throw e;
		}
		
	}
	
	

	public static void selectToolsDropdown(String[] args) throws Exception
	{
		try {
			getWebElement("linkText__Tools").click();
			
			List<WebElement> list=getWebElements("xpath__//a[text()='Tools']//following-sibling::ul/li/a");
			boolean flag=false;
			for (WebElement webElement : list) {
				if(webElement.getText().equalsIgnoreCase(args[0]))
				{
					webElement.click();
					flag=true;
					test.log(Status.PASS, "Clicked on Tools Dropdown option with text :"+args[0]);
					break;
				}
			}
			if(flag==false)
			{
				throw new Exception("Unable to click on Tools Dropdown option with text :"+args[0]);
			}
			else
			{
				waitUntilFrameAvailableAndSwitch(30, "frmDisplay");
				Thread.sleep(2000);
				test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click on Tools Dropdown option with text :"+args[0]);
			throw e;
		}
	}
	
	
	public static void clickCheckPricingSave() throws Exception
	{
		try {
			WebElement ele=getWebElement("id__save");
			scrollIntoElementView(ele);
			ele.click();
			test.log(Status.PASS, "Clicked on save button in check pricing details page");
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to Click on save button in check pricing details page");
			throw e;
			
		}
	}
	
	public static void editCheckPricingDetails(String[] args) throws Exception
	{
		try {
			JSONObject testdata=JSONUtils.getJsonObject(args[0].toLowerCase());
			Set<String> fields=testdata.keySet();
			
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frmDisplay");
			driver.switchTo().frame("frmFilter");
			
			getWebElement("id__edit").click();
			//td[text()='TransUnion Credit Report']//following-sibling::td/input
			for (String fieldlocator : fields) {
				WebElement inputField=getWebElement("xpath__//td[text()='"+fieldlocator+"']//following-sibling::td/input");
				if(!inputField.isDisplayed())
					scrollIntoElementView(inputField);
				inputField.click();
				inputField.sendKeys((String) testdata.get(fieldlocator));
				test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
			}
		} catch (Exception e) {
			// TODO: handle exception
			
			test.log(Status.FAIL, "Unable to edit text fields");
			throw e;
		}
	}
	
	public static void selectPricingFilterTab(String[] args) throws Exception
	{
		try {
			List<WebElement> list=getWebElements("xpath__//td[@url]");
			boolean flag=false;
			for (WebElement webElement : list) {
				if(webElement.getText().equalsIgnoreCase(args[0]))
				{
					webElement.click();
					flag=true;
					test.log(Status.PASS, "Clikced on pricing filter tab with name: "+args[0]);
				}
			}
			if(flag==false)
			{
				throw new  Exception("Unable to click on pricing filter tab with name: "+args[0]);
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click on pricing filter tab with name: "+args[0]);
		throw e;
		}
		
	}
	public static void clickCategory(String[] args) throws Exception
	{
		try {
			List<WebElement> list=driver.findElements(By.xpath("//table[@id='grdPricingCategories']//td[1]/a"));
			boolean flag=false;
			
			for (WebElement webElement : list) {
				if(webElement.getText().equals(args[0]))
				{
					webElement.click();
					flag=true;
					test.log(Status.PASS, "Clicked on category name with text :"+args[0]);
					break;
				}
			}
			
			if(flag==false)
			{
				throw new Exception("Unable to click on category name with text :"+args[0]);
			}
			else
			{
				waitUntilVisible(30, By.xpath("//*[@id='headerCell']/span[starts-with(text(),'Category')]"));
				test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click on category name with text :"+args[0]);
			throw e;
		}
	}
	
	public static void selectFinancialDropdown(String[] args) throws Exception
	{
		try {
			getWebElement("linkText__Financial").click();
			
			List<WebElement> list=getWebElements("xpath__//a[text()='Financial']//following-sibling::ul/li/a");
			boolean flag=false;
			for (WebElement webElement : list) {
				if(webElement.getText().equalsIgnoreCase(args[0]))
				{
					webElement.click();
					flag=true;
					test.log(Status.PASS, "Clicked on Financial Dropdown option with text :"+args[0]);
					break;
				}
			}
			if(flag==false)
			{
				throw new Exception("Unable to click on Financial Dropdown option with text :"+args[0]);
			}
			else
			{
				waitUntilFrameAvailableAndSwitch(30, "frmDisplay");
				Thread.sleep(2000);
				test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click on Financial Dropdown option with text :"+args[0]);
			throw e;
		}
	}
	
	
	
	public static void activateRegistrationName(String[] args) throws Exception
	{
		try {
			getWebElement(registrationtab_link).click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frmSearch"));
			
			
			JSONObject json=JSONUtils.getJsonObject(args[0].toLowerCase());
			
			String expetedCompanyName=(String) json.get("txtCompanyName");
			
			boolean flag=false;
			Thread.sleep(3000);
			List<WebElement> rows=getWebElements("xpath__//tr[@class='gridRow']");
			for (WebElement row : rows) {
				List<WebElement> cols=row.findElements(By.tagName("td"));
				String actualCompanyName=cols.get(0).findElement(By.tagName("a")).getText();
				
				if(actualCompanyName.trim().equalsIgnoreCase(expetedCompanyName))
				{
					cols.get(7).findElement(By.tagName("a")).click();
					
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					List<WebElement> frames=driver.findElements(By.xpath("//iframe"));
					
					String frameName=null;
					for (WebElement webElement : frames) {
						System.out.println(webElement.getAttribute("name"));
						if (webElement.getAttribute("name").contains("hs")) {
							frameName=webElement.getAttribute("name");
							break;
						}
					}
					
					
					driver.switchTo().frame(frameName);
					
					//new WebDriverWait(driver, 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='highslide-wrapper-3']/div[1]/div/div/div[2]/iframe")));
					
					getWebElement(peoplesoftnumber_textbox).sendKeys(args[1]);
					Select select=new Select(getWebElement(pricingcategory_dropdown));
					select.selectByVisibleText(args[2]);
					test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
					getWebElement(activateaccount_button).click();
					Thread.sleep(2000);
					test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
					flag=true;
					
					break;
				}
			}
			
			if(flag==false)
			{
				throw new Exception("Registered name : "+expetedCompanyName+" not found in table");
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to active the account");
			throw e;
		}
	}
	
	public static void logout_impersonate()
	{
		try {
			driver.switchTo().defaultContent();
			getWebElement(logout_impersonate).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void validateFirstNameAndLastNameHome(String[] args) throws Exception
	{
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frmSearch"));
			String expectedFirstName=args[0];
			String expectedLastName=args[1];
			//driver.switchTo().defaultContent();
			//driver.switchTo().frame("frmSearch");
			Thread.sleep(3000);
			List<WebElement> rows=getWebElements("xpath__//tr[@class='gridRow']");
			boolean flag=false;
			for (WebElement row : rows) {
				List<WebElement> cols=row.findElements(By.tagName("td"));
				String actualLastName=cols.get(2).findElement(By.tagName("a")).getText().trim();
				String actualFirstName=cols.get(1).getText().trim();
				if(expectedFirstName.equalsIgnoreCase(actualFirstName)&&expectedLastName.equalsIgnoreCase(actualLastName))
				{
					scrollIntoElementView(row);
					flag=true;
					test.log(Status.PASS, "Expected First Name and Last Name found in the lasted application table");
					test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
					break;
				}
			}
			
			if(!flag)
			{
				throw new Exception(" Expected First Name and Last Name not found in the lasted application table");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Expected First Name and Last Name not found in the lasted application table");
			throw e;
		}
	}
	
	
	public static void validateFirstNameAndLastName(String[] args) throws Exception
	{
		try {
			String expectedFirstName=args[0];
			String expectedLastName=args[1];
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frmDisplay");
			driver.switchTo().frame("frmFilter");
			List<WebElement> rows=getWebElements("xpath__//tr[@class='gridRow']");
			boolean flag=false;
			for (WebElement row : rows) {
				List<WebElement> cols=row.findElements(By.tagName("td"));
				String actualLastName=cols.get(1).getText().trim();
				String actualFirstName=cols.get(2).getText().trim();
				if(expectedFirstName.equalsIgnoreCase(actualFirstName)&&expectedLastName.equalsIgnoreCase(actualLastName))
				{
					Login.watermarkId=cols.get(0).findElement(By.tagName("a")).getText().trim();
					flag=true;
					test.log(Status.PASS, "Expected First Name and Last Name found in the lasted application table");
					break;
				}
			}
			
			if(!flag)
			{
				throw new Exception(" Expected First Name and Last Name not found in the lasted application table");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Expected First Name and Last Name not found in the lasted application table");
			throw e;
		}
	}
	
	
	public static void clickLatestApplicationTab() throws Exception
	{
		try {
			driver.switchTo().defaultContent();
			switchToFrame("frmDisplay");
			waitUntilElementClicable(30, By.name("applications"));
			getWebElement(latestapplication_tab).click();
			test.log(Status.PASS, "Clicked on latest application tab");
			//waitUntilElementClicable(30, By.xpath("//tr[@class='gridRow']"));
			test.addScreenCaptureFromPath(captureScreenshotAndGetpath());
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click on latest application tab");
			throw e;
		}
	}
	
	
	public static void impersonateFirstEmployee() throws Exception
	{
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frmDisplay");
			driver.switchTo().frame("frmFilter");
			WebElement firstrow=getWebElements(employeesrows_table).get(0);
			firstrow.findElement(By.xpath("td[9]/a")).click();
			Alert alert=driver.switchTo().alert();
			System.out.println("Alert text "+alert.getText());
			alert.accept();
			waitUntilPageLoads(30);
			waitUntilVisible(30, By.xpath("//*[@id='menuFrontOffice']/div/div/ul[1]/li/a"));
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public static void clickSideTab(String[] tabName) throws Exception
	{
		try {
			
			List<WebElement> tabList=getWebElements(sidetab_list);
			boolean flag=false;
			for (WebElement webElement : tabList) {
				if(webElement.getText().trim().equals(tabName[0]))
				{
					webElement.click();
					flag=true;
					test.log(Status.PASS, "Clicked on tab with name :"+tabName[0]);
					break;
				}
			}
			if(!flag)
			{
				throw new Exception("Unable to find and click on tab with name :"+tabName[0]);
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to find and click on tab with name :"+tabName[0]);
			throw e;
		}
	}
	
	
	public static void clickAccountNameInTable(String[] accountName) throws Exception
	{
		try {
			List<WebElement> accountList=getWebElements(accountcolumn_accounttable);
			boolean flag=false;
			for (WebElement webElement : accountList) {
				if(webElement.getText().trim().equalsIgnoreCase(accountName[0]))
				{
					webElement.click();
					test.log(Status.PASS, "clicked on account link in the searched table with text:"+accountName[0]);
					flag=true;
					waitUntilPageLoads(30);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("frmDisplay");
					validateHeader(accountName);
					break;
				}
			}
			if(!flag)
			{
				throw new Exception(accountName[0]+" not found in the table");
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "unable to click on account link in the searched table with text:"+accountName[0]);
			throw e;
		}
	}
	
	public static void enterAccountName(String[] name) throws Exception
	{
		try {
			waitUntilElementClicable(30, By.id("txtAccountName"));
			getWebElement(accountname_textbox).sendKeys(name[0]);
			test.log(Status.PASS, "Enter account name as :"+name[0]);
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to enter account name");
			throw e;
		}
	}
	
	public static void clickSearch_Account()
	{
		try {
			getWebElement(search_button).click();
			test.log(Status.PASS, "Clicked on search button");
			Thread.sleep(3000);
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "unable to click on search button");
		}
	}
	
	
	public static void clickAccountMenu() throws Exception
	{
		try {
			getWebElement(account_link).click();
			switchToFrame("frmSearch");
			String[] header={"Accounts"};
			validateHeader(header);
			test.log(Status.PASS, "Clicked on Account in the menu bar");
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Unable to click on Account in the menu bar");
			throw e;
		}
	}
	
	public static boolean validateHeader(String[] headerName) throws Exception
	
	{
		boolean flag=false;
		try {
			List<WebElement> list=getWebElements("xpath__//*[@id='headerCell']/span");
			System.out.println("---------HeaderValues---------");
			for (WebElement webElement : list) {
				if(webElement.isDisplayed())
				{
					System.out.println(webElement.getText());
					if(webElement.getText().trim().equalsIgnoreCase(headerName[0]))
							{
								flag=true;
								test.log(Status.PASS, "Header displayed correctly with text :"+headerName[0]);
								break;
							}
				}
			}
			if(!flag)
			{
				throw new Exception("Header not displayed correctly with text :"+headerName[0]);
			}
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Header not displayed correctly with text :"+headerName[0]);
			throw e;
		}
		return flag;
	}
	
	
	public static void validateTabFileds() throws Exception
	{
		try {
			
			getWebElement("linkText__Home").click();
			driver.switchTo().frame("frmSearch");
			String homeHeader=getWebElement("xpath__//*[@id='headerCell']/span").getText();
			Assert.assertEquals("Applications", homeHeader.trim());
			captureScreenshotAndGetpath();
			test.log(Status.PASS, "Validated Home Tab");
			driver.switchTo().defaultContent();
			
			getWebElement("linkText__Registrations").click();
			driver.switchTo().frame("frmSearch");
			String regHeader=getWebElement("xpath__//*[@id='headerCell']/span").getText();
			Assert.assertEquals("New Registrations", regHeader.trim());
			captureScreenshotAndGetpath();
			test.log(Status.PASS, "Validated Registration Tab");
			driver.switchTo().defaultContent();
			
			getWebElement("xpath__//a[text()='P&O Checks ']").click();
			List<WebElement> list=getWebElements("xpath__//a[text()='P&O Checks ']//following-sibling::ul/li/a");
			String[] expectedlist={"TransUnion Credit Report","Experian Credit Report","XDS Credit Report","Criminal Record - 91A Form","Criminal Record - 91A Form (Premium)",
					"Criminal Record - Attach Fingerprints Captured","Criminal Record - Attach Fingerprints Captured (Premium)","ID Verification & Validation","ID Verification & Fraud Listing",
					"Drivers Licence","Professional Driving Permit Verification","Employment History (SA only)","Employment history (Africa, excl South Africa)","Employment History (Global)",
					"Employment history (SA only) with Character Reference","Professional Association Membership (SA only)","Professional Association Membership (Africa, excl South Africa)",
					"Professional Association Membership (Global)","Consumer Goods Council","Permanent Residency","Citizenship","Fit and Proper Check","Business Background Check",
					"Financial Service Provider","Bank Verification","Director/Member confirmation","FAIS Comprehensive Check"};
			int i=0;
			for (String string : expectedlist) {
				System.out.println(list.get(i).getText().trim());
				Assert.assertEquals(string, list.get(i).getText().trim());
				i++;
			}
			captureScreenshotAndGetpath();
			test.log(Status.PASS, "Validated P&O Checks drop down fields");
			
			getWebElement("xpath__//a[text()='Academic Checks']").click();
			List<WebElement> academiclist=getWebElements("xpath__//a[text()='Academic Checks']//following-sibling::ul/li/a");
			String[] academicexpectedlist={"Matric Pre 1992 DOE","Matric Post 1992 Umalusi","Umalusi Other","N-Levels","Academic Qualifications (SA only)","Academic Qualifications (Africa, excl SA)","Academic Qualifications (Global)"};
			
			int j=0;
			for (String string : academicexpectedlist) {
				System.out.println(academiclist.get(j).getText().trim());
				Assert.assertEquals(string, academiclist.get(j).getText().trim());
				j++;
			}
			captureScreenshotAndGetpath();
			test.log(Status.PASS, "Validated Academic dropdown fields");
			
			getWebElement("linkText__Applications").click();
			driver.switchTo().frame("frmSearch");
			String applicationHeader=getWebElement("xpath__//*[@id='headerCell']/span").getText();
			Assert.assertEquals("Applications", applicationHeader.trim());
			captureScreenshotAndGetpath();
			test.log(Status.PASS, "Validated Application Tab");
			driver.switchTo().defaultContent();
			
			getWebElement("linkText__Accounts").click();
			driver.switchTo().frame("frmSearch");
			String accountsHeader=getWebElement("xpath__//*[@id='headerCell']/span").getText();
			Assert.assertEquals("Accounts", accountsHeader.trim());
			captureScreenshotAndGetpath();
			test.log(Status.PASS, "Validated Accounts Tab");
			driver.switchTo().defaultContent();
			
			getWebElement("xpath__//a[text()='Financial']").click();
			List<WebElement> financiallist=getWebElements("xpath__//a[text()='Financial']//following-sibling::ul/li/a");
			String[] financialexpectedlist={"Pricing Categories","Financial Invoice","Financial Run Dates"};
			
			int k=0;
			for (String string : financialexpectedlist) {
				
				Assert.assertEquals(string, financiallist.get(k).getText().trim());
				k=k+1;
			}
			captureScreenshotAndGetpath();
			test.log(Status.PASS, "Validated Financial Drop down fields");
			
			getWebElement("xpath__//a[text()='Tools']").click();
			List<WebElement> toolslist=getWebElements("xpath__//a[text()='Tools']//following-sibling::ul/li/a");
			String[] toolsexpectedlist={"Account Broadcast","SA Academics","National Credit Act Dispute Log","Role Functions","LexisNexis Employees","View System Batches",
					"View Manual Batches","Bulk Application Imports","Bulk Registration Imports","Website Downloads","Fingerprints","Merge Accounts","Pending Account Merges",
					"SLA Monitor Dashboard","Supplier SLA Dashboard","Secondary SLA Dashboard"};
			
			int l=0;
			for (String string : toolsexpectedlist) {
				
				Assert.assertEquals(string, toolslist.get(l).getText().trim());
				l=l+1;
			}
			captureScreenshotAndGetpath();
			test.log(Status.PASS, "Validated Tools Drop down fields");
			
			getWebElement("xpath__//a[text()='Sales']").click();
			List<WebElement> saleslist=getWebElements("xpath__//a[text()='Sales']//following-sibling::ul/li/a");
			String[] salesexpectedlist={"Introducer Performance","Account Performance"};
			
			int m=0;
			for (String string : salesexpectedlist) {
				
				Assert.assertEquals(string, saleslist.get(m).getText().trim());
				m=m+1;
			}
			captureScreenshotAndGetpath();
			test.log(Status.PASS, "Validated Sales Drop down fields");
			
			getWebElement("xpath__//a[text()='Reports']").click();
			List<WebElement> reportslist=getWebElements("xpath__//a[text()='Reports']//following-sibling::ul/li/a");
			String[] reportsexpectedlist={"Outstanding Applications per Account","Quarterly NCR Report","Focus Top 40 Report","Focus Customer Revenue Report","Focus Revenue Report",
					"AFISwitch Error Report","MIS Report","Account and User Information Report","Outstanding Documents and Information","Agent Activity Report By Check Type","Agent Activity Report By Agent",
					"Supplier SLA Report"};
			
			int n=0;
			for (String string : reportsexpectedlist) {
				
				Assert.assertEquals(string, reportslist.get(n).getText().trim());
				n=n+1;
			}
			captureScreenshotAndGetpath();
			
			test.log(Status.PASS, "Validated Reports Drop down fields");
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "Incomplete validation of tabs");
			throw e;
		}
	}
	
	
	public static void addNationalCreditCardEnquires(String[] args) throws Exception
	{
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frmDisplay");
			
			getWebElement("xpath__//input[@value='Add National Credit Act Enquiry']").click();
			test.log(Status.PASS, "Clicked on add national credit act enquiry button");
			switchToFrameNameContainsHS();
			
			Select type=new Select(getWebElement("id__cboType"));
			type.selectByVisibleText(args[0]);
			
			getWebElement("id__txtUserName").sendKeys(args[1]);
			test.log(Status.PASS, "Entered user name");
			
			getWebElement("id__txtIDNumber").sendKeys(args[2]);
			test.log(Status.PASS,"Enterd id number");
			captureScreenshotAndGetpath();
			
			Select select=new Select(getWebElement("id__CboSystemFrom"));
			select.selectByVisibleText(args[3]);
			test.log(Status.PASS, "Selected value:"+select.getFirstSelectedOption()+" in System dropdwon");
			
			Select bureau=new Select(getWebElement("id__ddBureau"));
			bureau.selectByVisibleText(args[4]);
			test.log(Status.PASS, "Selected value:"+bureau.getFirstSelectedOption()+" in Bureau dropdwon");
			
			JavascriptExecutor js=(JavascriptExecutor) driver;
			//"2018/09/20"
			js.executeScript("document.getElementById('txtQuestionedDate').value=arguments[0]", args[5]);
			test.log(Status.PASS, "Selected date");
			
			captureScreenshotAndGetpath();
			getWebElement("id__btnSave").click();
			test.log(Status.PASS, "Clicked on save button");
			
			Thread.sleep(3000);
			captureScreenshotAndGetpath();
		} catch (Exception e) {
			// TODO: handle exception
			test.log(Status.FAIL, "failed in filling add national credit act enquiry");
			throw e;
		}
	}
	

}
