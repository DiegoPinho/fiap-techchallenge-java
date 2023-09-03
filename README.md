# FIAP - Tech Challenge (Java)

## How to run

- You'll need a Postgres database.
- The script with all the tables needed is inside de `resources/` directory. Please, run it before start the application.
- Check the database configuration inside de `application.properties` file. You probably gonna have to change it.

## How it works

- For now, we don't have auth/sign, but, a admin user is created and all entities are related to it. On future version this will be used.
- Workflow:

  - Create an address.
  - Create a person and vinculate to an address.
    - You can create relationship between those people.
  - Create a home appliance. It'll be associated with an address.
  - Create a consumption.

## API Documentation

- This project includes a thunder-collection file that can be used with ThunderClient to test this API.

## Health

`GET /health`
Checks if the API is ok.

## Addresses

`GET /addresses`
Return all addressess.

`GET /addresses/:id`
Return an address based on the id.

`POST /addresses`
Creates a new address.

body (JSON):
```
{
  "street": String
  "number": Integer
  "string": String
  "city": String
  "state": String
}
```

`PUT /addresses/:id`
Updates a address based on the id.

body (JSON):
```
{
  "street": String
  "number": Integer
  "string": String
  "city": String
  "state": String
}
```

`DELETE /addresses/:id`
Deletes a address based on the id. You can't delete an address in use.

## People

`GET /people`
Return all people.

`GET /people/:id`
Return a person based on the id.

`POST /people`
Creates a new person.

body (JSON):
```
{
  "name": String
  "birthDate": "yyyy-MM-dd",
  "gender": "MALE | FEMALE | NON_BINARY",
  "addressId": Integer
}
```

`POST  /relationships`
Creates a relationship beetween two people.

body (JSON):
```
{
  "personId": Integer
  "relativeId": Integer,
  "relation": String
}
```

`PUT /people/:id`
Updates a person based on the id.

body (JSON):
```
{
  "name": String
  "birthDate": "yyyy-MM-dd",
  "gender": "MALE | FEMALE | NON_BINARY",
  "addressId": Integer
}
```

`DELETE /people/:id`
Deletes a person based on the id. You can't delete a person in use.

## Home Appliance

`GET /appliances`
Return all home appliances.

`GET /appliances/:id`
Return a home appliance based on the id.

`POST /appliances`
Creates a new home appliance.

body (JSON):
```
{
  "name": String
  "model": String
  "power": Integer
  "manufacturer": String
  "voltage": Integer
  "addressId": Long
}
```

`PUT /appliances/:id`
Updates a home appliance based on the id.

body (JSON):
```
{
  "name": String
  "model": String
  "power": Integer
  "manufacturer": String
  "voltage": Integer
  "addressId": Long
}
```

`DELETE /appliances/:id`
Deletes a home appliance based on the id.