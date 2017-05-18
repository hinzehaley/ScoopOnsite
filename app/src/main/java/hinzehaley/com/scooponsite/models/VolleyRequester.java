package hinzehaley.com.scooponsite.models;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import hinzehaley.com.scooponsite.pojo.Info;

/**
 * Created by haleyhinze on 5/18/17.
 * Singleton pattern to create only one instance
 */

public class VolleyRequester {
    static RequestQueue queue = null;

    private static VolleyRequester requester;

    public static VolleyRequester getInstance(){
        if(requester == null){
            requester = new VolleyRequester();
        }
        return requester;
    }

    private VolleyRequester(){

    }

    /**
     * Requests the Json data
     * @param context
     * @param listener
     */

    public void requestInfo(final Context context, final InfoRetrievedListener listener) {

        String urlPath = "https://api.takescoop.com/system/info";
        // Instantiate the RequestQueue.
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
        }

        // Request a JSON object response from the provided URL. Passes reponse into listener
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, urlPath, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String jsonString = response.toString();
                        Info info = new Gson().fromJson(jsonString, Info.class);
                        listener.infoRetrieved(info);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                listener.volleyError(error);
            }
        });
        queue.add(stringRequest);
    }
}
