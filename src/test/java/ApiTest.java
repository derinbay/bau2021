import com.bau.test.models.Movie;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasKey;

public class ApiTest {

    @Test
    public void shouldValidateTitle() {
        String keyword = "the matrix";

        Movie movie = when()
                .get("http://www.omdbapi.com/?apikey=28ca4305&t=" + keyword)
                .then()
                .extract().as(Movie.class);

        Assert.assertEquals(movie.getTitle(), "The Matrix");
    }

    @Test
    public void shouldGoToImageSuccessfully() {
        String keyword = "the matrix";

        Movie movie = when()
                .get("http://www.omdbapi.com/?apikey=28ca4305&t=" + keyword)
                .then()
                .extract().as(Movie.class);

        String url = movie.getPoster();

        when()
                .get(url)
                .then()
                .statusCode(200);
    }

    @Test
    public void shouldGetPropertiesCorrectly() {
        String keyword = "the matrix";

        when()
                .get("http://www.omdbapi.com/?apikey=28ca4305&t=" + keyword)
                .then()
                .assertThat()
                .body("$", hasKey("Title"))
                .body("$", hasKey("Genre"))
                .body("$", hasKey("Director"))
                .extract()
                .response();
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
