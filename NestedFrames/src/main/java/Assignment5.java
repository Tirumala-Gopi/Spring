import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment5 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		// System.out.println(driver.findElements(By.xpath("//frameset/frame")).size());
		driver.findElements(By.xpath("//frameset/frame")).size();
		driver.switchTo().frame(0);
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.cssSelector("#content")).getText());
		driver.switchTo().defaultContent();

	}
}