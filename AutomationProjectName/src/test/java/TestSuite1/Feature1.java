package TestSuite1;
import static org.junit.Assert.assertEquals;
import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Feature1 {

	
		private WebDriver driver; 
		
		@Before 
		public void setUp() {
			System.setProperty("webdriver.chrome.driver","c:/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
			
			//Implicit wait, will even if a object is not located 
		}
		@Test
		public void TestName() {
			WebElement searchbox = driver.findElement(By.name("q"));
			searchbox.clear();
			searchbox.sendKeys("buscar");
			searchbox.submit();
					
			//implicit wait, wait the time set after the object is ready
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//Explicit wait until a conditions is meet, are many expected conditions functions availables 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.titleContains("buscar - Buscar con Google"));
			
			//add static import from JUNIT
			assertEquals("buscar - Buscar con Google",driver.getTitle());
			
				
		}
		@After
		public void tearDown() {
		
			driver.quit();

	}
}


