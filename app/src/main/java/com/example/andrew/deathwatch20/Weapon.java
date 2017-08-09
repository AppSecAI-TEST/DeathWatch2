package com.example.andrew.deathwatch20;

/**
 * Holds weapon info and function
 * Created by Andrew on 8/6/2017.
 */

public class Weapon {

    private String name;
    private String damage;
    private int ammo;
    private int pen;
    private String effect;

    Weapon() {
        name = "Astrates Heavy Bolter";
        damage = "2d10+14";
        ammo = 60;
        pen = 5;
        effect = "Tearing";
    }
    // Todo: able to create grenades, melee, and bolters weapons
    Weapon(String name, String damage, int ammo, int pen, String effect){
        setName(name);
        setDamage(damage);
        setAmmo(ammo);
        setPen(pen);
        setEffect(effect);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDamage() {
        return "Damage: " + damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getAmmo() {
        if(ammo != 0)
            return "Ammo: " + Integer.toString(ammo);
        else
            return "Ammo: N/A";
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public String getPen() {
        return "Pen: " + Integer.toString(pen);
    }

    public void setPen(int pen) {
        this.pen = pen;
    }

    public String getEffect() {
        return "Effect: " + effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    // private String FILE_NAME = "DWW";

    public String toString() {
        return name + "\nDamage: " + damage + "\nPen: " + pen + "   Ammo: "
                + ammo + "\nEffect: " + effect;
    }

}
