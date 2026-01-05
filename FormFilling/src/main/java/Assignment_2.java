import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Gopi");
		driver.findElement(By.name("email")).sendKeys("gopi@gamil.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("gopi1234");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement staticdropDown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropDown = new Select(staticdropDown);
		dropDown.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("20000324");
		driver.findElement(By.cssSelector("input[class='btn btn-success']")).click();
		System.out.println(
				driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());

	}

}
