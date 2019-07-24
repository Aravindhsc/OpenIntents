package stepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class HomePage extends PageLocators {
	AndroidDriver<WebElement> driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();
	// WebDriverWait wait=new WebDriverWait(driver, 30);

	public void launchApp() throws MalformedURLException {
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "330020d19eed93a5");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");// device Version
		capabilities.setCapability("appPackage", "org.openintents.shopping");
		capabilities.setCapability("appActivity", "org.openintents.shopping.ShoppingActivity");
		capabilities.setCapability("launchTimeout", 120000);
		capabilities.setCapability("automationName", "uiautomator2");
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void selectLayout() {
		driver.findElement(By.id(choose_layout)).click();
	}

	public void addList(String listname) {
		driver.findElement(By.xpath(hamburger_menu)).click();
		driver.findElement(By.xpath(new_list)).click();
		driver.findElement(By.id(new_list_txt_box)).clear();
		driver.findElement(By.id(new_list_txt_box)).sendKeys(listname);
		driver.findElement(By.id(ok_btn)).click();
		System.out.println("List created succesfully");
	}

	public void addItems(String itemname) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id(add_item_txt_box)).clear();
		driver.findElement(By.id(add_item_txt_box)).sendKeys(itemname);
		driver.findElement(By.id(add_item_btn)).click();
		driver.findElement(By.id(add_item_btn)).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Items added succesfully");
	}

	public void selectList(String list) {
		driver.findElement(By.xpath(hamburger_menu)).click();
		String list_value = "//*[@text='" + list + "']";
		driver.findElement(By.xpath(list_value)).click();
	}

	public void deleteItems() {
		driver.findElement(By.xpath(check_box_1)).click();
		driver.findElement(By.xpath(clean_up_btn)).click();
		System.out.println("Items Deleted succesfully");
	}

	public void sortItems(String listname) {
		selectList(listname);
		driver.findElement(By.xpath(more_options)).click();
		driver.findElement(By.xpath(settings_btn)).click();
		driver.findElement(By.xpath(sort_order)).click();
		driver.findElement(By.xpath(alphabetical_sort)).click();
		driver.navigate().back();
		selectList(listname);
	}

	public void validateList(String listName) {
		selectList(listName);
		driver.findElement(By.xpath(navigate_back)).click();
		List<String> item_list = new ArrayList<String>();
		List<WebElement> webelements = driver.findElements(By.xpath(list_value));
		for (int i = 0; i < webelements.size(); i++) {
			item_list.add(webelements.get(i).getText());
		}
		System.out.println(item_list);
		
		List<List<String>> expList = ShoppingStepDef.list;
		Set<String> sortExpList = new TreeSet<String>();

		for (int i = 1; i < expList.size(); i++) {
			if (listName.equals(expList.get(i).get(0))) {
				for (int j = 1; j < expList.get(i).size(); j++) {
					sortExpList.add(expList.get(i).get(j));
				}
			}
		}
		System.out.println(sortExpList);

		int i=0;
		for(String expected_item : sortExpList) {
			org.junit.Assert.assertEquals(expected_item,item_list.get(i));
			i++;
		}
	}
}
