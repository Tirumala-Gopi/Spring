import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption2")).click();
		String selected = driver.findElement(By.cssSelector("label[for='benz']")).getText();

		WebElement staticdropDown = driver.findElement(By.id("dropdown-class-example"));
		Select dropDown = new Select(staticdropDown);
		dropDown.selectByVisibleText(selected);

		driver.findElement(By.id("name")).sendKeys(selected);
		driver.findElement(By.id("confirmbtn")).click();

		System.out.println(driver.switchTo().alert().getText().contains(selected));
		driver.switchTo().alert().accept();

	}

}
