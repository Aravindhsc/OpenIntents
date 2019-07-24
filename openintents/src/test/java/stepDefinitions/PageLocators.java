package stepDefinitions;

public class PageLocators{
	//Layout
	public static final String choose_layout = "org.openintents.shopping:id/layout_choice_bottom";
	public static final String navigate_back = "//android.widget.ImageButton[@content-desc='Open navigation drawer']";
	
	//AddItems
	public static final String add_item_txt_box="org.openintents.shopping:id/autocomplete_add_item";
	public static final String add_item_btn="org.openintents.shopping:id/button_add_item";
	
	//New_List
	public static final String hamburger_menu="//android.widget.ImageButton[@content-desc='Open navigation drawer']";
	public static final String new_list="//*[@text='New list']";
	public static final String new_list_txt_box="org.openintents.shopping:id/edittext";
	public static final String ok_btn = "android:id/button1";
	public static final String list_1= "//*[@text='List1']";
	
	//Delete_item
	public static final String check_box_1="(//*[@class='android.widget.CheckBox'])[1]";
	public static final String check_box_2="(//*[@class='android.widget.CheckBox'])[2]";
	public static final String clean_up_btn="//android.widget.TextView[@content-desc='Clean up list']";
	
	//Sorting
	public static final String more_options="//android.widget.ImageView[@content-desc='More options']";
	public static final String settings_btn="//*[@text='Settings']";
	public static final String sort_order="//*[@text='Sort order']";
	public static final String alphabetical_sort="//*[@text='alphabetical']";
	public static final String list_value="//*[@resource-id='org.openintents.shopping:id/name']";
}
