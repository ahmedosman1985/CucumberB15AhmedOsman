package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

   String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
   String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUxOTk2MzgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTI0MjgzOCwidXNlcklkIjoiNTIzNSJ9.nZZYMxpeou8gqqgcA3a7ULBA8919o87PUn4cWc7J7VU";
   static String employee_id;

   @Test
   public void bgetCreatedEmployee(){
      RequestSpecification preparedRequest = given().
              header("Content-Type" , "application/json").
              header("Authorization" , token).
              queryParam("employee_id", employee_id);

      //hitting the endpoint
      Response response = preparedRequest.when().get("/getOneEmployee.php");
      response.prettyPrint();

      //verify the response
      response.then().assertThat().statusCode(200);
      String tempEmpId = response.jsonPath().getString("employee.employee_id");
   }
   @Test
   public void acreateEmployee(){
      //prepare the request
      RequestSpecification preparedRequest = given().
              header("Content-Type", "application/json").
              header("Authorization" , token).body("{\n" +
                      "  \"emp_firstname\": \"Ahmed\",\n" +
                      "  \"emp_lastname\": \"Osman\",\n" +
                      "  \"emp_middle_name\": \"Mosaad Mohamed\",\n" +
                      "  \"emp_gender\": \"M\",\n" +
                      "  \"emp_birthday\": \"1985-04-29\",\n" +
                      "  \"emp_status\": \"Confirmed\",\n" +
                      "  \"emp_job_title\": \"Engineer\"\n" +
                      "}");
      //hitting the endpoint
      Response response = preparedRequest.when().post("/createEmployee.php");

      //it will print the output in the console
      response.prettyPrint();

      //verifying the assertions/get response
      response.then().assertThat().statusCode(201);

      //we are capturing employee id from the response
      employee_id = response.jsonPath().getString("Employee.employee_id");
      System.out.println(employee_id);

      //verifying the firstname in the response body
      response.then().assertThat().body("Employee.emp_firstname" , equalTo("Ahmed"));
      response.then().assertThat().body("Employee.emp_lastname" , equalTo("Osman"));

      //it will print the output in the console
      response.prettyPrint();

      //verify the response headers
      response.then().assertThat().header("Content-Type","application/json");
      System.out.println("My test case is passed");
   }
   //in homework, create a method to get all emoloyee status and job title
   @Test
   public void cupdateEmployee(){
      RequestSpecification preparedRequest = given().
              header("Content-Type","application/json").
              header("Authorization", token).body("{\n" +
                      "  \"employee_id\": \""+employee_id+"\",\n" +
                      "  \"emp_firstname\": \"Ahmed\",\n" +
                      "  \"emp_lastname\": \"Osman\",\n" +
                      "  \"emp_middle_name\": \"msa\",\n" +
                      "  \"emp_gender\": \"M\",\n" +
                      "  \"emp_birthday\": \"1985-04-29\",\n" +
                      "  \"emp_status\": \"probation\",\n" +
                      "  \"emp_job_title\": \"CEO\"\n" +
                      "}");

      //hitting the endpoint
      Response response = preparedRequest.when().put("/updateEmployee.php");
      response.then().assertThat().statusCode(200);
      //for verification
      response.then().assertThat().body("Message", equalTo("Employee record Updated"));
   }

}
