Feature: This is a feature file for updating a record in  Report Master Table

Scenario: Update a record successfully in report master table based on report name
Given A running restful controller application
When A post request is received to add a new valid record in the table
Then the record is added
And the record data is sent back
When An update request is received to update an existing record in the table
Then the record is updated.


Scenario: Update a record fails in report master table as report name is not found
Given A running restful controller application
When A post request is received to add a new valid record in the table
Then the record is added
And the record data is sent back
When An update request is received to update a non existing record in the table
Then the record is not updated.

Scenario: Update a record fails in report master table as report name is not found
Given A running restful controller application
When A post request is received to add a new valid record in the table
Then the record is added
And the record data is sent back
When An update request is received to update a non existing record in the table
Then the record is not updated

Scenario: Update a record fails in report master table as saving to the database fails
# This scenario needs use of wiremock to simulated db failure and hence will be done later
# Given A running restful controller application
# When A post request is received to add a new valid record in the table
# Then the record is added
# And the record data is sent back
# When An update request is received to update an existing record in the table
# And the database save fails
# Then the record is not updated