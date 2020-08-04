Feature: Validate Place API

Scenario Outline: Verify place is being Sucessfully added using AddPlaceAPI
Given Add Place Payload with "<language>" "<name>" "<address>"
When User calls "AddPlaceApi" API with Post http request
Then The Api call is success with response coe as 200
And The response body "scope" is "APP"
And The response body "status" is "OK"

Examples: 
		  |language|name |address    |
		  |Hindi   |sovit|CDA cuttack|	
		  |English |leo  |bangalore  |