Feature: This is a feature file for deleting a record in  Report Master Table

Scenario: Delete a record in report master table based on report name
Given A running restful controller application
When A post request is received to add a new valid record in the table
Then the record is added
And the record data is sent back
When A delete request is received to delete an existing record in the table
Then the record is deleted


