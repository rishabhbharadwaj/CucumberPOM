package Pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	private By accountSections = By.xpath("//div[@class='row addresses-lists']//span");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountsSecionCount() {
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountsSectionList() {
		List<String> accountsList = new ArrayList<String>();
		
		List<WebElement> accountsHeaderList = driver.findElements(accountSections);
		for(WebElement e: accountsHeaderList) {
			String text = e.getText();
			accountsList.add(text);
		}
		
		return accountsList;
	}
	
}
