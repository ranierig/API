On this test, you will have to consume the github APIs.

The endpoints' documentation that you will use for this test are available at:
https://developer.github.com/v3/
https://developer.github.com/v3/users/
https://developer.github.com/v3/repos/

Create an API that will proxy all client requests to the appropriate GitHub endpoint.
The following endpoints must be provided:

GET - /api/users?since={number}
This endpoint must return a list of GitHub users and the link for the next page.

GET - /api/users/:username/details
This endpoint must return the details of a GitHub users

GET - /api/users/:username/repos
This endpoint must return a list with all user repositries




github.com/devsuperior/demo-openfeign
https://devsuperior.com.br/ijs-udemy-531282
