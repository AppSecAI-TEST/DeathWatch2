package com.example.andrew.deathwatch20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Custom ArrayAdapter in order to display the Weapon list correctly
 *
 * Created by Andrew on 8/7/2017.
 */

public class WeaponAdapter extends ArrayAdapter<Weapon> implements View.OnClickListener {

    private ArrayList<Weapon> dataSet;
    Context mContext;
    private int lastPosition = -1;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtDamage;
        TextView txtAmmo;
        TextView txtPen;
        TextView txtEffect;
    }

    public WeaponAdapter(ArrayList<Weapon> data, Context context) {
        super(context, R.layout.weapon_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Weapon weapon = (Weapon)object;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get data item
        Weapon weapon = getItem(position);

        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.weapon_item, parent, false);
            viewHolder.txtName =    (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtDamage =  (TextView) convertView.findViewById(R.id.damage);
            viewHolder.txtAmmo =    (TextView) convertView.findViewById(R.id.ammo);
            viewHolder.txtPen =     (TextView) convertView.findViewById(R.id.pen);
            viewHolder.txtEffect =  (TextView) convertView.findViewById(R.id.special);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        viewHolder.txtName.setText(weapon.getName());
        viewHolder.txtDamage.setText(weapon.getDamage());
        viewHolder.txtAmmo.setText(weapon.getAmmo());
        viewHolder.txtPen.setText(weapon.getPen());
        viewHolder.txtEffect.setText(weapon.getSpecial());

        return convertView;
    }


}
