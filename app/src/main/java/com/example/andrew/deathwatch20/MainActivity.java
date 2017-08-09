package com.example.andrew.deathwatch20;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends NavDrawer {

    Button bBasicSkills;
    Button bArmour;
    Button bWeapons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bBasicSkills = (Button) findViewById(R.id.bSkill);
        bArmour = (Button) findViewById(R.id.bArmour);
        bWeapons = (Button) findViewById(R.id.bWeapons);

        //createActivityView();
        Skills skills = Skills.getInstance();

        bBasicSkills.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("Menu Item Pressed:", "Basic Skills opening");
                Intent intent = new Intent(MainActivity.this, BasicSkillsActivity.class);
                startActivity(intent);

            }
        });

        bArmour.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Not Available", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        bWeapons.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("Menu Item Pressed:", "Weapon Activity Opening");
                Intent intent = new Intent(MainActivity.this, WeaponActivity.class);
                startActivity(intent);
                /*Toast toast = Toast.makeText(getApplicationContext(),
                        "Not Available", Toast.LENGTH_SHORT);
                toast.show();*/

            }
        });
    }



}
