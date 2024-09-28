Run using postgres container
docker-compose -f docker-compose-local-db.yml run --service-ports employees-db

Run spring boot with dev profile
mvn clean spring-boot:run -Dspring-boot.run.profiles=dev

Run spring boot with arguments from application.yml
mvn clean spring-boot:run -Dspring-boot.run.arguments=--queue.name=iris-results-sqs-poc,--queue.region=us-west-2


References for complete CRUD operations w/ M2M and best practices

Code is based on this example (order by relevance)
https://hellokoding.com/jpa-many-to-many-relationship-mapping-example-with-spring-boot-maven-and-mysql
http://keenformatics.blogspot.com/2013/08/how-to-solve-json-infinite-recursion.html

https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/
https://vladmihalcea.com/a-beginners-guide-to-jpa-and-hibernate-cascade-types/
https://vladmihalcea.com/jpa-hibernate-synchronize-bidirectional-entity-associations/
https://www.javaworld.com/article/3387643/java-persistence-with-jpa-and-hibernate-part-2-many-to-many-relationships.html
https://www.baeldung.com/jpa-many-to-many

APIs tested after M2M relationship was added (No DTOs yet)
Employees
C -> by Id -> OK (even with DTO)
R by Id -> OK (even with DTO)
R All -> OK (even with DTO)
U -> Not implemented yet
U Assign certifications -> //In progress, just insert is working so far
D -> Not implemented yet

Certifications
C -> by Id -> OK (even with DTO)
R by Id -> OK
R All -> OK (even with DTO)
U -> Not implemented yet
D -> Not implemented yet

TODO in ISS-6:
EmployeeDto has to show the current Certifications that an employee might have 
Delete previous certifications before assigning new ones or updating them
Full implementation of DTOs in all controllers
Implement DTOProjection or manual transformations with mapstruct
