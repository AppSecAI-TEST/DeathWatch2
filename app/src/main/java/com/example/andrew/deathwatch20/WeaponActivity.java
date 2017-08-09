package com.example.andrew.deathwatch20;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This is where the user can see the a list of weapons
 * Created by Andrew on 8/6/2017.
 */

public class WeaponActivity extends NavDrawer {

    //private Weapon weapon = new Weapon();
    private static WeaponAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weapon_view);

        final ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
        weaponList.add(new Weapon("Astrates Heavy Bolter", "2d10+14", 60, 5, "Tearing"));
        weaponList.add(new Weapon("Ceremonial Sword", "1d10+13", 0, 2, "Rending"));

        ListView listView = (ListView) findViewById(R.id.weaponList);

        //custom adapter http://www.journaldev.com/10416/android-listview-with-custom-adapter-example-tutorial
        adapter = new WeaponAdapter(weaponList, getApplicationContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Weapon weapon =  weaponList.get(position);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.weapon_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // create a new weapon
        Toast toast = Toast.makeText(getApplicationContext(),
                "Not Available", Toast.LENGTH_SHORT);
        toast.show();
        return true;
    }


}
