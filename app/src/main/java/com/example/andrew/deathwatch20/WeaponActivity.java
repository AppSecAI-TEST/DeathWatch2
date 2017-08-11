package com.example.andrew.deathwatch20;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This is where the user can see the a list of weapons
 * Created by Andrew on 8/6/2017.
 */

public class WeaponActivity extends NavDrawer {

    private WeaponList weapons;
    private static WeaponAdapter adapter;
    private TextView noWeapon;
    EditText nameInput;
    EditText damageInput;
    EditText penInput;
    EditText ammoInput;
    EditText specialInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // cancelling out side touch on dialog
        // https://stackoverflow.com/questions/4650246/how-to-cancel-an-dialog-themed-like-activity-when-touched-outside-the-window/5831214#5831214
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weapon_view);
        noWeapon = (TextView) findViewById(R.id.noWeapon);
        ListView listView = (ListView) findViewById(R.id.weaponList);
        weapons = new WeaponList();

        if(weapons.getWeaponArrayList().size() == 0) {
            noWeapon.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
        }
        else {
            noWeapon.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
            //custom adapter http://www.journaldev.com/10416/android-listview-with-custom-adapter-example-tutorial
            adapter = new WeaponAdapter(weapons.getWeaponArrayList(), getApplicationContext());
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Weapon weapon =  weapons.getWeaponArrayList().get(position);
                }
            });
        }
    }

    public void onAddWeapon(View v) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View layout = inflater.inflate(R.layout.weapon_create, null);
        dialog.setTitle("Add Weapon");
        dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                nameInput = (EditText)layout.findViewById(R.id.name);
                damageInput = (EditText)layout.findViewById(R.id.damage);
                penInput = (EditText)layout.findViewById(R.id.pen);
                ammoInput = (EditText)layout.findViewById(R.id.ammo);
                specialInput = (EditText)layout.findViewById(R.id.special);

                if(nameInput.getText().length() != 0 && damageInput.getText().length() != 0 &&
                    penInput.getText().length() != 0 && ammoInput.getText().length() != 0 &&
                        specialInput.getText().length() != 0)
                    weapons.saveWeapon(nameInput.getText().toString(),
                            damageInput.getText().toString(), penInput.getText().toString(),
                            ammoInput.getText().toString(), specialInput.getText().toString());
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Not Saved, All fields must be filled", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        dialog.setNegativeButton("Cancel", null);
        dialog.setView(layout);
        dialog.create();
        dialog.show();
    }

    public void onDeleteFile(View v) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Delete Weapons");
        dialog.setMessage("You are about to Delete ALL of your weapons. Are you sure?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                weapons.deleteFile();
            }
        });
        dialog.setNegativeButton("Cancel", null);
        dialog.create();
        dialog.show();

    }

}
