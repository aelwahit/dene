import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class APIRestAssuredGet {
/*
Test Case
When I send a get request to REST http://54.173.111.76:1000/ords/hr/countries/US
Then response status should be 200
 */

    @Test
    public void simpleGet(){
 // io.restassured.RestAssured.when()    --> it is too long and we started to use import static

                    when()
                    .get("http://54.173.111.76:1000/ords/hr/employees")
                    .then().statusCode(200);
    }
        @Test()
      public void printResponse(){
                when()
                .get("http://54.173.111.76:1000/ords/hr/countries")
               .andReturn().body().prettyPrint();

      }

      public void getWithHeaders(){
                   with().accept(ContentType.JSON)
                   .when().get("http://54.173.111.76:1000/ords/hr/countries/US")
                  .then().statusCode(200);
      }
      }



}
