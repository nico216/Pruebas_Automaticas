package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageLogon {
	private WebDriver driver;
	private By titleText;
	public PageLogon(WebDriver driver) {
		this.driver = driver;
		titleText = By.xpath("/html/body/div[2]/div/div[4]/section/div/div/div/div[1]/h1");
	}
	public void assertLogonPage() {
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Ingresa a tu cuenta"));

	}

}


