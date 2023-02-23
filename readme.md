# Everything About Java

This project is everything about Java we will try to include most of the production line settings.
All the features are more like proof of concept. This is just for learning purposes.

### Features

- [ ] Spring WebSecurity
- [ ] Error Handling
- [ ] Logging
- [x] Postman
- [x] Docker
- [x] GitHub Actions
- [x] Dependabot for security
- [x] Code Coverage
- [ ] GitHub Badges
- [x] Use LocalStack for AWS
- [ ] Automated Changelog
- [ ] Dev Docs, Production Team Docs, User Docs
- [ ] Spring Reactive Database
- [ ] Spring Reactive WebAPI
- [ ] Monitoring
- [ ] Tracing in Distributed System
- [ ] Resilience
- [ ] Feature Flag in Spring Boot

### Existing Stack Info

1. Java 19
2. Spring React Starter 3.0.2
3. Amazon DyanamoDB

### Installation

DynamoDb Tables

```
aws dynamodb --endpoint-url=http://localhost:4566 create-table \
--table-name Student \
--attribute-definitions \
AttributeName=student_roll_no,AttributeType=S \
--key-schema \
AttributeName=student_roll_no,KeyType=HASH \
--provisioned-throughput \
ReadCapacityUnits=10,WriteCapacityUnits=5
```

### Running

1. Run Docker Compose file

### Deleting AWS Tables

```
aws dynamodb --endpoint-url=http://localhost:4566 delete-table --table-name Student
```
