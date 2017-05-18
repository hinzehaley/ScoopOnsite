package hinzehaley.com.scooponsite.dialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

import hinzehaley.com.scooponsite.R;

/**
 * Created by haleyhinze on 5/18/17.
 */

public class DialogManager {

    /**
     * Shows a dialog telling the user to connect to a network
     */
    public static void showNetworkNotConnectedDialog(Context context){
        showBasicDialog(context.getString(R.string.not_connected), context.getString(R.string.network), context);
    }

    /**
     * Shows a basic dialog with the given message and title. When ok button is clicked,
     * dismisses dialog
     * @param message
     * @param title
     * @param context
     */
    private static void showBasicDialog(String message, String title, Context context){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, context.getString(R.string.ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public static void showVolleyErrorDialog(VolleyError error, Context context){
        if(error instanceof NetworkError){
            showBasicDialog(context.getString(R.string.network_error), context.getString(R.string.request_error), context);
        }else if (error instanceof NoConnectionError){
            showBasicDialog(context.getString(R.string.no_connection), context.getString(R.string.request_error), context);
        }else if (error instanceof ParseError){
            showBasicDialog(context.getString(R.string.parse_error), context.getString(R.string.request_error), context);
        }else if (error instanceof ServerError){
            showBasicDialog(context.getString(R.string.server_error), context.getString(R.string.request_error), context);
        }else if (error instanceof TimeoutError){
            showBasicDialog(context.getString(R.string.timeout_error), context.getString(R.string.request_error), context);
        }else{
            showBasicDialog(context.getString(R.string.generic_error) + " " + error.getMessage(), context.getString(R.string.request_error), context);
        }
    }

}
