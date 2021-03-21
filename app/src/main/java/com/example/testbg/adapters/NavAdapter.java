package com.example.testbg.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testbg.R;
import com.example.testbg.UI.NavModel;

import java.util.ArrayList;

public class NavAdapter extends ArrayAdapter<NavModel>  {
    public NavAdapter(@NonNull Context context, ArrayList<NavModel> navModelArrayList) {
        super(context, 0, navModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }
        NavModel navModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.navText);
        ImageView courseIV = listitemView.findViewById(R.id.navImg);
        courseTV.setText(navModel.getCourse_name());
        courseIV.setImageResource(navModel.getImgid());
        return listitemView;
    }

}

//        if (view == mRegister) {
//                Intent intent = new Intent(MainActivity.this, TechNews.class);
//        startActivity(intent);