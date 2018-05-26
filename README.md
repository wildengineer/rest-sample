# rest-sample

This is a simple REST service to provide an API to a database of people.

The only endpoint currently implemented is: `GET /people`

	curl http://localhost:8080/people

Implement an appropriate API to allow a client application to:

- read a single person (by id)
- create an additional person
- update a person
- delete a person

Follow the pattern used by the existing endpoint, using the existing 
`PersonResource` resource class.

When creating or updating a person:

- return the new person object as JSON
- if the id is invalid, return a status of 404
- the person object should be provided as JSON to the endpoint

When reading a person:

- if the id is valid, return a status of 200 and the content as JSON
- if the id is invalid, return a status of 404

When deleting a person:

- if the id is valid, return a status of 204
- if the id is invalid, return a status of 404
