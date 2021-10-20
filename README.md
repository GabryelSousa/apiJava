## 📊 apiJava #
 Application for registration new characters.
 
 ## 🔐 API
* Application developed using Java with spring boot, for details of configuration and use can be found at: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/

 ## 🔥 Package #
 * [JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)
 * [SWAGGER](https://swagger.io/)

 ## ⚙️ Built with Amazing Tools #
* [JAVA](https://docs.oracle.com/en/java/) - Language compatible with multiple platforms and with many frameworks and documentation available on the internet.
* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot is an open source Java framework that aims to facilitate this process in Java applications..
* [IntelliJ](https://www.jetbrains.com/pt-br/idea/) - Code editing.


## ▶️ Starting #

To start the application and use it, you'll have to perform some configurations first.

1 - Using Docker () upload the server already configured, using the image located in the file: docker-compose.yaml

2 - Submit a request to the PotterAPI API to obtain an access key:

Method: POST
Host: http://us-central1-rh-challenges.cloudfunctions.net/potterApi/users
Body: {
"email": "YOUR_EMAIL_HERE",
"password": "SET_A_PASSWORD_HERE",
"name": "YOUR_NAME_HERE"
}

The callback will be your created user, following the following model:

{
   "user": {
     "email": "email",
     "password": "your encrypted password",
     "id": "id",
     "apiKey": "your apikey",
     "name": "name"
   }
}
Save your apiKey in a safe place, it will be used to communicate with the API.


After getting your APIKEY, inside the file: application.properties, define your API in the field: "api_key".

After that, just upload the application and perform the tests!
