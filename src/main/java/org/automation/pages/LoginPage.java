package org.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernamefield;

    @FindBy(id = "password")
    private WebElement passwordfield;

    @FindBy(id = "login-button")
    private WebElement loginbutton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement errorMessage;

    // constuctor calls basepage constuctor (which initializes pagefactory)
    public LoginPage(){
        super();
    }

    public void enterUsername(String username){
        type(usernamefield,username);
    }

    public void enterPassword(String password){
        type(passwordfield,password);

    }

    public void clickLogin(){
        click(loginbutton);

    }

    public void login(String username, String Password){
        enterUsername(username);
        enterPassword(Password);
        clickLogin();
    }

    public String geterrorMessage(){
        return getText(errorMessage);

    }

    public boolean iserrordisplayed(){
        return isDisplayed(errorMessage);
    }
    public boolean isloginsucessfull(){
        return getCurrentUrl().contains("inventory.html");

    }










}
