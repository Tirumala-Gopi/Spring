package adding_items_intoCart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String[] text = driver.findElement(By.cssSelector(".text-center.text-white")).getText().split("is");
		String username = text[1].split("and")[0].trim();
		String passWord = text[2].trim().replace(")", "");

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(passWord);

		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn"))).click();

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-backdrop")));

		WebElement staticdropDown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropDown = new Select(staticdropDown);
		dropDown.selectByVisibleText("Consultant");

		wait.until(ExpectedConditions.elementToBeClickable(By.id("terms"))).click();
		driver.findElement(By.id("signInBtn")).click();

		List<WebElement> products = driver.findElements(By.cssSelector("button[class='btn btn-info']"));
		for (int i = 0; i < products.size(); i++) {

			products.get(i).click();
		}

		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

	}
}