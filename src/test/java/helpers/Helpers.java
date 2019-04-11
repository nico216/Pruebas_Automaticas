package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Helpers {
	private WebDriver driver;
	
	
	public void tiempoDeEspera(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	/*public void scrollDown(int x, int y) {
		
		
	}*/

}
