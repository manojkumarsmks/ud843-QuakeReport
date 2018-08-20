package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<EarthQuake> {

    private Context context;
    private List<EarthQuake> earthQuakesList;

    public CustomAdapter(@NonNull Context context, List<EarthQuake> earthQuakes) {
        super(context,0, earthQuakes);
        this.context = context;
        this.earthQuakesList = earthQuakes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.layout_unit,parent,false);

        EarthQuake tempEarthQuake = earthQuakesList.get(position);

        TextView magnitude = (TextView)listItem.findViewById(R.id.magnitude);
        magnitude.setText(tempEarthQuake.magnitude);

        TextView location = (TextView)listItem.findViewById(R.id.location);
        location.setText(tempEarthQuake.location);

        TextView date = (TextView)listItem.findViewById(R.id.date);
        date.setText(tempEarthQuake.date);

        return listItem;

    }
}
