# FIAP - Tech Challenge (Java)

## API Documentation

### Home Appliance

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