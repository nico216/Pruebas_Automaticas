package tests;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import helpers.Helpers;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageReservation;

public class Tests_Automatizados {
	Helpers helper = new Helpers();
	private WebDriver driver;
	private PageReservation pageReservation = new PageReservation(driver);
	private By noGraciasButton;
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		/*System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();*/
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.latam.com/es_cl/");		
		helper.tiempoDeEspera(5);
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		noGraciasButton = By.id("onesignal-popover-cancel-button");
		driver.findElement(noGraciasButton).click();

		// Now you are in the popup window, perform necessary actions here

		//driver.switchTo().window(parentWindowHandler);  // switch back to parent window
	}
	
	@Test
	public void CP001() {
		PageLogin pageLogin = new PageLogin(driver);
		PageLogon pageLogon = new PageLogon(driver);
		pageLogin.login("user", "user");
		Helpers helper = new Helpers();
		helper.tiempoDeEspera(10);
		pageLogon.assertLogonPage();
	}
	
	@Test
	public void CP002() {
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.login("nico.briones@gmail.com", "Patriotas216");
		Helpers helper = new Helpers();
		helper.tiempoDeEspera(10);
		pageReservation.assertReservationPage();
	}
	
	@Test
	public void CP003() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		helper.tiempoDeEspera(5);
		//selecciona lugar de partida 
		PageReservation pageReservation = new PageReservation(driver);
		pageReservation.selectOrigen("Santiago de Chile (SCL), A. Merino Benítez Intl. (SCL), Chile");
		//js.executeScript("document.getElementById('compra-select-origin').value='Santiago de Chile (SCL), A. Merino Benítez Intl. (SCL), Chile';");
		//selecionar lugar de destino
		js.executeScript("document.getElementById('compra-select-destination').value='Arica (ARI), Chacalluta (ARI), Chile';");
		//selecciona fechas de viaje
		driver.findElement(By.xpath("//div[@id='tab-compra']/div/div/div/div/div/div/form/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div/input")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/table/tbody/tr[3]/td[4]/a")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[5]/a")).click();
		//selecciona numero de pasajeros
		driver.findElement(By.id("compra-passenger-count-id")).click();

		//driver.findElement(By.className("spinner-value form-control text-center")).sendKeys("2");
		helper.tiempoDeEspera(20);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();	}	
}