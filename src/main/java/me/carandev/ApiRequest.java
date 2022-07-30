package me.carandev;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * ApiRequest
 */
public class ApiRequest {

  private URL apiUrl;

  public JSONArray getPokemons() throws IOException {
    apiUrl = new URL("https://pokeapi.co/api/v2/pokemon");
    HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
    StringBuilder stringData = new StringBuilder();
    connection.setRequestMethod("GET");
    connection.connect();

    int reponseCode = connection.getResponseCode();
    if (reponseCode == 200) {
      Scanner scanner = new Scanner(apiUrl.openStream());

      while (scanner.hasNext()) {
        stringData.append(scanner.nextLine());
      }

      scanner.close();
    }

    JSONObject dataResults = new JSONObject(stringData.toString());

    return new JSONArray(dataResults.getJSONArray("results"));
  }

  public JSONObject getPokemon(String url) throws IOException {
    apiUrl = new URL(url);
    HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
    StringBuilder stringData = new StringBuilder();
    connection.setRequestMethod("GET");
    connection.connect();

    int reponseCode = connection.getResponseCode();
    if (reponseCode == 200) {
      Scanner scanner = new Scanner(apiUrl.openStream());

      while (scanner.hasNext()) {
        stringData.append(scanner.nextLine());
      }

      scanner.close();
    }

    return new JSONObject(stringData.toString());
  }
}
