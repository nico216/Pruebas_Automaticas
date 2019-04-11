package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import helpers.Helpers;

public class PageReservation {
	private WebDriver driver;
	private JavascriptExecutor js;
	
	private By titleText;
	private By pasajerosDrop;
	private By destinoDrop;
	private By fechaIdaDate;
	private By fechaVueltaDate;
	private String origenDrop;
	
	//private By origenDrop;
		
	public PageReservation(WebDriver driver) {	
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		titleText = By.className("Login-launcherInfo");
		pasajerosDrop = By.name("passCount");
		origenDrop = "compra-select-origin";
		destinoDrop = By.name("destination");
		fechaIdaDate = By.xpath("//div[@id='tab-compra']/div/div/div/div/div/div/form/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div/input");
		fechaVueltaDate = By.className("//*[@id=\"dp1554759664059\"]");		
	}
	
	public void assertReservationPage() {
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Hola"));
	
	}
	public void selectPasajeros(int cant) {
		Select selectPasajeros = new Select(driver.findElement(pasajerosDrop));
		selectPasajeros.selectByVisibleText(Integer.toString(cant));
	}
	public void selectOrigen(String ciudad) {
		String txt = "document.getElementById('" + origenDrop + "').value='" + ciudad + "';";
		js.executeScript(txt);
		//this.js.executeScript("document.getElementById('compra-select-origin').value='Santiago de Chile (SCL), A. Merino Benítez Intl. (SCL), Chile';");
	}
	public void selectDestino(String ciudad) {
		Select selectDestino = new Select(driver.findElement(destinoDrop));
		selectDestino.selectByValue(ciudad);
	}
	public void selectFechaIda(String fechaIda) {
		
	}
	public void selectfechaVuelta(String fechaVuelta) {	
	}
}