package com.example.andrew.deathwatch20;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Controls the weapon list
 *
 * Created by Andrew on 8/8/2017.
 */

public class WeaponList {

    private static WeaponList instance = null;
    private ArrayList<Weapon> weaponArrayList = new ArrayList<Weapon>();
    private String FILE_NAME = "DWW";

    /**
     * SKILLS CONSTRUCTOR
     * Checks for a storage file for the array of skills or creates a new one
     */
    WeaponList() {
        // create new file or get exsiting file from storage
        if (fileExists(FILE_NAME)) {
            readFile();
        } else {
            createNewFile();
        }
    }

    /**
     * Creates a single instance of the SKILLS class
     * @return instance
     */
    public static WeaponList getInstance() {
        if(instance == null) {
            instance = new WeaponList();
        }
        return instance;
    }

    /**
     * Checks to see if there is already a local file
     * @param fname name of file
     * @return boolean
     */
    public boolean fileExists(String fname){
        File file = MyApplication.getAppContext().getFileStreamPath(fname);
        Log.i("File Path: ", file.toString());
        return file.exists();
    }

    /**
     * Creates a new file
     */
    private void createNewFile(){
        File file = new File(MyApplication.getAppContext().getFilesDir(), FILE_NAME);
    }

    private void readFile(){
        try {
            FileInputStream fis = MyApplication.getAppContext().openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            String readLine;
            while ((readLine = bufferedReader.readLine()) != null){
                Log.i("Reading: ", readLine);
                String[] params = readLine.split(",");
                if(params.length == 5)
                    weaponArrayList.add(new Weapon(params[0], params[1], params[2],
                            params[3], params[4]));
                else {
                    Log.e("ERROR: ", "New Weapon, Too Many or Few Values: " + params.length);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Weapon> getWeaponArrayList() {
        return weaponArrayList;
    }

    public void saveWeapon(String name, String damage, String pen,
                           String ammo, String special) {
        weaponArrayList.add(new Weapon(name, damage, ammo, pen, special));
        try {
            FileOutputStream fos =
                    MyApplication.getAppContext().openFileOutput(FILE_NAME, Context.MODE_APPEND);
            String line = name + "," + damage + "," + ammo + "," + pen + "," + special + "\n\r";
            fos.write(line.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile() {
        File file = new File(MyApplication.getAppContext().getFilesDir(), FILE_NAME);
        file.delete();
    }
}
