import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class ApiTest {

    @Test
    public void firstTest() {
        String keyword = "the matrix";
        Response response = when()
                .get("http://www.omdbapi.com/?apikey=28ca4305&t=" + keyword)
                .then()
                .extract()
                .response();

        String title = response.jsonPath().get("Title");
        String year = response.jsonPath().get("Year");
        String runtime = response.jsonPath().get("Runtime");
        String ratings = response.jsonPath().get("Ratings[0].Source");

        System.out.println("Title: " + title);
        System.out.println("Year: " + year);
        System.out.println("Runtime: " + runtime);
        System.out.println("Ratings 0 Source: " + ratings);
    }

    @Test
    public void secondTest() {
        Response response = when()
                .get("https://public-mdc.trendyol.com/discovery-web-websfxproductrecommendation-santral/api/v1/product/81492615/recommendation?size=20&version=2&page=0&stamp=TypeA&storefrontId=1&culture=tr-TR")
                .then()
                .extract()
                .response();

        float value = response.jsonPath().get("result.content[0].price.sellingPrice.value");
        Assert.assertEquals(String.format("%.2f", value), "68.94");
    }
}
