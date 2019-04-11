package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.Helpers;

public class PageLogin {
	private WebDriver driver;
	private By iniciarSesionButton;
	private By userField;
	private By passwordField;
	private By loginButton;
	public PageLogin(WebDriver driver) {
		this.driver = driver;		
		iniciarSesionButton = By.xpath("//*[@id=\"loginLatamBox\"]/a");
		userField = By.name("login");
		passwordField = By.name("password");
		loginButton = By.name("enter");
	}
	public void login(String user, String pass) {
		Helpers helper = new Helpers();
		helper.tiempoDeEspera(5);
		driver.findElement(iniciarSesionButton).click();
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(loginButton).click();
	}
	
	
}
