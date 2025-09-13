package pages;
// this one

//this one
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class substore_page extends StartupPage {

	//TC-1 Locators
		public By getUsernameTextfieldLocator = By.id("username_id");
		public By getPasswordTextboxLocator = By.xpath("//input[@id='password']");
		public By getSignInButtonLocator = By.xpath("//button[@id='login']");
		public By getDropDownLocater = By.xpath("//a[@href='#/WardSupply']");
//		TC-2 Locators
		public By getCounterButtonFourth = By.xpath("//a[@class='report_list']");
//		TC-3 Locators
		public By getAnchorTagLocatorInventory = By.xpath("//a[contains(text(),'Inventory')]");
		public By getModuleSignoutLocator = By.xpath("//i[contains(@class,'sign-out')]");
		public By getHoverText = By.xpath("//h6[contains(text(),'To change, you can always click here.')]");
//		TC-4 Locators	
		public By getAnchorTagLocatorPharmacy = By.xpath("//a[contains(text(),'Pharmacy')]");
//		TC-5 Locators
		public By getSubModuleLocator = By.xpath("//ul[contains(@class,'nav-tabs')]//li//a");
//		TC-6 Locators
		public By getAnchorTagLocatorByText(String anchorTagName) {return By.xpath("//a[contains(text(),'" + anchorTagName + "')]");}
		public By getAnchorTagLocatorStock = By.xpath("//a[contains(text(),'Stock')]");
		public By getAnchorTagLocatorByTextInventoryRequisition = By.xpath("//a[contains(text(),'Inventory Requisition')]");
		public By getAnchorTagLocatorConsumption = By.xpath("//a[contains(text(),'Consumption')]");
		public By getAnchorTagLocatorReports = By.xpath("//a[contains(text(),'Reports')]");
		public By getAnchorTagLocatorPatientConsumption = By.xpath("//a[contains(text(),'Patient Consumption')]");
		public By getAnchorTagLocatorReturn = By.xpath("//a[contains(text(),'Return')]");
//		TC-8 Locators
		public By getCreateRequisitionButton = By.xpath("//button/span[text()='Create Requisition']");
		public By searchBarId() {return By.id("quickFilterInput");}
		public By getStarIconLocator = By.xpath("//i[contains(@class,'icon-favourite')]/..");
		public By getButtonLocatorFirst = By.xpath("//button[contains(text(),'" + "First" + "')]");
		public By getButtonLocatorPrevious = By.xpath("//button[contains(text(),'" + "Previous" + "')]");
		public By getButtonLocatorNext = By.xpath("//button[contains(text(),'" + "Next" + "')]");
		public By getButtonLocatorLast = By.xpath("//button[contains(text(),'" + "Last" + "')]");
		public By getButtonLocatorOK = By.xpath("//button[contains(text(),'" + "OK" + "')]");
		public By getRadioButtonLocatorPending = By.xpath("//label[contains(text(),'" + "Pending" + "')]/span");
		public By getRadioButtonLocatorComplete = By.xpath("//label[contains(text(),'" + "Complete" + "')]/span");
		public By getRadioButtonLocatorCancelled = By.xpath("//label[contains(text(),'" + "Cancelled" + "')]/span");
		public By getRadioButtonLocatorWithdrawn = By.xpath("//label[contains(text(),'" + "Withdrawn" + "')]/span");
		public By getRadioButtonLocatorAll = By.xpath("//label[contains(text(),'" + "All" + "')]/span");
//		TC-9 Locators
		public By getRequestButton = By.cssSelector("input#save_requisition");
		public By getTargetInventory = By.xpath("//input[@id='activeInventory']");
		public By getItemName = By.xpath("//input[@id='itemName0']");
		public By getRequiredQuantity = By.xpath("//input[@id='qtyip0']");
		public By getPopUpMessageText(String msgStatus, String messageText) {
			return By.xpath("//p[contains(text(),' " + msgStatus + " ')]/../p[contains(text(),'" + messageText + "')]");
		}
		public By popupCloseButton = By.cssSelector("a.close-btn");
		public By getCloseModalLocator = By.cssSelector("a[title='Cancel']");
		
	public substore_page(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * @Test Case 1.1: Verify login functionality using valid credentials
	 *
	 * @method loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData)
	 *
	 * @param expectedData A map containing valid login credentials:
	 *                     - "username": the username to enter
	 *                     - "password": the password to enter
	 *
	 * @steps
	 * 1. Locate the username text field element.
	 * 2. Highlight the username text field.
	 * 3. Enter the provided username into the username text field.
	 * 4. Locate the password text field element.
	 * 5. Highlight the password text field.
	 * 6. Enter the provided password into the password text field.
	 * 7. Locate and highlight the sign-in button.
	 * 8. Click the sign-in button to initiate login.
	 *
	 * @return true if all steps are performed without exception; false otherwise
	 *
	 * @throws Exception if any of the web elements are not found or interaction fails
	 *
	 * @author Yaksha
	 */

	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			WebElement usernametextFieldWebElement = commonEvents.findElement(getUsernameTextfieldLocator);
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(getUsernameTextfieldLocator, expectedData.get("username"));

			WebElement passwordtextFieldWebElement = commonEvents.findElement(getPasswordTextboxLocator);
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(getPasswordTextboxLocator, expectedData.get("password"));

			WebElement signinButtonWebElement = commonEvents.findElement(getPasswordTextboxLocator);
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.click(getSignInButtonLocator);
			textIsDisplayed = true;
		} catch (Exception e) {
			throw e;
		}
		return textIsDisplayed;

	}

	
	/**
	 * @Test Case 1.2: Scroll to and click on the "Substore" tab in the application UI
	 *
	 * @method scrollDownAndClickSubstoreTab()
	 *
	 * @description 
	 * This method performs the following actions to interact with the Substore tab:
	 * 
	 * @steps
	 * 1. Locate the "Substore" tab element using its defined locator.
	 * 2. Scroll the page to bring the element into the visible viewport using JavaScript.
	 * 3. Adjust the scroll position slightly upwards for optimal visibility (offset by 50 pixels).
	 * 4. Highlight the "Substore" tab element for visual debugging (optional step).
	 * 5. Click on the "Substore" tab to navigate to the corresponding section.
	 * 6. Wait until the URL contains the substring "WardSupply" to ensure successful navigation.
	 *
	 * @return true if the tab is successfully clicked and the URL updates as expected; false otherwise
	 *
	 * @throws Exception if the element is not found or any JavaScript/WebDriver interaction fails
	 *
	 * @author Yaksha
	 */

	public boolean scrollDownAndClickSubstoreTab() throws Exception {
		boolean scrolledTillElement = false;
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement SubstoreTab = commonEvents.findElement(getDropDownLocater);
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", SubstoreTab);
			jsExecutor.executeScript("window.scrollBy(0, -50)");
			commonEvents.highlight(SubstoreTab);
			commonEvents.click(SubstoreTab);

			// Wait for the URL to contain "WardSupply"
			commonEvents.waitForUrlContains("WardSupply", 30);

			scrolledTillElement = true;
		} catch (Exception e) {
			throw e;
		}
		return scrolledTillElement;
	}

	
	/**
	 * @Test Case 1.3: Verify the current page URL after navigating to the Substore page
	 *
	 * @method verifySubstorePageUrl()
	 *
	 * @param None
	 *
	 * @description 
	 * This method retrieves and returns the current URL of the active browser window. 
	 * It is typically used to verify if navigation to the Substore page was successful.
	 *
	 * @steps
	 * 1. Fetch the current URL from the browser using the WebDriver instance.
	 * 2. Return the retrieved URL.
	 *
	 * @return The current page URL as a String
	 *
	 * @throws Exception if the WebDriver fails to retrieve the current URL
	 *
	 * @author YAKSHA
	 */


	public String verifySubstorePageUrl() throws Exception {
		
		try {
			String titleToVerify = commonEvents.getCurrentUrl();
			return titleToVerify;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Test Case 2: Click on the fourth counter module if available
	 *
	 * @method clickFourthCounterIfAvailable()
	 *
	 * @param None
	 *
	 * @description 
	 * This method attempts to click on the fourth counter button (module) if it is present 
	 * in the list of located elements. It highlights the element before clicking it.
	 *
	 * @steps
	 * 1. Locate all elements that match the "counter" locator.
	 * 2. Check the number of counter elements found.
	 * 3. If at least one counter element is found:
	 *    - Highlight the first counter element in the list.
	 *    - Click on the first counter element.
	 *
	 * @note 
	 * Despite the method name suggesting the "fourth" counter, it currently clicks the **first** counter element.
	 * Consider updating the logic or renaming the method for clarity.
	 *
	 * @return true if execution is successful without exceptions; false otherwise
	 *
	 * @throws Exception if locating elements or interaction fails
	 *
	 * @author YAKSHA
	 */

	public boolean clickFourthCounterIfAvailable() throws Exception {
		try {
			List<WebElement> counterElements = commonEvents.getWebElements(getCounterButtonFourth);
			System.out.println("Elemets size >> " + counterElements.size());
			int numberOfCounterElements = counterElements.size();
			if (numberOfCounterElements > 0) {
				commonEvents.highlight(counterElements.get(0)).click(counterElements.get(0));
			}
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Test Case 3: Verify the hover text of the "Sign Out" module
	 *
	 * @method verifyModuleSignoutHoverText(Map<String, String> substoreExpectedData)
	 *
	 * @param substoreExpectedData A map containing expected values for verification:
	 *                             - "moduleSignOutHoverText": the expected hover text on the "Sign Out" module.
	 *
	 * @description 
	 * This method verifies that the actual hover text displayed on the "Sign Out" module 
	 * matches the expected text provided in the input map.
	 *
	 * @steps
	 * 1. Click on the "Inventory" section to ensure the module is visible.
	 * 2. Locate the "Sign Out" module element.
	 * 3. Perform a mouse hover action over the "Sign Out" module using the Actions class.
	 * 4. Retrieve the hover text element and get its text content.
	 * 5. Compare the actual hover text with the expected value from the input map.
	 * 6. Return true if they match; otherwise, throw an exception.
	 *
	 * @return true if the hover text matches the expected value; false otherwise
	 *
	 * @throws Exception if any element interaction fails or the hover text does not match
	 *
	 * @author YAKSHA
	 */

	public boolean verifyModuleSignoutHoverText(Map<String, String> substoreExpectedData) throws Exception {
		try {
			// Click on the "Inventory" section.
			commonEvents.click(getAnchorTagLocatorInventory);

			// Locate the "Sign Out" module for hover action.
			WebElement elementToHover = commonEvents.findElement(getModuleSignoutLocator);

			// Create an instance of Actions class to perform hover action.
			Actions actions = new Actions(driver);

			// Perform the hover action on the "Sign Out" module.
			actions.moveToElement(elementToHover).perform();

			// Retrieve the hover text displayed.
			String elementText = commonEvents.findElement(getHoverText).getText();
			System.out.println("Element text -->  " + elementText);

			// Check if the hover text matches the expected value.
			if (elementText.contains(substoreExpectedData.get("moduleSignOutHoverText"))) {
				return true;
			} else {
				throw new Exception("Hover text did not match the expected value.");
			}

		} catch (Exception e) {
			// Throw a meaningful exception indicating what failed.
			throw new Exception("Failed to verify the hover text on the 'Sign Out' module: " + e.getMessage(), e);
		}
	}
	
	/**
	 * @Test Case 4: Verify visibility and clickability of substore sub-modules
	 *
	 * @method verifySubstoreSubModule(Map<String, String> substoreExpectedData)
	 *
	 * @param substoreExpectedData A map containing expected substore information,
	 *                             such as:
	 *                             - "URL": expected Substore page URL (used for logging/verification context).
	 *
	 * @description 
	 * This method checks whether key sub-modules under the Substore section 
	 * (such as "Inventory" and "Pharmacy") are present, visible, and can be interacted with.
	 *
	 * @steps
	 * 1. Print the expected Substore URL for verification/debugging purposes.
	 * 2. Locate the "Inventory" sub-module element using its locator.
	 * 3. Locate the "Pharmacy" sub-module element using its locator.
	 * 4. Highlight and click on the "Inventory" sub-module to verify it is interactable.
	 * 5. Highlight and click on the "Pharmacy" sub-module to verify it is interactable.
	 *
	 * @return true if both sub-modules are successfully found and clicked without exceptions; false otherwise
	 *
	 * @throws Exception if any element is not found or an interaction fails during the process
	 *
	 * @author YAKSHA
	 */

	public boolean verifySubstoreSubModule(Map<String, String> substoreExpectedData) throws Exception {
		try {
			System.out.println("Substore Page URL: " + substoreExpectedData.get("URL"));

			// Find the Inventory and Pharmacy sub-modules
			WebElement inventorySubModule = commonEvents.findElement(getAnchorTagLocatorInventory);
			WebElement pharmacySubModule = commonEvents.findElement(getAnchorTagLocatorPharmacy);

			// Highlight and click on the Inventory sub-module
			commonEvents.highlight(inventorySubModule).click(inventorySubModule);

			// Highlight and click on the Pharmacy sub-module
			commonEvents.highlight(pharmacySubModule).click(pharmacySubModule);

			return true;
		} catch (Exception e) {
			throw new Exception("Failed to verify substore sub-modules due to: " + e.getMessage(), e);
		}
	}

	/**
	 * @Test Case 5: Verify the presence and visibility of sub-modules under the "Inventory" module
	 *
	 * @method subModulePresentInventory()
	 *
	 * @param None (The method specifically targets the "Inventory" module)
	 *
	 * @description 
	 * This method checks whether sub-modules under the "Inventory" section are present 
	 * and visible on the UI. It clicks the Inventory module, retrieves all related 
	 * sub-module elements, and verifies their visibility.
	 *
	 * @steps
	 * 1. Click on the "Inventory" module to expand or display its sub-modules.
	 * 2. Retrieve the list of sub-module WebElements using the defined locator.
	 * 3. If sub-modules are found:
	 *    - Iterate through each element and check if it is displayed.
	 *    - Log the visibility of each sub-module.
	 *    - Set the result flag to true if at least one is visible.
	 * 4. If no sub-modules are found, log the information for debugging.
	 *
	 * @return true if at least one sub-module is visible; false otherwise
	 *
	 * @throws Exception if elements cannot be located or any interaction fails during the process
	 *
	 * @author YAKSHA
	 */

	public boolean subModulePresentInventory() throws Exception {
		boolean areModulesDisplayed = false;
		try {
			// Click on the specified module
			commonEvents.click(getAnchorTagLocatorInventory);

			// Get the list of sub-module elements
			List<WebElement> subModuleElements = commonEvents.getWebElements(getSubModuleLocator);
			System.out.println("Sub-module count: " + subModuleElements.size());

			// Check if the sub-modules are displayed
			if (!subModuleElements.isEmpty()) {
				for (WebElement subModule : subModuleElements) {
					boolean isDisplayed = commonEvents.isDisplayed(subModule);
					System.out.println("Sub-module displayed: " + isDisplayed);
					areModulesDisplayed = areModulesDisplayed || isDisplayed;
				}
			} else {
				System.out.println("No sub-modules found under the specified module.");
			}

		} catch (Exception e) {
			throw new Exception("Failed to find elements: " + e.getMessage(), e);
		}
		return areModulesDisplayed;
	}

	/**
	 * @Test Case 6: Verify navigation between Inventory sub-modules
	 *
	 * @method verifyNavigationBetweenSubmodules()
	 *
	 * @param None
	 *
	 * @description 
	 * This method tests the navigation flow between multiple sub-modules under the 
	 * "Inventory" section of the application. It clicks on each sub-module sequentially 
	 * and validates successful navigation by checking URL fragments.
	 *
	 * @steps
	 * 1. Click on the "Inventory" main module to ensure sub-modules are visible.
	 * 2. Navigate to the following sub-modules, validating the URL after each:
	 *    - Stock → URL should contain "Inventory/Stock"
	 *    - Inventory Requisition → URL should contain "Inventory/InventoryRequisitionList"
	 *    - Consumption → URL should contain "Inventory/Consumption/ConsumptionList"
	 *    - Reports → URL should contain "Inventory/Reports"
	 *    - Patient Consumption → URL should contain "Inventory/PatientConsumption/PatientConsumptionList"
	 *    - Return → URL should contain "Inventory/Return"
	 * 3. Navigate back to "Stock" to complete the flow.
	 *
	 * @return true if all sub-module navigations and URL verifications are successful; 
	 *         false otherwise
	 *
	 * @throws Exception if any navigation or URL validation fails
	 *
	 * @author YAKSHA
	 */

	public boolean verifyNavigationBetweenSubmodules() throws Exception {
		try {
			// Clicking on the "Inventory" submodule to start navigation.
			commonEvents.click(getAnchorTagLocatorInventory);

			// Navigating to the "Stock" submodule and waiting for the URL to update.
			commonEvents.click(getAnchorTagLocatorStock);
			commonEvents.waitForUrlContains("Inventory/Stock", 5000);

			// Navigating to the "Inventory Requisition" submodule and waiting for the URL
			// to update.
			commonEvents.click(getAnchorTagLocatorByTextInventoryRequisition);
			commonEvents.waitForUrlContains("Inventory/InventoryRequisitionList", 5000);

			// Navigating to the "Consumption" submodule and waiting for the URL to update.
			commonEvents.click(getAnchorTagLocatorConsumption);
			commonEvents.waitForUrlContains("Inventory/Consumption/ConsumptionList", 5000);

			// Navigating to the "Reports" submodule and waiting for the URL to update.
			commonEvents.click(getAnchorTagLocatorReports);
			commonEvents.waitForUrlContains("Inventory/Reports", 5000);

			// Navigating to the "Patient Consumption" submodule and waiting for the URL to
			// update.
			commonEvents.click(getAnchorTagLocatorPatientConsumption);
			commonEvents.waitForUrlContains("Inventory/PatientConsumption/PatientConsumptionList", 5000);

			// Navigating to the "Return" submodule and waiting for the URL to update.
			commonEvents.click(getAnchorTagLocatorReturn);
			commonEvents.waitForUrlContains("Inventory/Return", 5000);

			// Finally, navigating back to the "Stock" submodule.
			commonEvents.click(getAnchorTagLocatorStock);

			// Return true if all navigations are successful.
			return true;
		} catch (Exception e) {
			// Throwing the exception if any issue occurs during navigation.
			throw e;
		}
	}
	
	/**
	 * @Test Case 7: Capture a screenshot of the current page
	 *
	 * @method takingScreenshotOfTheCurrentPage()
	 *
	 * @param None
	 *
	 * @description 
	 * This method captures a screenshot of the current page during test execution. 
	 * The screenshot is saved with the label "SubStore", which can help in debugging, 
	 * reporting, or documentation of test steps.
	 *
	 * @steps
	 * 1. Invoke the utility method to take a screenshot of the current browser view.
	 * 2. Save the screenshot with the filename or identifier "SubStore".
	 * 3. Set the status flag to true if the operation completes successfully.
	 *
	 * @return true if the screenshot is taken and saved successfully; false otherwise
	 *
	 * @throws Exception if any error occurs during the screenshot capture process
	 *
	 * @author YAKSHA
	 */

	public Boolean takingScreenshotOfTheCurrentPage() throws Exception {
		boolean isDisplayed = false;
		try {
			commonEvents.takeScreenshot("SubStore");
			isDisplayed = true;

		} catch (Exception e) {
			throw e;
		}
		return isDisplayed;
	}

	/**
	 * @Test Case 8: Verify the visibility of UI components on the Inventory Requisition page
	 *
	 * @method verifyIfInventoryReqInputFieldsDropdownsAndCheckboxesAreVisibleOrNot()
	 *
	 * @param None
	 *
	 * @description 
	 * This method checks whether all critical UI elements such as buttons, input fields, 
	 * dropdowns, radio buttons, and icons are visible on the Inventory Requisition page. 
	 * If any of these elements are not displayed, the test fails with a descriptive message.
	 *
	 * @steps
	 * 1. Click on the "Inventory Requisition" sub-module.
	 * 2. Wait for the page to load by verifying the URL.
	 * 3. Locate the following UI elements:
	 *    - Navigation buttons: First, Previous, Next, Last
	 *    - Action buttons: OK, Create Requisition
	 *    - Input field: Search bar
	 *    - Icon: Star icon
	 *    - Radio buttons: Pending, Complete, Cancelled, Withdrawn, All
	 * 4. Highlight each element and verify it is displayed on the page.
	 * 5. If any element is not visible, throw an exception with the element name/text.
	 *
	 * @return true if all listed UI components are visible; false otherwise
	 *
	 * @throws Exception if any UI component is not found or not visible on the page
	 *
	 * @author YAKSHA
	 */

	public boolean verifyIfInventoryReqInputFieldsDropdownsAndCheckboxesAreVisibleOrNot() throws Exception {
		boolean areAllFieldsDisplayed = false;
		try {
			commonEvents.click(getAnchorTagLocatorByText("Inventory Requisition"));
			commonEvents.waitForUrlContains("Inventory/InventoryRequisitionList", 5000);

			WebElement firstButton = commonEvents.findElement(getButtonLocatorFirst);
			WebElement previousButton = commonEvents.findElement(getButtonLocatorPrevious);
			WebElement nextButton = commonEvents.findElement(getButtonLocatorNext);
			WebElement lastButton = commonEvents.findElement(getButtonLocatorLast);
			WebElement okButton = commonEvents.findElement(getButtonLocatorOK);
			WebElement createReqButton = commonEvents.findElement(getCreateRequisitionButton);
			WebElement searchBarId = commonEvents.findElement(searchBarId());
			WebElement starIconLocator = commonEvents.findElement(getStarIconLocator);
			WebElement pendingRadiobtn = commonEvents.findElement(getRadioButtonLocatorPending);
			WebElement completeRadiobtn = commonEvents.findElement(getRadioButtonLocatorComplete);
			WebElement cancelledRadiobtn = commonEvents.findElement(getRadioButtonLocatorCancelled);
			WebElement withdrawnRadiobtn = commonEvents.findElement(getRadioButtonLocatorWithdrawn);
			WebElement allRadiobtn = commonEvents.findElement(getRadioButtonLocatorAll);

			List<WebElement> options = Arrays.asList(firstButton, previousButton, nextButton, lastButton, okButton,
					searchBarId, createReqButton, starIconLocator, pendingRadiobtn, completeRadiobtn, cancelledRadiobtn,
					withdrawnRadiobtn, allRadiobtn);

			for (int i = 0; i < options.size(); i++) {
				WebElement option = options.get(i);
				commonEvents.highlight(option);
				if (!option.isDisplayed()) {
					areAllFieldsDisplayed = false;
					throw new Exception("Visibility check failed for: " + option.getText());
				}
			}
			areAllFieldsDisplayed = true;
		} catch (Exception e) {
			// Throw an exception with a meaningful message if any UI component is not found
			throw new Exception("Failed to verify if all fields are displayed!", e);
		}
		// Return the result of the visibility check
		return areAllFieldsDisplayed;
	}

	/**
	 * @Test Case 9: Verify functionality of the Create Requisition button
	 *
	 * @method verifyCreateRequisitionButton()
	 *
	 * @param None
	 *
	 * @description
	 * This method tests the flow of creating a new requisition in the Inventory Requisition module.
	 * It performs the following steps:
	 * 1. Clicks the "Create Requisition" button and waits for the navigation to the requisition item page.
	 * 2. Waits for the "Request" button to be visible.
	 * 3. Fills in the target inventory field with "General-Inventory" and navigates through the form.
	 * 4. Selects an item by entering the item name "tissue" and confirms selection.
	 * 5. Enters the required quantity as "5".
	 * 6. Clicks the "Request" button to submit the requisition.
	 * 7. Verifies the success message "Requisition is Generated and Saved".
	 * 8. Closes the confirmation popup and the requisition modal.
	 *
	 * @return String containing the success message displayed after creating the requisition.
	 *
	 * @throws Exception if any step fails during the requisition creation process, with a descriptive error message.
	 *
	 * @author YAKSHA
	 */

	public String verifyCreateRequisitionButton() throws Exception {
		String requisitionSuccessMessage = "";
		try {
			// Locate and click the "Create Requisition" button.
			WebElement createReqButton = commonEvents.findElement(getCreateRequisitionButton);
			commonEvents.highlight(createReqButton).click(createReqButton);

			// Wait for the URL to contain the expected path after clicking the button.
			commonEvents.waitForUrlContains("Inventory/InventoryRequisitionItem", 5000);

			// Locate and wait for the "Request" button to be visible.
			WebElement requestButton = commonEvents.findElement(getRequestButton);
			commonEvents.waitTillElementVisible(requestButton, 10000);

			// Fill in the target inventory field.
			commonEvents.click(getTargetInventory).sendKeys(getTargetInventory, "General-Inventory")
					.sendKeys(getTargetInventory, Keys.TAB).sendKeys(getTargetInventory, Keys.TAB);

			// Locate the item name field, highlight it, and enter the item name.
			WebElement itemName = driver.findElement(getItemName);
			commonEvents.highlight(itemName);
			commonEvents.sendKeys(itemName, "tissue").sendKeys(itemName, Keys.ENTER);

			// Locate the required quantity field, highlight it, and enter the quantity.
			WebElement requiredQuantity = driver.findElement(getRequiredQuantity);
			commonEvents.highlight(requiredQuantity);
			commonEvents.sendKeys(requiredQuantity, "5");

			// Click the "Request" button after highlighting it.
			commonEvents.highlight(requestButton).click(requestButton);

			// Verify the success message after creating the requisition.
			WebElement element = commonEvents
					.findElement(getPopUpMessageText("success", "Requisition is Generated and Saved"));
			requisitionSuccessMessage = element.getText();
			System.out.println("Actual Success Message: " + requisitionSuccessMessage);

			// Close the popup and the requisition modal.
			commonEvents.click(popupCloseButton);
			commonEvents.click(getCloseModalLocator);

		} catch (Exception e) {
			// Throw a meaningful exception with details on what failed.
			throw new Exception("Failed to create requisition: " + e.getMessage(), e);
		}
		return requisitionSuccessMessage;
	}

}