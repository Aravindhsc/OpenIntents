package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;

public class ShoppingStepDef implements En {

	public static List<List<String>> list;
	HomePage homePage = new HomePage();
	public ShoppingStepDef() {
		Before(() -> {
			homePage.launchApp();

		});

		Given("User Navigates to Home page", () -> {
			homePage.selectLayout();
		});

		When("User Add List", () -> {
			homePage.addList("List1");
			homePage.addList("List2");
		});

		Given("Add some Items to List", (DataTable itemsname) -> {
			list=itemsname.asLists(String.class);
			for (int i = 1; i < list.size(); i++) {
				List<String> listItems = list.get(i);
				homePage.selectList(listItems.get(0));
				for (int j = 1; j < listItems.size(); j++) {
					homePage.addItems(listItems.get(j));
				}
			}

		});

		Then("Delete An Items in List", () -> {
			homePage.selectList("List1");
			homePage.deleteItems();
		});

		// Scenario2
		Given("Sort the list", () -> {
			homePage.sortItems("List1");
		});

		Then("Validate the list", () -> {
			homePage.selectList("List1");
			homePage.validateList("List1");
		});

	}
}
