Feature: Sales Force Edit Account

Scenario: Edit Account with positive credentials.

Given Launch browser and load the url
And Enter Username as 'gokul.sekar@testleaf.com'
And Enter Password as 'Leaf$123'
When Click Login
Then Verify Login is Successful
When Click on toggle menu button from the left corner
And Click view All
And Click Account
Given Search for the account name
When Click the dropdown icon and Select Edit
Given Select Type
And Select Industry
And Enter Billing Address as 'Pallikaranai - Chennai'
And Enter Shipping Address as 'Medavakkam - Chennai'
And Set Customer Priority
And Set SLA
And Set Active
And Enter Phone Number as '9876543210'
And Set Upsell Opportunity
When Click SF Save
Then Verify Phone Number
Given Close SF Browser