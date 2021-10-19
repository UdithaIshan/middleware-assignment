package org.acme;

import com.assignment.petstore.Pet;
import com.assignment.petstore.Type;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class PetResourceTest {

	@Test
    public void testAllPetsEndpoint() {
        given()
          .when().get("/v1/pets")
          .then()
             .statusCode(200);
    }

    @Test
    public void testPetsEndpoint() {
        given()
                .when().get("/v1/pets/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPetDeleteEndpoint() {
        given()
                .when().delete("/v1/pets/1")
                .then()
                .statusCode(200);
    }

//    @Test
//    public void testPetAddEndpoint() {
//        Pet pet = new Pet(new Type("Cat"), "Kitty", 1);
//        given()
//                .contentType(ContentType.JSON)
//                .body(pet)
//                .when()
//                .post("/v1/pets")
//                .then()
//                .statusCode(201);
//    }
//
//    @Test
//    public void testPetUpdateEndpoint() {
//        Pet pet = new Pet(new Type("Cat"), "Kitty", 1);
//        given()
//                .contentType(ContentType.JSON)
//                .body(pet)
//                .when()
//                .put("/v1/pets/1")
//                .then()
//                .statusCode(200);
//    }

}