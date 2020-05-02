package Lab3;


import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.hasItem;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RequestTest {

    @Test
    public void userInfoTest(){
        when()
                .get("https://api.vk.com/method/users.get?user_ids=76229304&fields=bdate&access_token=4592952e05c8d82268e37e0141180392de6065dd40ae03f6be5289bc9cc3096b621cfb9e06cc778e3b03a&v=5.103")
                .then()
                .statusCode(200)
                .body("response.id", hasItem(76229304),
                        "response.first_name", hasItem("Таня"),
                        "response.last_name", hasItem("Викентьева"),
                        "response.is_closed", hasItem(false),
                        "response.bdate", hasItem("26.1.1998"));

    }


    Object[][] arr = new Object[1][1];

    @Test
    public void testUsersGet(){
        arr[0][0] = 6798;
        when()
                .get("https://api.vk.com/method/wall.get?owner_id=2179250&access_token=4592952e05c8d82268e37e0141180392de6065dd40ae03f6be5289bc9cc3096b621cfb9e06cc778e3b03a&count=1&v=5.103")
                .then()
                .statusCode(200)
                .body(
                        "response.items.id", hasItem(287),
                        "response.items.from_id", hasItem(2179250),
                        "response.items.owner_id", hasItem(2179250),
                        "response.items.post_type", hasItem("post"),
                        "response.items.date", hasItem(1587759317),
                        "response.count", equalTo(146),
                        "response.items.copy_history.id", hasItem(contains(6798)),
                        "response.items.copy_history.attachments.type", hasItem(hasItem(contains("photo"))),
                        "response.items.copy_history.attachments.photo.sizes.width", hasItem(hasItem(hasItem(contains(130, 130, 200, 320, 510, 75, 604, 807, 1280))))
                );
    }
}
