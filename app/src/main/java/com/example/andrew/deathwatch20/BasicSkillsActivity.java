package com.example.andrew.deathwatch20;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 *
 * Created by Andrew on 6/5/2016.
 */
public class BasicSkillsActivity extends NavDrawer {

    public static int width;
    public static int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skill_view);

        createActivityView();

        GridView gridview = (GridView) findViewById(R.id.skillGrid);
        gridview.setAdapter(new SkillAdapter(this));

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        width = metrics.widthPixels;
        //the subtraction avoids overlap with toolbar
        height = metrics.heightPixels - 170;


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
        GridView gridview = (GridView) findViewById(R.id.skillGrid);
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

}
