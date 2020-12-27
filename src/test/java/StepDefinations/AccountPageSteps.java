package StepDefinations;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import Factory.DriverFactory;
import Pages.AccountsPage;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountPage;
	private String title;
	
	@Given("user has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable dataTable) {
	     List<Map<String,String>> cred =  dataTable.asMaps();
	     String userName = cred.get(0).get("userName");
	     String password = cred.get(0).get("password");
	     
	     DriverFactory.getDriver()
	    	.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	     
	     accountPage = loginPage.doLogin(userName, password);
	}

	@Given("user is on Account page")
	public void user_is_on_account_page() {
		title = accountPage.getAccountPageTitle();
	}
	
	@Then("account page title should be {string}")
	public void account_page_title_should_be(String accountPageTitle) {
	    Assert.assertTrue(title.equals(accountPageTitle));
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		List<String> expectedList = sectionTable.asList();
		List<String> actualList = accountPage.getAccountsSectionList();
		System.out.println(actualList);
		
		Assert.assertTrue(actualList.containsAll(expectedList));
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer sectionCount) {
		Assert.assertTrue(accountPage.getAccountsSecionCount() == sectionCount);
	}

}
