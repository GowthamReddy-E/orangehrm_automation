package com.satwa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.satwa.utils.EventUtil;

public class PimPage extends EventUtil{

	private WebDriver driver;

	private static ThreadLocal<PimPage> threadLocal = new ThreadLocal<>();

	public static void set(PimPage pimPage) {
		threadLocal.set(pimPage);
	}

	public static PimPage get() {
		return threadLocal.get();
	}

	public PimPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[normalize-space()='Add Employee']")
	private WebElement btnAddEmployee;

	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")
	private WebElement txtEmpFirstName;

	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/input[1]")
	private WebElement txtEmpMiddleName;

	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]")
	private WebElement txtEmpLastName;

	@FindBy(xpath ="//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	private WebElement rdBtnCreateLogin;

	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement txtUserName;

	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement btnPasswd;

	@FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[4]/div[1]/div[2]/div[1]/div[2]/input[1]")
	private WebElement btnCnfrmPasswd;

	@FindBy(xpath ="//button[normalize-space()='Save']")
	private WebElement btnSave;

	public boolean isAddEmployeeMenuDisplayed() {
		return checkElementExists(btnAddEmployee);
	}

	public void clickOnAddEmp() {
		clickElement(btnAddEmployee);
	}

	public void enterEmpDetails(String empFirstName, String empMiddleName, String empLastName,String empUserName, String empPasswd,String empCnfrmPasswd) {
		enterValue(txtEmpFirstName,empFirstName );
		enterValue(txtEmpMiddleName,empMiddleName );
		enterValue(txtEmpLastName,empLastName );
		clickElement(rdBtnCreateLogin);
		enterValue(txtUserName,empUserName );
		enterValue(btnPasswd,empPasswd );
		enterValue(btnCnfrmPasswd,empCnfrmPasswd);
	}

	public void clickOnSave() {
		clickElement(btnSave);
	}
}
