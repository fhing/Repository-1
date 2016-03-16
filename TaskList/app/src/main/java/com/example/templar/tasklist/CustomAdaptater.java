package com.example.templar.tasklist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Templar on 09/03/2016.
 */
public class CustomAdaptater extends ArrayAdapter<c1>{
    ArrayList<c1> c;
    Context context;
    public CustomAdaptater(Context context, ArrayList<c1> cc) {
        super(context,R.layout.list,cc);
        this.context=context;
        this.c=cc;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        c1 c1 = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list,parent,false);

        TextView name = (TextView) convertView.findViewById(R.id.tv_msg);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox);

        name.setText(c.get(position).getName());
        c1.setChecked(cb.isChecked());
        cb.setChecked(c1.getChecked());
        return convertView;
    }
}