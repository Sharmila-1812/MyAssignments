Feature: Sales Force Create Account

Scenario Outline: Create Account with positive credentials.

Given Launch browser and load the url
And Enter Username as 'gokul.sekar@testleaf.com'
And Enter Password as 'Leaf$123'
When Click Login
Then Verify Login is Successful
When Click on toggle menu button from the left corner
And Click view All
And  Click Sales from App Launcher
And Click on Accounts Tab
And Click on New button
Given Enter Account Name as <AccName>
And Select Ownership
When Click Save
Then Verify Account Name
Given Close Browser

Examples:
|AccName|
|Sharmila|
|Sanvi|