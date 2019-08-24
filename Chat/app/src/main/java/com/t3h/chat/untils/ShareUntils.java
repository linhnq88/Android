package com.t3h.chat.untils;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUntils {
    private SharedPreferences share;
    public ShareUntils (Context context){
        this.share = context.getSharedPreferences("ShareUltls",context.MODE_PRIVATE);

    }
    public void put(){

    }
}
