Feature: Flipcart shopping details

Scenario Outline: User verifies mobile searching and add to cart
Given The user is on amazon search page
When The user search "<mobiles>"
And The user add to cart  
Then The user verifies the mobile in cart

Examples:
|mobiles|
|Samsung|
|Lenovo|

