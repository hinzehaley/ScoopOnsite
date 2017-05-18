package hinzehaley.com.scooponsite.models;

import com.android.volley.VolleyError;

import hinzehaley.com.scooponsite.pojo.Info;

/**
 * Created by haleyhinze on 5/18/17.
 */

public interface InfoRetrievedListener {

    void infoRetrieved(Info info);

    void volleyError(VolleyError error);
}
