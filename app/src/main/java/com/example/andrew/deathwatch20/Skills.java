package com.example.andrew.deathwatch20;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
    private String fileName = "dwSL";
    private FileOutputStream outputStream;

    /**
     * SKILLS CONSTRUCTOR
     * Checks for a storage file for the array of skills or creates a new one
     */
    private Skills() {
        // create new file or get exsiting file from storage
        if (fileExists(fileName)) {
                //open and read into skillList
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
        //File file = MyApplication.getAppContext().getFileStreamPath(fname);
        return false;//file.exists();
    }

    private void createNewFile(){
        skillList = new Integer[]{31, 31, 31, 31, 31, 31, 31, 31, 31};
        //File file = new File(MyApplication.getAppContext().getFilesDir(), fileName);

//        try {
//            outputStream = openFileOutput(fileName, MyApplication.getAppContext().MODE_PRIVATE);
//            for(int value : skillList){
//                outputStream.write(value.getBytes());
//            }
//
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     *
     * @param position in the array
     * @param value the new value to be inserted into the position of the array
     */
    public void saveSkill(int position, int value){
        Log.i("Skills: ", "New Value: " + Integer.toString(value));
        this.skillList[position] = value;
        //saveSkillSet();

    }

    /**
     *
     */
//    private void saveSkillSet(){
//        // save new array to locale storage
//        FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
//        fos.write(skillList.);
//        fos.close();
//    }

}
