package com.example.andrew.deathwatch20;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Holds the user's skills
 * Created by Andrew on 6/10/2016.
 */
public class Skills {

    public Integer[] skillList;
    public String[] skillTitles =
            {"Weapon Skill", "Ballistic Skill", "Strength", "Toughness", "Agility",
                    "Intelligence", "Perception", "Will Power", "Fellowship" } ;
    private static Skills instance = null;
    private String FILE_NAME = "DWS";

    /**
     * SKILLS CONSTRUCTOR
     * Checks for a storage file for the array of skills or creates a new one
     */
    private Skills() {
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
    public static Skills getInstance() {
        if(instance == null) {
            instance = new Skills();
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
     * Creates a new file if there isn't one
     */
    private void createNewFile(){
        skillList = new Integer[]{31, 31, 31, 31, 31, 31, 31, 31, 31};
        File file = new File(MyApplication.getAppContext().getFilesDir(), FILE_NAME);
        saveSkillSet();
    }

    /**
     * Saves the individual skill then calls saveSkillSet()
     *
     * @param position in the array
     * @param value the new value to be inserted into the position of the array
     */
    public void saveSkill(int position, int value){
        Log.i("Skills: ", "New Value: " + Integer.toString(value));
        this.skillList[position] = value;
        saveSkillSet();

    }

    /**
     * This saves the skillList to internal storage file
     */
    private void saveSkillSet() {
        // save new array to locale storage
        try {
            FileOutputStream fos =
                    MyApplication.getAppContext().openFileOutput(FILE_NAME, Context.MODE_PRIVATE);

            for (Integer value : skillList) {
                String line = value + "\n";
                fos.write(line.getBytes());
            }

            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(){
        skillList = new Integer[9];
        try {
            FileInputStream fis = MyApplication.getAppContext().openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null){
                Log.i("Reading: ", line);
                skillList[i] = Integer.valueOf(line);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
