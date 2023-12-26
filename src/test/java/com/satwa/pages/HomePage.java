package com.satwa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.satwa.utils.EventUtil;


public class HomePage extends EventUtil {


	private WebDriver driver;

	private static ThreadLocal<HomePage> threadLocal = new ThreadLocal<>();

	public static void set(HomePage homePage) {
		threadLocal.set(homePage);
	}

	public static HomePage get() {
		return threadLocal.get();
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	@FindBy(xpath = "//i[@class='oxd-icon bi-chevron-left']")
	private WebElement btnArrow;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")
	private WebElement btnPim;

	public boolean isPimMenuDisplayed() {
		return checkElementExists(btnPim);
	}

	public void clickOnPimMenu() {
		clickElement(btnPim);
	}
	
	public void clickOnArrowAndPimButton() {
		if (isPimMenuDisplayed()) {
			clickElement(btnPim);
		}else {
			clickElement(btnArrow);
			clickElement(btnPim);
		}
	}


}
