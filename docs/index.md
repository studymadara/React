# Welcome to React

This project is a benchmark for most of the best practices one should follow when active development is in progress. Few
things are more like an experiment with new features and checking compatibility.

### Getting Started as a Developer

### Contents

| File/folder                     | Description                           |
|---------------------------------|---------------------------------------|
| `.github\workflows`             | GitHub Actions pipeline.              |
| `docs`                          | Documentation                         |
| `src`                           | Java App                              |
| `.readthedocs.yml`              | AutoGenerating Readme file.           |
| `Dockerfile`                    | To run the app.                       |
| `React.postman_collection.json` | Postman collection of all the API's.  |
| `docker-compose-services.yml`   | The whole environment to run the app. |
| `mkdocs.yml`                    | Mkdocs config file.                   |
| `pom.xml`                       | Maven POM file.                       |
| `README.md`                     | README file.                          |

#### Prerequisites

- [Java 19](https://www.oracle.com/java/technologies/downloads/)
- [Docker](https://www.docker.com/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html)

#### Installation

1. Clone the repo

```
git clone https://github.com/studymadara/React.git
```

2. Build the project

```
mvn clean install
```

#### Run Project

Make sure you clean the project before running docker compose.

````
docker-compose -f ./ReactCRUD/docker-compose-services.yml up -d
````

### Contribute to the Project

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

