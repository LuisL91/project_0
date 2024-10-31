package Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;
import java.util.Set;
import CallApi.CallApi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {

        CallApi api = new CallApi("https://jsonplaceholder.typicode.com/users/1/albums");
        JSONArray json_array = api.json_content;
        System.out.println(json_array);
        api.enum_response_elements();
        String param_content = api.get_apicall_param(0,"id");
        System.out.println(param_content);


        /*
        Set<String> keys = ((JSONObject) json_arr.get(0)).keySet();
        int keys_number = keys.size();
        System.out.println(keys);
        System.out.println(keys_number);
        System.out.println(j);
        JSONObject id = (JSONObject)  json_arr.get(0);
        long cosa = (long) id.get("id");
        System.out.println(cosa);
        System.out.println(id.get("id").getClass()); */




    }
}