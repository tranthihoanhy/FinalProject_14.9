package automation.testsuite.labelfunction;

import org.testng.annotations.Test;

import automation.pageLocator.Rise_Dashboard_Page;
import automation.pageLocator.Rise_Login_Page;
import automation.pageLocator.Rise_Projects_Page;
import automation.common.CommonBase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class LA1 extends CommonBase {
	Rise_Login_Page lp;
	Rise_Dashboard_Page dp;
	Rise_Projects_Page pp;

	@BeforeClass
	@Parameters({"browserTest"})
	void openSite(@Optional("browserTest")String br) {
		setupDriver(br);
		openWebsite("https://rise.fairsketch.com/signin");
		lp = new Rise_Login_Page(driver);
		dp = new Rise_Dashboard_Page(driver);
		pp = new Rise_Projects_Page(driver);
		lp.clickSubmit();
		dp.clickProject();
	}

	@Test
	public void TC1() throws InterruptedException {
		pp.clickLabelButton();
		String labelName = "TC1 LA1 " + randomString();
		pp.typeLabelName(labelName);
		pp.saveLabel();
		Thread.sleep(2000);
		Assert.assertEquals(pp.verifyLabelAndColor(labelName,"#4a8af4"), true);
	}

	@AfterClass
	void quitWebdriver() {
		driver.quit();
	}

}
