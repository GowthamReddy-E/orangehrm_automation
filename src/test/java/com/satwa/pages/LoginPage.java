package com.satwa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.satwa.utils.EventUtil;
import com.satwa.utils.WaitUtils;

import freemarker.log.Logger;

public class LoginPage extends EventUtil {
	private WebDriver driver;

	private static ThreadLocal<LoginPage> threadLocal = new ThreadLocal<>();

	public static void set(LoginPage loginPage) {
		threadLocal.set(loginPage);
	}

	public static LoginPage get() {
		return threadLocal.get();
	}


	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement txtUserName;

	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]")
	private WebElement txtPassword;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement btnLogin;



	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	public boolean isLoginPageDisplayed() {
		return checkElementExists(txtUserName);
	}

	public void login(String userName, String passWord) {
		enterValue(txtUserName,userName );
		enterValue(txtPassword,passWord );
		WaitUtils.constantWait(1000);
		clickElement(btnLogin);
	}



}
