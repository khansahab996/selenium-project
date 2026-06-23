package org.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(className = "inventory_details_name")
    private WebElement productName;

    @FindBy(className = "inventory_details_desc")
    private WebElement productDescription;

    @FindBy (className = "inventory_details_price")
    private WebElement productPrice;

    @FindBy(css = "button[data-test=\"add-to-cart\"]")
    private WebElement addToCartButton;

    @FindBy (css = "button[data-test=\"remove\"]")
    private WebElement removeButton;

    @FindBy(id = "back-to-products")
    private WebElement backButton;

    public ProductPage (){
        super();
    }

    //returns the product name
    public String getProductName(){
        return getText(productName);
    }

    //return the description
    public String getProductDescription(){
        return getText(productDescription);
    }

    //get product price
    public String getProductPrice(){
        return getText(productPrice);
    }

    //click add to cart
    public void addToCart(){
        click(addToCartButton);
    }

    // click remove button
    public  void removeButton(){
        click(removeButton);
    }

    // is remove button displayed
    public boolean isRemoveButtonDisplayed(){
        return isDisplayed(removeButton);
    }


    // click back button
    public void goBackToHomePage(){
        click(backButton);

    }


    
}
