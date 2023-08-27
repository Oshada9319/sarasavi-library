# sarasavi-library
A backend application for book library of Sarasavi

# How to use this code?

1. Make sure you have [Java 17](https://www.java.com/download/) and [Maven](https://maven.apache.org) installed

2. Fork this repository and clone it

```
$ git clone https://github.com/Oshada9319/sarasavi-library.git
```

3. Navigate into the folder

```
$ cd sarasavi-library
```

4. Install dependencies

```
$ mvn install
```

5. Run the project

```
$ mvn spring-boot:run
```

6. Make a GET request to `api/v1/book/getAllBooks` to check you're not authenticated. You should receive a response with a `403` with an `Access Denied` message since you haven't set your valid JWT token yet

```
$ curl -X GET http://localhost:8080/api/v1/book/getAllBooks
```

7. Make a POST request to `api/v1/auth/register` with the default user we programatically created to get a valid JWT token
```javascript
{
    "firstName": "Oshada",
    "lastName": "Maheeshan",
    "email" : "oshadamahee@gmail.com",
    "password" : "oshada1234@#44rf"
}
```
```
$ curl -X POST 'http://localhost:8080/api/v1/auth/register'
```

8. Make a POST request to `api/v1/auth/authenticate` to authenticate above created user
```javascript
{
    "email" : "oshadamahee@gmail.com",
    "password" : "oshada1234@#44rf"
}
```
```
$ curl -X POST 'http://localhost:8080/api/v1/auth/authenticate'
```

9. Add the JWT token as a Header parameter and make the initial GET request to `/api/v1/book/getAllBooks` again

```
$ curl -X GET http://localhost:8080/api/v1/book/getAllBooks -H 'Authorization: Bearer <JWT_TOKEN>'
```

10. And that's it, congrats! You should get a similar response to this one, meaning that you're now authenticated

```javascript
[
    {
        "id": 1,
        "bookId": "#67632e7",
        "title": "Harry Potter and the Philosopher's Stone",
        "author": "J. K. Rowling",
        "borrowed": false
    },
    {
        "id": 2,
        "bookId": "#17232d9",
        "title": "Harry Potter and the Chamber of Secrets",
        "author": "J. K. Rowling",
        "borrowed": false
    }
]
```

