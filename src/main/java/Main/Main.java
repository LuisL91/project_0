package Main;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Scanner;

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
        //api.enum_response_elements();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Elementos de la llamada");
        api.inform_response_elements();
        System.out.println("Set de parámetros");
        api.inform_params_set();

        System.out.println("Enter element param and index:");

        // String input
        String param = myObj.nextLine();

        // Numerical input
        int index = myObj.nextInt();
        String param_content = api.get_apicall_param(index,param);
        System.out.println(param_content);



        /*Scanner scan_obj =  new Scanner(System.in);
        System.out.println("introduce el índice del elemento");
        int index = scan_obj.nextInt();
        System.out.println("introduce el parámetro");
        String param = scan_obj.nextLine();
 */

        //String param_content = api.get_apicall_param(index,param);
        //System.out.println(param_content);


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