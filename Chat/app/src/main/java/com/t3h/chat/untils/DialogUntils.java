package com.t3h.chat.untils;

import android.app.ProgressDialog;
import android.content.Context;

public class DialogUntils {
    private static ProgressDialog dialog;

    public static void showProgress(Context context){
        dismissProgress();
        dialog = new ProgressDialog(context);
        dialog.setMessage("Loading...");
        dialog.show();

    }

    public static void dismissProgress(){
        if (dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }
    }
}
