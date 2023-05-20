package summer2023;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenaiAPI {

    private static final String API_KEY = "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";

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.openai.com/v1/engines/davinci/completions");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.setRequestProperty("Content-Type", "application/json");

        String prompt = "Write a poem about a cat.";
        String completions = getResponse(connection, prompt);

        System.out.println(completions);
    }

    private static String getResponse(HttpURLConnection connection, String prompt) throws IOException {
        String body = "{\"prompt\": \"" + prompt + "\"}";

        connection.setDoOutput(true);
        try (PrintWriter writer = new PrintWriter(connection.getOutputStream())) {
            writer.print(body);
        }

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Unexpected response code: " + responseCode);
        }

        try (InputStream inputStream = connection.getInputStream()) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            return new String(bytes);
        }
    }
}