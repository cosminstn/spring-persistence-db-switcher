## About
This demo app is designed to be able to switch between a MongoDB persistence layer and a SQL persistence layer.
The database engine is determined automatically by the datasource configured in application.properties:
1. If spring.data.mongodb.database is present in application.properties then we're dealing with a MongoDB engine
2. Else if spring.datasource.url is present then we're dealing with a SQL engine.

TODOs:
[ ] - Currently the app is stoppping imediatelly after starting even with the Scheduled component being implemented
[ ] - It seems like neither repositories are being registered (but maybe they don't have time to be registerered)


Resources:
1. [https://www.baeldung.com/spring-component-scanning](https://www.baeldung.com/spring-component-scanning)
2. [https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa](https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa)