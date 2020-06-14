package com.myapp.blooddonarfinder;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class DonarLists extends ArrayAdapter {
    private Activity context;
    private List<Donar> DonarList;
    public DonarLists(Activity context,List<Donar> DonarList){
        super(context, R.layout.list_layout,DonarList);
        this.context=context;
        this.DonarList=DonarList;

    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View ListViewItem= inflater.inflate(R.layout.list_layout, null, true);
        TextView textViewname=(TextView) ListViewItem.findViewById(R.id.textViewname);
        TextView textViewaddress=(TextView) ListViewItem.findViewById(R.id.textViewAddress);
        TextView textViewcontactno=(TextView) ListViewItem.findViewById(R.id.textViewcontactno);
        TextView textViewage=(TextView) ListViewItem.findViewById(R.id.textViewage);
        TextView textViewbloodgrp=(TextView) ListViewItem.findViewById(R.id.textViewbloodgrp);
        TextView textViewDate=(TextView) ListViewItem.findViewById(R.id.textViewDate);

        Donar donar=DonarList.get(position);
        textViewname.setText(donar.getFullname());
        textViewaddress.setText(donar.getAddress());
        textViewcontactno.setText(donar.getContactno());
        textViewage.setText(donar.getAge());
        textViewbloodgrp.setText(donar.getBloodgroup());
        textViewDate.setText(donar.getDate());
        return ListViewItem;
    }
}
