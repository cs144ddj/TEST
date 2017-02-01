package com.example.darre.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by darre on 01/02/2017.
 */

public class CustomAdapter extends BaseAdapter{


        private Context context;
        private List<String> listItem;
        private LayoutInflater layoutInflater;
        SharedPreferences.Editor editor;

        static class ViewHolder {
            TextView textView2;
            CheckBox cB;
        }


        CustomAdapter(Context context, List<String> listItem) {
            this.context = context;
            this.listItem = listItem;
        }

        //for the checkbox
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        SharedPreferences sharedPrefs = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);


        if (convertView == null) {

            viewHolder = new ViewHolder();
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.search_main, parent, false);
            viewHolder.textView2 = (TextView) convertView.findViewById(R.id.list_item);
            viewHolder.cB = (CheckBox)convertView.findViewById(R.id.chkBox);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // viewHolder.textView2.setText(listItem.get(position));
        //return convertView;

        editor = sharedPrefs.edit();

        viewHolder.textView2.setText(listItem.get(position));

        viewHolder.cB.setChecked(sharedPrefs.getBoolean("CheckValue"+position, false));
        viewHolder.cB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("CheckValue"+ position, isChecked);
                editor.commit();
            }});
        return convertView;

    }



    @Override
    public int getCount() {

        return listItem.size();
    }

    @Override
    public Object getItem(int position) {

        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }






}





