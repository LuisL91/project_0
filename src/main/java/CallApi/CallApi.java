package CallApi;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CallApi {
    public String url_;
    public JSONArray json_content;

    public CallApi(String link) {

         url_ = link;
        json_content = parser_to_json();
    }

    private JSONArray parser_to_json() {
        HttpResponse response = get_response();

        JSONParser parser = new JSONParser();
        String response_body = (String) response.body();
        JSONArray json_arr = null;
        try {
            json_arr = (JSONArray) parser.parse(response_body);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return json_arr;

    }

    public void enum_response_elements() {


        for (int i=0;i<json_content.size();++i) {
            System.out.println("element" + " " + i);

            System.out.println(json_content.get(i));
        }

    }

    public String get_apicall_param(int index,String param) {

       JSONObject arr_element = (JSONObject) json_content.get(index);
       System.out.println(arr_element.get(param).getClass());
       String param_content;

       param_content = arr_element.get(param).toString();
       return param_content;
    }


    private HttpResponse get_response() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;

        try {
           response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;

    }
}
