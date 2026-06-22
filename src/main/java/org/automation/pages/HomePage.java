package org.automation.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage{

    // Page title text ("Products")
    @FindBy(css = "span[data-test=\"title\"]")
    private WebElement pageTitle;

    // Shopping cart icon (top right)
    @FindBy(css ="a[data-test=\"shopping-cart-link\"]")
    private WebElement cartIcon;

    // Cart item count badge (red number on cart icon)
    @FindBy(css = "span[data-test=\"shopping-cart-badge\"]")
    private WebElement cartBadge;

    // Sort dropdown (Name A-Z, Price low-high, etc.)
    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    // All product names on the page
    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    // All "Add to cart" buttons
    @FindBy(className = "btn_primary")
    private List<WebElement> addToCartButtons;

    public HomePage() {
        super();
    }

    // Returns the page title text ("Products")
    public String getTitleText() {
        return getText(pageTitle);
    }

    // Clicks the cart icon
    public void clickCart() {
        click(cartIcon);
    }

    // Returns number of items in cart (from badge)
    public String getCartCount() {
        return isDisplayed(cartBadge) ? getText(cartBadge) : "0";
    }

    // Returns total number of products listed on page
    public int getProductCount() {
        return productNames.size();
    }

    // Returns list of all product names as text
    public List<String> getAllProductNames() {
        return productNames.stream()
                .map(WebElement::getText)
                .toList();
    }

    // Clicks "Add to cart" for a product by index (0 = first product)
    public void addProductToCartByIndex(int index) {

            click(addToCartButtons.get(index));


    }

    // Selects a sort option by visible text
    // e.g. "Name (A to Z)", "Price (low to high)"
    public void sortProductsBy(String visibleText) {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(visibleText);
    }
}