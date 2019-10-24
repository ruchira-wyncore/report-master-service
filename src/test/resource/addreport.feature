Feature:This is a feature file for doing database related operation on Report Master Table

Scenario:Add a record in report master table
Given A running restful controller application
When A post request is received to add a new valid record in the table
Then the record is added
And the record data is sent back


