package com.example.andrew.deathwatch20;

/**
 * Holds weapon info and function
 * Created by Andrew on 8/6/2017.
 */

public class Weapon {

    private String name;
    private String damage;
    private String ammo;
    private String pen;
    private String special;

    Weapon() {
        name = "Astrates Heavy Bolter";
        damage = "2d10+14";
        ammo = "60";
        pen = "5";
        special = "Tearing";
    }
    // Todo: able to create grenades, melee, and bolters weapons
    Weapon(String name, String damage, String ammo, String pen, String effect){
        setName(name);
        setDamage(damage);
        setAmmo(ammo);
        setPen(pen);
        setSpecial(effect);
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
        if(Integer.parseInt(ammo) != 0)
            return "Ammo: " + ammo;
        else
            return "Ammo: N/A";
    }

    public void setAmmo(String ammo) {
        this.ammo = ammo;
    }

    public String getPen() {
        return "Pen: " + pen;
    }

    public void setPen(String pen) {
        this.pen = pen;
    }

    public String getSpecial() {
        return "Effect: " + special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    // private String FILE_NAME = "DWW";

    public String toString() {
        return name + "\nDamage: " + damage + "\nPen: " + pen + "   Ammo: "
                + ammo + "\nEffect: " + special;
    }

}
