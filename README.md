# Ecommerce Test Interview

## HEROKU URL

https://ecommerce-interview-scerver.herokuapp.com/swagger-ui/

## Requirements

- Spring Framework & Spring Boot - Web Framework
- Gradle
- H2 database
- Java 11

## Build

1. Test your changes
```
$ ./gradlew test 
```

2. Build the project without Test
```
$ ./gradlew -x test build 
```

3. Build the project complete
```
$ ./gradlew build 
```

##Paths
- Swagger Documentation
```
{host}/swagger-ui/
```
- Health Check
```
{host}/
```

## Flyway
This project use ``Flyway`` for handle changes in the database.
in the ``db.migration`` folder.

The name of the script must have the following format:

``V[timestamp]__[description].sql``

Where:
* ``timestamp``: YYYYMMDDhhmm
* ``description``: a simple description

## Observations
* In a production environment I would make different ``application.properties (profiles)`` with each config using env var for credentials
* Into ``PricesController`` if we have many options about price response, I would implement graphql
* In the case that we have other DB sql or blocker tasks I would use reactive programming

## Contributors
- Sergio Cervera
