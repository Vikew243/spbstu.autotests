import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class RestAsuuredTests {

    @Test
    public void Test(){
        /*Response response1 =
                given()
                        //.log().all()
                        .when()
                        .get("http://httpbin.org/get?a=1")
                        .then()
                        //.log().all()
                        .statusCode(200)
                        .body("headers.Connection", equalTo("close"))
                        .body("args.a", equalTo("1"))
                        .extract()
                        .response();

        response1.getBody().print();*/
        Response response = get("https://api.vk.com/method/users.get?user_ids=76229304&fields=bdate&access_token=4592952e05c8d82268e37e0141180392de6065dd40ae03f6be5289bc9cc3096b621cfb9e06cc778e3b03a&v=5.103");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(200, response.statusCode());

    }

}
