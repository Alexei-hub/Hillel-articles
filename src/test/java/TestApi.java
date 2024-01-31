import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestApi {
    public static void main(String[] args) {
        String postUrl = "https://qauto.forstudy.space/api/cars/brands";

        try {
            // Створення об'єкту HttpClient
            HttpClient httpClient = HttpClient.newHttpClient();

            // Створення POST-запиту з JSON-тілом
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(postUrl))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();


            // Виконання POST-запиту та отримання відповіді
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


            // Отримання коду статусу та тіла відповіді
            int statusCode = response.statusCode();
            String responseBody = response.body();

            // Виведення результатів
            System.out.println("Код статусу: " + statusCode);
            System.out.println("Тіло відповіді: " + responseBody);

            JsonObject jsonObject = JsonParser.parseString(responseBody)
                    .getAsJsonObject();
            JsonArray jsonElement = jsonObject.getAsJsonArray("data");
            System.out.println(jsonElement.get(0).toString());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}