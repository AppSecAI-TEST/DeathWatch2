package com.example.andrew.deathwatch20;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 *
 * Created by Andrew on 6/5/2016.
 */
public class BasicSkillsActivity extends NavDrawer {

    private GridView gridview;
    public static int height;   // gives height to SkillAdapter views

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skill_view);

        //createActivityView() This is from the NavDrawer

        gridview = (GridView) findViewById(R.id.skillGrid);
        gridview.setAdapter(new SkillAdapter(this));

        height = Resources.getSystem().getDisplayMetrics().heightPixels - 56;


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Log.i("Skill Block::", "Skill opening");
                Intent intent = new Intent(BasicSkillsActivity.this, EditSkillActivity.class);
                intent.putExtra("p", Integer.toString(position));
                Log.i("BasicSkillsActivity:", "Position: " + position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        gridview = (GridView) findViewById(R.id.skillGrid);
        gridview.setAdapter(new SkillAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Log.i("Skill Block::", "Skill opening");
                Intent intent = new Intent(BasicSkillsActivity.this, EditSkillActivity.class);
                intent.putExtra("p", Integer.toString(position));
                Log.i("BasicSkillsActivity:", "Position: " + position);
                startActivity(intent);
            }
        });

    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
