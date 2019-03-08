package com.aqacourses.project.tests;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.pages.*;
import com.aqacourses.project.utils.Categories;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingCartTest extends BaseTest {

    /**
     * Open site and click on the "Sign in" link, fill in email and password to login form and click
     * on the "Sign in" button. Proceed to T-Shirts page and open product, verify breadcrumb and add
     * product to shopping cart and proceed to checkout. Increase quantity of product by one and
     * check that total price is increased by the price of product. Delete the product and verify
     * message
     */
    private HomePage homePage;

    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private TShirtsPage tShirtsPage;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;

    // Open site
    @Given("The user opens site sees Home Page")
    public void theUserOpensSiteSeesHomePage() {
        homePage = openSite();
        log("Opened site");
    }
    // Click on the "Sign in" link
    @When("User clicks Sign in link he sees Login Page")
    public void userClicksSignInLinkHeSeesLoginPage() {
        loginPage = homePage.clickSignInLink();
        log("Clicked on the \"Sign in\" link");
    }
    // Fill in email and password to login form and click on the "Sign in" button
    @When("User fills in email and password to login form and clicks on the \"Sign in\" button")
    public void userFillsInEmailAndPasswordToLoginFormAndClicksOnTheSignInButton() {
        myAccountPage = loginPage.login();
        log("Filled in email and password to login form and clicked on the \"Sign in\" button");
    }
    // Open TShirtsPage
    @When("User clicks on TShirts Button")
    public void userClicksOnTShirtsButton() {
        tShirtsPage = myAccountPage.openTShirtsPage();
        log("Opened TShirtsPage");
    }
    // Open the product
    @When("User clicks on product")
    public void userClicksOnProduct() {
        productPage = tShirtsPage.openProductByTitle("Faded Short Sleeve T-shirts");
        log("Opened product");
    }
    // Verify breadcrumb
    @Then("User verifies breadcrumb")
    public void userVerifiesBreadcrumb() {
        productPage.verifyBreadcrumb(
                Categories.WOMEN.toString() + ">" + Categories.TOPS + ">" + Categories.TSHIRTS);
        log("Verified breadcrumb");
    }

    // Add product to shopping cart and proceed to checkout
    @When("User clicks on add to cart button and then clicks on proceed to checkout button")
    public void userClicksOnAddToCartButtonAndThenClicksOnProceedToCheckoutButton() {
        shoppingCartPage = productPage.addProductToShoppingCartAndProceedToCheckout();
        log("Added product to shopping cart and proceeded to checkout");
    }
    // Increase quantity of product by one
    @When("User clicks on plus button to increase quantity of product by one")
    public void UserClicksOnPlusButtonToIncreaseQuantityOfProductByOne() {
        shoppingCartPage.increaseQuantityOfProductByOne();
        log("Increased quantity of product by one");
    }
    // Validate total price
    @Then("User validates the total price")
    public void userValidatesTheTotalPrice() {
        shoppingCartPage.validateTotalPrice();
        log("Validated total price");
    }
    // Delete product and verify that message is displayed
    @When("User deletes product and verifies that correct message is displayed")
    public void userDeletesProductAndVerifiesThatCorrectMessageIsDisplayed() {
        shoppingCartPage.deleteProduct();
        log("Deleted product and verified that message is displayed");
    }
    // Close browser
    @And("User closes browser")
    public void userClosesBrowser() {
        closeSite();
        log("Closed site");
    }
}
