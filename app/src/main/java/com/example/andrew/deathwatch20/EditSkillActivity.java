package com.example.andrew.deathwatch20;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *
 * Created by Andrew on 6/10/2016.
 */
public class EditSkillActivity extends NavDrawer {

    TextView textTitle;
    TextView textNum;
    private int num;
    int position;
    Skills skills = Skills.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_view);

        //createActivityView();

        Bundle extras = getIntent().getExtras();
        position = Integer.valueOf(extras.getString("p"));
        Log.i("EditActivity:", "Position: " + position);


        textTitle = (TextView) findViewById(R.id.titleView);
        textNum = (TextView) findViewById(R.id.numView);
        Button bAdd = (Button) findViewById(R.id.bPlus);
        Button bSubtract = (Button) findViewById(R.id.bSubtract);
        Button bSave = (Button) findViewById(R.id.bSave);

        num = skills.skillList[position];
        textNum.setText(Integer.toString(num));
        textTitle.setText(skills.skillTitles[position]);

        assert bAdd != null;
        bAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if(num < 99){
                    num++;
                    textNum.setText(Integer.toString(num));
                }
            }
        });

        assert bSubtract != null;
        bSubtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if(num > 31) {
                    num--;
                    textNum.setText(Integer.toString(num));
                }
            }
        });

        assert bSave != null;
        bSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                skills.saveSkill(position, num);
                finish();
            }
        });
    }
}
