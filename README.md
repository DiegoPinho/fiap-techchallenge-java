# FIAP - Tech Challenge (Java)

## API Documentation

## Health

`GET /health`
Checks if the API is ok.

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
}
```

`DELETE /appliances/:id`
Deletes a home appliance based on the id.

## Addresses

`GET /addresses`
Return all addressess.

`GET /addresses/:id`
Return a address based on the id.

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
Deletes a address based on the id.