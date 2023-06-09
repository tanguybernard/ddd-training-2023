Feature: Create Intervetion

Scenario: Create an intervention with a clinic ID and a carrier ID
Given an intervention API

When a user creates an intervention with clinicId "c123" and transpoteurID "t1234"
Then the HTTP response is 201
And in the body we get an id
And the intervention with ID is saved in the database
