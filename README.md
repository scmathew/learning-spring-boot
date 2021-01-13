# Learning Spring Boot

Sample Spring Boot project created from a LinkedIn Learning course.

## Build
### Start Postgres DB via Docker
```bash
cd bin
./start_postgres.sh
```

### Start Spring Boot App
```bash
 mvn spring-boot:run
```

## Helpful Links
- https://start.spring.io/
- [LinkedIn Learning Course](https://www.linkedin.com/learning/learning-spring-with-spring-boot-2/solution-build-an-additional-repository?u=2079044)

## Side Exploration
To connect to postgres available to localhost on your machine from a spring boot app running in a container: 
In `application.properties` set `spring.datasource.url=jdbc:postgresql://host.docker.internal:5432/dev`  
*Note*: Once you make this change, it will no longer work when just running locally outside of a container

To start + run the docker Spring Boot Docker Container:
```bash
mvn clean package
docker build -t learning-spring .
docker run -p 8080:8080 -d learning-spring
```

For more on `host.docker.internal` check out this [Stack Overflow Post](https://stackoverflow.com/questions/24319662/from-inside-of-a-docker-container-how-do-i-connect-to-the-localhost-of-the-mach?page=1&tab=votes#tab-top)