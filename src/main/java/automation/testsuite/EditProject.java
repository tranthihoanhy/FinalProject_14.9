package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pageLocator.LoginPageFactory;
import automation.pageLocator.ProjectPageFactory;


public class EditProject extends CommonBase {
	By btnEdit = By.xpath(
			"//a[contains(text(),'new added project')]//ancestor:: td//following-sibling::td[7]/a[@title='Edit project']");
	By btnSave = By.xpath("//button[text()=' Save']");

	@BeforeMethod
	@Parameters("browserTest")
	public void openBrowser(@Optional("browserTest") String browserName) {
		setupDriver(browserName);
		driver.get(CT_Account.webURL);
	}

	@Test
	public void editProjectSuccessfully() throws InterruptedException {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		click(By.linkText("Projects"));
		// find new added project by title
		ProjectPageFactory projPage = new ProjectPageFactory(driver);
		projPage.AddProjectFunction("new added project");
		pause(5000);
		projPage.searchProject("new added project");
		// click button edit
		click(btnEdit);
		// edit
		String[] listLabels = new String[] { "Urgent", "Upcoming" };
		projPage.editProject("new added project 1", "Client Project", "Demo Client", "abc", "27-11-2023", "30-11-2023",
				"36000", listLabels, "Completed");
		// click Save
		click(btnSave);
		pause(5000);
		//check
		projPage.searchProject("new added project 1");
		assertTrue(getElementPresentDOM(By.xpath("//a[contains(text(),'new added project 1')]")).isDisplayed());
		pause(5000);
		
	}
	

	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
