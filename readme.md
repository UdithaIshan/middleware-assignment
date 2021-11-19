# SCS3203 Assignment

## Packaging and running the application

If you want to build an uber-jar, execute the following command:

    ./gradlew quarkusBuild --uber-jar

To run the application:

    java -jar build/petstore-runner.jar

The application can be also packaged using simple:

    ./gradlew build

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it is not an _??ber-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

## How to run using Docker

First build the application:

    ./gradlew build
    

Then, build the image with:

    docker build -f src/main/docker/Dockerfile.jvm -t quarkus/petstore .

Then run the container using:

    docker run -i --rm -p 8080:8080 quarkus/petstore


## How to run tests
     ./gradlew test

## Endpoints

Get all pets:

```
curl --location --request GET 'http://localhost:8080/v1/pets'
```

Get pet by id:
```
curl --location --request GET 'http://localhost:8080/v1/pets/1'
```

Add new pet:
```
curl --location --request POST 'http://localhost:8080/v1/pets' \
--header 'Content-Type: application/json' \
--data-raw '{
    "petAge": 2,
    "petName": "Banti",
    "petType": {
        "petType": "Dog"
    }
}'
```

Update a pet by id:
```
curl --location --request PUT 'http://localhost:8080/v1/pets/2' \
--header 'Content-Type: application/json' \
--data-raw '{
        "petAge": 8,
        "petName": "Brown",
        "petType": {
            "petType": "Dog"
        }
    }'
```

Delete a pet:
```
curl --location --request DELETE 'http://localhost:8080/v1/pets/2'
```

Get pet types:
    
    curl --location --request GET 'http://localhost:8080/v1/pets/types'

Add new pet type:

```
curl --location --request POST 'http://localhost:8080/v1/pets/types' \
--header 'Content-Type: application/json' \
--data-raw '{
    "petType": "Cat"
}'
```

Update pet type:

```
curl --location --request PUT 'http://localhost:8080/v1/pets/types/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "petType": "Male Dog"
}'
```

Delete pet type:

```
curl --location --request DELETE 'http://localhost:8080/v1/pets/types/1'
```
