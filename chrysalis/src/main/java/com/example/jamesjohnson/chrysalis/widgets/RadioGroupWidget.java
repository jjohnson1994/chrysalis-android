package com.example.jamesjohnson.chrysalis.widgets;

import android.content.Context;
import android.util.Log;
import android.widget.ScrollView;

import org.json.JSONObject;

/**
 * Created by jamesjohnson on 21/06/2018.
 */

public class ScrollViewWidget extends ScrollView implements NativeWidget {

    public ScrollViewWidget(Context context) {
        super(context);
    }

    public void setUid(String uid) {

    }

    public void update(JSONObject description) {

    }

    public void setStyles(JSONObject styles) {
        Log.d("LinearLayoutWidget", "SetStyles" + styles.length());
    }
}