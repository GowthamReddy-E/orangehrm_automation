package com.satwa.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static void constantWait(int millis) {
		
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			
		}
		
	}
	
	public WebElement waitForElementLocated(By by, int timeOut) {
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeOut));
			wait.pollingEvery(Duration.ofMillis(200));
			return wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch(Exception e) {
			System.out.println("Element could not be found with locator : " + by.toString()+ " even after waiting for "+ timeOut + " seconds.");
		}
		
		return null;	
	}
	
	public WebElement waitForElementLocated(By by) {
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(GlobalVariables.DEFAULT_EXPLICIT_WAIT));
			wait.pollingEvery(Duration.ofMillis(200));
			return wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch(Exception e) {
			System.out.println("Element could not be found with locator : " + by.toString()+ " even after waiting for "+ GlobalVariables.DEFAULT_EXPLICIT_WAIT + " seconds.");
		}
		
		return null;	
	}
	
	public boolean waitForElementToEnable(WebElement element) {
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(GlobalVariables.DEFAULT_EXPLICIT_WAIT));
			wait.pollingEvery(Duration.ofMillis(200));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch(Exception e) {
			System.out.println("Element: " + element.toString()+ " was not enabled even after waiting for "+ GlobalVariables.DEFAULT_EXPLICIT_WAIT + " seconds.");
		}
		
		return false;	
	}
	
	public boolean waitForElementToEnable(WebElement element, int timeOut) {
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeOut));
			wait.pollingEvery(Duration.ofMillis(200));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch(Exception e) {
			System.out.println("Element: " + element.toString()+ " was not enabled even after waiting for "+ timeOut + " seconds.");
		}
		
		return false;	
	}
	
	public boolean waitForElementToVisible(WebElement element, int timeOut) {
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeOut));
			wait.pollingEvery(Duration.ofMillis(200));
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch(Exception e) {
			System.out.println("Element: " + element.toString()+ " was not visible even after waiting for "+ timeOut + " seconds.");
		}
		
		return false;	
	}
	
	public boolean waitForElementToVisible(By by, int timeOut) {
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeOut));
			wait.pollingEvery(Duration.ofMillis(200));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch(Exception e) {
			System.out.println("Element: " + by.toString()+ " was not visible even after waiting for "+ GlobalVariables.DEFAULT_EXPLICIT_WAIT + " seconds.");
		}
		
		return false;	
	}
	
	

	public boolean waitForElementToVisible(WebElement element) {
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(GlobalVariables.DEFAULT_EXPLICIT_WAIT));
			wait.pollingEvery(Duration.ofMillis(200));
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch(Exception e) {
			System.out.println("Element: " + element.toString()+ " was not visible even after waiting for "+ GlobalVariables.DEFAULT_EXPLICIT_WAIT + " seconds.");
		}
		
		return false;	
	}
	
	public Alert switchToAlert() {
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(GlobalVariables.DEFAULT_EXPLICIT_WAIT));
			wait.pollingEvery(Duration.ofMillis(200));
			return wait.until(ExpectedConditions.alertIsPresent());
			
		} catch(Exception e) {
			System.out.println("ALert was not displayed even after waiting for "+ GlobalVariables.DEFAULT_EXPLICIT_WAIT + " seconds.");
		}
		
		return null;	
	}
	
	public Alert switchToAlert(int timeOut) {
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeOut));
			wait.pollingEvery(Duration.ofMillis(200));
			return wait.until(ExpectedConditions.alertIsPresent());
			
		} catch(Exception e) {
			System.out.println("ALert was not displayed even after waiting for "+ timeOut + " seconds.");
		}
		
		return null;	
	}

	public boolean waitForElementTextToBePresent(By by, String text, int timeOut) {
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeOut));
			wait.pollingEvery(Duration.ofMillis(200));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
			return true;
		} catch(Exception e) {
			System.out.println("wait for the text : " + text + " in the element  " + by.toString()+ " failed as the text did not come even after waiting for "+ timeOut + " seconds.");
		}
		
		return false;	
	}
	
	
	public boolean waitForElementTextToBePresent(WebElement element, String text, int timeOut) {
		
		try {
			WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeOut));
			wait.pollingEvery(Duration.ofMillis(200));
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			return true;
		} catch(Exception e) {
			System.out.println("wait for the text : " + text + " in the element  " + element.toString()+ " failed as the text did not come even after waiting for "+ timeOut + " seconds.");
		}
		
		return false;	
	}
}
