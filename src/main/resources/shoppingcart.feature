Feature: Customer uses site,
         As a Customer,
         I want to login,
         Add product to cart,
         Increase quantity of product by one
         And verify total price.
         Delete the product
         And verify message.

Scenario: Shopping cart
          Given The user opens site sees Home Page
          When User clicks Sign in link he sees Login Page
          When User fills in email 'mystore@mailinator.com' and password 'mystore' to login form and clicks on the "Sign in" button
          When User clicks on TShirts Button
          When User clicks on product 'Faded Short Sleeve T-shirts'
          Then User verifies breadcrumb. Breadcrumb is 'Women>Tops>T-shirts'
          When User clicks on add to cart button and then clicks on proceed to checkout button
          When User clicks on plus button to increase quantity of product by one
          Then User validates the total price
          When User deletes product and verifies that correct message is displayed. Message is 'Your shopping cart is empty.'
          And User closes browser