package com.example.jamesjohnson.morph_view.widgets;

import android.content.Context;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.Log;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jamesjohnson on 19/06/2018.
 */

public class RadioButtonWidget extends AppCompatRadioButton implements NativeInputWidget {

    private WebView webView;
    private String uid;

    public RadioButtonWidget(Context context, final WebView webView) {
        super(context);

        this.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                webView.loadUrl("javascript:dispatchOnChange('" + uid + ", " + isChecked + "');");
            }
        });
    }

    public void update(JSONObject description) {
        try {

            Log.d("RadioButton", "Got description " + description.toString());
            String text = description.getString("text");
            String _checked  = description.getString("checked");
            Boolean checked = Boolean.parseBoolean(_checked);

            Log.d("RadioButton", "Got new text " + text);
            this.setText(text);
            this.setChecked(checked);
        } catch (JSONException e) {
            Log.d("RadioButton", "Error Reading Description " + e);
        }
    }

    public void setUid(String _uid) {
        uid = _uid;
    }

    public void setText(String text) {
        Log.d("Set Text", text);
        super.setText(text);
    }

    public void setStyles(JSONObject styles) {
        Log.d("RadioButton", "SetStyles" + styles.length());
    }

    /**
     * Created by jamesjohnson on 21/06/2018.
     */

    public static class RadioGroupWidget extends RadioGroup implements NativeWidget {

        public RadioGroupWidget(Context context) {
            super(context);
        }

        public void setUid(String uid) {

        }

        public void update(JSONObject description) {

        }

        public void setStyles(JSONObject styles) {
            Log.d("RadioGroupWidget", "SetStyles" + styles.length());
        }
    }
}
