# Welcome to React

This project is a benchmark for most of the best practices one should follow when active development is in progress. Few
things are more like an experiment with new features and checking compatibility.

### Installation

#### Dev

- [Java 19](https://www.oracle.com/java/technologies/downloads/)
- [Docker](https://www.docker.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html)

### Run Project

Build maven project locally

````
mvn clean verify
````

Make sure you clean the project before running docker compose.

````
docker-compose -f ./ReactCRUD/docker-compose-services.yml up -d
````

### Contribute to the Project

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

