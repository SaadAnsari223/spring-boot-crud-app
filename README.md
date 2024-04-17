# spring-boot-crud-app
spring-boot-crud-app

Create 
POST  http://localhost:8080/api/product
{
    "name": "prod",
    "description": "prod description ",
    "price": 1.5
}

validation 
{
    "name": "",
    "description": "",
    "price": 0.01
}
output 
{
    "price": "Price must be greater than 0.5",
    "name": "must not be empty",
    "description": "must not be empty"
}

Fetch
All 
GET http://localhost:8080/api/product

{
    "success": true,
    "message": "SUCCESS",
    "data": [
        {
            "id": 5,
            "name": "prod1",
            "description": "prod1",
            "price": 110.00
        },
        {
            "id": 6,
            "name": "prod2",
            "description": "prod2",
            "price": 0.01
        }
      ]
}

fetch 1 
GET http://localhost:8080/api/product/5
{
    "success": true,
    "message": "SUCCESS",
    "data": [
        {
            "id": 5,
            "name": "prod1",
            "description": "prod1",
            "price": 110.00
        }
      ]
}

Update 

PUT http://localhost:8080/api/product/5
req body 
{
    "name": "prod6",
    "description": "prod6",
    "price": 110.00
}

Delete

Delete http://localhost:8080/api/product/5

