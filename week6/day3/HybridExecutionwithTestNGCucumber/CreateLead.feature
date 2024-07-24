Feature: Create Lead
Scenario: Lead Creation with positive credentials.

#Given Launch the browser and load the url
Given Enter the Username
And Enter the Password
When Click on Login
Then Verify the Login is Successful
When Click CRMSFA
And Click Leads Tab
And Click Create Lead Link
Given Enter the Company Name
And Enter the First Name
And Enter the Last Name
When Click Submit
Then Verify Create Lead is Successful
#Given Close the browser