package com.example.andrew.deathwatch20;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 *
 * Created by Andrew on 6/7/2016.
 */
public class SkillAdapter extends BaseAdapter {

    private Activity mContext;
    Skills skills = Skills.getInstance();
    // references skills
    private String[] mSkillIds = {
            "WS", "BS","S", "T", "A", "I", "P", "WP", "F"
    };

    public SkillAdapter(Activity c) {
        mContext = c;
    }

    public int getCount() {
        return mSkillIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new TextView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout block;
        TextView title = new TextView(mContext);
        TextView number = new TextView(mContext);

        if(convertView != null) {
            Log.i("convertView", convertView.toString());
        }

        if (convertView == null) {
            Log.i("Position (IF): ", Integer.toString(position) + " " + mSkillIds[position]);
            // if it's not recycled, initialize some attributes
            block = new LinearLayout(mContext);

            block.setMinimumHeight(BasicSkillsActivity.height/3);
            block.setOrientation(LinearLayout.VERTICAL);
            block.setBackgroundColor(Color.rgb(224,224,224));

        } else {
            Log.i("Position (ELSE): ", Integer.toString(position) + " " + mSkillIds[position]);
            block = (LinearLayout) convertView;
            block.removeAllViews();
        }

        //textview TITLE
        LinearLayout.LayoutParams tParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT, 30f);
        tParams.gravity = Gravity.CENTER_HORIZONTAL;
        title.setTextColor(Color.BLACK);
        title.setTextSize(40);
        title.setLayoutParams(tParams);

        //textview NUMBER
        LinearLayout.LayoutParams nParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT, 70f);
        nParams.gravity = Gravity.CENTER_HORIZONTAL;
        number.setTextColor(Color.BLACK);
        number.setTextSize(70);
        number.setLayoutParams(nParams);

        //add the textviews
        block.addView(title);
        block.addView(number);

        Log.i("Position (OUT): ", Integer.toString(position) + " " + mSkillIds[position]);
        title.setText(mSkillIds[position]);
        Log.i("Title: ", (String) title.getText());
        number.setText(Integer.toString(skills.skillList[position]));

        return block;
    }
}

