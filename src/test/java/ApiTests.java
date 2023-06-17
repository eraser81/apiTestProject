import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import org.apache.http.client.fluent.Executor;

public class ApiTests {

    String baseUrl = "https://bandcamp.com/api/discover/3/";

    @Test
    void successfulGettingAlbumsData() throws IOException {
        String response = Executor.newInstance().execute(Request.Get(baseUrl + "get_web?g=metal&s=top&p=1&gn=0&f=all&w=0")).returnContent().asString();
        JsonElement parsed = new JsonParser().parse(response);
        JsonElement items = parsed.getAsJsonObject().get("items");
        Assertions.assertTrue(items.isJsonArray());
        Assertions.assertEquals(48, items.getAsJsonArray().size());
    }

    @Test
    void unsuccessfulGettingAlbumData() throws IOException {
        HttpResponse response = Executor.newInstance().execute(Request.Get(baseUrl + "get_web?g=metal&s=top&p=*-1")).returnResponse();
        Assertions.assertEquals(500, response.getStatusLine().getStatusCode());
    }
}
