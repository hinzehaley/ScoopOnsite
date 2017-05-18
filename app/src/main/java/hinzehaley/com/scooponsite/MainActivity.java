package hinzehaley.com.scooponsite;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.volley.VolleyError;

import hinzehaley.com.scooponsite.dialogs.DialogManager;
import hinzehaley.com.scooponsite.models.InfoRetrievedListener;
import hinzehaley.com.scooponsite.models.VolleyRequester;
import hinzehaley.com.scooponsite.pojo.Info;

public class MainActivity extends AppCompatActivity implements InfoRetrievedListener {

    Info info;
    TextView txtNewVersionAvailable;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNewVersionAvailable = (TextView) findViewById(R.id.txt_data_new_version_available);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        if(networkConnected()){
            requestItems();
        }else{
            DialogManager.showNetworkNotConnectedDialog(this);
        }

    }

    /**
     * Requests info using VolleyRequester. Shows a progress bar
     */
    private void requestItems(){
        progressBar.setVisibility(View.VISIBLE);
        txtNewVersionAvailable.setVisibility(View.GONE);
        VolleyRequester volleyRequester = VolleyRequester.getInstance();
        volleyRequester.requestInfo(this, this);
    }

    /**
     * Checks for a network connection
     * @return true if connected, otherwise false
     */
    private boolean networkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    /**
     * Called by VolleyRequester when new info is retrieved
     * @param info
     */
    @Override
    public void infoRetrieved(Info info) {
        progressBar.setVisibility(View.GONE);
        txtNewVersionAvailable.setVisibility(View.VISIBLE);
        this.info = info;
        updateView();
    }

    /**
     * Called by VolleyRequester when there is an error retrieving info
     * @param error
     */
    @Override
    public void volleyError(VolleyError error) {
        progressBar.setVisibility(View.GONE);
        DialogManager.showVolleyErrorDialog(error, this);
    }

    /**
     * Updates view with new information from volley request
     */
    private void updateView(){
        if(info != null){
            String text = info.getData().getNewVersion().isAvailable() + "";
            txtNewVersionAvailable.setText(text);
        }
    }
}
