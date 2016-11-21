
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.net.*;
import java.sql.SQLException;


/**
 * Created by dremon on 09/11/15.
 */
public class themovieDBproject {


    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static void main(String[] args){
        String s = "";
        String api_key = "78c57dc8f346b8ae099cbd1a4c3f377e";

        for (int i = 0; i < 4; i++) {
            int peli = 600 +i;
            String film = String.valueOf(peli);
            String peticio = "https://api.themoviedb.org/3/movie/"+film+"?api_key="+api_key;

            try {
                s = getHTML(peticio);
                saveMovie(s);


            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }


        }

    }

    public static Movie saveMovie (String cadena) throws SQLException, ClassNotFoundException {

        Object obj = JSONValue.parse(cadena);
        JSONObject jsonObj = (JSONObject) obj;

        int id =  Integer.parseInt(jsonObj.get("id").toString());
        String movie = jsonObj.get("original_title").toString();
        String fecha = jsonObj.get("release_date").toString();

        Movie m = new Movie(id, movie, fecha);

    }


}
