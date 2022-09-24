package Selenum_links;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https:\\www.facebook.com");
		
		// 1. count all the links in the page 
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// 2. Count only links in the footer the myfooter in a mini driver 
		WebElement myfooter = driver.findElement(By.id("pageFooter"));
		System.out.println(myfooter.findElements(By.tagName("a")).size());
		
		//3. count under the line 
		WebElement children = driver.findElement(By.id("pageFooterChildren"));
		System.out.println(children.findElements(By.tagName("a")).size());
		
		//4. open links in separated tabs (this will fail) 
		//for (int i=0; i < children.findElements(By.tagName("a")).size(); i++) {
		//	Thread.sleep(2000);
		//	children.findElements(By.tagName("a")).get(i).click();
			//driver.navigate().back();
			
			
		//}
		
		// 5. How to open all links in a seperate tab 
		//for (int i=0; i < children.findElements(By.tagName("a")).size(); i++) {
			//String openlink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			//children.findElements(By.tagName("a")).get(i).sendKeys(openlink);
		//}
		
		//6. get the title of each tab 
		Set<String> mytabs = driver.getWindowHandles();
		Iterator<String> tabview = mytabs.iterator();
		
		while (tabview.hasNext()){
			
			driver.switchTo().window(tabview.next());
			System.out.println(driver.getTitle());
		}
 	}

}
