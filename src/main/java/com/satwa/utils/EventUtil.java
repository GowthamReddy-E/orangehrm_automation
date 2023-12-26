package com.satwa.utils;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.satwa.exceptions.CheckBoxCannotBeSelectedException;
import com.satwa.exceptions.ClickElementFailedException;
import com.satwa.exceptions.ElementValueCanNotBeSetException;
import com.satwa.exceptions.ValueInListBoxNotFoundException;

public class EventUtil extends WaitUtils{
	
	protected boolean checkElementExists(WebElement elem) {	
			return waitForElementToVisible(elem);
	}
	
	protected boolean checkElementExists(WebElement elem, int timeOut) {		
			return waitForElementToVisible(elem,timeOut);		
	}
	
	protected void clickElement(By by, int timeOut) {
		
		WebElement element = waitForElementLocated(by);
		if (element != null) {
			if (waitForElementToVisible(element, timeOut) 
					&& waitForElementToEnable(element, timeOut)) {
				element.click();
			}else {
				throw new ClickElementFailedException("Element " + by.toString()+" either not enabled or not visible. Unable to click on the element.");
			}
		} else {
			throw new ClickElementFailedException ("unable to click on the element as given element is not found with locator : " + by.toString());
		}
		
	}
	
	public void clickElement(By by) {
		
		WebElement element = waitForElementLocated(by);
		if (element != null) {
			if (waitForElementToVisible(element, GlobalVariables.DEFAULT_EXPLICIT_WAIT) 
					&& waitForElementToEnable(element, GlobalVariables.DEFAULT_EXPLICIT_WAIT)) {
				element.click();
			}else {
				throw new ClickElementFailedException("Element " + by.toString()+" either not enabled or not visible. Unable to click on the element.");
			}
		} else {
			throw new ClickElementFailedException ("unable to click on the element as given element is not found with locator : " + by.toString());
		}
		
	}
	
	public void clickElement(WebElement element) {
		
	
		if (element != null) {
			if (waitForElementToVisible(element, GlobalVariables.DEFAULT_EXPLICIT_WAIT) 
					&& waitForElementToEnable(element, GlobalVariables.DEFAULT_EXPLICIT_WAIT)) {
				element.click();
			}else {
				throw new ClickElementFailedException("Element " + element.toString()+" either not enabled or not visible. Unable to click on the element.");
			}
		} else {
			throw new ClickElementFailedException("unable to click on the element as given element is null.");
		}
		
	}


	public void jsClick(WebElement element) {
		
		
		if (element != null) {
			JavascriptExecutor js = (JavascriptExecutor)Driver.get();
			js.executeScript("arguments[0].click();", element);
		} else {
			throw new ClickElementFailedException ("unable to click on the element as given element is null.");
		}
	}
	
	public  void enterValueUsingJS(WebElement element, String value) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.get();
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "');", element);
    }
	
	public void enterValue(WebElement element, String valueToEnter) {
		
		
		if (element != null) {
			if (waitForElementToVisible(element, GlobalVariables.DEFAULT_EXPLICIT_WAIT) 
					&& waitForElementToEnable(element, GlobalVariables.DEFAULT_EXPLICIT_WAIT)) {
				element.sendKeys(valueToEnter);
			}else {
				throw new ElementValueCanNotBeSetException ("unable to enter the value : " +valueToEnter+" as the Element " + element.toString()+" either not enabled or not visible. Unable to click on the element.");
			}
		} else {
			throw new ElementValueCanNotBeSetException ("unable to enter the value " + valueToEnter+" on the element as given element is null.");
		}
		
	}
	
	public void selectCheckBox(WebElement element) {		
		
		if (element != null) {
			if (waitForElementToVisible(element, GlobalVariables.DEFAULT_EXPLICIT_WAIT) 
					&& waitForElementToEnable(element, GlobalVariables.DEFAULT_EXPLICIT_WAIT)) {
				if (!element.isSelected())
						element.click();
			}else {
				throw new CheckBoxCannotBeSelectedException("Element " + element.toString()+" either not enabled or not visible. Unable to click on the element.");
			}
		} else {
			throw new CheckBoxCannotBeSelectedException("unable to select the checkbox  as given element is null.");
		}
		
	}
	
	
	public boolean switchToWindow(String windowTitle) {
		boolean isWindowFound = false;
		Set<String> allHandles = Driver.get().getWindowHandles();
		
		for (String handle: allHandles) {
			Driver.get().switchTo().window(handle);
			if (Driver.get().getTitle().contains(windowTitle)) {
				isWindowFound = true;
				break;
			}
		}
		
		return isWindowFound;

	}
	
	public static void killProcesses() {
		String[] allProcesses = {"chrome.exe","firefox.exe","msedge.exe","chromedriver.exe","geckodriver.exe","msedgedriver.exe"};
		for (String process: allProcesses) {
			try {
				Runtime.getRuntime().exec("taskkill /F /IM "+ process);
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
	}
	
	public void selectValueFromList(WebElement listBox, String valueToSelect) throws ValueInListBoxNotFoundException  {
		boolean isOptionFound = false;
		clickElement(listBox);
		
		List<WebElement> allOptions = listBox.findElements(By.tagName("span"));
		
		for (WebElement optionElem: allOptions) {
			if (optionElem.getText().equalsIgnoreCase(valueToSelect)) {
				optionElem.click();
				isOptionFound = true;
				break;
			}
		}
		
		if (!isOptionFound) {
			throw new ValueInListBoxNotFoundException("given value : "+ valueToSelect+" could not be selected in the listbox "+ listBox.toString()+" as the value is not found in the list.");
		}
		
	}

}
