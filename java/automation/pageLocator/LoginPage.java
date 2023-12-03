package automation.pageLocator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import automation.constant.CT_Account;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver _driver) {
		this.driver = _driver;
	}
	public void LoginFunction(String email , String password) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement txtEmail = driver.findElement(CT_Account.textEmail);
		if(txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys(email);
		}
		WebElement txtPass = driver.findElement(CT_Account.textPassword);
		if(txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys(password);
		}
		WebElement btnLogin = driver.findElement(CT_Account.btnLogin);
		if(btnLogin.isDisplayed()) {
			btnLogin.click();
		}
	}
}
